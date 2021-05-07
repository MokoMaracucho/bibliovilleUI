package com.oc.bibliovilleUI.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import com.oc.bibliovilleUI.entity.Utilisateur;
import com.oc.bibliovilleUI.form.FormConnexion;

@Controller
@RequestMapping(path="utilisateur")
public class UtilisateurController {

    public static final String ATT_FORM_CONNEXION 							= "formConnexion";
    public static final String ATT_LISTE_UTILISATEURS                       = "listeUtilisateurs";

    @Autowired
    private RestTemplate restTemplate;

    private static String url = "http://localhost:8080/utilisateur";

    @GetMapping("/connexion_utilisateur")
    public String connectionUtilisateur(Model model) {
        model.addAttribute(ATT_FORM_CONNEXION, new FormConnexion());
        return "connexionUtilisateur";
    }

    @GetMapping("/liste_utilisateurs")
    public String getListeUtilisateurs(Model model) {
        Utilisateur[] listeUtilisateurs = restTemplate.getForObject(url, Utilisateur[].class);
        model.addAttribute(ATT_LISTE_UTILISATEURS, Arrays.asList(listeUtilisateurs));
        return "listeUtilisateurs";
    }
}
