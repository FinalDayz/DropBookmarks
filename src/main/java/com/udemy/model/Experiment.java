package com.udemy.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.security.Principal;

import io.dropwizard.validation.OneOf;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

public class Experiment implements Principal {

    @NotNull
    private int experimentId;

    @NotNull
    @Length(max=50)
    private String experiment_naam;

    @NotNull
    private String wijziging_datum;

    @NotNull
    @OneOf(value = {"Lab in", "Idee", "Lab uit"})
    private String fase;

    @NotNull
    @Length(max=50)
    private String experiment_leider;

    @Override
    @JsonIgnore
    public String getName() {
        return null;
    }

    public String getExperiment_leider() {
        return experiment_leider;
    }

    public void setExperiment_leider(String experiment_leider) {
        this.experiment_leider = experiment_leider;
    }

    public String getFase() {
        return fase;
    }

    public void setFase(String fase) {
        this.fase = fase;
    }

    public String getExperiment_naam() {
        return experiment_naam;
    }

    public void setExperiment_naam(String experiment_naam) {
        this.experiment_naam = experiment_naam;
    }

    public int getExperimentId() {
        return experimentId;
    }

    public void setExperimentId(int experimentId) {
        this.experimentId = experimentId;
    }

    public String getWijziging_datum() {
        return wijziging_datum;
    }

    public void setWijziging_datum(String wijziging_datum) {
        this.wijziging_datum = wijziging_datum;
    }

    public boolean equals(Experiment experiment) {
        return experiment.getExperimentId() == this.getExperimentId();
    }
}
