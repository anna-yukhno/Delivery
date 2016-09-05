/**
 * DBClass
 * @version 17.0 
 * @author Anna Kovalenko, 2016
 */

package delivery.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBclass {

	public String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	public String DB_URL = "jdbc:mysql://localhost:3306/";

	public String DB_NAME = "delivery";
	public String TABLE_NAME_SEND = "sender";
	public String TABLE_NAME_REC = "receiver";

	public String CREATE_DB = "create database " + DB_NAME;

	public String CREATE_TABLE_SEND = "create table " + TABLE_NAME_SEND + "(officeID int not null ,"
			+ " \"officeName\" varchar(45)not null," + " \"senderName\" varchar(45) not null,"
			+ " \"parcID\" int not null, \"cost\" varchar(45) not null," + " \"cost\" int not null," + " \"paid\" int,"
			+ "CONSTRAINT \"officeID\" PRIMARY KEY (officeID) )";

	public String CREATE_TABLE_REC = "create table " + TABLE_NAME_SEND + "(officeID int not null ,"
			+ " \"officeName\" varchar(45)not null," + " \"recName\" varchar(45) not null,"
			+ " \"parcID\" int not null, \"cost\" varchar(45) not null," + " \"cost\" int not null," + " \"paid\" int,"
			+ "CONSTRAINT \"officeID\" PRIMARY KEY (officeID) )";

	public String INSERT_TO_TABLE_SEND = "insert into " + TABLE_NAME_SEND
			+ " (officeID, officeName, senderName, parcID, cost, paid) values (?, ?, ?, ?, ?, ?)";
	public String INSERT_TO_TABLE_REC = "insert into " + TABLE_NAME_REC
			+ " (officeID, officeName, recName, parcID, cost, paid) values (?, ?, ?, ?, ?, ?)";

	public String SELECT_ALL = "select * from ";

	public String user = "Anna Kovalenko";
	public String pass = "marietta1";
	public String connection = "DB_URL + DB_NAME, user, pass";

	/*
	 * create database
	 */
	public void createDb() throws SQLException {
		Connection conn = DriverManager.getConnection(DB_URL, user, pass);
		Statement stmt = conn.createStatement();
		stmt.execute(CREATE_DB);
		stmt.close();
		conn.close();
	}

	/*
	 * create tables sender & receiver in the database
	 */
	public void createTables() throws SQLException {
		Connection conn = DriverManager.getConnection(connection);
		Statement stmt = conn.createStatement();

		stmt.execute(CREATE_TABLE_SEND);
		stmt.execute(CREATE_TABLE_REC);

		stmt.close();
		conn.close();
	}

	/*
	 * insert data into sender table
	 */
	public void fillTableSend(int officeID, String officeName, String senderName, int parcID, int cost, int paid)
			throws SQLException {

		Connection conn = DriverManager.getConnection(connection);

		PreparedStatement stmt = conn.prepareStatement(INSERT_TO_TABLE_SEND);
		stmt.setInt(1, officeID);
		stmt.setString(2, officeName);
		stmt.setString(3, senderName);
		stmt.setInt(4, parcID);
		stmt.setInt(5, cost);
		stmt.setInt(6, paid);

		stmt.addBatch();
		stmt.executeBatch();

		conn.close();
	}

	/*
	 * insert data into receiver table
	 */
	public void fillTableRec(int officeID, String officeName, String recName, int parcID, int cost, int paid)
			throws SQLException {

		Connection conn = DriverManager.getConnection(connection);

		PreparedStatement stmt = conn.prepareStatement(INSERT_TO_TABLE_REC);
		stmt.setInt(1, officeID);
		stmt.setString(2, officeName);
		stmt.setString(3, recName);
		stmt.setInt(4, parcID);
		stmt.setInt(5, cost);
		stmt.setInt(6, paid);

		stmt.addBatch();
		stmt.executeBatch();

		conn.close();
	}

	/*
	 * show sender table
	 */
	public void selectAllSend(String condition) throws SQLException {

		Connection conn = DriverManager.getConnection(connection);
		Statement stmt = conn.createStatement();
		ResultSet res = stmt.executeQuery(SELECT_ALL + TABLE_NAME_SEND + condition);
		while (res.next()) {

			System.out.println("------------------------------------------");
			System.out.print("officeID: " + res.getInt("officeID"));
			System.out.print(", OfficeName: " + res.getString("officeName"));
			System.out.print(", Sender name" + res.getString("senderName"));
			System.out.println(", Parcel ID: " + res.getInt("parcID"));
			System.out.println(", Cost: " + res.getInt("cost"));
			System.out.println(", paid: " + res.getInt("paid"));
		}
		res.close();
		stmt.close();
		conn.close();
	}

	/*
	 * show receiver table
	 */
	public void selectAllRec(String condition) throws SQLException {
		
		Connection conn = DriverManager.getConnection(connection);
		Statement stmt = conn.createStatement();
		ResultSet res = stmt.executeQuery(SELECT_ALL + TABLE_NAME_REC + condition);
		while (res.next()) {

			System.out.println("------------------------------------------");
			System.out.print("officeID: " + res.getInt("officeID"));
			System.out.print(", OfficeName: " + res.getString("officeName"));
			System.out.print(", Receiver name" + res.getString("recName"));
			System.out.println(", Parcel ID: " + res.getInt("parcID"));
			System.out.println(", Cost: " + res.getInt("cost"));
			System.out.println(", paid: " + res.getInt("paid"));
		}
		res.close();
		stmt.close();
		conn.close();
	}

}
