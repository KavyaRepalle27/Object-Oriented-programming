package tree;
import tree.StreamsandOptionals;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.Flow.Subscriber;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.math.BigDecimal;
import java.util.*;
import java.util.function.*;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;



public class StreamsandOptionalsTest {
     /**
     * A test class for {@link StreamsandOptionals}.
     */
 
    @Test
    public void testSumOdd() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        int result = tree.StreamsandOptionals.sumOdd(numbers);

        assertEquals(25, result); // The sum of odd numbers (1 + 3 + 5 + 7 + 9) is 25
    }

    
    @Test
    public void testImmutablePairInteger() {

       tree.StreamsandOptionals. ImmutablePair<Integer, Integer> pair = new tree.StreamsandOptionals.ImmutablePair<>(1, 2);
        assertEquals(Integer.valueOf(1), pair.getFirst());
        assertEquals(Integer.valueOf(2), pair.getSecond());
    }
    @Test
    public void testImmutablePairString() {
        tree.StreamsandOptionals. ImmutablePair<String, String> pair = new tree.StreamsandOptionals. ImmutablePair<>("first", "second");
        assertEquals("first", pair.getFirst());
        assertEquals("second", pair.getSecond());
    }

    @Test
    public void testImmutablePairMixed() {
        tree.StreamsandOptionals. ImmutablePair<Integer, String> pair = new tree.StreamsandOptionals. ImmutablePair<>(1, "second");
        assertEquals(Integer.valueOf(1), pair.getFirst());
        assertEquals("second", pair.getSecond());
    }

    @Test
    public void testsomeCalculation() {
       
        List<Double> values = List.of(0.5, 1.5, 2.5, 15.0, 25.0, 35.0, 45.0, 55.0, 65.0, 75.0, 85.0, 95.0);
        tree.StreamsandOptionals.ImmutablePair<Long, Double> result = tree.StreamsandOptionals.someCalculation(values);

        // Assert tests
        assertEquals(3, result.first());
        assertEquals(55, result.getSecond());
       
    }
    @Test
    public void testrepl() {
        List<Integer> list = List.of(1, 2, 3);
        List<Integer> result = tree.StreamsandOptionals.repl(list, 3);
        assertEquals(List.of(1, 2, 3, 1, 2, 3, 1, 2, 3), result);
        List<Integer> list1 = List.of(1, 2, 3);
        List<Integer> result1 = tree.StreamsandOptionals.repl(list1, 0);
        assertEquals(List.of(1, 2, 3), result1);
        List<Integer> list2 = null;
      
         try{
            List<Integer> result2= tree.StreamsandOptionals.repl(null, 4);
                    Assert.fail(); } catch ( IllegalArgumentException e ) {}
    }
    @Test
    public void testtitlecase() {
        List<String> strings = List.of("apple", "banana", "cherry");
        List<String> result = tree.StreamsandOptionals.titlecase(strings);
        assertEquals(List.of("Apple", "banana", "cherry"), result);
        
        List<String> string2=null;
        try{
            List<String> result2= tree.StreamsandOptionals.titlecase(null);
                    Assert.fail(); } catch ( IllegalArgumentException e ) {}
        
        List<String> string3= List.of();
        try{
            List<String> result3= tree.StreamsandOptionals.titlecase(string3);
                    Assert.fail(); } catch ( IllegalArgumentException e ) {}
        
    }
  
    @Test
    public void testreplace() throws IOException {
        Path tempFile = Files.createTempFile("testFile", ".txt");

        // Write some content to the file
        List<String> originalLines = List.of("This is a true statement.", "Another true example.", "Not affected line.");
        Files.write(tempFile, originalLines);

        // Replace the word "true" with "false"
        tree.StreamsandOptionals.replaceWord(tempFile.toString(), "true", "false");

        // Read the modified lines from the file
        List<String> modifiedLines = Files.readAllLines(tempFile);

        // Assert the modifications
        assertEquals("This is a false statement.", modifiedLines.get(0));
        assertEquals("Another false example.", modifiedLines.get(1));
        assertEquals("Not affected line.", modifiedLines.get(2));

    
 
       
       
    }
    @Test
    public void testreplace1() throws IOException {
        try{
       String fileName = "C:\\oopsmy\\demo\\demo\\src\\test\\java\\tree\\people.csv";

        // Write some content to the file

        // Replace the word "true" with "false"
        tree.StreamsandOptionals.replaceWord(fileName.toString(), "true", "false");
        
        System.out.println("Test for replaceWord:");
     
            tree.StreamsandOptionals.replaceWord(fileName, "true", "false");
        } catch (IOException e) {
            e.printStackTrace();
        } 
       
    }
    @Test
    public void testGetElement() {
        int[] arr = {1, 2, 3, 4, 5};

        // Testing valid index
        assertEquals(Optional.of(3), tree.StreamsandOptionals.getElement(arr, 2));

        // Testing invalid index
        assertEquals(Optional.empty(), tree.StreamsandOptionals.getElement(arr, 10));
    }

    @Test
    public void testSqrt() {
        // Testing valid input
        assertEquals(Optional.of(2.0), tree.StreamsandOptionals.sqrt(4));

        // Testing invalid input (negative number)
        assertEquals(Optional.empty(), tree.StreamsandOptionals.sqrt(-1));
    }

    @Test
    public void testHalf() {
        // Testing valid input (even number)
        assertEquals(Optional.of(2), tree.StreamsandOptionals.half(4));

        // Testing invalid input (odd number)
        assertEquals(Optional.empty(), tree.StreamsandOptionals.half(3));
    }

    @Test
    public void testComposedFunction() {
        int[] arr = {4, 9, 8, 25};

        // Testing a valid scenario
        assertEquals(Optional.of(1.4142135623730951), tree.StreamsandOptionals.composedFunction(arr, 0));
        assertEquals(Optional.of(2.0), tree.StreamsandOptionals.composedFunction(arr, 2));
        try {
            tree.StreamsandOptionals.composedFunction(null, 2);
           Assert.fail(); } catch ( IllegalArgumentException e ) {}
        // Testing an invalid scenario (index out of bounds)
        assertEquals(Optional.empty(), tree.StreamsandOptionals.composedFunction(arr, 10));

        // Testing an invalid scenario (odd number)
        assertEquals(Optional.empty(), tree.StreamsandOptionals.composedFunction(arr, 1));
    }
    @Test
    public void testLoadDatabase() throws IOException {
//
        try{
    List<tree.StreamsandOptionals.Subscriber> subscribers = tree.StreamsandOptionals.Subscriber.loadDatabase("C:\\oopsmy\\demo\\demo\\src\\test\\java\\tree\\people.csv");
    assertEquals(6, subscribers.size());
       
}
        catch (IOException e) { }
        

    }
     @Test
    void testPaymentFromGB() throws IOException  {
        try {
            List<tree.StreamsandOptionals.Subscriber> subscribers =tree.StreamsandOptionals.Subscriber.loadDatabase("C:\\oopsmy\\demo\\demo\\src\\test\\java\\tree\\people.csv");
            assertNotNull(subscribers);
            assertFalse(subscribers.isEmpty());

            // Call the method under test
            System.out.println("Subscribers from GB who have paid the annual fee:");
            tree.StreamsandOptionals.Subscriber.PaymentFromGB(subscribers);

            // You might want to add more specific assertions based on your file content and structure
        } catch (IOException e) {
           
        }
        try{
           
            List<tree.StreamsandOptionals.Subscriber> subscribers = new ArrayList<>();
            subscribers = tree.StreamsandOptionals.Subscriber.loadDatabase("C:\\oopsmy\\demo\\demo\\src\\test\\java\\tree\\people.csv");
    
            tree.StreamsandOptionals.Subscriber subscriber = new tree.StreamsandOptionals.Subscriber();
            ByteArrayOutputStream payFrom  = new ByteArrayOutputStream();
            System.setOut(new PrintStream(payFrom));
            
            subscriber.PaymentFromGB(subscribers);
        }
    
         catch (IOException e) {
        
       
    }

   
    }
 
}


 



