import java.io.*;
import java.util.*;

public class Histogram {

	private FileReader fr =  null;
	private BufferedReader br = null;
	int charNumber = 0;
	private Character c;
	private Character C;
	private File test;
	//private String text = "";
	private ArrayList<Character> usedLetters;
	private HashMap<Character, Integer> histogram;
	private int min = 65; //ASCII for A
	private int max = 91; //ASCII for Z
	
	public static void main (String args[]) throws IOException
	{
		Histogram hist = new Histogram();
		hist.printHistogram(hist.reduce(hist.getNextCharacterFromFile(hist.getFile())));
	}

	/**
	 * P1 - reading a file character by character 
	 * @throws IOException
	 */
	private ArrayList<Character> getNextCharacterFromFile(File file) throws IOException
	{
		
		fr = new FileReader(file);
		br = new BufferedReader(fr);
		usedLetters = new ArrayList<>();
		usedLetters.clear();

		while((charNumber = br.read()) != -1)
		{
			 c = (char) charNumber;			 
			 if(c == '\n' | c == '\r')
				 continue;
			 else {
				 C = Character.toUpperCase(c);
				 usedLetters.add(C); 
			 }
		}
		return usedLetters;
	}
	
	private HashMap<Character, Integer> reduce(ArrayList<Character> usedLetters)
	{
		
		histogram = new HashMap<>();
		
		//initializing HashMap with the letters from A-Z with a count of 0
		for(int i = min; i < max; i++){
			histogram.put((char) i, 0);
		}
		
		for(int i = 0; i < this.usedLetters.size() ; i++){
			 if(histogram.containsKey(this.usedLetters.get(i))){
				 int value = histogram.get(this.usedLetters.get(i));
				 histogram.put((this.usedLetters.get(i)), value+1);
				}
		 }
		return histogram;
	}
	
	public void printHistogram(HashMap<Character, Integer> histogram) throws IOException 
	{
		String line;
		
		for(int i = min; i < max; i++) 
		{
			line = String.valueOf((char)i);
			for(int a = 0; a < histogram.get((char) i);a++)
			{
				line = line + "*";
			}
			writeToFile(line);
		}
	}

	private File getFile() 
	{
		test = new File("test.txt");
		return test;	
	}
	
	private void writeToFile(String line) throws IOException
	{
		FileWriter writer = new FileWriter("C:\\Users\\Tony\\eclipse-workspace\\Histogram\\frequency.txt", true);
		BufferedWriter bWriter = new BufferedWriter(writer);
		PrintWriter pWriter = new PrintWriter(bWriter);
		pWriter.println(line);
		pWriter.close();
	}

}