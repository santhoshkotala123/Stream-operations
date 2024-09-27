package Streem;

import java.util.List; //
import java.util.Optional;
import java.util.stream.Collectors; // Import Collectors for collecting stream results
import java.util.stream.Stream;

public class StreamOperationsExample {

    public static void main(String[] args) {
        // Sample list of names
        List<String> names = List.of("Santhosh", "John", "Sarah", "Adam", "Alice", "Steve", "Sarah");
        // Sample list of numbers
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 2, 4);

        // 1. Filter: Get names that start with 'S'
        List<String> filteredNames = names.stream()
                                          .filter(name -> name.startsWith("S")) // Condition to filter names
                                          .collect(Collectors.toList()); // Collect results into a list
        System.out.println("1.Filtered Names: " + filteredNames);

        // 2. Map: Convert all names to uppercase
        List<String> upperCaseNames = names.stream()
                                           .map(String::toUpperCase) // Convert each name to uppercase
                                           .collect(Collectors.toList());
        System.out.println("2.Uppercase Names: " + upperCaseNames);

        // 3. Distinct: Remove duplicate numbers
        List<Integer> distinctNumbers = numbers.stream()
                                              .distinct() // Remove duplicates
                                              .collect(Collectors.toList());
        System.out.println("3.Distinct Numbers: " + distinctNumbers);

        // 4. Sorted: Sort names alphabetically
        List<String> sortedNames = names.stream()
                                        .sorted() // Sort names
                                        .collect(Collectors.toList());
        System.out.println("4.Sorted Names: " + sortedNames);

        // 5. Limit: Get only the first 3 names
        List<String> limitedNames = names.stream()
                                         .limit(3) // Limit to the first 3 names
                                         .collect(Collectors.toList());
        System.out.println("5.Limited Names: " + limitedNames);

        // 6. Skip: Skip the first 2 names
        List<String> skippedNames = names.stream()
                                         .skip(2) // Skip the first 2 names
                                         .collect(Collectors.toList());
        System.out.println("6.Skipped Names: " + skippedNames);

        // 7. Collect: Join all names into a single string
        String singleRow = names.stream()
                                .collect(Collectors.joining(", ")); // Join names with a comma
        System.out.println("7.All Names in Single Row: " + singleRow);

        // 8. ForEach: Print each name
        System.out.print("8.Names using forEach: ");
        names.stream().forEach(System.out::println); // Print each name on a new line

        // 9. Reduce: Calculate the sum of numbers
        int sum = numbers.stream()
                         .reduce(0, Integer::sum); // Sum all numbers
        System.out.println("9.Sum of Numbers: " + sum);

        // 10. Count: Count the total number of names
        long count = names.stream().count(); // Get the count of names
        System.out.println("10.Count of Names: " + count);

        // 11. AnyMatch: Check if any name starts with 'S'
        boolean anyMatch = names.stream().anyMatch(name -> name.startsWith("S")); // Check condition
        System.out.println("11.Any name starts with 'S': " + anyMatch);

        // 12. FindFirst: Find the first name in the list
        Optional<String> firstName = names.stream().findFirst(); // Get the first name
        firstName.ifPresent(name -> System.out.println("12.First Name: " + name)); // Print if present

        // 13. Parallel Stream: Process names in parallel
        List<String> parallelNames = names.parallelStream() // Create a parallel stream
                                          .map(String::toUpperCase) // Convert to uppercase
                                          .collect(Collectors.toList());
        System.out.println("13.Parallel Stream Names: " + parallelNames);

        // 14. Infinite Stream: Generate an infinite stream of numbers
        System.out.println("14.Infinite Stream Example:");
        Stream.iterate(0, n -> n + 1) // Start from 0 and increment by 1
              .limit(5) // Limit to the first 5 numbers
              .forEach(System.out::println); // Print each number
    }
}
