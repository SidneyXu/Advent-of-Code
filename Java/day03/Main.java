import java.io.File;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) throws Exception {
        List<Integer> currentLocation = Arrays.asList(0, 0);

        Stream houses = Files.lines(new File("input.txt").toPath())
                .flatMap(line -> Stream.of(line.split("")))
                .map(s -> {
                    matchPath(s, currentLocation);
                    return new ArrayList<>(currentLocation);
                }).distinct();
        System.out.println(houses.count());

        List<Integer> santa = Arrays.asList(0, 0);
        List<Integer> robot = Arrays.asList(0, 0);
        List<String> paths = Files.lines(new File("input.txt").toPath())
                .flatMap(line -> Stream.of(line.split("")))
                .collect(Collectors.toList());
        Stream houses2 = IntStream.range(0, paths.size())
                .mapToObj(i -> {
                    if (i % 2 == 0) {
                        matchPath(paths.get(i), santa);
                    } else {
                        matchPath(paths.get(i), robot);
                    }
                    return Arrays.asList(santa, robot);
                }).flatMap(lists -> Stream.of(lists.get(0), lists.get(1)))
                .distinct();
        System.out.println(houses2.count());
    }

    private static void matchPath(String path, List<Integer> role) {
        switch (path) {
            case "^":
                role.set(1, role.get(1) + 1);
                break;
            case "v":
                role.set(1, role.get(1) - 1);
                break;
            case ">":
                role.set(0, role.get(0) + 1);
                break;
            case "<":
                role.set(0, role.get(0) - 1);
                break;
        }
    }
}
