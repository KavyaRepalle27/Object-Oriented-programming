package hw1;


import java.lang.Comparable;

/**
 * <p>An immutable video object.</p>
 *
 * <p>Comprises a triple: title, year, director.</p>
 *
 * @objecttype Immutable Data Class
 * * @objectinvariant
 *   Title is non-null, no leading or final spaces, not empty string.
 * @objectinvariant
 *   Year is greater than 1800, less than 5000.
 * @objectinvariant
 *   Director is non-null, no leading or final spaces, not empty string.
 */
public interface Video extends Comparable<Video> {

  /**
   *  Return the value of the attribute.
   */
  public String director();

  /**
   *  Return the value of the attribute.
   */
  public String title();

  /**
   *  Return the value of the attribute.
   */
  public int year();

  /**
   * Compare the attributes of this object with those of thatObject.
   * @param thatObject the Object to be compared.
   * @return true if this object is the same as the obj argument;
   *  false otherwise.
   */
  public boolean equals(Object thatObject);

  /**
   * Return a hash code value for this object using the algorithm from Bloch:
   * fields are added in the following order: title, year, director.
   */
  public int hashCode();

  /**
   * Compares the attributes of this object with those of thatObject, in
   * the following order: title, year, director.
   * @param that the Video to be compared.
   * @return a negative integer, zero, or a positive integer as this
   *  object is less than, equal to, or greater than that object.
   */
  public int compareTo(Video that);

  /**
   * Return a string representation of the object in the following format:
   * <code>"title (year) : director"</code>.
   */
  public String toString();
}

