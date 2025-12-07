public class Campaign {
  public String name;
  public int creatures;
  public Species[] species;
  public Environment targetEnvironment;
  public int structureWidth;
  public int structureDepth;
  public Campaign(String name, int creatures, Species[] species, Environment targetEnvironment, int structureWidth, int structureDepth) {
    this.name = name;
    this.creatures = creatures;
    this.species = species;
    this.targetEnvironment = targetEnvironment;
    this.structureWidth = structureWidth;
    this.structureDepth = structureDepth;
  }
}