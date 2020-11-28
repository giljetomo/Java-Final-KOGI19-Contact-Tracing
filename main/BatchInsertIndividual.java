package kogi19.main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;

import kogi19.DatabaseHandler.DatabaseHandler;

public class BatchInsertIndividual {
	
	DatabaseHandler dbhandler = null;

//	public BatchInsertIndividual() throws IOException {
//	  BufferedReader br = new BufferedReader(new FileReader("/Users/124090/Documents/School/WMAD/TextFileTest/src/file.csv"));
//	    String line = null;
//	    ArrayList<String> items = new ArrayList<>();
//	    int counter = 1;
//	    while ((line = br.readLine()) != null) {
//	    	items = new ArrayList<>();
//	    	String[] values = line.split(",");
//	    		for (String str : values) {
//	    			items.add(str);
//	    		}
//	    	System.out.print(counter++ + ". ");
//	    	for(int num = 0; num < items.size(); num++) {
//	    		System.out.print(items.get(num) + " ");
//	    	}
//	    	System.out.println();
//	    }
//	    br.close();
//	  }

	public int batchInsert () throws IOException {
		  int totalAdded = 0;
//		  BufferedReader br = new BufferedReader(new FileReader("/Users/124090/Documents/School/WMAD/TextFileTest/src/test.csv"));
		  //file outside src folder
		  BufferedReader br = new BufferedReader(new FileReader("file.csv"));
		    String line = null;
		    ArrayList<String> items = new ArrayList<>();
		    ArrayList<Individual> persons = new ArrayList<>();
		    while ((line = br.readLine()) != null) {
		    	items = new ArrayList<>();
		    	String[] values = line.split(",");
		    	
		    	String name = values[0];
		    	String gender = values[1];
		    	Date birthdate = Date.valueOf(values[2]);
		    	String address = values[3];
		    	String contact = values[4];
		    	
		    	persons.add(new Individual(name, gender, birthdate, contact, address));
		    	
		    }
		    
		    for(Individual i : persons) {
		    	
		    	dbhandler = DatabaseHandler.getInstance();
		    	if(dbhandler.addNewIndividual(i)) {
		    		totalAdded++;
		    	}
//		    	System.out.printf("%s %s %s %s %s", i.getName(), i.getGender(), i.getBirthdate(), i.getAddress(), i.getContact());
//		    	System.out.println();
		    }
		    
		    br.close();
		    return totalAdded;
		  }
	
}
