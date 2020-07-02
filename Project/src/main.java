import java.io.File;

public class main {

	public static void main(String[] args) {

		FileHandler FH = new FileHandler();
		FH.writeFile("Lorem Ipsum dolo sit");
		FH.writeFile("Lorem Ipsssssum dolo sit");
		FH.readFile();
		
		
		System.out.print(FH.getPath());
		
	
	}

}
