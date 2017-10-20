package pl.blaszak.kata.binarysearch.strategy;

import java.util.List;

public interface FindCenterStrategy {
    int findCenter(List<Integer> theList, Integer element, int left, int right);
}
