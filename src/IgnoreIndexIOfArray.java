import java.util.ArrayList;
import java.util.List;

/*
// This problem was asked by Uber.
// Given an array of integers, return a new array such that each element at index i of the new array is the product of all the numbers in the original array except the one at i.
// For example, if our input was [1, 2, 3, 4, 5], the expected output would be [120, 60, 40, 30, 24]. If our input was [3, 2, 1], the expected output would be [2, 3, 6].
*/
public class IgnoreIndexIOfArray {
    public static void main(String[] args) {

        Integer[] numbers = {3, 4, 5};
        //Integer[] numbers = {3, 2, 1};
        //Integer[] numbers = {1, 2, 3, 4, 5};

        List<Integer> numbersResult = new ArrayList<>();

        for (int i = 0; i < numbers.length; i++) {
            int result = 1;
            for (int j = 0; j < numbers.length; j++) {
                result *= numbers[j] ;
            }
            result =  result / numbers[i];
            numbersResult.add(result);
        }
        System.out.println(numbersResult);
    }
}
