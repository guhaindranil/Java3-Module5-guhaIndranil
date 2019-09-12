/*
 * ResultSetModel Class 
 * Establishes Database Connection
 * Create Movie Table 
 * Create PrepareStatements for Select All Entries and Insert a New Row
 * Implements the methods for AbstractTableModel Interface as appropriate
 * 
 */
package module5;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.table.AbstractTableModel;

public class MovieResultSetTableModel extends AbstractTableModel{
	
	private static final String URL = "jdbc:derby:MovieDB;create=true";

	private Connection connection;
	private Statement statement;
	private PreparedStatement selectAllMovie;
	private PreparedStatement addNewMovie;
	private ResultSet resultSet;
	private ResultSetMetaData metadata;
	private int numberOfRows;

	public MovieResultSetTableModel() {
		try {
			System.out.println("Connecting to database URL: " + URL);
			connection = DriverManager.getConnection(URL);

			
			createMovieDB();

			System.out.println("Creating MovieDB prepareStatement");
			
			selectAllMovie = connection.prepareStatement("Select * From movie",ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			addNewMovie = connection.prepareStatement("INSERT INTO movie VALUES (?,?,?,?)");
			
			selectAllMovie();
			
			
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
		}
	}

	void createMovieDB() {
		try {
			statement = connection.createStatement();
			System.out.println("Creating Table - This will throw an exception if the table is already created.");
			statement.execute("CREATE TABLE movie (" + "id INTEGER PRIMARY KEY ," + "name VARCHAR(255)," + "rating INTEGER NOT NULL CHECK(rating BETWEEN 1 AND 10)," + "description VARCHAR(255))");
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
		}

	}

	public void close() {
		try {
			connection.close();
		} catch (SQLException sqlExeption) {
			sqlExeption.printStackTrace();
		}
	}

	@Override
	public int getRowCount() {
		return numberOfRows;
	}

	@Override
	public int getColumnCount() {
		try {
			return metadata.getColumnCount();
		} catch (SQLException sqlExeption) {
			sqlExeption.printStackTrace();
		}
		
		return 0;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		try {
			resultSet.absolute(rowIndex + 1);
			return resultSet.getObject(columnIndex + 1);
		} catch (SQLException sqlExeption) {
			sqlExeption.printStackTrace();
		}
		
		return "";
	}
	
	public String getColumnName(int columnIndex) {
		try {
			return metadata.getColumnName(columnIndex + 1);
		} catch (SQLException sqlExeption) {
			sqlExeption.printStackTrace();
		}
		
		return "";
		
	}
	
	public int addMovie(int id, String name, int rating, String desc) {
		try {
			addNewMovie.setInt(1, id);
			addNewMovie.setString(2, name);
			addNewMovie.setInt(3, rating);
			addNewMovie.setString(4, desc);
			return addNewMovie.executeUpdate();
					
		} catch (SQLException sqlExeption) {
			sqlExeption.printStackTrace();
		}
		
		return 0;
	}
	
	public void selectAllMovie() {
		try {
             this.resultSet = selectAllMovie.executeQuery();
			 this.metadata = resultSet.getMetaData();
			 this.resultSet.last();
			 this.numberOfRows = this.resultSet.getRow();
			 this.fireTableDataChanged();
			 
		} catch (SQLException sqlExeption) {
			sqlExeption.printStackTrace();
		}
		
	}
	

}
