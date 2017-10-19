package pl.blaszak.kata.letsmakeadeal.service;

import org.junit.Test;
import pl.blaszak.kata.letsmakeadeal.model.DoorStatus;
import pl.blaszak.kata.letsmakeadeal.strategy.ChangeFirstDecision;
import pl.blaszak.kata.letsmakeadeal.strategy.SaveFirstDecision;
import pl.blaszak.kata.letsmakeadeal.strategy.SecondChoiceStrategy;

/**
 * Created by SG0945943 on 10/16/2017.
 */
public class LetsMakeADealPlayTest {

    private static final int TEST_COUNT = 10000;

    @Test
    public void shouldGetAbout60percentWinForChangeStrategy() throws Exception {
        SecondChoiceStrategy strategy = new ChangeFirstDecision();
        letsPlay(strategy);
    }

    @Test
    public void saveChoiceStrategy() throws Exception {
        SecondChoiceStrategy strategy = new SaveFirstDecision();
        letsPlay(strategy);
    }

    private void letsPlay(SecondChoiceStrategy strategy) {
        int win = 0;
        int zonk = 0;
        for (int i = 0; i < TEST_COUNT; i++) {
            LetsMakeADealPlay play = new LetsMakeADealPlay();
            if (play.play(strategy) == DoorStatus.WIN) {
                win++;
            } else {
                zonk++;
            }
        }
        System.out.println(strategy.getClass().getSimpleName() + " strategy: win = " + win + ", zonk = " + zonk);
    }
}