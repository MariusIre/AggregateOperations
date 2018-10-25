package ro.jademy.StreamSample.Ex1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class StreamsEx {

    public static void main(String[] args) {

        //create a list of string lowercase animal names
        List<String> animalNames = new ArrayList<>();
        animalNames.add("cat");
        animalNames.add("dog");
        animalNames.add("monkey");
        animalNames.add("rhino");
        animalNames.add("lion");

        System.out.println("Print each element in the list.");

        Stream<String> animalStream = animalNames.stream(); // can only be used once

        animalStream.forEach( name -> System.out.println("Animal: " + name));


        System.out.println("\nFilter out some animals and the print them.");
        animalNames.stream()
                .peek( name -> System.out.println("Peek before filter:" + name))
                .filter( name -> name.length() > 4)
                .peek( name -> System.out.println("Peek after filter:" + name))
                .forEach( name -> System.out.println("Animal: " + name));


        System.out.println("\nTransform all the animal names to uppercase using map() and then print them.");

        Function<String,String> firstLettertoUpperCase = name -> name.substring(0,1).toUpperCase() + name.substring(1);

        animalNames.stream()
                .map(firstLettertoUpperCase)
                .forEach(name -> System.out.println("Animal: " + name));


        System.out.println("\nSort animals and then print them.");
        Comparator<String> stringComp = (nameOne,nameTwo) -> {
            if(nameOne.length() == nameTwo.length()){
                return 0;
            }
            if(nameOne.length() > nameTwo.length()){
                return 1;
            }
            return -1;
        };
        animalNames.stream()
                .sorted(stringComp)
                .forEach(name -> System.out.println("Animal: " + name));


        System.out.println("\nFind out which animal name has the most letters using streams.");
        System.out.println("Biggest string in our list: " + animalNames.stream().max(stringComp).orElse("No max"));
        System.out.println("Biggest string in our list: " + animalNames.stream().max(stringComp).get());
    }
}
