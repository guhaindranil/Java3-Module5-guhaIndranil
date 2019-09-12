/*
 * Application Controller Class
 */

package module5;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;


public class MovieAppController {
	
	private MovieAppView myview;
	private MovieResultSetTableModel mymodel;

	
	/*
	 * Constructor 
	 */
	public MovieAppController (MovieAppView myview, MovieResultSetTableModel mymodel) {
		this.myview = myview;
		this.mymodel = mymodel;
		this.myview.buttonAddListener(new buttonAddListener());
		this.myview.buttonRefListener(new buttonRefListener());
			
	}
	/*
	 * Action Listener For Button Insert
	 * This will add a Row to the Movie database from the Text Fields Inputs
	 * Pop Up a Successful dialog if Insert Operation is successful
	 */
	class buttonAddListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			
			if ((mymodel.addMovie(myview.getID(),myview.getMovieName(),myview.getRating(),myview.getDesc())) > 0)
			{
				JOptionPane.showMessageDialog(myview, "Row Added");
			}
		}
		
	}
	/*
	 * Action Listener for Button Refresh
	 * This will Reset the Text Fields and Refresh the table entries 
	 */

	class buttonRefListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			
			mymodel.selectAllMovie();
			myview.resetColumns();
			
		}
	
	}
}
