package org.boxingTournament.conference;

import org.boxingTournament.fighter.Fighter;
import org.boxingTournament.interfaces.ConferenceInterface;

import java.util.List;
import java.util.Set;

/**
 *  needs a collection of fighters, this is required in order to enroll in a tournament
 */
public class Conference implements ConferenceInterface {
    private final String conferenceName;
    private final List<Fighter> conferenceFighters;

    public Conference(String conferenceName, List<Fighter> conferenceFighters) {
        this.conferenceName = conferenceName;
        this.conferenceFighters = conferenceFighters;
    }

    public String getConferenceName() {
        return conferenceName;
    }

    public List<Fighter> getConferenceFighters() {
        return conferenceFighters;
    }

    @Override
    public Fighter lookUpFighterById(int id) {
        return null;
    }

    @Override
    public Set<Fighter> rankFighters() {
        return null;
    }

    @Override
    public String toString() {
        return "Conference{" +
                "conferenceName='" + conferenceName + '\'' +
                ", conferenceFighters=" + conferenceFighters +
                '}';
    }
}
