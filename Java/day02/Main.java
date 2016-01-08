import java.io.File;
import java.nio.file.Files;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) throws Exception {
        int totalWrapping = Files.lines(new File("input.txt").toPath())
                .map(line -> {
                    IntStream intStream = Stream.of(line.split("x")).mapToInt(Integer::valueOf);
                    int[] lwh = intStream.sorted().toArray();
                    int minSide = lwh[0] * lwh[1];
                    return 2 * (lwh[0] * lwh[1] + lwh[1] * lwh[2] + lwh[0] * lwh[2]) + minSide;
                }).reduce((integer, integer2) -> integer + integer2).get();
        System.out.println(totalWrapping);

        int totalLength = Files.lines(new File("input.txt").toPath())
                .map(line -> {
                    IntStream intStream = Stream.of(line.split("x")).mapToInt(Integer::valueOf);
                    int[] lwh = intStream.sorted().toArray();
                    int minPerimeter = 2 * (lwh[0] + lwh[1]);
                    return lwh[0] * lwh[1] * lwh[2] + minPerimeter;
                }).reduce((integer, integer2) -> integer + integer2).get();
        System.out.println(totalLength);
    }
}
