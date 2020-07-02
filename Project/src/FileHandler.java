import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Vector; 
/**
 * Handels File Operations
 * 
 * @author John Doe
 *
 */
public class FileHandler {
	
	private File file;
	

	
	private File createFile(String filename) {
	  try {
	      File file = new File(filename + ".csv");
	      if (file.createNewFile()) {
	        System.out.println("File erstellt unter " + file.getAbsolutePath() + " ! ");
	      }
	      return file;
	   }catch (IOException ex) {
	      ex.printStackTrace();
	      return null;
	   }
	
	}
	
	/**
	 * @param Content the Content
	 * @return void
	 */
	public void writeFile(String Content) {
		try {
			FileWriter writer = new FileWriter(getFile().getAbsolutePath(),true);	
			writer.write(Content + "\n");
			writer.close();
		}catch (IOException ex){
			ex.printStackTrace();
		}
	}
	
	/**
	 * @param null
	 * @return Vector of Strings
	 */
	public Vector<String> readFile() {
	    try {
	      Scanner scanner = new Scanner(getFile());
	      Vector<String> v = new Vector<String>();
	      while (scanner.hasNextLine()) {
	        String line = scanner.nextLine();
	        v.add(line);
	      }
	      scanner.close();
	      return v;
	    } catch (Exception ex) {
	      ex.printStackTrace();
	      return null;
	    }
		
	  }
	
	public String getPath() {
		return getFile().getAbsolutePath();
	}
	
	//Constructor when File available
	FileHandler(File file){
		setFile(file);
		System.out.print("Used Path file object to open file ");
	}
	
	//Constructor when Absolute Path is available
	FileHandler(String absolutePath){
		 File file = new File(absolutePath);
		 setFile(file);
		 System.out.print("Used Path " + absolutePath + " to open file ");
		
	}
	
	//Basic Constructor
	FileHandler(){
		 System.out.print("Used Path Constructor without parameter \n");
		 setFile(createFile("testfile"));
		
	}

	
	//getter & setter
	private File getFile() {
		return file;
	}

	private void setFile(File file) {
		this.file = file;
	}
}
