//Name:Chenhao Lu
//ID:1824173

package csvReading;

import static csvReading.Reading.animalamount;
import static csvReading.Reading.countrylist;
import static csvReading.Reading.readAmount;
import static csvReading.Reading.readCountry;
import static csvReading.Reading.readTitle;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Graphic extends JPanel {
	private int myX, myY;
	private int myWidth, myHeight;
	private final Image Image;
	private final Image QuarterImage;
	private final Image HalfImage;
	private final Image ThreetofourImage;

	//constructor
	public Graphic(String path, int myX, int myY, int myWidth, int myHeight) {
		this.myX = myX;
		this.myY = myY;
		this.myWidth = myWidth;
		this.myHeight = myHeight;
		Image = readImage(path).get(0);
		QuarterImage = readImage(path).get(1);
		HalfImage = readImage(path).get(2);
		ThreetofourImage = readImage(path).get(3);

	}

	public void paint(Graphics g) {

		// fill up the background
		g.setColor(new Color(200, 250, 233));
		g.fillRect(0, 0,750,750);

		// Depict graphic grid line
		g.setColor(Color.black);
		g.drawLine(0, 100, 750, 100);
		g.drawLine(0, 175, 750, 175);
		g.drawLine(0, 250, 750, 250);
		g.drawLine(0, 325, 750, 325);
		g.drawLine(0, 400, 750, 400);
		g.drawLine(0, 475, 750, 475);
		g.drawLine(0, 550, 750, 550);
		g.drawLine(0, 625, 750, 625);

		g.drawLine(175, 100, 175, 625);

	
		// Loop for outputting icons
		for (int i = 0; i < animalamount.size(); i++) {

			int number = animalamount.get(i);
			// read data from CSV and convert it into different images
			int thousand = number / 1000;
			// Number for print out "entire" icon
			for (int j = 0; j < thousand; j++) {

				g.drawImage(Image, 200 + 50 * j, 113 + 75 * i, 50, 50, this);
			}

			int remain = number % 1000;
			// Number for print out "fragment" icon
			switch (remain) {
			case 0:
				break;
			case 250:
				g.drawImage(QuarterImage, 200 + 50 * thousand, 113 + 75 * i, 12, 50, this);
				break;
			case 500:
				g.drawImage(HalfImage, 200 + 50 * thousand, 113 + 75 * i, 25, 50, this);
				break;
			case 750:
				g.drawImage(ThreetofourImage, 200 + 50 * thousand, 113 + 75 * i, 37, 50, this);
			
				
			}

		}
		g.setFont(new Font("Calibri",Font.PLAIN,26));
		
		//Loop countries
		for(int i=0;i<countrylist.size();i++) {
			g.drawString(countrylist.get(i),30,140+75*i );
		}
		//Print out title
		g.setFont(new Font("Georgia",Font.PLAIN,35));
		g.drawString(readTitle("Animal_Data.csv"), 40, 60);
		
		//Print out appendix
		g.setFont(new Font("Calibri",Font.PLAIN,20));
		g.drawString("Key:", 30, 675);
		g.drawImage(Image, 90, 650, 50, 50, this);
		g.drawString("=1000", 150, 675);
		g.drawImage(QuarterImage, 250, 650, 12, 50, this);
		g.drawString("=250", 320, 675);
		g.drawImage(HalfImage, 420, 650, 25, 50, this);
		g.drawString("=500", 490, 675);
		g.drawImage(ThreetofourImage, 590, 650, 37, 50, this);
		g.drawString("=750", 660, 675);
		
		
		
		
		
		
		
	}

	public static ArrayList<BufferedImage> readImage(String filename) {
		// this method reads image from files
		BufferedImage image = null;
		ArrayList<BufferedImage> imagelist = new ArrayList<BufferedImage>();
		// Create a list for storing icons (entire and component ones)
		try {
			image = ImageIO.read(new File(filename));
			BufferedImage image250 = image.getSubimage(0, 0, 40, 160);
			BufferedImage image500 = image.getSubimage(0, 0, 80, 160);
			BufferedImage image750 = image.getSubimage(0, 0, 120, 160);

			imagelist.add(image);
			imagelist.add(image250);
			imagelist.add(image500);
			imagelist.add(image750);

		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Wrong path for image display");
		}
		return imagelist;
	}
}
