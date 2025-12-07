public class Conjuration extends School {
    public int gallonsofwaterperlevel;
    public boolean stabilizer;
    public int basehealing; // CHANGED from double
    public int healingperlevel;
    public int maxhealingperlevel;
    public int obscurationradius; 
    public boolean poisonimmunity;
    public int grappleradius;
    public int neutralizespoisonroundsperlevel;
    public boolean removesdiseases;
    public int createscubicfeetofmatterperlevel;
    public boolean removestwoabilitydamageandnegativelevel;
    public boolean removesafflictions;
    public boolean raisesdead;
    public boolean stonewallsquareperlevel;
    // Constructor updated
    public Conjuration(String name, int gallonsofwaterperlevel, boolean stabilizer, int basehealing, int healingperlevel, int maxhealingperlevel, int obscurationradius, boolean poisonimmunity, int grappleradius, int neutralizespoisonroundsperlevel, boolean removesdiseases, int createscubicfeetofmatterperlevel, boolean removestwoabilitydamageandnegativelevel, boolean removesafflictions, boolean raisesdead, boolean stonewallsquareperlevel) {
        super(name);
        this.gallonsofwaterperlevel = gallonsofwaterperlevel;
        this.stabilizer = stabilizer;
        this.basehealing = basehealing; // Assignment updated
        this.healingperlevel = healingperlevel;
        this.maxhealingperlevel = maxhealingperlevel;
        this.obscurationradius = obscurationradius;
        this.poisonimmunity = poisonimmunity;
        this.grappleradius = grappleradius;
        this.neutralizespoisonroundsperlevel = neutralizespoisonroundsperlevel;
        this.removesdiseases = removesdiseases;
        this.createscubicfeetofmatterperlevel = createscubicfeetofmatterperlevel;
        this.removestwoabilitydamageandnegativelevel = removestwoabilitydamageandnegativelevel;
        this.removesafflictions = removesafflictions;
        this.raisesdead = raisesdead;
        this.stonewallsquareperlevel = stonewallsquareperlevel;
    }
}