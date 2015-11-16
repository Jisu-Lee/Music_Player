import java.io.*;
import java.util.Scanner;


public class FileReader {
	public String[] readTextFile(String fileInformationAddress, String fileName){
		
		int lineNum = readLine(fileInformationAddress,fileName+".txt");
		String[] information = new String[lineNum];
		
		lineNum = 0;
		String inputLine = new String("");
		File musicFile = new File(fileInformationAddress,fileName+".txt");
		Scanner input ;
		try {
			input = new Scanner(musicFile);
		}
		
		catch(Exception e) {
			try {
				FileWriter fw = new FileWriter(musicFile);
				fw.close();
			} 
			catch (IOException e1) {
				e1.printStackTrace();
			}
			return null;
		}
		
		while(input.hasNext()){
			inputLine = input.nextLine();
			if(inputLine.startsWith("//")||(inputLine.trim()).equals("")) continue; // �ּ� �Ǵ� �� ��
			else{
				information[lineNum] = inputLine;
			
				lineNum++;
			}
		}
		input.close();
		
		return information;
	}
	public void writeTextFile(String fileInformationAddress, String fileName){
		
	}
	
	private int readLine(String fileAddress, String musicFile){
		int lineNum = 0;

		String inputLine = new String("");
		File fileName = new File(fileAddress,musicFile);
		Scanner input ;
		try {
			input = new Scanner(fileName);
		}
		
		catch(Exception e) {
			try {
				FileWriter fw = new FileWriter(fileName);
				fw.close();
			} 
			catch (IOException e1) {
				e1.printStackTrace();
			}
			return 0;
		}
		
		while(input.hasNext()){
			inputLine = input.nextLine();
			if(inputLine.startsWith("//")||(inputLine.trim()).equals("")) continue; // �ּ� �Ǵ� �� ��
			lineNum++;
		}
		input.close();

		return lineNum;
	}
	
}


