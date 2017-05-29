package com.paulmdavies.sugurusolver;

import java.util.List;

public class SuggestionApplicationService {
    public List<List<Integer>> applySuggestions(List<List<Integer>> squares, List<Suggestion> suggestions) {
        suggestions.stream().forEach(suggestion -> {
            squares.get(suggestion.getXCoordinate()).set(suggestion.getYCoordinate(), suggestion.getValue());
        });
        return squares;
    }
}
