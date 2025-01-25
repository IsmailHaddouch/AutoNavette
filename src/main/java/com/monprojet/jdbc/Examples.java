package com.monprojet.jdbc;

public class Examples {

	void exp01() {
		DataSource ds = new MySqlDataSource("Transportapp");
		Database db = new Database(ds);
		String[][] data = db.select("utilisateur");
		print(data, 2);
	}
	
	void exp02() {
		// R�cup�rer les livres publi�s par l'�diteur N� 469
		DataSource ds = new MySqlDataSource("Biblio");
		Database db = new Database(ds);
		String[][] data = db.select("Titles", "Publisher_ID", 469);
		print(data, data.length);
	}
	
	void print(String[][] data, int rows) {
		if (rows >= data.length) rows = data.length - 1;
		for (int i = 0; i <= rows; i++) {
			for (int j = 0; j < data[i].length; j++) {
				System.out.print(data[i][j] + "\t");
			}
			System.out.println();
		}
	}
	public Examples() {
		exp01();
	}
	public static void main(String[] args) {
		new Examples();
	}

}
