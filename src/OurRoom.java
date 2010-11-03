import java.util.ArrayList;

public class OurRoom
{
	private OurRoom exits[];
	private String name;
	private static ArrayList<OurRoom> list, ilist;

	public OurRoom()
	{
		this(null);
	}

	public OurRoom(String name)
	{
		this.name = name;
		this.list = new ArrayList<OurRoom>();
		this.ilist = new ArrayList<OurRoom>();
		exits = new OurRoom[Direction.values().length];
		for(OurRoom exit : exits)
		{
			exit = null;
		}
	}       


	public void connectTo(OurRoom theOtherRoom, Direction direction)
	{
		exits[direction.ordinal()] = theOtherRoom;
		theOtherRoom.exits[direction.getOpposite().ordinal()] = this;
	}

	public OurRoom getExit(Direction direction)
	{
		return exits[direction.ordinal()];
	}

	public boolean lookExit(Direction direction)
	{
		return exits[direction.ordinal()] != null;
	}

	public String getName() {
		return name;
	}

	public void solveIteratively(OurRoom entrance, OurRoom exit) {
		OurRoom temp = entrance, previous = null;
		while(temp != exit){
			if(!ilist.contains(temp))
				ilist.add(temp);
			
			if(temp.lookExit(Direction.up)) {
				if(!ilist.contains(temp.getExit(Direction.up))) {
					previous = temp;
					temp = temp.getExit(Direction.up);
					continue;
				} else {
					temp = previous;
				}
			}
			if(temp.lookExit(Direction.east)) {
				if(!ilist.contains(temp.getExit(Direction.east))) {
					previous = temp;
					temp = temp.getExit(Direction.east);
					continue;
				} else {
					temp = previous;
				}
			}
			if(temp.lookExit(Direction.south)) {
				if(!ilist.contains(temp.getExit(Direction.south))) {
					previous = temp;
					temp = temp.getExit(Direction.south);
					continue;
				} else {
					temp = previous;
				}
			}
			if(temp.lookExit(Direction.north)) {
				if(!ilist.contains(temp.getExit(Direction.north))) {
					previous = temp;
					temp = temp.getExit(Direction.north);
					continue;
				} else {
					temp = previous;
				}
			}			
			if(temp.lookExit(Direction.down)) {
				if(!ilist.contains(temp.getExit(Direction.down))) {
					previous = temp;
					temp = temp.getExit(Direction.down);
					continue;
				} else {
					temp = previous;
				}
			}
			if(temp.lookExit(Direction.west)) {
				if(!ilist.contains(temp.getExit(Direction.west))) {
					previous = temp;
					temp = temp.getExit(Direction.west);
					continue;
				} else {
					temp = previous;
				}
			}			
		}
		ilist.add(temp);
	}

	public void solveRecursively(OurRoom exit) {
		if(list.contains(this))
			return;

		list.add(this);

		if(this == exit) {
			return;
		}else {	
			if(lookExit(Direction.east)) {
				exits[Direction.east.ordinal()].solveRecursively(exit);	
				if(checkExit(exit))
					return;
			}	
			if(lookExit(Direction.up)) {
				exits[Direction.up.ordinal()].solveRecursively(exit);
				if(checkExit(exit))
					return;
			}
			if(lookExit(Direction.south)) {
				exits[Direction.south.ordinal()].solveRecursively(exit);
				if(checkExit(exit))
					return;
			}	
			if(lookExit(Direction.down)) {
				exits[Direction.down.ordinal()].solveRecursively(exit);
				if(checkExit(exit))
					return;
			}
			if(lookExit(Direction.west)) {
				exits[Direction.west.ordinal()].solveRecursively(exit);
				if(checkExit(exit))
					return;
			}	
			if(lookExit(Direction.north)) {
				exits[Direction.north.ordinal()].solveRecursively(exit);
				if(checkExit(exit))
					return;
			}

		}
	}

	private boolean checkExit(OurRoom exit) {
		return list.get(list.size()-1).equals(exit);
	}

	public ArrayList<OurRoom> getIList() {
		return ilist;
	}

	public ArrayList<OurRoom> getList() {
		return list;
	}

}