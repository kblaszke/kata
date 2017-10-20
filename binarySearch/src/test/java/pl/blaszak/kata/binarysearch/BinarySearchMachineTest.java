package pl.blaszak.kata.binarysearch;

import org.assertj.core.api.WithAssertions;
import org.junit.Test;
import pl.blaszak.kata.binarysearch.strategy.InterpolationFindCenterStrategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class BinarySearchMachineTest implements WithAssertions {

    private static final int MAX_VALUE = 100000000;
    private final static int ELEMENT_COUNT = 10000000;
    private static final Random GEN = new Random();

    private final BinarySearchMachine searchMachine = new BinarySearchMachine(new InterpolationFindCenterStrategy());
    //private final BinarySearchMachine searchMachine = new BinarySearchMachine(new SimpleFindCenterStrategy());

    @Test
    public void shouldFindWantedElement() throws Exception {
        // given
        List<Integer> theList = new ArrayList<>(createUniqueIntegers(ELEMENT_COUNT));
        Integer wantedElement = theList.get(GEN.nextInt(ELEMENT_COUNT));
        Collections.sort(theList);
        // when
        Integer wantedElementIndex = searchMachine.forOrderedElements(theList).findIndex(wantedElement);
        // then
        assertThat(wantedElementIndex).isNotNull();
        assertThat(theList.get(wantedElementIndex)).isEqualTo(wantedElement);
    }

    @Test
    public void shouldNotFindWantedElement() throws Exception {
        // given
        List<Integer> theList = new ArrayList<>(createUniqueIntegers(ELEMENT_COUNT));
        Integer wantedElement = theList.get(GEN.nextInt(ELEMENT_COUNT));
        theList.remove(wantedElement);
        Collections.sort(theList);
        // when
        Integer wantedElementIndex = searchMachine.forOrderedElements(theList).findIndex(wantedElement);
        // then
        assertThat(wantedElementIndex).isNull();
    }

    private Set<Integer> createUniqueIntegers(int elementCount) {

        HashSet<Integer> set = new HashSet<>();
        while (set.size() < elementCount) {
            set.add(GEN.nextInt(MAX_VALUE));
        }
        return set;
    }
}