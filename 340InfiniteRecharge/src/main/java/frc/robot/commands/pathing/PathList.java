package frc.robot.commands.pathing;


import frc.robot.commands.pathing.PathSegment.Vec2;

/**
 * All of our paths. We have a lot of them.<br>
 * Part of me wants to convert this double-nested class
 * crap into an enum thing, but it's not worth the effort
 */

//TODO: These are last years paths for reference, pathing still needs to be done!


public class PathList {
	//Made path start sides based on looking from our driver station, not other team's
	public static final class TRENCH_RUN {
		//Needs to be tested to check if reversing speed actually worked
		public static final Path RIGHT_LINE_ONE = new Path(x -> -.2, new PathSegment( 
			/* {"start":{"x":148,"y":61},"mid1":{"x":241,"y":41},"mid2":{"x":233,"y":48},"end":{"x":337,"y":45}} */
			new Vec2(148, 61), new Vec2(241, 41), new Vec2(233, 48), new Vec2(337, 45) 
			, 191));

		public static final Path INTIAL_LINE_SHOT = new Path(x -> .2, new PathSegment( 
			/* {"start":{"x":337,"y":45},"mid1":{"x":233,"y":45},"mid2":{"x":241,"y":45},"end":{"x":150,"y":75}} */
			new Vec2(337, 45), new Vec2(233, 45), new Vec2(241, 45), new Vec2(150, 75) 
			, 192));

	}



}



	//2019 paths, just for reference on how to set up, and write paths
	// /** The cargo front-side */
	// public static final Path STRAIGHT_ON = new Path(x -> .4, new PathSegment(x -> 0.0, 100));

	// public static final class LEFT_ROCKET {

	// 	public static final Path CLOSE_HATCH = new Path(x -> .4, new PathSegment( 
	// 		/* {"start":{"x":68,"y":116},"mid1":{"x":161,"y":116},"mid2":{"x":124,"y":82},"end":{"x":157,"y":64}} */
	// 		new Vec2(68, 116), new Vec2(161, 116), new Vec2(124, 82), new Vec2(157, 64) 
	// 		, 114));

	// 	public static final Path FAR_HATCH = new Path(x -> x < .8 ? x < .125 ? .35 : .55 : .2, new PathSegment( 
	// 		/* {"start":{"x":69,"y":117},"mid1":{"x":125,"y":117},"mid2":{"x":341,"y":96},"end":{"x":309,"y":64}} */
	// 		new Vec2(69, 117), new Vec2(125, 117), new Vec2(341, 96), new Vec2(309, 64) 
	// 		, 260));

	// 	public static final Path HECK_PATH = new Path(x -> .4, new PathSegment( 
	// 		/* {"start":{"x":37p,"y":246},"mid1":{"x":149,"y":243},"mid2":{"x":127,"y":229},"end":{"x":129,"y":186}} */
	// 		new Vec2(37, 246), new Vec2(149, 243), new Vec2(127, 229), new Vec2(129, 186) 
	// 		, 137));
	// }

	// public static final class RIGHT_ROCKET {
		
	// 	public static final Path CLOSE_HATCH = new Path(x -> .4, new PathSegment( 
	// 		/* {"start":{"x":68,"y":116},"mid1":{"x":161,"y":116},"mid2":{"x":124,"y":150},"end":{"x":157,"y":168}} */
	// 		new Vec2(68, 116), new Vec2(161, 116), new Vec2(124, 150), new Vec2(157, 168) 
	// 		, 114));
		
	// 	public static final Path FAR_HATCH = new Path(x -> x < .8 ? x < .125 ? .35 : .55 : .2, new PathSegment( 
	// 		/* {"start":{"x":69,"y":117},"mid1":{"x":125,"y":117},"mid2":{"x":341,"y":138},"end":{"x":309,"y":170}} */
	// 		new Vec2(69, 117), new Vec2(125, 117), new Vec2(341, 138), new Vec2(309, 170) 
	// 		, 260));
	// }

	// public static final class LEFT_CARGO {

	// 	public static final Path FIRST_SLOT = new Path(x -> x < .75 ? .55 : .2, new PathSegment( 
	// 		/* {"start":{"x":68,"y":207},"mid1":{"x":206,"y":201},"mid2":{"x":275,"y":117},"end":{"x":273,"y":160}} */
	// 		new Vec2(68, 207), new Vec2(206, 201), new Vec2(275, 117), new Vec2(273, 160) 
	// 		, 225));
	// }

	// public static final class RIGHT_CARGO {

	// 	public static final Path FIRST_SLOT = new Path(x -> x < .75 ? .55 : .2, new PathSegment( 
	// 		/* {"start":{"x":68,"y":207},"mid1":{"x":206,"y":213},"mid2":{"x":275,"y":297},"end":{"x":273,"y":254}} */
	// 		new Vec2(68, 207), new Vec2(206, 213), new Vec2(275, 297), new Vec2(273, 254) 
	// 		, 226));
	// }
