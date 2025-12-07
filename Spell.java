public class Spell {
  public String name;
  public School school; 
  public int level;
  public int time; // CHANGED from double
  public boolean v;
  public boolean s;
  public boolean d;
  public int cost;  // CHANGED from double
  public int rangebase;
  public int rangelevel;
  public int durationbase;
  public int durationlevel;
  public String savingthrow;
  public boolean spellresistance;
  
  // Constructor parameters updated to int
  public Spell(String name, School school, int level, int time, boolean v, boolean s, boolean d, int cost, int rangebase, int rangelevel, int durationbase, int durationlevel, String savingthrow, boolean spellresistance) {
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
      
      // School specific checks
      if(this.school.name.equals("abjuration")) {
          Abjuration s = (Abjuration) this.school;
          if(s.existcomfortablycold != 0) {
              target.existingcomfortablycold = s.existcomfortablycold; 
          }
          if(s.existcomfortablyhot != 0) {
              target.existingcomfortablyhot = s.existcomfortablyhot; 
          }
          if(s.deflectionbonus != 0) {
              target.protection = s.deflectionbonus; 
          }
          if(s.savebonus != 0) {
              // Note: Character.java does not have a separate field for generic save bonus.
          }
          if(s.contactprevention != false) {
              // Logic for contact prevention is complex
          }
          if(!s.againstalignment.equals("none")) {
              target.protectionfrom = s.againstalignment; 
          }
          if(s.energyresistance != 0) {
              target.resisting = s.energyresistance; 
          }
          if(!s.resistenergytype.equals("none")) {
              target.resistenergy = s.resistenergytype; 
          }
          if(s.removecurses != false) {
              // Remove curses logic
          }
          if(s.dradamantineuptopercasterlevelmaxfifteen != 0) {
              target.dr = s.dradamantineuptopercasterlevelmaxfifteen; 
          }
          if(s.freefromenchantmentstransmutations != false) {
              target.badmagiceffects = 0; 
          }
      } else if(this.school.name.equals("conjuration")) {
          Conjuration s = (Conjuration) this.school;
          if(s.gallonsofwaterperlevel != 0) {
              // Affects environment
          }
          if(s.stabilizer != false) {
              target.stabilized = durationleft;
          }
          if(s.basehealing != 0) { // UPDATED check from 0.0 to 0
              // Healing application logic...
              int healing = s.basehealing * cLevel; // UPDATED to int arithmetic
              if (s.maxhealingperlevel != 0 && healing > s.maxhealingperlevel) {
                  healing = s.maxhealingperlevel;
              }
              target.currenthp += healing; // UPDATED to int arithmetic
          }
          if(s.healingperlevel != 0) {
              // Handled above
          }
          if(s.maxhealingperlevel != 0) {
              // Handled above
          }
          if(s.obscurationradius != 0) {
              target.obscured = durationleft;
          }
          if(s.poisonimmunity != false) {
              target.poisoned = false; 
          }
          if(s.grappleradius != 0) {
              target.grappled = durationleft; 
          }
          if(s.neutralizespoisonroundsperlevel != 0) {
              target.poisoned = false; 
          }
          if(s.removesdiseases != false) {
              target.diseased = durationleft; 
          }
          if(s.createscubicfeetofmatterperlevel != 0) {
              // Affects environment
          }
          if(s.removestwoabilitydamageandnegativelevel != false) {
              target.negativelevels = 0;
          }
          if(s.removesafflictions != false) {
              target.poisoned = false;
              target.diseased = 0;
          }
          if(s.raisesdead != false) {
              // Complex logic
          }
          if(s.stonewallsquareperlevel != false) {
              // Affects environment
          }
      } else if(this.school.name.equals("divination")) {
          Divination s = (Divination) this.school;
          if(s.detectsmagic != false) {
              target.detect = durationleft;
          }
          if(s.oneattacksaveskillcheck != 0) {
              target.oneattacksaveskillcheck = s.oneattacksaveskillcheck; 
          }
          if(s.readmagic != false) {
              target.readmagic = durationleft;
          }
          if(s.comprehendlanguages != false) {
              target.tongues = durationleft;
          }
          if(!s.detecting.equals("none")) {
              target.detecting = s.detecting; 
              target.detect = durationleft;
          }
          if(s.seeinvisibility != false) {
              target.trueseeing = durationleft;
          }
          if(s.tongues != false) {
              target.tongues = durationleft;
          }
          if(s.commune != false) {
              target.commune = durationleft;
          }
      } else if(this.school.name.equals("enchantment")) {
          Enchantment s = (Enchantment) this.school;
          if(s.attackrollfearsavebonus != false) {
              target.attackrollfearsavebonus = durationleft;
          }
          if(s.command != false) {
              target.commanded = durationleft;
          }
          if(s.sleep != false) {
              target.sleep = durationleft;
          }
          if(s.maxtemphpeachcasterlevel != false) {
              target.entrancing = durationleft;
          }
          if(s.entrance != false) {
              target.entrancing = durationleft;
          }
      } else if(this.school.name.equals("evocation")) {
          Evocation s = (Evocation) this.school;
          if(s.light != false) {
              target.light = durationleft;
          }
          if(s.damageperlevel != 0) { // UPDATED check from 0.0 to 0
              // Damage calculation (Skip for now)
          }
          if(s.maxdamagelevel != 0) {
              // Damage calculation (Skip for now)
          }
          if(!s.damagetype.equals("none")) {
              // Damage type (Skip for now)
          }
          if(s.modifylightbysteps != 0) {
              target.light -= s.modifylightbysteps; 
              if (target.light < -1) target.light = -1;
          }
          if(s.continualflame != false) {
              target.light = 999999;
          }
      } else if(this.school.name.equals("illusion")) {
          Illusion s = (Illusion) this.school;
          if(s.ghostsound != false) {
              // Affects senses
          }
          if(s.invisibility != false) {
              target.invisibility = durationleft;
          }
          if(s.mirrorimage != false) {
              target.mirrorimage = cLevel; 
          }
      } else if(this.school.name.equals("necromancy")) {
          Necromancy s = (Necromancy) this.school;
          if(s.fatigue != false) {
              target.fatigued = durationleft;
          }
          if(s.shake != false) {
              target.shaken = durationleft;
          }
          if(s.animatefourhdpercasterlevel != false) {
              // Summons, complex. Skip.
          }
          if(s.abilitiesattacksaveskillchecksdecreasebyoneandsixteenpercenttotakenoaction != false) {
              target.badmagiceffects = durationleft;
          }
          if(s.disease != false) {
              target.diseased = durationleft;
          }
      } else if(this.school.name.equals("transmutation")) {
          Transmutation s = (Transmutation) this.school;
          if(s.mends != false) {
              // Affects object
          }
          if(s.purifies != false) {
              target.poisoned = false;
              target.diseased = durationleft;
          }
          if(!s.plusfourabilitybonus.equals("none")) {
              // Complex stat modification. Skip for now.
          }
          if(!s.polymorph.equals("none")) {
              target.polymorph = durationleft; 
          }
      }
    } 
  }
}