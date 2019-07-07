/*
 * File: StoneMasonKarel.java
 * --------------------------
 * The StoneMasonKarel subclass as it appears here does nothing.
 * When you finish writing it, it should solve the "repair the quad"
 * problem from Assignment 1.  In addition to editing the program,
 * you should be sure to edit this comment so that it no longer
 * indicates that the program does nothing.
 */

import stanford.karel.*;
/*
 * Egemen Ihsan Guray
 * gurege@stanford.edu
 */
public class StoneMasonKarel extends SuperKarel {
	/*
	 * Karel checks for is it a linear map if it is reapairs the road and then comes back
	 * if it is not after he repaired first column he moves and makes this for four times
	 * after he finished the repairing he checks for outlier if the last column is outlier he erases it
	 * Precondition:None
	 * Postcondition:Karel checked for is it a linear map if it is reapaired the road and then came back
	 * if it is not after he repaired first column he moved for four times
	 * after he finished the repairing he checked for any outlier if the last column is an outlier he erased it
	 */

	public void run(){
		if(frontIsBlocked()){
			repairRoad();
		}else{
			while(frontIsClear()){
				repairRoad();
				karelMove();
			}
			karelCheckLastCoulumn();
		}
	}
	/*
	 * Karel checks is there a beeper if there is not puts beeper and then turns left 
	 * while he is moving he repairs the road when he hit the wall he turns	around and checks again 
	 * for missing part of the road if there is empty space he puts beeper
	 * when he hit the wall he turns left in order to move
	 * Precondition:None
	 * Postcondition:Karel repaired one column and then he came back to the initial position.
	 */
	private void repairRoad(){
		if(noBeepersPresent()){
			putBeeper();
		}
		if(leftIsClear()){
			turnLeft();
			while(frontIsClear()){
				move();
				if(noBeepersPresent()){
					putBeeper();
				}
			}
			turnAround();
			while(frontIsClear()){
				move();
			}
			if(frontIsBlocked()){
				turnLeft();
			}
		}
	}
	/*
	 * Since we don`t know how many columns Karel moves only if the front is clear he checks 4 times and moves for times
	 * Precondition:None
	 * PostCondition:Karel moved 4 times or he hit the wall before he moved 4 times
	 */
	private void karelMove(){
		for(int i=0; i<4; i++){
			if(frontIsClear()){
				move();
			}
		}
	}
	/*
	 * Karel makes a mistake and makes a road at the end of the so Karel earases the last road that he did 
	 * Precondition:Karel made a road at the end of the map
	 * Postcondition:Karel erased the last road and came back
	 */
	private void eraseWrongRoad(){
		turnAround();
		if(frontIsClear()){
			while(frontIsClear()){
				move();
			}
		}
		pickBeeper();
		turnLeft();
		while(frontIsClear()){			
			while(beepersPresent()){
				pickBeeper();
			}
			move();
			while(beepersPresent()){
				pickBeeper();
			}
		}
		turnAround();
		while(frontIsClear()){
			move();
		}
		turnLeft();
	}
	/*
	 * Karel moves one time back and check if there is a beeper if there he understands 
	 * that there is an error and erases the last road
	 * PostCondition:Karel made the last road(column)
	 * Precondition:Karel moved one times back and left for regression error 
	 * if there is he erased the tower if there is not he came back to the end of the map
	 */
	private void lastCheck(){
		turnAround();
		move();
		if(beepersPresent()){
			eraseWrongRoad();
		}else{
			turnAround();
			while(frontIsClear()){
				move();
			}
		}
	}
	/*
	 * Karel moves two times back and check if there is a beeper if there he understands 
	 * that there is an error and erases the last road
	 * PostCondition:Karel made the last road(column)
	 * Precondition:Karel moved two times back and left for regression error 
	 * if there is he erased the tower if there is not he came back to the end of the map
	 */
	private void lastCheck2(){
		turnAround();
		move();
		move();
		if(beepersPresent()){
			eraseWrongRoad();
		}else{
			turnAround();
			while(frontIsClear()){
				move();
			}
		}
	}
	/*
	 * Karel moves three times back and check if there is a beeper if there he understands 
	 * that there is an error and erases the last road
	 * PostCondition:Karel made the last road(column)
	 * Precondition:Karel moved three times back and left for regression error 
	 * if there is he erased the tower if there is not he came back to the end of the map
	 */
	private void lastCheck3(){
		turnAround();
		move();
		move();
		move();
		if(beepersPresent()){
			eraseWrongRoad();
		}else{
			turnAround();
			while(frontIsClear()){
				move();
			}
		}
	}
	/*
	 * Karel makes the last column since we don`t know it is an outlier for the regression or not 
	 * he moves one times back and checks is it an outlier if it is he erases the last column
	 * if it is not than comes back and then moves two times back checks again if it is an outlier than erases the column
	 * if it is not than comes back and then moves three times back checks again if it is an outlier than erases the column
	 * if it is not than comes back
	 * Postcondition:Karel is at the end of the map
	 * Precondition:Karel made the last coulumn than checked that it is an outlier or not if it is then he erased if it is not he came back to the end of the map
	 */
	private void karelCheckLastCoulumn(){
		repairRoad();
		lastCheck();
		lastCheck2();
		lastCheck3();
	}
		
	
}