/*
 * This Class Will Launch the Movie Interface Application
 */
package module5;

public class MovieDB {
	public static void main(String[] args) {
		//MovieQueries movie = new MovieQueries();
		
		MovieAppView movieView = new MovieAppView();
		//MovieResultSetTableModel movieModel = new MovieResultSetTableModel();
		movieView.setTitle("Movie Database Interface");
		movieView.setVisible(true);
		MovieAppController movieController = new MovieAppController(movieView,movieView.getModel());
		
	}
}
