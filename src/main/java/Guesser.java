import java.math.BigInteger;
import java.util.Random;

public class Guesser {
    /**
     * This method must return the number Chooser c has chosen. c can guess() any
     * number and tell you whether the number is "correct", "higher", or "lower".
     *
     * @param c The "chooser" that has chosen a number you must guess.
     * @return The number that the "chooser" has chosen
     */
    // I want to be able to guess a random number and place it in a variable.
    // Figure out if it is higher or lower, then make the number below it the ceiling or
    // number above it the floor. Keep choosing the middle number??
    public static BigInteger findNumber(Chooser c) {
        BigInteger currGuess = new BigInteger(100, new Random());
        BigInteger low = new BigInteger("0");
        BigInteger high = new BigInteger("0");
        while (!c.guess(currGuess).equals("correct")) {
            if (c.guess(currGuess).equals("higher")) {
                low = low.subtract(low).add(currGuess);
                currGuess = currGuess.add(currGuess);
            } else {
                high = high.subtract(high).add(currGuess);
                currGuess = high.add(currGuess).divide(new BigInteger("10"));
            }
        }
        return currGuess;
    }
}
