package hw1;

import java.util.Collection;

public interface Inventory {

    
public int size();

public Record get(Video v);
 
public Collection<Record> toCollection();
  
public void addNumOwned(Video v1, int change);
 
public void checkOut(Video video);

public void checkIn(Video video);
   
public void clear();
  
public String toString();


}
