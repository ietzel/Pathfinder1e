public class Divination extends School {
    public boolean detectsmagic;
    public int oneattacksaveskillcheck;
    public boolean readmagic;
    public boolean comprehendlanguages;
    public String detecting;
    public boolean seeinvisibility;
    public boolean tongues;
    public boolean commune;
    public Divination(String name, boolean detectsmagic, int oneattacksaveskillcheck, boolean readmagic, boolean comprehendlanguages, String detecting, boolean seeinvisibility, boolean tongues, boolean commune) {
        super(name);
        this.detectsmagic = detectsmagic;
        this.oneattacksaveskillcheck = oneattacksaveskillcheck;
        this.readmagic = readmagic;
        this.comprehendlanguages = comprehendlanguages;
        this.detecting = detecting;
        this.seeinvisibility = seeinvisibility;
        this.tongues = tongues;
        this.commune = commune;
    }
}