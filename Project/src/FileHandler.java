import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner; 
/**
 * Basic File Operations
 * 
 * @author John Doe
 *
 */
public class FileHandler {
	
	private File file;
	
	/**
	 * @param filename the Name of the File
	 * @return void
	 */
	
	private File createFile(String filename) {
	  try {
	      File file = new File(filename);
	      if (file.createNewFile()) {
	        System.out.println("File erstellt unter " + file.getAbsolutePath() + " ! ");
	      }
	      return file;
	   }catch (IOException ex) {
	      ex.printStackTrace();
	      return null;
	   }
	
	}
	
	public void writeFile(String Content) {
		try {
			FileWriter writer = new FileWriter(getFile().getAbsolutePath());	
			writer.append(Content);
			writer.close();
		}catch (IOException ex){
			ex.printStackTrace();
		}
	}
	
	public void readFile() {
	    try {
	      Scanner scanner = new Scanner(getFile());
	      System.out.println("\nContent is :");
	      while (scanner.hasNextLine()) {
	        String line = scanner.nextLine();
	        System.out.println(line + "\n");
	      }
	      scanner.close();
	    } catch (Exception ex) {
	      ex.printStackTrace();
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
	
	FileHandler(){
		 System.out.print("Used Path Constructor without parameter \n");
		 setFile(createFile("testfile"));
		
	}

	private File getFile() {
		return file;
	}

	private void setFile(File file) {
		this.file = file;
	}
}
