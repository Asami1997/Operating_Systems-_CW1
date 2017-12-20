/*
 *This class contains the implementation of the first come first serve algorithm 
 *
 */

import java.util.*;

// each object of this class represent an object

class Process{
    int wait;
    
    int arrivalTime;
    
    int bursts;
    
	int turnAround;
	
	int completionTime = 0;
	
    Process(int sub,int bur){
    	
        arrivalTime = sub;
        
        bursts = bur;
    }

}
public class Main{
	
	 
       static float averageWaitingTime;
        
       static float averageTurnAroundTime;
       
       //an array that contain n processes
       
       static Process[] processes;
       
    public static void main(String[] args){
        int wait = 0;
        
        int x=0;
       
        
		Scanner s = new Scanner(System.in);
		
		System.out.println("Enter the number of processes:");
		
		int n = s.nextInt();
		
		
		
         processes = new Process[n];
        
        //get the arrival and burst time of each process from user
        
		for(int i=0;i<n;i++){
			
			System.out.println("Enter Arrival time and bursts of "+i+"st"+" process:");
			
			int arrivalTime  = s.nextInt();
			
			int burstTime = s.nextInt();
			
			processes[i] = new Process(arrivalTime,burstTime);
			
		}
		
        for(int i=0;i<processes.length;i++){
        	
        	//completion time of the process at the current iteration
            x = x+processes[i].bursts;
            
            //adding the completion time to the process
			processes[i].completionTime = x;
	
			//calculating turn around time for the process and saving it in the assigned variable
			processes[i].turnAround = processes[i].completionTime - processes[i].arrivalTime;
			
			//getting average turn around time
			getAvgTurnAround();
			
			processes[i].wait = processes[i].turnAround - processes[i].bursts;
			
			//getting average waiting time
			getAvgWaitingTime();
			
			System.out.println("Process "+i+":");
			
			System.out.println("Arrival Time\tBurst Time\tTurnaround\tCompletion\twaiting\t");
			
			System.out.println(processes[i].arrivalTime + "\t\t" + processes[i].bursts + "\t\t" + processes[i].turnAround+"\t\t"+
			
					processes[i].completionTime+"\t\t"+processes[i].wait);
						
        }
        
		System.out.println("\n\n\nAverageTurnAroundTime :"+averageTurnAroundTime +"\n\n\nAverageWaitingTime :" + averageWaitingTime);

    }
    
    public static void getAvgTurnAround(){
    	
    	int totalTurnAroundTime = 0;
    	
   
    	for(int i = 0 ; i < processes.length ; i++){
    		
    		
    		totalTurnAroundTime += processes[i].turnAround;
    		
    	}
    	
    	averageTurnAroundTime = totalTurnAroundTime/processes.length;
    	
    	
    	
    }
    
    public static void getAvgWaitingTime(){
    	
    	int totalWaitingsTime = 0;
    	
    	for(int i = 0 ; i < processes.length ; i++){
    		
    		totalWaitingsTime += processes[i].wait;
    	}
    	
    	averageWaitingTime = totalWaitingsTime/processes.length;
    }
}