
package hw1;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;
public class VideoObjTest2{

    @Test
    public void testConstructorAndAttributes()
    {
        
        VideoObj2 video = new VideoObj2("Interstellar", 2014, "Christopher Nolan");
        VideoObj2 video2=new VideoObj2("newMovie",2023,"newDirector");
        assertEquals("Interstellar", video.title());
        assertEquals(2014, video.year());
        assertEquals("Christopher Nolan", video.director());
        assertFalse(video.title().equals(video2.title()));
        assertEquals("newMovie", video2.title());
        assertEquals(2023, video2.year());
        assertEquals("newDirector", video2.director());

    }
    @Test
    public void testequals(){
        VideoObj2 video = new VideoObj2("Interstellar", 2014, "Christopher Nolan");
        VideoObj2 video2=new VideoObj2("newMovie",2023,"newDirector");
        VideoObj2 video3=new VideoObj2("Interstellar", 2014, "Christopher Nolan");
        VideoObj2 video4=new VideoObj2("newMovie",2023,"newDirector");

        assertTrue(video.equals(video3));
        assertTrue(video3.equals(video));
        assertFalse(video.equals(video2));
        assertFalse(video2.equals(video));
        assertFalse(video.equals(video4));
        assertFalse(video4.equals(video));
        assertFalse(video3.equals(video4));
        assertFalse(video4.equals(video3));
        assertTrue(video2.equals(video4));
        assertTrue(video4.equals(video2));
    }

    @Test 
    public void testCompare()
    {
        VideoObj2 video = new VideoObj2("Interstellar", 2014, "Christopher Nolan");
        VideoObj2 video2=new VideoObj2("newMovie",2023,"newDirector");
        VideoObj2 video3=new VideoObj2("Interstellar", 2014, "Christopher Nolan");
        VideoObj2 video4=new VideoObj2("newMovie",2023,"newDirector");
        assertTrue(video.compareTo(video3)==0);
        assertTrue(video.compareTo(video2)<0);
        assertTrue(video2.compareTo(video)>0);
        assertTrue(video2.compareTo(video4)==0);
        assertTrue(video4.compareTo(video2)==0);
        assertTrue(video3.compareTo(video4)<0);
        assertTrue(video4.compareTo(video3)>0);
    }

    @Test
    public void testToString()
    {
        VideoObj2 video = new VideoObj2("Interstellar", 2014, "Christopher Nolan");
        assertEquals("Interstellar (2014) : Christopher Nolan", video.toString());
    }
    @Test
    public void testHashCode(){
        VideoObj2 video = new VideoObj2("Interstellar", 2014, "Christopher Nolan");
        VideoObj2 video2=new VideoObj2("newMovie",2023,"newDirector");
        VideoObj2 video3=new VideoObj2("Interstellar", 2014, "Christopher Nolan");
        VideoObj2 video4=new VideoObj2("newMovie",2023,"newDirector");
        assertEquals(video.hashCode(),video3.hashCode());
        assertEquals(video2.hashCode(),video4.hashCode());
        assertNotEquals(video.hashCode(),video2.hashCode());
        assertNotEquals(video.hashCode(),video4.hashCode());
        assertNotEquals(video2.hashCode(),video3.hashCode());
        assertNotEquals(video3.hashCode(),video4.hashCode());
    }
    
}
