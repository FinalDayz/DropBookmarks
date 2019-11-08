package com.udemy.persistence;

import com.udemy.model.VasteDienst;
import com.udemy.model.VasteDienst;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Stefan
 */
public class VasteDienstDAO {

    private final List<VasteDienst> vasteDiensten;

    public VasteDienstDAO() {

        VasteDienst dienst1 = new VasteDienst();
        dienst1.setVasteDiendstNaam("Vaste dienst een");
        dienst1.setLogStatus("Logggg status");
        dienst1.setOmschrijving("De omschrijving van de eerste vaste dienst");
        dienst1.setVasteDiensId(0);

        vasteDiensten = new ArrayList<>();
        vasteDiensten.add(dienst1);
    }

    public List<VasteDienst> getAll() {
        return this.vasteDiensten;
    }

    public VasteDienst find(int id) {
        /* EXECUTE QUERY */
        for (VasteDienst experiment : this.vasteDiensten) {
            if (experiment.getVasteDienstId() == id) {
                return experiment;
            }
        }
        return null;
    }

    public void delete(int id) {
        /* EXECUTE QUERY */
        for (VasteDienst experiment : this.vasteDiensten) {
            if (experiment.getVasteDienstId() == id) {
                vasteDiensten.remove(experiment);
                return;
            }
        }
    }

    public void add(VasteDienst newVasteDienst) {
        /* EXECUTE QUERY */
        this.vasteDiensten.add(newVasteDienst);
    }

    public void update(int id, VasteDienst updatedVasteDienst) {
        /* EXECUTE QUERY */
        for (VasteDienst experiment : this.vasteDiensten) {
            if (experiment.getVasteDienstId() == id) {
                vasteDiensten.set(vasteDiensten.indexOf(experiment), updatedVasteDienst);
                return;
            }
        }
    }

}
