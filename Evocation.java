public class Evocation extends School {
    public boolean light;
    public int damageperlevel; // CHANGED from double
    public int maxdamagelevel;
    public String damagetype;
    public int modifylightbysteps;
    public boolean continualflame;
    // Constructor updated
    public Evocation(String name, boolean light, int damageperlevel, int maxdamagelevel, String damagetype, int modifylightbysteps, boolean continualflame) {
        super(name);    
        this.light = light;
        this.damageperlevel = damageperlevel; // Assignment updated
        this.maxdamagelevel = maxdamagelevel;
        this.damagetype = damagetype;
        this.modifylightbysteps = modifylightbysteps;
        this.continualflame = continualflame;
    }
}