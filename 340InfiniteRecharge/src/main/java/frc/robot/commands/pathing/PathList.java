package frc.robot.commands.pathing;




import frc.robot.commands.pathing.PathSegment.Vec2;

/**
 * All of our paths. We have a lot of them.<br>
 * Part of me wants to convert this double-nested class
 * crap into an enum thing, but it's not worth the effort
 */

//TODO: These are last years paths for reference, pathing still needs to be done!


public class PathList {
	public static final Path STRAIGHT_ON = new Path(x -> .4, new PathSegment(x -> 0.0, 50));
	//Made path start sides based on looking from our driver station, not other team's
	public static final class ENEMY_TRENCH_RUN {
		//63in from left wall, 105in from back wall
		public static final Path SHORT_ONE = new Path(x->.4, new PathSegment( 
			/* {"start":{"x":136,"y":277},"mid1":{"x":227,"y":259},"mid2":{"x":276,"y":283},"end":{"x":276,"y":318}} */
			new Vec2(136, 277), new Vec2(227, 259), new Vec2(276, 283), new Vec2(276, 318) 
			, 164));
		public static final Path SHORT_TWO = new Path(x->-.4,new PathSegment( 
			/* {"start":{"x":276,"y":318},"mid1":{"x":276,"y":283},"mid2":{"x":217,"y":265},"end":{"x":148,"y":210}} */
			new Vec2(276, 318), new Vec2(276, 283), new Vec2(217, 265), new Vec2(148, 210) 
			, 172));

			//95in from left wall, 115in from back wall
			public static final Path LONG_ONE = new Path(x->.4, new PathSegment( 
				/* {"start":{"x":145,"y":245},"mid1":{"x":237,"y":250},"mid2":{"x":269,"y":272},"end":{"x":277,"y":318}} */
				new Vec2(145, 245), new Vec2(237, 250), new Vec2(269, 272), new Vec2(277, 318) 
				, 166));
			public static final Path LONG_TWO = new Path(x->-.4, new PathSegment( 
				/* {"start":{"x":277,"y":318},"mid1":{"x":269,"y":272},"mid2":{"x":221,"y":110},"end":{"x":145,"y":110}} */
				new Vec2(277, 318), new Vec2(269, 272), new Vec2(221, 110), new Vec2(145, 110) 
				, 261));
			public static final Path LONG_THREE = new Path(x->.4, new PathSegment( 
				/* {"start":{"x":145,"y":110},"mid1":{"x":221,"y":110},"mid2":{"x":150,"y":38},"end":{"x":339,"y":44}} */
				new Vec2(145, 110), new Vec2(221, 110), new Vec2(150, 38), new Vec2(339, 44) 
				, 216));
	}

	public static final class TRENCH_RUN{
		//31in from right wall, 115in from back wall
		public static final Path TWO_BALL = new Path(x->.4,new PathSegment( 
			/* {"start":{"x":146,"y":48},"mid1":{"x":217,"y":48},"mid2":{"x":217,"y":48},"end":{"x":298,"y":48}} */
			new Vec2(146, 48), new Vec2(217, 48), new Vec2(217, 48), new Vec2(298, 48) 
			, 152));

	}

	public static final class INIT_SHOT{
			public static final Path LEFT_TURN = new Path(x -> .4, new PathSegment( 
				/* {"start":{"x":145,"y":168},"mid1":{"x":181,"y":196},"mid2":{"x":195,"y":191},"end":{"x":215,"y":170}} */
				new Vec2(145, 168), new Vec2(181, 196), new Vec2(195, 191), new Vec2(215, 170) 
				, 81));

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
