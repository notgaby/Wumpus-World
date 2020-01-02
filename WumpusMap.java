public class WumpusMap {
	
	public static final int NUM_ROWS=10;
	public static final int NUM_COLUMNS=10;
	public static final int NUM_PITS=10;
	
	public int ladderC;
	public int ladderR; 
	WumpusSquare[][] grid = new WumpusSquare[10][10];
	WumpusSquare test = new WumpusSquare();
	//WumpusPlayer bob = new WumpusPlayer();
	
	
	public WumpusMap()
	{
		
		createMap();
		
	}
	
	void createMap()
	{
		
		for(int y=0;y<10;y++)
		{
			for(int x=0;x<10;x++)
			{
				grid[x][y]= new WumpusSquare();
				
				//[x][y]; .setpitrue
		
		}
		}
		
		
		
		/////////////////PIT 
		//for loop bc need 10
		
		//System.out.println("pit");
		int counterpit = 0;
		//int breezecounter = 0;
		

		
		while(counterpit<10){
		
			//System.out.println("Run");
			int px=(int)(Math.random()*NUM_ROWS);
			int py=(int)(Math.random()*NUM_COLUMNS);
			
	
				
				//if(grid[px][py].getPit()==false)
				//{
				
				if(grid[px][py].getLadder()==false&&grid[px][py].getWumpus()==false&&grid[px][py].getGold()==false)//&&grid[px][py].getBreeze()==false)
				{
				grid[px][py].setPit(true);
				counterpit++;

				}
				
				for(int h=0;h<10;h++)
				{
					for(int i=0;i<10;i++)
					{
						
					if(grid[i][h].getPit()==false&&grid[i][h].getBreeze()==false)
					{
				
				
						if(px+1<10&&grid[px+1][py].getPit()==false)
						{
							//breezecounter++;
						 
							if(grid[px+1][py].getBreeze()==false)
							{
							grid[px+1][py].setBreeze(true);
							}
							
						}
						
						
						if(px-1>=0&&grid[px-1][py].getPit()==false)
						{
							//breezecounter++;
							if(grid[px-1][py].getBreeze()==false)
							{
							grid[px-1][py].setBreeze(true);
							}
						}
						
						if(py+1<10&&grid[px][py+1].getPit()==false)
						{
							//breezecounter++;
							if(grid[px][py+1].getBreeze()==false)
							{
							grid[px][py+1].setBreeze(true);
							}
						}
						
						if(py-1>=0&&grid[px][py-1].getPit()==false)
						{
							//breezecounter++;
							if(grid[px][py-1].getBreeze()==false)
							{
							grid[px][py-1].setBreeze(true);
							}
						}
						
					}
				}
					
				
				
				}
		
			
			
		}
		
		
		///////////////GOLD
		int gx=(int)(Math.random()*NUM_ROWS);
		int gy=(int)(Math.random()*NUM_COLUMNS);
		
		//System.out.println("Gold");
		
		while(grid[gx][gy].getPit()==true||grid[gx][gy].getLadder()==true)
		{
			gx=(int)(Math.random()*NUM_ROWS);
			gy=(int)(Math.random()*NUM_COLUMNS);
			//System.out.println(gx);
			
			///System.out.println("aa");
		}
		grid[gx][gy].setGold(true);
		
		
		/////////////LADDER
		//System.out.println("Ladder");
		int lx=(int)(Math.random()*NUM_ROWS);
		int ly=(int)(Math.random()*NUM_COLUMNS);
		
		while(grid[lx][ly].getGold()==true||grid[lx][ly].getPit()==true||grid[lx][ly].getWumpus()==true)//&&grid[lx][ly].getBreeze()==false)
		{
			lx=(int)(Math.random()*NUM_ROWS);
			ly=(int)(Math.random()*NUM_COLUMNS);
	
		}
		//System.out.print("ladder lx:"+lx);
			grid[lx][ly].setLadder(true);
			grid[ly][lx].setVisited(true);
			ladderC=ly;
			ladderR=lx;

		//////////////WUMPUS
		
		
		//System.out.println("Wumpus");
		int wx=(int)(Math.random()*NUM_ROWS);
		int wy=(int)(Math.random()*NUM_COLUMNS);
		
		while(grid[wx][wy].getPit()==true||grid[wx][wy].getLadder()==true)
		{
			System.out.println("wumpus");
			wx=(int)(Math.random()*NUM_ROWS);
			wy=(int)(Math.random()*NUM_COLUMNS);
			
			
		}
		

		grid[wx][wy].setWumpus(true);
		

		//System.out.println("wumpus wx: "+wx+" wumpus wy: "+wy);
		if(wx+1<10&&grid[wx+1][wy].getWumpus()==false&&grid[wx+1][wy].getStench()==false)
		{
			grid[wx+1][wy].setStench(true);
			
		}
		
		if(wx-1>=0&&grid[wx-1][wy].getWumpus()==false&&grid[wx-1][wy].getStench()==false)
		{
			grid[wx-1][wy].setStench(true);
		}
		
		if(wy+1<10&&grid[wx][wy+1].getWumpus()==false&&grid[wx][wy+1].getStench()==false)
		{
			grid[wx][wy+1].setStench(true);
		}
		
		if(wy-1>=0&&grid[wx][wy-1].getWumpus()==false&&grid[wx][wy-1].getStench()==false)
		{
			grid[wx][wy-1].setStench(true);
		}
		
		
		
// dedwumpus?
		//stenches are somewhere

	}
	
//////////OTHER METHODS
	
	public int getLadderCol()
	{
		return ladderC;
	}
	
	public int getLadderRow()
	{
		//System.out.println("tez");
		return ladderR;
	}
	
	public String toString()
	{
		//System.out.println("hai");
		String ret="";
		
		for(int sx=0;sx<10;sx++)
		{
			ret+="\n";
			for(int sy=0;sy<10;sy++)
			{
				ret+=grid[sx][sy].toString();
			}
		}
		
		System.out.println(ret);
		return ret;
	}
	

	

	public WumpusSquare getSquare(int col, int row)
	{
		
		if(row>=0&&row<10&&col>=0&&col<10)
		{
				return grid[col][row];
		}else{
			return null;
		}
			
	}

	
	
	
	

}


