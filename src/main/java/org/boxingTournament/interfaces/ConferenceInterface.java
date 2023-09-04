package org.boxingTournament.interfaces;

import org.boxingTournament.boxing.Fighter;

import java.util.Set;

public interface ConferenceInterface {
    Fighter lookUpFighterById(int id);

    Set<Fighter> rankFighters();
}
