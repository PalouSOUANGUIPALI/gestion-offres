package com.infoevent.gestion_offres.integrationRouterControllerTests;

import com.infoevent.gestion_offres.controller.RoutesController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ui.Model;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class RoutesControllerTest {

    @InjectMocks
    private RoutesController routesController; // Injecte un mock de RoutesController

    @Mock
    private Model model; // Mock du modèle pour intercepter les attributs ajoutés

    @Value("${olympic.tickets.base.url}")
    //private String olympicTicketsBaseUrl = "http://example.com"; // Simule une configuration externe fictive pour des tests unitaires par exemple

    // Configuration externe de olympic-tickets avec la vraie base URL de l'API olympic-tickets pour les tests d'integration
    private String olympicTicketsBaseUrl = "https://olympic-tickets-5bd9958c659c.herokuapp.com";

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this); // Initialise les annotations Mockito
        routesController = new RoutesController(); // Initialise le Routercontrôleur
        routesController.olympicTicketsBaseUrl = olympicTicketsBaseUrl; // Configure l'URL de base de l'API ou celle simulée
    }

    @Test
    void testShowRoutes() {
        // Appel de la méthode showRoutes du contrôleur
        String viewName = routesController.showRoutes(model);

        // Vérifie que l'attribut "routes" a été ajouté au modèle une fois
        verify(model, times(1)).addAttribute(eq("routes"), any(List.class));

        // Vérifie que la vue retournée est "index"
        assertEquals("index", viewName);

        // Vérifie le contenu attendu de la liste des routes
        List<String> expectedRoutes = List.of(
                olympicTicketsBaseUrl + "/users/home - Accéder au site",
                olympicTicketsBaseUrl + "/users/login - Connexion pour gérer les offres",
                olympicTicketsBaseUrl + "/offers/sold-by-type - Voir les offres vendues par types d'offres"
        );

        // Vérifie que l'attribut "routes" contient bien la liste attendue
        verify(model).addAttribute("routes", expectedRoutes);
    }

    @Test
    void testRedirectToHome() {
        // Appel de la méthode redirectToHome du contrôleur
        String redirectView = routesController.redirectToHome();

        // Vérifie que l'URL de redirection est correcte
        assertEquals("redirect:" + olympicTicketsBaseUrl + "/users/home", redirectView);
    }

    @Test
    void testRedirectToConnexion() {
        // Appel de la méthode redirectToConnexion du contrôleur
        String redirectView = routesController.redirectToConnexion();

        // Vérifie que l'URL de redirection est correcte
        assertEquals("redirect:" + olympicTicketsBaseUrl + "/users/login", redirectView);
    }

    @Test
    void testRedirectToSoldByType() {
        // Appel de la méthode redirectToSoldByType du contrôleur
        String redirectView = routesController.redirectToSoldByType();

        // Vérifie que l'URL de redirection est correcte
        assertEquals("redirect:" + olympicTicketsBaseUrl + "/offers/sold-by-type", redirectView);
    }
}
