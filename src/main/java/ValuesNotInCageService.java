import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ValuesNotInCageService {
    public Set<Integer> getValuesNotInCage(List<List<Integer>> squares, List<List<Integer>> cage) {
        Set<Integer> valueSet = new HashSet<>();
        cage.stream().forEach(integers -> {
            Integer xCoordinate = integers.get(0);
            Integer yCoordinate = integers.get(1);
            Integer value = squares.get(xCoordinate).get(yCoordinate);
            if (value != 0) {
                valueSet.add(value);
            }
        });
        Set<Integer> allValuesSet = IntStream.rangeClosed(1, cage.size()).boxed().collect(Collectors.toSet());
        allValuesSet.removeAll(valueSet);
        return allValuesSet;
    }
}
