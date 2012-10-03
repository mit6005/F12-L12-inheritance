package beforeclass;


public class Duration {
    private final int mins;
    private final int secs;
    // rep invariant:
    //    mins >= 0, secs >= 0
    // abstraction function:
    //    represents a span of time of mins minutes and secs seconds

    /** Make a duration lasting for m minutes and s seconds. */
    public Duration(int m, int s) {
        mins = m; secs = s;
    }
    
    /** @return length of this duration in seconds */
    public long getLength() {
        return mins*60 + secs;
    }
    
    // Right definition of equals()
    @Override // asserts that superclass has this method; compile-time error if not
    public boolean equals (Object _that) {
        if (!(_that instanceof Duration)) return false; // also handles _that == null
        Duration that = (Duration) _that;
        return this.getLength() == that.getLength();
    }
    
    // Right definition of hashCode()
    @Override
    public int hashCode() {
        return (int) getLength();
    }

}
