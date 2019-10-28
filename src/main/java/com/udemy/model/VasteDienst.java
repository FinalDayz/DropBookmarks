package com.udemy.model;

import io.dropwizard.validation.OneOf;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

public class VasteDienst {

    @NotNull
    private int vasteDienstId;

    @NotNull
    @Length(max=50)
    private String vasteDiendstNaam;

    @NotNull
    @Length(max=50)
    private String vasteDienstLeider;

    @NotNull
    @OneOf(value = {"Lab in", "Idee", "Lab uit"})
    private String statucKleur;

    private byte[] bijlagen;

    private byte[] afbeelding;

    private String omschrijving;

    private String logStatus;

    public int getVasteDienstId() {
        return vasteDienstId;
    }

    public void setVasteDiensId(int vasteDienstId) {
        this.vasteDienstId = vasteDienstId;
    }

    public String getVasteDiendstNaam() {
        return vasteDiendstNaam;
    }

    public void setVasteDiendstNaam(String vasteDiendstNaam) {
        this.vasteDiendstNaam = vasteDiendstNaam;
    }

    public String getVasteDienstLeider() {
        return vasteDienstLeider;
    }

    public void setVasteDienstLeider(String vasteDienstLeider) {
        this.vasteDienstLeider = vasteDienstLeider;
    }

    public String getStatucKleur() {
        return statucKleur;
    }

    public void setStatucKleur(String statucKleur) {
        this.statucKleur = statucKleur;
    }

    public byte[] getBijlagen() {
        return bijlagen;
    }

    public void setBijlagen(byte[] bijlagen) {
        this.bijlagen = bijlagen;
    }

    public byte[] getAfbeelding() {
        return afbeelding;
    }

    public void setAfbeelding(byte[] afbeelding) {
        this.afbeelding = afbeelding;
    }

    public String getOmschrijving() {
        return omschrijving;
    }

    public void setOmschrijving(String omschrijving) {
        this.omschrijving = omschrijving;
    }

    public String getLogStatus() {
        return logStatus;
    }

    public void setLogStatus(String logStatus) {
        this.logStatus = logStatus;
    }
}
