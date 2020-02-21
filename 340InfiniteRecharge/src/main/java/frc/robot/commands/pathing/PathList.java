package frc.robot.commands.pathing;

import frc.robot.commands.pathing.PathSegment.Vec2;

/**
 * All of our paths. We have a lot of them.<br>
 * Part of me wants to convert this double-nested class crap into an enum thing,
 * but it's not worth the effort
 */

// TODO: These are last years paths for reference, pathing still needs to be
// done!

public class PathList {
	public static final Path STRAIGHT_ON = new Path(x -> .2, new PathSegment(x -> 0.0, 108));

	public static final class TEST_PATHING {

		public static final Path BACK_108_INCHES = new Path(x -> .7, new PathSegment( 
			/* {"start":{"x":150,"y":200},"mid1":{"x":200,"y":200},"mid2":{"x":219,"y":200},"end":{"x":258,"y":200}} */
			new Vec2(150, 200), new Vec2(200, 200), new Vec2(219, 200), new Vec2(258, 200) 
			, 108));

		public static final Path U_SHAPE = new Path(x -> .2, new PathSegment(
				/*
				 * {"start":{"x":145,"y":168},"mid1":{"x":218,"y":112},"mid2":{"x":231,"y":220},
				 * "end":{"x":144,"y":193}}
				 */
				new Vec2(145, 168), new Vec2(218, 112), new Vec2(231, 220), new Vec2(144, 193), 150));

		public static final Path SHORT_CURVE = new Path(x -> .4, new PathSegment(
				/*
				 * {"start":{"x":145,"y":168},"mid1":{"x":157,"y":188},"mid2":{"x":171,"y":189},
				 * "end":{"x":187,"y":186}}
				 */
				new Vec2(145, 168), new Vec2(157, 188), new Vec2(171, 189), new Vec2(187, 186), 50));

		public static final Path S_CURVE = new Path(x -> .4, new PathSegment(
				/*
				 * {"start":{"x":145,"y":168},"mid1":{"x":172,"y":165},"mid2":{"x":171,"y":189},
				 * "end":{"x":220,"y":186}}
				 */
				new Vec2(145, 168), new Vec2(172, 165), new Vec2(171, 189), new Vec2(220, 186), 79));
		public static final Path S_CURVE_REVERSE = new Path(x -> -.4, new PathSegment(
				/*
				 * {"start":{"x":220,"y":186},"mid1":{"x":171,"y":189},"mid2":{"x":172,"y":165},
				 * "end":{"x":145,"y":168}}
				 */
				new Vec2(220, 186), new Vec2(171, 189), new Vec2(172, 165), new Vec2(145, 168), 79));

	}

	public static final class EASY_SHOOT {
		public static final Path THIRTY_SIX_INCH = new Path(x -> .7, new PathSegment( 
			/* {"start":{"x":148,"y":246},"mid1":{"x":178,"y":246},"mid2":{"x":178,"y":246},"end":{"x":184,"y":246}} */
			new Vec2(148, 246), new Vec2(178, 246), new Vec2(178, 246), new Vec2(184, 246) 
			, 37));
	}

	public static final class TRENCH_FIVE_BALL {
		public static final Path STEP_ONE = new Path(x -> .7, new PathSegment( 
			/* {"start":{"x":150,"y":43},"mid1":{"x":203,"y":43},"mid2":{"x":203,"y":43},"end":{"x":278,"y":43}} */
			new Vec2(150, 43), new Vec2(203, 43), new Vec2(203, 43), new Vec2(278, 43) 
			, 129));
		public static final Path STEP_TWO = new Path(x -> .7, new PathSegment( 
			/* {"start":{"x":278,"y":43},"mid1":{"x":250,"y":59},"mid2":{"x":250,"y":59},"end":{"x":218,"y":79}} */
			new Vec2(278, 43), new Vec2(250, 59), new Vec2(250, 59), new Vec2(218, 79) 
			, 70));
	}

	public static final class COLOR_WHEEL_STEAL {
		public static final Path STAGE_ONE = new Path(x -> .7, new PathSegment( 
			/* {"start":{"x":150,"y":200},"mid1":{"x":200,"y":202},"mid2":{"x":203,"y":228},"end":{"x":258,"y":240}} */
			new Vec2(150, 200), new Vec2(200, 202), new Vec2(203, 228), new Vec2(264, 240) 
			, 117));
		public static final Path STAGE_TWO = new Path(x -> -.7, new PathSegment( 
			/* {"start":{"x":278,"y":238},"mid1":{"x":221,"y":196},"mid2":{"x":201,"y":229},"end":{"x":150,"y":200}} */
			new Vec2(278, 238), new Vec2(221, 196), new Vec2(201, 229), new Vec2(150, 200) 
			, 136));
		public static final Path STAGE_THREE = new Path(x -> .7, new PathSegment( 
			/* {"start":{"x":150,"y":200},"mid1":{"x":117,"y":179},"mid2":{"x":119,"y":115},"end":{"x":150,"y":150}} */
			new Vec2(150, 200), new Vec2(129, 195), new Vec2(128, 150), new Vec2(150, 150) 
			, 117));
	}
//##########################################################################################################//
//##########################################################################################################//
//####                     KEEP TRACK OF YOUR STUFF                                                    #####//
//##########################################################################################################//
//##########################################################################################################//
	// Made path start sides based on looking from our driver station, not other
	// team's
	public static final class ENEMY_TRENCH_RUN {
		// 96in from left wall, in from back wall
		public static final Path SHORT_ONE = new Path(x -> .7, new PathSegment( 
			/* {"start":{"x":143,"y":259},"mid1":{"x":223,"y":263},"mid2":{"x":205,"y":293},"end":{"x":250,"y":289}} */
			new Vec2(143, 259), new Vec2(223, 263), new Vec2(205, 293), new Vec2(250, 289) 
			, 114));
		public static final Path SHORT_TWO = new Path(x -> -.7,new PathSegment( 
			/* {"start":{"x":272,"y":314},"mid1":{"x":205,"y":293},"mid2":{"x":272,"y":145},"end":{"x":188,"y":141}} */
			new Vec2(272, 314), new Vec2(205, 293), new Vec2(272, 145), new Vec2(188, 141) 
			, 212));

	}

	public static final class ENEMY_TRENCH_RUN_SECOND {
		// 95in from left wall, 115in from back wall
		public static final Path LONG_ONE = new Path(x -> .4, new PathSegment(
				/*
				 * {"start":{"x":145,"y":245},"mid1":{"x":237,"y":250},"mid2":{"x":269,"y":272},
				 * "end":{"x":277,"y":318}}
				 */
				new Vec2(145, 245), new Vec2(237, 250), new Vec2(269, 272), new Vec2(277, 318), 166));
		public static final Path LONG_TWO = new Path(x -> -.4, new PathSegment(
				/*
				 * {"start":{"x":277,"y":318},"mid1":{"x":269,"y":272},"mid2":{"x":221,"y":110},
				 * "end":{"x":145,"y":110}}
				 */
				new Vec2(277, 318), new Vec2(269, 272), new Vec2(221, 110), new Vec2(145, 110), 261));
		public static final Path LONG_THREE = new Path(x -> .4, new PathSegment(
				/*
				 * {"start":{"x":145,"y":110},"mid1":{"x":221,"y":110},"mid2":{"x":150,"y":38},
				 * "end":{"x":339,"y":44}}
				 */
				new Vec2(145, 110), new Vec2(221, 110), new Vec2(150, 38), new Vec2(339, 44), 216));
	}

	public static final class TRENCH_RUN {
		// 31in from right wall, 115in from back wall
		public static final Path TWO_BALL = new Path(x -> .6, new PathSegment( 
			/* {"start":{"x":147,"y":49},"mid1":{"x":258,"y":48},"mid2":{"x":192,"y":47},"end":{"x":273,"y":46}} */
			new Vec2(147, 49), new Vec2(258, 48), new Vec2(192, 47), new Vec2(273, 46) 
			, 127));

		public static final Path THREE_BALL = new Path(x -> .6, new PathSegment( 
			/* {"start":{"x":149,"y":79},"mid1":{"x":254,"y":34},"mid2":{"x":281,"y":50},"end":{"x":339,"y":47}} */
			new Vec2(149, 79), new Vec2(254, 34), new Vec2(281, 50), new Vec2(339, 47) 
			, 195));

		public static final Path BACKWARDS_TWO_BALL = new Path(x -> -.6, new PathSegment( 
			/* {"start":{"x":304,"y":45},"mid1":{"x":267,"y":58},"mid2":{"x":306,"y":45},"end":{"x":243,"y":67}} */
			new Vec2(122, 18), new Vec2(107, 23), new Vec2(122, 18), new Vec2(97, 27) 
			, 26));

		public static final Path TWO_BALL_STEAL = new Path(x->.6,new PathSegment( 
			/* {"start":{"x":301,"y":36},"mid1":{"x":357,"y":16},"mid2":{"x":338,"y":66},"end":{"x":402,"y":47}} */
			new Vec2(301, 36), new Vec2(357, 16), new Vec2(338, 66), new Vec2(402, 47) 
			, 108));

		public static final Path TEST_TRENCH = new Path( x -> .6, new PathSegment( 
			/* {"start":{"x":73.5,"y":24.5},"mid1":{"x":258,"y":24},"mid2":{"x":96,"y":23.5},"end":{"x":136.5,"y":23}} */
			new Vec2(74, 25), new Vec2(258, 24), new Vec2(96, 24), new Vec2(137, 23) 
			, 132));

		public static final Path TEST_TRENCH_PATH_TWO = new Path (x -> .6, new PathSegment( 
			/* {"start":{"x":151.5,"y":47.5},"mid1":{"x":212,"y":47},"mid2":{"x":226,"y":44.5},"end":{"x":302.5,"y":44}} */
			new Vec2(60, 18), new Vec2(85, 18), new Vec2(90, 17), new Vec2(120, 17) 
			, 60));

		public static final Path TEST_TRENCH_PATH_THREE = new Path (x -> .6, new PathSegment( 
			/* {"start":{"x":148,"y":45},"mid1":{"x":210,"y":45},"mid2":{"x":210,"y":45},"end":{"x":316,"y":45}} */
			new Vec2(148, 45), new Vec2(210, 45), new Vec2(210, 45), new Vec2(300, 45) 
			, 152));

		public static final Path BACKWARDS_PATH_THREE = new Path (x -> .6, new PathSegment( 
			/* {"start":{"x":339,"y":46},"mid1":{"x":306,"y":53},"mid2":{"x":277,"y":60},"end":{"x":243,"y":68}} */
			new Vec2(136, 18), new Vec2(122, 18), new Vec2(111, 18), new Vec2(97, 18) 
			, 40));

	}



	public static final class INIT_SHOT {
		public static final Path LEFT_TURN = new Path(x -> .1, new PathSegment(
				/*
				 * {"start":{"x":145,"y":168},"mid1":{"x":181,"y":196},"mid2":{"x":195,"y":191},
				 * "end":{"x":215,"y":170}}
				 */
				new Vec2(145, 168), new Vec2(181, 196), new Vec2(195, 191), new Vec2(215, 170), 81));

	}



}

// 2019 paths, just for reference on how to set up, and write paths
// /** The cargo front-side */
// public static final Path STRAIGHT_ON = new Path(x -> .4, ne= PathSegment(x ->
// 0.0, 100));

// public static final class LEFT_ROCKET {

// public static final Path CLOSE_HATCH = new Path(x -> .4, new PathSegment(
// /*
// {"start":{"x":68,"y":116},"mid1":{"x":161,"y":116},"mid2":{"x":124,"y":82},"end":{"x":157,"y":64}}
// */
// new Vec2(68, 116), new Vec2(161, 116), new Vec2(124, 82), new Vec2(157, 64)
// , 114));

// public static final Path FAR_HATCH = new Path(x -> x < .8 ? x < .125 ? .35 :
// .55 : .2, new PathSegment(
// /*
// {"start":{"x":69,"y":117},"mid1":{"x":125,"y":117},"mid2":{"x":341,"y":96},"end":{"x":309,"y":64}}
// */
// new Vec2(69, 117), new Vec2(125, 117), new Vec2(341, 96), new Vec2(309, 64)
// , 260));

// public static final Path HECK_PATH = new Path(x -> .4, new PathSegment(
// /*
// {"start":{"x":37p,"y":246},"mid1":{"x":149,"y":243},"mid2":{"x":127,"y":229},"end":{"x":129,"y":186}}
// */
// new Vec2(37, 246), new Vec2(149, 243), new Vec2(127, 229), new Vec2(129, 186)
// , 137));
// }

// public static final class RIGHT_ROCKET {

// public static final Path CLOSE_HATCH = new Path(x -> .4, new PathSegment(
// /*
// {"start":{"x":68,"y":116},"mid1":{"x":161,"y":116},"mid2":{"x":124,"y":150},"end":{"x":157,"y":168}}
// */
// new Vec2(68, 116), new Vec2(161, 116), new Vec2(124, 150), new Vec2(157, 168)
// , 114));

// public static final Path FAR_HATCH = new Path(x -> x < .8 ? x < .125 ? .35 :
// .55 : .2, new PathSegment(
// /*
// {"start":{"x":69,"y":117},"mid1":{"x":125,"y":117},"mid2":{"x":341,"y":138},"end":{"x":309,"y":170}}
// */
// new Vec2(69, 117), new Vec2(125, 117), new Vec2(341, 138), new Vec2(309, 170)
// , 260));
// }

// public static final class LEFT_CARGO {

// public static final Path FIRST_SLOT = new Path(x -> x < .75 ? .55 : .2, new
// PathSegment(
// /*
// {"start":{"x":68,"y":207},"mid1":{"x":206,"y":201},"mid2":{"x":275,"y":117},"end":{"x":273,"y":160}}
// */
// new Vec2(68, 207), new Vec2(206, 201), new Vec2(275, 117), new Vec2(273, 160)
// , 225));
// }

// public static final class RIGHT_CARGO {

// public static final Path FIRST_SLOT = new Path(x -> x < .75 ? .55 : .2, new
// PathSegment(
// /*
// {"start":{"x":68,"y":207},"mid1":{"x":206,"y":213},"mid2":{"x":275,"y":297},"end":{"x":273,"y":254}}
// */
// new Vec2(68, 207), new Vec2(206, 213), new Vec2(275, 297), new Vec2(273, 254)
// , 226));
// }
