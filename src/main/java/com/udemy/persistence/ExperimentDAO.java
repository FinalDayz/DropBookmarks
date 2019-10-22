package com.udemy.persistence;

import com.udemy.model.Experiment;

import javax.inject.Singleton;
import java.util.ArrayList;
import java.util.List;

@Singleton
public class ExperimentDAO {

    private final List<Experiment> experiments;

    public ExperimentDAO() {

        Experiment testExperiment1 = new Experiment();
        testExperiment1.setExperimentId(0);
        testExperiment1.setExperiment_leider("Henk");
        testExperiment1.setFase("Lab in");
        testExperiment1.setWijziging_datum("2019-10-21");

        Experiment testExperiment2 = new Experiment();
        testExperiment1.setExperimentId(1);
        testExperiment1.setExperiment_leider("Michiel");
        testExperiment1.setFase("Lab uit");
        testExperiment1.setWijziging_datum("2019-09-12");

        experiments = new ArrayList<>();
        experiments.add(testExperiment1);
        experiments.add(testExperiment2);
    }

    public List<Experiment> getAll() {
        return this.experiments;
    }

    public Experiment find(int id) {
        /* EXECUTE QUERY */
        for (Experiment experiment : this.experiments) {
            if (experiment.getExperimentId() == id) {
                return experiment;
            }
        }
        return null;
    }

    public void delete(int id) {
        /* EXECUTE QUERY */
        for (Experiment experiment : this.experiments) {
            if (experiment.getExperimentId() == id) {
                experiments.remove(experiment);
                return;
            }
        }
    }

    public void add(Experiment newExperiment) {
        /* EXECUTE QUERY */
        this.experiments.add(newExperiment);
    }

    public void update(int id, Experiment updatedExperiment) {
        /* EXECUTE QUERY */
        for (Experiment experiment : this.experiments) {
            if (experiment.getExperimentId() == id) {
                experiments.set(experiments.indexOf(experiment), updatedExperiment);
                return;
            }
        }
    }

}
