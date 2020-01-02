////////NOT DONE: Pit has stench and breeze on top of it??????
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;

public class WumpusPanel extends JPanel implements KeyListener
{	
	private static final int PLAYING=0;
	private static final int DEAD=1;
	private static final int WON=2;
	BufferedImage buffer;
	int status;
	WumpusPlayer player;
	WumpusMap map= new WumpusMap();
	
	
	//WumpusMap dora= new WumpusMap();
	WumpusPlayer chicken= new WumpusPlayer();
	WumpusSquare squack= new WumpusSquare();
	
	//private int xOfLeft=50;
	//private int yOfLeft=50;
	//private int xOfRight=100;
	//private int yOfRight=100;
	
	BufferedImage Floor;
	BufferedImage arrow;
	BufferedImage black;
	BufferedImage breeze;
	BufferedImage ladder;
	BufferedImage deadWumpus;
	BufferedImage pit;
	BufferedImage playerDown;
	BufferedImage playerLeft;
	BufferedImage playerRight;
	BufferedImage playerUp;
	BufferedImage gold;
	BufferedImage wumpus;
	BufferedImage stench;
	int laddercol= map.getLadderCol();
	int ladderrow= map.getLadderRow();
	boolean anotha1=false;
	boolean ontop=false;
	boolean lose=false;
	boolean katniss=true;
	boolean goldbar=true;
	boolean inventorygold=false;
	boolean win=false;
	boolean laddertext=true;
	boolean wumpusded=false;
	boolean wumpuslose=false;
	boolean goaway=false;
	boolean cheat=false;
	boolean scream=false;
	
	
	//boolean iwashere=false;
	public WumpusPanel(int panelWidth, int panelHeight)
	{
		
		//create the panel
		super();
		

		
		addKeyListener(this);
		
		setSize(panelWidth, panelHeight);
		reset();
		
		try
		{
			//floor = ImageIO.read(this.getClass().getResource("Images\\Floor.gif"));
			
			Floor= ImageIO.read(getClass().getResourceAsStream("/Floor.gif"));
			arrow= ImageIO.read(getClass().getResourceAsStream("/arrow.gif"));
			black= ImageIO.read(getClass().getResourceAsStream("/black.gif"));
			breeze=ImageIO.read(getClass().getResourceAsStream("/breeze.gif"));
			deadWumpus=ImageIO.read(getClass().getResourceAsStream("/deadWumpus.gif"));
			gold=ImageIO.read(getClass().getResourceAsStream("/gold.gif"));
			ladder= ImageIO.read(getClass().getResourceAsStream("/ladder.gif"));
			pit=ImageIO.read(getClass().getResourceAsStream("/pit.gif"));
			playerDown=ImageIO.read(getClass().getResourceAsStream("/playerDown.png"));
			playerLeft=ImageIO.read(getClass().getResourceAsStream("/playerLeft.png"));
			playerRight=ImageIO.read(getClass().getResourceAsStream("/playerRight.png"));
			playerUp=ImageIO.read(getClass().getResourceAsStream("/playerUp.png"));
			stench=ImageIO.read(getClass().getResourceAsStream("/stench.gif"));
			wumpus=ImageIO.read(getClass().getResourceAsStream("/wumpus.gif"));
			
			//floor = ImageIO.read((new File("images\\Floor.gif")));
			//System.out.println("All imafes were loaded properly");
		}
		catch(Exception e)
		{
			System.out.println("Error loading images: "+e.getMessage());
		}
		
		
	}

	public void reset()
	{
		//System.out.println("gere");
		status=PLAYING;
		map.createMap();
		map.toString(); 
		cheat=false;
		goldbar=true;
		win=false;
		lose=false;
		wumpuslose=false;
		wumpusded=false;
		katniss=true;
		anotha1=false;
		goaway=true;
		chicken.colPosition=map.getLadderCol();
		chicken.rowPosition=map.getLadderRow();
		//map.getSquare(map.getLadderCol(), map.getLadderRow()).setVisited(true);
		
		
		//System.out.println("reset:"+chicken.getCol());
	
		

		
		
	}
	
	public void paint(Graphics g)
	{

		//System.out.println("paint: "+chicken.getCol());
		
		
		
		g.setColor(new Color(138,140,145));
		g.fillRect(0,0,getWidth(),getHeight());
		
		g.setColor(new Color(0,0,0));
		g.fillRect(50, 555, 260, 90);
		
		g.fillRect(330, 555, 220, 90);
		
		
		g.setColor(new Color(255,255,255));
		Font f= new Font("LeviBrush",Font.PLAIN,35);
		g.setFont(f);
		g.setColor(Color.RED);
		g.drawString("Inventory:", 370, 585);
	
		//Font msg= new Font("LeviBrush",Font.PLAIN,25);
		//g.setFont(msg);
		g.drawString("Messages:", 90, 585);
		g.setColor(new Color(255,255,255));
		g.fillRect(50,50,500,500);
		
		g.setColor(Color.CYAN);
		Font m= new Font("Apple Gothic",Font.PLAIN,15);
		g.setFont(m);
		

		
		for(int x=0;x<10;x++)
		{
			for(int y=0;y<10;y++)
			{
				
				//System.out.println(map.grid[chicken.rowPosition][chicken.colPosition].getplswork());
				//System.out.println(map.iwashere());
				
			
				
				//System.out.println(map.getSquare(x,y).getVisited());
				//System.out.println("x: "+x+" y: "+y);
				
				
				if(map.getSquare(x, y).getVisited()==true||cheat==true)
				{
					//System.out.println("hell ya");
					g.drawImage(Floor, ((x*50)+50), ((y*50)+50), null);
					//g.drawImage(Floor, ((x*50)+50), ((y*50)+50), null);
				}else{
					g.drawImage(black, ((x*50)+50), ((y*50)+50), null);
				}
			
				
				
				
				//''
				
				
				//g.drawImage(pit, 100, 100, null);
				
				/*
				if(((chicken.getCol()*50)+50)==x&&((chicken.getRow()*50)+50)==y)
				{
					//iwashere=true;
				}
				
				if(iwashere==false)
				{
					g.drawImage(black, x, y, null);
				}else{
					g.drawImage(Floor, x, y, null);
				}
				
				
				if(((chicken.getCol()*50)+50)==x&&((chicken.getRow()*50)+50)==y&&iwashere==true)
				{
					g.drawImage(Floor, x, y, null);
				}
				
				
				
				
				if(((chicken.getCol()*50)+50)==x&&((chicken.getRow()*50)+50)==y)
				{
				//int test1=chicken.colPosition;
				//int test2=chicken.rowPosition;
				//System.out.println(test1);
					for(int xx=50;xx<550;xx+=50)
					{
						for(int yy=50;yy<550;yy+=50)
						{
					
					//System.out.println(xx);
							//xx=x;
							//yy=y;
					g.drawImage(Floor, xx, yy, null);
				//g.drawImage(Floor,((chicken.getCol()*50)+50),((chicken.getRow()*50)+50),null);
					}
						
					}
					}//else{
					ontop=true;
					*/
				 
					
					
				}
				
			}
		//}
		

		
		
		//System.out.println("player x:"+chicken.colPosition+" player y:"+chicken.rowPosition);
		
		
		
		for(int la=0;la<10;la++)
		{
			for(int lo=0;lo<10;lo++)
			{
				//if(map.gri)
				//System.out.println(lose);
				
				
				//System.out.println("x-"+lo+" y-"+la);
				
				/*
				 * boolean breezeandstench=false;
		boolean breezeandgold=false;
				 */
				
				/*
				//make 1 big for loop?
				if(map.grid[lo][la].getBreeze()==map.grid[lo][la].getStench())
				{
					//breezeandstench=true;
					g.drawString("You smell a stench.", 65, 610);
					g.drawString("You feel a breeze.", 65, 625);
					//breezeandstench=false;
				}
				
				
				if(map.grid[lo][la].getPit()==true&&chicken.rowPosition==lo&&chicken.colPosition==la)
				{
					//System.out.println("on pit");
					g.drawString("You fell down a pit to your death.", 65, 610);
					g.drawString("GAME OVER. (n for new game)", 65, 625);
					
					lose=true;
				}
				
				
		
				if(map.grid[lo][la].getLadder()==true&&chicken.colPosition==la&&chicken.rowPosition==lo)
				{
					
					if(laddertext==true&&map.grid[lo][la].getBreeze()==true&&chicken.colPosition==la&&chicken.rowPosition==lo)
					{
						ladandbreeze=true;
						g.drawString("You bump into the ladder.", 65, 610);
						g.drawString("You feel a breeze.", 65, 625);
					}
			
				}
				
				if(map.grid[lo][la].getBreeze()==true&&chicken.colPosition==la&&chicken.rowPosition==lo&&ladandbreeze==false&&breezeandstench==false)
				{
					g.drawString("You feel a breeze.", 65, 610);
				}
				*/
				
				if(map.grid[lo][la].getPit()==true)
				{
					//System.out.println(lo);
					/*if(lo==0)
					{
						lo=1;
					}
					
					if(la==0)
					{
						la=1;
					}
					*/
					//g.drawImage(pit,2*50,2*50, null);
					
					//System.out.println(la+" "+lo);
					if(map.getSquare(la, lo).getVisited()==true||cheat==true){
					g.drawImage(pit,((la*50)+50),((lo*50)+50),null);}
					
				}
				
				if(map.grid[lo][la].getBreeze()==true)
				{
					if((map.getSquare(la, lo).getVisited()==true||cheat==true)&&map.grid[lo][la].getPit()==false){///77{{
					g.drawImage(breeze,((la*50)+50),((lo*50)+50),null);}
				}
				
				if(map.grid[lo][la].getWumpus()==true)
				{
					if(wumpusded==false)
					{
						if(map.getSquare(la, lo).getVisited()==true||cheat==true){
					g.drawImage(wumpus, ((la*50)+50), ((lo*50)+50), null);}
					}else 
					{
						if(map.getSquare(la, lo).getVisited()==true||cheat==true){
						g.drawImage(deadWumpus, ((la*50)+50), ((lo*50)+50), null);}
					}
				}
				
				if(map.grid[lo][la].getStench()==true)
				{
					if((map.getSquare(la, lo).getVisited()==true||cheat==true)&&map.grid[lo][la].getPit()==false){
					g.drawImage(stench, ((la*50)+50), ((lo*50)+50), null);}
				}
				
				if(map.grid[lo][la].getLadder()==true)
				{
					if(map.getSquare(la, lo).getVisited()==true||cheat==true){
					g.drawImage(ladder, ((la*50)+50), ((lo*50)+50), null);}
				}
				
				if(map.grid[lo][la].getGold()==true&&goldbar==true)
				{
					//booleangold tru = pick up
					if(map.getSquare(la, lo).getVisited()==true||cheat==true){
					g.drawImage(gold, ((la*50)+50), ((lo*50)+50), null);}
				}
				
				
				
				//int startx= chicken.getCol();
				//int starty= chicken.getRow();
				

				//g.drawImage(playerUp, ((chicken.colPosition*50)+50), ((chicken.rowPosition*50)+50), null);
				
			}
			

		}
		
		for(int iam=0;iam<10;iam++)
		{
			for(int gaby=0;gaby<10;gaby++)
			{
				if(map.grid[gaby][iam].getDead()==true)
				{
					
					//if(goaway==false&&map.grid[gaby][iam].getDead()==true)
					if(map.grid[gaby][iam].getDead()==true)
					{
						System.out.println(anotha1);
						if(goaway==false)
						{
						//System.out.println(anotha1);
						anotha1=true;
						if(anotha1==true)
						{
							g.drawString("You hear a scream.", 65, 610);
						}
						}else if(goaway==true)
						{
						anotha1=false;
						//System.out.println(anotha1);
						}
					}
				}
				if(chicken.colPosition==iam&&chicken.rowPosition==gaby)
				{
					
				if(map.grid[gaby][iam].getLadder()==true&&win==false&&anotha1==false)
				{
					//System.out.println("lel");
					if(map.grid[gaby][iam].getBreeze()==true)
					{
						if(map.grid[gaby][iam].getStench()==true)
						{
							
							g.drawString("You bump into the ladder.", 65, 610);
							g.drawString("You feel a breeze.", 65, 625);
							g.drawString("You feel a stench.", 65, 640);
							
							
						}else{
						g.drawString("You bump into the ladder.", 65, 610);
						g.drawString("You feel a breeze.", 65, 625);
						}
					}
					
					if(map.grid[gaby][iam].getStench()==true&&map.grid[gaby][iam].getBreeze()==false)
					{
						g.drawString("You bump into the ladder.", 65, 610);
						g.drawString("You smell a stench.", 65, 625);
					}else{
					g.drawString("You bump into the ladder.", 65, 610);
					}
					
					
					
				}
				
				if(map.grid[gaby][iam].getGold()==true&&win==false&&anotha1==false)
				{
					if(map.grid[gaby][iam].getBreeze()==true)
					{
						g.drawString("You see a glimmer.", 65, 610);
						g.drawString("You feel a breeze.", 65, 625);
						
					}
					
					if(map.grid[gaby][iam].getStench()==true)
					{
						g.drawString("You see a glimmer.", 65, 610);
						g.drawString("You smell a stench.", 65, 625);
					}
					else
					{
						g.drawString("You see a glimmer.", 65, 610);
					}
				}
				
				if(map.grid[gaby][iam].getBreeze()==true&&map.grid[gaby][iam].getLadder()==false&&map.grid[gaby][iam].getGold()==false&&win==false&&map.grid[gaby][iam].getWumpus()==false&&map.grid[gaby][iam].getPit()==false&&anotha1==false)
				{
					if(map.grid[gaby][iam].getStench()==true)
					{
						g.drawString("You feel a breeze.", 65, 610);
						g.drawString("You smell a stench.", 65, 625);
					}else{
						
					g.drawString("You feel a breeze.", 65, 610);
					}
				}
				
				if(map.grid[gaby][iam].getStench()==true&&map.grid[gaby][iam].getGold()==false&&map.grid[gaby][iam].getLadder()==false&&map.grid[gaby][iam].getBreeze()==false&&win==false&&map.grid[gaby][iam].getPit()==false&&anotha1==false)
				{
					
					g.drawString("You smell a stench.", 65, 610);
				}
				
				if(map.grid[gaby][iam].getWumpus()==true&&wumpuslose==false&&win==false&&wumpuslose==false&&anotha1==false)
				{
					g.drawString("You are eaten by the Wumpus.", 65, 610);
					g.drawString("GAME OVER. (n for new game)", 65, 625);
					
					lose=true;
					wumpuslose=true;
				}
				
				if(map.grid[gaby][iam].getPit()==true&&win==false&&anotha1==false)
				{
					g.drawString("You fell down a pit to your death.", 65, 610);
					g.drawString("GAME OVER. (n for new game)", 65, 625);
					lose=true;
				}
				

			}
		}
		
		if(win==true)
		{
			g.drawString("You win. (n for new game)", 65, 610);
		}
		
		if(wumpusded==true)
		{
			//g.drawString("You hear a scream.", 65, 610); //how to make this go away
			scream=true;
			wumpuslose=true;
		}
		

		if(goldbar==false)
		{
			g.drawImage(gold, 430, 590, null);
		}
	
		if(katniss==true)
		{
			g.drawImage(arrow, 400, 590, null);
			//g.drawImage(arrow, 50, 560, null);
		}
		
	//System.out.println("paint: "+((chicken.getRow()*50)+50));
		
		
		if(chicken.getDirection()==0)
		{
			//System.out.print(chicken.getCol());
			//System.out.println(chicken.getRow());
			g.drawImage(playerUp, ((chicken.getCol()*50)+50), ((chicken.getRow()*50)+50), null);
		}else if(chicken.getDirection()==1)
		{
			g.drawImage(playerRight, ((chicken.getCol()*50)+50), ((chicken.getRow()*50)+50), null);
		}else if(chicken.getDirection()==2)
		{
			
			g.drawImage(playerDown, ((chicken.getCol()*50)+50), ((chicken.getRow()*50)+50), null);
			
		}else if(chicken.getDirection()==3)
		{
			g.drawImage(playerLeft, ((chicken.getCol()*50)+50), ((chicken.getRow()*50)+50), null);
		}
		}
		
		
		
		//g.drawImage
		//System.out.println("h");
		//make a double for loop
		/*if(ontop==true)
		{
			for(int idk=50;idk<550;idk+=50)
			{
				for(int kdi=50;kdi<550;kdi+=50)
				{
					g.drawImage(black, idk, kdi, null);
				}
			}
		}
		*/
				


	}
	
			
		
		public void keyPressed(KeyEvent e)
		{
		}
		
		public void keyReleased(KeyEvent e)
		{
		}
		
		public void keyTyped(KeyEvent e)
		{
		
			char key= e.getKeyChar();
			if(key=='w')
			{
			
				//what happens if it gets out of bounds

				if(lose==false&&win==false)//&&chicken.colPosition>=0&&chicken.rowPosition>=0&&chicken.colPosition<10&&chicken.rowPosition<10)
				{
					if(goaway==false)
					{
						goaway=true;
					}
					chicken.direction=0;
				if(chicken.getRow()-1>-1&&chicken.getRow()-1<9)
				{
				chicken.rowPosition=chicken.getRow()-1;
				map.getSquare(chicken.getCol(),chicken.getRow()).setVisited(true);
				
				//chicken.rowPosition=(((chicken.getRow()*50)+50)-50);
				//System.out.println("key: "+chicken.getRow());
				
				}
				}
				
				/*for(int x=0;x<10;x++)
				{
					for(int y=0;y<10;y++)
					{
						if(map.grid[y][x].getPit()==true&&chicken.colPosition==y&&chicken.rowPosition==x)
						{
							System.out.println("lost");
							lose=true;
						}
					}
				}
				*/
				
				
				

	
				
				//System.out.println("up");
			}else if(key=='s')
			{
				
				
				if(lose==false&&win==false)//&&chicken.colPosition>=0&&chicken.rowPosition>=0&&chicken.colPosition<10&&chicken.rowPosition<10)
				{
					if(goaway==false)
					{
						goaway=true;
					}
					chicken.direction=2;
				if(chicken.getRow()+1>-1&&chicken.getRow()<9)	
				{
				chicken.rowPosition=chicken.getRow()+1;
				map.getSquare(chicken.getCol(),chicken.getRow()).setVisited(true);
				}
				//System.out.println("down");
				}
			}else if(key=='a')
			{
			
				if(lose==false&&win==false)//&&chicken.colPosition>=0&&chicken.rowPosition>=0&&chicken.colPosition<10&&chicken.rowPosition<10)
				{
					if(goaway==false)
					{
						goaway=true;
					}
					chicken.direction=3;
					if(chicken.getCol()-1>-1&&chicken.getRow()<=9)
					{
				chicken.colPosition=chicken.getCol()-1;
				map.getSquare(chicken.getCol(),chicken.getRow()).setVisited(true);
				
					}
				//System.out.println("left");
				}
			}else if(key=='d')
			{
				if(goaway==true)
				{
					//System.out.println("HELLO");
					anotha1=false;
				}
				//System.out.println(chicken.colPosition);
				//System.out.println(chicken.rowPosition);
				if(lose==false&&win==false)//&&chicken.colPosition>=0&&chicken.rowPosition>=0&&chicken.colPosition<10&&chicken.rowPosition<10)
				{
					if(goaway==false)
					{
						goaway=true;
					}
					chicken.direction=1;
					if(chicken.getCol()+1>-1&&chicken.getCol()+1<=9)
					{
				chicken.colPosition=chicken.getCol()+1;
				map.getSquare(chicken.getCol(),chicken.getRow()).setVisited(true);
				
					}
				//System.out.println("right");
				}
			}else if(key=='i'&&katniss==true&&lose==false&&win==false)
			{
				
				
				katniss=false;
				chicken.direction=0;
				
				 
				for(int y=chicken.rowPosition;y>=0;y--)
				{
					System.out.println(chicken.colPosition);
					int x=chicken.colPosition;
					
					System.out.println("x: "+x);
					System.out.println("y: "+y);
					
					if(map.grid[y][x].getWumpus()==true)
					{
						map.grid[x][y].setDead(true);
						wumpuslose=true;
						wumpusded=true;
						anotha1=true;
						goaway=false;
					}
						
				}
				
				/*
				for(int wm=0;wm<10;wm++)
				{
					for(int mw=0;mw<10;mw++)
					{
						if(map.grid[mw][wm].getWumpus()==true)
						{
							System.out.println("Wumpus mw/x: "+mw);
							System.out.println("Wumpus wm/y: "+wm);
						}
					}

				}
				
				
				
				 * 		for(int y=0;y<=chicken.colPosition;y++)
				{
					for(int x=0;x<=chicken.rowPosition;x++);
					{
							
						//System.out.println(y);
					System.out.println("x: "+x);
					//System.out.println("gang");
						if(map.grid[x][y].getWumpus()==true)
						{
							System.out.println("lol");
							wumpusded=true;
						}
				
				}
				}
				 */
				
		
				
				
				
				//System.out.println("Shoot up");
			}else if(key=='k'&&katniss==true&&lose==false&&win==false)
			{
				
				katniss=false;
				chicken.direction=2;
	
				
				
				for(int y=chicken.rowPosition;y<10;y++)
				{
					System.out.println(chicken.colPosition);
					int x=chicken.colPosition;
					
					//System.out.println("x: "+x);
					//System.out.println("y: "+y);
					
					if(map.grid[y][x].getWumpus()==true)
					{
						map.grid[x][y].setDead(true);
						wumpusded=true;
						wumpuslose=true;
						goaway=false
								;
					}
						
				}
				
				
				
				//System.out.println("Shoot down");
			}else if(key=='j'&&katniss==true&&lose==false&&win==false)
			{
	
				//int wump=0;
				katniss=false;
				chicken.direction=3;
		//	System.out.println("yo");
				for(int y=0;y<=chicken.colPosition;y++)
				{
					for(int x=0;x<=chicken.rowPosition;x++)
					{
						/*System.out.println("player x: "+chicken.rowPosition);
						System.out.println("player y: "+chicken.colPosition);
						System.out.println("x: "+x);
						System.out.println("y: "+y);
						*/

						if(map.grid[x][y].getWumpus()==true)
						{
							//System.out.println(x);
							//System.out.println("rat");
							
							//wump=x;
							//System.out.println(x);
							if(x==chicken.rowPosition)
							{
								map.grid[x][y].setDead(true);
								wumpusded=true;
								wumpuslose=true;
								goaway=false;
								//wumpus dead scream text
							}
						}else{
							//System.out.println("false");
						}
					}
				}
				
				/*
				for(int wm=0;wm<10;wm++)
				{
					for(int mw=0;mw<10;mw++)
					{
						if(map.grid[mw][wm].getWumpus()==true)
						{
							System.out.println("Wumpus mw/x: "+mw);
							System.out.println("Wumpus wm/y: "+wm);
						}
					}

				}
				*/
				
				//System.out.println("Shoot left");
				
			}else if(key=='l'&&katniss==true&&lose==false&&win==false)
			{
				
					
				
				//int wump=0;
				katniss=false;
				chicken.direction=1;
				
				for(int y=chicken.colPosition;y<10;y++)
				{
					for(int x=chicken.rowPosition;x<10;x++)
					{
						//System.out.println(x);
						if(map.grid[x][y].getWumpus()==true)
						{
							
							//wump=x;
							//System.out.println(x);
							if(x==chicken.rowPosition)
							{
								map.grid[x][y].setDead(true);
								wumpusded=true;
								wumpuslose=true;
								goaway=false;
								//wumpus dead scream text
							}
						}
					}
				}
				
				//System.out.println("Shoot right");
			}else if(key=='c')
			{
				for(int x=0;x<10;x++)
				{
					for(int y=0;y<10;y++)
					{
						

						if(goldbar==false)
						{
								if(map.grid[y][x].getLadder()==true&&chicken.colPosition==x&&chicken.rowPosition==y)
								{
									//System.out.println("winna");
									win=true;
									laddertext=false;
								}
						}
					}
				}
				
				
				
				//System.out.println("Climb ladder");
			}else if(key=='n')
			{
				//add if he dies too u can restart
				if(win==true||lose==true)
				{
					reset();
				}
				
				//System.out.println("New game");
			}else if(key=='*')
			{
				if(cheat==false)
				{
					cheat=true;
				}else if(cheat==true)
				{
					cheat=false;
				}
				
				//System.out.println("on/off cheat mode");
			}else if(key=='p')
			{
				for(int x=0;x<10;x++)
				{
					for(int y=0;y<10;y++)
					{
						if(map.grid[y][x].getGold()==true&&chicken.colPosition==x&&chicken.rowPosition==y)
						{
							goldbar=false;
							//inventorygold=true;
						}
					}
				}
				
				//System.out.println("gold");
			}
			repaint();
			

		}
		
		

		
		public void addNotify()
		{
			super.addNotify();
			requestFocus();
		}
	
		
		/*public char getKeyChar()
		{
			
		}
		
		public int getKeyCode()
		{
			
		}
		*/
}

