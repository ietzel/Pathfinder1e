import java.awt.Color;

public class Terrain {
  public String name;
  public Color color;
  public boolean determined;
  public int movementcost;
  public double concealment;
  public int acrobaticsDC;
  public int stealthDC;
  public int ACbonus;
  public int reflexbonus;
  public int highgroundbonus;
  public int climbDC;
  public Terrain(String name, Color color, int movementcost, double concealment, int acrobaticsDC, int stealthDC, int ACbonus, int reflexbonus, int highgroundbonus, int climbDC) {
    this.name = name; 
    this.color = color;
    this.determined = determined;
    this.movementcost = movementcost;
    this.concealment = concealment; 
    this.acrobaticsDC = acrobaticsDC; 
    this.stealthDC = stealthDC; 
    this.ACbonus = ACbonus;
    this.reflexbonus = reflexbonus; 
    this.highgroundbonus = highgroundbonus;
    this.climbDC = climbDC;
  }
}