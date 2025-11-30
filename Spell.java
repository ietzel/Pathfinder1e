public class Spell {
  public String time;
  public boolean v;
  public boolean s;
  public double cost;  
  public int rangebase;
  public int rangelevel;
  public String durationbase;
  public String durationlevel;
  public String savingthrow;
  public Spell(String time, boolean v, boolean s, double cost, int rangebase, int rangelevel, String durationbase, String durationlevel, String savingthrow) {
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
}
