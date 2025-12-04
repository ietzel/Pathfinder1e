public class Evocation extends School {
    public boolean light;
    public double damageperlevel;
    public int maxdamagelevel;
    public String damagetype;
    public int modifylightbysteps;
    public boolean continualflame;
    public Evocation(String name, boolean light, double damageperlevel, int maxdamagelevel, String damagetype, int modifylightbysteps, boolean continualflame) {
        super(name);    
        this.light = light;
        this.damageperlevel = damageperlevel;
        this.maxdamagelevel = maxdamagelevel;
        this.damagetype = damagetype;
        this.modifylightbysteps = modifylightbysteps;
        this.continualflame = continualflame;
    }
}