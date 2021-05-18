package hw10;

import java.util.stream.Stream;

public interface Generator {
    Stream<Long> lcg (Long a, int c, int m, Long seed);
}
