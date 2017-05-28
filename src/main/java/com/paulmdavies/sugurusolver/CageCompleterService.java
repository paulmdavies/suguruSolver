package com.paulmdavies.sugurusolver;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class CageCompleterService {
    public List<List<Integer>> completeCage(List<List<Integer>> squares, List<List<Integer>> cage) {
        ValuesNotInCageService valuesNotInCageService = new ValuesNotInCageService();
        Set<Integer> valuesNotInCage = valuesNotInCageService.getValuesNotInCage(squares, cage);
        if (valuesNotInCage.size() != 1) {
            return squares;
        }
        ArrayList<List<Integer>> updatedSquares = new ArrayList<List<Integer>>(squares.stream().map(integers -> new ArrayList<Integer>(integers)).collect(Collectors.toList()));
        cage.stream().forEach(integers -> {
            Integer xCoordinate = integers.get(0);
            Integer yCoordinate = integers.get(1);
            if (updatedSquares.get(xCoordinate).get(yCoordinate) == 0) {
                updatedSquares.get(xCoordinate).set(yCoordinate, valuesNotInCage.stream().collect(Collectors.toList()).get(0));
            }
        });
        return updatedSquares;
    }
}
