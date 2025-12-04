import java.awt.Color;

public class Plane {
  public String name; 
  public Color color;
  public Species[] species;
  public Plane(String name, Color color, Species[] species) {
    this.name = name;
    this.color = color;
    this.species = species;
  }
}