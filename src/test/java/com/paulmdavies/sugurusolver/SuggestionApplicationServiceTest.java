package com.paulmdavies.sugurusolver;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class SuggestionApplicationServiceTest {
    @Test
    public void shouldNotChangeAnyValuesIfNoSuggestionsToApply() {
        List<List<Integer>> squares = Arrays.asList(Arrays.asList(0));
        List<Suggestion> suggestions = Collections.emptyList();

        SuggestionApplicationService suggestionApplicationService = new SuggestionApplicationService();

        List<List<Integer>> updatedSquares = suggestionApplicationService.applySuggestions(squares, suggestions);

        assertThat(updatedSquares, is(equalTo(squares)));
    }

    @Test
    public void shouldUpdateValueForSuggestion() {
        List<List<Integer>> squares = Arrays.asList(Arrays.asList(0));
        List<Suggestion> suggestions = Arrays.asList(new Suggestion(0, 0, 1));

        SuggestionApplicationService suggestionApplicationService = new SuggestionApplicationService();

        List<List<Integer>> updatedSquares = suggestionApplicationService.applySuggestions(squares, suggestions);

        assertThat(updatedSquares, is(equalTo(Arrays.asList(Arrays.asList(1)))));
    }

    @Test
    public void shouldSupportMultipleSuggestionsForSameSquare() {
        List<List<Integer>> squares = Arrays.asList(Arrays.asList(0));
        List<Suggestion> suggestions = Arrays.asList(
                new Suggestion(0, 0, 1),
                new Suggestion(0, 0, 2)
        );

        SuggestionApplicationService suggestionApplicationService = new SuggestionApplicationService();

        List<List<Integer>> updatedSquares = suggestionApplicationService.applySuggestions(squares, suggestions);

        assertThat(updatedSquares, is(equalTo(Arrays.asList(Arrays.asList(2)))));
    }
}