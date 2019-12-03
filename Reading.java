//Name:Chenhao Lu
//ID:1824173

package csvReading;

import static csvReading.Reading.animalamount;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Reading {

	// Create variables

	// private String title;
	private String country;
	private int amount;

	
	public static ArrayList<Integer> animalamount = new ArrayList<Integer>();
	public static ArrayList<String> countrylist = new ArrayList<String>();

	// constructor

	public Reading(String country, int amount) {
		
		this.country = country;
		this.amount = amount;
	}

	public String getCountry() {
		return country;
	}

	public int getAmount() {
		return amount;
	}

	
	public static void readAmount(String filepath) {
		Path path = Paths.get(filepath);

		try {
			BufferedReader reader = Files.newBufferedReader(path);
			String lineContent;// =null
			// Read title in first row (not use it)
			reader.readLine();
			

			while ((lineContent = reader.readLine()) != null) {

				String item[] = lineContent.split(",");

				if (item.length >= 1) {
					String last = item[1];
					int amount = Integer.parseInt(last);

					// Looping countries and amount of animals
					animalamount.add(amount);
					// Add countries and amounts to array list
				}
                
				// System.out.println(title); Test
			}
			reader.close();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	
	}
	


	public static void readCountry(String filepath) {
		Path path = Paths.get(filepath);

		try {
			BufferedReader reader = Files.newBufferedReader(path);
			String lineContent;// =null
			reader.readLine();
			// Read title in first row (not use it)

			while ((lineContent = reader.readLine()) != null) {

				String item[] = lineContent.split(",");

				if (item.length >= 0) {
					String last = item[0];
										
					// Looping countries and amount of animals
					countrylist.add(last);
					// Add countries and amounts to array list
				}
              
				// System.out.println(title); Test
			}
			reader.close();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	
	}
	
	public static String readTitle(String filepath) {
		Path path = Paths.get(filepath);
		String lineContent=null;
		try {
			BufferedReader reader = Files.newBufferedReader(path);
			 lineContent=reader.readLine();// =null
		
			// Read title in first row (use it)
		}catch (IOException ioe) {
			ioe.printStackTrace();
		}
		
		return lineContent;
	}
}