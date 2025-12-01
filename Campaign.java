public class Campaign {
  public String name;
  public int creatures;
  public Species[] species;
  public Campaign(String name, int creatures, Species[] species) {
    this.name = name;
    this.creatures = creatures;
    this.species = species;
  }
}