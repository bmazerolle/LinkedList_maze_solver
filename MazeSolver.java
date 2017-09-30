/*
 * Name: Ben Mazerolle
 * ID: V00868691
 * Date: March 12, 2017
 * Filename: MazeSolver.java
 * Details: CSC 115, Spring 2017 Assignment 3
 */

import java.io.*;
import java.util.*;


public class MazeSolver {
    
	
	
	public static String findPath(Maze maze) {
      
		boolean[][] mazeArray = new boolean[(maze.getNumRows())][(maze.getNumCols())]; //Visited locations tracked using boolean array
		StackRefBased<MazeLocation> location = new StackRefBased<MazeLocation>(); //Current location is pushed onto this stack
		StackRefBased<MazeLocation> reversal = new StackRefBased<MazeLocation>(); //Used to reverse the order of the stack at the end
		String result = ""; //The string used to display the determined path
		
		try{
		
		location.push(maze.getEntry()); //Push the start location onto the stakc
		
		//The following loop runs while the stack is filled and has not found the exit
		while((location.isEmpty() != true)&&(!(location.peek()).equals(maze.getExit()))){
			
			MazeLocation cur = location.peek(); //Set the current location to be the stack's top
			mazeArray[cur.getRow()][cur.getCol()] = true; //Mark the current location as visited
			
			//Check the location above the current node to see if it is not a wall or already visited
			if(!(maze.isWall((cur.getRow()+1),cur.getCol()))&&(mazeArray[(cur.getRow())+1][cur.getCol()] == false)){
				location.push(new MazeLocation((cur.getRow()+1),cur.getCol())); //If new and open, push onto stack
			}
			//Check the location above the current node to see if it is not a wall or already visited
			else if(!(maze.isWall((cur.getRow()-1),cur.getCol()))&&(mazeArray[(cur.getRow())-1][cur.getCol()] == false)){
				location.push(new MazeLocation((cur.getRow()-1),cur.getCol()));//If new and open, push onto stack
			}
			//Check the location above the current node to see if it is not a wall or already visited
			else if(!(maze.isWall((cur.getRow()),cur.getCol()+1))&&(mazeArray[(cur.getRow())][cur.getCol()+1] == false)){
				location.push(new MazeLocation((cur.getRow()),cur.getCol()+1));//If new and open, push onto stack
			}
			//Check the location above the current node to see if it is not a wall or already visited
			else if(!(maze.isWall((cur.getRow()),cur.getCol()-1))&&(mazeArray[(cur.getRow())][cur.getCol()-1] == false)){
				location.push(new MazeLocation((cur.getRow()),cur.getCol()-1));//If new and open, push onto stack
			}else{
			//If no locations around the current are available, pop the location from the stack and restart the loop
				location.pop(); 
			}
		}
				
				if(location.isEmpty()){ 
					return ""; //If no path found, return an empty string
				}
				
				while(!location.isEmpty()){
					reversal.push((location.pop())); //Reverse the order of the filled stack
				}
				
				//The following code block prints out the contents of the reversed stack
				while(!reversal.isEmpty()){
					MazeLocation rev = reversal.pop();
					result+="("+rev.getRow()+","+rev.getCol()+")";
					if(!reversal.isEmpty())
						result+=" ";
				}
	  
		}catch(StackEmptyException s){ 
			System.out.println("StackEmptyException!");
		}
		return result;
	}
	
}
