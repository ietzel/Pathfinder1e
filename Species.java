public class Species {
  Species(name, str, dex, con, int, wis, cha, size, water, land, air) {
    this.name = name;
    this.str = str;
    this.dex = dex;
    this.con = con;
    this.int = int;
    this.wis = wis;
    this.cha = cha;
    this.size = size;
    if(this.size == "s" | "S") {
      this.str -= 2;
      this.dex += 2;
    } else if(this.size == "l" | "L") {
      this.str += 2;
      this.dex -= 2;
    this.water = water;
    this.land = land;
    this.air = air;
  }
}
