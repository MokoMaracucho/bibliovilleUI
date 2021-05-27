package com.oc.bibliovilleUI.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.oc.bibliovilleUI.entity.Utilisateur;
import com.oc.bibliovilleUI.form.FormConnexion;

@Controller
@RequestMapping(path="utilisateur")
public class UtilisateurController {

    public static final String ATT_FORM_CONNEXION 							= "formConnexion";
    public static final String ATT_LISTE_UTILISATEURS                       = "listeUtilisateurs";
	
	public static final String ATT_SESSION_STATUT							= "sessionStatut";
	
	public static final String ATT_UTILISATEUR				 				= "utilisateur";

    @Autowired
    private RestTemplate restTemplate;

    private static String url = "http://localhost:8080/utilisateur";

    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    @GetMapping("/connexion_utilisateur")
    public String connectionUtilisateur(Model model) {
        model.addAttribute(ATT_FORM_CONNEXION, new FormConnexion());
        return "connexionUtilisateur";
    }

    @GetMapping("/selection_utilisateur_par_id")
    public String selectionUtilisateurParId(HttpServletRequest request, @RequestParam(name="idUtilisateur") Long idUtilisateur, Model model) {
    	Utilisateur utilisateur = restTemplate.getForObject(url + "/" + idUtilisateur, Utilisateur.class);
    	model.addAttribute(ATT_UTILISATEUR, utilisateur);
    	return "afficherUtilisateur";
    }
    
//    @PostMapping("/traitement_formulaire_connexion")
//    public String traitementConnexionUtilisateur(HttpServletRequest request, @Valid @ModelAttribute("formConnexion") FormConnexion formConnexion, BindingResult bindingResult, Model model) {
//    	HttpSession session = request.getSession();
//    	if(bindingResult.hasErrors()) {
//        	session.setAttribute(ATT_SESSION_STATUT, false);
//	        return "connexionUtilisateur";
//		} else {
//			Utilisateur utilisateur = restTemplate.ge
//			//Utilisateur utilisateur = utilisateurService.selectionUtilisateurParEmail(formConnexion.getEmailFormConnexion());
//        	session.setAttribute(ATT_SESSION_STATUT, true);
//			session.setAttribute(ATT_UTILISATEUR, utilisateur);
//			model.addAttribute(ATT_UTILISATEUR, utilisateur);
//	        return "redirect:/livre/listeLivres";
//		}
//    }

    @GetMapping("/liste_utilisateurs")
    public String getListeUtilisateurs(Model model) {
        Utilisateur[] listeUtilisateurs = restTemplate.getForObject(url, Utilisateur[].class);
        model.addAttribute(ATT_LISTE_UTILISATEURS, Arrays.asList(listeUtilisateurs));
        return "listeUtilisateurs";
    }
}
