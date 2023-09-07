package org.boxingTournament.conference;

import org.boxingTournament.fighter.Fighter;
import org.boxingTournament.interfaces.ConferenceInterface;

import java.util.List;
import java.util.Set;

public record Conference(List<Fighter> fighters) implements ConferenceInterface {
    /**
     * @param fighters - needs a collection of fighters, this is required in order to enroll in a tournament
     */
    public Conference {
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
