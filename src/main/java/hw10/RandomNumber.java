package hw10;

import java.util.stream.Stream;

public class RandomNumber implements Generator{
    @Override
    public Stream<Long> lcg(Long a, int c, int m, Long seed) {
        return Stream.iterate(seed, n -> (((a * n) + c) % m)).limit(7);
    }
}
