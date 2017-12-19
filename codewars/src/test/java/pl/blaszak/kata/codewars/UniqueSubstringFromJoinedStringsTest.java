package pl.blaszak.kata.codewars;

import org.assertj.core.api.WithAssertions;
import org.junit.Test;

import java.util.LinkedHashSet;
import java.util.Random;

import static org.junit.Assert.assertEquals;

public class UniqueSubstringFromJoinedStringsTest implements WithAssertions {

    @Test
    public void firstTest() throws Exception {
        // given
        String a = "piquancy";
        String b = "refocusing";
        // when
        int result = UniqueSubstringFromJoinedStrings.create(a, b);
        // then
        assertThat(result).isEqualTo(5);
    }

    @Test
    public void secondTest() throws Exception {
        // given
        String a = "";
        String b = "06032016";
        // when
        int result = UniqueSubstringFromJoinedStrings.create(a, b);
        // then
        //System.out.println(result);
        assertThat(result).isEqualTo(4);
    }

    @Test
    public void name() throws Exception {
        /*assertEquals("Basic test ('preface', 'singularity')", 8, UniqueSubstringFromJoinedStrings.create("preface","singularity"));
        assertEquals("Long strings", 607, UniqueSubstringFromJoinedStrings.create(";;;;;;;;;;;;ZZZZ5;;;;;;;;;;;;ZZZZ5;;;;;;;;;;;;ZZZZ5;;;;;;;;;;;;ZZZZ5;;;;;;;;;;;;ZZZZ5;;;;;;;;;;;;ZZZZ5;;;;;;;;;;;;ZZZZ5;;;;;;;;;;;;ZZZZ5;;;;;;;;;;;;ZZZZ5;;;;;;;;;;;;ZZZZ5;;;;;;;;;;;;ZZZZ5;;;;;;;;;;;;ZZZZ5;;;;;;;;;;;;ZZZZ5;;;;;;;;;;;;ZZZZ5;;;;;;;;;;;;ZZZZ5;;;;;;;;;;;;ZZZZ5;;;;;;;;;;;;ZZZZ5;;;;;;;;;;;;ZZZZ5;;;;;;;;;;;;ZZZZ5;;;;;;;;;;;;ZZZZ5;;;;;;;;;;;;ZZZZ5;;;;;;;;;;;;ZZZZ5;;;;;;;;;;;;ZZZZ5;;;;;;;;;;;;ZZZZ5;;;;;;;;;;;;ZZZZ5;;;;;;;;;;;;ZZZZ5;;;;;;;;;;;;ZZZZ5;;;;;;;;;;;;ZZZZ5;;;;;;;;;;;;ZZZZ5;;;;;;;;;;;;ZZZZ5;;;;;;;;;;;;ZZZZ5;;;;;;;;;;;;ZZZZ5;;;;;;;;;;;;ZZZZ5;;;;;;;;;;;;ZZZZ5535533553355355335533553355355335533553355355335533553355533553355335535533553355335535533553355335553355335533553553355335533553553355335533555335533553355355335533553355355335533553355533553355335535533553355335535533553355335553355335533553553355335533553553355335533555335533553355355335533553355355335533553355533553355335535533553355335535533553355335553355335533553553355335533553553355335533555335533553355355335533553355355335533553355533553355335535533553355335535533553355335553355335533553553355335533553553355335533535535533553355335535533553355335535533553355335533553355335535533553355335533113355335533553355335511","01000100101010010101001010101010010001000100101010010101001010101010010001000100101010010101001010101010010001000100101010010101001010101010010001000100101010010101001010101010010001000100101010010101001010101010010001000100101010010101001010101010010001000100101010010101001010101010010001000100101010010101001010101010010001000100101010010101001010101010010001000100101010010101001010101010010001000100101010010101001010101010010001000100101010010101001010101010010001000100101010010101001010101010010001000100101010010101001010101010010001000100Z10101001010100101010101001000100010010101001010100101010101001000100010010101001010100101010101001000100010010101001010100101010101001000100010010101001010100101010101001000100010010101001010100101010101001000100010010101001010100101010101001000100010010101001010100101010101001000100010010101001010100101010101001000100010010101001010100101010101001000100010010101001010100101010101001001"));
        assertEquals("Anagrams ('tablets', 'battles')", 0, UniqueSubstringFromJoinedStrings.create("tablets","battles"));
        assertEquals("Whitespace and escape characters", 5, UniqueSubstringFromJoinedStrings.create("                         \t","\n445       "));
        assertEquals("Substring entirely in B", 6, UniqueSubstringFromJoinedStrings.create("bbbbbbbbbbbbbbbbbbbbbbbbbbbbbb","beliefs"));
        assertEquals("Substring entirely in A",  6, UniqueSubstringFromJoinedStrings.create("hotdogs","sssssssssssssssssss"));
        assertEquals("Substring mid A", 3, UniqueSubstringFromJoinedStrings.create("e1222111100011112221f","12eeeeeeeffffffff"));
        assertEquals("Substring mid B", 4, UniqueSubstringFromJoinedStrings.create("&&&&&&&&&&&&&&$$$$$$$$$$$$GGGG","$$$$$$$$$G$$$$$hamo&&&&&&&&&&&&&&&&&&&"));
        assertEquals("No shared characters ('rhythms', 'logician')", 15, UniqueSubstringFromJoinedStrings.create("rhythms","logician"));
        assertEquals("Lots of shared characters", 6, UniqueSubstringFromJoinedStrings.create("abcd`efgh';lij1|234@5\678[90klmnopqrstsrqponmlk","tsrq6\789p[`onmlkvutlsrqp12;345onm|lk'jihgfedcba0uvwxyz@"));
        assertEquals("Two empty strings", 0, UniqueSubstringFromJoinedStrings.create("",""));
        assertEquals("One empty string", 8, UniqueSubstringFromJoinedStrings.create("","06032016"));*/

        String[] randomTestsA = {makeWord(), makeWord(),makeWord(),makeWord(),
                makeWord(), makeWord(), makeWord(), makeWord(), makeWord(), makeWord(),
                makeWord(), makeWord(), makeWord(), makeWord(), makeWord(), makeWord(),
                makeWord(), makeWord(), makeWord(), makeWord(), makeWord(), makeWord(),
                makeWord(), makeWord(), makeWord(), makeWord(), makeWord(), makeWord(),
                makeWord(), makeWord(), makeWord(), makeWord(), makeWord(), makeWord(),
                makeWord(), makeWord(), makeWord(), makeWord(), makeWord(), makeWord(),
                makeWord(), makeWord(), makeWord(), makeWord(), makeWord(), makeWord(),
                makeWord(), makeWord(), makeWord(), makeWord(), makeWord(), makeWord(),
                makeWord(), makeWord(), makeWord(), makeWord(), makeWord(), makeWord()};

        String[] randomTestsB = {makeWord(), makeWord(),makeWord(),makeWord(),
                makeWord(), makeWord(), makeWord(), makeWord(), makeWord(), makeWord(),
                makeWord(), makeWord(), makeWord(), makeWord(), makeWord(), makeWord(),
                makeWord(), makeWord(), makeWord(), makeWord(), makeWord(), makeWord(),
                makeWord(), makeWord(), makeWord(), makeWord(), makeWord(), makeWord(),
                makeWord(), makeWord(), makeWord(), makeWord(), makeWord(), makeWord(),
                makeWord(), makeWord(), makeWord(), makeWord(), makeWord(), makeWord(),
                makeWord(), makeWord(), makeWord(), makeWord(), makeWord(), makeWord(),
                makeWord(), makeWord(), makeWord(), makeWord(), makeWord(), makeWord(),
                makeWord(), makeWord(), makeWord(), makeWord(), makeWord(), makeWord()};

        for (int i = 0; i < randomTestsA.length; i++) {
            assertEquals("Random test " + i + 1 + "/58" + " (" + randomTestsA[i] + ", " + randomTestsB[i] + ") " , lSubstring(randomTestsA[i],randomTestsB[i]), UniqueSubstringFromJoinedStrings.create(randomTestsA[i],randomTestsB[i]));
        }
    }

    public int lSubstring(String a, String b) {

        char[] aPlusB = a.concat(b).toCharArray();
        char[] bPlusA = b.concat(a).toCharArray();

        // Determine the characters shared by both strings
        char[] aChars = a.toCharArray();
        char[] bChars = b.toCharArray();
        LinkedHashSet<Character> aCharsSet = new LinkedHashSet<Character>();
        LinkedHashSet<Character> bCharsSet = new LinkedHashSet<Character>();

        for (char character : aChars) {
            aCharsSet.add(character);
        }

        for (char character : bChars) {
            bCharsSet.add(character);
        }

        aCharsSet.retainAll(bCharsSet);
        //aCharsSet now holds the characters shared by the strings

        int temp = 0;
        int maxLength = 0;

        // Check each character of aPlusB to see if it's in the set of shared characters
        for (int i = 0; i < aPlusB.length; i++) {
            if (!aCharsSet.contains(aPlusB[i])) {
                // If it isn't, increment temp. temp represents the longest current length of unshared characters.
                temp++;
                if (temp > maxLength) {
                    // If temp is greater than the stored max value, update the max value
                    maxLength = temp;
                }
            } else {
                // Otherwise, reset the length to zero
                temp = 0;
            }
        }

        // Repeat the process for B + A
        temp = 0;
        for (int i = 0; i < bPlusA.length; i++) {
            if (!aCharsSet.contains(bPlusA[i])) {
                temp++;
                if (temp > maxLength) {
                    maxLength = temp;
                }
            } else {
                temp = 0;
            }
        }

        return maxLength;

    }


    public String makeWord() {
        String testWord = "";
        String charSet = "abcdefghijklMNOPQRSTUVWXYZ1234567890)(*&^% `<>?/}{+=";
        Random r = new Random();
        for (int i = 0; i < r.nextInt(145)+60; i++){
            testWord = testWord += charSet.charAt(r.nextInt(charSet.length()));
        }
        return testWord;
    }
}