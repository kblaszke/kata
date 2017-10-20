package pl.blaszak.kata.binarysearch;

import org.apache.log4j.Logger;
import pl.blaszak.kata.binarysearch.strategy.FindCenterStrategy;

import java.util.List;

public class BinarySearchMachine {

    private static final Logger LOGGER = Logger.getLogger(BinarySearchMachine.class);

    private List<Integer> orderedList;
    private int operationCount = 0;

    private final FindCenterStrategy findCenterStrategy;

    public BinarySearchMachine(FindCenterStrategy findCenterStrategy) {
        this.findCenterStrategy = findCenterStrategy;
    }

    public BinarySearchMachine forOrderedElements(List<Integer> orderedList) {
        this.orderedList = orderedList;
        return this;
    }

    public Integer findIndex(Integer wantedElement) {
        operationCount = 0;
        return findIndex(wantedElement, 0, orderedList.size() - 1);
    }

    private Integer findIndex(Integer wantedElement, int left, int right) {
        operationCount++;
        if (orderedList.get(left).equals(wantedElement)) {
            LOGGER.debug("Operation count = " + operationCount);
            return left;
        }
        if (left >= right) {
            LOGGER.debug("Operation count = " + operationCount);
            return null;
        }
        int center = findCenterStrategy.findCenter(orderedList, wantedElement, left, right);
        if (orderedList.get(center).compareTo(wantedElement) < 0) {
            return findIndex(wantedElement, center + 1, right);
        } else {
            return findIndex(wantedElement, left, center);
        }
    }
}
