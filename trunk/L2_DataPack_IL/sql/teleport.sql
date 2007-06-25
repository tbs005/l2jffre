-- 
-- Table structure for table `teleport`
--

DROP TABLE IF EXISTS teleport;
CREATE TABLE teleport (
  Description varchar(75) default NULL,
  id decimal(11,0) NOT NULL default '0',
  loc_x decimal(9,0) default NULL,
  loc_y decimal(9,0) default NULL,
  loc_z decimal(9,0) default NULL,
  price decimal(6,0) default NULL,
  fornoble int(1) NOT NULL default '0',
  PRIMARY KEY  (id)
) DEFAULT CHARSET=utf8;

-- 
-- Dumping data for table 'teleport'
-- 

INSERT INTO `teleport` VALUES ('Dark Elven Town -> Town of Gludio', 1, -12672, 122776, -3116, 10000, 0);
INSERT INTO `teleport` VALUES ('Elven Town  -> Town of Gludio', 2, -12672, 122776, -3116, 9200, 0);
INSERT INTO `teleport` VALUES ('Elven Village -> Elven Forest', 468, 21362, 51122, -3688, 710, 0);
INSERT INTO `teleport` VALUES ('Elven Village -> Neutral Zone', 469, -10674, 75550, -3597, 740, 0);
INSERT INTO `teleport` VALUES ('Elven Village -> Elven Fortress', 470, 29294, 74968, -3776, 820, 0);
INSERT INTO `teleport` VALUES ('Town of Gludio -> Elven village', 3, 46934, 51467, -2977, 9200, 0);
INSERT INTO `teleport` VALUES ('Town of Gludio -> Dark Elven village', 4, 9745, 15606, -4574, 10000, 0);
INSERT INTO `teleport` VALUES ('Town of Gludio -> Village of Gludin', 5, -80826, 149775, -3043, 7300, 0);
INSERT INTO `teleport` VALUES ('Town of Gludio -> Dion', 6, 15670, 142983, -2705, 3400, 0);
INSERT INTO `teleport` VALUES ('Village of Gludin -> Orc village', 7, -44836, -112524, -235, 26000, 0);
INSERT INTO `teleport` VALUES ('Village of Gludin -> Dwarven village', 8, 115113, -178212, -901, 38000, 0);
INSERT INTO `teleport` VALUES ('Village of Gludin -> TI', 9, -84318, 244579, -3730, 9400, 0);
INSERT INTO `teleport` VALUES ('Village of Gludin -> Elven Village', 10, 46934, 51467, -2977, 16000, 0);
INSERT INTO `teleport` VALUES ('Village of Gludin -> Dark Elven Village', 11, 9745, 15606, -4574, 16000, 0);
INSERT INTO `teleport` VALUES ('Village of Gludin -> Town of Gludio', 12, -12672, 122776, -3116, 7300, 0);
INSERT INTO `teleport` VALUES ('Village of Gludin -> Southern entrance of wastelands', 13, -16730, 209417, -3664, 3400, 0);
INSERT INTO `teleport` VALUES ('Dark Elven Town -> Southern part of dark elven forest', 14, -61095, 75104, -3356, 1100, 0);
INSERT INTO `teleport` VALUES ('DE Village -> Dark Forest', 464, -22224, 14168, -3232, 890, 0);
INSERT INTO `teleport` VALUES ('DE Village -> Spider Nest', 465, -56532, 78321, -2960, 3600, 0);
INSERT INTO `teleport` VALUES ('DE Village -> Swampland', 466, -30777, 49750, -3552, 1100, 0);
INSERT INTO `teleport` VALUES ('DE Village -> Neutral Zone', 467, -23520, 68688, -3640, 1700, 0);
INSERT INTO `teleport` VALUES ('TI -> Village of Gludin', 15, -80826, 149775, -3043, 18000, 0);
INSERT INTO `teleport` VALUES ('TI -> Obelisk of Victory', 1001, -99678, 237562, -3567, 470, 0);
INSERT INTO `teleport` VALUES ('TI -> Western Territory', 1002, -101294, 212553, -3093, 1000, 0);
INSERT INTO `teleport` VALUES ('TI -> Elven Ruins', 1003, -113329, 235327, -3653, 830, 0);
INSERT INTO `teleport` VALUES ('TI -> Singing Waterfall', 1004, -107456, 242669, -3493, 770, 0);
INSERT INTO `teleport` VALUES ('Dwarf Town  -> Town of Gludio', 16, -12672, 122776, -3116, 32000, 0);
INSERT INTO `teleport` VALUES ('Dwarf Town -> The Northeast Coast', 17, 169008, -208272, -3504, 2400, 0);
INSERT INTO `teleport` VALUES ('Dwarven Town -> Abandoned Coal Mines', 418, 139714, -177456, -1536, 690, 0);
INSERT INTO `teleport` VALUES ('Dwarven Town -> Mithril Mines', 419, 171946, -173352, 3448, 2200, 0);
INSERT INTO `teleport` VALUES ('Dion Town -> Town of Gludio', 18, -12672, 122776, -3116, 3400, 0);
INSERT INTO `teleport` VALUES ('Dion Town -> Town of Giran', 19, 83400, 147943, -3404, 6800, 0);
INSERT INTO `teleport` VALUES ('Dion Town -> Giran Harbor', 20, 47942, 186764, -3485, 6500, 0);
INSERT INTO `teleport` VALUES ('Cruma Tower Entrance -> Cruma Tower 1st floor', 21, 17724, 114004, -11672, 0, 0);
INSERT INTO `teleport` VALUES ('Cruma Tower 1st floor -> Cruma Tower Entrance', 22, 17192, 114178, -3439, 0, 0);
INSERT INTO `teleport` VALUES ('Cruma Tower 1st floor -> Cruma Tower 2nd floor', 23, 17730, 108301, -9057, 0, 0);
INSERT INTO `teleport` VALUES ('Cruma Tower 2nd floor -> Cruma Tower 1st floor', 24, 17714, 107923, -11850, 0, 0);
INSERT INTO `teleport` VALUES ('Town of Giran -> Dion Town', 25, 15670, 142983, -2705, 6800, 0);
INSERT INTO `teleport` VALUES ('Town of Giran -> Oren Town', 26, 82956, 53162, -1495, 9400, 0);
INSERT INTO `teleport` VALUES ('Town of Giran -> Hunter Village', 27, 116819, 76994, -2714, 4100, 0);
INSERT INTO `teleport` VALUES ('Town of Giran -> Hardin''s Private Academy', 28, 105918, 109759, -3207, 4400, 0);
INSERT INTO `teleport` VALUES ('Talking Island -> Obelisk of Victory', 460, -99843, 237583, -3568, 200, 0);
INSERT INTO `teleport` VALUES ('Talking Island -> Western Territory of Talking Island (Northern Area)', 461, -102850, 215932, -3424, 3000, 0);
INSERT INTO `teleport` VALUES ('Talking Island -> Elven Ruins', 462, 49315, 248452, -5960, 2500, 0);
INSERT INTO `teleport` VALUES ('Talking Island -> Singing Waterfall', 463, -113686, 235723, -3640, 2300, 0);
INSERT INTO `teleport` VALUES ('TI Dungeon inside -> outside', 29, -113329, 235327, -3653, 0, 0);
INSERT INTO `teleport` VALUES ('TI Dungeon outside -> inside', 30, 48736, 248463, -6162, 0, 0);
INSERT INTO `teleport` VALUES ('Ivory Tower Basement', 31, 84915, 15969, -4294, 0, 0);
INSERT INTO `teleport` VALUES ('Ivory Tower Ground Floor', 32, 85399, 16197, -3679, 0, 0);
INSERT INTO `teleport` VALUES ('Ivory Tower 1st Floor', 33, 85399, 16197, -2809, 0, 0);
INSERT INTO `teleport` VALUES ('Ivory Tower 2nd Floor', 34, 85399, 16197, -2293, 0, 0);
INSERT INTO `teleport` VALUES ('Ivory Tower 3th Floor', 35, 85399, 16197, -1776, 0, 0);
INSERT INTO `teleport` VALUES ('Ivory Tower Ground Floor -> Oren Castle Town', 36, 82956, 53162, -1495, 3700, 0);
INSERT INTO `teleport` VALUES ('Ivory Tower Ground Floor -> Hunter''s Village', 37, 116819, 76994, -2714, 6800, 0);
INSERT INTO `teleport` VALUES ('Ivory Tower Ground Floor -> Aden Castle Town', 38, 146331, 25762, -2018, 6200, 0);
INSERT INTO `teleport` VALUES ('Aden Town -> Ivory Tower', 39, 85348, 16142, -3699, 12000, 0);
INSERT INTO `teleport` VALUES ('Aden Town -> Oren Town', 40, 82956, 53162, -1495, 6900, 0);
INSERT INTO `teleport` VALUES ('Aden Town -> Hunter''s Village', 41, 116819, 76994, -2714, 5900, 0);
INSERT INTO `teleport` VALUES ('Hunter''s Village -> Giran Town', 42, 83400, 147943, -3404, 9400, 0);
INSERT INTO `teleport` VALUES ('Hunter''s Village -> Oren Town', 43, 82956, 53162, -1495, 4100, 0);
INSERT INTO `teleport` VALUES ('Hunter''s Village -> Ivory Tower', 44, 85348, 16142, -3699, 8200, 0);
INSERT INTO `teleport` VALUES ('Hunter''s Village -> Hardin''s Private Academy', 45, 105918, 109759, -3207, 3400, 0);
INSERT INTO `teleport` VALUES ('Hunter''s Village -> Aden Town', 46, 146331, 25762, -2018, 5900, 0);
INSERT INTO `teleport` VALUES ('Oren Town -> Giran Town', 47, 83400, 147943, -3404, 9400, 0);
INSERT INTO `teleport` VALUES ('Oren Town -> Ivory Tower', 48, 85348, 16142, -3699, 3700, 0);
INSERT INTO `teleport` VALUES ('Oren Town -> Hunter''s Village', 49, 116819, 76994, -2714, 4100, 0);
INSERT INTO `teleport` VALUES ('Oren Town -> Hardin''s Private Academy', 50, 105918, 109759, -3207, 6100, 0);
INSERT INTO `teleport` VALUES ('Oren Town -> Aden Town', 51, 146331, 25762, -2018, 6900, 0);
INSERT INTO `teleport` VALUES ('Hardin''s Private Academy -> Giran Town', 52, 83400, 147943, -3404, 5300, 0);
INSERT INTO `teleport` VALUES ('Hardin''s Private Academy -> Oren Town', 53, 82956, 53162, -1495, 7300, 0);
INSERT INTO `teleport` VALUES ('Hardin''s Private Academy -> Hunter''s Village', 54, 116819, 76994, -2714, 4100, 0);
INSERT INTO `teleport` VALUES ('Cruma level 2 -> Cruma level 3', 55, 17719, 115590, -6584, 0, 0);
INSERT INTO `teleport` VALUES ('Cruma level 3 -> Cruma Core', 56, 17691, 111726, -6583, 0, 0);
INSERT INTO `teleport` VALUES ('Cruma core -> Cruma level 3', 57, 17719, 115590, -6584, 0, 0);
INSERT INTO `teleport` VALUES ('Cruma Tower 3rd floor -> Cruma Tower 2nd Floor', 58, 17731, 119465, -9067, 0, 0);
INSERT INTO `teleport` VALUES ('Heine -> The Town of Giran', 59, 83400, 147943, -3404, 7600, 0);
INSERT INTO `teleport` VALUES ('Heine -> Giran Harbor', 60, 47942, 186764, -3485, 7100, 0);
INSERT INTO `teleport` VALUES ('Lair end -> Antharas Nest', 61, 173826, 115333, -7708, 0, 0);
INSERT INTO `teleport` VALUES ('Antharas Nest - > Giran castle town', 62, 83400, 147943, -3404, 0, 0);
INSERT INTO `teleport` VALUES ('Giran Harbor -> Giran Town', 63, 83400, 147943, -3404, 6300, 0);
INSERT INTO `teleport` VALUES ('Giran Harbor -> Dion Town', 64, 15670, 142983, -2705, 6500, 0);
INSERT INTO `teleport` VALUES ('Giran Harbor -> Heine', 107, 111409, 219364, -3545, 8500, 0);
INSERT INTO `teleport` VALUES ('Heine -> The Town of Dion', 65, 15670, 142983, -2705, 12000, 0);
INSERT INTO `teleport` VALUES ('Heine -> Field of Silence', 66, 82684, 183551, -3597, 2500, 0);
INSERT INTO `teleport` VALUES ('Heine -> Field of Whispers', 67, 91186, 217104, -3649, 2300, 0);
INSERT INTO `teleport` VALUES ('Heine -> Entrance to Alligator Islands', 68, 126450, 174774, -3079, 2100, 0);
INSERT INTO `teleport` VALUES ('Giran -> Dragon Valley', 69, 122824, 110836, -3720, 1800, 0);
INSERT INTO `teleport` VALUES ('Giran -> Heine', 70, 111409, 219364, -3545, 7600, 0);
INSERT INTO `teleport` VALUES ('Monster Derby Track', 75, 12661, 181687, -3560, 0, 0);
INSERT INTO `teleport` VALUES ('Aden -> Coliseum', 76, 146440, 46723, -3432, 2000, 0);
INSERT INTO `teleport` VALUES ('Aden -> Blazing Swamp', 81, 159455, -12931, -2872, 6800, 0);
INSERT INTO `teleport` VALUES ('Aden -> The Forbidden Gateway', 82, 185319, 20218, -3264, 1400, 0);
INSERT INTO `teleport` VALUES ('Aden -> The Front of Anghell Waterfall', 83, 163341, 91374, -3320, 2400, 0);
INSERT INTO `teleport` VALUES ('Aden -> Forsaken Plains', 84, 167285, 37109, -4008, 1900, 0);
INSERT INTO `teleport` VALUES ('Dion -> Heine', 85, 111409, 219364, -3545, 12000, 0);
INSERT INTO `teleport` VALUES ('Dion -> Partisan Hideaway', 86, 46467, 126885, -3720, 1700, 0);
INSERT INTO `teleport` VALUES ('Dion -> Bee Hive', 87, 20505, 189036, -3344, 2900, 0);
INSERT INTO `teleport` VALUES ('Gludio -> Windawood Manor', 88, -23789, 169683, -3424, 1400, 0);
INSERT INTO `teleport` VALUES ('Gludio -> Southern Pathway to the Wasteland', 89, -16730, 209417, -3664, 2400, 0);
INSERT INTO `teleport` VALUES ('Gludin -> Abandoned Camp', 90, -46932, 140883, -2936, 1200, 0);
INSERT INTO `teleport` VALUES ('Gludin -> Fellmere Harvest Grounds', 91, -70387, 115501, -3472, 1400, 0);
INSERT INTO `teleport` VALUES ('Gludin -> Langk Lizardman Dwelling', 92, -45210, 202654, -3592, 1800, 0);
INSERT INTO `teleport` VALUES ('Orc Village -> Immortal Plateau,Northern Region', 93, -8804, -114748, -3088, 960, 0);
INSERT INTO `teleport` VALUES ('Orc Village -> Immortal Plateau,Southern Region', 94, -17870, -90980, -2528, 2000, 0);
INSERT INTO `teleport` VALUES ('Orc Village -> Immortal Plateau,Southeast Region', 95, 8209, -93524, -2312, 750, 0);
INSERT INTO `teleport` VALUES ('Orc Village -> Frozen Waterfall', 96, 7603, -138871, -920, 1600, 0);
INSERT INTO `teleport` VALUES ('Orc Village -> Entrance to the Cave of Trials', 471, 9340, -112509, -2536, 1500, 0);
INSERT INTO `teleport` VALUES ('Oren -> Plains of Lizardmen', 97, 87252, 85514, -3056, 1900, 0);
INSERT INTO `teleport` VALUES ('Oren -> Sea of Spores', 98, 64328, 26803, -3768, 2500, 0);
INSERT INTO `teleport` VALUES ('Hunters -> Northern Pathway of Enchanted Valley', 99, 104426, 33746, -3800, 3600, 0);
INSERT INTO `teleport` VALUES ('Hunters -> Southern Pathway of Enchanted Valley', 100, 124904, 61992, -3920, 1300, 0);
INSERT INTO `teleport` VALUES ('Hunters -> Entrance to the Forest of Mirrors', 101, 142065, 81300, -3000, 2000, 0);
INSERT INTO `teleport` VALUES ('Hunters -> The Front of Anghel Waterfall', 102, 163341, 91374, -3320, 4000, 0);
INSERT INTO `teleport` VALUES ('Goddard -> Aden Castle Town', 132, 146331, 25762, -2018, 8100, 0);
INSERT INTO `teleport` VALUES ('Goddard -> Rune Castle Village', 108, 43799, -47727, -798, 10000, 0);
INSERT INTO `teleport` VALUES ('Goddard -> Varka Silenos Stronghold', 109, 125543, -40953, -3724, 4200, 0);
INSERT INTO `teleport` VALUES ('Goddard -> Ketra Orc Outpost', 110, 146954, -67390, -3660, 1800, 0);
INSERT INTO `teleport` VALUES ('Goddard -> Entrance to the Forge of the Gods', 111, 169178, -116244, -2421, 2300, 0);
INSERT INTO `teleport` VALUES ('Rune -> Goddard Castle Village', 119, 147928, -55273, -2734, 10000, 0);
INSERT INTO `teleport` VALUES ('Rune -> The Town of Giran', 120, 83400, 147943, -3404, 59000, 0);
INSERT INTO `teleport` VALUES ('Rune -> Aden Castle Town', 121, 146331, 25762, -2018, 37000, 0);
INSERT INTO `teleport` VALUES ('Rune -> Rune Castle Town Guild', 122, 38320, -48092, -1153, 150, 0);
INSERT INTO `teleport` VALUES ('Rune -> Rune Castle Town Temple', 123, 38275, -48065, 896, 150, 0);
INSERT INTO `teleport` VALUES ('Rune -> Entrance to the Forest of the Dead', 124, 52112, -53939, -3159, 1200, 0);
INSERT INTO `teleport` VALUES ('Rune -> Western Entrance to the Swamp of Screams', 125, 70006, -49902, -3251, 3000, 0);
INSERT INTO `teleport` VALUES ('Rune -> Rune Castle Town Store', 131, 43799, -47727, -798, 150, 0);
INSERT INTO `teleport` VALUES ('Aden -> Rune', 134, 43799, -47727, -798, 37000, 0);
INSERT INTO `teleport` VALUES ('Aden -> Goddard', 135, 147928, -55273, -2734, 8100, 0);
INSERT INTO `teleport` VALUES ('Giran Town -> Giran Harbor', 136, 47942, 186764, -3485, 5200, 0);
INSERT INTO `teleport` VALUES ('TOI - 1st Floor', 201, 115168, 16022, -5100, 100000, 0);
INSERT INTO `teleport` VALUES ('TOI - 2nd Floor', 202, 114649, 18587, -3609, 150000, 0);
INSERT INTO `teleport` VALUES ('TOI - 3rd Floor', 203, 117918, 16039, -2127, 200000, 0);
INSERT INTO `teleport` VALUES ('TOI - 4th Floor', 204, 114622, 12946, -645, 250000, 0);
INSERT INTO `teleport` VALUES ('TOI - 5th Floor', 205, 112209, 16078, 928, 300000, 0);
INSERT INTO `teleport` VALUES ('TOI - 6th Floor', 206, 112376, 16099, 1947, 350000, 0);
INSERT INTO `teleport` VALUES ('TOI - 7th Floor', 207, 114448, 16175, 2994, 400000, 0);
INSERT INTO `teleport` VALUES ('TOI - 8th Floor', 208, 111063, 16118, 3967, 450000, 0);
INSERT INTO `teleport` VALUES ('TOI - 9th Floor', 209, 117147, 18415, 4977, 500000, 0);
INSERT INTO `teleport` VALUES ('TOI - 10th Floor', 210, 118374, 15973, 5987, 550000, 0);
INSERT INTO `teleport` VALUES ('TOI - 11th Floor', 211, 112209, 16078, 7028, 600000, 0);
INSERT INTO `teleport` VALUES ('TOI - 12th Floor', 212, 114809, 18711, 7996, 650000, 0);
INSERT INTO `teleport` VALUES ('TOI - 13th Floor', 213, 115178, 16989, 9007, 700000, 0);
INSERT INTO `teleport` VALUES ('TOI - 14th Floor Outside Door', 214, 112714, 14111, 10077, 800000, 0);
INSERT INTO `teleport` VALUES ('TOI - 14th Floor Inside On Roof', 215, 113098, 14532, 10077, 900000, 0);
INSERT INTO `teleport` VALUES ('Cat Heretics Entrance', 250, -53307,-250271,-7910, 0, 0); -- Interlude (undersea)
INSERT INTO `teleport` VALUES ('Cat Heretics Exit', 251, 42514, 143917, -5385, 0, 0);
INSERT INTO `teleport` VALUES ('Cat Branded Entrance', 252, 46217, 170290, -4983, 0, 0);
INSERT INTO `teleport` VALUES ('Cat Branded Exit', 253, 45770, 170299, -4985, 0, 0);
INSERT INTO `teleport` VALUES ('Cat Apostate Entrance', 254, -20683,-250783,-8166, 0, 0); -- Interlude (undersea)
INSERT INTO `teleport` VALUES ('Cat Apostate Exit', 255, 77225, 78362, -5119, 0, 0);
INSERT INTO `teleport` VALUES ('Cat Witch Entrance', 256, 140404, 79678, -5431, 0, 0);
INSERT INTO `teleport` VALUES ('Cat Witch Exit', 257, 139965, 79678, -5433, 0, 0);
INSERT INTO `teleport` VALUES ('Cat DarkOmen Entrance', 258, -19500, 13508, -4905, 0, 0);
INSERT INTO `teleport` VALUES ('Cat DarkOmen Exit', 259, -19931, 13502, -4905, 0, 0);
INSERT INTO `teleport` VALUES ('Cat ForbiddenPath Entrance', 260, 12501,-248472,-9582, 0, 0); -- Interlude (undersea)
INSERT INTO `teleport` VALUES ('Cat ForbiddenPath Exit', 261, 113429, 84540, -6545, 0, 0);
INSERT INTO `teleport` VALUES ('Necro Sacrifice Entrance', 262, -41570, 209785, -5089, 0, 0);
INSERT INTO `teleport` VALUES ('Necro Sacrifice Exit', 263, -41567, 209292, -5091, 0, 0);
INSERT INTO `teleport` VALUES ('Necro Pilgrims Entrance', 264, 45251, 123890, -5415, 0, 0);
INSERT INTO `teleport` VALUES ('Necro Pilgrims Exit', 265, 45250, 124366, -5417, 0, 0);
INSERT INTO `teleport` VALUES ('Necro Worshippers Entrance', 266, 111273, 174015, -5417, 0, 0);
INSERT INTO `teleport` VALUES ('Necro Worshippers Exit', 267, 110818, 174010, -5443, 0, 0);
INSERT INTO `teleport` VALUES ('Necro Patriots Entrance', 268, -21726, 77385, -5177, 0, 0);
INSERT INTO `teleport` VALUES ('Necro Patriots Exit', 269, -22197, 77369, -5177, 0, 0);
INSERT INTO `teleport` VALUES ('Necro Ascetics Entrance', 270, -52254, 79103, -4743, 0, 0);
INSERT INTO `teleport` VALUES ('Necro Ascetics Exit', 271, -52716, 79106, -4745, 0, 0);
INSERT INTO `teleport` VALUES ('Necro Martyrs Entrance', 272, 118308, 132800, -4833, 0, 0);
INSERT INTO `teleport` VALUES ('Necro Martyrs Exit', 273, 117793, 132810, -4835, 0, 0);
INSERT INTO `teleport` VALUES ('Necro Saints Entrance', 274, 83000, 209213, -5443, 0, 0);
INSERT INTO `teleport` VALUES ('Necro Saints Exit', 275, 82608, 209225, -5443, 0, 0);
INSERT INTO `teleport` VALUES ('Necro Disciples Entrance', 276, 172251, -17605, -4903, 0, 0);
INSERT INTO `teleport` VALUES ('Necro Disciples Exit', 277, 171902, -17595, -4905, 0, 0);
INSERT INTO `teleport` VALUES ('Dion(artifact -> out)', 350, 22967, 157715, -2954, 0, 0);
INSERT INTO `teleport` VALUES ('Dion(artifact -> hall)', 351, 22090, 159871, -2711, 0, 0);
INSERT INTO `teleport` VALUES ('Dion(artifact -> outofcastle)', 352, 22448, 155798, -2958, 0, 0);
INSERT INTO `teleport` VALUES ('Dion(in -> artifact)', 353, 22592, 161530, -2775, 0, 0);
INSERT INTO `teleport` VALUES ('Dion(in -> out)', 354, 22967, 157715, -2954, 0, 0);
INSERT INTO `teleport` VALUES ('Dion(in -> outofcastle)', 355, 22448, 155798, -2958, 0, 0);
INSERT INTO `teleport` VALUES ('Dion(out -> artifact)', 356, 22592, 161530, -2775, 0, 0);
INSERT INTO `teleport` VALUES ('Dion(out -> hall)', 357, 22090, 159871, -2711, 0, 0);
INSERT INTO `teleport` VALUES ('Dion(out -> outofcastle)', 358, 22448, 155798, -2958, 0, 0);
INSERT INTO `teleport` VALUES ('Dion(outofcastle -> artifact)', 359, 22592, 161530, -2775, 0, 0);
INSERT INTO `teleport` VALUES ('Dion(outofcastle -> out)', 360, 22967, 157715, -2954, 0, 0);
INSERT INTO `teleport` VALUES ('Dion(outofcastle -> hall)', 361, 22090, 159871, -2711, 0, 0);
INSERT INTO `teleport` VALUES ('Giran(artifact -> out)', 362, 113892, 144175, -2714, 0, 0);
INSERT INTO `teleport` VALUES ('Giran(artifact -> hall)', 363, 115984, 145073, -2584, 0, 0);
INSERT INTO `teleport` VALUES ('Giran(artifact -> outofcastle)', 364, 112016, 144682, -2833, 0, 0);
INSERT INTO `teleport` VALUES ('Giran(in -> artifact)', 365, 117619, 144564, -2648, 0, 0);
INSERT INTO `teleport` VALUES ('Giran(in -> out)', 366, 113892, 144175, -2714, 0, 0);
INSERT INTO `teleport` VALUES ('Giran(in -> outofcastle)', 367, 112016, 144682, -2833, 0, 0);
INSERT INTO `teleport` VALUES ('Giran(out -> artifact)', 368, 117619, 144564, -2648, 0, 0);
INSERT INTO `teleport` VALUES ('Giran(out -> hall)', 369, 115984, 145073, -2584, 0, 0);
INSERT INTO `teleport` VALUES ('Giran(out -> outofcastle)', 370, 112016, 144682, -2833, 0, 0);
INSERT INTO `teleport` VALUES ('Giran(outofcastle -> artifact)', 371, 117619, 144564, -2648, 0, 0);
INSERT INTO `teleport` VALUES ('Giran(outofcastle -> out)', 372, 113892, 144175, -2714, 0, 0);
INSERT INTO `teleport` VALUES ('Giran(outofcastle -> hall)', 373, 115984, 145073, -2584, 0, 0);
INSERT INTO `teleport` VALUES ('Oren(artifact -> out)', 374, 79956, 36351, -2532, 0, 0);
INSERT INTO `teleport` VALUES ('Oren(artifact -> hall)', 375, 82113, 37217, -2311, 0, 0);
INSERT INTO `teleport` VALUES ('Oren(artifact -> outofcastle)', 376, 78079, 36809, -2566, 0, 0);
INSERT INTO `teleport` VALUES ('Oren(in -> artifact)', 377, 83710, 36713, -2375, 0, 0);
INSERT INTO `teleport` VALUES ('Oren(in -> out)', 378, 79956, 36351, -2532, 0, 0);
INSERT INTO `teleport` VALUES ('Oren(in -> outofcastle)', 379, 78079, 36809, -2566, 0, 0);
INSERT INTO `teleport` VALUES ('Oren(out -> artifact)', 380, 83710, 36713, -2375, 0, 0);
INSERT INTO `teleport` VALUES ('Oren(out -> hall)', 381, 82113, 37217, -2311, 0, 0);
INSERT INTO `teleport` VALUES ('Oren(out -> outofcastle)', 382, 78079, 36809, -2566, 0, 0);
INSERT INTO `teleport` VALUES ('Oren(outofcastle -> artifact)', 383, 83710, 36713, -2375, 0, 0);
INSERT INTO `teleport` VALUES ('Oren(outofcastle -> out)', 384, 79956, 36351, -2532, 0, 0);
INSERT INTO `teleport` VALUES ('Oren(outofcastle -> hall)', 385, 82113, 37217, -2311, 0, 0);
INSERT INTO `teleport` VALUES ('Gludio(artifact -> out)', 386, -18941, 112085, -2762, 0, 0);
INSERT INTO `teleport` VALUES ('Gludio(artifact -> hall)', 387, -18129, 109898, -2517, 0, 0);
INSERT INTO `teleport` VALUES ('Gludio(artifact -> outofcastle)', 388, -18484, 113897, -2772, 0, 0);
INSERT INTO `teleport` VALUES ('Gludio(in -> artifact)', 389, -18592, 108271, -2581, 0, 0);
INSERT INTO `teleport` VALUES ('Gludio(in -> out)', 390, -18941, 112085, -2762, 0, 0);
INSERT INTO `teleport` VALUES ('Gludio(in -> outofcastle)', 391, -18484, 113897, -2772, 0, 0);
INSERT INTO `teleport` VALUES ('Gludio(out -> artifact)', 392, -18592, 108271, -2581, 0, 0);
INSERT INTO `teleport` VALUES ('Gludio(out -> hall)', 393, -18129, 109898, -2517, 0, 0);
INSERT INTO `teleport` VALUES ('Gludio(out -> outofcastle)', 394, -18484, 113897, -2772, 0, 0);
INSERT INTO `teleport` VALUES ('Gludio(outofcastle -> artifact)', 395, -18592, 108271, -2581, 0, 0);
INSERT INTO `teleport` VALUES ('Gludio(outofcastle -> out)', 396, -18941, 112085, -2762, 0, 0);
INSERT INTO `teleport` VALUES ('Gludio(outofcastle -> hall)', 397, -18129, 109898, -2517, 0, 0);
INSERT INTO `teleport` VALUES ('Aden(artifact -> out)', 398, 147723, 7916, -475, 0, 0);
INSERT INTO `teleport` VALUES ('Aden(artifact -> in)', 399, 148580, 4578, -408, 0, 0);
INSERT INTO `teleport` VALUES ('Aden(artifact -> outofcastle)', 400, 147582, 8753, -496, 0, 0);
INSERT INTO `teleport` VALUES ('Aden(artifact -> hall)', 401, 147520, 6107, -409, 0, 0);
INSERT INTO `teleport` VALUES ('Aden(in -> artifact)', 402, 1147499, 2544, -473, 0, 0);
INSERT INTO `teleport` VALUES ('Aden(in -> out)', 403, 147723, 7916, -475, 0, 0);
INSERT INTO `teleport` VALUES ('Aden(in -> outofcastle)', 404, 147582, 8753, -496, 0, 0);
INSERT INTO `teleport` VALUES ('Aden(in -> hall)', 405, 147520, 6107, -409, 0, 0);
INSERT INTO `teleport` VALUES ('Aden(out -> artifact)', 406, 147499, 2544, -473, 0, 0);
INSERT INTO `teleport` VALUES ('Aden(out -> in)', 407, 148580, 4578, -408, 0, 0);
INSERT INTO `teleport` VALUES ('Aden(out -> outofcastle)', 408, 147582, 8753, -496, 0, 0);
INSERT INTO `teleport` VALUES ('Aden(out -> hall)', 409, 147520, 6107, -409, 0, 0);
INSERT INTO `teleport` VALUES ('Aden(outofcastle -> artifact)', 410, 147499, 2544, -473, 0, 0);
INSERT INTO `teleport` VALUES ('Aden(outofcastle -> out)', 411, 147723, 7916, -475, 0, 0);
INSERT INTO `teleport` VALUES ('Aden(outofcastle -> in)', 412, 148580, 4578, -408, 0, 0);
INSERT INTO `teleport` VALUES ('Aden(outofcastle -> hall)', 413, 147520, 6107, -409, 0, 0);
INSERT INTO `teleport` VALUES ('Aden(hall) -> artifact)', 414, 147499, 2544, -473, 0, 0);
INSERT INTO `teleport` VALUES ('Aden(hall) -> out)', 415, 147723, 7916, -475, 0, 0);
INSERT INTO `teleport` VALUES ('Aden(hall) -> in)', 416, 148580, 4578, -408, 0, 0);
INSERT INTO `teleport` VALUES ('Aden(hall) -> outofcastle)', 417, 147582, 8753, -496, 0, 0);
INSERT INTO `teleport` VALUES ('Lair Of Valakas', 420, 208884, -113705, -256, 0, 0);
INSERT INTO `teleport` VALUES ('Disciples Necropolis -> Anakim', 445, 184448, -10112, -5488, 0, 0);
INSERT INTO `teleport` VALUES ('Disciples Necropolis -> Lilith', 450, 185075, -11993, -5488, 0, 0);
INSERT INTO `teleport` VALUES ('Anakim/Lilith -> Disciples Necropolis', 451, 183225, -11911, -4897, 0, 0);
INSERT INTO `teleport` VALUES ('TI -> Dark Elven Village', 1005, 9745, 15606, -4574, 24000, 0);
INSERT INTO `teleport` VALUES ('TI -> Dwarven Village', 1006, 115113, -178212, -901, 46000, 0);
INSERT INTO `teleport` VALUES ('TI -> Elven Village', 1007, 46934, 51467, -2977, 23000, 0);
INSERT INTO `teleport` VALUES ('TI -> Orc Village', 1008, -44836, -112524, -235, 35000, 0);
INSERT INTO `teleport` VALUES ('DE Village -> Dwarven Village', 1009, 115113, -178212, -901, 22000, 0);
INSERT INTO `teleport` VALUES ('DE Village -> TI Village', 1010, -84318, 244579, -3730, 24000, 0);
INSERT INTO `teleport` VALUES ('Gludin -> Windy Hill', 1121, -88525, 83379, -2864, 2600, 0);
INSERT INTO `teleport` VALUES ('DE Village -> Orc Village', 1012, -44836, -112524, -235, 13000, 0);
INSERT INTO `teleport` VALUES ('Elven Village -> Neutral Zone', 1013, -10674, 75550, -3597, 1700, 0);
INSERT INTO `teleport` VALUES ('Elven Village -> Dwarven Village', 1014, 115113, -178212, -901, 23000, 0);
INSERT INTO `teleport` VALUES ('Elven Village -> TI Village', 1015, -84318, 244579, -3730, 23000, 0);
INSERT INTO `teleport` VALUES ('Elven Village -> Orc Village', 1016, -44836, -112524, -235, 18000, 0);
INSERT INTO `teleport` VALUES ('Dwarven Village -> DE Village', 1017, 9745, 15606, -4574, 22000, 0);
INSERT INTO `teleport` VALUES ('Dwarven Village -> Elven Village', 1018, 46934, 51467, -2977, 23000, 0);
INSERT INTO `teleport` VALUES ('Dwarven Village -> TI Village', 1019, -84318, 244579, -3730, 46000, 0);
INSERT INTO `teleport` VALUES ('Dwarven Village -> Schuttgart', 1020, 87386, -143246, -1293, 4400, 0);
INSERT INTO `teleport` VALUES ('Dwarven Village -> Orc Village', 1021, -44836, -112524, -235, 17000, 0);
INSERT INTO `teleport` VALUES ('Dwarven Village -> Central Shore', 1022, 136910, -205082, -3664, 970, 0);
INSERT INTO `teleport` VALUES ('Orc Village -> Town of Gludio', 1023, -12672, 122776, -3116, 23000, 0);
INSERT INTO `teleport` VALUES ('Orc Village -> Schuttgart', 1024, 87386, -143246, -1293, 13000, 0);
INSERT INTO `teleport` VALUES ('Orc Village -> DE Village', 1025, 9745, 15606, -4574, 13000, 0);
INSERT INTO `teleport` VALUES ('Orc Village -> Dwarven Village', 1026, 115113, -178212, -901, 17000, 0);
INSERT INTO `teleport` VALUES ('Orc Village -> TI Village', 1027, -84318, 244579, -3730, 35000, 0);
INSERT INTO `teleport` VALUES ('Orc Village -> Elven Village', 1028, 46934, 51467, -2977, 18000, 0);
INSERT INTO `teleport` VALUES ('Gludio -> Orc Village', 1033, -44836, -112524, -235, 23000, 0);
INSERT INTO `teleport` VALUES ('Gludin Village -> Windmill Hill', 1029, -68628, 162336, -3592, 550, 0);
INSERT INTO `teleport` VALUES ('Gludin Village -> Forgotten Temple', 1030, -52841, 190730, -3518, 2000, 0);
INSERT INTO `teleport` VALUES ('Gludio -> Ant Cave', 1031, -9993, 176457, -4182, 2100, 0);
INSERT INTO `teleport` VALUES ('Gludin Village -> Crimson Boulder Ridge', 1032, -42256, 198333, -2800, 3700, 0);
INSERT INTO `teleport` VALUES ('Gludio -> Dwarven Village', 1034, 115113, -178212, -901, 32000, 0);
INSERT INTO `teleport` VALUES ('Gludio -> Schuttgart', 1035, 87386, -143246, -1293, 85000, 0);
INSERT INTO `teleport` VALUES ('Gludio -> Heine', 1036, 111409, 219364, -3545, 47000, 0);
INSERT INTO `teleport` VALUES ('Gludio -> Aden Castle Town', 1037, 146331, 25762, -2018, 56000, 0);
INSERT INTO `teleport` VALUES ('Gludio -> Oren Castle Town', 1038, 82956, 53162, -1495, 35000, 0);
INSERT INTO `teleport` VALUES ('Gludio -> Goddard Castle Town', 1039, 147928, -55273, -2734, 71000, 0);
INSERT INTO `teleport` VALUES ('Gludio -> Giran Castle Town', 1040, 83400, 147943, -3404, 29000, 0);
INSERT INTO `teleport` VALUES ('Gludio -> Rune Castle Town', 1041, 43799, -47727, -798, 53000, 0);
INSERT INTO `teleport` VALUES ('Gludio -> Ruins of Agony', 1042, -42504, 120046, -3519, 790, 0);
INSERT INTO `teleport` VALUES ('Gludio -> Ruins of Despair', 1043, -20057, 137618, -3897, 610, 0);
INSERT INTO `teleport` VALUES ('Gludin -> Turek Orc', 1044, -89839, 105362, -3580, 1800, 0);
INSERT INTO `teleport` VALUES ('Gludio -> Windmill Hill', 1045, -68628, 162336, -3592, 2600, 0);
INSERT INTO `teleport` VALUES ('Dion -> Goddard', 1046, 147928, -55273, -2734, 71000, 0);
INSERT INTO `teleport` VALUES ('Dion -> Rune Castle Town', 1047, 43799, -47727, -798, 57000, 0);
INSERT INTO `teleport` VALUES ('Dion -> Schuttgart', 1048, 87386, -143246, -1293, 88000, 0);
INSERT INTO `teleport` VALUES ('Dion -> Aden', 1049, 146331, 25762, -2018, 52000, 0);
INSERT INTO `teleport` VALUES ('Dion -> Oren', 1050, 82956, 53162, -1495, 33000, 0);
INSERT INTO `teleport` VALUES ('Dion -> Cruma Marshlands', 1051, 5106, 126916, -3664, 760, 0);
INSERT INTO `teleport` VALUES ('Dion -> Cruma Tower', 1052, 17192, 114178, -3439, 2300, 0);
INSERT INTO `teleport` VALUES ('Dion -> Dion Pasture', 1053, 630, 179184, -3720, 1500, 0);
INSERT INTO `teleport` VALUES ('Dion -> Tanor Canyon', 1054, 58316, 163851, -2816, 3800, 0);
INSERT INTO `teleport` VALUES ('Giran -> Gludio', 1055, -12672, 122776, -3116, 29000, 0);
INSERT INTO `teleport` VALUES ('Giran -> Goddard', 1056, 147928, -55273, -2734, 63000, 0);
INSERT INTO `teleport` VALUES ('Giran -> Rune', 1057, 43799, -47727, -798, 59000, 0);
INSERT INTO `teleport` VALUES ('Giran -> Schuttgart', 1058, 87386, -143246, -1293, 87000, 0);
INSERT INTO `teleport` VALUES ('Giran -> Aden', 1059, 146331, 25762, -2018, 13000, 0);
INSERT INTO `teleport` VALUES ('Giran -> Antharas Lair', 1060, 132828, 114421, -3725, 7000, 0);
INSERT INTO `teleport` VALUES ('Giran -> Devil Isle', 1061, 43408, 206881, -3752, 5700, 0);
INSERT INTO `teleport` VALUES ('Giran -> Brekas Stronghold', 1062, 79798, 130624, -3677, 1000, 0);
INSERT INTO `teleport` VALUES ('Heine -> Oren', 1063, 82956, 53162, -1495, 50000, 0);
INSERT INTO `teleport` VALUES ('Heine -> Aden', 1064, 146331, 25762, -2018, 59000, 0);
INSERT INTO `teleport` VALUES ('Heine -> Goddard', 1065, 147928, -55273, -2734, 83000, 0);
INSERT INTO `teleport` VALUES ('Heine -> Rune', 1066, 43799, -47727, -798, 82000, 0);
INSERT INTO `teleport` VALUES ('Heine -> Schuttgart', 1067, 87386, -143246, -1293, 100000, 0);
INSERT INTO `teleport` VALUES ('Heine -> Gludio', 1068, -12672, 122776, -3116, 47000, 0);
INSERT INTO `teleport` VALUES ('Heine -> Garden of Eva', 1069, 86006, 231069, -3600, 2400, 0);
INSERT INTO `teleport` VALUES ('Oren -> Rune', 1070, 43799, -47727, -798, 10000, 0);
INSERT INTO `teleport` VALUES ('Oren -> Goddard', 1071, 147928, -55273, -2734, 37000, 0);
INSERT INTO `teleport` VALUES ('Oren -> Heine', 1072, 111409, 219364, -3545, 50000, 0);
INSERT INTO `teleport` VALUES ('Oren -> Dion', 1073, 15670, 142983, -2705, 33000, 0);
INSERT INTO `teleport` VALUES ('Oren -> Schuttgart', 1074, 87386, -143246, -1293, 59000, 0);
INSERT INTO `teleport` VALUES ('Oren -> Gludio', 1075, -12672, 122776, -3116, 35000, 0);
INSERT INTO `teleport` VALUES ('Oren -> Skyshadow Meadow', 1076, 82764, 61145, -3502, 780, 0);
INSERT INTO `teleport` VALUES ('Oren -> Forest Outlaw', 1077, 85995, -2433, -3528, 5200, 0);
INSERT INTO `teleport` VALUES ('Aden -> Giran', 1078, 83400, 147943, -3404, 13000, 0);
INSERT INTO `teleport` VALUES ('Aden -> Heine', 1079, 111409, 219364, -3545, 59000, 0);
INSERT INTO `teleport` VALUES ('Aden -> Schuttgart', 1080, 87386, -143246, -1293, 53000, 0);
INSERT INTO `teleport` VALUES ('Aden -> Dion', 1081, 15670, 142983, -2705, 52000, 0);
INSERT INTO `teleport` VALUES ('Aden -> Gludio', 1082, -12672, 122776, -3116, 56000, 0);
INSERT INTO `teleport` VALUES ('Aden -> Seal of Shilen', 1083, 188611, 20588, -3696, 3300, 0);
INSERT INTO `teleport` VALUES ('Aden -> Forest of Mirrors', 1084, 142065, 81300, -3000, 4400, 0);
INSERT INTO `teleport` VALUES ('Aden -> Fields of Massacre', 1085, 179718, -7843, -3517, 6500, 0);
INSERT INTO `teleport` VALUES ('Aden -> Ancient Battleground', 1086, 127739, -6998, -3869, 5900, 0);
INSERT INTO `teleport` VALUES ('Aden -> Silent Valley', 1087, 177318, 48447, -3835, 6100, 0);
INSERT INTO `teleport` VALUES ('Aden -> ToI', 1088, 121291, 15960, -4964, 4200, 0);
INSERT INTO `teleport` VALUES ('Goddard -> Gludio', 1089, -12672, 122776, -3116, 71000, 0);
INSERT INTO `teleport` VALUES ('Goddard -> Giran', 1090, 83400, 147943, -3404, 63000, 0);
INSERT INTO `teleport` VALUES ('Goddard -> Dion', 1091, 15670, 142983, -2705, 71000, 0);
INSERT INTO `teleport` VALUES ('Goddard -> Heine', 1092, 111409, 219364, -3545, 83000, 0);
INSERT INTO `teleport` VALUES ('Goddard -> Schuttgart', 1093, 87386, -143246, -1293, 10000, 0);
INSERT INTO `teleport` VALUES ('Goddard -> Oren', 1094, 82956, 53162, -1495, 37000, 0);
INSERT INTO `teleport` VALUES ('Goddard -> Hot Springs', 1095, 149594, -112698, -2065, 9300, 0);
INSERT INTO `teleport` VALUES ('Goddard -> Wall of Argos', 1096, 165054, -47861, -3560, 2200, 0);
INSERT INTO `teleport` VALUES ('Goddard -> Monastery of silence', 1097, 106414, -87799, -2920, 10000, 0);
INSERT INTO `teleport` VALUES ('Rune -> Dion', 1098, 15670, 142983, -2705, 57000, 0);
INSERT INTO `teleport` VALUES ('Rune -> Gludio', 1099, -12672, 122776, -3116, 53000, 0);
INSERT INTO `teleport` VALUES ('Rune -> Heine', 1100, 111409, 219364, -3545, 82000, 0);
INSERT INTO `teleport` VALUES ('Rune -> Schuttgart', 1101, 87386, -143246, -1293, 10000, 0);
INSERT INTO `teleport` VALUES ('Rune -> Oren', 1102, 82956, 53162, -1495, 10000, 0);
INSERT INTO `teleport` VALUES ('Rune -> Beast Farm', 1103, 57059, -82976, -2847, 4800, 0);
INSERT INTO `teleport` VALUES ('Rune -> Valley of Saints', 1104, 67992, -72012, -3748, 3800, 0);
INSERT INTO `teleport` VALUES ('Rune -> Monastery of Silence', 1105, 123743, -75032, -2902, 14000, 0);
INSERT INTO `teleport` VALUES ('Schuttgart -> Rune', 1106, 43799, -47727, -798, 10000, 0);
INSERT INTO `teleport` VALUES ('Schuttgart -> Goddard', 1107, 147928, -55273, -2734, 10000, 0);
INSERT INTO `teleport` VALUES ('Schuttgart -> Aden', 1108, 146331, 25762, -2018, 53000, 0);
INSERT INTO `teleport` VALUES ('Schuttgart -> Oren', 1109, 82956, 53162, -1495, 59000, 0);
INSERT INTO `teleport` VALUES ('Schuttgart -> Heine', 1110, 111409, 219364, -3545, 100000, 0);
INSERT INTO `teleport` VALUES ('Schuttgart -> Giran', 1111, 83400, 147943, -3404, 87000, 0);
INSERT INTO `teleport` VALUES ('Schuttgart -> Dion', 1112, 15670, 142983, -2705, 88000, 0);
INSERT INTO `teleport` VALUES ('Schuttgart -> Gludio', 1113, -12672, 122776, -3116, 85000, 0);
INSERT INTO `teleport` VALUES ('Schuttgart -> Orc Village', 1114, -44836, -112524, -235, 13000, 0);
INSERT INTO `teleport` VALUES ('Schuttgart -> Dwarven Village', 1115, 115113, -178212, -901, 4400, 0);
INSERT INTO `teleport` VALUES ('Schuttgart -> Nest of Evil Spirit', 1116, 76860, -125169, -3414, 3000, 0);
INSERT INTO `teleport` VALUES ('Schuttgart -> Wasteland of plunder', 1117, 109024, -159223, -1778, 1600, 0);
INSERT INTO `teleport` VALUES ('Schuttgart -> Labyrinth of winter', 1118, 113903, -108752, -848, 3500, 0);
INSERT INTO `teleport` VALUES ('Schuttgart -> Graveyard of disgrace', 1119, 56095, -118952, -3290, 1900, 0);
INSERT INTO `teleport` VALUES ('Schuttgart -> Farbel Ruins', 1120, 88288, -125692, -3816, 2100, 0);
INSERT INTO `teleport` VALUES ('Clan Hall -> Execution Grounds', 502, 51055, 141959, -2869, 500, 0);
INSERT INTO `teleport` VALUES ('Clan Hall -> Cruma Marshlands', 504, 5106, 126916, -3664, 500, 0);
INSERT INTO `teleport` VALUES ('Clan Hall -> Cruma Tower Entrance', 505, 17192, 114178, -3439, 500, 0);
INSERT INTO `teleport` VALUES ('Clan Hall -> Town of Dion', 507, 15670, 142983, -2705, 500, 0);
INSERT INTO `teleport` VALUES ('Clan Hall -> Floran Village', 508, 17838, 170274, -3508, 500, 0);
INSERT INTO `teleport` VALUES ('Clan Hall -> Tanor Canyon', 510, 58316, 163851, -2816, 500, 0);
INSERT INTO `teleport` VALUES ('Clan Hall -> Bee Hive', 511, 20505, 189036, -3344, 500, 0);
INSERT INTO `teleport` VALUES ('Clan Hall -> Hardin''s Academy', 517, 105918, 109759, -3207, 500, 0);
INSERT INTO `teleport` VALUES ('Clan Hall -> Dragon Valley', 518, 122824, 110836, -3720, 500, 0);
INSERT INTO `teleport` VALUES ('Clan Hall -> Death Pass', 521, 70000, 126636, -3804, 500, 0);
INSERT INTO `teleport` VALUES ('Clan Hall -> Pirate Tunnel', 522, 41298, 200350, -4583, 500, 0);
INSERT INTO `teleport` VALUES ('Clan Hall -> Giran Harbor', 524, 47942, 186764, -3485, 500, 0);
INSERT INTO `teleport` VALUES ('Clan Hall -> Giran Castle Town', 525, 83400, 147943, -3404, 500, 0);
INSERT INTO `teleport` VALUES ('Clan Hall -> Giran Arena', 526, 73890, 142656, -3778, 500, 0);
INSERT INTO `teleport` VALUES ('Clan Hall -> Breka''s Stronghold', 528, 79798, 130624, -3677, 500, 0);
INSERT INTO `teleport` VALUES ('Clan Hall -> Ivory Tower', 581, 85348, 16142, -3699, 500, 0);
INSERT INTO `teleport` VALUES ('Clan Hall -> Town of Oren', 582, 82956, 53162, -1495, 500, 0);
INSERT INTO `teleport` VALUES ('Clan Hall -> Plains of Lizardmen', 584, 87252, 85514, -3056, 500, 0);
INSERT INTO `teleport` VALUES ('Clan Hall -> Skyshadow Meadow', 585, 82764, 61145, -3502, 500, 0);
INSERT INTO `teleport` VALUES ('Clan Hall -> Spider Nest', 588, -56532, 78321, -2960, 500, 0);
INSERT INTO `teleport` VALUES ('Clan Hall -> Outlaw Forest', 592, 85995, -2433, -3528, 500, 0);
INSERT INTO `teleport` VALUES ('Clan Hall -> Tower of Insolence', 598, 121685, 15749, -3852, 500, 0);
INSERT INTO `teleport` VALUES ('Clan Hall -> The Blazing Swamp', 599, 146828, -12859, -4455, 500, 0);
INSERT INTO `teleport` VALUES ('Clan Hall -> The Forbidden Gateway', 601, 185395, 20359, -3270, 500, 0);
INSERT INTO `teleport` VALUES ('Clan Hall -> The Giants Cave', 602, 174528, 52683, -4369, 500, 0);
INSERT INTO `teleport` VALUES ('Clan Hall -> Northern Pathway of Enchanted Valley', 603, 104426, 33746, -3800, 500, 0);
INSERT INTO `teleport` VALUES ('Clan Hall -> The Cemetery', 604, 172136, 20325, -3326, 500, 0);
INSERT INTO `teleport` VALUES ('Clan Hall -> The Forest of Mirrors', 605, 150477, 85907, -2753, 500, 0);
INSERT INTO `teleport` VALUES ('Clan Hall -> Anghel Waterfall', 606, 165584, 85997, -2338, 500, 0);
INSERT INTO `teleport` VALUES ('Clan Hall -> Aden Castle Town', 607, 146331, 25762, -2018, 500, 0);
INSERT INTO `teleport` VALUES ('Clan Hall -> Hunters Village', 608, 117110, 76883, -2695, 500, 0);
INSERT INTO `teleport` VALUES ('Clan Hall -> Border Outpost(Aden Side)', 609, 109699, -7908, -2902, 500, 0);
INSERT INTO `teleport` VALUES ('Clan Hall -> Coliseum', 610, 150086, 46733, -3412, 500, 0);
INSERT INTO `teleport` VALUES ('Clan Hall -> Ancient Battleground', 613, 127739, -6998, -3869, 500, 0);
INSERT INTO `teleport` VALUES ('Clan Hall -> Forsaken Plains', 614, 167285, 37109, -4008, 500, 0);
INSERT INTO `teleport` VALUES ('Clan Hall -> Silent Valley', 615, 177318, 48447, -3835, 500, 0);
INSERT INTO `teleport` VALUES ('Clan Hall -> Fields of Massacre', 618, 179718, 48447, -7843, 500, 0);
INSERT INTO `teleport` VALUES ('Clan Hall -> Border Outpost(Unknown Side)', 620, 114172, -18034, -1875, 500, 0);
INSERT INTO `teleport` VALUES ('Clan Hall -> Rune Castle Town - Shopping Area', 621, 43835, -47749, -796, 0, 0);
INSERT INTO `teleport` VALUES ('Clan Hall -> Rune Castle Town - Temple', 622, 38303, -48044, 897, 0, 0);
INSERT INTO `teleport` VALUES ('Clan Hall -> Rune Castle Town - North Gate', 623, 38956, -53648, -1343, 0, 0);
INSERT INTO `teleport` VALUES ('Clan Hall -> Rune Castle Town - Harbor', 624, 38025, -38359, -3608, 0, 0);
INSERT INTO `teleport` VALUES ('Clan Hall -> Beast Farm', 625, 42598, -88832, -3124, 500, 0);
INSERT INTO `teleport` VALUES ('Clan Hall -> Forest of the Dead - East Entrance', 626, 61868, -48890, -3128, 500, 0);
INSERT INTO `teleport` VALUES ('Clan Hall -> Forest of the Dead - West Entrance', 627, 45555, -56081, -3667, 500, 0);
INSERT INTO `teleport` VALUES ('Clan Hall -> Swamp of Screams - East Entrance', 628, 94152, -58694, -2832, 500, 0);
INSERT INTO `teleport` VALUES ('Clan Hall -> Swamp of Screams - West Entrance', 629, 69999, -49929, -3253, 500, 0);
INSERT INTO `teleport` VALUES ('Clan Hall -> Valley of the Saints', 630, 65800, -71526, -3747, 500, 0);
INSERT INTO `teleport` VALUES ('Clan Hall -> Village Square', 631, 147728, -56331, -2776, 0, 0);
INSERT INTO `teleport` VALUES ('Clan Hall -> North Gate Entrance', 632, 147731, -58930, -2976, 0, 0);
INSERT INTO `teleport` VALUES ('Clan Hall -> East Gate Entrance', 633, 150561, -57489, -2976, 0, 0);
INSERT INTO `teleport` VALUES ('Clan Hall -> West Gate Entrance', 634, 144866, -57464, -2976, 0, 0);
INSERT INTO `teleport` VALUES ('Clan Hall -> Forge of the Gods', 635, 168902, -116703, -2417, 0, 0);
INSERT INTO `teleport` VALUES ('Clan Hall -> Garden of Beasts', 636, 129138, -60864, -3576, 500, 0);
INSERT INTO `teleport` VALUES ('Clan Hall -> Swamp of Screams', 637, 70006, -49902, -3251, 500, 0);
INSERT INTO `teleport` VALUES ('Clan Hall -> Valley of Saints', 638, 67992, -72012, -3748, 500, 0);
INSERT INTO `teleport` VALUES ('Clan Hall -> Monastery of Silence', 639, 123743, -75032, -2902, 500, 0);
INSERT INTO `teleport` VALUES ('Clan Hall -> Wall of Argos', 640, 164564, -48145, -3536, 500, 0);
INSERT INTO `teleport` VALUES ('Clan Hall -> Hot Springs', 641, 144880, -113468, -2560, 500, 0);
INSERT INTO `teleport` VALUES ('Clan Hall -> Ketra Orc Outpost', 642, 146990, -67128, -3640, 500, 0);
INSERT INTO `teleport` VALUES ('Clan Hall -> Goddard Border Checkpoint', 643, 157560, -33269, -3320, 500, 0);
INSERT INTO `teleport` VALUES ('Clan Hall -> Aden Border Checkpoint', 644, 125381, -33536, -3848, 500, 0);
INSERT INTO `teleport` VALUES ('Clan Hall -> Garden of Beasts', 645, 129138, -60864, -3576, 500, 0);
INSERT INTO `teleport` VALUES ('Clan Hall -> Devil''s Pass', 646, 106849, -62061, -2968, 500, 0);
INSERT INTO `teleport` VALUES ('Clan Hall -> Varka Silenos Outpost', 647, 125740, -40864, -3736, 500, 0);
INSERT INTO `teleport` VALUES ('Clan Hall -> Village Square', 648, -82445, 150788, -3129, 0, 0);
INSERT INTO `teleport` VALUES ('Clan Hall -> North Gate Entrance', 649, -83331, 148563, -3148, 0, 0);
INSERT INTO `teleport` VALUES ('Clan Hall -> East Gate Entrance', 650, -78405, 152723, -3181, 0, 0);
INSERT INTO `teleport` VALUES ('Clan Hall -> Nanmen Entrance', 651, -77460, 155995, -3194, 0, 0);
INSERT INTO `teleport` VALUES ('Clan Hall -> West Gate Entrance', 652, -85138, 152749, -3160, 0, 0);
INSERT INTO `teleport` VALUES ('Clan Hall -> Neutral Zone', 653, -10612, 75881, -3592, 500, 0);
INSERT INTO `teleport` VALUES ('Clan Hall -> Langk Lizardmen Dwellings', 654, -36961, 201895, -2760, 500, 0);
INSERT INTO `teleport` VALUES ('Clan Hall -> Windy Hill', 655, -93453, 89814, -3240, 500, 0);
INSERT INTO `teleport` VALUES ('Clan Hall -> Orc Barracks', 656, -85329, 106369, -3603, 500, 0);
INSERT INTO `teleport` VALUES ('Clan Hall -> Fellmere Harvesting Ground', 657, -68668, 115407, -3600, 500, 0);
INSERT INTO `teleport` VALUES ('Clan Hall -> Ruins of Agony', 658, -41055, 122647, -2889, 500, 0);
INSERT INTO `teleport` VALUES ('Clan Hall -> Abandoned Camp', 659, -49756, 146951, -2828, 500, 0);
INSERT INTO `teleport` VALUES ('Clan Hall -> Forgotten Temple', 660, -52369, 191259, -3610, 500, 0);
INSERT INTO `teleport` VALUES ('Clan Hall -> The Ant Nest', 661, -14913, 170017, -2893, 500, 0);
INSERT INTO `teleport` VALUES ('Clan Hall -> Wasteland', 662, -47506, 179572, -3669, 500, 0);
INSERT INTO `teleport` VALUES ('Clan Hall -> Ol Mahum Checkpoint', 663, -17279, 208954, -3664, 500, 0);
INSERT INTO `teleport` VALUES ('Clan Hall -> Ant Cave South Entrance', 664, -16019, 193365, -4488, 500, 0);
INSERT INTO `teleport` VALUES ('Clan Hall -> Ant Cave East Entrance', 665, -10875, 175962, -4152, 500, 0);
INSERT INTO `teleport` VALUES ('Clan Hall -> Ant Cave West Entrance', 666, -25899, 172857, -4186, 500, 0);
INSERT INTO `teleport` VALUES ('Clan Hall -> Altar of Rites', 667, -44311, 78617, -3744, 500, 0);
INSERT INTO `teleport` VALUES ('Gludin Arena - 1000 adena', 9000, -87328, 142266, -3640, 1000, 0);
INSERT INTO `teleport` VALUES ('Coliseum - 1000 adena', 9001, 146440, 46723, -3432, 1000, 0);
INSERT INTO `teleport` VALUES ('Giran Arena - 1000 adena', 9002, 73579, 142709, -3768, 1000, 0);
INSERT INTO `teleport` VALUES ('Forgotten Temple - 1000 adena', 9010, -54026, 179504, -4640, 1000, 0);
INSERT INTO `teleport` VALUES ('Wasteland  - 1000 adena', 9011, -47506, 179572, -3632, 1000, 0);
INSERT INTO `teleport` VALUES ('Silent Valley - 1000 adena', 9020, 181737, 46469, -4352, 1000, 0);
INSERT INTO `teleport` VALUES ('Plains of Glory - 1000 adena', 9021, 135756, 19557, -3424, 1000, 0);
INSERT INTO `teleport` VALUES ('War-Torn Plains - 1000 adena', 9022, 156898, 11217, -4032, 1000, 0);
INSERT INTO `teleport` VALUES ('Tower of Insolence, 3rd Floor - 1000 adena', 9023, 110848, 16154, -2120, 1000, 0);
INSERT INTO `teleport` VALUES ('Tower of Insolence, 5th Floor - 1000 adena', 9024, 118404, 15988, 832, 1000, 0);
INSERT INTO `teleport` VALUES ('Tower of Insolence, 7th Floor - 1000 adena', 9025, 115064, 12181, 2960, 1000, 0);
INSERT INTO `teleport` VALUES ('Tower of Insolence, 10th Floor - 1000 adena', 9026, 118525, 16455, 5984, 1000, 0);
INSERT INTO `teleport` VALUES ('Tower of Insolence, 13th Floor - 1000 adena', 9027, 115384, 16820, 9000, 1000, 0);
INSERT INTO `teleport` VALUES ('Hunters Valley - 1000 adena', 9028, 114306, 86573, -3112, 1000, 0);
INSERT INTO `teleport` VALUES ('Angel Waterfall - 1000 adena', 9029, 166182, 91560, -3168, 1000, 0);
INSERT INTO `teleport` VALUES ('Forest of Mirrors - 1000 adena', 9030, 166080, 75574, -2992, 1000, 0);
INSERT INTO `teleport` VALUES ('Enchanted Valley - 1000 adena', 9031, 114674, 44150, -3376, 1000, 0);
INSERT INTO `teleport` VALUES ('Hunters Valley - 1000 adena', 9032, 114306, 86573, -3112, 1000, 0);
INSERT INTO `teleport` VALUES ('Gorgon Flower Garden - 1000 adena', 9040, 113553, 134813, -3640, 1000, 0);
INSERT INTO `teleport` VALUES ('Antharas Lair 1 - 1000 adena', 9041, 147071, 120156, -4520, 1000, 0);
INSERT INTO `teleport` VALUES ('Antharas Lair 2 - 1000 adena', 9042, 151689, 112615, -5520, 1000, 0);
INSERT INTO `teleport` VALUES ('Dragon Valley - 1000 adena', 9043, 116425, 109898, -3424, 1000, 0);
INSERT INTO `teleport` VALUES ('Antharas Lair, Heart of Warding - 1000 adena', 9044, 154396, 121235, -3808, 1000, 0);
INSERT INTO `teleport` VALUES ('Dragon Valley, Traders Post - 1000 adena', 9045, 122824, 110836, -3720, 1000, 0);
INSERT INTO `teleport` VALUES ('Private Hardin''s Academy - 1000 adena', 9046, 105918, 109759, -3192, 1000, 0);
INSERT INTO `teleport` VALUES ('Forest of the Dead - 1000 adena', 9050, 54425, -41692, -3072, 1000, 0);
INSERT INTO `teleport` VALUES ('Valley of Saints - 1000 adena', 9051, 84092, -80084, -3504, 1000, 0);
INSERT INTO `teleport` VALUES ('Cursed Village - 1000 adena', 9052, 57670, -41672, -3144, 1000, 0);
INSERT INTO `teleport` VALUES ('Stakato Nest - 1000 adena', 9053, 88969, -45307, -2104, 1000, 0);
INSERT INTO `teleport` VALUES ('Monastery of Silence - 1000 adena', 9054, 106414, -87799, -2920, 1000, 0);
INSERT INTO `teleport` VALUES ('Varka Silenos Village - 1000 adena', 9060, 107929, -52248, -2408, 1000, 0);
INSERT INTO `teleport` VALUES ('Ketra Orc Village - 1000 adena', 9061, 149817, -80053, -5576, 1000, 0);
INSERT INTO `teleport` VALUES ('Devil''s Pass - 1000 adena', 9062, 106349, -61870, -2904, 1000, 0);
INSERT INTO `teleport` VALUES ('Garden of Beasts - 1000 adena', 9063, 132997, -60608, -2960, 1000, 0);
INSERT INTO `teleport` VALUES ('Hot Springs - 1000 adena', 9064, 144625, -101291, -3384, 1000, 0);
INSERT INTO `teleport` VALUES ('Wall of Argos - 1000 adena', 9065, 183140, -53307, -1896, 1000, 0);
INSERT INTO `teleport` VALUES ('Wall of Argos - 1000 adena', 9066, 183140, -53307, -1896, 1000, 0);
INSERT INTO `teleport` VALUES ('Four Sepulchers - 1000 adena', 9067, 178127, -84435, -7216, 1000, 0);
INSERT INTO `teleport` VALUES ('Imperial Tomb - 1000 adena', 9068, 186699, -75915, -2824, 1000, 0);
INSERT INTO `teleport` VALUES ('Forge of the Gods, entrance - 1000 adena', 9069, 169018, -116303, -2432, 1000, 0);
INSERT INTO `teleport` VALUES ('Forge of the Gods, entrance - 1000 adena', 9070, 169018, -116303, -2432, 1000, 0);
INSERT INTO `teleport` VALUES ('Forge of the Gods, lower level - 1000 adena', 9071, 179887, -111241, -5824, 1000, 0);
INSERT INTO `teleport` VALUES ('Execution Grounds - 1000 adena', 9080, 50568, 152408, -2656, 1000, 0);
INSERT INTO `teleport` VALUES ('Floran Agricultural Area - 1000 adena', 9081, 26810, 172787, -3376, 1000, 0);
INSERT INTO `teleport` VALUES ('Cruma Marshlands - 1000 adena', 9082, 5941, 125455, -3640, 1000, 0);
INSERT INTO `teleport` VALUES ('Cruma Tower, 1st Floor - 1000 adena', 9083, 17718, 117315, -12064, 1000, 0);
INSERT INTO `teleport` VALUES ('Cruma Tower, 2nd Floor - 1000 adena', 9084, 17728, 110325, -9312, 1000, 0);
INSERT INTO `teleport` VALUES ('Frost Lake - 1000 adena', 9090, 107577, -122392, -3632, 1000, 0);
INSERT INTO `teleport` VALUES ('Crypts of Disgrace - 1000 adena', 9091, 44221, -114232, -2784, 1000, 0);
INSERT INTO `teleport` VALUES ('Sky Wagon Relic - 1000 adena', 9092, 121618, -141554, -1496, 1000, 0);
INSERT INTO `teleport` VALUES ('Evil Hunting Grounds - 1000 adena', 9100, -6989, 109503, -3040, 1000, 0);
INSERT INTO `teleport` VALUES ('Neutral Zone - 1000 adena', 9101, -18415, 85624, -3680, 1000, 0);
INSERT INTO `teleport` VALUES ('Dark Forest - 1000 adena', 9102, -14129, 27094, -3680, 1000, 0);
INSERT INTO `teleport` VALUES ('School of Dark Arts - 1000 adena', 9103, -49185, 49441, -5912, 1000, 0);
INSERT INTO `teleport` VALUES ('Elven Ruins - 1000 adena', 9104, 49315, 248452, -5960, 1000, 0);
INSERT INTO `teleport` VALUES ('Immortal Plateau - 1000 adena', 9105, -25309, -131569, -680, 1000, 0);
INSERT INTO `teleport` VALUES ('Mithril Mines - 1000 adena', 9106, 175499, -181586, -904, 1000, 0);
INSERT INTO `teleport` VALUES ('Abandoned Coal Mines - 1000 adena', 9107, 144706, -173223, -1520, 1000, 0);
INSERT INTO `teleport` VALUES ('Forest of Evil - 1000 adena', 9110, 93218, 16969, -3904, 1000, 0);
INSERT INTO `teleport` VALUES ('Timak Outpost - 1000 adena', 9111, 67097, 68815, -3648, 1000, 0);
INSERT INTO `teleport` VALUES ('Altar of Rites - 1000 adena', 9112, -44566, 77508, -3736, 1000, 0);
INSERT INTO `teleport` VALUES ('Fields of Silence - 1000 adena', 9120, 69748, 186111, -2872, 1000, 0);
INSERT INTO `teleport` VALUES ('Field of Whispers - 1000 adena', 9121, 97786, 209303, -3040, 1000, 0);
INSERT INTO `teleport` VALUES ('Alligator Island - 1000 adena', 9122, 113708, 178387, -3232, 1000, 0);
INSERT INTO `teleport` VALUES ('Garden of Eva, entrance - 1000 adena', 9123, 82693, 242220, -6712, 1000, 0);
INSERT INTO `teleport` VALUES ('Garden of Eva, 2nd level - 1000 adena', 9124, 79248, 247390, -8816, 1000, 0);
INSERT INTO `teleport` VALUES ('Garden of Eva, 3rd level - 1000 adena', 9125, 77868, 250400, -9328, 1000, 0);
INSERT INTO `teleport` VALUES ('Garden of Eva, 4th level - 1000 adena', 9126, 78721, 253309, -9840, 1000, 0);
INSERT INTO `teleport` VALUES ('Garden of Eva, 5th level - 1000 adena', 9127, 82951, 252354, -10592, 1000, 0);
INSERT INTO `teleport` VALUES ('Gludin Arena - 1 Noble Gate Pass', 9900, -87328, 142266, -3640, 1, 1);
INSERT INTO `teleport` VALUES ('Coliseum - 1 Noble Gate Pass', 9901, 146440, 46723, -3432, 1, 1);
INSERT INTO `teleport` VALUES ('Giran Arena - 1 Noble Gate Pass', 9902, 73579, 142709, -3768, 1, 1);
INSERT INTO `teleport` VALUES ('Forgotten Temple - 1 Noble Gate Pass', 9910, -54026, 179504, -4640, 1, 1);
INSERT INTO `teleport` VALUES ('Wasteland  - 1 Noble Gate Pass', 9911, -47506, 179572, -3632, 1, 1);
INSERT INTO `teleport` VALUES ('Silent Valley - 1 Noble Gate Pass', 9920, 181737, 46469, -4352, 1, 1);
INSERT INTO `teleport` VALUES ('Plains of Glory - 1 Noble Gate Pass', 9921, 135756, 19557, -3424, 1, 1);
INSERT INTO `teleport` VALUES ('War-Torn Plains - 1 Noble Gate Pass', 9922, 156898, 11217, -4032, 1, 1);
INSERT INTO `teleport` VALUES ('Tower of Insolence, 3rd Floor - 1 Noble Gate Pass', 9923, 110848, 16154, -2120, 1, 1);
INSERT INTO `teleport` VALUES ('Tower of Insolence, 5th Floor - 1 Noble Gate Pass', 9924, 118404, 15988, 832, 1, 1);
INSERT INTO `teleport` VALUES ('Tower of Insolence, 7th Floor - 1 Noble Gate Pass', 9925, 115064, 12181, 2960, 1, 1);
INSERT INTO `teleport` VALUES ('Tower of Insolence, 10th Floor - 1 Noble Gate Pass', 9926, 118525, 16455, 5984, 1, 1);
INSERT INTO `teleport` VALUES ('Tower of Insolence, 13th Floor - 1 Noble Gate Pass', 9927, 115384, 16820, 9000, 1, 1);
INSERT INTO `teleport` VALUES ('Hunters Valley - 1 Noble Gate Pass', 9928, 114306, 86573, -3112, 1, 1);
INSERT INTO `teleport` VALUES ('Angel Waterfall - 1 Noble Gate Pass', 9929, 166182, 91560, -3168, 1, 1);
INSERT INTO `teleport` VALUES ('Forest of Mirrors - 1 Noble Gate Pass', 9930, 166080, 75574, -2992, 1, 1);
INSERT INTO `teleport` VALUES ('Enchanted Valley - 1 Noble Gate Pass', 9931, 114674, 44150, -3376, 1, 1);
INSERT INTO `teleport` VALUES ('Hunters Valley - 1 Noble Gate Pass', 9932, 114306, 86573, -3112, 1, 1);
INSERT INTO `teleport` VALUES ('Gorgon Flower Garden - 1 Noble Gate Pass', 9940, 113553, 134813, -3640, 1, 1);
INSERT INTO `teleport` VALUES ('Antharas Lair 1 - 1 Noble Gate Pass', 9941, 147071, 120156, -4520, 1, 1);
INSERT INTO `teleport` VALUES ('Antharas Lair 2 - 1 Noble Gate Pass', 9942, 151689, 112615, -5520, 1, 1);
INSERT INTO `teleport` VALUES ('Dragon Valley - 1 Noble Gate Pass', 9943, 116425, 109898, -3424, 1, 1);
INSERT INTO `teleport` VALUES ('Antharas Lair, Heart of Warding - 1 Noble Gate Pass', 9944, 154396, 121235, -3808, 1, 1);
INSERT INTO `teleport` VALUES ('Dragon Valley, Traders Post - 1 Noble Gate Pass', 9945, 122824, 110836, -3720, 1, 1);
INSERT INTO `teleport` VALUES ('Private Hardin''s Academy - 1 Noble Gate Pass', 9946, 105918, 109759, -3192, 1, 1);
INSERT INTO `teleport` VALUES ('Forest of the Dead - 1 Noble Gate Pass', 9950, 54425, -41692, -3072, 1, 1);
INSERT INTO `teleport` VALUES ('Valley of Saints - 1 Noble Gate Pass', 9951, 84092, -80084, -3504, 1, 1);
INSERT INTO `teleport` VALUES ('Cursed Village - 1 Noble Gate Pass', 9952, 57670, -41672, -3144, 1, 1);
INSERT INTO `teleport` VALUES ('Stakato Nest - 1 Noble Gate Pass', 9953, 88969, -45307, -2104, 1, 1);
INSERT INTO `teleport` VALUES ('Monastery of Silence - 1 Noble Gate Pass', 9954, 106414, -87799, -2920, 1, 1);
INSERT INTO `teleport` VALUES ('Varka Silenos Village - 1 Noble Gate Pass', 9960, 107929, -52248, -2408, 1, 1);
INSERT INTO `teleport` VALUES ('Ketra Orc Village - 1 Noble Gate Pass', 9961, 149817, -80053, -5576, 1, 1);
INSERT INTO `teleport` VALUES ('Devil''s Pass - 1 Noble Gate Pass', 9962, 106349, -61870, -2904, 1, 1);
INSERT INTO `teleport` VALUES ('Garden of Beasts - 1 Noble Gate Pass', 9963, 132997, -60608, -2960, 1, 1);
INSERT INTO `teleport` VALUES ('Hot Springs - 1 Noble Gate Pass', 9964, 144625, -101291, -3384, 1, 1);
INSERT INTO `teleport` VALUES ('Wall of Argos - 1 Noble Gate Pass', 9965, 183140, -53307, -1896, 1, 1);
INSERT INTO `teleport` VALUES ('Four Sepulchers - 1 Noble Gate Pass', 9967, 178127, -84435, -7216, 1, 1);
INSERT INTO `teleport` VALUES ('Imperial Tomb - 1 Noble Gate Pass', 9968, 186699, -75915, -2824, 1, 1);
INSERT INTO `teleport` VALUES ('Forge of the Gods, entrance - 1 Noble Gate Pass', 9970, 169018, -116303, -2432, 1, 1);
INSERT INTO `teleport` VALUES ('Forge of the Gods, lower level - 1 Noble Gate Pass', 9971, 179887, -111241, -5824, 1, 1);
INSERT INTO `teleport` VALUES ('Execution Grounds - 1 Noble Gate Pass', 9980, 50568, 152408, -2656, 1, 1);
INSERT INTO `teleport` VALUES ('Floran Agricultural Area - 1 Noble Gate Pass', 9981, 26810, 172787, -3376, 1, 1);
INSERT INTO `teleport` VALUES ('Cruma Marshlands - 1 Noble Gate Pass', 9982, 5941, 125455, -3640, 1, 1);
INSERT INTO `teleport` VALUES ('Cruma Tower, 1st Floor - 1 Noble Gate Pass', 9983, 17718, 117315, -12064, 1, 1);
INSERT INTO `teleport` VALUES ('Cruma Tower, 2nd Floor - 1 Noble Gate Pass', 9984, 17728, 110325, -9312, 1, 1);
INSERT INTO `teleport` VALUES ('Frost Lake - 1 Noble Gate Pass', 9990, 107577, -122392, -3632, 1, 1);
INSERT INTO `teleport` VALUES ('Crypts of Disgrace - 1 Noble Gate Pass', 9991, 44221, -114232, -2784, 1, 1);
INSERT INTO `teleport` VALUES ('Sky Wagon Relic - 1 Noble Gate Pass', 9992, 121618, -141554, -1496, 1, 1);
INSERT INTO `teleport` VALUES ('Evil Hunting Grounds - 1 Noble Gate Pass', 10000, -6989, 109503, -3040, 1, 1);
INSERT INTO `teleport` VALUES ('Neutral Zone - 1 Noble Gate Pass', 10001, -18415, 85624, -3680, 1, 1);
INSERT INTO `teleport` VALUES ('Dark Forest - 1 Noble Gate Pass', 10002, -14129, 27094, -3680, 1, 1);
INSERT INTO `teleport` VALUES ('School of Dark Arts - 1 Noble Gate Pass', 10003, -49185, 49441, -5912, 1, 1);
INSERT INTO `teleport` VALUES ('Elven Ruins - 1 Noble Gate Pass', 10004, 49315, 248452, -5960, 1, 1);
INSERT INTO `teleport` VALUES ('Immortal Plateau - 1 Noble Gate Pass', 10005, -25309, -131569, -680, 1, 1);
INSERT INTO `teleport` VALUES ('Mithril Mines - 1 Noble Gate Pass', 10006, 175499, -181586, -904, 1, 1);
INSERT INTO `teleport` VALUES ('Abandoned Coal Mines - 1 Noble Gate Pass', 10007, 144706, -173223, -1520, 1, 1);
INSERT INTO `teleport` VALUES ('Forest of Evil - 1 Noble Gate Pass', 10010, 93218, 16969, -3904, 1, 1);
INSERT INTO `teleport` VALUES ('Timak Outpost - 1 Noble Gate Pass', 10011, 67097, 68815, -3648, 1, 1);
INSERT INTO `teleport` VALUES ('Altar of Rites - 1 Noble Gate Pass', 10012, -44566, 77508, -3736, 1, 1);
INSERT INTO `teleport` VALUES ('Field of Silence - 1 Noble Gate Pass', 10020, 69748, 186111, -2872, 1, 1);
INSERT INTO `teleport` VALUES ('Field of Whispers - 1 Noble Gate Pass', 10021, 97786, 209303, -3040, 1, 1);
INSERT INTO `teleport` VALUES ('Alligator Island - 1 Noble Gate Pass', 10022, 113708, 178387, -3232, 1, 1);
INSERT INTO `teleport` VALUES ('Garden of Eva, entrance - 1 Noble Gate Pass', 10023, 82693, 242220, -6712, 1, 1);
INSERT INTO `teleport` VALUES ('Garden of Eva, 2nd ring - 1 Noble Gate Pass', 10024, 79248, 247390, -8816, 1, 1);
INSERT INTO `teleport` VALUES ('Garden of Eva, 3rd ring - 1 Noble Gate Pass', 10025, 77868, 250400, -9328, 1, 1);
INSERT INTO `teleport` VALUES ('Garden of Eva, 4th ring - 1 Noble Gate Pass', 10026, 78721, 253309, -9840, 1, 1);
INSERT INTO `teleport` VALUES ('Garden of Eva, 5th level - 1 Noble Gate Pass', 10027, 82951, 252354, -10592, 1, 1);
INSERT INTO `teleport` VALUES ('Innadril(artifact -> out)', 421, 116046, 247094, -930, 0, 0);
INSERT INTO `teleport` VALUES ('Innadril(artifact -> hall)', 422, 116028, 249163, -787, 0, 0);
INSERT INTO `teleport` VALUES ('Innadril(artifact -> outofcastle)', 423, 116373, 244729, -1059, 0, 0);
INSERT INTO `teleport` VALUES ('Innadril(hall -> artifact)', 424, 116028, 250136, -867, 0, 0);
INSERT INTO `teleport` VALUES ('Innadril(hall -> out)', 425, 116046, 247094, -930, 0, 0);
INSERT INTO `teleport` VALUES ('Innadril(hall -> outofcastle)', 426, 116373, 244729, -1059, 0, 0);
INSERT INTO `teleport` VALUES ('Innadril(out -> artifact)', 427, 116028, 250136, -867, 0, 0);
INSERT INTO `teleport` VALUES ('Innadril(out -> hall)', 428, 116028, 249163, -787, 0, 0);
INSERT INTO `teleport` VALUES ('Innadril(out -> outofcastle)', 429, 116373, 244729, -1059, 0, 0);
INSERT INTO `teleport` VALUES ('Innadril(outofcastle -> artifact)', 430, 116028, 250136, -867, 0, 0);
INSERT INTO `teleport` VALUES ('Innadril(outofcastle -> out)', 431, 116046, 247094, -930, 0, 0);
INSERT INTO `teleport` VALUES ('Innadril(outofcastle -> hall)', 432, 116028, 249163, -787, 0, 0);
INSERT INTO `teleport` VALUES ('Goddard(artifact -> out)', 433, 147466, -48514, -2085, 0, 0);
INSERT INTO `teleport` VALUES ('Goddard(artifact -> hall)', 434, 147463, -48504, -2277, 0, 0);
INSERT INTO `teleport` VALUES ('Goddard(artifact -> outofcastle)', 435, 147265, -44908, -2085, 0, 0);
INSERT INTO `teleport` VALUES ('Goddard(hall -> artifact)', 436, 146165, -50478, -1604, 0, 0);
INSERT INTO `teleport` VALUES ('Goddard(hall -> out)', 437, 147466, -48514, -2085, 0, 0);
INSERT INTO `teleport` VALUES ('Goddard(hall -> outofcastle)', 438, 147265, -44908, -2085, 0, 0);
INSERT INTO `teleport` VALUES ('Goddard(out -> artifact)', 439, 146165, -50478, -1604, 0, 0);
INSERT INTO `teleport` VALUES ('Goddard(out -> hall)', 440, 147463, -48504, -2277, 0, 0);
INSERT INTO `teleport` VALUES ('Goddard(out -> outofcastle)', 441, 147265, -44908, -2085, 0, 0);
INSERT INTO `teleport` VALUES ('Goddard(outofcastle -> artifact)', 442, 146165, -50478, -1604, 0, 0);
INSERT INTO `teleport` VALUES ('Goddard(outofcastle -> out)', 443, 147466, -48514, -2085, 0, 0);
INSERT INTO `teleport` VALUES ('Goddard(outofcastle -> hall)', 444, 147463, -48504, -2277, 0, 0);
INSERT INTO `teleport` VALUES ('Rune(artifact -> out)', 501, 16981, -49170, -1098, 0, 0);
INSERT INTO `teleport` VALUES ('Rune(artifact -> outofcastle)', 503, 19049, -49141, -1258, 0, 0);
INSERT INTO `teleport` VALUES ('Rune(hall -> outofcastle)', 506, 19049, -49141, -1258, 0, 0);
INSERT INTO `teleport` VALUES ('Rune(out -> outofcastle)', 509, 19049, -49141, -1258, 0, 0);
INSERT INTO `teleport` VALUES ('Rune(outofcastle -> hall)', 512, 11729, -49154, -537, 0, 0);
INSERT INTO `teleport` VALUES ('Schuttgard(artifact -> out)', 513, 77501, -149943, -353, 0, 0);
INSERT INTO `teleport` VALUES ('Schuttgard(artifact -> hall)', 514, 77547, -152461, -545, 0, 0);
INSERT INTO `teleport` VALUES ('Schuttgard(artifact -> outofcastle)', 515, 77562, -149119, -353, 0, 0);
INSERT INTO `teleport` VALUES ('Schuttgard(hall -> artifact)', 516, 77557, -154975, 387, 0, 0);
INSERT INTO `teleport` VALUES ('Schuttgard(out -> artifact)', 519, 77557, -154975, 387, 0, 0);
INSERT INTO `teleport` VALUES ('Schuttgard(out -> hall)', 520, 77547, -152461, -545, 0, 0);
INSERT INTO `teleport` VALUES ('Schuttgard(outofcastle -> out)', 523, 77501, -149943, -353, 0, 0);
INSERT INTO `teleport` (`Description`, `id`, `loc_x`, `loc_y`, `loc_z`, `price`, `fornoble`) VALUES
('Clan Hall --> Center Town of Aden', 12000, 147450, 28081, -2294, 0, 0),
('Clan Hall --> North Town of Aden', 12001, 151950, 25094, -2172, 0, 0),
('Clan Hall --> East Town of Aden', 12002, 142593, 26344, -2425, 0, 0),
('Clan Hall --> South Town of Aden', 12003, 147503, 32299, -2501, 0, 0),
('Clan Hall --> West Town of Aden', 12004, 147465, 20737, -2130, 0, 0),
('Clan Hall -> Southern Pathway of Enchanted Valley', 12005, 124904, 61992, -3973, 500, 0),
('Clan Hall --> East of Blazing Swamp', 12006, 159676, -13544, -2832, 500, 0),
('Clan Hall --> Plains of Glory', 12007, 133164, 14036, -3888, 500, 0),
('Clan Hall --> Plains of Fierce Battle', 12008, 153757, 8905, -4024, 500, 0),
('Clan Hall --> Path to Forest of Wirrors', 12009, 134310, 71976, -3298, 500, 0),
('Clan Hall --> The Front of Anghel Waterfall', 12010, 163341, 91374, -3320, 500, 0),
('Clan Hall --> Disciples Necropolis', 12011, 168779, -18790, -3184, 500, 0),
('Clan Hall --> North Path to The Cementery', 12012, 175191, 4082, -2863, 500, 0),
('Clan Hall -->South Path to The Cementery', 12013, 175432, 30299, -3773, 500, 0),
('Clan Hall --> West Path to The Cementery', 12014, 166502, 20284, -3328, 500, 0),
('Clan Hall --> Center of Giran Castle Town', 12015, 81749, 149171, -3464, 0, 0),
('Clan Hall --> North of Giran Castle Town', 12016, 81525, 143821, -3528, 0, 0),
('Clan Hall --> East of Giran Castle Town', 12017, 88342, 147329, -3400, 0, 0),
('Clan Hall --> South of Giran Castle Town', 12018, 81548, 152633, -3528, 0, 0),
('Clan Hall --> West of Giran Castle Town', 12019, 77305, 148636, -3592, 0, 0),
('Clan Hall --> Devils Isle', 12020, 43408, 206881, -3752, 500, 0),
('Clan Hall --> Center of Gludin Village', 12021, -82445, 150788, -3129, 0, 0),
('Clan Hall --> North of Gludin Village', 12022, -83331, 148563, -3148, 0, 0),
('Clan Hall --> East of Gludin Village', 12023, -78405, 152723, -3181, 0, 0),
('Clan Hall --> South of Gludin Village', 12024, -77460, 155995, -3194, 0, 0),
('Clan Hall --> West of Gludin Village', 12025, -85138, 152749, -3160, 0, 0),
('Clan Hall --> Necropolis of Sacrifice', 12026, -36961, 201895, -2760, 500, 0),
('Clan Hall --> Oracle Dusk', 12027, -93453, 89814, -3240, 500, 0),
('Clan Hall --> Oracle of Dawn', 12028, -85329, 106369, -3603, 500, 0),
('Clan Hall --> South Pathway to the Wasterland', 12029, -17279, 208954, -3664, 500, 0),
('Clan Hall --> Wasterland', 12030, -16019, 193365, -4488, 500, 0),
('Clan Hall --> North of Dion Castle Town', 12041, 21511, 145866, -3153, 0, 0),
('Clan Hall --> Center of Dion Castle Town', 12040, 19025, 145245, -3107, 0, 0),
('Clan Hall --> Center of Gludio Castle Town', 12033, -14393, 123671, -3144, 0, 0),
('Clan Hall --> North of Gludio Castle Town', 12035, -11817, 123652, -3079, 0, 0),
('Clan Hall --> East of Gludio Castle Town', 12034, -16796, 124108, -3127, 0, 0),
('Clan Hall --> West of Gludio Castle Town', 13037, -14591, 121024, -2990, 0, 0),
('Clan Hall --> Ruins of Despair', 12038, -20767, 136437, -3923, 500, 0),
('Clan Hall --> The Ruins Bend', 12039, -32664, 148626, -3956, 500, 0),
('Clan Hall --> East of Dion Castle Town', 12042, 18891, 142365, -3051, 0, 0),
('Clan Hall --> South of Dion Castle Town', 12043, 17394, 147593, -3129, 0, 0),
('Clan Hall --> West of Dion Castle Town', 12044, 16582, 144130, -2960, 0, 0),
('Clan Hall --> Plains of Dion', 12031, 9980, 173167, -3734, 500, 0),
('Clan Hall --> Piligrims Necropolis', 12032, 46428, 127157, -3745, 500, 0),
('Clan Hall --> Giran Territory', 12045, 69373, 155208, -3746, 500, 0),
('Clan Hall --> Center of Goddard Castle Town', 12046, 147728, -56331, -2776, 0, 0),
('Clan Hall --> North of Goddard Castle Town', 12047, 147731, -58930, -2976, 0, 0),
('Clan Hall --> East of Goddard Castle Town', 12048, 150561, -57489, -2976, 0, 0),
('Clan Hall --> West of Goddard Castle Town', 12049, 144866, -57464, -2976, 0, 0);

INSERT INTO teleport VALUES 
('Pagan Temple - > exit', 11999, -16307, -36591, -10725, 0, 0),
('Pagan Chapel - > exit', 11998, -16359, -43803, -10725, 0, 0);

INSERT INTO teleport VALUES
('Lair of Sailren -> Primeval Isle Wharf', 20004, 10468, -24569, -3650, 0, 0);

-- L2J Free Addon

-- Update Boss Manager
Update npc Set `type` = "L2Teleporter" Where idTemplate = 31759;
Update npc set `type` = 'L2Teleporter' Where idTemplate = 31859;
Delete From teleport where id in (20000,20001,20002);
INSERT INTO teleport VALUES
	("Lair of Antharas -> Town of Giran", 20000, 83400, 147943, -3404, 0, 0),
	("Lair of Baium -> Town of Aden", 20001, 146331, 25762, -2018, 0, 0),
	("Lair of Valakas -> Town of Goddard", 20002, 147928, -55273, -2734, 0, 0);