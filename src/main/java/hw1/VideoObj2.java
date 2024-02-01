package hw1;

public record VideoObj2(String title, int year, String director) implements Video {

    public VideoObj2 {

        // Throws an exception if any of the invariant is violated.
        if ((title == null) || (director == null) || (year <= 1800) || (year >= 5000)) {
            throw new IllegalArgumentException(
                    String.format("Invalid parameters: %s, %s, %d", title, director, year));
        }

        title = title.trim();
        director = director.trim();

        // Throws an exception if any of the invariant is violated after trimming
        if (("" == title) || ("" == director)) {
            throw new IllegalArgumentException(
                    String.format("Empty strings are not valid.%s,%s", title, director));

        }

    }

    /*
     * Since this is a record class all methods such as hashcode, equals, toString
     * are defined automatically except for
     * compareTo method. So we have to explicitly declare the compareTo function in
     * this class.
     */

    public int compareTo(Video that) {
        if (title.compareTo(that.title()) != 0) {
            return title.compareTo(that.title());
        }
        if (year - that.year() != 0) {
            return year - that.year();
        }
        if (director.compareTo(that.director()) != 0) {
            return director.compareTo(that.director());
        }
        return 0;
    }

    // To maintain the functionality of the original code we have to override the
    // toString method
    @Override
    public String toString() {
        String S = title + " (" + year + ") : " + director;
        return S;
    }

}
