package cat.xvcom.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleUtils {
	
	/**
	 * read an integer from the console
	 * @return
	 */
	public static int readInt() {
		int i = -1;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try{
            i = Integer.parseInt(br.readLine());
        }catch(NumberFormatException | IOException nfe){
            System.err.println("Invalid Format!");
        }
        
        return i;
	}
	
	/**
	 * read an String from the console
	 * @return
	 */
	public static String readString() {
		String s = null;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try{
            s = br.readLine();
        }catch( IOException nfe){
            System.err.println("Invalid Format!");
        }
        
        return s;
	}
	
	/**
	 * reads an string from the console with a message 
	 * @param message
	 * @return
	 */
	public static String readString(String message) {
		System.out.print(message+":>");
		return readString();
	}
	
	/**
	 * reads an int from the console with a message 
	 * @param message
	 * @return
	 */
	public static int readInt(String message) {
		System.out.print(message+":>");
		return readInt();
	}
}
