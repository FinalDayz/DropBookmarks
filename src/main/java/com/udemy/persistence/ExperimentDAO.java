package com.udemy.persistence;

import com.udemy.model.Experiment;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.BindBean;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;

import javax.inject.Singleton;
import java.util.List;

@Singleton
public interface ExperimentDAO {

    public List<Experiment> getAll();

    @SqlQuery("SELECT * FROM experiment WHERE experiment_ID = :id")
    @Mapper(ExperimentMapper.class)
    public Experiment find(@Bind("id") int id);

    @SqlUpdate("DELETE FROM experiment WHERE experiment_ID = :id")
    public void delete(@Bind("id")int id);

    @SqlUpdate("INSERT INTO experiment (experiment_naam, wijziging_datum, fase, experiment_leider) " +
            "VALUES (:experiment_naam, :wijziging_datum, :fase, :experiment_leider)")
    public void add(@BindBean Experiment newExperiment);

    @SqlUpdate("UPDATE experiment (" +
            "experiment_naam = :experiment_naam" +
            ", wijziging_datum = :wijziging_datum," +
            "fase = :fase," +
            "experiment_leider = :experiment_leider) " +
            "VALUES (, :fase, :experiment_leider" +
            ") WHERE experiment_ID = :experimentId")
    public void update(int id, Experiment updatedExperiment);
}
