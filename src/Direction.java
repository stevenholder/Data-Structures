
/**
 * Enumeration class Direction - write a description of the enum class here
 * 
 * @author (Rodrigo A. Obando)
 * @version (1.0)
 */
public enum Direction
{
    north, south, east, west, up, down;
    
    public Direction getOpposite()
    {
        switch(this)
        {
            case north:
                return south;
            case south:
                return north;
            case east:
                return west;
            case west:
                return east;
            case up:
                return down;
            case down:
                return up;
            default:
                return this;
        }
    }
}
