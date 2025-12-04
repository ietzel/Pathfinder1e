public class Transmutation extends School {
    public boolean mends;
    public boolean purifies;
    public String plusfourabilitybonus;
    public String polymorph;
    public Transmutation(String name, boolean mends, boolean purifies, String plusfourabilitybonus, String polymorph) {
        super(name);    
        this.mends = mends;
        this.purifies = purifies;
        this.plusfourabilitybonus = plusfourabilitybonus;
        this.polymorph = polymorph;
    }
}