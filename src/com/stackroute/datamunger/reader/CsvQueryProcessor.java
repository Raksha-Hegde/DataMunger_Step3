package com.stackroute.datamunger.reader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


import com.stackroute.datamunger.query.DataTypeDefinitions;
import com.stackroute.datamunger.query.Header;

public class CsvQueryProcessor extends QueryProcessingEngine {

	String fileName;
	static BufferedReader bufferedReader;
	static int columnCount;

	// parameterized constructor to initialize filename
	public CsvQueryProcessor(String fileName) throws FileNotFoundException {
		this.fileName = fileName;
		
	}

	/*
	 * implementation of getHeader() method. We will have to extract the headers
	 * from the first line of the file. Note: Return type of the method will be
	 * Header
	 */
	@Override
	public Header getHeader() throws IOException {
		Header headerObj = new Header();
		bufferedReader = new BufferedReader(new FileReader(this.fileName));
		
		// read the first line
		String line = bufferedReader.readLine();

		// populate the header object with the String array containing the
		// header names
		headerObj.setHeaders(line.split(","));
		columnCount = headerObj.getHeaders().length;
		return headerObj;
	}

	/**
	 * getDataRow() method will be used in the upcoming assignments
	 */

	@Override
	public void getDataRow() {

	}

	/*
	 * implementation of getColumnType() method. To find out the data types, we will
	 * read the first line from the file and extract the field values from it. If a
	 * specific field value can be converted to Integer, the data type of that field
	 * will contain "java.lang.Integer", otherwise if it can be converted to Double,
	 * then the data type of that field will contain "java.lang.Double", otherwise,
	 * the field is to be treated as String. Note: Return Type of the method will be
	 * DataTypeDefinitions
	 */
	@Override
	public DataTypeDefinitions getColumnType() throws IOException {
		DataTypeDefinitions dataTypeDef = new DataTypeDefinitions();
		String line = bufferedReader.readLine();
		String[] rowData = line.split(",", columnCount);
		String[] dataType = new String[columnCount];
		int counter = 0;
		for (String str : rowData) {
			try {
				Integer.parseInt(str);
				dataType[counter] = "java.lang.Integer";
				counter++;
			} catch (NumberFormatException e) {
				try {
					Float.parseFloat(str);
					dataType[counter] = "java.lang.Float";
					counter++;
				} catch (NumberFormatException e1) {
					dataType[counter] = "java.lang.String";
					counter++;

				}

			}
		}
		dataTypeDef.setDataTypes(dataType);
		return dataTypeDef;
	}
}
