//Name:Chenhao Lu
//ID:1824173

package csvReading;



import static csvReading.Reading.readAmount;
import static csvReading.Reading.readCountry;


import javax.swing.JFrame;


public class GraphicTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
		   
		    //Initialize graphic object
			Graphic graphic=new Graphic("orangutan.png", 0, 0, 750, 750);
			JFrame frame = new JFrame();
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setSize(750,750);
			frame.setTitle("Table");
			//Before adding graphic, read data from CSV files
			readAmount("Animal_Data.csv");
			readCountry("Animal_Data.csv");
			
			frame.add(graphic);
			
			
			
			

			frame.setVisible(true);
			
	}

}
