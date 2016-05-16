package day03;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Day3 {
	public static void main(String[] args) throws IOException {
        String directions;
        
        URL path = Day3.class.getResource("input03.txt");
		Scanner scanner = new Scanner(new File(path.getFile()));
        if (scanner.hasNext()) {
        	directions = scanner.nextLine();
        	scanner.close();
        }
        else {
        	scanner.close();
        	throw new IOException("no input");
        }
        
    	int santaX = 0;
    	int santaY = 0;
    	int roboX = 0;
    	int roboY = 0;
    	
    	boolean isSantasTurn = true;
    	Set<List<Integer>> visitedPositions = new HashSet<>();
    	visitedPositions.add(Arrays.asList(0, 0));
        
        for (int i = 0; i < directions.length(); i++) {
        	char step = directions.charAt(i);
        	
        	if (isSantasTurn) {
        		int[] newPosition = takeStep(step, santaX, santaY);
        		santaX = newPosition[0];
        		santaY = newPosition[1];
        		visitedPositions.add(Arrays.asList(santaX, santaY));
        		isSantasTurn = false;
        	}
        	else {
        		int[] newPosition = takeStep(step, roboX, roboY);
        		roboX = newPosition[0];
        		roboY = newPosition[1];
        		visitedPositions.add(Arrays.asList(roboX, roboY));
        		isSantasTurn = true;
        	}	
        }
        System.out.println("Houses visited: " + visitedPositions.size());
	}
	
	public static int[] takeStep (char step, int x, int y) {
		switch (step) {
			case '>':
				x++;
				break;
			case '<':
				x--;
				break;
			case'^':
				y++;
				break;
			case 'v':
				y--;
				break;
    	}
		return new int[] {x, y};
	}
}
