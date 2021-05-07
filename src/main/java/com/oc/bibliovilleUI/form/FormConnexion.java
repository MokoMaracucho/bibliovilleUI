package com.oc.bibliovilleUI.form;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

public class FormConnexion {

    @NotEmpty(message="Veuillez renseigner un email.")
    @Email(message="Veuillez saisir un email valide.")
    private String emailFormConnexion;

    @NotEmpty(message="Veuillez renseigner un mot-de-passe.")
    private String motPasseFormConnexion;

    public String getEmailFormConnexion() {
        return emailFormConnexion;
    }

    public void setEmailFormConnexion(String emailFormConnexion) {
        this.emailFormConnexion = emailFormConnexion;
    }

    public String getMotPasseFormConnexion() {
        return motPasseFormConnexion;
    }

    public void setMotPasseFormConnexion(String motPasseFormConnexion) {
        this.motPasseFormConnexion = motPasseFormConnexion;
    }
}
