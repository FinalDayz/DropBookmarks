package com.udemy.persistence;

import com.udemy.model.Experiment;
import com.udemy.model.Message;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;

import java.util.Collection;
import java.util.List;

public interface MessageDAO {

    public List<Experiment> getAll();

    /**
     * @author Bart
     * @param message
     * @param experimentId
     * @param accountId
     */
    @SqlUpdate("INSERT INTO message (account_ID, Bericht, experiment_ID) " +
            "VALUES (:account_ID, :Bericht, :experiment_ID);")
    void addMessage(@Bind("Bericht") String message,
                    @Bind("experiment_ID") int experimentId,
                    @Bind("account_ID") int accountId);

    @SqlUpdate("UPDATE experiment " +
            "Set wijziging_datum = CURRENT_TIMESTAMP() " +
            "WHERE experiment_ID = :experiment_ID;")
    void updateExperiment(@Bind("experiment_ID") int experimentId);

    @SqlQuery("SELECT bericht, date FROM message INNER JOIN experiment ON experiment.experiment_ID=message.experiment_ID\n" +
            "WHERE experiment.experiment_ID = :ID;")
    @Mapper(ExperimentMapper.class)
    public List<Experiment> getMessages(@Bind("ID")int ID);

    @SqlQuery("SELECT m.*, a.account_naam FROM `message` m join account a on a.account_ID = m.account_ID where m.experiment_ID = :ID;")
    @Mapper(MessageMapper.class)
    public List<Experiment> getMessagesFromExperiment(@Bind("ID") int ID);

}
