package org.boxingTournament.match;

import org.boxingTournament.interfaces.RandomNumberGeneratorInterface;

import java.util.Random;

public class StatisticsAndOutcomes implements RandomNumberGeneratorInterface {

    private boolean transistor = true;
    private final Random random = new Random();

    public boolean getTransistor() {
        return transistor;
    }

    public StatisticsAndOutcomes generateOne() {
        transistor = generateMethodOne();
        return this;
    }

    public StatisticsAndOutcomes generateTwo() {
        transistor = generateMethodTwo();
        return this;
    }

    @Override
    public boolean generateMethodOne() {
        return random.nextBoolean();
    }

    @Override
    public boolean generateMethodTwo() {
        return random.nextInt(1_000_000) <= 500_000;
    }
}
