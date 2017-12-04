package com.stackroute.datamunger;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
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
			String[] header = queryProcessor.getHeader().getHeaders();
			/*
			 * call getColumnType() method of CsvQueryProcessor class to retrieve the array
			 * of column data types which is actually the object of DataTypeDefinitions
			 * class
			 */
			String[] columnType = queryProcessor.getColumnType().getDataTypes();
			/*
			 * display the columnName from the header object along with its data type from
			 * DataTypeDefinitions object
			 */
			for( int i =0;i<header.length;i++)
				System.out.println(header[i]+"\t\t"+columnType[i]);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		

	}

}
