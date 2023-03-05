package com.rozsa.exercises;

/*Given an array of integers where every integer occurs three times except for one integer, which only occurs once, find and return the non-duplicated integer.
For example, given [6, 1, 3, 3, 3, 6, 6], return 1. Given [13, 19, 13, 13], return 19.
Do this in O(n) time and O(1) space.
*/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class NonDuplicatedInteger {
    public static void main(String[] args) {

        System.out.println(getNonDuplicatedInteger());
    }

    private static Integer getNonDuplicatedInteger() {
        ArrayList<Integer> numbers = new ArrayList<>();
//        numbers.add(6);
//        numbers.add(1);
//        numbers.add(3);
//        numbers.add(3);
//        numbers.add(3);
//        numbers.add(6);
//        numbers.add(6);
        numbers.add(13);
        numbers.add(13);
        numbers.add(19);
        numbers.add(13);

        HashMap<Integer, Integer> num = new HashMap<>();

        for (int currentNumber : numbers) {
            if (num.containsKey(currentNumber)) {
                num.put(currentNumber, num.get(currentNumber) + 1);
            } else {
                num.put(currentNumber, 1);
            }
        }

        Integer minKey = -1;
        for (var currentPair : num.entrySet()) {
            if (currentPair.getValue() == 1) {
                minKey = currentPair.getKey();
            }
        }
        return minKey;
    }
}



