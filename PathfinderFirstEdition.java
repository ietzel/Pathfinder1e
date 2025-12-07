import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class PathfinderFirstEdition extends JPanel implements KeyListener {
    public int playerX3 = 7;
    public int playerY3 = 7;
    public int playerX2 = 6;
    public int playerY2 = 6;
    public int playerXminusone = 6;
    public int playerYminusone = 6;
    public int playerX1 = 4;
    public int playerY1 = 4;
    private int playerX = playerX3 * 35;
    private int playerY = playerY3 * 35;
    @SuppressWarnings("FieldMayBeFinal")
    private int playerLevel = 0;
    private boolean upPressed, downPressed, rightPressed, leftPressed, iPressed, oPressed = false;

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
        new Species("Vanara", 0, 2, 0, 0, 2, -2, "M", 0, 15, 30, 20, 0, false),
        new Species("Vishkanya", 0, 2, 0, 0, -2, 2, "M", 0, 8, 30, 8, 0, false),
        new Species("Wayang", 0, 2, 0, 2, -2, 0, "S", 0, 5, 20, 5, 0, false),
        new Species("Wyrwood", 0, 2, 0, 2, 0, -2, "S", 0, 8, 30, 8, 0, false),
        new Species("Wyvaran", 0, 2, 0, -2, 2, 0, "M", 0, 8, 30, 8, 30, false)
    };

    public Character[] Characters = {
        new Character("Player", SPECIES[19], 1, 3, 3, "N", 8, 12, 10, 13, 15, 14),
    };

    public int scale = 3;

    public Terrain[] TERRAIN = {
        new Terrain("Light Undergrowth", new Color(102, 153, 51, 255), 2, 0.2, 2, 2, 0, 0, 0, -10),
        new Terrain("Heavy Undergrowth", new Color(34, 102, 34, 255), 4, 0.3, 5, -5, 0, 0, 0, -10),
        new Terrain("Typical Trees", new Color(0, 128, 0, 255), 0, 0.0, 0, 0, 2, 1, 0, -10),
        new Terrain("Massive Trees", new Color(0, 85, 0, 255), 0, 0.0, 0, 0, 2, 2, 0, -10),
        new Terrain("Shallow Bog", new Color(102, 102, 0, 255), 2, 0, 2, 0, 0, 0, 0, -10),
        new Terrain("Deep Bog", new Color(51, 51, 0, 255), 4, 0, 2, 0, 2, 2, 0, -10),
        new Terrain("Gradual Slope", new Color(153, 153, 102, 255), 0, 0, 0, 0, 0, 0, 1, -10),
        new Terrain("Steep Slope", new Color(128, 128, 128, 255), 2, 0, 2, 0, 0, 0, 1, -10),
        new Terrain("Cliff", new Color(80, 80, 80, 255), 0, 0, 0, 0, 0, 0, 0, 5),
        new Terrain("Chasm", new Color(40, 40, 40, 255), 0, 0, 0, 0, 0, 0, 0, 5),
        new Terrain("Scree", new Color(160, 160, 160, 255), 0, 0, 2, 2, 0, 0, 0, -10),
        new Terrain("Light Rubble", new Color(180, 110, 100, 255), 0, 0, 2, 0, 0, 0, 0, -10),
        new Terrain("Dense Rubble", new Color(130, 80, 70, 255), 2, 0, 5, 2, 0, 0, 0, -10),
        new Terrain("Sand Dunes", new Color(244, 164, 96, 255), 1, 0, 1, 0, 0, 0, 0, -10),
        new Terrain("Water", new Color(0, 102, 204, 255), 0, 0, 0, 0, 8, 4, 0, -10),
        new Terrain("Normal", new Color(100, 140, 80, 255), 0, 0, 0, 0, 0, 0, 0, -10)
    };

    Terrain[][] area = new Terrain[13][13];

    public Terrain[] ForestFundamentals = {TERRAIN[0], TERRAIN[1], TERRAIN[2], TERRAIN[3]};
    public double[] ForestA = {0.7, 0.2, 0.7, 0.1};
    public Terrain[] SwampFundamentals = {TERRAIN[0], TERRAIN[1], TERRAIN[4], TERRAIN[5]};
    public double[] SwampA = {0.2, 0.2, 0.4, 0.2};
    public Terrain[] AquaticFundamentals = {TERRAIN[14], TERRAIN[15]};
    public double[] AquaticA = {0.98, 0.02};
    public Terrain[] DesertFundamentals = {TERRAIN[0], TERRAIN[11], TERRAIN[12], TERRAIN[13]};
    public double[] DesertA = {0.05, 0.1, 0.05, 0.5};
    public Terrain[] PlainsFundamentals = {TERRAIN[0], TERRAIN[1]};
    public double[] PlainsA = {0.2, 0.1, 0.03};
    public Terrain[] HillsFundamentals = {TERRAIN[6], TERRAIN[7], TERRAIN[8], TERRAIN[9], TERRAIN[0], TERRAIN[10], TERRAIN[12]};
    public double[] HillsA = {0.4, 0.5, 0.1, 0.15};
    public Terrain[] MountainFundamentals = {TERRAIN[6], TERRAIN[7], TERRAIN[8], TERRAIN[0]};
    public double[] MountainA = {0.25, 0.55, 0.15, 0.05, 0.1, 0.2, 0.2};

    public Environment[] ENVIRONMENTS = {
        new Environment("Forest", 0, new Color(34, 139, 34, 204), ForestFundamentals, ForestA),
        new Environment("Hills", 1, new Color(122, 135, 111, 216), HillsFundamentals, HillsA),
        new Environment("Swamp", 2, new Color(105, 131, 57, 178), SwampFundamentals, SwampA),
        new Environment("Mountain", 3, new Color(177, 171, 154, 234), MountainFundamentals, MountainA),
        new Environment("Plains", 4, new Color(102, 204, 153, 242), PlainsFundamentals, PlainsA),
        new Environment("Desert", 5, new Color(234, 201, 159, 165), DesertFundamentals, DesertA),
        new Environment("Aquatic", 6, new Color(235, 244, 250, 191), AquaticFundamentals, AquaticA)
    };

    public Terrain determineTerrain(Environment env) {
        double initialTerrain = Math.random()*2;
        Terrain terrainA = TERRAIN[15];
        for(int i = 0; i < env.chancesA.length-1; i++) {
            if(initialTerrain <= env.chancesA[i]) {
                if(i == 0) {
                    if(initialTerrain >= 0) {
                        terrainA = env.terrain[0];
                    }   
                } else {
                    if(initialTerrain >= env.chancesA[i-1]) {
                        terrainA = env.terrain[i-1];
                        if(i == env.chancesA.length-1) {
                            if(initialTerrain > env.chancesA[env.chancesA.length-1]) {
                                terrainA = TERRAIN[15];
                            }
                        }
                    }   
                }
            }
        }
        return terrainA;
    }

    public Environment determineEnvironment() {
        int index = (int) (Math.random() * 20);
        int eIndex;
        if (index > 19) {
            index = 19;
        }
        eIndex = switch (index) {
            case 0, 1, 2 ->
                0;
            case 3, 4 ->
                1;
            case 6, 7 ->
                2;
            case 8, 9 ->
                3;
            case 10, 11, 12 ->
                4;
            case 13 ->
                5;
            case 14, 15 ->
                6;
            default ->
                Universe[playerX1][playerY1][playerXminusone][playerYminusone].index;
        };
        return ENVIRONMENTS[eIndex];
    }

    public Species[] Inhabitants = {SPECIES[19]};

    public Plane[][] PLANES = {
        {
            new Plane("Ethereal", new Color(127, 127, 127, 63), Inhabitants),
            new Plane("Negative", new Color(63, 63, 63, 63), Inhabitants),
            new Plane("Negative", new Color(63, 63, 63, 63), Inhabitants),
            new Plane("Astral", new Color(89, 89, 89, 15), Inhabitants),
            new Plane("Abyss", new Color(88, 51, 34, 127), Inhabitants),
            new Plane("Abbadon", new Color(30, 30, 26, 127), Inhabitants),
            new Plane("Hell", new Color(135, 13, 14, 127), Inhabitants)
        },
        {
            new Plane("Shadow", new Color(95, 95, 95, 95), Inhabitants),
            new Plane("Ethereal", new Color(127, 127, 127, 63), Inhabitants),
            new Plane("Ethereal", new Color(127, 127, 127, 63), Inhabitants),
            new Plane("Ethereal", new Color(127, 127, 127, 63), Inhabitants),
            new Plane("Astral", new Color(89, 89, 89, 15), Inhabitants),
            new Plane("Astral", new Color(89, 89, 89, 15), Inhabitants),
            new Plane("Astral", new Color(89, 89, 89, 15), Inhabitants),},
        {
            new Plane("Ethereal", new Color(127, 127, 127, 63), Inhabitants),
            new Plane("Earth", new Color(165, 42, 42, 191), Inhabitants),
            new Plane("Water", new Color(50, 100, 169, 217), Inhabitants),
            new Plane("Ethereal", new Color(127, 127, 127, 63), Inhabitants),
            new Plane("Astral", new Color(89, 89, 89, 15), Inhabitants),
            new Plane("Astral", new Color(89, 89, 89, 15), Inhabitants),
            new Plane("Astral", new Color(89, 89, 89, 15), Inhabitants)
        },
        {
            new Plane("Firstworld", new Color(127, 127, 127, 127), Inhabitants),
            new Plane("Ethereal", new Color(127, 127, 127, 63), Inhabitants),
            new Plane("Ethereal", new Color(127, 127, 127, 63), Inhabitants),
            new Plane("Astral", new Color(89, 89, 89, 15), Inhabitants),
            new Plane("Limbo", new Color(191, 168, 63, 127), Inhabitants),
            new Plane("Purgatory", new Color(151, 151, 151, 127), Inhabitants),
            new Plane("Utopia", new Color(127, 127, 191, 127), Inhabitants),},
        {
            new Plane("Ethereal", new Color(127, 127, 127, 63), Inhabitants),
            new Plane("Air", new Color(0, 191, 255, 127), Inhabitants),
            new Plane("Fire", new Color(128, 102, 215, 91), Inhabitants),
            new Plane("Ethereal", new Color(127, 127, 127, 63), Inhabitants),
            new Plane("Astral", new Color(89, 89, 89, 15), Inhabitants),
            new Plane("Astral", new Color(89, 89, 89, 15), Inhabitants),
            new Plane("Astral", new Color(89, 89, 89, 15), Inhabitants),},
        {
            new Plane("Material", new Color(159, 159, 159, 159), Inhabitants),
            new Plane("Ethereal", new Color(127, 127, 127, 63), Inhabitants),
            new Plane("Ethereal", new Color(127, 127, 127, 63), Inhabitants),
            new Plane("Ethereal", new Color(127, 127, 127, 63), Inhabitants),
            new Plane("Astral", new Color(89, 89, 89, 15), Inhabitants),
            new Plane("Astral", new Color(89, 89, 89, 15), Inhabitants),
            new Plane("Astral", new Color(89, 89, 89, 15), Inhabitants),},
        {
            new Plane("Ethereal", new Color(127, 127, 127, 63), Inhabitants),
            new Plane("Positive", new Color(191, 191, 191, 191), Inhabitants),
            new Plane("Positive", new Color(191, 191, 191, 191), Inhabitants),
            new Plane("Astral", new Color(89, 89, 89, 15), Inhabitants),
            new Plane("Elysium", new Color(255, 215, 0, 127), Inhabitants),
            new Plane("Nirvana", new Color(41, 122, 78, 127), Inhabitants),
            new Plane("Heaven", new Color(212, 175, 55, 127), Inhabitants),}
    };

    public Environment[][][][] Universe = new Environment[7][7][11][11];

{
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                for (int k = 0; k < 11; k++) {
                    for (int l = 0; l < 11; l++) {
                        int eIndex = (int) (Math.random() * 7);
                        if (eIndex > 6) {
                            eIndex = 6;
                        }
                        // Create a NEW Environment instance for every tile
                        Environment baseEnv = ENVIRONMENTS[eIndex];
                        Universe[i][j][k][l] = new Environment(
                            baseEnv.name, 
                            baseEnv.index, 
                            baseEnv.color, 
                            baseEnv.terrain, 
                            baseEnv.chancesA
                        );
                    }
                }
            }
        }
        Universe[4][4][6][6].explored = true;
    }

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

    public Campaign[] CAMPAIGNS = {
        new Campaign("Arms Dealing", 42, campaignA, ENVIRONMENTS[0], 7, 11),
        new Campaign("Mining Incident", 69, campaignB, ENVIRONMENTS[3], 7, 11),
        new Campaign("Reconciling", 1000, campaignC, ENVIRONMENTS[0], 7, 11),
        new Campaign("Hospitality", 1, campaignD, ENVIRONMENTS[3], 7, 11),
        new Campaign("Bunker Beasts", 1, campaignE, ENVIRONMENTS[3], 7, 11),
        new Campaign("Uprising", 1, campaignF, ENVIRONMENTS[6], 7, 11),
        new Campaign("Mad Science", 82861, campaignG, ENVIRONMENTS[4], 7, 11),
        new Campaign("Army Partition", 1, campaignH, ENVIRONMENTS[1], 7, 11),
        new Campaign("Persecution", 1, campaignI, ENVIRONMENTS[2], 7, 11),

        new Campaign("Tower", 100, campaignJ, ENVIRONMENTS[1], 7, 11),
        new Campaign("Redemption", 250, campaignK, ENVIRONMENTS[2], 7, 11),
        new Campaign("Fallacity", 1, campaignL, ENVIRONMENTS[5], 7, 11),

        new Campaign("Mystery", 1, campaignM, ENVIRONMENTS[5], 7, 11)
    };


    public String[] quotes = {
        "The tower of power!",
        "Well, I, uh.",
        "You get the house, the boat, the car, the plane!",
        "You mean to say that you were all, alone?",
        "Interesting, if true.",
        "What the heck is that, what the heck is that?",
        "Just a disaster recovery!",
        "Negligee.",
        "You mystify me!",
        "Uh-oh, uh-oh.",
        "They just keep driving, driving, driving!",
        "It's decomposing.",        
        "You're kidding!",
        "Chocolate chip pancakes with chokecherry syrup?",
        "Cute, cute!",
        "Holy mackerel!",
        "You gotta be kidding me.",
        "I like some toast with my pills!",
        "Oh puddin'!",
        "Lasagna with six cheeses!",
        "Ja Ju Je Jo!",
        "Aight thin",
        "Up high, down low, in the middle, tickle tickle.",
        "A little bit of poison never hurt anybody.",
        "Here we go loopy loo, here we go loopy liy, here we go loop'dedoo, all on a saturday night!",
        "Hey'a'oh, you'a'oh, does your momma know, you're going down the road, to see your little girlie'o!",
        "Oh $#*^ I forgot the kit.",
        "Dun dun dun.",
        "Take a little rest time, watch a little anime.",
        "It was because tin omen.",
        "Oh my!",
        "Is that, atheist?",
        "It is like a kazillion bajillion.",
        "Legend has it, until only then.",
        "Pro gansta!",
        "Remember the guy who had a gang-bang fetish?",
        "Hey flowrizzle, the super from across the street!",
        "Rock and roll, coochie-coo!",
        "So, how'd you like the play?",
        "Wogod!",
        "He'll kill us all!",
        "Look how big it is, look how big it is!",
        "Anything goes!",
        "You don't wanna know man!",
        "So, how's your love life?",
        "Here comes the nasty.",
        "Where, is the scroll?",
        "Sorry I'm tardy!",
        "Chainsaw seppuku!",
        "Permanent malapropism.",
        "Keep falling, keep dying, deep on drowning me in your love.",
        "Young boy!",
        "I lost the game.",
        "They can take it like champs!",
        "Godspeed.",
        "That's what we can say about it then!",
        "They had this fantasy, where they thought they could triple the ripple.",
        "This is the most intelligent, system.",
        "It's like the most schizo, ciscoaffective.",
        "Spinware is money hacking.",
        "Heyhey, hohhoh!",
        "Fo to the sho, it is what you make it, and it can be mo.",
        "I didn't know it was an afro roast!",
        "Don't you know I'm a human 'bein, and I love me some teetees?",
        "In the paytheist, in the paytheist, in the paytheist, in the paytheist. Let's say we strike a deal, not reinvent the wheel, inthepaytheistinthepaytheistinthepaytheistinthepaytheistinthepaytheist. In the paytheist in the paytheist in the paytheist in the paytheist in the paytheist in the paytheist in the paytheist in the paytheist!",
        "What are you doing, buster?",
        "So funny, shorty honey!",
        "Silly no he didn't.",
        "It was at the gift shop today, it was at the gift shop today.",
        "Come, get yourself all wet, let me get a hizzae.",
        "And the Linux, one of the paingaintheists.",
        "It's never going to annabella again.",
        "They cried grenades that day.",
        "I've come to kick gum and chew @$$. As a professional, I'm all out of @$$.",
        "A day without sunshine is like night, it is now a club banger!",
        "You don't even know that you're alive, %*^&#!",
        "Spinal fracking fluid injection.",
        "No is my favorite emotion.",
        "Do the thing you fear most and the death of fear is certain.",
        "A person's tongue can give you the taste of his heart.",
        "If your past is limited your future is boundless."
    };

    public Spell[] SPELLS = {
        // Level 0
        new Spell("create water", new Conjuration("conjuration", 2, false, 0, 0, 0, 0, false, 0, 0, false, 0, false, false, false, false), 0, 1, true, true, false, 0, 25, 2, -1, 0, "none", false), // 2 for gallonsofwaterperlevel
        new Spell("detect magic", new Divination("divination", true, 0, false, false, "none", false, false, false), 0, 1, true, true, false, 0, 60, 0, 0, 10, "none", false), // detectsmagic = true
        new Spell("ghost sound", new Illusion("illusion", true, false, false), 0, 1, true, true, false, 0, 25, 2, 0, 1, "will negates", false), // ghostsound = true
        new Spell("guidance", new Divination("divination", false, 1, false, false, "none", false, false, false), 0, 1, true, true, false, 0, 5, 0, -1, 0, "will negates", true), // oneattacksaveskillcheck = 1
        new Spell("light", new Evocation("evocation", true, 0, 0, "none", 0, false), 0, 1, true, false, true, 0, 5, 0, 0, 100, "none", false), // light = true
        new Spell("mending", new Transmutation("transmutation", true, false, "none", "none"), 0, 100, true, true, false, 0, 10, 0, -1, 0, "will negates", true), // mends = true
        new Spell("purify food and drink", new Transmutation("transmutation", false, true, "none", "none"), 0, 1, true, true, false, 0, 10, 0, -1, 0, "will negates", true), // purifies = true
        new Spell("read magic", new Divination("divination", false, 0, true, false, "none", false, false, false), 0, 1, true, true, true, 0, 0, 0, 0, 100, "none", false), // readmagic = true
        new Spell("stabilize", new Conjuration("conjuration", 0, true, 0, 0, 0, 0, false, 0, 0, false, 0, false, false, false, false), 0, 1, true, true, false, 0, 25, 2, -1, 0, "none", false), // stabilizer = true
        new Spell("touch of fatigue", new Necromancy("necromancy", true, false, false, false, false), 0, 1, true, true, false, 0, 5, 0, 0, 1, "fort negates", true), // fatigue = true
        // Level 1
        new Spell("bless", new Enchantment("enchantment", true, false, false, false, false), 1, 1, true, true, true, 0, 50, 0, 0, 10, "none", true), // attackrollfearsavebonus = true
        new Spell("burning hands", new Evocation("evocation", false, 1, 5, "fire", 0, false), 1, 1, true, true, false, 0, 15, 0, -1, 0, "ref half", true), // damageperlevel=1 (1d4/CL), maxdamagelevel=5, damagetype=fire
        new Spell("cause fear", new Necromancy("necromancy", false, true, false, false, false), 1, 1, true, true, false, 0, 25, 2, 0, 1, "will partial", false), // shake = true
        new Spell("command", new Enchantment("enchantment", false, true, false, false, false), 1, 1, true, false, false, 0, 25, 2, 1, 0, "will negates", true), // command = true
        new Spell("comprehend languages", new Divination("divination", false, 0, false, true, "none", false, false, false), 1, 1, true, true, true, 0, 0, 0, 0, 100, "none", false), // comprehendlanguages = true
        new Spell("cure light wounds", new Conjuration("conjuration", 0, false, 1, 1, 5, 0, false, 0, 0, false, 0, false, false, false, false), 1, 1, true, true, false, 0, 5, 0, -1, 0, "will half", true), // basehealing=1, healingperlevel=1, maxhealingperlevel=5
        new Spell("detect chaos", new Divination("divination", false, 0, false, false, "chaos", false, false, false), 1, 1, true, true, true, 0, 60, 0, 0, 100, "none", false), // detecting = chaos
        new Spell("detect evil", new Divination("divination", false, 0, false, false, "evil", false, false, false), 1, 1, true, true, true, 0, 60, 0, 0, 100, "none", false), // detecting = evil
        new Spell("detect good", new Divination("divination", false, 0, false, false, "good", false, false, false), 1, 1, true, true, true, 0, 60, 0, 0, 100, "none", false), // detecting = good
        new Spell("detect law", new Divination("divination", false, 0, false, false, "law", false, false, false), 1, 1, true, true, true, 0, 60, 0, 0, 100, "none", false), // detecting = law
        new Spell("endure elements", new Abjuration("abjuration", 1, 1, 0, 0, false, false, "none", 0, "none", false, 0, false), 1, 1, true, true, false, 0, 5, 0, 14400, 0, "none", true), // existcomfortablycold=1, existcomfortablyhot=1
        new Spell("obscuring mist", new Conjuration("conjuration", 0, false, 0, 0, 0, 20, false, 0, 0, false, 0, false, false, false, false), 1, 1, true, true, false, 0, 20, 0, 0, 10, "none", false), // obscurationradius = 20
        new Spell("protection from chaos", new Abjuration("abjuration", 0, 0, 2, 2, true, true, "chaos", 0, "none", false, 0, false), 1, 1, true, true, true, 0, 5, 0, 0, 10, "will negates", true), // deflectionbonus=2, savebonus=2, contactprevention=true, againstalignment=chaos
        new Spell("protection from evil", new Abjuration("abjuration", 0, 0, 2, 2, true, true, "evil", 0, "none", false, 0, false), 1, 1, true, true, true, 0, 5, 0, 0, 10, "will negates", true), // deflectionbonus=2, savebonus=2, contactprevention=true, againstalignment=evil
        new Spell("protection from good", new Abjuration("abjuration", 0, 0, 2, 2, true, true, "good", 0, "none", false, 0, false), 1, 1, true, true, true, 0, 5, 0, 0, 10, "will negates", true), // deflectionbonus=2, savebonus=2, contactprevention=true, againstalignment=good
        new Spell("protection from law", new Abjuration("abjuration", 0, 0, 2, 2, true, true, "law", 0, "none", false, 0, false), 1, 1, true, true, true, 0, 5, 0, 0, 10, "will negates", true), // deflectionbonus=2, savebonus=2, contactprevention=true, againstalignment=law
        new Spell("sleep", new Enchantment("enchantment", false, false, true, false, false), 1, 1, true, true, false, 0, 100, 10, 0, 10, "will negates", true), // sleep = true
        // Level 2
        new Spell("aid", new Enchantment("enchantment", true, false, false, false, false), 2, 1, true, true, true, 0, 5, 0, 0, 10, "none", true), // attackrollfearsavebonus = true
        new Spell("animal trance", new Enchantment("enchantment", false, false, false, true, true), 2, 1, true, true, false, 0, 25, 2, 7, 0, "will negates", true), // maxtemphpeachcasterlevel=true, entrance=true (simplifying based on trance effect)
        new Spell("bears endurance", new Transmutation("transmutation", false, false, "constitution", "none"), 2, 1, true, true, false, 0, 5, 0, 0, 10, "will negates", true), // plusfourabilitybonus = constitution
        new Spell("bulls strength", new Transmutation("transmutation", false, false, "strength", "none"), 2, 1, true, true, false, 0, 5, 0, 0, 10, "will negates", true), // plusfourabilitybonus = strength
        new Spell("cats grace", new Transmutation("transmutation", false, false, "dexterity", "none"), 2, 1, true, true, false, 0, 5, 0, 0, 10, "will negates", true), // plusfourabilitybonus = dexterity
        new Spell("cure moderate wounds", new Conjuration("conjuration", 0, false, 2, 1, 10, 0, false, 0, 0, false, 0, false, false, false, false), 2, 1, true, true, false, 0, 5, 0, -1, 0, "will half", true), // basehealing=2, healingperlevel=1, maxhealingperlevel=10
        new Spell("darkness", new Evocation("evocation", false, 0, 0, "none", 1, false), 2, 1, true, false, true, 0, 5, 0, 0, 10, "none", false), // modifylightbysteps = 1 (decreases light by one step)
        new Spell("delay poison", new Conjuration("conjuration", 0, false, 0, 0, 0, 0, true, 0, 0, false, 0, false, false, false, false), 2, 1, true, true, true, 0, 5, 0, 0, 600, "fort negates", false), // poisonimmunity = true
        new Spell("invisibility", new Illusion("illusion", false, true, false), 2, 1, true, true, true, 0, 5, 0, 0, 10, "will negates", true), // invisibility = true
        new Spell("mirror image", new Illusion("illusion", false, false, true), 2, 1, true, true, false, 0, 0, 0, 0, 10, "none", false), // mirrorimage = true
        new Spell("resist energy", new Abjuration("abjuration", 0, 0, 0, 0, false, false, "none", 10, "choose", false, 0, false), 2, 1, true, true, true, 0, 5, 0, 0, 100, "fort negates", true), // energyresistance=10, resistenergytype=choose
        new Spell("scorching ray", new Evocation("evocation", false, 4, 0, "fire", 0, false), 2, 1, true, true, false, 0, 25, 2, -1, 0, "none", true), // damageperlevel=4 (for 4d6 per ray), damagetype=fire
        new Spell("see invisibility", new Divination("divination", false, 0, false, false, "none", true, false, false), 2, 1, true, true, false, 0, 0, 0, 0, 100, "none", false), // seeinvisibility = true
        new Spell("web", new Conjuration("conjuration", 0, false, 0, 0, 0, 0, false, 20, 0, false, 0, false, false, false, false), 2, 1, true, true, false, 0, 100, 10, 0, 100, "ref negates", false), // grappleradius = 20
        // Level 3
        new Spell("animate dead", new Necromancy("necromancy", false, false, true, false, false), 3, 1, true, true, false, 25, 5, 0, -1, 0, "none", false), // animatefourhdpercasterlevel = true
        new Spell("bestow curse", new Necromancy("necromancy", false, false, false, true, false), 3, 1, true, true, false, 0, 25, 2, -1, 0, "none", false), // abilitiesattacksaveskillchecksdecreasebyoneandsixteenpercenttotakenoaction = true
        new Spell("contagion", new Necromancy("necromancy", false, false, false, false, true), 3, 1, true, true, false, 0, 5, 0, -1, 0, "fort negates", true), // disease = true
        new Spell("continual flame", new Evocation("evocation", true, 0, 0, "none", 0, true), 3, 1, true, true, false, 50, 5, 0, 999999, 999999, "none", false), // light=true, continualflame=true
        new Spell("cure serious wounds", new Conjuration("conjuration", 0, false, 3, 1, 15, 0, false, 0, 0, false, 0, false, false, false, false), 3, 1, true, true, false, 0, 5, 0, -1, 0, "will half", true), // basehealing=3, healingperlevel=1, maxhealingperlevel=15
        new Spell("daylight", new Evocation("evocation", true, 0, 0, "none", 0, false), 3, 1, true, true, false, 0, 25, 2, -1, 0, "none", false), // light = true
        new Spell("deeper darkness", new Evocation("evocation", false, 0, 0, "none", 2, false), 3, 1, true, true, true, 0, 5, 0, 0, 100, "none", false), // modifylightbysteps = 2 (decreases light by two steps)
        new Spell("lightning bolt", new Evocation("evocation", false, 1, 10, "electricity", 0, false), 3, 1, true, true, false, 0, 120, 0, -1, 0, "ref half", true), // damageperlevel=1 (1d6/CL), maxdamagelevel=10, damagetype=electricity
        new Spell("neutralize poison", new Conjuration("conjuration", 0, false, 0, 0, 0, 0, false, 0, 1, false, 0, false, false, false, false), 3, 1, true, true, true, 0, 5, 0, -1, 0, "will negates", true), // neutralizespoisonroundsperlevel = 1
        new Spell("remove curse", new Abjuration("abjuration", 0, 0, 0, 0, false, false, "none", 0, "none", true, 0, false), 3, 1, true, true, false, 0, 5, 0, -1, 0, "will negates", true), // removecurses = true
        new Spell("remove disease", new Conjuration("conjuration", 0, false, 0, 0, 0, 0, false, 0, 0, true, 0, false, false, false, false), 3, 1, true, true, false, 0, 5, 0, -1, 0, "fort negates", true), // removesdiseases = true
        new Spell("tongues", new Divination("divination", false, 0, false, false, "none", false, true, false), 3, 1, true, true, true, 0, 5, 0, 0, 100, "will negates", false), // tongues = true
        // Level 4
        new Spell("cure critical wounds", new Conjuration("conjuration", 0, false, 4, 1, 20, 0, false, 0, 0, false, 0, false, false, false, false), 4, 1, true, true, false, 0, 5, 0, -1, 0, "will half", true), // basehealing=4, healingperlevel=1, maxhealingperlevel=20
        new Spell("minor creation", new Conjuration("conjuration", 0, false, 0, 0, 0, 0, false, 0, 0, false, 1, false, false, false, false), 4, 10, true, true, false, 0, 0, 0, 0, 600, "none", false), // createscubicfeetofmatterperlevel = 1
        new Spell("polymorph", new Transmutation("transmutation", false, false, "none", "target"), 4, 1, true, true, false, 0, 5, 0, 0, 10, "will negates", true), // polymorph = target
        new Spell("restoration", new Conjuration("conjuration", 0, false, 0, 0, 0, 0, false, 0, 0, false, 0, true, false, false, false), 4, 1, true, true, false, 1000, 5, 0, -1, 0, "will negates", true), // removestwoabilitydamageandnegativelevel = true
        new Spell("stoneskin", new Abjuration("abjuration", 0, 0, 0, 0, false, false, "none", 0, "none", false, 10, false), 4, 1, true, true, false, 250, 5, 0, 0, 100, "will negates", true), // dradamantineuptopercasterlevelmaxfifteen = 10 (for DR 10)
        new Spell("wall of fire", new Evocation("evocation", false, 0, 0, "fire", 0, false), 4, 1, true, true, true, 0, 100, 10, 10, 1, "none", true), // damagetype=fire
        // Level 5
        new Spell("baleful polymorph", new Transmutation("transmutation", false, false, "none", "targetpermanent"), 5, 1, true, true, false, 0, 25, 2, 999999, 999999, "fort negates", true), // polymorph = targetpermanent (to differentiate from regular polymorph)
        new Spell("break enchantment", new Abjuration("abjuration", 0, 0, 0, 0, false, false, "none", 0, "none", false, 0, true), 5, 1, true, true, false, 0, 25, 2, -1, 0, "none", false), // freefromenchantmentstransmutations = true
        new Spell("commune", new Divination("divination", false, 0, false, false, "none", false, false, true), 5, 1, true, true, true, 500, 0, 0, 0, 1, "none", false), // commune = true
        new Spell("heal", new Conjuration("conjuration", 0, false, 150, 0, 0, 0, false, 0, 0, false, 0, false, true, false, false), 5, 1, true, true, false, 0, 5, 0, -1, 0, "will negates", true), // basehealing=150 (for 150 hp), removesafflictions = true
        new Spell("major creation", new Conjuration("conjuration", 0, false, 0, 0, 0, 0, false, 0, 0, false, 1, false, false, false, false), 5, 100, true, true, false, 0, 25, 2, 0, 1, "none", false), // createscubicfeetofmatterperlevel = 1
        new Spell("raise dead", new Conjuration("conjuration", 0, false, 0, 0, 0, 0, false, 0, 0, false, 0, false, true, true, false), 5, 1, true, true, true, 5000, 5, 0, -1, 0, "none", true), // removesafflictions=true, raisesdead=true
        new Spell("true seeing", new Divination("divination", false, 0, false, false, "none", true, false, false), 5, 1, true, true, false, 500, 5, 0, 0, 10, "will negates", true), // seeinvisibility = true
        new Spell("wall of stone", new Conjuration("conjuration", 0, false, 0, 0, 0, 0, false, 0, 0, false, 0, false, false, false, true), 5, 1, true, true, true, 0, 100, 10, -1, 0, "reflex negates", false) // stonewallsquareperlevel = true
    };

    public String[] classskills = {
        "Craft(all) Heal, Knowledge(all), Profession, Spellcraft, and Survival."
    };

    public String[] feats = {
        "Caster: Cleave, Combat Casting, Improved Initiative, Iron Will, item creation feats (all), Lightning Reflexes, metamagic feats (all), Power Attack, Spell Focus, Spell Penetration, Toughness, and Weapon Focus.",
        "Finesse: Combat Expertise, Combat Reflexes, Dazzling Display, Deadly Stroke, Dodge, Greater Vital Strike, Improved Disarm, Improved Feint, Improved Trip, Improved Vital Strike, Mobility, Spring Attack, Shatter Defenses, Vital Strike, Weapon Finesse, and Whirlwind Attack.",
        "Unarmed: Combat Reflexes, Deflect Arrows, Dodge, Gorgon’s Fist, Improved Grapple, Improved Initiative, Improved Unarmed Strike, Medusa’s Wrath, Mobility, Scorpion Style, Snatch Arrows, Spring Attack, Stunning Fist, and Weapon Focus.",
        "Sword and Shield: Cleave, Great Cleave, Great Fortitude, Greater Vital Strike, Improved Bull Rush, Improved Critical, Improved Initiative, Improved Sunder, Improved Vital Strike, Power Attack, Shield Focus, Shield Master, Shield Slam, Two-Weapon Fighting, Vital Strike, and Weapon Focus.",
        "Two-Handed: Cleave, Great Cleave, Great Fortitude, Greater Vital Strike, Improved Bull Rush, Improved Critical, Improved Initiative, Improved Sunder, Improved Vital Strike, Power Attack, Vital Strike, and Weapon Focus.",
        "Two-Weapon: Combat Reflexes, Dodge, Double Slice, Greater Two-Weapon Fighting, Greater Vital Strike, Improved Critical, Improved Initiative, Improved Two-Weapon Fighting, Improved Vital Strike, Two-Weapon Defense, Two-Weapon Fighting, Two-Weapon Rend, Vital Strike, and Weapon Focus.",
        "Ranged: Deadly Aim, Far Shot, Greater Vital Strike, Improved Initiative, Improved Vital Strike, Manyshot, Pinpoint Targeting, Point-Blank Shot, Precise Shot, Rapid Reload, Rapid Shot, Shot on the Run, Vital Strike, and Weapon Focus.",
        "Skill: Armor Proficiency (all), Great Fortitude, Improved Initiative, Iron Will, Lightning Reflexes, Martial Weapon Proficiency, Run, Shield Proficiency, Skill Focus, and Toughness."
    };

    @SuppressWarnings("OverridableMethodCallInConstructor")
    public PathfinderFirstEdition() {
        generateLocalTerrain();
        JFrame frame = new JFrame("Pathfinder First Edition");
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(this);
        frame.setVisible(true);
        frame.addKeyListener(this);
        setFocusable(true);
    }

    @Override
    @SuppressWarnings({"StringEquality", "ConvertToStringSwitch"})
    public void paint(Graphics g) {
        super.paint(g);
        switch (scale) {
            case 3 -> {
                g.clearRect(0, 0, 500, 500);
                for (int i = 0; i < 13; i++) {
                    for (int j = 0; j < 13; j++) {
                        g.setColor(area[i][j].color);
                        //}
                        g.fillRect((i * 35) - 1, (j * 35) - 1, 34, 34);
                    }
                }
            }
            case 2 -> {
                g.clearRect(0, 0, 500, 500);
                for (int i = 0; i < 11; i++) {
                    for (int j = 0; j < 11; j++) {
                        g.setColor(Color.BLACK);
                        if (Universe[playerX1][playerY1][i][j].explored == true) {
                            g.setColor(Universe[playerX1][playerY1][i][j].color);
                        }
                        g.fillRect((i * 35) - 1, (j * 35) - 1, 34, 34);
                    }
                }
            }
            case 1 -> {
                g.clearRect(0, 0, 500, 500);
                for (int i = 0; i < 7; i++) {
                    for (int j = 0; j < 7; j++) {
                        g.setColor(PLANES[i][j].color);
                        g.fillRect((i * 35) - 1, (j * 35) - 1, 34, 34);
                    }
                }
            }
            default -> {
            }
        }
        g.setColor(Color.WHITE);
        g.fillOval(playerX, playerY, 30, 30);
        g.drawString("Player Level: " + playerLevel, 50, 50);
    }
    
    // NEW METHOD: Generates the 13x13 terrain map for the current local area.
    public void generateLocalTerrain() {
        // The environment is determined by the parent map coordinates (playerX1, playerY1, playerX2, playerY2)
        Environment currentEnv = Universe[playerX1][playerY1][playerX2][playerY2];
        
        for (int i = 0; i < 13; i++) {
            for (int j = 0; j < 13; j++) {
                area[i][j] = determineTerrain(currentEnv);
                if (area[i][j].determined == false) {
                    area[i][j].determined = true;
                }
            }
        }
    }

    @SuppressWarnings({"ConvertToStringSwitch", "StringEquality"})
    public void moveplayers() {
        if (upPressed) {
            if(Characters[0].species.fly == 0) {
                playerY -= (int) Math.floor(Characters[0].species.land/5);
            } else {
                playerY -= (int) Math.floor(Characters[0].species.fly/5);
            }
        }
        if (downPressed) {
            if(Characters[0].species.fly == 0) {
                playerY += (int) Math.floor(Characters[0].species.land/5);
            } else {
                playerY += (int) Math.floor(Characters[0].species.fly/5);
            }
        }
        if (rightPressed) {
            if(Characters[0].species.fly == 0) {
                playerX += (int) Math.floor(Characters[0].species.land/5);
            } else {
                playerX += (int) Math.floor(Characters[0].species.fly/5);
            }
        }
        if (leftPressed) {
            if(Characters[0].species.fly == 0) {
                playerX -= (int) Math.floor(Characters[0].species.land/5);
            } else {
                playerX -= (int) Math.floor(Characters[0].species.fly/5);
            }
        }
        if (playerY < 0) {
            playerY = 0;
        }

        if (playerX < 0) {
            playerX = 0;
        }

        switch (scale) {
            case 3 -> {
                if (playerY > 420) {
                    playerY = 420;
                }   if (playerX > 420) {
                    playerX = 420;
                }   
                playerX3 = (int) playerX / 35;
                playerY3 = (int) playerY / 35;
                for(Character Character : Characters) {
                    if (area[playerX3][playerX3].movementcost > 1) {
                        Character.species.land /= area[playerX3][playerX3].movementcost;
                    } else {
                        Character.species.land = SPECIES[19].land;
                    }
                    if (area[playerX3][playerX3].concealment > 0.0) {
                        Character.concealment = area[playerX3][playerX3].concealment;
                    } else {
                        Character.concealment = 0.0;
                    }
                    if (area[playerX3][playerX3].reflexbonus > 0) {
                        Character.ref = area[playerX3][playerX3].reflexbonus;
                    } else {
                        Character.ref = (int) Math.floor(Character.level / 3);
                    }
                }
            }
            case 2 -> {
                if (playerY > 350) {
                    playerY = 350;
                }   if (playerX > 350) {
                    playerX = 350;
                }   
                playerX2 = (int) playerX / 35;
                playerY2 = (int) playerY / 35;
                // FIX START: Simplified exploration logic for scale == 2.
                
                // Ensure coordinates are within the 11x11 bounds (0-10)
                if (playerX2 >= 0 && playerX2 <= 10 && playerY2 >= 0 && playerY2 <= 10) {
                    
                    // Track the current tile as the most recent explored tile (replaces old loop tracking)
                    playerXminusone = playerX2;
                    playerYminusone = playerY2;
                    
                    // Check if the current tile is unexplored
                    if (Universe[playerX1][playerY1][playerX2][playerY2].explored == false) {
                        
                        // FIX 2: Do NOT call determineEnvironment(). The map is already
                        // randomly generated during initialization. Simply mark as explored.
                        Universe[playerX1][playerY1][playerX2][playerY2].explored = true;
                    }
                }
            }
            case 1 -> {
                if (playerY > 210) {
                    playerY = 210;
                }   if (playerX > 210) {
                    playerX = 210;
                }   
                playerX1 = (int) playerX / 35;
                playerY1 = (int) playerY / 35;
            }
            default -> {
            }
        }
        if (iPressed) {
            switch (scale) {
                case 2 -> {
                    scale = 3;
                    // FIX 3 (Bug 2): Reset screen coordinates to the center of the new 13x13 map
                    playerX = 6 * 35; 
                    playerY = 6 * 35;
                    playerX3 = 6; // Set player's tile position in the new 13x13 map
                    playerY3 = 6;
                    
                    // The environment for this local map is now correctly determined by 
                    // the fixed playerX1/Y1/X2/Y2 values.
                    generateLocalTerrain();
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        System.err.println("Thread interrupted during sleep: " + e.getMessage());
                    }
                }
                case 1 -> {
                    scale = 2;
                    // Reset screen coordinates to the center of the new 11x11 map
                    // FIX 2 (Bug 2): Set middle-level coordinates to a starting tile (e.g., center tile 5)
                    playerX2 = 5; 
                    playerY2 = 5; 
                    
                    // Set screen coordinates to the center of the current plane tile
                    playerX = playerX1 * 35; 
                    playerY = playerY1 * 35;
                    
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        System.err.println("Thread interrupted during sleep: " + e.getMessage());
                    }
                }
                default -> {
                }
            }
        }
        if (oPressed) {
            switch (scale) {
                case 3 -> {
                    scale = 2;
                    // FIX 4: Reset screen coordinates to match the player's last location in the 11x11 map
                    playerX = playerX2 * 35;
                    playerY = playerY2 * 35;
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        System.err.println("Thread interrupted during sleep: " + e.getMessage());
                    }
                }
                case 2 -> {
                    scale = 1;
                    // Reset screen coordinates to match the player's location in the 7x7 map
                    playerX = playerX1 * 35;
                    playerY = playerY1 * 35;
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        System.err.println("Thread interrupted during sleep: " + e.getMessage());
                    }
                }
            }
        }
    }

    @Override
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

    @Override
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

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @SuppressWarnings("CallToPrintStackTrace")
    public static void main(String[] args) {
        PathfinderFirstEdition game = new PathfinderFirstEdition();
        double timeElapsed = 0.0;
        int roundsPassed = 0;
        while (true) {
            game.moveplayers();
            game.repaint();
            try {
                Thread.sleep(10);
                timeElapsed += 0.01;
                roundsPassed = (int) Math.floor(timeElapsed/6);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}