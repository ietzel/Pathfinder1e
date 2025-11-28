public class Character {
  Character(name, species, level, alignment, str, dex, con, int, wis, cha) {
    this.name = name;
    this.species = species;
    this.level = level;
    this.fort = Math.floor(level/3);
    this.ref = Math.floor(level/3);
    this.will = Math.floor(level/2)+2;
    this.bab = Math.floor(level/2);
    this.alignment = alignment;
    this.str = str + this.species.str;
    this.dex = dex + this.species.dex;
    this.con = con + this.species.con;
    this.int = int + this.species.int;
    this.wis = wis + this.species.wis;
    this.cha = cha + this.species.cha;
  }
  public leveling(amount) {
    this.level += amount;
    this.fort = Math.floor(level/3);
    this.ref = Math.floor(level/3);
    this.will = Math.floor(level/2)+2;
    this.bab = Math.floor(level/2);
  } 
}
