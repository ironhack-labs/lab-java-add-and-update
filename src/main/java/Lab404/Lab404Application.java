package Lab404;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.FileWriter;

@SpringBootApplication
public class Lab404Application {

	public static void main(String[] args) {
		SpringApplication.run(Lab404Application.class, args);
	}
/*

	// Readme edit
	String direccionReadme = "C:\\IronHack\\Labs\\Lab404\\lab-java-add-and-update\\README.md";

	String respuesta = " - I did use the same type of route for the updates, however on the patch you have to include the specific field on the path after selecting the id \n"
			+ "- I chose the selected strategy per restful guidelines \n"
			+ "advantages:  easy to access, standardization, disadvantages prone to user error. \n"
			+ "-cost benefit:  use correct method as patching uses a lot less data when compared to put (relevant on larger applications) ";

	FileWriter fileWriter = new FileWriter(direccionReadme, false);
g
	filewriter.write(respuesta);
	filewriter.close;
*/

}
