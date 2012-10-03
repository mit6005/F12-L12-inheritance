package beforeclass;

public class PreciseDuration extends Duration {
    private final int millisecs;
    
    public PreciseDuration(int m, int s, int ms) {
        super(m, s);
        millisecs = m;
    }
    
    public long getMillisecs() {
        return super.getLength() * 1000 + millisecs;
    }
    
    // this equals method is broken!
    @Override
    public boolean equals(Object _that) {
        if (! (_that instanceof PreciseDuration)) return false;
        PreciseDuration that = (PreciseDuration) _that;
        return this.getMillisecs() == that.getMillisecs();
    }
}
