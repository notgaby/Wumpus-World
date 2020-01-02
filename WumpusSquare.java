public class WumpusSquare {
	
	boolean gold;
	boolean ladder;
	boolean pit;
	boolean breeze;
	boolean wumpus;
	boolean deadWumpus;
	boolean stench;
	boolean plswork;
	boolean visited;
	
	public WumpusSquare()
	{
		gold=false;
		ladder=false;
		pit= false;
		breeze= false;
		wumpus= false;
		deadWumpus= false;
		stench= false;
		visited= false;
	}
	
	//accessors
	
	public boolean getVisited() 
	{
		return visited;
	}
	
	public boolean getGold()
	{
		return gold;
	}
	
	public boolean getLadder()
	{
		return ladder;
	}
	
	public boolean getPit()
	{
		return pit;
	}
	
	public boolean getBreeze()
	{
		return breeze;
	}
	
	public boolean getWumpus()
	{
		return wumpus;
	}
	
	public boolean getDead()
	{
		return deadWumpus;
	}
	
	
	public boolean getStench()
	{
		return stench;
	}
	
	//mutators
	
	public void setVisited(boolean visited)
	{
		this.visited = visited;
	}
	
	public void setGold(boolean gold)
	{
		this.gold = gold;
	}
	
	public void setLadder(boolean ladder)
	{
		this.ladder = ladder;
	}
	
	public void setPit(boolean pit)
	{

		this.pit = pit;
	}
	
	public void setBreeze(boolean breeze)
	{
		
		this.breeze = breeze;
	}
	
	public void setWumpus(boolean wumpus)
	{
		
		this.wumpus = wumpus;
		
	}
	
	public void setDead(boolean deadWumpus)
	{
		
		this.deadWumpus = deadWumpus;
		
	}
	
	public void setStench(boolean stench)
	{
		
		this.stench = stench;
		
	}
	
	//toString
	
	public String toString()
	{
		//System.out.println("test");
		if(deadWumpus==true)
		{
			return "D";
		} else if(wumpus==true)
		{
			return "W";
		}else if(ladder==true)
		{
			return "L";
		}else if(pit==true)
		{
			return "P";
		}else if(gold==true)
		{
			return "G";
		}//else if(breeze==true)
			//{
			//return "B";
			//}
		else{
			return "*";
			}
			
		}
	


	
	}





