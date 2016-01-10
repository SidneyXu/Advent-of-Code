import java.io.File;
import java.nio.file.Files;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) throws Exception {
        int floor = Files.lines(new File("input.txt").toPath())
                .map(line ->
                        Stream.of(line.split(""))
                                .mapToInt(s -> {
                                    if (s.equals("(")) {
                                        return 1;
                                    } else if (s.equals(")")) {
                                        return -1;
                                    }
                                    return 0;
                                }).reduce((v1, v2) -> v1 + v2)
                                .getAsInt()).reduce((v1, v2) -> v1 + v2).get();
        System.out.println(floor);

        AtomicInteger pos = new AtomicInteger(0);
        AtomicInteger sum = new AtomicInteger(0);
        Files.lines(new File("input.txt").toPath())
                .flatMap(line -> Stream.of(line.split("")))
                .mapToInt(s -> {
                    if (s.equals("(")) {
                        return 1;
                    } else if (s.equals(")")) {
                        return -1;
                    }
                    return 0;
                }).forEachOrdered(s -> {
            if (sum.get() == -1)
                return;
            sum.addAndGet(s);
            pos.incrementAndGet();
        });
        System.out.println(pos.get());
    }
}
