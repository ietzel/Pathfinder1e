public class Spell {
  public String name;
  public String school;
  public int level;
  public double time;
  public boolean v;
  public boolean s;
  public boolean d;
  public double cost;  
  public int rangebase;
  public int rangelevel;
  public int durationbase;
  public int durationlevel;
  public String savingthrow;
  public boolean spellresistance;
  public Spell(String name, String school, int level, double time, boolean v, boolean s, boolean d, double cost, int rangebase, int rangelevel, int durationbase, int durationlevel, String savingthrow, boolean spellresistance) {
    this.name = name;
    this.school = school;
    this.level = level;
    this.time = time;
    this.v = v;
    this.s = s;
    this.d = d;
    this.cost = cost;
    this.rangebase = rangebase;
    this.rangelevel = rangelevel;
    this.durationbase = durationbase;
    this.durationlevel = durationlevel;
    this.savingthrow = savingthrow;
    this.spellresistance = spellresistance;
  }
  public void cast(Spell spell, int cLevel, int targetDistance, Character target) {
    if(spell.rangebase+(spell.rangelevel*cLevel) <= targetDistance) {
      int durationleft = 0;
      if(spell.durationbase == 999999) {
        if(spell.durationlevel == 999999) {
          return;
        }
      } else if(spell.durationbase == -1) {
	      return;
      } else if(spell.durationbase == -2) {
	      return;
      } else {
        durationleft = spell.rangebase+(spell.rangelevel*cLevel);
      }
      /*
      if(this.school.name == "abjuration") {
          if(this.school.existcomfortablycold != -1) {
              
          }
          if(this.school.existcomfortablyhot != -1) {
              
          }
      } else if(this.school.name == "conjuration") {

      } else if(this.school.name == "divination") {

      } else if(this.school.name == "enchantment") {

      } else if(this.school.name == "evocation") {

      } else if(this.school.name == "illusion") {

      } else if(this.school.name == "necromancy") {

      } else if(this.school.name == "transmutation") {

      }
      */
    } 
  }
}