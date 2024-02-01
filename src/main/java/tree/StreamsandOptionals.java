package tree;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.Integer;
import java.util.stream.Stream;

import org.checkerframework.checker.fenum.qual.SwingTitlePosition;

public class StreamsandOptionals {
      public static int sumOdd(List<Integer> numbers) {
        if(numbers==null || numbers.isEmpty()) {
            throw new IllegalArgumentException("list should not be empty");
        }
        return numbers.stream()
                      .filter(n -> n % 2 != 0)
                      .mapToInt(Integer::intValue)
                      .sum();
    }

public   record  ImmutablePair<T1, T2>(T1 first,T2 second) {
    
        public T1 getFirst() {
            return first;
        }

        public T2 getSecond() {
            return second;
        }
    }

    public static ImmutablePair<Long, Double> someCalculation(List<Double> lst) {
        // Calculate the number of elements in the range [0.2, Math.PI]
        if(lst==null || lst.isEmpty()) {
            throw new IllegalArgumentException("list should not be empty");
        }
        Long countInRange = lst.stream().filter(value -> value >= 0.2 && value <= Math.PI).count();

        // Calculate the average of values in the range [10, 100]
        double averageInRange = lst.stream()
                .filter(value -> value >= 10 && value <= 100)
                .mapToDouble(Double::doubleValue)
                .average()
                .orElse(0.0);

        // Create and return an ImmutablePair with the results
        return new ImmutablePair<>(countInRange, averageInRange);
    }
    public static <T> List<T> repl(List<T> xs, int n) {
        if(n < 0) {
            throw new IllegalArgumentException("n must be non-negative");
        }
        if(n == 0) {
            return xs;
        }
        if(xs==null || xs.isEmpty()) {
            throw new IllegalArgumentException("list should not be empt");
        }
        return IntStream.range(0, n)
                .mapToObj(i -> xs)
                .flatMap(List::stream)
                .collect(Collectors.toList());
    }
    
    public static List<String> titlecase(List<String> strings) {
        if(strings==null || strings.isEmpty()) {
            throw new IllegalArgumentException("list should not be empty");
        }
        return strings.stream()
                .map(s -> s.startsWith("a") ? s.substring(0, 1).toUpperCase() + s.substring(1) : s)
                .collect(Collectors.toList());
    }
    
    public static void replaceWord(String fileName, String word, String repl) throws IOException{
        if(fileName==null || word==null || repl==null) {
            throw new IllegalArgumentException("file name, word and replacement should not be null");
        }
        Path path = Paths.get(fileName);

        try {
            List<String> replacedLines = Files.lines(path)
                    .map(line -> line.replaceAll("\\b" + word + "\\b", repl))
                    .collect(Collectors.toList());

            Files.write(path, replacedLines);
            System.out.println(replacedLines);
            System.out.println("Replacement completed successfully.");

        } catch (IOException e) {
            System.err.println("An error occurred while replacing the word: " + e.getMessage());
        }
    }

          // Partial function getElement
          public static Optional<Integer> getElement(int[] arr, int index) {
            if(arr==null) {
                throw new IllegalArgumentException("arr should not be null");
            }
            if (index >= 0 && index < arr.length) {
                return Optional.of(arr[index]);
            } else {
                return Optional.empty();
            }
        }
    
        // Partial function sqrt
        public static Optional<Double> sqrt(int n) {
            if(n>Integer.MAX_VALUE || n<Integer.MIN_VALUE) {
                throw new IllegalArgumentException("n should be valid number");
            }
            if (n > 0) {
                return Optional.of(Math.sqrt(n));
            } else {
                return Optional.empty();
            }
        }
    
        // Partial function half
        public static Optional<Integer> half(int n) {
            if(n>Integer.MAX_VALUE || n<Integer.MIN_VALUE||n==0) {
                throw new IllegalArgumentException("n should be valid number");
            }
            if (n % 2 == 0) {
                return Optional.of(n / 2);
            } else {
                return Optional.empty();
            }
        }
    
        // Composition of getElement, sqrt, and half
        public static Optional<Double> composedFunction(int[] arr, int index) {
            if(arr==null) {
                throw new IllegalArgumentException("arr should not be null");
            }
            return getElement(arr, index)
                    .flatMap(StreamsandOptionals::half)
                    .flatMap(StreamsandOptionals::sqrt);
        }
        public static class Subscriber {
            private String id;
            private String firstName;
            private String surname;
            private String dateOfBirth;
            private boolean subscriptionPaid;
            private Optional<String> title;
            private Optional<String> address;
            private Optional<String> town;
            private Optional<String> country;
            private Optional<String> postcode;
            private Optional<String> gender;
        
            // Constructors, getters, setters, etc. for the Subscriber class...
        
           
        public Subscriber(String id, String firstName, String surname, Optional<String> title, Optional<String> address, Optional<String> town,
                          Optional<String> country, Optional<String> postcode, boolean subscriptionPaid, Optional<String> gender,  String dateOfBirth) {
            this.id = id;
            this.firstName = firstName;
            this.surname = surname;
            this.dateOfBirth = dateOfBirth;
            this.subscriptionPaid = subscriptionPaid;
            this.title = title;
            this.address = address;
            this.town = town;
            this.country = country;
            this.postcode = postcode;
            this.gender = gender;
        }
        public Subscriber(){}

       
        public static List<Subscriber> loadDatabase(String filename) throws IOException {
            List<Subscriber> subscribers = new ArrayList<>();
            try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
                String line;

                while ((line = reader.readLine()) != null) {
                    if(line.contains("firstname")){
                        continue;
                    }
                    String[] parts = line.split(",");
                    Subscriber subscriber = new Subscriber(parts[0].trim(),parts[1].trim(), parts[2].trim(),Optional.ofNullable(parts[3].trim()),
                            Optional.ofNullable(parts[4]), Optional.ofNullable(parts[5]), Optional.ofNullable(parts[6].trim()),
                            Optional.ofNullable(parts[7]), parts[8].trim() == "true", Optional.ofNullable(parts[9].trim()),
                            parts[10].trim());

                    subscribers.add(subscriber);
                }
            }
            return subscribers;
        }

        public static void PaymentFromGB(List<Subscriber> subscribers) {
            subscribers.stream()
                    .filter(Subscriber::isSubscriptionPaid)
                    .filter(sub -> sub.getCountry().orElse("").equalsIgnoreCase("GB"))
                    .forEach(System.out::println);
        }


        public boolean isSubscriptionPaid() {
            return subscriptionPaid;
        }

        public Optional<String> getCountry() {
            return country;
        }
}
}
