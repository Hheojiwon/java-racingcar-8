package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGeneratorImpl implements RandomNumberGenerator {

    public final int RANDOM_NUMBER_START = 0;
    public final int RANDOM_NUMBER_END = 9;

    @Override
    public int generate() {
        return Randoms.pickNumberInRange(RANDOM_NUMBER_START, RANDOM_NUMBER_END);
    }
}