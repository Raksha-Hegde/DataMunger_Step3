package com.stackroute.datamunger;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import com.stackroute.datamunger.query.DataTypeDefinitions;
import com.stackroute.datamunger.query.Header;
import com.stackroute.datamunger.reader.CsvQueryProcessor;

public class DataMunger {

	public static void main(String[] args) {

		// read the file name from the user
		System.out.println("Enter a file name: ");
		Scanner scannerObj = new Scanner(System.in);
		String fileName = scannerObj.nextLine();
		scannerObj.close();

		
		CsvQueryProcessor queryProcessor;
		try {
			/*
			 * create object of CsvQueryProcessor. We are trying to read from a file inside
			 * the constructor of this class. Hence, we will have to handle exceptions.
			 */
			queryProcessor = new CsvQueryProcessor(fileName);
			/*
			 * call getHeader() method of CsvQueryProcessor class to retrieve the array of
			 * headers
			 */
			
				queryProcessor.getHeader();
			/*
			 * call getColumnType() method of CsvQueryProcessor class to retrieve the array
			 * of column data types which is actually the object of DataTypeDefinitions
			 * class
			 */
			//queryProcessor.getColumnType();
			
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		}
		catch (IOException e) {
			System.out.println("File not found");
		}
		
		/*
		 * display the columnName from the header object along with its data type from
		 * DataTypeDefinitions object
		 */

	}

}
