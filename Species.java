public class Species {
  public String name;
  public int strength;
  public int dexterity;
  public int constitution;
  public int intelligence;
  public int wisdom;
  public int charisma;
  public String size;
  public int burrow;
  public int swim;
  public int land;
  public int climb;
  public int fly;
  public boolean variation;
  Species(String name, int strength, int dexterity, int constitution, int intelligence, int wisdom, int charisma, String size, int burrow, int swim, int land, int climb, int fly, boolean variation) {
    this.name = name;
    this.strength = strength;
    this.dexterity = dexterity;
    this.constitution = constitution;
    this.intelligence = intelligence;
    this.wisdom = wisdom;
    this.charisma = charisma;
    this.size = size;
    if(this.size == "s" || this.size == "S") {
      this.strength -= 2;
      this.dexterity += 2;
    } else if(this.size == "l" || this.size == "L") {
      this.strength += 2;
      this.dexterity -= 2;
    }
    this.burrow = burrow;
    this.swim = swim;
    this.land = land;
    this.climb = climb;
    this.fly = fly;
    this.variation = variation;
  }
}
