import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
	
	int total_section = 100000;
	
	float acc = 2.7f;				// km/h/s
	float desc = 3.8f;				// km/h/s
	
	int max_speed = 90;				// km/h
	int taille_train = 100;			// m
	int taille_station = 150;		// m
	
	int taille_minSection = 500;	// m	

    
	public void acceleration()
	{
		
		float dt = 0.5f;     // frequence d'echantillonage en secondes
		float accel = 9.81f; // m/s²
		double speed = 0.0;        // m/s
		double position = 0.0;     // m
		double time;
	 
			for (time = 0.0; time < 2.5; time += dt)   // Termine au bout de 2.5 secondes
				{
					System.out.println("05.2 - 05.2 - 05.2");
					position += (accel * dt * dt / 2.0) + speed * dt;
					speed += accel * dt;
				}		
		
		
		}
	
	
	
	public static void main(String[] args) {
		
		int temps_depard = 0;
		int temps_arrive = 0;
		
		int nbr_train = 0;
		int nbr_sections = 0;
		
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