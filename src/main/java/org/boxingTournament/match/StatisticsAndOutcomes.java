package org.boxingTournament.match;

import org.boxingTournament.interfaces.RandomNumberGeneratorInterface;

import java.util.Random;

public class StatisticsAndOutcomes implements RandomNumberGeneratorInterface {
    private final Random random = new Random();

    @Override
    public int generateRandomInt(int max) {
        return random.nextInt(max);
    }
}
