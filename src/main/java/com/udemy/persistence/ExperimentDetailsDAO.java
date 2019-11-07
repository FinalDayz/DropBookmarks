package com.udemy.persistence;

import com.udemy.model.Experiment;
import com.udemy.model.ExperimentDetails;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;

import java.util.ArrayList;
import java.util.List;

public interface ExperimentDetailsDAO {

    @SqlQuery("SELECT * FROM experiment_details  WHERE experiment_id = :id")
    @Mapper(ExperimentDetailsMapper.class)
    public ExperimentDetails find(@Bind("id") int id);

    @SqlUpdate("DELETE FROM experiment_details  WHERE experiment_id = :id")
    public void delete(@Bind("id") int id);

        ExperimentDetails experimentDetails2 = new ExperimentDetails();
        experimentDetails2.setArchief(true);
        experimentDetails2.setArchiefType("HOF");
        experimentDetails2.setStatus("Experiment goed uitgevoerd");
        experimentDetails2.setBeschrijving("Dit is een mensenlijk experiment, van kinderen van 5 jaar tot volwassenen tot 95 jaar");
        experimentDetails2.setDoorlooptijd("10 jaar");
        experimentDetails2.setExperimentId(1);
        experimentDetails2.setKostenAnders("1000000 euro voor nieuwe organen en andere");
        experimentDetails2.setKostenInovatie("100000 voor mnedicatie");
        experimentDetails2.setNetwerk("Europa en rusland");
        experimentDetails2.setStatusKleur("Rood");
        experimentDetails2.setVoortgang("Het gaat slecht met de gezondheid van de deelnemers");

    public void add(ExperimentDetails newExperimentDetail);

    public void update(int id, ExperimentDetails updatedExperimentDetails);

    public List<ExperimentDetails> getAll() {
        return this.experimentsDetails;
    }

    public ExperimentDetails find(int id) {
        /* EXECUTE QUERY */
        for (ExperimentDetails experimentDetails : this.experimentsDetails) {
            if (experimentDetails.getExperimentId() == id) {
                return experimentDetails;
            }
        }
        return null;
    }

    public void delete(int id) {
        /* EXECUTE QUERY */
        for (ExperimentDetails experimentDetails : this.experimentsDetails) {
            if (experimentDetails.getExperimentId() == id) {
                experimentsDetails.remove(experimentDetails);
                return;
            }
        }
    }

    public void add(ExperimentDetails newExperimentDetail) {
        /* EXECUTE QUERY */
        this.experimentsDetails.add(newExperimentDetail);
    }

    public void update(int id, ExperimentDetails updatedExperimentDetails) {
        /* EXECUTE QUERY */
        for (ExperimentDetails experimentDetails : this.experimentsDetails) {
            if (experimentDetails.getExperimentId() == id) {
                experimentsDetails.set(experimentsDetails.indexOf(experimentDetails), updatedExperimentDetails);
                return;
            }
        }
    }
}
