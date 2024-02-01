package hw1;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class VideoTEST {
 
  @Test
  public void testConstructorAndAttributes() {
    String title1 = "XX";
    String director1 = "XY";
    String title2 = " XX ";
    String director2 = " XY ";
    int year = 2002;

    VideoObj v1 = new VideoObj(title1, year, director1);
    assertTrue(title1== v1.title());
    assertTrue(year== v1.year());
    assertTrue(director1== v1.director());

    VideoObj v2 = new VideoObj(title2, year, director2);
    assertTrue(title1.equals(v2.title()));
    assertEquals(director1,v2.director());
  }
}
