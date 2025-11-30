import java.awt.Color;

public class Environment {
  public String name; 
  public Color color;
  public Terrain[] terrain;
  public double[] chancesA;
  public double[] chancesB;
  public Environment(String name, Color color, Terrain[] terrain, double[] chancesA, double[] chancesB) {
    this.name = name;
    this.color = color;
    this.terrain = terrain;
    this.chancesA = chancesA;
    this.chancesB = chancesB;
  }
}

/*
Forest Terrain

Trees: The most important terrain element in a forest is the trees, obviously. A creature standing in the same square as a tree gains partial cover, which grants a +2 bonus to Armor Class and a +1 bonus on Reflex saves. The presence of a tree doesn’t otherwise affect a creature’s fighting space, because it’s assumed that the creature is using the tree to its advantage when it can. The trunk of a typical tree has AC 4, hardness 5, and 150 hp. A DC 15 Climb check is sufficient to climb a tree. Medium and dense forests have massive trees as well. These trees take up an entire square and provide cover to anyone behind them. They have AC 3, hardness 5, and 600 hp. Like their smaller counterparts, it takes a DC 15 Climb check to climb them.

Undergrowth: Vines, roots, and short bushes cover much of the ground in a forest. A space covered with light undergrowth costs 2 squares of movement to move into, and provides concealment. Undergrowth increases the DC of Acrobatics and Stealth checks by 2 because the leaves and branches get in the way. Heavy undergrowth costs 4 squares of movement to move into and provides concealment with a 30% miss chance (instead of the usual 20%). It increases the DC of Acrobatics checks by 5. Heavy undergrowth is easy to hide in, granting a +5 circumstance bonus on Stealth checks. Running and charging are impossible. Squares with undergrowth are often clustered together. Undergrowth and trees aren’t mutually exclusive; it’s common for a 5-foot square to have both a tree and undergrowth.

Forest Canopy: It’s common for elves and other forest dwellers to live on raised platforms far above the surface floor. These wooden platforms often have rope bridges between them. To get to the treehouses, characters ascend the trees’ branches (Climb DC 15), use rope ladders (Climb DC 0), or take pulley elevators (which can be made to rise a number of feet equal to a Strength check, made each round as a full-round action). Creatures on platforms or branches in a forest canopy are considered to have cover when fighting creatures on the ground, and in medium or dense forests they have concealment as well.

Stealth and Detection in a Forest: In a sparse forest, the maximum distance at which a Perception check for detecting the nearby presence of others can succeed is 105 feet. In a medium forest, this distance is 90 feet, and in a dense forest it is 70 feet.

The background noise in the forest makes Perception checks that rely on sound more difficult, increasing the DC of the check by 2 per 10 feet, not 1.


Marsh Terrain
Marsh Category
			Swamp
Shallow bog		40%
Deep bog		20%
Light undergrowth	20%
Heavy undergrowth	20%

Bogs: If a square is part of a shallow bog, it has deep mud or standing water of about 1 foot in depth. It costs 2 squares of movement to move into a square with a shallow bog, and the DC of Acrobatics checks in such a square increases by 2.

A square that is part of a deep bog has roughly 4 feet of standing water. It costs Medium or larger creatures 4 squares of movement to move into a square with a deep bog, or characters can swim if they wish. Small or smaller creatures must swim to move through a deep bog. Tumbling is impossible in a deep bog.

The water in a deep bog provides cover for Medium or larger creatures. Smaller creatures gain improved cover (+8 bonus to AC, +4 bonus on Reflex saves). Medium or larger creatures can crouch as a move action to gain this improved cover. Creatures with this improved cover take a –10 penalty on attacks against creatures that aren’t underwater.

Deep bog squares are usually clustered together and surrounded by an irregular ring of shallow bog squares. Both shallow and deep bogs increase the DC of Stealth checks by 2.

Undergrowth: The bushes, rushes, and other tall grasses in marshes function as undergrowth does in a forest. A square that is part of a bog does not also have undergrowth.

Other Marsh Terrain Elements: Some marshes, particularly swamps, have trees just as forests do, usually clustered in small stands. Paths lead across many marshes, winding to avoid bog areas. As in forests, paths allow normal movement and don’t provide the concealment that undergrowth does.

Stealth and Detection in a Marsh: In a marsh, the maximum distance at which a Perception check for detecting the nearby presence of others can succeed is 210 feet. In a swamp, this distance is 90 feet. Undergrowth and deep bogs provide plentiful concealment, so it’s easy to use Stealth in a marsh.


Hills Terrain
Source PRPG Core Rulebook pg. 427
A hill can exist in most other types of terrain, but hills can also dominate the landscape. Hills terrain is divided into two categories: gentle hills and rugged hills. Hills terrain often serves as a transition zone between rugged terrain such as mountains and flat terrain such as plains.
Hills Category
			Rugged Hills
Gradual slope		40%
Steep slope		50%
Cliff			10%
Light undergrowth	15%

Gradual Slope: This incline isn’t steep enough to affect movement, but characters gain a +1 bonus on melee attacks against foes downhill from them.

Steep Slope: Characters moving uphill (to an adjacent square of higher elevation) must spend 2 squares of movement to enter each square of steep slope. Characters running or charging downhill (moving to an adjacent square of lower elevation) must succeed on a DC 10 Acrobatics check upon entering the first steep slope square. Mounted characters make a DC 10 Ride check instead. Characters who fail this check stumble and must end their movement 8 feet later. Characters who fail by 5 or more fall prone in the square where they end their movement. A steep slope increases the DC of Acrobatics checks by 2.

Cliff: A cliff typically requires a DC 15 Climb check to scale and is 25 feet tall, although the needs of your map might mandate a taller cliff. A cliff isn’t perfectly vertical, taking up 5-foot squares if it’s less than 30 feet tall and 10-foot squares if it’s 30 feet or taller.

Light Undergrowth: Sagebrush and other scrubby bushes grow on hills, although they rarely cover the landscape. Light undergrowth provides concealment and increases the DC of Acrobatics and Stealth checks by 2.

Other Hills Terrain Elements: Trees aren’t out of place in hills terrain, and valleys often have active streams (8 feet wide and no more than 5 feet deep) or dry streambeds (treat as a trench 5 to 10 feet across) in them. If you add a stream or streambed, remember that water always flows downhill.

Stealth and Detection in Hills: In gentle hills, the maximum distance at which a Perception check for detecting the nearby presence of others can succeed is 110 feet. In rugged hills, this distance is 70 feet. Hiding in hills terrain can be difficult if there isn’t undergrowth around. A hilltop or ridge provides enough cover to hide from anyone below the hilltop or ridge.


Mountain Terrain
Source PRPG Core Rulebook pg. 428

Mountains have an important terrain element, the rock wall, that is marked on the border between squares rather than taking up squares itself.
Mountain Category
			Rugged
Gradual slope		25%
Steep slope		55%
Cliff			15%
Chasm			5%
Light undergrowth	10%
Scree			20%
Dense Rubble		20%

Gradual and Steep Slopes: These function as described in Hills Terrain.

Cliff: These terrain elements also function like their hills terrain counterparts, but they’re typically 70 feet tall. Cliffs taller than 80 feet take up 20 feet of horizontal space.

Chasm: Usually formed by natural geological processes, chasms function like pits in a dungeon setting. Chasms aren’t hidden, so characters won’t fall into them by accident (although bull rushes are another story). A typical chasm is 50 feet deep, at least 20 feet long, and 13 feet wide. It takes a DC 15 Climb check to climb out of a chasm.

Light Undergrowth: This functions as described in Forest Terrain.

Scree: A field of shifting gravel, scree doesn’t affect speed, but it can be treacherous on a slope. The DC of Acrobatics checks increases by 2 if there’s scree on a gradual slope and by 5 if there’s scree on a steep slope. The DC of Stealth checks increases by 2 if the scree is on a slope of any kind.

Dense Rubble: The ground is covered with rocks of all sizes. It costs 2 squares of movement to enter a square with dense rubble. The DC of Acrobatics checks on dense rubble increases by 5, and the DC of Stealth checks increases by 2.

Cave Entrance: Found in cliff and steep slope squares and next to rock walls, cave entrances are typically between 5 and 20 feet wide and 5 feet deep. A cave could be anything from a simple chamber to the entrance to an elaborate dungeon. Caves used as monster lairs typically have 2 rooms that are 25 feet across.

Other Mountain Terrain Features: Most alpine meadows begin above the treeline, so trees and other forest elements are rare in the mountains. Mountain terrain can include active streams (8 feet wide and no more than 5 feet deep) and dry streambeds (treat as a trench 8 feet across). Particularly high-altitude areas tend to be colder than the lowland areas that surround them, so they might be covered in ice sheets (described in Desert Terrain).

Stealth and Detection in Mountains: As a guideline, the maximum distance in mountain terrain at which a Perception check for detecting the nearby presence of others can succeed is 220 feet. Certain peaks and ridgelines afford much better vantage points, of course, and twisting valleys and canyons have much shorter spotting distances. Because there’s little vegetation to obstruct line of sight, the specifics on your map are your best guide for the range at which an encounter could begin. As in hills terrain, a ridge or peak provides enough cover to hide from anyone below the high point.

It’s easier to hear faraway sounds in the mountains. The DC of Perception checks that rely on sound increase by 1 per 20 feet between listener and source, not per 10 feet.

Desert Terrain
Source PRPG Core Rulebook pg. 430
Desert terrain exists in warm, temperate, and cold climates, but all deserts share one common trait: little rain. The three categories of desert terrain are tundra (cold desert), rocky deserts (often temperate), and sandy deserts (often warm).

Tundra differs from the other desert categories in two important ways. Because snow and ice cover much of the landscape, it’s easy to find water. During the height of summer, the permafrost thaws to a depth of a foot or so, turning the landscape into a vast field of mud. The muddy tundra affects movement and skill use as the shallow bogs described in Marsh Terrain, although there’s little standing water.

The table below describes terrain elements found in each of the three desert categories. The terrain elements on this table are mutually exclusive; for instance, a square of tundra might contain either light undergrowth or an ice sheet, but not both.
Desert Category
			Sandy
Light undergrowth	5%
Light rubble		10%
Dense rubble		5%
Sand dunes		50%

Light Undergrowth: Consisting of scrubby, hardy bushes and cacti, light undergrowth functions as described for other terrain types.

Ice Sheet: The ground is covered with slippery ice. It costs 2 squares of movement to enter a square covered by an ice sheet, and the DC of Acrobatics checks there increases by 5. A DC 10 Acrobatics check is required to run or charge across an ice sheet.

Light Rubble: Small rocks are strewn across the ground, making nimble movement more difficult. The DC of Acrobatics checks increases by 2.

Dense Rubble: This terrain feature consists of more and larger stones. It costs 2 squares of movement to enter a square with dense rubble. The DC of Acrobatics checks increases by 5, and the DC of Stealth checks increases by 2.

Sand Dunes: Created by the action of wind on sand, dunes function as hills that move. If the wind is strong and consistent, a sand dune can move several hundred feet in a week’s time. Sand dunes can cover hundreds of squares. They always have a gentle slope pointing in the direction of the prevailing wind and a steep slope on the leeward side.

Other Desert Terrain Features: Tundra is sometimes bordered by forests, and the occasional tree isn’t out of place in the cold wastes. Rocky deserts have towers and mesas consisting of flat ground surrounded on all sides by cliffs and steep slopes (as described in Mountain Terrain). Sandy deserts sometimes have quicksand; this functions as described in Marsh Terrain, although desert quicksand is a waterless mixture of fine sand and dust. All desert terrain is crisscrossed with dry streambeds (treat as trenches 5 to 15 feet wide) that fill with water on the rare occasions when rain falls.

Stealth and Detection in the Desert: In general, the maximum distance in desert terrain at which a Perception check for detecting the nearby presence of others can succeed is 6d6 × 20 feet; beyond this distance, elevation changes and heat distortion in warm deserts makes sight-based Perception impossible. The presence of dunes in sandy deserts limits spotting distance to 6d6 × 10 feet. The scarcity of undergrowth or other elements that offer concealment or cover makes using Stealth more difficult.


Plains Terrain
Source PRPG Core Rulebook pg. 431
Plains come in three categories: farms, grasslands, and battlefields. Farms are common in settled areas, while grasslands represent untamed plains. The battlefields where large armies clash are temporary places, usually reclaimed by natural vegetation or the farmer’s plow. Battlefields represent a third terrain category because adventurers tend to spend a lot of time there, not because they’re particularly prevalent.

The table below shows the proportions of terrain elements in the different categories of plains. On a farm, light undergrowth represents most mature grain crops, so farms growing vegetable crops will have less light undergrowth, as will all farms during the time between harvest and a few months after planting.

The terrain elements in the table below are mutually exclusive.
Plains Category
			Grasslands
Light undergrowth	20%
Heavy undergrowth	10%

Undergrowth: Whether they’re crops or natural vegetation, the tall grasses of the plains function like light undergrowth in a forest. Particularly thick bushes form patches of heavy undergrowth that dot the landscape in grasslands.

Light Rubble: On the battlefield, light rubble usually represents something that was destroyed: the ruins of a building or the scattered remnants of a stone wall, for example. It functions as described in the Desert Terrain section.

Trench: Often dug before a battle to protect soldiers, a trench functions as a low wall, except that it provides no cover against adjacent foes. It costs 2 squares of movement to leave a trench, but it costs nothing extra to enter one. Creatures outside a trench who make a melee attack against a creature inside the trench gain a +1 bonus on melee attacks because they have higher ground. In farm terrain, trenches are generally irrigation ditches.

Berm: A common defensive structure, a berm is a low, earthen wall that slows movement and provides a measure of cover. Put a berm on the map by drawing two adjacent rows of steep slope (described in Hills Terrain), with the edges of the berm on the downhill side. Thus, a character crossing a 2-square berm will travel uphill for 1 square, then downhill for 1 square. Two square berms provide cover as low walls for anyone standing behind them. Larger berms provide the low wall benefit for anyone standing 1 square downhill from the top of the berm.

Fences: Wooden fences are generally used to contain livestock or impede oncoming soldiers. It costs an extra square of movement to cross a wooden fence. A stone fence provides a measure of cover as well, functioning as low walls. Mounted characters can cross a fence without slowing their movement if they succeed on a DC 15 Ride check. If the check fails, the steed crosses the fence, but the rider falls out of the saddle.

Other Plains Terrain Features: Occasional trees dot the landscape in many plains, although on battlefields they’re often felled to provide raw material for siege engines (described in Urban Features). Hedgerows (described in Marsh Terrain) are found in plains as well. Streams, generally 5 to 20 feet wide and 5 to 10 feet deep, are commonplace.

Stealth and Detection in Plains: In plains terrain, the maximum distance at which a Perception check for detecting the nearby presence of others can succeed is 6d6 × 40 feet, although the specifics of your map might restrict line of sight. Cover and concealment are not uncommon, so a good place of refuge is often nearby, if not right at hand.
*/