package CPS_393_Lab.exercise10;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.*;
import java.util.function.*;
import java.util.Map;

/** The goal of this practice is not to "get the answer" through AI or some other means, but for you to think through the questions and
* come up with a strategy. You can decide not to do it at your own cost.
*/

/**
* In the following, write code to achieve what's asked. You don't need to but if you want to very the accuracy of your code,
* include statements to print the result.
*/

/**
 * Submit to the TA, and he will assign you a grade based on a few selected
 * responses.
 */

public class Week10_labs {
    public static void main(String[] args) {
        List<String> fruit = Arrays.asList("cherry", "banana", "berry", "apple", "cherry", "kiwi", "fig", "date",
                "lemon", "honeydew", "cherry", "elderberry", "apple", "banana", "grape");

        // Collect elements into a Set
        Set<String> fruitSet = fruit.stream().collect(Collectors.toSet());
        System.out.println(fruitSet);
        System.out.println();
        System.out.println("__________________________________________________");
        System.out.println();

        // Collect the fruit into groups based on their first character
        Map<Character, List<String>> fruitFirstChar = fruit.stream().collect(Collectors.groupingBy(s -> s.charAt(0)));
        System.out.println(fruitFirstChar);
        System.out.println();
        System.out.println("__________________________________________________");
        System.out.println();

        // Group fruit by the length of the name
        Map<Integer, List<String>> nameLength = fruit.stream().collect(Collectors.groupingBy(String::length));
        System.out.println(nameLength);
        System.out.println();
        System.out.println("__________________________________________________");
        System.out.println();

        // Collect the fruit that has erry in it
        List<String> hasErry = fruit.stream().filter(s -> s.contains("erry")).collect(Collectors.toList());
        System.out.println(hasErry);
        System.out.println();
        System.out.println("__________________________________________________");
        System.out.println();

        // Create a partition of fruit based on if it contains erry
        Map<Boolean, List<String>> containsErry = fruit.stream()
                .collect(Collectors.partitioningBy(s -> s.contains("erry")));
        System.out.println(containsErry);
        System.out.println();
        System.out.println("__________________________________________________");
        System.out.println();

        // collect/ the fruit that has 5 or less symbols
        List<String> lessThan5Symbol = fruit.stream().filter(s -> s.length() <= 5).collect(Collectors.toList());
        System.out.println(lessThan5Symbol);
        System.out.println();
        System.out.println("__________________________________________________");

        // find the total number of symbols in all the fruit stored
        // int sumSymbol =
        // fruit.stream().map(s->s.length()).mapToInt(Integer::intValue).sum();
        int sumSymbol = fruit.stream().mapToInt(String::length).sum();
        System.out.println(sumSymbol);
        System.out.println();
        System.out.println("__________________________________________________");
        System.out.println();

        List<Integer> data = Arrays.asList(87, 23, 45, 100, 6, 78, 92, 44, 13, 56, 34, 99, 82, 19, 1012, 78, 45, 90, 23,
                56, 78, 100, 3, 43, 67, 89, 21, 34, 10);

        // Partition data based on if >=50
        Map<Boolean, List<Integer>> partData = data.stream().collect(Collectors.partitioningBy(d -> d >= 50));
        System.out.println(partData);
        System.out.println();
        System.out.println("__________________________________________________");
        System.out.println();

        // divide data into groups based on the remainder when divided by 7
        Map<Integer, List<Integer>> divBy7 = data.stream().collect(Collectors.groupingBy(n -> n % 7));
        System.out.println(divBy7);
        System.out.println();
        System.out.println("__________________________________________________");
        System.out.println();

        // find the sum of the data
        int sumData = data.stream().mapToInt(Integer::intValue).sum();
        System.out.println(sumData);
        System.out.println();
        System.out.println("__________________________________________________");

        // collect the unique values
        Set<Integer> uniques = data.stream().collect(Collectors.toSet());
        System.out.println(uniques);
        System.out.println();
        System.out.println("__________________________________________________");

        // compute the cube of each values
        List<Integer> cubeComputing = data.stream().map(n -> n * n * n).collect(Collectors.toList());
        System.out.println(cubeComputing);
        System.out.println();
        System.out.println("__________________________________________________");

        // find the sum of the cubes of each value
        int cubeSum = data.stream().map(n -> n * n * n).mapToInt(Integer::intValue).sum();
        System.out.println(cubeSum);
        System.out.println();
        System.out.println("__________________________________________________");

        // increase the value of each element by 5
        List<Integer> add5 = data.stream().map(n -> n + 5).collect(Collectors.toList());
        System.out.println(add5);
        System.out.println();
        System.out.println("__________________________________________________");

        // compute the cube of the even values
        Predicate<Integer> evenNum = n -> n % 2 == 0;
        List<Integer> evenComputing = data.stream().filter(evenNum).map(n -> n * n * n).collect(Collectors.toList());
        System.out.println(evenComputing);
        System.out.println();

    }
}
