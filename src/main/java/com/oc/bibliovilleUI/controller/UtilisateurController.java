package com.oc.bibliovilleUI.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import com.oc.bibliovilleUI.entity.Utilisateur;

@Controller
@RequestMapping(path="utilisateur")
public class UtilisateurController {

    public static final String ATT_LISTE_UTILISATEURS                       = "listeUtilisateurs";

    @Autowired
    private RestTemplate restTemplate;

    private static String url = "http://localhost:8080/utilisateur";

    @GetMapping("/liste_utilisateurs")
    public String getListeUtilisateurs(Model model) {
        Utilisateur[] listeUtilisateurs = restTemplate.getForObject(url, Utilisateur[].class);
        model.addAttribute(ATT_LISTE_UTILISATEURS, Arrays.asList(listeUtilisateurs));
        return "listeUtilisateurs";
    }
}
