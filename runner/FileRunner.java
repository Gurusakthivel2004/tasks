package runner;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import exception.CustomException;

public class FileRunner {

	public static void main(String[] args) {
		FileRunner fileRunner = new FileRunner();
		Scanner reader = new Scanner(System.in);
		
		System.out.println("Enter the question number: ");
	    int questionNo = reader.nextInt();
	    reader.nextLine();
	      
	    switch(questionNo) {
	
        	case 1:
        		fileRunner.createFile(reader);
        		break;
				
	    }
	}
	
	public void createFile(Scanner reader) {
		try (FileWriter writer = new FileWriter("sample.txt")){
			System.out.println("Enter the number of words : ");
			int numberOfWords = reader.nextInt();
			reader.nextLine();
			System.out.println("Enter the words to add in the file");
			while(numberOfWords --> 0) {
				writer.write(reader.nextLine() + "\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
 
}
