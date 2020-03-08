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
	public static final Path STRAIGHT_ON_20INCHES = new Path(x -> -.2, new PathSegment(x -> 0.0, 20));

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
	public static final class HUNGRY_HIPPO_SHOT {
		public static final Path SCOOT_BACK = new Path(x -> -.7, new PathSegment( 
			/* {"start":{"x":0,"y":0},"mid1":{"x":7,"y":0},"mid2":{"x":7,"y":0},"end":{"x":15,"y":0}} */
			new Vec2(0, 0), new Vec2(7, 0), new Vec2(7, 0), new Vec2(15, 0) 
			, 15));
	}

	public static final class EASY_SHOOT {
		public static final Path THIRTY_SIX_INCH = new Path(x -> .7, new PathSegment( 
			/* {"start":{"x":148,"y":246},"mid1":{"x":178,"y":246},"mid2":{"x":178,"y":246},"end":{"x":184,"y":246}} */
			new Vec2(148, 246), new Vec2(178, 246), new Vec2(178, 246), new Vec2(184, 246) 
			, 37));
	}

	public static final class TRENCH_SIX_BALL {
		public static final Path GRAB_THREE = new Path(x -> .7, new PathSegment( 
			/* {"start":{"x":150,"y":43},"mid1":{"x":203,"y":43},"mid2":{"x":203,"y":43},"end":{"x":278,"y":43}} */
			new Vec2(150, 43), new Vec2(203, 43), new Vec2(203, 43), new Vec2(250, 43) 
			, 178));

		public static final Path POSITION_SHOOT_THREE = new Path(x -> -.7, new PathSegment( 
			/* {"start":{"x":250,"y":43},"mid1":{"x":203,"y":43},"mid2":{"x":203,"y":43},"end":{"x":100,"y":43}} */
			new Vec2(250, 43), new Vec2(203, 43), new Vec2(203, 43), new Vec2(100, 43) 
			, 150));
	}

	public static final class TRENCH_FIVE_BALL {
		public static final Path STEP_ONE = new Path(x -> x<.5 ? .7:.5, new PathSegment( 
			/* {"start":{"x":150,"y":43},"mid1":{"x":203,"y":43},"mid2":{"x":203,"y":43},"end":{"x":278,"y":43}} */
			new Vec2(150, 43), new Vec2(203, 43), new Vec2(203, 43), new Vec2(214, 43) 
			, 129));
		public static final Path STEP_TWO = new Path(x -> -.7, new PathSegment( 
			/* {"start":{"x":278,"y":43},"mid1":{"x":253,"y":43},"mid2":{"x":253,"y":43},"end":{"x":241,"y":43}} */
			new Vec2(278, 43), new Vec2(200, 43), new Vec2(200, 43), new Vec2(190, 43) 
			, 88));
	}

	public static final class FULL_TRENCH_RUN {
		public static final Path STEP_ONE = new Path(x -> x<.8 ? .85 : .4, new PathSegment( 
			/* {"start":{"x":150,"y":43},"mid1":{"x":203,"y":43},"mid2":{"x":203,"y":43},"end":{"x":278,"y":43}} */
			new Vec2(150, 43), new Vec2(203, 43), new Vec2(203, 43), new Vec2(290, 43) 
			, 140));
		public static final Path STEP_TWO = new Path(x -> -1.0, new PathSegment( 
			/* {"start":{"x":278,"y":43},"mid1":{"x":253,"y":42},"mid2":{"x":253,"y":42},"end":{"x":241,"y":44}} */
			new Vec2(290, 43), new Vec2(253, 42), new Vec2(253, 42), new Vec2(218, 44) 
			, 72));
		public static final Path ZOOM = new Path(x -> x <.8 ? .85 : x<.85 ? .45 :.3, new PathSegment( 
			/* {"start":{"x":240,"y":44},"mid1":{"x":252,"y":44},"mid2":{"x":252,"y":44},"end":{"x":400,"y":44}} */
			new Vec2(240, 44), new Vec2(252, 44), new Vec2(252, 44), new Vec2(436, 44) 
			, 196));
		public static final Path ZOOM_BACK_UNDERWHEEL = new Path(x-> -.8, new PathSegment( 
			/* {"start":{"x":400,"y":43},"mid1":{"x":252,"y":43},"mid2":{"x":252,"y":43},"end":{"x":240,"y":43}} */
			new Vec2(150, 100), new Vec2(112, 100), new Vec2(112,100), new Vec2(100, 100) 
			, 50));

		public static final Path ZOOM_BACK_PASTWHEEL = new Path(x -> -1.0, new PathSegment( 
			/* {"start":{"x":350,"y":43},"mid1":{"x":252,"y":43},"mid2":{"x":252,"y":43},"end":{"x":240,"y":43}} */
			new Vec2(350, 44), new Vec2(252, 45), new Vec2(252, 45), new Vec2(230, 47) 
			, 110));
	}

	public static final class THE_EIGHTH_HOKAGE {
		public static final Path STAGE_ONE = new Path(x -> x<.7 ? .7 : x<.85 ? .35 : .2, new PathSegment( 
			/* {"start":{"x":150,"y":200},"mid1":{"x":200,"y":202},"mid2":{"x":203,"y":228},"end":{"x:264,""y":240}} */
			new Vec2(150, 200), new Vec2(200, 202), new Vec2(203, 228), new Vec2(264, 240) 
			, 117));
		public static final Path STAGE_TWO = new Path(x -> -.7, new PathSegment( 
			/* {"start":{"x":278,"y":238},"mid1":{"x":185,"y":219},"mid2":{"x":249,"y":128},"end":{"x":170,"y":120}} */
			new Vec2(278, 238), new Vec2(185, 219), new Vec2(249, 128), new Vec2(170, 120) 
			, 175));
		public static final Path STAGE_THREE = new Path(x -> .4, new PathSegment( 
			/* {"start":{"x":184,"y":176},"mid1":{"x":210,"y":175},"mid2":{"x":210,"y":175},"end":{"x":233,"y":182}} */
			new Vec2(184, 176), new Vec2(210, 175), new Vec2(210, 175), new Vec2(233, 182) 
			, 50));
		public static final Path STAGE_FOUR = new Path(x -> -.7, new PathSegment( 
			/* {"start":{"x":233,"y":170},"mid1":{"x":210,"y":175},"mid2":{"x":210,"y":175},"end":{"x":184,"y":176}} */
			new Vec2(233, 170), new Vec2(210, 175), new Vec2(210, 175), new Vec2(184, 176) 
			, 50));
	}

	public static final class COLOR_WHEEL_STEAL {
		public static final Path STAGE_ONE = new Path(x -> x<.7 ? .7 : x<.85 ? .35 : .2, new PathSegment( 
			/* {"start":{"x":150,"y":200},"mid1":{"x":200,"y":202},"mid2":{"x":203,"y":228},"end":{"x":258,"y":240}} */

			new Vec2(150, 200), new Vec2(200, 202), new Vec2(203, 228), new Vec2(264, 240) 
			, 117));
		public static final Path STAGE_TWO = new Path(x -> -.7, new PathSegment( 
			/* {"start":{"x":278,"y":238},"mid1":{"x":192,"y":221},"mid2":{"x":261,"y":175},"end":{"x":185,"y":150}} */
			new Vec2(278, 238), new Vec2(192, 221), new Vec2(261, 175), new Vec2(185, 150) 
			, 139));

	}
	public static final class WALL_SHOT {
		public static final Path SCOOTCH_BACK = new Path(x -> .7, new PathSegment( 
			/* {"start":{"x":150,"y":200},"mid1":{"x":200,"y":202},"mid2":{"x":203,"y":228},"end":{"x":258,"y":240}} */
			new Vec2(0, 0), new Vec2(6, 0), new Vec2(6, 0), new Vec2(12, 0) 
			, 12));
	}
	
	public static final class TWO_BALL_CORNER_SHOT {
		public static final Path SCOOT = new Path(x -> .6, new PathSegment( 
			/* {"start":{"x":0,"y":0},"mid1":{"x":6,"y":0},"mid2":{"x":6,"y":0},"end":{"x":36,"y":0}} */
			new Vec2(0, 0), new Vec2(6, 0), new Vec2(6, 0), new Vec2(36, 0) 
			, 36));
		public static final Path REVERSE_SCOOT = new Path(x -> -.7, new PathSegment( 
			/* {"start":{"x":0,"y":0},"mid1":{"x":6,"y":0},"mid2":{"x":6,"y":0},"end":{"x":36,"y":0}} */
			new Vec2(0, 0), new Vec2(6, 0), new Vec2(6, 0), new Vec2(36, 0) 
			, 36));
	}

//##########################################################################################################//
//##########################################################################################################//
//####                     KEEP TRACK OF YOUR STUFF                                                    #####//
//##########################################################################################################//
//##########################################################################################################//

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
