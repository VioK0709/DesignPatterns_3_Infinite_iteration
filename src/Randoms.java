import java.util.Iterator;
import java.util.Random;

public class Randoms implements Iterable<Integer> {

    protected Random random;
    protected int min, max;

    public Randoms(int min, int max) {
        this.random = new Random();
        this.min = min;
        this.max = max;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<>() {
            int index = 0;

            @Override
            public boolean hasNext() {
                return index < max;
            }

            @Override
            public Integer next() {
                int diff = max - min;
                if (index < max && diff >= 0 && diff != Integer.MAX_VALUE) {
                    index++;
                    return random.nextInt(diff + 1) + min;
                }
                return null;
            }
        };
    }
}