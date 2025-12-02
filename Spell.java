public class Spell {
  public String time;
  public boolean v;
  public boolean s;
  public double cost;  
  public int rangebase;
  public int rangelevel;
  public int durationbase;
  public int durationlevel;
  public String savingthrow;
  public Spell(String time, boolean v, boolean s, double cost, int rangebase, int rangelevel, int durationbase, int durationlevel, String savingthrow) {
    this.time = time;
    this.v = v;
    this.s = s;
    this.cost = cost;
    this.rangebase = rangebase;
    this.rangelevel = rangelevel;
    this.durationbase = durationbase;
    this.durationlevel = durationlevel;
    this.savingthrow = savingthrow;
  }
  public void cast(int cLevel, int targetDistance, Character target) {
    if(this.rangebase+(this.rangelevel*cLevel) <= targetDistance) {
      int duration = this.durationbase+(this.durationlevel*cLevel);
    } 
  }
}
