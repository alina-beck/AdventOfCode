package day01;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

public class Day1 {

	public static void main(String[] args) throws IOException {
        String directions;
        
        URL path = Day1.class.getResource("input.txt");
		Scanner scanner = new Scanner(new File(path.getFile()));
        if (scanner.hasNext()) {
        	directions = scanner.nextLine();
        	scanner.close();
        }
        else {
        	scanner.close();
        	throw new IOException("no input");
        }
        
        int currentPosition = 0;
        char step;
        
        for (int i = 0; i < directions.length(); i++) {
            step = directions.charAt(i);
            if (step == '(') {
                currentPosition += 1;
            }
            else if (step == ')') {
                currentPosition -= 1;
            }
        }
        
        System.out.println(currentPosition);
	}
}
