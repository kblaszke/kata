package pl.blaszak.kata.binarysearch.strategy;

import java.util.List;

public class InterpolationFindCenterStrategy implements FindCenterStrategy {

    @Override
    public int findCenter(List<Integer> theList, Integer element, int left, int right) {
        int x = element;
        int xa = theList.get(left);
        int xb = theList.get(right);
        if (xa < x && x > xb) {
            int t = (x - xa) / (xb - xa);
            return left + t * (right - left);
        }
        return (left + right)/2;
    }
}
