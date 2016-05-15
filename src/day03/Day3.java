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
        
    	int x = 0;
    	int y = 0;
    	Set<List<Integer>> visitedPositions = new HashSet<>();
        
        for (int i = 0; i < directions.length(); i++) {
        	visitedPositions.add(Arrays.asList(x, y));
        	
        	char step = directions.charAt(i);
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
        }
        System.out.println("Houses visited: " + visitedPositions.size());
	}
}
