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
    public Species[] campaign_ = {SPECIES[19]};

    public Campaign[] CAMPAIGNS = {
        new Campaign("Arms Dealing", 42, campaignA),
        new Campaign("Tower", 100, campaignB),
        new Campaign("Strange Wreck", 10, campaignC),
        new Campaign("Redemption", 250, campaignD),
        new Campaign("Mining Incident", 69, campaignE),
        new Campaign("Reconciling", 1000, campaignF),
        new Campaign("Sentient Forest", 1, campaignG),
        new Campaign("Hospitality", 1, campaignH),
        new Campaign("Bunker Beasts", 1, campaignI),
        new Campaign("Uprising", 1, campaignJ),
        new Campaign("Mad Science", 82861, campaignK),
        new Campaign("Mystery", 1, campaignL),
        new Campaign("Extreme Tomb", 1, campaignM),
        new Campaign("Fallacity", 1, campaignN),
        new Campaign("Army Partition", 1, campaignO),
        new Campaign("Persecution", 1, campaignP),
        new Campaign("", 1, campaignQ),
        new Campaign("", 1, campaignR),
        new Campaign("", 1, campaignS),
        new Campaign("", 1, campaignT),
        new Campaign("", 1, campaignU),
        new Campaign("", 1, campaignV),
        new Campaign("", 1, campaignW),
        new Campaign("", 1, campaignX),
        new Campaign("", 1, campaignY),
        new Campaign("", 1, campaignZ),
        new Campaign("", 1, campaign_)
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
                            if(initialTerrain > env.chancesA[env.chancesA.length]) {
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
        "Uh-oh, uh-oh."
        "They just keep driving, driving, driving!",
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
        "A little bit of poison never hurt anybody.",
        "Here we go loopy loo, here we go loopy liy, here we go loop'dedoo, all on a saturday night!",
        "Hey'a'oh, you'a'oh, does your momma know, you're going down the road, to see your little girlie'o!",
        "Legend has it, until only then.",
        "Pro gansta!",
        "Hey flowrizzle, the super from across the street!",
        "Rock and roll, coochie-coo!",
        "So, how'd you like the play?",
        "Wogod!",
        "He'll kill us all!",
        "Look how big it is, look how big it is!",
        "Anything goes!",
        "You don't wanna know man!",
        "So, how's your love life?",
        "Where, is the scroll?",
        "Sorry I'm tardy!",
        "Chainsaw seppuku!",
        "They can take it like champs!",
        "Godspeed.",
        "That's what we can say about it then!",
        "Fo to the sho, it is what you make it, and it can be mo.",
        "Don't you know I'm a human 'bein, and I love me some teetees?",
        "In the atheist, in the atheist, in the atheist, in the atheist; let's say we make a deal, not reinvent the wheel; intheatheistintheatheistintheatheistintheatheist; in the atheist in the atheist in the atheist in the atheist!",
        "What are you doing, buster?",
        "So funny, shorty honey!"
    };

    public Spell[] SPELLS = {
        new Spell("create water", "conjuration", 0, 0.5, true, true, false, 0.0, 25, 2, -1, 0, "none", false),
        new Spell("detect magic", "divination", 0, 0.5, true, true, false, 0.0, 60, 0, 0, 10, "none", false),
        new Spell("ghost sound", "illusion", 0, 0.5, true, true, false, 0.0, 25, 2, 0, 1, "will negates", false),
        new Spell("guidance", "divination", 0, 0.5, true, true, false, 0.0, 5, 0, -1, 0, "will negates", true),
        new Spell("light", "evocation", 0, 0.5, true, false, true, 0.0, 5, 0, 0, 100, "none", false),
        new Spell("mending", "transmutation", 0, 100, true, true, false, 0.0, 10, 0, -1, 0, "will negates", true),
        new Spell("purify food and drink", "transmutation", 0, 0.5, true, true, false, 0.0, 10, 0, -1, 0, "will negates", true),
        new Spell("read magic", "divination", 0, 0.5, true, true, true, 0.0, 0, 0, 0, 100, "none", false),
        new Spell("stabilize", "conjuration", 0, 0.5, true, true, false, 0.0, 25, 2, -1, 0, "none", false),
        new Spell("touch of fatigue", "necromancy", 0, 0.5, true, true, false, 0.0, 5, 0, 0, 1, "fort negates", true),
        new Spell("bless", "enchantment", 1, 0.5, true, true, true, 0.0, 50, 0, 0, 10, "none", true),
        new Spell("burning hands", "evocation", 1, 0.5, true, true, false, 0.0, 15, 0, -1, 0, "ref half", true),
        new Spell("cause fear", "necromancy", 1, 0.5, true, true, false, 0.0, 25, 2, 0, 1, "will partial", false),
        new Spell("command", "enchantment", 1, 0.5, true, false, false, 0.0, 25, 2, 1, 0, "will negates", true),
        new Spell("comprehend languages", "divination", 1, 0.5, true, true, true, 0.0, 0, 0, 0, 100, "none", false),
        new Spell("cure light wounds", "conjuration", 1, 0.5, true, true, false, 0.0, 5, 0, -1, 0, "will half", true),
        new Spell("detect chaos", "divination", 1, 0.5, true, true, true, 0.0, 60, 0, 0, 100, "none", false),
        new Spell("detect evil", "divination", 1, 0.5, true, true, true, 0.0, 60, 0, 0, 100, "none", false),
        new Spell("detect good", "divination", 1, 0.5, true, true, true, 0.0, 60, 0, 0, 100, "none", false),
        new Spell("detect law", "divination", 1, 0.5, true, true, true, 0.0, 60, 0, 0, 100, "none", false),
        new Spell("endure elements", "abjuration", 1, 0.5, true, true, false, 0.0, 5, 0, 14400, 0, "none", true),
        new Spell("obscuring mist", "conjuration", 1, 0.5, true, true, false, 0.0, 20, 0, 0, 10, "none", false),
        new Spell("protection from chaos", "abjuration", 1, 0.5, true, true, true, 0.0, 5, 0, 0, 10, "will negates", true),
        new Spell("protection from evil", "abjuration", 1, 0.5, true, true, true, 0.0, 5, 0, 0, 10, "will negates", true),
        new Spell("protection from good", "abjuration", 1, 0.5, true, true, true, 0.0, 5, 0, 0, 10, "will negates", true),
        new Spell("protection from law", "abjuration", 1, 0.5, true, true, true, 0.0, 5, 0, 0, 10, "will negates", true),
        new Spell("sleep", "enchantment", 1, 0.5, true, true, false, 0.0, 100, 10, 0, 10, "will negates", true),
        new Spell("aid", "enchantment", 2, 0.5, true, true, true, 0.0, 5, 0, 0, 10, "none", true),
        new Spell("animal trance", "enchantment", 2, 0.5, true, true, false, 0.0, 25, 2, 7, 0, "will negates", true),
        new Spell("bears endurance", "transmutation", 2, 0.5, true, true, false, 0.0, 5, 0, 0, 10, "will negates", true),
        new Spell("bulls strength", "transmutation", 2, 0.5, true, true, false, 0.0, 5, 0, 0, 10, "will negates", true),
        new Spell("cats grace", "transmutation", 2, 0.5, true, true, false, 0.0, 5, 0, 0, 10, "will negates", true),
        new Spell("cure moderate wounds", "conjuration", 2, 0.5, true, true, false, 0.0, 5, 0, -1, 0, "will half", true),
        new Spell("darkness", "evocation", 2, 0.5, true, false, true, 0.0, 5, 0, 0, 10, "none", false),
        new Spell("delay poison", "conjuration", 2, 0.5, true, true, true, 0.0, 5, 0, 0, 600, "fort negates", false),
        new Spell("invisibility", "illusion", 2, 0.5, true, true, true, 0.0, 5, 0, 0, 10, "will negates", true),
        new Spell("mirror image", "illusion", 2, 0.5, true, true, false, 0.0, 0, 0, 0, 10, "none", false),
        new Spell("resist energy", "abjuration", 2, 0.5, true, true, true, 0.0, 5, 0, 0, 100, "fort negates", true),
        new Spell("scorching ray", "evocation", 2, 0.5, true, true, false, 0.0, 25, 2, -1, 0, "none", true),
        new Spell("see invisibility", "divination", 2, 0.5, true, true, false, 0.0, 0, 0, 0, 100, "none", false),
        new Spell("web", "conjuration", 2, 0.5, true, true, false, 0.0, 100, 10, 0, 100, "ref negates", false),
        new Spell("animate dead", "necromancy", 3, 0.5, true, true, false, 25, 5, 0, -1, 0, "none", false),
        new Spell("bestow curse", "necromancy", 3, 0.5, true, true, false, 0.0, 25, 2, -1, 0, "none", false),
        new Spell("contagion", "necromancy", 3, 0.5, true, true, false, 0.0, 5, 0, -1, 0, "fort negates", true),
        new Spell("continual flame", "evocation", 3, 0.5, true, true, false, 50, 5, 0, 999999, 999999, "none", false),
        new Spell("cure serious wounds", "conjuration", 3, 0.5, true, true, false, 0.0, 5, 0, -1, 0, "will half", true),
        new Spell("daylight", "evocation", 3, 0.5, true, true, false, 0.0, 25, 2, -1, 0, "none", false),
        new Spell("deeper darkness", "evocation", 3, 0.5, true, true, true, 0.0, 5, 0, 0, 100, "none", false),
        new Spell("lightning bolt", "evocation", 3, 0.5, true, true, false, 0.0, 120, 0, -1, 0, "ref half", true),
        new Spell("neutralize poison", "conjuration", 3, 0.5, true, true, true, 0.0, 5, 0, -1, 0, "will negates", true),
        new Spell("remove curse", "abjuration", 3, 0.5, true, true, false, 0.0, 5, 0, -1, 0, "will negates", true),
        new Spell("remove disease", "conjuration", 3, 0.5, true, true, false, 0.0, 5, 0, -1, 0, "fort negates", true),
        new Spell("tongues", "divination", 3, 0.5, true, true, true, 0.0, 5, 0, 0, 100, "will negates", false),
        new Spell("cure critical wounds", "conjuration", 4, 0.5, true, true, false, 0.0, 5, 0, -1, 0, "will half", true),
        new Spell("minor creation", "conjuration", 4, 10.0, true, true, false, 0.0, 0, 0, 0, 600, "none", false),
        new Spell("polymorph", "transmutation", 4, 0.5, true, true, false, 0.0, 5, 0, 0, 10, "will negates", true),
        new Spell("restoration", "conjuration", 4, 0.5, true, true, false, 1000, 5, 0, -1, 0, "will negates", true),
        new Spell("stoneskin", "abjuration", 4, 0.5, true, true, false, 250, 5, 0, 0, 100, "will negates", true),
        new Spell("wall of fire", "evocation", 4, 0.5, true, true, true, 0.0, 100, 10, 10, 1, "none", true),
        new Spell("baleful polymorph", "transmutation", 5, 0.5, true, true, false, 0.0, 25, 2, 999999, 999999, "fort negates", true),
        new Spell("break enchantment", "abjuration", 5, 0.5, true, true, false, 0.0, 25, 2, -1, 0, "none", false),
        new Spell("commune", "divination", 5, 0.5, true, true, true, 500, 0, 0, 0, 1, "none", false),
        new Spell("heal", "conjuration", 5, 0.5, true, true, false, 0.0, 5, 0, -1, 0, "will negates", true),
        new Spell("major creation", "conjuration", 5, 100.0, true, true, false, 0.0, 25, 2, 0, 1, "none", false),
        new Spell("raise dead", "conjuration", 5, 0.5, true, true, true, 5000, 5, 0, -1, 0, "none", true),
        new Spell("true seeing", "divination", 5, 0.5, true, true, false, 500, 5, 0, 0, 10, "will negates", true),
        new Spell("wall of stone", "conjuration", 5, 0.5, true, true, true, 0.0, 100, 10, -1, 0, "reflex negates", false),};

    public String[] skills = {
        "Acrobatics, Appraise, Bluff, Climb, Craft, Diplomacy, Disable Device, Disguise, Escape Artist, Fly, Handle Animal, Heal, Intimidate, Knowledge, Linguistics, Perception, Perform, Profession, Ride, Sense Motive, Sleight of Hand, Spellcraft, Stealth, Survival, Swim, Use Magic Device"
    };

    public String[] classskills = {
        "Craft, Handle Animal, Heal, Knowledge (all skills taken individually), Profession, Spellcraft, and Survival."
    };

    public String[] feats = {
        "Caster: Cleave, Combat Casting, Improved Initiative, Iron Will, item creation feats (all), Lightning Reflexes, metamagic feats (all), Natural Spell, Power Attack, Spell Focus, Spell Penetration, Toughness, and Weapon Focus.",
        "Finesse: Combat Expertise, Combat Reflexes, Dazzling Display, Deadly Stroke, Dodge, Greater Vital Strike, Improved Disarm, Improved Feint, Improved Trip, Improved Vital Strike, Mobility, Spring Attack, Shatter Defenses, Vital Strike, Weapon Finesse, and Whirlwind Attack.",
        "Unarmed: Combat Reflexes, Deflect Arrows, Dodge, Gorgon’s Fist, Improved Grapple, Improved Initiative, Improved Unarmed Strike, Medusa’s Wrath, Mobility, Scorpion Style, Snatch Arrows, Spring Attack, Stunning Fist, and Weapon Focus.",
        "Mounted: Improved Critical, Improved Initiative, Mounted Combat, Power Attack, Ride-By Attack, Skill Focus (Ride), Spirited Charge, Toughness, Trample, and Weapon Focus.",
        "Sword and Shield: Cleave, Great Cleave, Great Fortitude, Greater Vital Strike, Improved Bull Rush, Improved Critical, Improved Initiative, Improved Sunder, Improved Vital Strike, Power Attack, Shield Focus, Shield Master, Shield Slam, Two-Weapon Fighting, Vital Strike, and Weapon Focus.",
        "Two-Handed: Cleave, Great Cleave, Great Fortitude, Greater Vital Strike, Improved Bull Rush, Improved Critical, Improved Initiative, Improved Sunder, Improved Vital Strike, Power Attack, Vital Strike, and Weapon Focus.",
        "Two-Weapon: Combat Reflexes, Dodge, Double Slice, Greater Two-Weapon Fighting, Greater Vital Strike, Improved Critical, Improved Initiative, Improved Two-Weapon Fighting, Improved Vital Strike, Two-Weapon Defense, Two-Weapon Fighting, Two-Weapon Rend, Vital Strike, and Weapon Focus.",
        "Ranged: Deadly Aim, Far Shot, Greater Vital Strike, Improved Initiative, Improved Vital Strike, Manyshot, Pinpoint Targeting, Point-Blank Shot, Precise Shot, Rapid Reload, Rapid Shot, Shot on the Run, Vital Strike, and Weapon Focus.",
        "Skill: Armor Proficiency (all), Great Fortitude, Improved Initiative, Iron Will, Lightning Reflexes, Martial Weapon Proficiency, Run, Shield Proficiency, Skill Focus, and Toughness."
    };

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
        if (scale == 3) {
            g.clearRect(0, 0, 500, 500);
            for (int i = 0; i < 13; i++) {
                for (int j = 0; j < 13; j++) {
                        g.setColor(area[i][j].color);
                    //}
                    g.fillRect((i * 35) - 1, (j * 35) - 1, 34, 34);
                }
            }
        } else if (scale == 2) {
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
        } else if (scale == 1) {
            g.clearRect(0, 0, 500, 500);
            for (int i = 0; i < 7; i++) {
                for (int j = 0; j < 7; j++) {
                    g.setColor(PLANES[i][j].color);
                    g.fillRect((i * 35) - 1, (j * 35) - 1, 34, 34);
                }
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

        if (playerX < 0) {
            playerX = 0;
        }

        if (scale == 3) {
            if (playerY > 420) {
                playerY = 420;
            }
            if (playerX > 420) {
                playerX = 420;
            }
            playerX3 = (int) playerX / 35;
            playerY3 = (int) playerY / 35;
            // The map generation loop has been removed from here.
            // It was previously:
            /*
            for (int i = 0; i < 13; i++) {
                for (int j = 0; j < 13; j++) {
                    area[i][j] = determineTerrain(Universe[playerX1][playerY1][playerX2][playerY2]);
                    if(area[i][j].determined == false) {
                        area[i][j].determined = true;
                    }
                }
            }
            */
        } else if (scale == 2) {
            if (playerY > 350) {
                playerY = 350;
            }
            if (playerX > 350) {
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
        } else if (scale == 1) {
            if (playerY > 210) {
                playerY = 210;
            }
            if (playerX > 210) {
                playerX = 210;
            }
            playerX1 = (int) playerX / 35;
            playerY1 = (int) playerY / 35;
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
