import java.io.*;

public class Histogram {

	private FileReader fr =  null;
	private BufferedReader br = null;
	private File file = null;
	int charNumber = 0;
	int charCount = 0;
	
	public static void main (String args[]) throws IOException
	{
		Histogram hist = new Histogram();
		if(hist.getNextCharacterFromFile(hist.getFile())== '\n')
		{
			System.out.println(hist.getNextCharacterFromFile(hist.getFile()));
		}
		else
			System.out.println(hist.getNextCharacterFromFile(hist.getFile()));

	}
	

	/**
	 * P1 - reading a file character by character 
	 * @throws IOException
	 */
	private char getNextCharacterFromFile(File file) throws IOException
	{
		
		fr = new FileReader(file);
		br = new BufferedReader(fr);
		
		char c = '0';
		if((charNumber = br.read()) != -1)
		{
			 c = (char) charNumber;
			
		}
		return c;
		/*charCount++;
		System.out.println(charCount);*/
	}
	
	private File getFile() 
	{
		file = new File("test.txt");
		return file;
		
	}
	
/*	private char readCharSkipCR(BufferedReader reader) throws IOException
	{
		int i = 0;
		Character c = null;
		while (i != -1)
		{
			i = reader.read();
			if((char) i == '\r')
				continue;
			else if((char) i == '\n')
				return c;
			
		}
		return c;
	} */
	
	
}