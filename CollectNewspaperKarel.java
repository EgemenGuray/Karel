/*
 * File: CollectNewspaperKarel.java
 * --------------------------------
 * At present, the CollectNewspaperKarel subclass does nothing.
 * Your job in the assignment is to add the necessary code to
 * instruct Karel to walk to the door of its house, pick up the
 * newspaper (represented by a beeper, of course), and then return
 * to its initial position in the upper left corner of the house.
 */

import stanford.karel.*;
/*
 * Egemen Ihsan Guray
 * gurege@stanford.edu
 */
public class CollectNewspaperKarel extends Karel {
	/*
	 * Karel moves to newspaper picks and comes back to the initial position
	 * Precondition:None
	 * Postcondition:Karel moved to the newspaper picked and then 
	 * came back to the where he started
	 */
	public void run() {
		pickAndComeBack();
			}
		/*
		 * Karel can turn right 
		 * Precondition:None
		 * Postcondition:Karel turned right 
		 */
		private void turnRight(){
			for (int i = 0; i < 3; i++){
				turnLeft();
				}
			}
		/*
		 * Karel moves untill he hits the wall
		 * Precondition:None
		 * Postcondition:Karel moved untill he hit the wall
		 */
		private void fastMove(){
			while(frontIsClear()){
				move();
				}
			}
		/*
		 * Karel can turn around
		 * Precondition:None
		 * Postcondition:Karel turned around
		 */
		private void turnAround(){
			for (int i = 0; i < 2; i++){
				turnLeft();
				}
			}
		/*
		 * Karel goes back to the inital position by turning around and 
		 * moving till he hits the wall and if there is a wall karel turns right
		 * Precondition:Karel picked the newspaper
		 * PostCondition:Karel came back to the initial position
		 */
		private void initializeKarel(){
			turnAround();
			for(int i =0; i<2; i++){
				fastMove();
				turnRight();
				}
			}
		/*
		 * Karel goes to beeper
		 * Precondition:None
		 * PostCondition:Karel moved until he hit the wall then turned right and then 
		 * moved one step then turned left and moved in order to pick up the newspaper
		 */
		private void goToBeeper(){
			fastMove();
			turnRight();
			move();
			turnLeft();
			move();
			}
		/*
		 * Karel goes to beeper picks the beeper and 
		 * comes back to the initial position
		 * Precondition:None
		 * Postcondition:Karel moved untill he hit the wall turned right moved then turned left and 
		 * moved then picked up the newspaper and then Karel came back to the initial position
		 */
		private void pickAndComeBack(){
			goToBeeper();
			pickBeeper();
			initializeKarel();
			}
		}