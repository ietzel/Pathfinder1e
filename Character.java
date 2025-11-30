public class Character {
  public String name;
  public Species species;
  public int level;
  public int fort;
  public int ref;
  public int will;
  public int bab;
  public String alignment;
  public int strength;
  public int dexterity;
  public int constitution;
  public int intelligence;
  public int wisdom;
  public int charisma;
  Character(String name, Species species, int level, String alignment, int strength, int dexterity, int constitution, int intelligence, int wisdom, int charisma) {
    this.name = name;
    this.species = species;
    this.level = level;
    this.fort = (int) Math.floor(level/3);
    this.ref = (int) Math.floor(level/3);
    this.will = (int) Math.floor(level/2)+2;
    this.bab = (int) Math.floor(level/2);
    this.alignment = alignment;
    this.strength = strength + this.species.strength;
    this.dexterity = dexterity + this.species.dexterity;
    this.constitution = constitution + this.species.constitution;
    this.intelligence = intelligence + this.species.intelligence;
    this.wisdom = wisdom + this.species.wisdom;
    this.charisma = charisma + this.species.charisma;
  }
  public void leveling(int amount) {
    this.level += amount;
    this.fort = (int) Math.floor(level/3);
    this.ref = (int) Math.floor(level/3);
    this.will = (int) Math.floor(level/2)+2;
    this.bab = (int) Math.floor(level/2);
  } 
}
