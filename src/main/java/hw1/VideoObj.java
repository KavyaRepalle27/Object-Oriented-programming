package hw1;
/**
 * Immutable Data Class for video objects.
 * Comprises a triple: title, year, director.
 *
 * @objecttype Immutable Data Class
 */
final class VideoObj implements Video {
  /** @invariant non-null, no leading or final spaces, not empty string */
  private final String _title;
  /** @invariant greater than 1800, less than 5000 */
  private final int    _year;
  /** @invariant non-null, no leading or final spaces, not empty string */
  private final String _director;

  /**
   * Initialize all object attributes.
   * Title and director are "trimmed" to remove leading and final space.
   * @throws IllegalArgumentException if any object invariant is violated.
   */
  VideoObj(String title, int year, String director) {
    if (  (title == null)
       || (director == null)
       || (year <= 1800)
       || (year >= 5000)) {
      throw new IllegalArgumentException();
    }
    _title = title.trim();
    _director = director.trim();
    _year = year;
    if (  ("".equals(_title))
       || ("".equals(_director))) {
      throw new IllegalArgumentException();
    }
  }

  /**
   * Return the value of the attribute.
   */
  public String director() {
    return _director;
  }

  /**
   * Return the value of the attribute.
   */
  public String title() {
    return _title;
  }

  /**
   * Return the value of the attribute.
   */
  public int year() {
    return _year;
  }

  /**
   * Compare the attributes of this object with those of thatObject.
   * @param thatObject the Object to be compared.
   * @return deep equality test between this and thatObject.
   */
  public boolean equals(Object thatObject) {
    if (!(thatObject instanceof VideoObj)) {
      return false;
    }
    VideoObj that = (VideoObj) thatObject;
    return _title.equals(that.title())
      && (_year == that.year())
      && _director.equals(that.director());
  }

  /**
   * Return a hash code value for this object using the algorithm from Bloch:
   * fields are added in the following order: title, year, director.
   */
  public int hashCode() {
    int result = _title.hashCode();
    result = 31*result + _year;
    result = 31*result + _director.hashCode();
    return result;
  }

  /**
   * Compares the attributes of this object with those of thatObject, in
   * the following order: title, year, director.
   * @param that the VideoObj to be compared.
   * @return a negative integer, zero, or a positive integer as this
   *  object is less than, equal to, or greater than that object.
   */
  public int compareTo(Video that) {
    int titleDiff = _title.compareTo(that.title());
    if (titleDiff != 0) {
      return titleDiff;
    }
    int yearDiff = _year - that.year();
    if (yearDiff != 0) {
      return yearDiff;
    }
    int directorDiff = _director.compareTo(that.director());
    if (directorDiff != 0) {
      return directorDiff;
    }
    return 0;
  }

  /**
   * Return a string representation of the object in the following format:
   * <code>"title (year) : director"</code>.
   */
  public String toString() {
    StringBuilder buffer = new StringBuilder();
    buffer.append(_title);
    buffer.append(" (");
    buffer.append(_year);
    buffer.append(") : ");
    buffer.append(_director);
    return buffer.toString();
  }
}
