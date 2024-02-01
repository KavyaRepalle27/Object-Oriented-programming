package fp;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Map;
import java.util.Random;
import java.util.function.*;
import java.util.stream.Collectors;
import java.util.List;

class ExerciseNotCompletedException extends RuntimeException {
    public ExerciseNotCompletedException() {
        super("Exercise is not completed yet");
    }
}

/**
 * {@link HW} is an exercise class. Each method returns a functional interface and it should be implemented
 * using either lambda or a method reference. Every method that is not implemented yet throws
 * {@link ExerciseNotCompletedException}.
 * <p>
 * TODO: remove exception and implement each method of this class using lambda or method reference
 * <p><p>
 * <strong>TODO: to get the most out of your learning, <a href="https://www.bobocode.com/learn">visit our website</a></strong>
 * <p>
 *
 */

record pair<U,V> (U u, V v) {}
public class HW {

    // precondition: l1 and l2 have the same length
    static <U,V> List<pair<U,V>> zip(List<U> l1, List<V> l2) {
        // walk through the U's and V's
        // construct list of pairs
        ArrayList<pair<U,V>> l = new ArrayList<>();
        if (l1.size() != l2.size() || l1 == null || l2 == null) {
            throw new IllegalArgumentException();
        }
        for (int i = 0; i < l1.size(); i++) {
            l.add(new pair<U,V>(l1.get(i),l2.get(i)));  
        }
        return l;
        // ArrayList<Integer> l = new ArrayList<>();
        // for (int i = 0; i < l1.size(); i++) { l.add(i); }
        // return map(l, i -> new pair<>(l1.get(i), l2.get(i)));
    }

    // postcondition: result has the same length as l
    static <U,V> List<V> map(List<U> l, Function<U,V> f) {
        // walk through the U's
        // use f at every stage f.apply
        // construct list of V's
        if(l == null || f == null) {
            throw new IllegalArgumentException();
        }
        ArrayList<V> l2 = new ArrayList<>();
        for (U x: l) {
            l2.add(f.apply(x));
        }
        return l2;
    }

    static <U,V> List<V> flatmap(List<U> l, Function<U,List<V>> f) {
        if(l == null || f == null) {
            throw new IllegalArgumentException();
        }
        // walk through the U's
        // use f at every stage f.apply
        // construct list of V's
        ArrayList<V> res = new ArrayList<>();
        for (U x: l) {
            List<V> l2 = f.apply(x);
            for (V y: l2) {
                res.add(y);
            }
        }
        return res;
    }
    
    // foldleft(            0, [1,2,3,4], (x,y) -> x+y) = 10
    // U = V= Integer
    // fpldleft(            1, [1,2,3,4], (x,y) -> x*y) = 24
    static <U,V> V foldLeft(V e, Iterable<U>l, BiFunction<V,U,V> f){
        // walk through the U's [u1,u2, ..,un]
        //                       e
        // use f at every stage v1= f.apply(e,u1)
        //                         v2= f.apply(v1,u2)
        //						    v3= f.apply(v2,u3)..
        // return the last v
        if(l == null || f == null || e == null) {
            throw new IllegalArgumentException();
        }
        V v = e;
        for (U x: l) {
            v = f.apply(v,x);
        }
        return v;
    }
    
    
    // similar to above
    // but from the right
    //     vn=  f(un,e)
    //          vn-1 = f(un-1,vn)
    // ..
    // return the first v
    static <U,V> V foldRight(V e, List<U>l, BiFunction<U,V,V> f){
        // walk through the U's [u1,u2, ..,un]
        //                       e
        // use f at every stage v1= f.apply(u1,e)
        //                         v2= f.apply(u2,v1)
        //						    v3= f.apply(u3,v2)..
        // return the last v
        if(l == null || f == null || e == null) {
            throw new IllegalArgumentException();
        }
        V v = e;
        for (int i = l.size()-1; i >= 0; i--) {
            v = f.apply(l.get(i),v);
        }
        return v;
    }
    
    // return true if there is an element in l that satisfies p
    static <U> boolean exists(Iterable<U> l, Predicate<U> p){
        if(l == null || p == null) {
            throw new IllegalArgumentException();
        }
        for (U element : l) {
            // Check if the predicate is satisfied for the current element
            if (p.test(element)) {
                return true; // Return true if satisfied
            }
        }
        // If no element satisfies the predicate, return false
        return false;
    }
    
    public static <U> List<U> filter(List<U> l, Predicate<U> p){
        if(l == null || p == null) {
            throw new IllegalArgumentException();
        }
        ArrayList<U> l2 = new ArrayList<>();
        for (U x: l) {
            if (p.test(x)) {
                l2.add(x);
            }
        }
        return l2;

    
    }
    
    static record Person(String name, int age, boolean teach) {}

    public static void printFiltered2(ArrayList<Person> l, Predicate<Person> f) {
        if(l == null || f == null) {
            throw new IllegalArgumentException();
        }
        List<Person> l2 = filter(l,f);
        map(l2, (Person p) -> {return p.name(); });

    }


    // precondition: l is not empty
    static <U> U minVal(Iterable<U> l, Comparator<U> c){
        // write using fold.  No other loops or recursion permitted. 
        // use c.compare
        // 
        // precondition: l is not empty
        // Preconditions: l is not empty
        if(l == null || c == null) {
            throw new IllegalArgumentException();
        }
        U firstElement = l.iterator().next();
        U minVal = foldLeft(firstElement, l, (min, current) -> {
        if (c.compare(current, min) < 0) {
            return current;
        } else if(c.compare(current, min) > 0) {
            return min;
        } else {
            return current;
        }
});

return minVal;

}
    
    /**
     * Returns {@link Supplier} that always supply "Hello"
     *
     * @return a string supplier
     */
    public static Supplier<String> helloSupplier() {
        return () -> "Hello";
    }

    /**
     * Returns a {@link Predicate} of string that checks if string is empty
     *
     * @return a string predicate
     */
    public static Predicate<String> isEmptyPredicate() {
        return str -> str.isEmpty();
    }

    /**
     * Return a {@link Function} that accepts {@link String} and returns that string repeated n time, where n is passed
     * as function argument
     *
     * @return function that repeats Strings
     */
    public static BiFunction<String, Integer, String> stringMultiplier() {
        return (str, n) -> {
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < n; i++) {
               result.append(str);
       }
       return result.toString();
   
   };
    }

    /**
     * Returns a {@link Function} that converts a {@link BigDecimal} number into a {@link String} that start with
     * a dollar sign and then gets a value
     *
     * @return function that converts adds dollar sign
     */
    public static Function<BigDecimal, String> toDollarStringFunction() {
        return (BigDecimal number) -> String.format("$%.2f", number);

       
    }

    /**
     * Receives two parameter that represent a range and returns a {@link Predicate<String>} that verifies if string
     * length is in the specified range. E.g. min <= length < max
     *
     * @param min min length
     * @param max max length
     * @return a string predicate
     */
    public static Predicate<String> lengthInRangePredicate(int min, int max) {
        if((min>max) || (min<0) || (max<0)|| (min==max)) {
            throw new IllegalArgumentException();
        }
        return str -> str.length() >= min && str.length() < max;
    }

    /**
     * Returns a {@link Supplier} of random integers
     *
     * @return int supplier
     */
    public static IntSupplier randomIntSupplier() {
        Random random = new Random();
        return random::nextInt;
    }


    /**
     * Returns an {@link IntUnaryOperator} that receives an int as a bound parameter, and returns a random int
     *
     * @return int operation
     */
    public static IntUnaryOperator boundedRandomIntSupplier() {
        Random random = new Random();
        return (int parameter) -> random.nextInt(parameter);
    }

    /**
     * Returns {@link IntUnaryOperator} that calculates an integer square
     *
     * @return square operation
     */
    public static IntUnaryOperator intSquareOperation() {
        return value -> value * value;
    }

    /**
     * Returns a {@link LongBinaryOperator} sum operation.
     *
     * @return binary sum operation
     */
    public static LongBinaryOperator longSumOperation() {
        return (long left, long right) -> left + right;
    }

    /**
     * Returns a {@link ToIntFunction<String>} that converts string to integer.
     *
     * @return string to int converter
     */
    public static ToIntFunction<String> stringToIntConverter() {
        return str -> Integer.parseInt(str);
    }

    /**
     * Receives int parameter n, and returns a {@link Supplier} that supplies {@link IntUnaryOperator}
     * that is a function f(x) = n * x
     *
     * @param n a multiplier
     * @return a function supplier
     */
    public static Supplier<IntUnaryOperator> nMultiplyFunctionSupplier(int n) {

        return () -> (int x) -> x * n;
    }

    /**
     * Returns a {@link UnaryOperator} that accepts str to str function and returns the same function composed with trim
     *
     * @return function that composes functions with trim() function
     */
    public static UnaryOperator<Function<String, String>> composeWithTrimFunction() {
        return func -> func.compose(String::trim);
    }

    /**



    /**
     * Returns a {@link BiFunction} that has two parameters. First is {@link IntUnaryOperator} which is some integer function.
     * Second is {@link IntPredicate} which is some integer condition. And the third is {@link IntUnaryOperator} which is
     * a new composed function that uses provided predicate (second parameter of binary function) to verify its input
     * parameter. If predicate returns {@code true} it applies a provided integer function
     * (first parameter of binary function) and returns a result value, otherwise it returns an element itself.
     *
     * @return a binary function that receiver predicate and function and compose them to create a new function
     */
    public static BiFunction<IntUnaryOperator, IntPredicate, IntUnaryOperator> functionToConditionalFunction() {
        return (IntUnaryOperator fn, IntPredicate fn2) -> (int i) -> {
            if (!fn2.test(i)) {
                return i;
            } else {
                return fn.applyAsInt(i);
            }
        };
    }

    /**
     * Returns a {@link BiFunction} which first parameter is a {@link Map} where key is a function name, and value is some
     * {@link IntUnaryOperator}, and second parameter is a {@link String} which is a function name. If the map contains a
     * function by a given name then it is returned by high order function otherwise an identity() is returned.
     *
     * @return a high-order function that fetches a function from a function map by a given name or returns identity()
     */
    public static BiFunction<Map<String, IntUnaryOperator>, String, IntUnaryOperator> functionLoader() {
        return (Map<String, IntUnaryOperator> map, String str) -> {
            if (map.containsKey(str)) {
                return map.get(str);
            } else {
                return IntUnaryOperator.identity();
            }
        };

    }

    /**
     * Returns a comparator of type T that is comparing values extracted using the provided mapper function.
     * <p>
     * E.g. imagine you need to compare accounts by their balance values.
     * <pre>{@code
     * Comparator<Account> balanceComparator = comparing(Account::getBalance);
     * }</pre>
     * <p>
     * PLEASE NOTE, that @{@link Comparator} is a functional interface, and you should manually write a lambda expression
     * to implement it.
     *
     * @param mapper a mapper function that allows to map an object to a comparable value
     * @return a comparator instance
     */
    public static <T, U extends Comparable<? super U>> Comparator<T> comparing(Function<? super T, ? extends U> mapper) {
        if(mapper==null) {
            throw new IllegalArgumentException();
        }
        return (T T1, T T2) -> {
            U U1 = mapper.apply(T1);
            U U2 = mapper.apply(T2);
            return U1.compareTo(U2);
        };
    }

    /**
     * Returns a comparator of type T that uses a provided comparator to compare objects, and only if they are equal
     * it's comparing values extracted using the provided mapper function.
     * <p>
     * E.g. suppose you want to compare accounts by balance, but in case two people have the same balance you want to
     * compare their first names:
     * <pre>{@code
     * Comparator<Account> accountComparator = thenComparing(balanceComparator, Account::getFirstName);
     * }</pre>
     * <p>
     *
     * @param comparator an initial comparator
     * @param mapper     a mapper function that is used to extract values when initial comparator returns zero
     * @return a comparator instance
     */
    public static <T, U extends Comparable<? super U>> Comparator<T> thenComparing(
            Comparator<? super T> comparator, Function<? super T, ? extends U> mapper) {
                if(comparator==null||mapper==null) {
                    throw new IllegalArgumentException();
                }
                return (T T1, T T2) -> {
                    if (T1 == null || T2 == null) {
                        throw new NullPointerException("Mapper function should not return null");
                    }
                    int res = comparator.compare(T1, T2);
        
                    if (res == 0) {
        
                        U U1 = mapper.apply(T1);
                        U U2 = mapper.apply(T2);
                        if (U1 == null || U2 == null) {
                            throw new NullPointerException("Mapper function should not return null");
                        }
                        return U1.compareTo(U2);
        
                    } else {
                        return res;
                    }
        
                };
        
    }

    /**
     * Returns {@link Supplier} of {@link Supplier} of {@link Supplier} of {@link String} "WELL DONE!".
     *
     * @return a supplier instance
     */
    public static Supplier<Supplier<Supplier<String>>> trickyWellDoneSupplier() {
        return () -> () -> () -> "WELL DONE!";
    }

    public static void main(String[] args){
        ArrayList<String> l = new ArrayList<>();
        l.add("a");
        l.add("bc");
        l.add("dcf");
        System.out.println(map(l, (String x) -> { return x.length();}));
        // U = String, V = Integer [1,2,3]

    }


    static <T> List<T> myRepl(int n, T v) {
        if (v == null|| n==0) {
            throw new IllegalArgumentException("Parameter 'v' cannot be null");
        }
        ArrayList<T> list = new ArrayList<>();

        list.add(v);// initialized with v

        for (int i = 1; i <= n - 1; i++) {
            list.add(v); // All the elements are equal to v
        }

        return list;

    }

    public static int sumOdd(List<Integer> inputList)  
    {
        if (inputList == null) {
            throw new IllegalArgumentException();
        }
        int sumOfOddNumbers = 0;

        // Extracts a list of odd integers
        List<Integer> oddNumbersList = filter(inputList, new Predicate<Integer>() {
            public boolean test(Integer number) {
                return number % 2 != 0;
            }
        });

        // Sums the odd integers
        sumOfOddNumbers = foldLeft(sumOfOddNumbers, oddNumbersList, (accumulator, currentNumber) -> accumulator + currentNumber);
        return sumOfOddNumbers;
    }
    public static <U> List<U> repl(List<U> xs, int n) {

        if (xs == null|| n==0) {
            throw new IllegalArgumentException("Parameter 'xs' cannot be null");
        }
        // myRepl() returns list of each element of xs repeated n times
        // flatmap() returns a list of all the elements of xs that are repeated n times
        return flatmap(xs, (U x) -> myRepl(n, x));
    }

    public static int totalLength(List<String> xs) {
       
        if (xs == null) {
            throw new IllegalArgumentException();
        }

        return xs.stream()
                .filter(x -> x != null && x.charAt(0) == 'A')
                .map(String::length)
                .reduce(0, Integer::sum);
    }
        

    

    public static List<String> titlecase(List<String> xs) {
  // Check for null input
        // Check for null input
        if (xs == null) {
            throw new IllegalArgumentException();
        }

        return xs.stream()
                .map(x -> x != null && x.charAt(0) == 'a' ? x.toUpperCase() : x)
                .collect(Collectors.toList());
    }

    

    public static int countVowelPali(List<String> xs) {
        if (xs == null) {
            throw new IllegalArgumentException();
        }

        return (int) xs.stream()
                .filter(x -> {
                    String xReverse = new StringBuilder(x).reverse().toString();
                    return x.equals(xReverse);
                })
                .flatMap(x -> x.chars().mapToObj(c -> (char) c))
                .filter(x -> "aeiouAEIOU".indexOf(x) >= 0)
                .count();
    

    }
}



