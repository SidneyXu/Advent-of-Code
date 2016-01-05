import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.nio.file.Files;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

/**
 * Created by SidneyXu on 2016/01/06.
 */
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

        try (FileReader reader = new FileReader("input.txt");
             BufferedReader bufferedReader = new BufferedReader(reader)) {
            String content = bufferedReader.readLine();
            AtomicInteger sum = new AtomicInteger(0);
            AtomicInteger pos = new AtomicInteger(0);
            Stream.of(content).flatMap(s -> Stream.of(s.split(""))).forEachOrdered(s -> {
                if (sum.get() == -1)
                    return;
                if (s.equals("("))
                    sum.incrementAndGet();
                else if (s.equals(")"))
                    sum.decrementAndGet();
                pos.incrementAndGet();
            });
            System.out.println(pos.get());
        }
    }
}
