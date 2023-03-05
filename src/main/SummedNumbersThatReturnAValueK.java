package main;//Given a list of numbers and a number k, return whether any two numbers from the list add up to k.
// For example, given [10, 15, 3, 7] and k of 17, return true since 10 + 7 is 17

import java.util.ArrayList;
import java.util.List;

public class SummedNumbersThatReturnAValueK {
    public static void main(String[] args) {

        List<Integer> numbers = List.of(10, 2, 3, 8, 11, 13, 9, 4, 6, 7);

        List<Integer> sum = new ArrayList<>();

        int k = 17;


        for (int i = 0; i < numbers.size(); i++) {
            int currentValue = numbers.get(i);

            for (int j = i+ 1; j < numbers.size(); j++) {
                int currentValue2 = numbers.get(j);
                System.out.println(currentValue + "(" + i +  ")  + " + currentValue2 + "(" + j + ") = " + (currentValue + currentValue2));

                if (currentValue + currentValue2 == k) {
                    sum.add(currentValue);
                    sum.add(currentValue2);
                }
            }
        }
        System.out.println(sum);
    }
}
