package com.rozsa.exercises;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.List;

public class NonDuplicatedIntegerTest {

    private final NonDuplicatedInteger nonDuplicatedInteger = new NonDuplicatedInteger();

    @Test
    void getNonDuplicatedIntegerShouldReturnOne() {
        List<Integer> numbers = List.of(6, 1, 3, 3, 3, 6, 6);
        Integer result = nonDuplicatedInteger.getNonDuplicatedInteger(numbers);

        assertEquals(1, result);
    }

    @Test
    void getNonDuplicatedIntegerShouldReturnNineteen() {
        List<Integer> numbers = List.of(13, 19, 13, 13);
        Integer result = nonDuplicatedInteger.getNonDuplicatedInteger(numbers);

        assertEquals(19, result);
    }
}
