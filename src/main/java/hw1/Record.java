package hw1;

public interface Record {

    public int numOwned();

    public int numOut();

    public int numRentals();

    public String toString();

    public Record copy();

}
