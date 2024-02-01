package hw1;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;


public class RecordObjTest {

    @Test
    public void testConstructorAndAttributes()
    {
        
        Video video = new VideoObj("Interstellar", 2014, "Christopher Nolan");

        RecordObj record = new RecordObj(video, 8, 6, 7);

        assertEquals(8, record.numOwned());
        assertEquals(6, record.numOut());
        assertEquals(7, record.numRentals());

        RecordObj2 record2 = new RecordObj2(video, 8, 6, 7);

        assertEquals(8, record2.numOwned());
        assertEquals(6, record2.numOut());
        assertEquals(7, record2.numRentals());
    

    }
    @Test
    public void testExceptions()
    {
        Video v=new VideoObj("A",2000,"B");
        assertThrows(IllegalArgumentException.class,()->new RecordObj2(null,1,1,1));
        assertThrows(IllegalArgumentException.class,()->new RecordObj2(v,-1,1,1));
        assertThrows(IllegalArgumentException.class,()->new RecordObj2(v,1,-1,1));
        assertThrows(IllegalArgumentException.class,()->new RecordObj2(v,1,1,-1));
        assertThrows(IllegalArgumentException.class,()->new RecordObj2(v,1,2,3));

    }
    @Test
    public void testCopy(){
        Video v=new VideoObj("A",2000,"B");
        RecordObj record=new RecordObj(v,3,1,2);
        RecordObj record2=record.copy();
        assertEquals(record.numOwned(),record2.numOwned());
        assertEquals(record.numOut(),record2.numOut());
        assertEquals(record.numRentals(),record2.numRentals());
        assertNotSame(record,record2);

        RecordObj2 record3=new RecordObj2(v,3,1,2);
        RecordObj2 record4=record3.copy();
        assertEquals(record3.numOwned(),record4.numOwned());
        assertEquals(record3.numOut(),record4.numOut());
        assertEquals(record3.numRentals(),record4.numRentals());
        assertNotSame(record3,record4);
    }
    @Test
    public void testtoString(){
        Video v=new VideoObj("A",2000,"B");
        RecordObj record=new RecordObj(v,3,1,2);
        assertEquals("A (2000) : B [3,1,2]",record.toString());

        RecordObj2 record2=new RecordObj2(v,3,1,2);
        assertEquals("A (2000) : B [3,1,2]",record2.toString());
        
    }   

}