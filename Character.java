public class Character {
  Character(name, species, alignment, str, dex, con, int, wis, cha) {
    this.name = name;
    this.species = species;
    this.alignment = alignment;
    this.str = str + this.species.str;
    this.dex = dex + this.species.dex;
    this.con = con + this.species.con;
    this.int = int + this.species.int;
    this.wis = wis + this.species.wis;
    this.cha = cha + this.species.cha;
  }
}
