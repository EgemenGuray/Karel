/*
 * File: MidpointFindingKarel.java
 * -------------------------------
 * When you finish writing it, the MidpointFindingKarel class should
 * leave a beeper on the corner closest to the center of 1st Street
 * (or either of the two central corners if 1st Street has an even
 * number of corners).  Karel can put down additional beepers as it
 * looks for the midpoint, but must pick them up again before it
 * stops.  The world may be of any size, but you are allowed to
 * assume that it is at least as tall as it is wide.
 */

import stanford.karel.*;
/*
 * Egemen Ihsan Guray
 * gurege@stanford.edu
 */

public class MidpointFindingKarel extends SuperKarel {
	/*
	 * Karel puts beepers one by one at the sides of the midpoint after a while he ends his movement at one unit left of the midpoint
	 * he turns around and moves in order to find the midpoint after that he clears the extra beepers and comes back to the midpoint
	 * Precondition:None
	 * Postcondition:Karel is at the center square on the beeper
	 */

	public void run(){
		firstMove();
		while(noBeepersPresent()){
			fundamentalMove();
		}
		midpointFinder();
		clearAndFindMidpoint();
	}
	/*
	 * Karel puts the first beeper then moves to the the other corner and then puts another beeper there and then turns around and moves one time
	 * Precondition:None
	 * PostCondition:Karel put the beeper at the left end corner then moved to the right end corner again put another beeper then turned back to the left corner
	 */
	private void firstMove(){
		putBeeper();
		if(frontIsClear()){
			move();		
			while(frontIsClear()){
				move();
			}
			putBeeper();
			turnAround();
			move();
		}
	}
	/*
	 * Karel checkes for is it an 1x1 map or not if it is not Karel moves untill he encounters with a beeper then turns around
	 * and then moves one time in order to put new beeper then puts the beeper and moves
	 * Precondition:Karel is on the last beeper on the corner
	 * Postcondition:Karel moved to the the other side and put a beeper
	 */
	private void fundamentalMove(){
		if(frontIsClear()){
			while(noBeepersPresent()){
				move();
			}
			turnAround();
			move();
			putBeeper();
			move();
		}
	}
	/*
	 * When Karel filled all row with beepers he finishes his movement at wrong place in order to prevent this 
	 * he turns around moves one time and he ends up in the midpoint
	 * Precondition:Karel filled one row with beepers and ended up at one unit left of the midpoint
	 * Postcondition:Karel turned around moved one time and ended up at the midpoint
	 */
	private void midpointFinder(){
		if(frontIsClear()){
			turnAround();
			move();
		}
	}
	/*
	 * In order to clear the extra beepers in the row Karel moves left untill he hits the wall meanwhile he picks the beepers
	 * Precondition:Karel is at the midpoint while the first row is filled with beepers
	 * Postcondition:Karel is cleared the extra beepers and then came back to the midpoint 
	 */
	private void clearance(){
		while(frontIsClear()){
			move();
			pickBeeper();
		}
	}
	/*
	 * Karel moves back to the midpoint
	 * Precondition:Karel is at the corner and one beeper has left in the middle of row
	 * Postcondition:Karel moved to the midpoint
	 */
	private void midpointFinder2(){
		turnAround();
		while(noBeepersPresent()){
			move();
		}
	}
	/*
	 * In order to clear the extra beepers in the row Karel moves left untill he hits the wall meanwhile he picks the beepers he makes this for to times because 
	 * one for the beepers at the left and the other beepers at the right
	 * Precondition:Karel is at the midpoint while the first row is filled with beepers
	 * Postcondition:Karel is cleared the extra beepers and then came back to the midpoint 
	 */
	private void clearAndFindMidpoint(){
		for(int i=0; i<2;i++){
			clearance();
			midpointFinder2();
		}
	}
}

