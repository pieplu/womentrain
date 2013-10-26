import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.RestoreAction;

public class Solution {
	
	
	static double timeAll;
	static double timeDec;
    
	public static void acceleration()
	{
		
		float dt = 0.01f;     		// frequence d'echantillonage en secondes
		float accel = 0.75f; 		// m/s²
		double speed = 0.0;         // m/s
		double position = 0.0;      // m
		double time;
		
		double rest_position = 100000;
	 
			for (time = 0.0; deceleration(speed, rest_position) >= 0; time += dt)   
				{
					
					position += (accel * dt * dt / 2.0) + speed * dt;
					rest_position -= (accel * dt * dt / 2.0) + speed * dt;
					if (speed < 25){
						speed += accel * dt;
				}
					//System.out.println("-----\t" + time + " | " + speed + " | " + position);
					
					
				}
			
			timeAll = time + timeDec;
		
	}
	
	
	public static double deceleration(double speed, double rest_position)
	{
		
		float dt = 0.01f;     // frequence d'echantillonage en secondes
		float decel = 1.05555555555555556f; // m/s²

		double temps;
		
			for (temps = 0.0; speed >= 0; temps += dt)   // Termine au bout de 2.5 secondes
				{
					//System.out.println( "*****\t" + time + "-" + speed + "-" + rest_position);
					rest_position -= (decel * dt * dt / 2.0) + speed * dt;
					speed -= decel * dt;
				}		
			timeDec = temps;
		return rest_position;
		
	}
	
	public static void main(String[] args) {
		
		int temps_depard = 0;
		int temps_arrive = 0;
		
		int nbr_train = 0;
		int nbr_sections = 0;
		
		acceleration();

		System.out.println(timeAll);
		
		output(temps_depard, temps_arrive, nbr_train, nbr_sections);
		System.out.println("x");
		
		
		
        
    }


	/**
	 * @param temps_depard
	 * @param temps_arrive
	 * @param nbr_train
	 * @param nbr_sections
	 */
	private static void output(int temps_depard, int temps_arrive, int nbr_train, int nbr_sections) {
		for (int i = 0;i < nbr_sections; i++)
		{
			System.out.println("***** -");
			
			for (int j= 0;j < nbr_train; j++)
			{
				System.out.println("\t" + temps_depard + "\t" + temps_arrive + " -");
				
			}
			
			System.out.println("*****\n");
			
		}
	}
}