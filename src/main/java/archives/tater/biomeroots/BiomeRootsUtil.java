package archives.tater.biomeroots;

import java.util.Comparator;
import java.util.Optional;
import java.util.function.Function;

public interface BiomeRootsUtil {
    static <T> Comparator<T> compareByPresence(Function<T, Optional<?>> getter) {
        return (first, second) -> {
            var firstValue = getter.apply(first);
            var secondValue = getter.apply(second);
            return firstValue.isPresent()
                ? secondValue.isPresent()
                    ? 0
                    : -1
                : secondValue.isPresent()
                    ? 0
                    : 1;
        };
    }
}
