package com.rozsa.exercises;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NonDuplicatedIntegerTest {

    private NonDuplicatedInteger nonDuplicatedInteger = new NonDuplicatedInteger();

    @Test
    public void getNonDuplicatedIntegerOneDuplicated() {
        //inicialização/preparação
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(6);
        numbers.add(1);
        numbers.add(3);
        numbers.add(3);
        numbers.add(3);
        numbers.add(6);
        numbers.add(6);

        //execução
        Integer result = nonDuplicatedInteger.getNonDuplicatedInteger(numbers);

        //asserção
        assertEquals(1, result);
    }
}
