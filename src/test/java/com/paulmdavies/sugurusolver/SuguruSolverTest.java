package com.paulmdavies.sugurusolver;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;

public class SuguruSolverTest {
    @Test
    public void basicTest() {
        List<List<Integer>> squares = Arrays.asList(Arrays.asList(1, 2), Arrays.asList(0, 0));
        List<List<List<Integer>>> cages = Arrays.asList(
                Arrays.asList(Arrays.asList(0, 0), Arrays.asList(1, 0)),
                Arrays.asList(Arrays.asList(0, 1), Arrays.asList(1, 1))
        );

        SuguruSolver suguruSolver = new SuguruSolver();
        List<List<Integer>> solution = suguruSolver.solve(squares, cages);

        assertThat(solution, is(equalTo(Arrays.asList(Arrays.asList(1, 2), Arrays.asList(2, 1)))));
    }
}