package smoketests;

import java.util.List;

public class DataReaders {

	public static void main(String[] args) {
		readXLS();

	}
	
	public static void readCSV() {
		String filename = "C:\\Software\\EvansUserAccount.csv";
		List <String[]> records = Utilities.CSV.get(filename);
		
		//Iterating through the list
		for (String[] record : records) {
			for (String field : record) {
				System.out.println(field);
			}
		}		
		
	}
	
	public static void readXLS() {
		String filename = "C:\\Software\\EvansUserLogin.xls";
		String[][] data = Utilities.Escel.get(filename);
		for (String[] record : data) {
			System.out.println("\nNEW RECORD");
			System.out.println(record[0]);
			System.out.println(record[1]);
			}
		}
		
		
}


