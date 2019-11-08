package com.udemy.model;

import io.dropwizard.validation.OneOf;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import java.security.Principal;

/**
 * @author Stefan
 */
public class ExperimentDetails {

    @NotNull
    private int experimentId;

    @NotNull
    @Length(max=150)
    private String netwerk;

    private String status;

    @NotNull
    @OneOf(value = {"Groen", "Rood", "Orange"})
    private String statusKleur;

    @Length(max=150)
    private String kostenInovatie;

    @Length(max=150)
    private String kostenAnders;

    @Length(max=150)
    private String doorlooptijd;

    private String beschrijving;

    @Length(max=150)
    private String voortgang;

    private boolean archief = false;

    @OneOf(value = {"HoF", "GY"})
    private String archiefType;


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

    public int getExperimentId() {
        return experimentId;
    }

    public void setExperimentId(int experimentId) {
        this.experimentId = experimentId;
    }

    public String getStatusKleur() {
        return statusKleur;
    }

    public void setStatusKleur(String statusKleur) {
        this.statusKleur = statusKleur;
    }

    public String getKostenInovatie() {
        return kostenInovatie;
    }

    public void setKostenInovatie(String kostenInovatie) {
        this.kostenInovatie = kostenInovatie;
    }

    public String getKostenAnders() {
        return kostenAnders;
    }

    public void setKostenAnders(String kostenAnders) {
        this.kostenAnders = kostenAnders;
    }

    public String getArchiefType() {
        return archiefType;
    }

    public void setArchiefType(String archiefType) {
        this.archiefType = archiefType;
    }
}
