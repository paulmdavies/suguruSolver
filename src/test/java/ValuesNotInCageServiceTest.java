import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;

public class ValuesNotInCageServiceTest {

    public static final List<List<Integer>> ANY_SQUARES = Arrays.asList(Arrays.asList(1));

    @Test
    public void shouldReturnEmptyListForCageWithNoSquares() {
        ValuesNotInCageService valuesNotInCageService = new ValuesNotInCageService();
        Set<Integer> valuesNotInCage = valuesNotInCageService.getValuesNotInCage(
                ANY_SQUARES,
                Collections.<List<Integer>>emptyList()
        );
        assertThat(valuesNotInCage.size(), is(equalTo(0)));
    }

    @Test
    public void shouldReturnEmptyListForCageWithNoEmptySquares() {
        ValuesNotInCageService valuesNotInCageService = new ValuesNotInCageService();
        Set<Integer> valuesNotInCage = valuesNotInCageService.getValuesNotInCage(
                Arrays.asList(Arrays.asList(1)),
                Arrays.asList(Arrays.asList(0, 0))
        );
        assertThat(valuesNotInCage.size(), is(equalTo(0)));
    }

    @Test
    public void shouldReturnAllPossibleValuesForCageWithNoFilledInSquares() {
        ValuesNotInCageService valuesNotInCageService = new ValuesNotInCageService();
        Set<Integer> valuesNotInCage = valuesNotInCageService.getValuesNotInCage(
                Arrays.asList(Arrays.asList(0, 0), Arrays.asList(0, 0)),
                Arrays.asList(Arrays.asList(0, 0), Arrays.asList(0, 1), Arrays.asList(1, 0), Arrays.asList(1, 1))
        );
        assertThat(valuesNotInCage, is(equalTo(Stream.of(1, 2, 3, 4).collect(Collectors.toSet()))));
    }
}