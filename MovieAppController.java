package module5;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MovieAppController {
	
	private MovieAppView myview;

	
	/*
	 * Constructor 
	 */
	public MovieAppController (MovieAppView myview) {
		this.myview = myview;
		this.myview.buttonAddListener(new buttonAddListener());
		
		
	}
	
	class buttonAddListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			
			myview.model.addMovie(myview.getID(),myview.getMovieName(),myview.getRating(),myview.getDesc());
				
		}
		
	}

	class buttonRefListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			
			myview.model.selectAllMovie();
			myview = new MovieAppView();
			
		}
		
	}
}
