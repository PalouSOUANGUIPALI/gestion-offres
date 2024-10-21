package com.infoevent.gestion_offres.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;
import java.util.List;

@Controller
public class RoutesController {

    @GetMapping("/routes")
    public String showRoutes(Model model) {
        // Liste des actions que l'administrateur peut effectuer
        List<String> routes = Arrays.asList(
                "/users/home - Acceder au site",
                "/users/connexion - Connexion pour gérer les offres",
                "/users/sold-by-type - Voir les offres vendues par types d'offres"
        );

        model.addAttribute("routes", routes);
        return "index"; // Retourne le nom du template HTML index (index.html)
    }
}

