

public class WumpusPlayer 
{
	public static final int NORTH=0;
	public static final int EAST=1;
	public static final int SOUTH=1;
	public static final int WEST=3;
	
	int direction;
	int colPosition;
	int rowPosition; 
	boolean arrow;
	boolean gold;
	
	
	
	//accessors
	
	public int getDirection()
	{
		return direction;
	}
	
	public int getCol()
	{
		return colPosition;
	}
	
	public int getRow()
	{
		return rowPosition;
	}
	
	public boolean getArrow()
	{
		return arrow;
	}
	
	public boolean getGold()
	{
		return gold;
	}
	
	//mutators
	
	public void setDirection(int direction)
	{
		this.direction= direction;
	}
	
	public void setCol(int colPosition)
	{
		this.colPosition= colPosition;
	}
	
	public void setRow(int rowPosition)
	{
		this.rowPosition = rowPosition;
	}
	
	public void setArrow(boolean arrow)
	{
		this.arrow= arrow;
	}
	
	public void setGold(boolean gold)
	{
		this.gold= gold;
	}

}


