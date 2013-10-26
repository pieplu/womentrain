import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.RestoreAction;

public class Solution {
	
	int total_section = 100000;
	
	float acc = 2.7f;				// km/h/s
	float desc = 3.8f;				// km/h/s
	
	int max_speed = 90;				// km/h
	int taille_train = 100;			// m
	int taille_station = 150;		// m
	
	int taille_minSection = 500;	// m	
	
	static double timeAll;

    
	public static void acceleration()
	{
		
		float dt = 0.0001f;     		// frequence d'echantillonage en secondes
		float accel = 2.7f; 		// m/s²
		double speed = 0.0;         // m/s
		double position = 0.0;      // m
		double time;
		
		double rest_position = 2000;
	 
			for (time = 0.0; deceleration(speed, rest_position, time) >= 0; time += dt)   // Termine au bout de 2.5 secondes
				{
					System.out.println("-----\t" + time + " | " + speed + " | " + position);
					position += (accel * dt * dt / 2.0) + speed * dt;
					if(speed < 25)
						{
						speed += accel * dt;
						}
					
					
					rest_position -= position;
					
				}
			
		
		
	}
	
	
	public static double deceleration(double speed, double rest_position, double time)
	{
		
		float dt = 0.0001f;     // frequence d'echantillonage en secondes
		float decel = 3.8f; // m/s²

		double temps;
		
			for (temps = time; speed >= 0; time += dt)   // Termine au bout de 2.5 secondes
				{
					//System.out.println( "*****\t" + time + "-" + speed + "-" + rest_position);
					rest_position -= (decel * dt * dt / 2.0) + speed * dt;
					speed -= decel * dt;
					
					
				}		
		return rest_position;
		
	}
	
	public static void main(String[] args) {
		
		int temps_depard = 0;
		int temps_arrive = 0;
		
		int nbr_train = 0;
		int nbr_sections = 0;
		
		acceleration();
		//deceleration(50, 1000);
		
		for (int i = 0;i < nbr_sections; i++)
		{
			System.out.println("***** -");
			
			for (int j= 0;j < nbr_train; j++)
			{
				System.out.println("\t" + temps_depard + "\t" + temps_arrive + " -");
				
			}
			
			System.out.println("*****\n");
			
		}
		 System.out.println("x");
		
		
		
        
    }
}