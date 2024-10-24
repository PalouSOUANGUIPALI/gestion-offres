package com.infoevent.gestion_offres.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/routes") // Point d'entrée unique pour les routes
public class RoutesController {

    @Value("${olympic.tickets.base.url}")
    private String olympicTicketsBaseUrl;

    @GetMapping
    public String showRoutes(Model model) {
        // Liste des actions que l'administrateur peut effectuer
        List<String> routes = Arrays.asList(
                "/home - Accéder au site",
                "/connexion - Connexion pour gérer les offres",
                "/ventes-par-types-offres - Voir les offres vendues par types d'offres"
        );

        model.addAttribute("routes", routes);
        return "index"; // Retourne le nom du template HTML index (index.html)
    }

    // Redirections vers olympic-tickets
    @GetMapping("/Accueil")
    public String redirectToHome() {
        return "redirect:" + olympicTicketsBaseUrl + "/users/home";
    }

    @GetMapping("/inscription")
    public String redirectToInscription() {
        return "redirect:" + olympicTicketsBaseUrl + "/users/inscription";
    }

    @GetMapping("/validation")
    public String redirectToValidation() {
        return "redirect:" + olympicTicketsBaseUrl + "/users/validation";
    }

    @GetMapping("/connexion")
    public String redirectToConnexion() {
        return "redirect:" + olympicTicketsBaseUrl + "/users/login";
    }

    @GetMapping("/ventes-par-types-offres")
    public String redirectToSoldByType() {
        return "redirect:" + olympicTicketsBaseUrl + "/offers/sold-by-type";
    }
}
