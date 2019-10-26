package com.udemy.persistence;

import com.udemy.model.Experiment;
import com.udemy.model.ExperimentDetails;

import java.util.ArrayList;
import java.util.List;

public class ExperimentDetailsDAO {

    private final List<ExperimentDetails> experimentDetails;

    public ExperimentDetailsDAO() {
        experimentDetails = new ArrayList<>();

        ExperimentDetails experimentDetails1 = new ExperimentDetails();
        experimentDetails1.setArchief(false);
        experimentDetails1.setBeschrijving("Bla bla bla beschrijving blabla");
        experimentDetails1.setDoorlooptijd("Doorlooptijd hierrr");
        experimentDetails1.setExperiment_ID(0);
        experimentDetails1.setKosten_anders("Hier kosten anders");
        experimentDetails1.setKosten_inovatie("Hier kosten inovatie");
        experimentDetails1.setNetwerk("Netwerkkkkk hierrr");
        experimentDetails1.setStatus_kleur("Groen");
        experimentDetails1.setVoortgang("Vooruitgang");
        experimentDetails1.setStatus("Status hierzo");

        ExperimentDetails experimentDetails2 = new ExperimentDetails();
        experimentDetails2.setArchief(true);
        experimentDetails2.setArchief_type("HOF");
        experimentDetails2.setStatus("Experiment goed uitgevoerd");
        experimentDetails2.setBeschrijving("Dit is een mensenlijk experiment, van kinderen van 5 jaar tot volwassenen tot 95 jaar");
        experimentDetails2.setDoorlooptijd("10 jaar");
        experimentDetails2.setExperiment_ID(1);
        experimentDetails2.setKosten_anders("1000000 euro voor nieuwe organen en andere");
        experimentDetails2.setKosten_inovatie("100000 voor mnedicatie");
        experimentDetails2.setNetwerk("Europa en rusland");
        experimentDetails2.setStatus_kleur("Rood");
        experimentDetails2.setVoortgang("Het gaat slecht met de gezondheid van de deelnemers");



    }
}
