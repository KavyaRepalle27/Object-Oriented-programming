package hw1;

/**
 * Utility class .  Fields are mutable and package-private.
 * Does not override <code>equals</code> or <code>hashCode</code>.
 *
 * @objecttype Immutable Data Class
 */
final record RecordObj2(Video video, int numOwned, int numOut, int numRentals) implements Record {
    
         RecordObj2(Video video, int numOwned, int numOut, int numRentals) {
            if (video == null || numOwned <= 0 || numOut < 0 || numRentals < 0 || numOut > numOwned || numRentals < numOut)
                throw new IllegalArgumentException();
            this.video = video;
            this.numOwned = numOwned;
            this.numOut = numOut;
            this.numRentals = numRentals;
        }
    
        public int numOwned() {
            return numOwned;
        }
    
        public int numOut() {
            return numOut;
        }

    
        public int numRentals() {
            return numRentals;
        }
    
        public String toString() {
            return video.toString() + " ["
                    + numOwned + "," + numOut + "," + numRentals + "]";
        }
    
        public RecordObj2 copy() {
            return new RecordObj2(video, numOwned, numOut, numRentals);
        }
}
