package hw1;


public class RecordObj implements Record {
  /**
   * The video.
   * @invariant <code>video != null</code>
   */
  Video video;
  /**
   * The number of copies of the video that are in the inventory.
   * @invariant <code>numOwned > 0</code>
   */
  int numOwned;
  /**
   * The number of copies of the video that are currently checked out.
   * @invariant <code>numOut <= numOwned</code>
   */
  int numOut;
  /**
   * The total number of times this video has ever been checked out.
   * @invariant <code>numRentals >= numOut</code>
   */
  int numRentals;

  /**
   * Initialize all object attributes.
   */
  RecordObj(Video video, int numOwned, int numOut, int numRentals) {
    if(video == null || numOwned <= 0 || numOut < 0 || numRentals < 0 || numOut > numOwned || numRentals < numOut)
      throw new IllegalArgumentException();
    this.video = video;
    this.numOwned = numOwned;
    this.numOut = numOut;
    this.numRentals = numRentals;
    // TODO
  }
  /**
   * @return <code>number of owned video</code>
   */
  
  public int numOwned() {
    return numOwned;
    // TODO
  }

  /**
   * @return <code>number of out video</code>
   */

  public int numOut() {
    return numOut;
    // TODO
  }

  /**
   * @return <code>number of rented video</code>
   */
  public int numRentals() {
    return numRentals;
    // TODO
  }
  /**
   * @return a shallow copy of this record.
   */
  public RecordObj copy() {
    return new RecordObj(video, numOwned, numOut, numRentals);
    // TODO
  }
  /**
   * Return a string representation of the object in the following format:
   * <code>"video [numOwned,numOut,numRentals]"</code>.
   */
  public String toString() {
    StringBuilder buffer = new StringBuilder();
    buffer.append(video);
    buffer.append(" [");
    buffer.append(numOwned);
    buffer.append(",");
    buffer.append(numOut);
    buffer.append(",");
    buffer.append(numRentals);
    buffer.append("]");
    return buffer.toString();
  }
}
