package com.infoevent.gestion_offres;



import com.infoevent.gestion_offres.controller.RoutesController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ui.Model;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class RoutesControllerTest {

    @InjectMocks
    private RoutesController routesController;

    @Mock
    private Model model;

    @Value("${olympic.tickets.base.url}")
    private String olympicTicketsBaseUrl = "http://example.com"; // Simulation de la valeur de configuration

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        routesController = new RoutesController();
        routesController.olympicTicketsBaseUrl = olympicTicketsBaseUrl;
    }

    @Test
    void testShowRoutes() {
        // When
        String viewName = routesController.showRoutes(model);

        // Then
        verify(model, times(1)).addAttribute(eq("routes"), any(List.class));
        assertEquals("index", viewName);

        // Vérification du contenu de la liste des routes ajoutée au modèle
        List<String> expectedRoutes = List.of(
                olympicTicketsBaseUrl + "/users/home - Accéder au site",
                olympicTicketsBaseUrl + "/users/login - Connexion pour gérer les offres",
                olympicTicketsBaseUrl + "/offers/sold-by-type - Voir les offres vendues par types d'offres"
        );
        verify(model).addAttribute("routes", expectedRoutes);
    }

    @Test
    void testRedirectToHome() {
        // When
        String redirectView = routesController.redirectToHome();

        // Then
        assertEquals("redirect:" + olympicTicketsBaseUrl + "/users/home", redirectView);
    }

    @Test
    void testRedirectToConnexion() {
        // When
        String redirectView = routesController.redirectToConnexion();

        // Then
        assertEquals("redirect:" + olympicTicketsBaseUrl + "/users/login", redirectView);
    }

    @Test
    void testRedirectToSoldByType() {
        // When
        String redirectView = routesController.redirectToSoldByType();

        // Then
        assertEquals("redirect:" + olympicTicketsBaseUrl + "/offers/sold-by-type", redirectView);
    }
}

