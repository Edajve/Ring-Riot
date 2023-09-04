package org.boxingTournament.match;

import org.boxingTournament.interfaces.RandomNumberGeneratorInterface;

import java.util.Random;

public class StatisticsAndOutcomes implements RandomNumberGeneratorInterface {
    @Override
    public byte generateRandomByte(byte max) {
        Random random = new Random();
        return (byte) random.nextInt(max);
    }
}
