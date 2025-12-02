import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class PathfinderFirstEdition extends JPanel implements KeyListener {
    public int playerX3, playerY3, playerX2, playerY2, playerX1, playerY1 = 2;
    private int playerX = 54;
    private int playerY = 54;
    private int playerScore = 0;
    private boolean upPressed = false;
    private boolean downPressed = false;
    private boolean rightPressed = false;
    private boolean leftPressed = false;
    private boolean iPressed = false;
    private boolean oPressed = false;

    public Species[] SPECIES = {
    new Species("Aasimar", 0, 0, 0, 0, 2, 2, "M", 0, 8, 30, 8, 0, false),
    new Species("Catfolk", 0, 2, 0, 0, -2, 2, "M", 0, 8, 30, 8, 0, false),
    new Species("Changeling", 0, 0, -2, 0, 2, 2, "M", 0, 8, 30, 8, 0, false),
    new Species("Dhampir", 0, 2, -2, 0, 0, 2, "M", 0, 8, 30, 8, 0, false),
    new Species("Drow", 0, 2, -2, 0, 0, 2, "M", 0, 8, 30, 8, 0, false),
    new Species("Drow Noble", 0, 4, -2, 2, 2, 2, "M", 0, 8, 30, 8, 0, false),
    new Species("Duergar", 0, 0, 2, 0, 2, -4, "M", 0, 5, 20, 5, 0, false),
    new Species("Dwarf", 0, 0, 2, 0, 2, -2, "M", 0, 5, 20, 5, 0, false),
    new Species("Elf", 0, 2, -2, 2, 0, 0, "M", 0, 8, 30, 8, 0, false),
    new Species("Fetchling", 0, 2, 0, 0, -2, 2, "M", 0, 8, 30, 8, 0, false),
    new Species("Gathlain", 0, 2, -2, 0, 0, 2, "S", 0, 8, 30, 8, 40, false),
    new Species("Gnoll", 2, 2, 0, 0, 0, 0, "M", 0, 8, 30, 8, 0, false),
    new Species("Gnome", -2, 0, 2, 0, 0, 2, "S", 0, 5, 20, 5, 0, false),
    new Species("Goblin", -2, 4, 0, 0, 0, 2, "S", 0, 8, 30, 8, 0, false),
    new Species("Grippli", -2, 2, 0, 0, 2, 0, "S", 0, 15, 30, 20, 0, false),
    new Species("Half-Elf", 0, 0, 0, 0, 0, 0, "M", 0, 8, 30, 8, 0, true),
    new Species("Half-Orc", 0, 0, 0, 0, 0, 0, "M", 0, 8, 30, 8, 0, true),
    new Species("Halfling", -2, 2, 0, 0, 0, 2, "M", 0, 5, 20, 5, 0, false),
    new Species("Hobgoblin", 0, 2, 2, 0, 0, 0, "M", 0, 8, 30, 8, 0, false),
    new Species("Human", 0, 0, 0, 0, 0, 0, "M", 0, 8, 30, 8, 0, true),
    new Species("Ifrit", 0, 2, 0, 0, -2, 2, "M", 0, 8, 30, 8, 0, false),
    new Species("Kasatha", 0, 2, 0, 0, 2, 0, "M", 0, 8, 30, 8, 0, false),
    new Species("Kitsune", -2, 2, 0, 0, 0, 2, "M", 0, 8, 30, 8, 0, false),
    new Species("Kobold", -4, 2, -2, 0, 0, 0, "M", 0, 8, 30, 8, 0, false),
    new Species("Lizardfolk", 2, 2, 0, 0, 0, 0, "M", 0, 30, 30, 15, 0, false),
    new Species("Merfolk", 0, 2, 2, 0, 0, 2, "M", 0, 50, 5, 5, 0, false),
    new Species("Orc", 4, 0, 0, -2, -2, -2, "M", 0, 8, 30, 8, 0, false),
    new Species("Oread", 2, 0, 0, 0, 2, -2, "M", 0, 5, 20, 5, 0, false),
    new Species("Nagaji", 2, 0, 0, -2, 0, 2, "M", 0, 5, 20, 5, 0, false),
    new Species("Ratfolk", -2, 2, 0, 2, 0, 0, "S", 0, 5, 20, 5, 0, false),
    new Species("Suli", 2, 0, 0, -2, 0, 2, "M", 0, 8, 30, 8, 0, false),
    new Species("Svirfneblin", -2, 2, 0, 0, 2, -4, "S", 0, 5, 20, 5, 0, false),
    new Species("Sylph", 0, 2, -2, 2, 0, 0, "M", 0, 8, 30, 8, 0, false),
    new Species("Tengu", 0, 2, -2, 0, 2, 0, "M", 0, 8, 30, 8, 0, false),
    new Species("Tiefling", 0, 2, 0, 2, 0, -2, "M", 0, 8, 30, 8, 0, false),
    new Species("Trox", 6, 0, 0, -2, -2, -2, "L", 20, 8, 30, 8, 0, false),    
    new Species("Undine", -2, 2, 0, 0, 2, 0, "M", 0, 20, 30, 15, 0, false),
    new Species("Vanara", 0, 2, 0, 0, 2, -2, "M", 0, 15, 30, 20, 0, true),
    new Species("Vishkanya", 0, 2, 0, 0, -2, 2, "M", 0, 8, 30, 8, 0, false),
    new Species("Wayang", 0, 2, 0, 2, -2, 0, "S", 0, 5, 20, 5, 0, false),
    new Species("Wyrwood", 0, 2, 0, 2, 0, -2, "S", 0, 8, 30, 8, 0, false),
    new Species("Wyvaran", 0, 2, 0, -2, 2, 0, "M", 0, 8, 30, 8, 30, true)
    };

    public Species[] campaignA = {SPECIES[19]};
    public Species[] campaignB = {SPECIES[19]};
    public Species[] campaignC = {SPECIES[19]};
    public Species[] campaignD = {SPECIES[19]};
    public Species[] campaignE = {SPECIES[19]};
    public Species[] campaignF = {SPECIES[19]};
    public Species[] campaignG = {SPECIES[19]};
    public Species[] campaignH = {SPECIES[19]};
    public Species[] campaignI = {SPECIES[19]};
    public Species[] campaignJ = {SPECIES[19]};
    public Species[] campaignK = {SPECIES[19]};
    public Species[] campaignL = {SPECIES[19]};
    public Species[] campaignM = {SPECIES[19]};
    public Species[] campaignN = {SPECIES[19]};
    public Species[] campaignO = {SPECIES[19]};
    public Species[] campaignP = {SPECIES[19]};
    public Species[] campaignQ = {SPECIES[19]};
    public Species[] campaignR = {SPECIES[19]};
    public Species[] campaignS = {SPECIES[19]};
    public Species[] campaignT = {SPECIES[19]};
    public Species[] campaignU = {SPECIES[19]};
    public Species[] campaignV = {SPECIES[19]};
    public Species[] campaignW = {SPECIES[19]};
    public Species[] campaignX = {SPECIES[19]};
    public Species[] campaignY = {SPECIES[19]};
    public Species[] campaignZ = {SPECIES[19]};

    public Campaign[] CAMPAIGNS = {
    new Campaign("Arms Dealing", 42, campaignA),
    new Campaign("Redemption", 100, campaignB),
    new Campaign("Mining Incident", 10, campaignC),
    new Campaign("Reconciling", 250, campaignD),
    new Campaign("Sentient Forest", 69, campaignE),
    new Campaign("Uprising", 1000, campaignF),
    new Campaign("Mad Science", 1, campaignG),
    new Campaign("Mystery", 1, campaignH),
    new Campaign("Extreme Tomb", 1, campaignI),
    new Campaign("Fallacity", 1, campaignJ),
    new Campaign("Army Partition", 82861, campaignK),
    new Campaign("Persecution", 1, campaignL),
    new Campaign("", 1, campaignM),
    new Campaign("", 1, campaignN),
    new Campaign("", 1, campaignO),
    new Campaign("", 1, campaignP),
    new Campaign("", 1, campaignQ),
    new Campaign("", 1, campaignR),
    new Campaign("", 1, campaignS),
    new Campaign("", 1, campaignT),
    new Campaign("", 1, campaignU),
    new Campaign("", 1, campaignV),
    new Campaign("", 1, campaignW),
    new Campaign("", 1, campaignX),
    new Campaign("", 1, campaignY),
    new Campaign("", 1, campaignZ)
    };

    public String scale = "C";

    public Terrain[] TERRAIN = {
    new Terrain("Light Undergrowth", 2, 0.2, 2, 2, 0, 0, 0, -10),
    new Terrain("Heavy Undergrowth", 4, 0.3, 5, -5, 0, 0, 0, -10),
    new Terrain("Typical Trees", 0, 0.0, 0, 0, 2, 1, 0, -10),
    new Terrain("Massive Trees", 0, 0.0, 0, 0, 2, 2, 0, -10),
    new Terrain("Shallow Bog", 2, 0, 2, 0, 0, 0, 0, -10),
    new Terrain("Deep Bog", 4, 0, 2, 0, 2, 2, 0, -10),
    new Terrain("Gradual Slope", 0, 0, 0, 0, 0, 0, 1, -10),
    new Terrain("Steep Slope", 2, 0, 2, 0, 0, 0, 1, -10),
    new Terrain("Cliff", 0, 0, 0, 0, 0, 0, 0, 5),
    new Terrain("Chasm", 0, 0, 0, 0, 0, 0, 0, 5),
    new Terrain("Scree", 0, 0, 2, 2, 0, 0, 0, -10),
    new Terrain("Light Rubble", 0, 0, 2, 0, 0, 0, 0, -10),
    new Terrain("Dense Rubble", 2, 0, 5, 2, 0, 0, 0, -10),
    new Terrain("Sand Dunes", 1, 0, 1, 0, 0, 0, 0, -10),
    new Terrain("Water", 0, 0, 0, 0, 8, 4, 0, -10),
    new Terrain("Normal", 0, 0, 0, 0, 0, 0, 0, -10)
    };
	
    public Terrain[] ForestFundamentals = {TERRAIN[0], TERRAIN[1], TERRAIN[2], TERRAIN[3]};
    public double[] ForestA = {0.7, 0.2};
    public double[] ForestB = {0.7, 0.1};
    public Terrain[] SwampFundamentals = {TERRAIN[0], TERRAIN[1], TERRAIN[4], TERRAIN[5]};
    public double[] SwampA = {0.2, 0.2};
    public double[] SwampB = {0.4, 0.2};
    public Terrain[] AquaticFundamentals = {TERRAIN[14], TERRAIN[15]};
    public double[] AquaticA = {0.98};
    public double[] AquaticB = {0.02};
    public Terrain[] DesertFundamentals = {TERRAIN[0], TERRAIN[11], TERRAIN[12], TERRAIN[13]};
    public double[] DesertA = {0.05, 0.1, 0.05};
    public double[] DesertB = {0.5};
    public Terrain[] PlainsFundamentals = {TERRAIN[0], TERRAIN[1]};
    public double[] PlainsA = {0.2, 0.1};
    public double[] PlainsB = {0.03};
    public Terrain[] HillsFundamentals = {TERRAIN[6], TERRAIN[7], TERRAIN[8], TERRAIN[9], TERRAIN[0], TERRAIN[10], TERRAIN[12]};
    public double[] HillsA = {0.4, 0.5, 0.1};
    public double[] HillsB = {0.15};
    public Terrain[] MountainFundamentals = {TERRAIN[6], TERRAIN[7], TERRAIN[8], TERRAIN[0]};
    public double[] MountainA = {0.25, 0.55, 0.15, 0.05};
    public double[] MountainB = {0.1, 0.2, 0.2};

    public Environment[] ENVIRONMENTS = {
    new Environment("Forest", new Color(34, 139, 34, 204), ForestFundamentals, ForestA, ForestB),
    new Environment("Swamp", new Color(105, 131, 57, 178), SwampFundamentals, SwampA, SwampB),
    new Environment("Aquatic", new Color(235, 244, 250, 191), AquaticFundamentals, AquaticA, AquaticB),
    new Environment("Desert", new Color(229, 201, 159, 165), DesertFundamentals, DesertA, DesertB),
    new Environment("Plains", new Color(102, 204, 153, 242), PlainsFundamentals, PlainsA, PlainsB),
    new Environment("Hills", new Color(122, 135, 111, 216), HillsFundamentals, HillsA, HillsB),
    new Environment("Mountain", new Color(177, 171, 154, 229), MountainFundamentals, MountainA, MountainB),
    };
	
    public Species[] Inhabitants = {SPECIES[19]};

    public Plane[] PLANES = {
    new Plane("Material", Inhabitants),
    new Plane("Firstworld", Inhabitants),
    new Plane("Shadow", Inhabitants),
    new Plane("Earth", Inhabitants),
    new Plane("Water", Inhabitants),
    new Plane("Air", Inhabitants),
    new Plane("Fire", Inhabitants),
    new Plane("Positive", Inhabitants),
    new Plane("Negative", Inhabitants),
    new Plane("Ethereal", Inhabitants),
    new Plane("Elysium", Inhabitants),
    new Plane("Nirvana", Inhabitants),
    new Plane("Heaven", Inhabitants),
    new Plane("Utopia", Inhabitants),
    new Plane("Purgatory", Inhabitants),
    new Plane("Limbo", Inhabitants),
    new Plane("Abyss", Inhabitants),
    new Plane("Abbadon", Inhabitants),
    new Plane("Hell", Inhabitants),
    new Plane("Astral", Inhabitants)
    };

    public Environment[][][][] Universe = new Environment[4][5][10][10];
    public boolean[][][][] ExplorationStatus = new boolean[4][5][10][10];
    {
    for(int i = 0; i<4; i++) {
    for(int j = 0; j<5; j++) {
    for(int k = 0; k<10; k++) {
    for(int l = 0; l<10; l++) {
    int eIndex = (int) (Math.random()*7);
    if(eIndex > 6) {
        eIndex = 6;
    }
    Universe[i][j][k][l] = ENVIRONMENTS[eIndex];
    Universe[i][j][k][l].explored = false;
    }
    }
    }
    }
    }
    
    public String[] quotes = {
        "The tower of power!",
        "Well, I, uh.",
        "You get the house, the boat, the car, the plane!",
        "You mean to say that you were all, alone?",
        "Interesting, if true.",
        "What the heck is that, what the heck is that?",
	"Negligee.",

        "They just keep driving, driving, driving!",
        
        "You're kidding!",
        "Chocolate chip pancakes with chokecherry syrup?",
        "Cute, cute!",

        "Holy mackerel!",

        "Oh puddin'!",

        "Lasagna with six cheeses!",
        
        "A little bit of poison never hurt anybody.",

        "Here we go loopy loo, here we go loopy liy, here we go loop'dedoo, all on a saturday night!",
        "Hey'a'oh, you'a'oh, does your momma know, you're going down the road, to see your little girlie'o!",

	"Legend has it, until only then.",

        "Pro gansta!",

        "Hey flowrizzle, the super from across the street!",
        "Rock and roll, coochie-coo!",

        "So, how'd you like the play?",

        "Wogod!",

        "Look how big it is, look how big it is!",

        "Anything goes!",

        "Where, is the scroll?",

        "They can take it like champs!",

        "Godspeed.",

        "That's what we can say about it then!",

        "Fo to the sho, it is what you make it, and it can be mo."
    };
    
    public Spell[] SPELLS = {
    
    };
/*
    "0th: create water, detect magic, ghost sound, guidance, light, mending, purify food and drink, read magic, stabilize, touch of fatigue.",
    "1st: bless, burning hands, cause fear, command, comprehend languages, cure light wounds, detect chaos, detect evil, detect good, detect law, endure elements, obscuring mist, protection from chaos, protection from evil, protection from good, protection from law, sleep.",
    "2nd: aid, animal trance, bear's endurance, bull's strength, cat's grace, cure moderate wounds, darkness, delay poison, invisibility, mirror image, resist energy, scorching ray, see invisibility, web.",
    "3rd: animate dead, bestow curse, contagion, continual flame, cure serious wounds, daylight, deeper darkness, lightning bolt, neutralize poison, remove curse, remove disease, tongues.",
    "4th: cure critical wounds, minor creation, polymorph, restoration, stoneskin, wall of fire.",
    "5th: baleful polymorph, break enchantment, commune, heal, major creation, raise dead, true seeing, wall of stone."
*/

    public String[] skills = {
    "Acrobatics, Appraise, Bluff, Climb, Craft, Diplomacy, Disable Device, Disguise, Escape Artist, Fly, Handle Animal, Heal, Intimidate, Knowledge, Linguistics, Perception, Perform, Profession, Ride, Sense Motive, Sleight of Hand, Spellcraft, Stealth, Survival, Swim, Use Magic Device"
    };


    public String[] classskills = {
    "Craft, Handle Animal, Heal, Knowledge (all skills taken individually), Profession, Spellcraft, and Survival."
    };

    public String[] feats = {
    "Caster: Cleave, Combat Casting, Eschew Materials, Improved Initiative, Iron Will, item creation feats (all), Lightning Reflexes, metamagic feats (all), Natural Spell, Power Attack, Spell Focus, Spell Penetration, Toughness, and Weapon Focus.",
    "Finesse: Combat Expertise, Combat Reflexes, Dazzling Display, Deadly Stroke, Dodge, Greater Vital Strike, Improved Disarm, Improved Feint, Improved Trip, Improved Vital Strike, Mobility, Spring Attack, Shatter Defenses, Vital Strike, Weapon Finesse, and Whirlwind Attack.",
    "Unarmed: Combat Reflexes, Deflect Arrows, Dodge, Gorgon’s Fist, Improved Grapple, Improved Initiative, Improved Unarmed Strike, Medusa’s Wrath, Mobility, Scorpion Style, Snatch Arrows, Spring Attack, Stunning Fist, and Weapon Focus.",
    "Mounted: Improved Critical, Improved Initiative, Mounted Combat, Power Attack, Ride-By Attack, Skill Focus (Ride), Spirited Charge, Toughness, Trample, and Weapon Focus.",
    "Sword and Shield: Cleave, Great Cleave, Great Fortitude, Greater Vital Strike, Improved Bull Rush, Improved Critical, Improved Initiative, Improved Vital Strike, Power Attack, Shield Focus, Shield Master, Shield Slam, Two-Weapon Fighting, Vital Strike, and Weapon Focus.",
    "Two-Handed: Cleave, Great Cleave, Great Fortitude, Greater Vital Strike, Improved Bull Rush, Improved Critical, Improved Initiative, Improved Sunder, Improved Vital Strike, Power Attack, Vital Strike, and Weapon Focus.",
    "Two-Weapon: Combat Reflexes, Dodge, Double Slice, Greater Two-Weapon Fighting, Greater Vital Strike, Improved Critical, Improved Initiative, Improved Two-Weapon Fighting, Improved Vital Strike, Two-Weapon Defense, Two-Weapon Fighting, Two-Weapon Rend, Vital Strike, and Weapon Focus.",
    "Ranged: Deadly Aim, Far Shot, Greater Vital Strike, Improved Initiative, Improved Vital Strike, Manyshot, Pinpoint Targeting, Point-Blank Shot, Precise Shot, Rapid Reload, Rapid Shot, Shot on the Run, Vital Strike, and Weapon Focus.",
    "Skill: Armor Proficiency (all), Great Fortitude, Improved Initiative, Iron Will, Lightning Reflexes, Martial Weapon Proficiency, Run, Shield Proficiency, Skill Focus, and Toughness."
    };
    
    public PathfinderFirstEdition() {
    JFrame frame = new JFrame("Pathfinder First Edition");
    frame.setSize(500, 500);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.add(this);
    frame.setVisible(true);
    frame.addKeyListener(this);
    setFocusable(true);
    }

public void paint(Graphics g) {
    super.paint(g);
    if(scale == "C") {
	g.clearRect(0, 0, 500, 500);
        for(int i=0; i<225; i++) {
	g.setColor(Universe[playerX1][playerY1][playerX2][playerY2].color);
    	g.fillRect((((i-1)%15)*30)+1, (((i-1)/15)*30)-1, 29, 29);
	}
    } else if(scale == "B") {
	g.clearRect(0, 0, 500, 500);
        for(int i=0; i<10; i++) {
	for(int j=0; j<10; j++) {
	g.setColor(Color.BLACK);
	if(Universe[playerX1][playerY1][i][j].explored == true) {
	    g.setColor(Universe[playerX1][playerY1][i][j].color);
	}	
    	g.fillRect((i*30)-1, (j*30)-1, 29, 29);
	}
	}
    } else {
	g.clearRect(0, 0, 500, 500);
        for(int i=0; i<25; i++) {
	g.setColor(Universe[playerX1][playerY1][playerX2][playerY2].color);
    	g.fillRect((((i-1)%5)*30)+1, (((i-1)/5)*30)-1, 29, 29);
	}
    }
    g.setColor(Color.WHITE);
    g.fillOval(playerX, playerY, 30, 30);
    g.drawString("Player Level: " + playerScore, 50, 50);
}

public void moveplayers() {
    if (upPressed) {
        playerY -= 5;
    }
    if (downPressed) {
        playerY += 5;
    }
    if (rightPressed) {
        playerX += 5;
    }
    if (leftPressed) {
        playerX -= 5;
    }
    if (playerY < 0) {
        playerY = 0;
    }
    if (playerY > 400) {
        playerY = 400;
    }
    if (playerX < 0) {
        playerX = 0;
    }
    if (playerX > 400) {
        playerX = 400;
    }
    if(scale == "C") {
        playerX3 = (int) playerX / 30;
        playerY3 = (int) playerY / 30; 
    } else if(scale == "B") {
        playerX2 = (int) playerX / 30;
        playerY2 = (int) playerY / 30; 
	for(int i=0; i<10; i++) {
	for(int j=0; j<10; j++) {
	if(Universe[playerX1][playerY1][i][j].explored == false) {
	    if(playerX2 == i) {
		if(playerY2 == j) {
	            Universe[playerX1][playerY1][i][j].explored = true;
		}
	    }
	}
	}
	}
    } else {
        playerX1 = (int) playerX / 30;
        playerY1 = (int) playerY / 30;
    }
    if (iPressed) {
	switch(scale) {
		case "B":
			scale = "C";
			try {
            			Thread.sleep(333); 
        		} catch (InterruptedException e) {
            			Thread.currentThread().interrupt();
            			System.err.println("Thread interrupted during sleep: " + e.getMessage());
        		}
			break;
		case "A":
			scale = "B";
			try {
            			Thread.sleep(333); 
        		} catch (InterruptedException e) {
            			Thread.currentThread().interrupt();
            			System.err.println("Thread interrupted during sleep: " + e.getMessage());
        		}
			break;
		default:
			break;
	}
    }
    if (oPressed) {
	switch(scale) {
		case "C":
			scale = "B";
			try {
            			Thread.sleep(333); 
        		} catch (InterruptedException e) {
            			Thread.currentThread().interrupt();
            			System.err.println("Thread interrupted during sleep: " + e.getMessage());
        		}

			break;
		case "B":
			scale = "A";
			try {
            			Thread.sleep(333); 
        		} catch (InterruptedException e) {
            			Thread.currentThread().interrupt();
            			System.err.println("Thread interrupted during sleep: " + e.getMessage());
        		}
			break;
	}
    }
}

public void keyPressed(KeyEvent e) {
    if (e.getKeyCode() == KeyEvent.VK_W) {
        upPressed = true;
    }
    if (e.getKeyCode() == KeyEvent.VK_S) {
        downPressed = true;
    }
    if (e.getKeyCode() == KeyEvent.VK_D) {
        rightPressed = true;
    }
    if (e.getKeyCode() == KeyEvent.VK_A) {
        leftPressed = true;
    }
    if (e.getKeyCode() == KeyEvent.VK_I) {
        iPressed = true;
    }
    if (e.getKeyCode() == KeyEvent.VK_O) {
        oPressed = true;
    }

}

public void keyReleased(KeyEvent e) {
    if (e.getKeyCode() == KeyEvent.VK_W) {
        upPressed = false;
    }
    if (e.getKeyCode() == KeyEvent.VK_S) {
        downPressed = false;
    }
    if (e.getKeyCode() == KeyEvent.VK_D) {
        rightPressed = false;
    }
    if (e.getKeyCode() == KeyEvent.VK_A) {
        leftPressed = false;
    }
    if (e.getKeyCode() == KeyEvent.VK_I) {
        iPressed = false;
    }
    if (e.getKeyCode() == KeyEvent.VK_O) {
        oPressed = false;
    }
}

public void keyTyped(KeyEvent e) {
}

public static void main(String[] args) {
    PathfinderFirstEdition game = new PathfinderFirstEdition();
    while (true) { 
        game.moveplayers();
        game.repaint();
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

}
