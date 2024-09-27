package Streem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class StreemOperationsDemo {

    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));

        // 1. For-each: Print each element
        System.out.println("1.For-each:");
        numbers.stream().forEach(e -> System.out.println(e));

        // 2. Filter: Print even numbers
        System.out.println("\n2.Filter (even numbers):");
        numbers.stream()
               .filter(e -> e % 2 == 0)
               .forEach(e -> System.out.println(e));

        // 3. Map: Print square of each number
        System.out.println("\n3.Map (squares):");
        numbers.stream()
               .map(e -> e * e)
               .forEach(e -> System.out.println(e));

        // 4. FlatMap: Multiply each element by 2 and 3, then flatten
        System.out.println("\n4.FlatMap:");
        numbers.stream()
               .flatMap(e -> List.of(e * 2, e * 3).stream())
               .forEach(e -> System.out.println(e));

        // 5. Distinct: Remove duplicates
        System.out.println("\n5.Distinct:");
        List<Integer> numbersWithDuplicates = new ArrayList<>(Arrays.asList(1, 2, 2, 3, 4, 4, 5, 6, 6));
        numbersWithDuplicates.stream()
                             .distinct()
                             .forEach(e -> System.out.println(e));

        // 6. Limit: Limit to the first 5 elements
        System.out.println("\n6.Limit:");
        numbers.stream()
               .limit(5)
               .forEach(e -> System.out.println(e));

        // 7. Skip: Skip the first 3 elements
        System.out.println("\n7.Skip:");
        numbers.stream()
               .skip(3)
               .forEach(e -> System.out.println(e));

        // 8. Collect: Collect into a list of even numbers
        System.out.println("\n8.Collect (even numbers list):");
        List<Integer> evenNumbers = numbers.stream()
                                           .filter(e -> e % 2 == 0)
                                           .collect(Collectors.toList());
        System.out.println(evenNumbers);

        // 9. Count: Count the total elements
        System.out.println("\n9.Count:");
        long count = numbers.stream().count();
        System.out.println(count);

        // 10. AnyMatch: Check if there's any element greater than 8
        System.out.println("\n10.AnyMatch (greater than 8):");
        boolean anyGreaterThanEight = numbers.stream()
                                             .anyMatch(e -> e > 8);
        System.out.println(anyGreaterThanEight);

        // 11. AllMatch: Check if all elements are greater than 0
        System.out.println("\n11.AllMatch (all > 0):");
        boolean allGreaterThanZero = numbers.stream()
                                            .allMatch(e -> e > 0);
        System.out.println(allGreaterThanZero);

        // 12. NoneMatch: Check if no elements are negative
        System.out.println("\n12.NoneMatch (no negatives):");
        boolean noneNegative = numbers.stream()
                                      .noneMatch(e -> e < 0);
        System.out.println(noneNegative);

        // 13. FindFirst: Get the first element
        System.out.println("\n13.FindFirst:");
        Optional<Integer> firstElement = numbers.stream().findFirst();
        firstElement.ifPresent(System.out::println);

    }
}
