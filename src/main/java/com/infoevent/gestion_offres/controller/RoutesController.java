package com.infoevent.gestion_offres.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;
import java.util.List;

@Controller
public class RoutesController {

    // Injecter la base URL de gestion-offres depuis les propriétés
    @Value("${gestion.offres.base.url}")
    private String baseUrl;

    @GetMapping("/routes")
    public String showRoutes(Model model) {
        // Liste des actions que l'administrateur peut effectuer
        List<String> routes = Arrays.asList(
                baseUrl + "/users/home - Accéder au site",
                baseUrl + "/users/connexion - Connexion pour gérer les offres",
                baseUrl + "/users/sold-by-type - Voir les offres vendues par types d'offres"
        );

        model.addAttribute("routes", routes);
        return "index"; // Retourne le nom du template HTML index (index.html)
    }
}
