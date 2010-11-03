import java.util.ArrayList;
import java.util.Iterator;


/**
 * Write a description of class OurMaze here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class OurMaze
{
	private OurRoom entrance, exit;

	/**
	 * Constructor for objects of class OurMaze
	 */
	public OurMaze()
	{
		this(1);
	}

	public OurMaze(int mazeNumber)
	{
		entrance = null;
		exit = null;
		switch(mazeNumber)
		{
		case 0:
			break;
		case 1:
			this.buildMaze1();
			break;
		case 2:
			this.buildMaze2();
			break;
		case 3:
			this.buildMaze3();
			break;                
		default:
		}
	}

	public OurRoom getEntrance()
	{
		return entrance;
	}

	public OurRoom getExit()
	{
		return exit;
	}

	public Iterator<OurRoom> findPathIteratively() {
		entrance.solveIteratively(entrance, exit);
		ArrayList<OurRoom> list = entrance.getIList();
		return list.iterator();
	}

	public Iterator<OurRoom> findPathRecursively() {
		entrance.solveRecursively(exit);
		ArrayList<OurRoom> list = entrance.getList();		
		return list.iterator();
	}

	private void buildMaze1()
	{
		OurRoom room1, room2;

		room1 = new OurRoom("Room 1");
		room2 = new OurRoom("Room 2");
		room1.connectTo(room2, Direction.north);

		entrance = room1;
		exit = room2;
	}

	private void buildMaze2()
	{
		OurRoom room1, room2, room3, room4, room5, room6, room7, room8, room9, room10;

		room1 = new OurRoom("Room 1");
		room2 = new OurRoom("Room 2");
		room3 = new OurRoom("Room 3");
		room4 = new OurRoom("Room 4");
		room5 = new OurRoom("Room 5");
		room6 = new OurRoom("Room 6");
		room7 = new OurRoom("Room 7");
		room8 = new OurRoom("Room 8");
		room9 = new OurRoom("Room 9");
		room10 = new OurRoom("Room 10");

		room1.connectTo(room2, Direction.up);
		room2.connectTo(room3, Direction.up);
		room3.connectTo(room4, Direction.up);
		room4.connectTo(room5, Direction.up);
		room5.connectTo(room6, Direction.up);
		room6.connectTo(room7, Direction.up);
		room7.connectTo(room8, Direction.up);
		room8.connectTo(room9, Direction.up);
		room9.connectTo(room10, Direction.up);

		entrance = room1;
		exit = room10;
	}

	private void buildMaze3() {
		OurRoom room1, room2, room3, room4, room5, room6, room7, room8, room9, room10, room11, room12, room13, room14, room15, room16, room17, room18, room19, room20, room21;

		room1 = new OurRoom("Room 1");
		room2 = new OurRoom("Room 2");
		room3 = new OurRoom("Room 3");
		room4 = new OurRoom("Room 4");
		room5 = new OurRoom("Room 5");
		room6 = new OurRoom("Room 6");
		room7 = new OurRoom("Room 7");
		room8 = new OurRoom("Room 8");
		room9 = new OurRoom("Room 9");
		room10 = new OurRoom("Room 10");
		room11 = new OurRoom("Room 11");
		room12 = new OurRoom("Room 12");
		room13 = new OurRoom("Room 13");
		room14 = new OurRoom("Room 14");
		room15 = new OurRoom("Room 15");
		room16 = new OurRoom("Room 16");
		room17 = new OurRoom("Room 17");
		room18 = new OurRoom("Room 18");
		room19 = new OurRoom("Room 19");
		room20 = new OurRoom("Room 20");
		room21 = new OurRoom("Room 21");

		//Floor 1
		room1.connectTo(room2, Direction.north);
		room1.connectTo(room3, Direction.east);
		room3.connectTo(room5, Direction.east);
		room3.connectTo(room4, Direction.south);
		room5.connectTo(room6, Direction.east);
		room5.connectTo(room8, Direction.up);

		//Floor 2
		room8.connectTo(room7, Direction.west);
		room8.connectTo(room9, Direction.north);
		room8.connectTo(room10, Direction.east);
		room10.connectTo(room11, Direction.east);
		room11.connectTo(room12, Direction.east);
		room11.connectTo(room16, Direction.up);
		room12.connectTo(room13, Direction.north);

		//Floor 3
		room16.connectTo(room14, Direction.west);
		room14.connectTo(room15, Direction.south);
		room16.connectTo(room17, Direction.east);
		room17.connectTo(room18, Direction.south);
		room18.connectTo(room19, Direction.east);
		room19.connectTo(room20, Direction.east);
		room20.connectTo(room21, Direction.north);

		entrance = room1;
		exit = room7;
	}
	
	public static void main(String[] args) {
		OurMaze maze = new OurMaze(3);
		//Iterator<OurRoom> itr = maze.findPathIteratively();
		Iterator<OurRoom> itr = maze.findPathRecursively();
		
		while(itr.hasNext())
			System.out.println(itr.next().getName());
	}
}