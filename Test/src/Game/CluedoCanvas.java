package Game;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import Tokens.PlayerToken;
import Tokens.Token;


public class CluedoCanvas extends JPanel{

	private static int BOARD_HEIGHT = 600;
	private static int WINDOW_WIDTH;
	private static int WINDOW_HEIGHT;
	
	public CluedoCanvas(int width, int height){
		super();
		WINDOW_WIDTH  = width;
		WINDOW_HEIGHT = height;
	}
	
	@Override
	public void paint(Graphics g){
		super.paint(g);

	//Basic frame coloring
	//drawBackgrounds(g);
	
	}
	
	private static int DICE_SIZE = 40;
	private static int CARD_HEIGHT = 50;
	private static int CARD_WIDTH = 30;
	private static int CARD_X = 300;
	private static int NAME_HEIGHT = 30;
	
	
	
	/**
	 * Draw backgrounds of interface sections
	 * @param g graphics item to draw on
	 */
	private void drawBackgrounds(Graphics g) {
		//Draw Board square
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, WINDOW_WIDTH, BOARD_HEIGHT);
		
		//Interface square
		g.setColor(new Color(50,50,50));
		g.fillRect(0, BOARD_HEIGHT, WINDOW_WIDTH, BOARD_HEIGHT);
		
		
		//Draw dice area
		g.setColor(Color.WHITE);
		g.fillRect(DICE_SIZE,  BOARD_HEIGHT + DICE_SIZE, DICE_SIZE * 5, DICE_SIZE * 2);
		
		//Play name section
		g.setColor(new Color(25,25,25));
		g.fillRect(0,  BOARD_HEIGHT - (NAME_HEIGHT/ 2), WINDOW_WIDTH, NAME_HEIGHT);
		
		//Cards
		g.setColor(Color.WHITE);
		int cardSectionHeight = BOARD_HEIGHT + ((WINDOW_HEIGHT - BOARD_HEIGHT) / 2) - (CARD_HEIGHT / 2); 
		g.fillRect(CARD_X, cardSectionHeight, CARD_WIDTH * 5, CARD_HEIGHT + 5);
		
		
	}
	
	private static final String IMAGE_PATH = "images/";
	
	private static final Image Tile = loadImage("Tile.png");
	private static final Image Room_Tile = loadImage("RmT.png");
	private static final Image Room_Wall = loadImage("RmW.png");
	private static final Image Room_Wall_Corner = loadImage("RmC.png");
	private static final Image Room_Wall_Point = loadImage("RmI.png");
	private static final Image Room_Window = loadImage("RmWi.png");
	private static final Image Room_Window_Corner = loadImage("RmWiC.png");
	private static final Image Room_Door = loadImage("RmD.png");
	private static final Image Room_Wall_Door_1 = loadImage("WD1.png");
	private static final Image Room_Wall_Door_2 = loadImage("WD2.png");
	private static final Image Hall_1 = loadImage("H1.png");
	private static final Image Hall_2 = loadImage("H2.png");
	private static final Image External_Wall = loadImage("EW.png");
	private static final Image External_Wall_Corner = loadImage("EWC.png");
	private static final Image External_Wall_Point = loadImage("EWO.png");
	private static final Image External_Wall_U = loadImage("EWU.png");
	
	private static final Image[] squares = {
		Tile,								//0 - Common floor tile
		Room_Tile,							//1 - Common room tile
		Room_Wall,							//2 - Room wall Left
		rotate(Room_Wall, 90),				//3 - Room wall Up
		rotate(Room_Wall, 180),				//4 - Room wall Right
		rotate(Room_Wall, -90),				//5 - Room wall Down
		Room_Wall_Corner,					//6 - Room wall Corner Left and Up
		rotate(Room_Wall_Corner, 90),		//7 - Room wall Corner Up and Right
		rotate(Room_Wall_Corner, 180),		//8 - Room wall Corner Right and Down
		rotate(Room_Wall_Corner, -90),		//9 - Room wall Corner Down and Left
		Room_Wall_Point,					//10 - Room wall Point Left and Up
		rotate(Room_Wall_Point, 90),		//11 - Room wall Point Up and Right
		rotate(Room_Wall_Point, 180),		//12 - Room wall Point Right and Down
		rotate(Room_Wall_Point, -90),		//13 - Room wall Point Down and Left
		Room_Window,						//14 - Room window Left
		rotate(Room_Window, 90),			//15 - Room window Up
		rotate(Room_Window, 180),			//16 - Room window Right
		rotate(Room_Window, -90),			//17 - Room window Down
		Room_Window_Corner,					//18 - Room window Corner Up and Right
		rotate(Room_Window_Corner, 180),	//19 - Room window Corner Right and Down
		Room_Door,							//20 - Room door Left
		rotate(Room_Door, 90),				//21- Room door Up
		rotate(Room_Door, 180),				//22 - Room door Right
		rotate(Room_Door, -90),				//23 - Room door Down
		Room_Wall_Door_1,					//24 - Room wall right, door up
		rotate(Room_Wall_Door_1, 180),		//25 - Room wall left, door down
		Room_Wall_Door_2,					//26 - Room wall left, door up
		Hall_1,								//27 - Lounge hallway
		rotate(Hall_1, 90),					//28 - Kitchen hallway
		rotate(Hall_1, 180),				//29 - Conservatory hallway
		Hall_2,								//30 - Study hallway
		External_Wall,						//31 - External wall Left
		rotate(External_Wall, 90),			//32 - External wall Up
		rotate(External_Wall, 180),			//33 - External wall Right
		rotate(External_Wall, -90),			//34 - External wall Down
		External_Wall_Corner,				//35 - External wall Corner Left and Up
		rotate(External_Wall_Corner, 90),	//36 - External wall Corner Up and Right
		rotate(External_Wall_Corner, 180),	//37 - External wall Corner Right and Down
		rotate(External_Wall_Corner, -90),	//38 - External wall Corner Down and Left
		External_Wall_Point,				//39 - External wall Point Left and Up
		rotate(External_Wall_Point, 90),	//40 - External wall Point Up and Right
		rotate(External_Wall_Point, 180),	//41 - External wall Point Right and Down
		rotate(External_Wall_Point, -90),	//42 - External wall Point Down and Left
		External_Wall_U,					//43 - External wall U Down
		rotate(External_Wall_U, 90),		//44 - External wall U Left
		rotate(External_Wall_U, 180),		//45 - External wall U Right
		rotate(External_Wall_U, -90),		//46 - External wall U up (Normal U shape)
	};
	
	
	/**
	 * Load an image from the file system, using a given filename.
	 * 
	 * @param filename
	 * @return
	 */
	public static Image loadImage(String filename) {
		// using the URL means the image loads when stored
		// in a jar or expanded into individual files.
		java.net.URL imageURL = CluedoCanvas.class.getResource(IMAGE_PATH + filename);

		try {
			Image img = ImageIO.read(imageURL);
			return img;
		} catch (IOException e) {
			// we've encountered an error loading the image. There's not much we
			// can actually do at this point, except to abort the game.
			throw new RuntimeException("Unable to load image: " + filename);
		}
	}

	/**
	 * Rotate an image a given number of degrees.
	 * @param src
	 * @param angle
	 * @return
	 */
	public static Image rotate(Image src, double angle) {
		int width = src.getWidth(null);
		int height = src.getHeight(null);		
		BufferedImage img = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
		Graphics2D g = img.createGraphics();
		g.rotate(Math.toRadians(angle), width/2, height/2);		
		g.drawImage(src,0,0,width,height,null);
		g.dispose();
		return img;
	}
	
	private void drawTokens(Graphics g, int startx, int starty, int width, int height){
		
		for (int row=1; row<=25; row++){
			for(int col=1; col<=24; col++){
				// If there is a token at position draw the piece
			}
		}
	}
	
	private void drawToken(Token t, Graphics g){
		if (t instanceof PlayerToken){
			g.setColor(t.getColor());
		}
	}
	
}
