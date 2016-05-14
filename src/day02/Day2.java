package day02;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

public class Day2 {
	public static void main(String[] args) throws IOException {
		ArrayList<String> dimensions = new ArrayList<>();
		
        URL path = Day2.class.getResource("input02.txt");
		Scanner scanner = new Scanner(new File(path.getFile()));
		while (scanner.hasNext()) {
        	dimensions.add(scanner.nextLine()); 	
        }
        scanner.close();
        
        long totalWrappingPaper = 0;
        long totalRibbonLength = 0;
        
        for (String present : dimensions) {
        	String[] presentDimensions = present.split("x");
        	int l = Integer.parseInt(presentDimensions[0]);
        	int w = Integer.parseInt(presentDimensions[1]);
        	int h = Integer.parseInt(presentDimensions[2]);
        	
        	int surface = 2 * ((l*w) + (w*h) + (h*l));
        	int extraPaper = Math.min((l*w), Math.min((w*h), (h*l)));
        	int onePresentWrappingPaper = surface + extraPaper;
        	
        	totalWrappingPaper += onePresentWrappingPaper;
        	
        	int ribbonWrap = 2 * ((l+w+h) - Math.max(l, Math.max(w, h)));
        	int ribbonBow = l*w*h;
        	int onePresentRibbon = ribbonWrap + ribbonBow;
        	
        	totalRibbonLength += onePresentRibbon;
        }
        
        System.out.println("Wrapping Paper: " + totalWrappingPaper);
        System.out.println("Ribbon: " + totalRibbonLength);
	}
}