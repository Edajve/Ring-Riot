package org.boxingTournament.interfaces;

import java.util.UUID;

public interface JudgeInterface {
    void judgeRound(); //will populate a private member variable
    UUID determineWinner();
    void clear();

}
