
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileProcessor {

	private String fileName;
	private int stringLength;
	private ArrayList<String> stringList;
	private Scanner input;
	
	public FileProcessor(String fileName, int stringLength) {
		
			
	}//end empty-argument constructor
	
	public String getFileName() {
		return fileName;
		
	} //setFileName



	public void setFileName(String fileName) {
		this.fileName = fileName;
		
	} //setFileName



	public int getStringLength() {
		return stringLength;
		
	} //getStringLength



	public void setStringLength(int stringLength) {
		
		if (stringLength < 5) {
			this.stringLength = 5;
			
		} else {
			this.stringLength = stringLength;
		}
	} //setStringLength
	
	public int getArrayListSize() {
		return stringList.size();
		
	}//end getArrayListSize
	
	public void processFile() {
		try {
			input = new Scanner(new File(fileName));
			
			while (input.hasNextLine()) {
				String line = input.nextLine();
				
				if (line.length() > stringLength) {
					throw new StringTooLongException("String is too long!");
				}
				stringList.add(line);
			}
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
			
		} catch (StringTooLongException e) {
			System.out.println(e.getMessage());
			
		} finally {
			if (input != null) {
				input.close();
			}
		}
	} //end processFile	
	
}//end class
