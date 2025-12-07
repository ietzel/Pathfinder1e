public class Character {
  public String name;
  public Species species;
  public int level;
  public int maxhp = 1;
  public int currenthp = 1;
  public int fort;
  public int ref;
  public int will;
  public int ac;
  public int bab;
  public String alignment;
  public int strength;
  public int dexterity;
  public int constitution;
  public int intelligence;
  public int wisdom;
  public int charisma;
  public double concealment;
  public int grappled;
  public int fatigued;
  public int exhausted;
  public int unconscious;
  public int shaken;
  public int frightened;
  public int panicked;
  public int existingcomfortablycold;
  public int existingcomfortablyhot;
  public int existcomfortablycold;
  public int existcomfortablyhot;
  public int protection;
  public String protectionfrom;
  public int resisting;
  public String resistenergy;
  public Curse[] curses = new Curse[10];
  public int damagereducting;
  public int dr;
  public int badmagiceffects;
  public int stabilized; // CHANGED from boolean
  public int obscured;   // CHANGED from boolean
  public boolean poisoned; // Remains boolean (for status clearing)
  public int diseased;   // CHANGED from boolean
  public int negativelevels;
  public int oneattacksaveskillcheck;
  public int readmagic;    // CHANGED from boolean
  public String detecting;
  public int detect;       // CHANGED from boolean
  public int tongues;      // CHANGED from boolean
  public int commune;      // CHANGED from boolean
  public int trueseeing;   // CHANGED from boolean
  public int attackrollfearsavebonus; // CHANGED from boolean
  public int commanded;    // CHANGED from boolean
  public int sleep;
  public int entrancing;
  public int light;
  public int invisibility; 
  public int mirrorimage;
  public int polymorph;    // CHANGED from String

  public Character(String name, Species species, int level, int maxhp, int currenthp, String alignment, int strength, int dexterity, int constitution, int intelligence, int wisdom, int charisma) {
    this.name = name;
    this.species = species;
    this.level = level;
    this.maxhp = maxhp;
    this.currenthp = currenthp;
    this.fort = fort;
    this.ref = ref;
    this.will = will;
    this.ac = ac;
    this.bab = bab;
    this.alignment = alignment;
    this.strength = strength + this.species.strength;
    this.dexterity = dexterity + this.species.dexterity;
    this.constitution = constitution + this.species.constitution;
    this.intelligence = intelligence + this.species.intelligence;
    this.wisdom = wisdom + this.species.wisdom;
    this.charisma = charisma + this.species.charisma;
    this.concealment = 0.0;
    this.grappled = 0;
    this.fatigued = 0;
    this.exhausted = 0;
    this.unconscious = 0;
    this.shaken = 0;
    this.frightened = 0;
    this.panicked = 0;
    this.existingcomfortablycold = 0;
    this.existingcomfortablyhot = 0;
    this.existcomfortablycold = 33;
    this.existcomfortablyhot = 94;
    this.protection = 0;
    this.protectionfrom = "none";
    this.resisting = 0;
    this.resistenergy = "none";
    this.curses = new Curse[10];
    this.damagereducting = 0;
    this.dr = 0;
    this.badmagiceffects = 0;
    this.stabilized = 0; // CHANGED from true
    this.obscured = 0; // CHANGED from false
    this.poisoned = false;
    this.diseased = 0; // CHANGED from false
    this.negativelevels = 0;
    this.oneattacksaveskillcheck = 0;
    this.readmagic = 0; // CHANGED from false
    this.detecting = "none";
    this.detect = 0; // CHANGED from false
    this.tongues = 0; // CHANGED from false
    this.commune = 0; // CHANGED from false
    this.trueseeing = 0; // CHANGED from false
    this.attackrollfearsavebonus = 0; // CHANGED from false
    this.commanded = 0; // CHANGED from false
    this.sleep = 0;
    this.entrancing = 0;
    this.light = 0;
    this.invisibility = 0;
    this.mirrorimage = 0;
  }
}