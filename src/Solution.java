import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
	
	int total_section = 100000;
	
	float acc = 2.7;				// km/h/s
	float desc = 3.8;				// km/h/s
	
	int max_speed = 90;				// km/h
	int taille_train = 100;			// m
	int taille_station = 150		// m
	
	int taille_minSection = 500;	// m	

    
	public void acceleration()
	{
		
		const double dt = 0.5;     // frequence d'echantillonage en secondes
		const double accel = 9.81; // m/s²
		double speed = 0.0;        // m/s
		double position = 0.0;     // m
		double time;
	 
			for (time = 0.0; time < 2.5; time += dt)   // Termine au bout de 2.5 secondes
				{
					printf("%05.2f - %05.2f - %05.2f\n", time, speed, position);
					position += (accel * dt * dt / 2.0) + speed * dt;
					speed += accel * dt;
				}		
		
			return lalala;
		}
	
	
	
	public static void main(String[] args) {
        
    }
}