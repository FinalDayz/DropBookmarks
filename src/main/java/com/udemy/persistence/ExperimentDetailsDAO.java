package com.udemy.persistence;

import com.udemy.model.Experiment;
import com.udemy.model.ExperimentDetails;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.BindBean;
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

    @SqlUpdate("UPDATE `experiment_details` SET "+
            "`netwerk`=:netwerk," +
            "`status`=:status," +
            "`status_kleur`=:statusKleur," +
            "`kosten_inovatie`=:kostenInovatie," +
            "`kosten_anders`=:kostenAnders," +
            "`doorlooptijd`=:doorlooptijd," +
            "`beschrijving`=:beschrijving," +
            "`voortgang`=:voortgang," +
            "`archief`=:archief," +
            "`archief_type`=:archiefType" +
            " WHERE experiment_ID = :id")
    public void update(@Bind("id") int id, @BindBean ExperimentDetails updatedExperimentDetails);

}
