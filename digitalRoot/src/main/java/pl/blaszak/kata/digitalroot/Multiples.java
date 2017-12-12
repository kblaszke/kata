package pl.blaszak.kata.digitalroot;

public class Multiples {

    public static int solution(int maxNumber) {
        return solution(3, maxNumber) + solution(5, maxNumber);

    }

    private static int solution(int number, int maxNumber) {
        int sum = 0;
        int var = number;
        while(var < maxNumber) {
            sum += var;
            var += number;
        }
        return sum;
    }
}
