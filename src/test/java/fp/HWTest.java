package fp;

import java.math.BigDecimal;
import java.util.*;
import java.util.function.*;
import org.junit.Assert;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import fp.HW.Person;



public class HWTest {


/**
 * A test class for {@link HW}.
 *
 */
    @Test
    public void ziptest(){
        List<Integer> l1 = Arrays.asList(1, 2, 3);
        List<String> l2 = Arrays.asList("A", "B", "C");
        List<Integer> l3 = List.of(7, 8, 9, 11);

        List<pair<Integer, String>> result = HW.zip(l1, l2);

        // Test case 1: Check if the size of the result list is correct
        assertEquals(Math.min(l1.size(), l2.size()), result.size());

        // Test case 2: Check individual pairs
        assertEquals(new pair<>(1, "A"), result.get(0));
        assertEquals(new pair<>(2, "B"), result.get(1));
        assertEquals(new pair<>(3, "C"), result.get(2));
        Assertions.assertThrows(IllegalArgumentException.class, () -> HW.zip(l1, l3));
        System.out.println("All test cases passed for zip method!");
       
    }

    @Test
    public void testMap(){
        List<Integer> inputList = Arrays.asList(1, 2, 3, 4, 5);

        // Test case: Map each element to its square
        List<Integer> result = HW.map(inputList, x -> x * x);

        // Expected output: [1, 4, 9, 16, 25]
        List<Integer> expected = Arrays.asList(1, 4, 9, 16, 25);

        // Assert that the result matches the expected output
        assertEquals(expected, result);

        System.out.println("Test case passed for map method!");
        try{
            List<Integer> result1 = HW.map(null,null);
            Assert.fail(); } catch ( IllegalArgumentException e ) {}
    }
    @Test
    public void testFlatMap(){
        List<Integer> inputList = Arrays.asList(1, 2, 3, 4, 5);

        // Test case: FlatMap each element to a list containing its square and cube
        List<Integer> result = HW.flatmap(inputList, x -> Arrays.asList(x * x, x * x * x));

        // Expected output: [1, 1, 4, 8, 9, 27, 16, 64, 25, 125]
        List<Integer> expected = Arrays.asList(1, 1, 4, 8, 9, 27, 16, 64, 25, 125);

        // Assert that the result matches the expected output
        assertEquals(expected, result);
        try{
            List<Integer> result1= HW.flatmap(null,null);
            Assert.fail(); } catch ( IllegalArgumentException e ) {}

        System.out.println("Test case passed for flatmap method!");
    }
    @Test
    public void testFoldLeft(){
        int sum = 0;

        List<Integer> s = List.of(1, 2, 3, 4, 5);
        List<String> list = List.of("kavya", "repalle");

        sum = HW.foldLeft(sum, s, (x, y) -> x + y);
        String name = HW.foldLeft("", list, (x, y) -> x + y);
        String expectedName = "kavyarepalle";

        assertEquals(15, sum);
        assertEquals(expectedName, name);
        try{
           String result = HW.foldLeft(null,null,null);
            Assert.fail(); } catch ( IllegalArgumentException e ) {}
    }
    @Test
    public void testFoldRight(){
        int mul = 1;

        List<Integer> s = List.of(1, 2, 3, 4, 5);
        List<String> list = List.of("kavya", "repalle");

        mul = HW.foldRight(mul, s, (x, y) -> x * y);
        String name = HW.foldRight("", list, (x, y) -> y + x);
        String expectedName = "repallekavya";

        assertEquals(120, mul);
        assertEquals(expectedName, name);
        try{
            String result = HW.foldRight(null,null,null);
            Assert.fail(); } catch ( IllegalArgumentException e ) {}
        System.out.println("Test case passed for foldRight method!");
    }
    @Test
    public void testExists(){
        List<Integer> inputList = Arrays.asList(1, 2, 3, 4, 5);

        // Test case 1: Check if any element is greater than 3
        Predicate<Integer> greaterThanThree = x -> x > 3;
        boolean result1 = HW.exists(inputList, greaterThanThree);

        // Expected output: At least one element (4 and 5) is greater than 3
        assertTrue(result1);

        // Test case 2: Check if any element is negative
        Predicate<Integer> isNegative = x -> x < 0;
        boolean result2 = HW.exists(inputList, isNegative);

        // Expected output: No element is negative
        assertFalse(result2);
        try{
           boolean result = HW.exists(null,null);
            Assert.fail(); } catch ( IllegalArgumentException e ) {}
        System.out.println("Test cases passed for exists method!");
    }
    @Test
    public void testFilter(){
        List<Integer> inputList = Arrays.asList(1, 2, 3, 4, 5);

        // Test case 1: Filter even numbers
        Predicate<Integer> isEven = x -> x % 2 == 0;
        List<Integer> result1 = HW.filter(inputList, isEven);

        // Expected output: [2, 4]
        assertEquals(Arrays.asList(2, 4), result1);

        // Test case 2: Filter numbers greater than 3
        Predicate<Integer> greaterThanThree = x -> x > 3;
        List<Integer> result2 = HW.filter(inputList, greaterThanThree);

        // Expected output: [4, 5]
        assertEquals(Arrays.asList(4, 5), result2);
        try{
            List<Integer> result = HW.filter(null,null);
            Assert.fail(); } catch ( IllegalArgumentException e ) {}
        System.out.println("Test cases passed for filter method!");
    }
    @Test
    public void testPrintFiltered2(){
       ArrayList<Person> list = new ArrayList<Person>();
        list.add(new Person("x", 20, true));
        list.add(new Person("y", 30, false));
        list.add(new Person("z", 40, true));

        Predicate<Person> p = (Person x) -> x.age() > 20;

        ArrayList<Person> expected = new ArrayList<Person>();
        expected.add(new Person("y", 30, false));
        expected.add(new Person("z", 40, true));

        assertEquals(expected, HW.filter(list, p));
        try{
            List<Person> result = HW.filter(null,null);
            Assert.fail(); } catch ( IllegalArgumentException e ) {}
        
    }
    
    @Test
    public void testminVal(){
        // Test case 1: List of integers
        List<Integer> intList = Arrays.asList(5, 2, 8, 1, 7);
        assert HW.minVal(intList, Integer::compare) == 1 : "Test Case 1 Failed";

        // Test case 2: List of strings
        List<String> stringList = Arrays.asList("apple", "orange", "banana", "kiwi");
        assert HW.minVal(stringList, Comparator.naturalOrder()).equals("apple") : "Test Case 2 Failed";

        try{
            int result = HW.minVal(null,null);
            Assert.fail(); } catch ( IllegalArgumentException e ) {}
        System.out.println("All test cases passed!");
    }
    @Test
    public void helloSupplier() {
        Supplier<String> helloSupplier = HW.helloSupplier();

        assertEquals("Hello", helloSupplier.get());
    }


    @Test
   
    public void isEmptyPredicate() {
        Predicate<String> isEmptyPredicate = HW.isEmptyPredicate();

        boolean nonEmptyStringResult = isEmptyPredicate.test("fasdfa");
        boolean emptyStringResult = isEmptyPredicate.test("");

        assertFalse(nonEmptyStringResult);
        assertTrue(emptyStringResult);
    }

    @Test
    public void stringMultiplier() {
        BiFunction<String, Integer, String> stringMultiplier = HW.stringMultiplier();

        String threeTimesHi = stringMultiplier.apply("Hi", 3);
        String twoTimesHello = stringMultiplier.apply("Hello", 2);

        assertEquals("HiHiHi", threeTimesHi);
        assertEquals("HelloHello", twoTimesHello);
    }

    @Test
    public void toDollarStringFunction() {
        Function<BigDecimal, String> toDollarStringFunction = HW.toDollarStringFunction();
        String tenDollarStr = toDollarStringFunction.apply(BigDecimal.TEN.setScale(2));

        assertEquals("$10.00", tenDollarStr);
    }

    @Test
    public void lengthInRangePredicate() {
        Predicate<String> lengthInRangePredicate = HW.lengthInRangePredicate(4, 10);

        boolean twoLetterStringResult = lengthInRangePredicate.test("Hi");
        boolean fourLetterStringResult = lengthInRangePredicate.test("Hola");
        boolean fiveLetterStringResult = lengthInRangePredicate.test("Amigo");
        boolean eightLetterStringResult = lengthInRangePredicate.test("Lalaland");
        boolean thirteenLetterStringResult = lengthInRangePredicate.test("Lambda rocks!");

        assertFalse(twoLetterStringResult);
        assertTrue(fourLetterStringResult);
        assertTrue(fiveLetterStringResult);
        assertTrue(eightLetterStringResult);
        assertFalse(thirteenLetterStringResult);
        try{
            Predicate<String> result = HW.lengthInRangePredicate(10,4);
            Assert.fail(); } catch ( IllegalArgumentException e ) {}
        try{
                Predicate<String> result1 = HW.lengthInRangePredicate(-10,-2);
                Assert.fail(); } catch ( IllegalArgumentException e ) {}
        try{
                    Predicate<String> result2 = HW.lengthInRangePredicate(2,2);
                    Assert.fail(); } catch ( IllegalArgumentException e ) {}
        
    }


    @Test
    public void randomIntSupplier() {
        IntSupplier randomIntSupplier = HW.randomIntSupplier();

        int firstValue = randomIntSupplier.getAsInt();
        int secondValue = randomIntSupplier.getAsInt();

        assertNotEquals(firstValue, secondValue);
    }

    @Test
    public void boundedRandomIntSupplier() {
        IntUnaryOperator boundedRandomIntSupplier = HW.boundedRandomIntSupplier();

        int randomIntLessThan10 = boundedRandomIntSupplier.applyAsInt(10);
        int randomIntLessThan100 = boundedRandomIntSupplier.applyAsInt(100);
        int randomIntLessThan1000 = boundedRandomIntSupplier.applyAsInt(1000);
        int randomIntLessThan10000 = boundedRandomIntSupplier.applyAsInt(1000);

        assertTrue(randomIntLessThan10 < 10);
        assertTrue(randomIntLessThan100 < 100);
        assertTrue(randomIntLessThan1000 < 1000);
        assertTrue(randomIntLessThan10000 < 10000);
    }

    @Test
    public void intSquareOperation() {
        IntUnaryOperator squareOperation = HW.intSquareOperation();

        int squareOfFour = squareOperation.applyAsInt(4);
        int squareOfZero = squareOperation.applyAsInt(0);

        assertEquals(16, squareOfFour);
        assertEquals(0, squareOfZero);
    }


    @Test
    public void longSumOperation() {
        LongBinaryOperator sumOperation = HW.longSumOperation();


        long sumOfSevenAndEight = sumOperation.applyAsLong(7, 8);
        long sumOfTenAndZero = sumOperation.applyAsLong(10, 0);
        long sumOfFiveAndMinusTen = sumOperation.applyAsLong(5, -10);

        assertEquals(15, sumOfSevenAndEight);
        assertEquals(10, sumOfTenAndZero);
        assertEquals(-5, sumOfFiveAndMinusTen);
    }

    @Test
    public void stringToIntConverter() {
        ToIntFunction<String> stringToIntConverter = HW.stringToIntConverter();

        int num = stringToIntConverter.applyAsInt("234");
        int negativeNum = stringToIntConverter.applyAsInt("-122");

        assertEquals(234, num);
        assertEquals(-122, negativeNum);
    }

    @Test
    public void nMultiplyFunctionSupplier() {
        Supplier<IntUnaryOperator> fiveMultiplyFunctionSupplier = HW.nMultiplyFunctionSupplier(5);

        IntUnaryOperator multiplyByFiveOperation = fiveMultiplyFunctionSupplier.get();
        int result = multiplyByFiveOperation.applyAsInt(11); // 11 * 5 = 55

        assertEquals(55, result);
    }

    @Test
    public void composeWithTrimFunction() {
        UnaryOperator<Function<String, String>> composeWithTrimFunction = HW.composeWithTrimFunction();
        Function<String, String> toLowerWithTrim = composeWithTrimFunction.apply(String::toLowerCase);
        Function<String, String> threeTimesRepeatWithTrim = composeWithTrimFunction.apply(s -> s.repeat(3));

        String hey = toLowerWithTrim.apply("  Hey ");
        String threeTimesHi = threeTimesRepeatWithTrim.apply("  Hi  ");

        assertEquals("hey", hey);
        assertEquals("HiHiHi", threeTimesHi);
    }

    
    

    @Test
    public void functionToConditionalFunction() {
        BiFunction<IntUnaryOperator, IntPredicate, IntUnaryOperator> intFunctionToConditionalIntFunction
                = HW.functionToConditionalFunction();

        IntUnaryOperator abs = intFunctionToConditionalIntFunction.apply(a -> -a, a -> a < 0);

        assertEquals(5, abs.applyAsInt(-5));
        assertEquals(0, abs.applyAsInt(0));
        assertEquals(5, abs.applyAsInt(5));
    }

    @Test
    public void functionLoader() {
        BiFunction<Map<String, IntUnaryOperator>, String, IntUnaryOperator> functionLoader = HW.functionLoader();
        Map<String, IntUnaryOperator> functionMap = new HashMap<>();
        functionMap.put("increment", x -> x + 1);
        functionMap.put("square", x -> x * x);

        IntUnaryOperator incrementFunction = functionLoader.apply(functionMap, "increment");
        IntUnaryOperator squareFunction = functionLoader.apply(functionMap, "square");
        IntUnaryOperator identityFunction = functionLoader.apply(functionMap, "none");

        assertEquals(5, incrementFunction.applyAsInt(4));
        assertEquals(9, squareFunction.applyAsInt(3));
        assertEquals(10, identityFunction.applyAsInt(10));
    }

    @Test
    public void comparing() {
        var strLengthComparator = HW.comparing(String::length);
        var stringList = new ArrayList<>(List.of("Me", "I", "All of us", "They", "She"));

        stringList.sort(strLengthComparator);

        assertEquals(stringList,List.of("I", "Me", "She", "They", "All of us"));
        try{
            var  result = HW.comparing(null);
            Assert.fail(); } catch ( IllegalArgumentException e ) {}
    }

    @Test
    public void thenComparing() {
        var strLengthComparator = Comparator.comparing(String::length);

        Comparator<String> lengthThenNaturalComparator = HW.thenComparing(strLengthComparator, s -> s);
        var stringList = new ArrayList<>(List.of("Me", "I", "All of us", "They", "She", "He"));

        stringList.sort(lengthThenNaturalComparator);
        assertEquals(stringList,List.of("I", "He", "Me", "She", "They", "All of us"));
        try{
            Comparator<String> result = HW.thenComparing(null,null);
            Assert.fail(); } catch ( IllegalArgumentException e ) {}
    }

    @Test
    public void trickyWellDoneSupplier() {
        Supplier<Supplier<Supplier<String>>> wellDoneSupplier = HW.trickyWellDoneSupplier();

        String wellDoneStr = wellDoneSupplier.get().get().get();

        assertEquals("WELL DONE!", wellDoneStr);
    }

    @Test

    public void testmyRepl() {
        int n = 3;
        int v = 10;

        List<Integer> actual = HW.myRepl(n, v);
        List<Integer> expected = List.of(10, 10, 10);

        assertEquals(expected, actual);
    



    

    }
    @Test
    public void testSumOdds(){
        List<Integer> oddNumbers = List.of(1, 3, 5, 7, 9);
        int expectedSum = 25;
        int actualSum = HW.sumOdd(oddNumbers);
        assertEquals( expectedSum, actualSum);
    
    }

    @Test

    public void testRepl() {

        List<Integer> l = List.of(1, 2, 3);
        int n = 3;

        List<Integer> expected = List.of(1, 1, 1, 2, 2, 2, 3, 3, 3);
        List<Integer> actual = HW.repl(l, n);

        assertEquals(expected, actual);
    }


    @Test
    public void testTotalLength(){
        assertEquals(5, HW.totalLength(List.of("Apple")));
        assertEquals(0, HW.totalLength(List.of("Banana", "Orange", "Grapes")));
        assertEquals(19, HW.totalLength(List.of("Apple", "Avocado", "Apricot")));
    }

    @Test
    public void testTitlecase(){
        List<String> inputList = List.of("apple", "banana", "orange", "grape");
        List<String> expectedOutput = List.of("APPLE", "banana", "orange", "grape");

        // Call the titlecase method
        List<String> actualOutput = HW.titlecase(inputList);

        // Assert the result
        assertEquals(expectedOutput, actualOutput);
        try{
        List<String> result = HW.titlecase(null);
        Assert.fail(); } catch ( IllegalArgumentException e ) {}
        // Assert
        
        List<String> input = Collections.emptyList();

        // Act
        List<String> result1 = HW.titlecase(input);

        // Assert
        List<String> expected = Collections.emptyList();
        assertEquals(expected, result1);
        // Arrange
        List<String> input1 = Arrays.asList("apple", null, "banana");

        // Act
        List<String> result2 = HW.titlecase(input1);

        // Assert
        List<String> expected1 = Arrays.asList("APPLE", null, "banana");
        assertEquals(expected1, result2);
    }
   

  

    @Test

    public void testCountVowelPali() {
        try{
            List<String> result = null;
            int c=HW.countVowelPali(result);
            Assert.fail(); } catch ( IllegalArgumentException e ) {}
        List<String> xs = List.of("anna", "banana", "civic", "mouse");
        List<String> emptyString = List.of("");
        List<String> nullString = null;


        int count = HW.countVowelPali(xs);

        assertEquals(4, count);
        assertEquals(0, HW.countVowelPali(emptyString));
        Assertions.assertThrows(IllegalArgumentException.class, () -> HW.countVowelPali(nullString));

    }



}
    
