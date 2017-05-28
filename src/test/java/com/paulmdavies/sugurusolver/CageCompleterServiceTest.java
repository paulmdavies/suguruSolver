package com.paulmdavies.sugurusolver;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class CageCompleterServiceTest {
    @Test
    public void shouldMakeNoChangesIfCageHasMoreThanOneEmptySquare() {
        List<List<Integer>> squares = Arrays.asList(Arrays.asList(0, 0));
        List<List<Integer>> cage = Arrays.asList(Arrays.asList(0, 0), Arrays.asList(0, 1));

        CageCompleterService cageCompleterService = new CageCompleterService();
        List<List<Integer>> updatedSquares = cageCompleterService.completeCage(squares, cage);

        assertThat(updatedSquares, is(equalTo(squares)));
    }

    @Test
    public void shouldFillInSquareIfCageHasOnlyOneEmptySquare() {
        List<List<Integer>> squares = Arrays.asList(Arrays.asList(0));
        List<List<Integer>> cage = Arrays.asList(Arrays.asList(0, 0));

        CageCompleterService cageCompleterService = new CageCompleterService();
        List<List<Integer>> updatedSquares = cageCompleterService.completeCage(squares, cage);

        assertThat(updatedSquares, is(equalTo(Arrays.asList(Arrays.asList(1)))));
    }
}