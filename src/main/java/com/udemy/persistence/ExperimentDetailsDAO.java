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


    public void add(ExperimentDetails newExperimentDetail);

    public void update(int id, ExperimentDetails updatedExperimentDetails);

}
