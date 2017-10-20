package pl.blaszak.kata.binarysearch.strategy;

import java.util.List;

public class SimpleFindCenterStrategy implements FindCenterStrategy {

    @Override
    public int findCenter(List theList, Integer element, int left, int right) {
        return (left + right)/2;
    }
}
