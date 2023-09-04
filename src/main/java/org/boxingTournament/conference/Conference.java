package org.boxingTournament.conference;

import org.boxingTournament.fighter.Fighter;
import org.boxingTournament.interfaces.ConferenceInterface;

import java.util.List;
import java.util.Set;

public class Conference implements ConferenceInterface {
    private List<Fighter> fighters;

    /**
     *
     * @param fighters - needs a collection of fighters, this is required in order to enroll in a tournament
     */
    public Conference(List<Fighter> fighters) {
        this.fighters = fighters;
    }

    public List<Fighter> getFighters() {
        return fighters;
    }

    public void setFighters(List<Fighter> fighters) {
        this.fighters = fighters;
    }

    @Override
    public Fighter lookUpFighterById(int id) {
        return null;
    }

    @Override
    public Set<Fighter> rankFighters() {
        return null;
    }
}
