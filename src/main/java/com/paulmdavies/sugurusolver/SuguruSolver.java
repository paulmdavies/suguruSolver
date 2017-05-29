package com.paulmdavies.sugurusolver;

import java.util.List;
import java.util.stream.Collectors;

public class SuguruSolver {
    List<List<Integer>> solve(List<List<Integer>> squares, List<List<List<Integer>>> cages) {
        CageCompleterService cageCompleterService = new CageCompleterService();
        // apply solvers
        List<Suggestion> suggestions = cages.stream().flatMap(cage -> {
            List<Suggestion> cageSuggestions = cageCompleterService.completeCage(squares, cage);
            return cageSuggestions.stream();
        }).collect(Collectors.toList());
        // update squares
        SuggestionApplicationService suggestionApplicationService = new SuggestionApplicationService();
        List<List<Integer>> solution = suggestionApplicationService.applySuggestions(squares, suggestions);

        return solution;
    }
}
