package kogi19.main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class BatchInsertIndividual {

	public BatchInsertIndividual() throws IOException {
	  BufferedReader br = new BufferedReader(new FileReader("/Users/124090/Documents/School/WMAD/TextFileTest/src/file.csv"));
	    String line = null;
	    ArrayList<String> items = new ArrayList<>();
	    int counter = 1;
	    while ((line = br.readLine()) != null) {
	    	items = new ArrayList<>();
	    	String[] values = line.split(",");
	    		for (String str : values) {
	    			items.add(str);
	    		}
	    	System.out.print(counter++ + ". ");
	    	for(int num = 0; num < items.size(); num++) {
	    		System.out.print(items.get(num) + " ");
	    	}
	    	System.out.println();
	    }
	    br.close();
	  }

}
