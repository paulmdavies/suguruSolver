package com.paulmdavies.sugurusolver;

import java.util.*;
import java.util.stream.Collectors;

public class CageCompleterService {
    public List<Suggestion> completeCage(List<List<Integer>> squares, List<List<Integer>> cage) {
        ValuesNotInCageService valuesNotInCageService = new ValuesNotInCageService();
        Set<Integer> valuesNotInCage = valuesNotInCageService.getValuesNotInCage(squares, cage);
        if (valuesNotInCage.size() != 1) {
            return Collections.emptyList();
        }
        ArrayList<Suggestion> suggestions = new ArrayList<Suggestion>();
        cage.stream().forEach(integers -> {
            Integer xCoordinate = integers.get(0);
            Integer yCoordinate = integers.get(1);
            if (squares.get(xCoordinate).get(yCoordinate) == 0) {
                suggestions.add(new Suggestion(xCoordinate, yCoordinate, valuesNotInCage.stream().collect(Collectors.toList()).get(0)));
            }
        });
        return suggestions;
    }
}
