package hw1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

public class InventorySetTest {

    @Test

    public void testSize() {

        InventorySet set=new InventorySet();
        assertEquals(0,set.size());
        Video video1=new VideoObj("A",2000,"B");
        set.addNumOwned(video1,1);
        assertEquals(1,set.size());
    }

    @Test
    public void testGet() {

        InventorySet set=new InventorySet();
        Video video1=new VideoObj("A",2000,"B");
        set.addNumOwned(video1,1);
        assertEquals(1,set.get(video1).numOwned());
        assertEquals(0,set.get(video1).numOut());
        assertEquals(0,set.get(video1).numRentals());
        assertNotEquals(1,set.get(video1).numRentals());

        Record record1=set.get(video1);

        assertEquals(1,record1.numOwned());

    }

    @Test

    public void testtoCollection() {

        InventorySet set=new InventorySet();
        Video video1=new VideoObj("A",2000,"B");
        Video video2=new VideoObj("C",2000,"D");
        set.addNumOwned(video1,1);
        set.addNumOwned(video2,1);
        assertEquals(2,set.toCollection().size());
        assertEquals(1,set.toCollection().iterator().next().numOwned());
        assertEquals(0,set.toCollection().iterator().next().numOut());
        assertEquals(0,set.toCollection().iterator().next().numRentals());
        assertNotEquals(1,set.toCollection().iterator().next().numRentals());

        Record record1=set.toCollection().iterator().next();

        assertEquals(1,record1.numOwned());
    }

    @Test

    public void testaddNumOwned() {

        InventorySet set=new InventorySet();
        Video video1=new VideoObj("A",2000,"B");
        Video video2=new VideoObj("C",2000,"D");
        set.addNumOwned(video1,3);
        set.addNumOwned(video2,1);
        assertEquals(3,set.get(video1).numOwned());
        assertEquals(0,set.get(video1).numOut());
        assertEquals(0,set.get(video1).numRentals());
        assertNotEquals(1,set.get(video1).numRentals());
        assertEquals(1,set.get(video2).numOwned());
        assertEquals(0,set.get(video2).numOut());
        assertEquals(0,set.get(video2).numRentals());
        assertNotEquals(1,set.get(video2).numRentals());


        Record record1=set.get(video1);
        Record record3=set.get(video2);

        assertEquals(3,record1.numOwned());
        assertEquals(1,record3.numOwned());

        set.addNumOwned(video1,1);
        assertEquals(4,set.get(video1).numOwned());
    }

    @Test

    public void testCheckOut() {

        InventorySet invSet = new InventorySet();
        Video video1=new VideoObj("A",2000,"B");
        Video video2=new VideoObj("C",2000,"D");
        invSet.addNumOwned(video1, 2);
        invSet.addNumOwned(video2, 1);

        invSet.checkOut(video1);
        invSet.checkOut(video1);
        invSet.checkOut(video2);

        assertEquals(2, invSet.get(video1).numOut());
        assertEquals(1, invSet.get(video2).numOut());
        assertEquals(2, invSet.get(video1).numRentals());
        assertEquals(1, invSet.get(video2).numRentals());

    }

    @Test

    public void testCheckIn() {

       Inventory set = new InventorySet();
        Video video1=new VideoObj("A",2000,"B");
        Video video2=new VideoObj("C",2000,"D");
        set.addNumOwned(video1, 2);
        set.addNumOwned(video2, 1);

        set.checkOut(video1);
        set.checkOut(video1);
        set.checkOut(video2);
        set.checkIn(video1);
        set.checkIn(video2);

        assertEquals(1, set.get(video1).numOut());
        assertEquals(0, set.get(video2).numOut());
        assertEquals(2, set.get(video1).numRentals());
        assertEquals(1, set.get(video2).numRentals());


    }

    @Test

    public void testClear() {

        InventorySet invSet = new InventorySet();
        Video video1=new VideoObj("A",2000,"B");
        Video video2=new VideoObj("C",2000,"D");
        invSet.addNumOwned(video1, 2);
        invSet.addNumOwned(video2, 1);

        invSet.checkOut(video1);
        invSet.checkOut(video1);
        invSet.checkOut(video2);
        invSet.checkIn(video1);
        invSet.checkIn(video2);

        invSet.clear();

        assertEquals(0, invSet.size());
    
    }

    @Test

    public void testtoString() {

      Inventory set= new InventorySet();
        Video video1=new VideoObj("A",2000,"B");
        Video video2=new VideoObj("C",2000,"D");
        set.addNumOwned(video1, 2);
        set.addNumOwned(video2, 1);

        set.checkOut(video1);
        set.checkOut(video1);
        set.checkOut(video2);
        set.checkIn(video1);
        set.checkIn(video2);

        assertEquals("Database:\n\s\sA (2000) : B [2,1,2]\n\s\sC (2000) : D [1,0,1]\n", set.toString());

    }

}
