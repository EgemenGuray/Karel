/*
 * File: CheckerboardKarel.java
 * ----------------------------
 * When you finish writing it, the CheckerboardKarel class should draw
 * a checkerboard using beepers, as described in Assignment 1.  You
 * should make sure that your program works for all of the sample
 * worlds supplied in the starter folder.
 */

import stanford.karel.*;
/*
 * Egemen Ihsan Guray
 * gurege@stanford.edu
 */
public class CheckerboardKarel extends SuperKarel {
/*
 * Karel moves and puts beeper when he can`t move 
 * he decides to where he is going to turn and then makes the pattern again
 * Postcondition:None
 * Precondition Karel made the checkboard pattern
 */
	public void run(){
		if(frontIsClear()){
			while(frontIsClear()){
				makeCheckboard();
			}
		}else{
			turnLeft();
			if(frontIsBlocked()){
				turnAround();
			}
			while(frontIsClear()){
				makeCheckboard();
			}					
		}
		if(leftIsBlocked()){
			if(rightIsBlocked()){
				pickBeeper();
			}
		}
	}
	/*
	 * Karel puts the first beeper than checks for any blockage if there is Karel checks 
	 * for blockage at the right and at the left side whichever is empty Karel moves and puts beeper s this leads to a checkboard pattern. 
	 * If there is no blockage at the front then Karel moves and makes the pattern
	 * Precondition:None
	 * Postondition:Karel made one line or one row of checkboard pattern
	 */
	private void makeCheckboard(){
		while(noBeepersPresent()){
			putBeeper();
			if(frontIsClear()){
				move();
			}else{
				karelMakeaDecision();	
			}
			if(frontIsClear()){
				move();
			}else{
				karelMakeaDecision();	
			}
		}
		
	}
	/*
	 * Karel turns left if the front is blocked if the front still 
	 * blocked than turns around and checks the other way and then moves and then turns left
	 * Precondition:Front is blocked karel can`t move
	 * Postcondition:Karel turns left and then turns left or 
	 * Karel turned right and moved then turned left
	 */
	private void makeUturn1(){
		if(frontIsBlocked()){
			turnLeft();
			if(frontIsBlocked()){
				turnAround();
			}
			if(frontIsClear()){
				for(int i = 0; i<1; i++){
					move();
				}
			}
			turnLeft();
		}
		
	}
	/*
	 * Karel turns right if the front is blocked if the front still 
	 * blocked than turns around and checks the other way and then moves and then turns left
	 * Precondition:Front is blocked karel can`t move
	 * Postcondition:Karel turned right then moves and then turned right or 
	 * Karel turned left and moved then turned right
	 */
	private void makeUturn2(){
		if(frontIsBlocked()){
			turnRight();
			if(frontIsBlocked()){
				turnAround();
			}
			if(frontIsClear()){
				for(int i = 0; i<1; i++){
					move();
				}
			}
			turnRight();
		}
	}
	/*
	 * Karel turns left and then moves then turns left if Karel is facing East 
	 * if Karel is facing east he turns right then moves and then turns again
	 * Precondition:Karel can`t move because front is blocked
	 * Post condition:Karel turned right or left depending on his facing direction
	 */
	private void karelMakeaDecision(){
		if(facingEast()){
			makeUturn1();
		}
		if(facingWest()){
			makeUturn2();
		}
	}
	
}


