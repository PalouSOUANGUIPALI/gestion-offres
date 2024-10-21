package com.infoevent.gestion_offres.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/users")
public class UserController {

    @Value("${olympic.tickets.base.url}")
    private String olympicTicketsBaseUrl;


    @GetMapping("/home")
    public String showHomePage() {
        return "redirect:" + olympicTicketsBaseUrl + "/users/home";
    }

    @GetMapping("/inscription")
    public String showInscriptionPage() {
        // Redirige vers la page d'inscription de olympic-tickets
        return "redirect:" + olympicTicketsBaseUrl + "/users/inscription";
    }

    @GetMapping("/validation")
    public String showValidationPage() {
        // Redirige vers la page de validation de olympic-tickets
        return "redirect:" + olympicTicketsBaseUrl + "/users/validation";
    }

    @GetMapping("/connexion")
    public String showLoginPage() {
        // Redirige vers la page de connexion de olympic-tickets
        return "redirect:" + olympicTicketsBaseUrl + "/users/login";
    }

    // Récupération des offres vendues par types
    @GetMapping("/sold-by-type")
    public String getOffersSoldByType(){
        return "redirect:" + olympicTicketsBaseUrl + "/offers/sold-by-type";
    }

}

