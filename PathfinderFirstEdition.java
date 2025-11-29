import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class PathfinderFirstEdition extends JPanel implements KeyListener {
    private int ballX = 250;
    private int ballY = 250;
    private int ballXSpeed = 2;
    private int ballYSpeed = 2;
    private int paddle1Y = 200;
    private int paddle2Y = 200;
    private int player1Score = 0;
    private int player2Score = 0;
    private boolean upPressed1 = false;
    private boolean downPressed1 = false;
    private boolean upPressed2 = false;
    private boolean downPressed2 = false;

    public final Species[] SPECIES = new Species[37];
    SPECIES[0] = new Species("Dwarf", 0, 0, 2, 0, 2, -2, "M", 0, 15, 20, 15, 0);
    SPECIES[1] = new Species("Elf", 0, 2, -2, 2, 0, 0, "M", 0, 15, 30, 15, 0);
    SPECIES[2] = new Species("Gnome", -2, 0, 2, 0, 0, 2, "S", 0, 15, 20, 15, 0);
    SPECIES[3] = new Species("Half-Elf", 0, 0, 0, 0, 0, 0, "M", 0, 15, 30, 15, 0, true);
    SPECIES[4] = new Species("Half-Orc", 0, 0, 0, 0, 0, 0, "M", 0, 15, 30, 15, 0, true);
    SPECIES[5] = new Species("Halfling", -2, 2, 0, 0, 0, 2, "M", 0, 15, 20, 15, 0);
    SPECIES[6] = new Species("Human", 0, 0, 0, 0, 0, 0, "M", 0, 15, 30, 15, 0, true);
    SPECIES[7] = new Species("Aasimar", 0, 0, 0, 0, 2, 2, "M", 0, 15, 30, 15, 0);
    SPECIES[8] = new Species("Catfolk", 0, 2, 0, 0, -2, 2, "M", 0, 15, 30, 15, 0);
    SPECIES[9] = new Species("Dhampir", 0, 2, -2, 0, 0, 2, "M", 0, 15, 30, 15, 0);
    SPECIES[10] = new Species("Drow", 0, 2, -2, 0, 0, 2, "M", 0, 15, 30, 15, 0);
    SPECIES[11] = new Species("Drow Noble", 0, 4, -2, 2, 2, 2, "M", 0, 15, 30, 15, 0);
    SPECIES[12] = new Species("Duergar", 0, 0, 2, 0, 2, -4, "M", 0, 15, 20, 15, 0);
    SPECIES[13] = new Species("Fetchling", 0, 2, 0, 0, -2, 2, "M", 0, 15, 30, 15, 0);
    SPECIES[14] = new Species("Goblin", -2, 4, 0, 0, 0, 2, "S", 0, 15, 30, 15, 0);
    SPECIES[15] = new Species("Grippli", -2, 2, 0, 0, 2, 0, "S", 0, 15, 30, 20, 0);
    SPECIES[16] = new Species("Hobgoblin", 0, 2, 2, 0, 0, 0, "M", 0, 15, 30, 15, 0);
    SPECIES[17] = new Species("Ifrit", 0, 2, 0, 0, -2, 2, "M", 0, 15, 30, 15, 0);
    SPECIES[18] = new Species("Kobold", -4, 2, -2, 0, 0, 0, "M", 0, 15, 30, 15, 0);
    SPECIES[19] = new Species("Orc", 4, 0, 0, -2, -2, -2, "M", 0, 15, 30, 15, 0);
    SPECIES[20] = new Species("Oread", 2, 0, 0, 0, 2, -2, "M", 0, 15, 20, 15, 0);
    SPECIES[21] = new Species("Ratfolk", -2, 2, 0, 2, 0, 0, "S", 0, 15, 20, 15, 0);
    SPECIES[22] = new Species("Suli", 2, 0, 0, -2, 0, 2, "M", 0, 15, 30, 15, 0);
    SPECIES[23] = new Species("Svirfneblin", -2, 2, 0, 0, 2, -4, "S", 0, 15, 20, 15, 0);
    SPECIES[24] = new Species("Sylph", 0, 2, -2, 2, 0, 0, "M", 0, 15, 30, 15, 0);
    SPECIES[25] = new Species("Tengu", 0, 2, -2, 0, 2, 0, "M", 0, 15, 30, 15, 0);
    SPECIES[26] = new Species("Tiefling", 0, 2, 0, 2, 0, -2, "M", 0, 15, 30, 15, 0);
    SPECIES[27] = new Species("Undine", -2, 2, 0, 0, 2, 0, "M", 20, 30, 15, 0);
    SPECIES[28] = new Species("Vanara", 0, 2, 0, 0, 2, -2, "M", 0, 15, 30, 20, 0);
    SPECIES[29] = new Species("Vishkanya", 0, 2, 0, 0, -2, 2, "M", 0, 15, 30, 15, 0);
    SPECIES[30] = new Species("Gathlain", 0, 2, -2, 0, 0, 2, "S", 0, 15, 30, 15, 40);
    SPECIES[31] = new Species("Gnoll", 2, 2, 0, 0, 0, 0, "M", 0, 15, 30, 15, 0);
    SPECIES[32] = new Species("Kasatha", 0, 2, 0, 0, 2, 0, "M", 0, 15, 30, 15, 0);
    SPECIES[33] = new Species("Lizardfolk", 2, 2, 0, 0, 0, 0, "M", 30, 30, 15, 0);
    SPECIES[34] = new Species("Trox", 6, 0, 0, -2, -2, -2, "L", 20, 15, 30, 15, 0);
    SPECIES[35] = new Species("Wyrwood", 0, 2, 0, 2, 0, -2, "S", 0, 15, 30, 15, 0);
    SPECIES[36] = new Species("Wyvaran", 0, 2, 0, -2, 2, 0, "M", 0, 15, 30, 15, 30);
    
    private String[] quotes = {
        
        "The tower of power!",
        "Well, I, uh.",
        "You get the house, the boat, the car, the plane!",
        "You mean to say that you were all, alone?",
        "Interesting, if true.",
        "What the heck is that, what the heck is that?",

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

        "Hey flowrizzle, the super from across the street!",
        "Rock and roll, coochie-coo!"

        "So, how'd you like the play?",

        "Wogod!",

        "Look how big it is, look how big it is!",

        "Anything goes!",

        "Where, is the scroll?",

        "They can take it like champs!",

        "Godspeed.",

        "That's what we can say about it then!",
        
    }

    private String[] species = {
        "https://www.d20pfsrd.com/gamemastering/other-rules/creating-new-races/"
        "not: Centaur, Drider, Gargoyle, Ogre"
    }
    
    private String[] spells = {
    "0th: create water, detect magic, ghost sound, guidance, light, mending, purify food and drink, read magic, stabilize, touch of fatigue.",
    "1st: bless, burning hands, cause fear, command, comprehend languages, cure light wounds, detect chaos, detect evil, detect good, detect law, endure elements, obscuring mist, protection from chaos, protection from evil, protection from good, protection from law, sleep.",
    "2nd: aid, animal trance, bear's endurance, bull's strength, cat's grace, cure moderate wounds, darkness, delay poison, invisibility, mirror image, resist energy, scorching ray, see invisibility, web.",
    "3rd: animate dead, bestow curse, contagion, continual flame, cure serious wounds, daylight, deeper darkness, lightning bolt, neutralize poison, remove curse, remove disease, tongues.",
    "4th: cure critical wounds, minor creation, polymorph, restoration, stoneskin, wall of fire.",
    "5th: baleful polymorph, break enchantment, commune, heal, major creation, raise dead, true seeing, wall of stone."
    }

    private String[] skills = {
    "Acrobatics, Appraise, Bluff, Climb, Craft, Diplomacy, Disable Device, Disguise, Escape Artist, Fly, Handle Animal, Heal, Intimidate, Knowledge, Linguistics, Perception, Perform, Profession, Ride, Sense Motive, Sleight of Hand, Spellcraft, Stealth, Survival, Swim, Use Magic Device"
    }


    private String[] classskills = {
    "Craft, Handle Animal, Heal, Knowledge (all skills taken individually), Profession, Spellcraft, and Survival."
    }

    private String[] feats = {
    "Caster: Cleave, Combat Casting, Eschew Materials, Improved Initiative, Iron Will, item creation feats (all), Lightning Reflexes, metamagic feats (all), Natural Spell, Power Attack, Spell Focus, Spell Penetration, Toughness, and Weapon Focus.",
    "Finesse: Combat Expertise, Combat Reflexes, Dazzling Display, Deadly Stroke, Dodge, Greater Vital Strike, Improved Disarm, Improved Feint, Improved Trip, Improved Vital Strike, Mobility, Spring Attack, Shatter Defenses, Vital Strike, Weapon Finesse, and Whirlwind Attack.",
    "Unarmed: Combat Reflexes, Deflect Arrows, Dodge, Gorgon’s Fist, Improved Grapple, Improved Initiative, Improved Unarmed Strike, Medusa’s Wrath, Mobility, Scorpion Style, Snatch Arrows, Spring Attack, Stunning Fist, and Weapon Focus.",
    "Mounted: Improved Critical, Improved Initiative, Mounted Combat, Power Attack, Ride-By Attack, Skill Focus (Ride), Spirited Charge, Toughness, Trample, and Weapon Focus.",
    "Sword and Shield: Cleave, Great Cleave, Great Fortitude, Greater Vital Strike, Improved Bull Rush, Improved Critical, Improved Initiative, Improved Vital Strike, Power Attack, Shield Focus, Shield Master, Shield Slam, Two-Weapon Fighting, Vital Strike, and Weapon Focus.",
    "Two-Handed: Cleave, Great Cleave, Great Fortitude, Greater Vital Strike, Improved Bull Rush, Improved Critical, Improved Initiative, Improved Sunder, Improved Vital Strike, Power Attack, Vital Strike, and Weapon Focus.",
    "Two-Weapon: Combat Reflexes, Dodge, Double Slice, Greater Two-Weapon Fighting, Greater Vital Strike, Improved Critical, Improved Initiative, Improved Two-Weapon Fighting, Improved Vital Strike, Two-Weapon Defense, Two-Weapon Fighting, Two-Weapon Rend, Vital Strike, and Weapon Focus.",
    "Ranged: Deadly Aim, Far Shot, Greater Vital Strike, Improved Initiative, Improved Vital Strike, Manyshot, Pinpoint Targeting, Point-Blank Shot, Precise Shot, Rapid Reload, Rapid Shot, Shot on the Run, Vital Strike, and Weapon Focus.",
    "Skill: Armor Proficiency (all), Great Fortitude, Improved Initiative, Iron Will, Lightning Reflexes, Martial Weapon Proficiency, Run, Shield Proficiency, Skill Focus, and Toughness."
    }
    
    public PongGame() {
    JFrame frame = new JFrame("Pong Game");
    frame.setSize(500, 500);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.add(this);
    frame.setVisible(true);
    frame.addKeyListener(this);
    setFocusable(true);
    }

public void paint(Graphics g) {
    super.paint(g);
    g.setColor(Color.BLACK);
    g.fillRect(0, 0, 500, 500);
    g.setColor(Color.WHITE);
    g.fillRect(0, paddle1Y, 10, 100);
    g.fillRect(490, paddle2Y, 10, 100);
    g.fillOval(ballX, ballY, 10, 10);
    g.drawString("Player 1: " + player1Score, 50, 50);
    g.drawString("Player 2: " + player2Score, 400, 50);
}

public void moveBall() {
    ballX += ballXSpeed;
    ballY += ballYSpeed;
    if (ballY < 0 || ballY > 490) {
        ballYSpeed = -ballYSpeed;
    }
    if (ballX < 10) {
        if (ballY > paddle1Y && ballY < paddle1Y + 100) {
            ballXSpeed = -ballXSpeed;
        } else {
            player2Score++;
            ballX = 250;
            ballY = 250;
        }
    }
    if (ballX > 480) {
        if (ballY > paddle2Y && ballY < paddle2Y + 100) {
            ballXSpeed = -ballXSpeed;
        } else {
            player1Score++;
            ballX = 250;
            ballY = 250;
        }
    }
}

public void movePaddles() {
    if (upPressed1) {
        paddle1Y -= 5;
    }
    if (downPressed1) {
        paddle1Y += 5;
    }
    if (upPressed2) {
        paddle2Y -= 5;
    }
    if (downPressed2) {
        paddle2Y += 5;
    }
    if (paddle1Y < 0) {
        paddle1Y = 0;
    }
    if (paddle1Y > 400) {
        paddle1Y = 400;
    }
    if (paddle2Y < 0) {
        paddle2Y = 0;
    }
    if (paddle2Y > 400) {
        paddle2Y = 400;
    }
}

public void keyPressed(KeyEvent e) {
    if (e.getKeyCode() == KeyEvent.VK_UP) {
        upPressed2 = true;
    }
    if (e.getKeyCode() == KeyEvent.VK_DOWN) {
        downPressed2 = true;
    }
    if (e.getKeyCode() == KeyEvent.VK_W) {
        upPressed1 = true;
    }
    if (e.getKeyCode() == KeyEvent.VK_S) {
        downPressed1 = true;
    }
}

public void keyReleased(KeyEvent e) {
    if (e.getKeyCode() == KeyEvent.VK_UP) {
        upPressed2 = false;
    }
    if (e.getKeyCode() == KeyEvent.VK_DOWN) {
        downPressed2 = false;
    }
    if (e.getKeyCode() == KeyEvent.VK_W) {
        upPressed1 = false;
    }
    if (e.getKeyCode() == KeyEvent.VK_S) {
        downPressed1 = false;
    }
}

public void keyTyped(KeyEvent e) {
}

public static void main(String[] args) {
    PathfinderFirstEdition game = new PathfinderFirstEdition();
    while (true) {
        game.moveBall();
        game.movePaddles();
        game.repaint();
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

}
