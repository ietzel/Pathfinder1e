public class Species {
  Species(name, str, dex, con, int, wis, cha, size, burrow, swim, land, climb, fly, variation) {
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
    this.burrow = burrow;
    this.swim = swim;
    this.land = land;
    this.air = air;
    this.climb = climb;
    this.fly = fly;
    if(variation === undefined) {
      this.variation = false;
    } else {
      this.variation = variation;
    }
  }
}
