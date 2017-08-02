package com.inteview.corejava;

import com.inteview.corejava.stream.Status;
import com.inteview.corejava.stream.Task;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by linxing on 30/07/2017.
 */
public class StreamTest {
    public List<Task> tasks;

    @Before
    public void init() {
        tasks = Arrays.asList(
                new Task(Status.OPEN, 9),
                new Task(Status.OPEN, 10),
                new Task(Status.CLOSED, 12)
        );
    }

    @Test
    public void createTest() {
        String[] myArray = new String[]{"bob", "alice", "paul", "ellie"};
        Stream<String> myStream = Arrays.stream(myArray);

        System.out.println(myStream);

        long totalPointOfOpenTasks = tasks
                .stream()
                .filter(task -> task.getStatus() == Status.OPEN)
                .mapToInt(Task::getPoints)
                .sum();

        System.out.println("totalPointOfOpenTasks --> " + totalPointOfOpenTasks);
    }

    @Test
    public void totalPointTest() {

        long totalPoint = tasks
                .stream()
                .parallel()
                .map(task -> task.getPoints())
                .reduce(0, Integer::sum);

        System.out.println("totalPoint --> " + totalPoint);

    }

    @Test
    public void groupTest() {
        Map<Status, List<Task>> taskMap = tasks
                .stream()
                .collect(Collectors.groupingBy(Task::getStatus));

        System.out.println(taskMap);
    }

    @Test
    public void averageTest() {
        final double totalPoints = tasks
                .stream()
                .parallel()
                .map(task -> task.getPoints()) // or map( Task::getPoints )
                .reduce(0, Integer::sum);

        List<String> avg = tasks
                .stream()                                       // Stream <String>
                // .map(Task::getPoints)                        // IntStream
                .mapToInt(Task::getPoints)                      // IntStream
                .asLongStream()                                 // LongStream
                .mapToDouble(point -> point / totalPoints)      // DoubleStream
                .boxed()                                        // Stream<Double>
                .mapToLong(weight -> (long) (weight * 100))     // LongStream
                .mapToObj(percentage -> percentage + "%")       // Stream<String>
                .collect(Collectors.toList());                  // List<String>

        System.out.println("avg --> " + avg);

    }


    @Test
    public void fileTest() throws IOException {

        String filename = "src/test/resources/static/streamtest.txt";

        final Path path = new File(filename).toPath();

        try (Stream<String> lines = Files.lines(path, StandardCharsets.UTF_8)) {
            lines.onClose(() -> System.out.println("Done!")).forEach(System.out::println);
        }
    }

    @Test
    public void minTest() {
        //int
        int min1 = Arrays.stream(new int[]{1, 2, 3, 4, 5}).min().orElse(0);
        System.out.println(min1);

        int min2 = Arrays.stream(new int[]{}).min().orElse(0);
        System.out.println(min2);

    }

    @Test
    public void mapTest() {
        List<Integer> listOfInt = Stream.of("1", "2", "3", "4")
                .map(Integer::valueOf)
                .collect(Collectors.toList());

        System.out.println(listOfInt);
    }

    @Test
    public void flatMapTest() {
        List numbers = Stream.of(
                Arrays.asList("1"),
                Arrays.asList("2"),
                Arrays.asList("3"))
                .flatMap(list -> list.stream())
                .collect(Collectors.toList());

        System.out.println(numbers);

        Optional<String> s = Optional.of("input");
        System.out.println(s.map(StreamTest::getOutput));
        System.out.println(s.flatMap(StreamTest::getOutputOpt));

    }

    @Test
    public void toListTest() {

        List<Status> openList = tasks.stream()
                .map(Task::getStatus)
                .collect(Collectors.toList());

        System.out.println(openList);

    }

    @Test
    public void toMapTest() {

        Map<Status, List<Task>> taskMap = tasks
                .stream()
                .collect(Collectors.groupingBy(Task::getStatus));

        System.out.println(taskMap);
    }


    @Test
    public void reduceTest() {

        final List<Integer> numbers = Arrays.asList(1, 2, 3, 4);
        final Optional<Integer> sum = numbers.stream()
                .reduce((a, b) -> a + b);

        System.out.println(sum);
        sum.orElseGet(() -> 0);

        String[] myArray = {"this", "is", "a", "sentence"};
        String result = Arrays.stream(myArray)
                .reduce("", (a, b) -> a + b);

        System.out.println(result);
    }

    @Test
    public void stringValueTest(){
        String[] myArray = {"this", "is", "a", "sentence"};
        String result = Arrays.stream(myArray)
                .reduce("", (a, b) -> a +" "+ b);
        System.out.println(result);
    }

    @Test
    public void captialLetterSortTest(){
        String[] names = { "Fred Edwards", "Anna Cox", "Deborah Patterson", "Ruth Torres", "Shawn Powell",
                "Rose Thompson", "Rachel Barnes", "Eugene Ramirez", "Earl Flores", "Janice Reed", "Sarah Miller",
                "Patricia Kelly", "Carl Hall", "Craig Wright", "Martha Phillips", "Thomas Howard", "Steve Martinez",
                "Diana Bailey", "Kathleen Hughes", "Russell Anderson", "Theresa Perry" };
        Arrays.asList(names)
                .stream()
                .map(String::toUpperCase)
                .sorted().forEach(System.out::println);
    }

    @Test
    public void boxedTest(){
        List<Integer> list = IntStream.range(1, 100).boxed().collect(Collectors.toList());
        System.out.println(list.stream().count());
    }

    static Optional<String> getOutputOpt(String input) {
        return input == null ? Optional.empty() : Optional.of("output for " + input);
    }

    static String getOutput(String input) {
        return input == null ? null : "output for " + input;
    }


    public void testString(){
        StringBuilder stringBuilder = new StringBuilder();
    }
}
