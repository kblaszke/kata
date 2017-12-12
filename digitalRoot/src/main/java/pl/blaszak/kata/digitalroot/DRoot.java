package pl.blaszak.kata.digitalroot;

public class DRoot {

        public static int digital_root(int n) {
            int theSum = n;
            do {
                theSum = digitalSum(theSum);
            } while (theSum / 10 != 0);
            return theSum;
        }

        private static int digitalSum(int n) {
            int reducedNumber = n / 10;
            if (reducedNumber == 0) {
                return n;
            }
            return n % 10 + digitalSum(reducedNumber);
        }
}
