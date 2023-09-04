package org.boxingTournament.match;

import org.boxingTournament.interfaces.RandomNumberGeneratorInterface;

import java.util.Random;

public class StatisticsAndOutcomes implements RandomNumberGeneratorInterface {
    private final Random random = new Random();

    @Override
    public byte generateRandomByte(byte max) {
        return (byte) random.nextInt(max);
    }
}
