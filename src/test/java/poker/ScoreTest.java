package poker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

/**
 * ScoreTest
 */
public class ScoreTest {

    @Test
    public void score1Test() {

        Score score = new Score();

        List<String> hand1 = new ArrayList<>(Arrays.asList("2", "3", "4", "6", "7"));
        List<String> hand2 = new ArrayList<>(Arrays.asList("2", "2", "4", "10", "7"));

        System.out.println("hand1 : " + score.scoring(hand1));
        System.out.println("hand2 : " + score.scoring(hand2));
    }
}