package com.infoevent.gestion_offres.controller;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class RoutesControllerTest {

    @InjectMocks
    private RoutesController routesController;

    @Mock
    private Model model;

    private AutoCloseable closeable;

    @BeforeEach
    void setUp() {
        // Initialisation des mocks et injection dans le contrôleur
        closeable = MockitoAnnotations.openMocks(this);
        routesController = new RoutesController();
        routesController.olympicTicketsBaseUrl = "http://localhost:8080";
        System.out.println("INITIALISATION : RoutesController et dépendances mockées.");
    }

    @AfterEach
    void tearDown() throws Exception {
        closeable.close();
        System.out.println("TEARDOWN :  Le test de la méthode et son néttoyage terminés avec succès.\n");
    }

    @Test
    void testShowRoutes() {
        System.out.println("TEST : testShowRoutes démarré.");

        // Étape 1 : Appeler la méthode
        String viewName = routesController.showRoutes(model);
        System.out.println("ÉTAPE 1 : Appel de showRoutes(). Vue retournée : " + viewName);

        // Étape 2 : Préparer les routes attendues
        List<String> expectedRoutes = Arrays.asList(
                "http://localhost:8080/users/home - Accéder au site",
                "http://localhost:8080/users/login - Connexion pour gérer les offres",
                "http://localhost:8080/offers/sold-by-type - Voir les offres vendues par types d'offres"
        );

        // Étape 3 : Vérifier que le modèle contient bien les routes
        verify(model).addAttribute("routes", expectedRoutes);

        // Étape 4 : Vérifier le nom de la vue retournée
        assertEquals("index", viewName);

        System.out.println("RÉSULTAT : testShowRoutes est passé avec succès.\n" +
                "Vici l'ensemble des routes disponibles depuis l'espace de gestion de l'application gestion-offres \n : "
                + expectedRoutes);
    }

    @Test
    void testRedirectToHome() {
        System.out.println("TEST : testRedirectToHome démarré.");

        // Étape 1 : Appel de la méthode
        String result = routesController.redirectToHome();
        System.out.println("ÉTAPE 1 : Redirection retournée : " + result);

        // Étape 2 : Vérification du résultat attendu
        assertEquals("redirect:http://localhost:8080/users/home", result);
        System.out.println("RÉSULTAT : testRedirectToHome est passé avec succès.\n");
    }

    @Test
    void testRedirectToConnexion() {
        System.out.println("TEST : testRedirectToConnexion démarré.");

        // Étape 1 : Appel de la méthode
        String result = routesController.redirectToConnexion();
        System.out.println("ÉTAPE 1 : Redirection retournée : " + result);

        // Étape 2 : Vérification du résultat attendu
        assertEquals("redirect:http://localhost:8080/users/login", result);
        System.out.println("RÉSULTAT : testRedirectToConnexion est passé avec succès.\n");
    }

    @Test
    void testRedirectToSoldByType() {
        System.out.println("TEST : testRedirectToSoldByType démarré.");

        // Étape 1 : Appel de la méthode
        String result = routesController.redirectToSoldByType();
        System.out.println("ÉTAPE 1 : Redirection retournée : " + result);

        // Étape 2 : Vérification du résultat attendu
        assertEquals("redirect:http://localhost:8080/offers/sold-by-type", result);
        System.out.println("RÉSULTAT : testRedirectToSoldByType est passé avec succès.\n");
    }
}
