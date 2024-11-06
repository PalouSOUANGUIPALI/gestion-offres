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
    public String olympicTicketsBaseUrl;

    @GetMapping
    public String showRoutes(Model model) {
        // Liste des actions que l'administrateur peut effectuer avec les liens directs vers olympic-tickets
        List<String> routes = Arrays.asList(
                olympicTicketsBaseUrl + "/users/home - Accéder au site",
                olympicTicketsBaseUrl + "/users/login - Connexion pour gérer les offres",
                olympicTicketsBaseUrl + "/offers/sold-by-type - Voir les offres vendues par types d'offres"
        );

        model.addAttribute("routes", routes);
        return "index"; // Retourne le nom du template HTML index (index.html)
    }

    // Ces méthodes permettent une redirection via les routes
    @GetMapping("/home")
    public String redirectToHome() {
        return "redirect:" + olympicTicketsBaseUrl + "/users/home";
    }

    @GetMapping("/connexion")
    public String redirectToConnexion() {
        return "redirect:" + olympicTicketsBaseUrl + "/users/login";
    }

    @GetMapping("/sold-by-type ")
    public String redirectToSoldByType() {
        return "redirect:" + olympicTicketsBaseUrl + "/offers/sold-by-type";
    }
}
