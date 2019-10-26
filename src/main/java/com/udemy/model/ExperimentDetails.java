package com.udemy.model;

import io.dropwizard.validation.OneOf;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import java.security.Principal;

public class ExperimentDetails implements Principal {

    @NotNull
    private int experiment_ID;

    @NotNull
    @Length(max=150)
    private String netwerk;

    private String status;

    @NotNull
    @OneOf(value = {"Groen", "Rood", "Orange"})
    private String status_kleur;

    @Length(max=150)
    private String kosten_inovatie;

    @Length(max=150)
    private String kosten_anders;

    @Length(max=150)
    private String doorlooptijd;

    private String beschrijving;

    @Length(max=150)
    private String voortgang;

    private boolean archief = false;

    @OneOf(value = {"Hof", "GY"})
    private String archief_type;

    @Override
    public String getName() {
        return null;
    }

    public int getExperiment_ID() {
        return experiment_ID;
    }

    public void setExperiment_ID(int experiment_ID) {
        this.experiment_ID = experiment_ID;
    }

    public String getNetwerk() {
        return netwerk;
    }

    public void setNetwerk(String netwerk) {
        this.netwerk = netwerk;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus_kleur() {
        return status_kleur;
    }

    public void setStatus_kleur(String status_kleur) {
        this.status_kleur = status_kleur;
    }

    public String getKosten_inovatie() {
        return kosten_inovatie;
    }

    public void setKosten_inovatie(String kosten_inovatie) {
        this.kosten_inovatie = kosten_inovatie;
    }

    public String getKosten_anders() {
        return kosten_anders;
    }

    public void setKosten_anders(String kosten_anders) {
        this.kosten_anders = kosten_anders;
    }

    public String getDoorlooptijd() {
        return doorlooptijd;
    }

    public void setDoorlooptijd(String doorlooptijd) {
        this.doorlooptijd = doorlooptijd;
    }

    public String getBeschrijving() {
        return beschrijving;
    }

    public void setBeschrijving(String beschrijving) {
        this.beschrijving = beschrijving;
    }

    public String getVoortgang() {
        return voortgang;
    }

    public void setVoortgang(String voortgang) {
        this.voortgang = voortgang;
    }

    public boolean isArchief() {
        return archief;
    }

    public void setArchief(boolean archief) {
        this.archief = archief;
    }

    public String getArchief_type() {
        return archief_type;
    }

    public void setArchief_type(String archief_type) {
        this.archief_type = archief_type;
    }
}
