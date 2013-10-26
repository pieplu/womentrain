import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
	
	static double timeDec;
	static double TIMEEXIT = 16.3295;
    
	public static double distanceAcceleration(double distanceSection){
		float dt = 0.0005f;     	// frequence d'echantillonage en secondes
		float accel = 0.75f; 		// m/s²
		double speed = 0.0;         // m/s
		//double position = 0.0;      // m
		double time;
		double distTemp;
		double rest_position = distanceSection;
		
		
			for (time = 0.0; distanceDecceleration(speed, rest_position) >= 0; time += dt){
				distTemp = (accel * dt * dt / 2.00) + speed * dt;
				//position += distTemp;
				rest_position -= distTemp;
				if (speed < 25){
					speed += accel * dt;
				}
				//System.out.println("-----\t" + time + " | " + speed + " | " + position);
			}
		return time + timeDec;
	}
	
	
	public static double distanceDecceleration(double speed, double rest_position){
		float dt = 0.5f;     	// frequence d'echantillonage en secondes
		float decel = 1.05556f; // m/s²
		double restPourDt = rest_position;
		double temps;
		
		for (temps = 0.0; speed >= 0; temps += dt){
			if(restPourDt<1000){dt = 0.005f;
			}else if(restPourDt<500){dt= 0.0005f;
			}else if(restPourDt<200){dt = 0.000005f;
			}
			//System.out.println( "*****\t" + time + "-" + speed + "-" + rest_position);
			rest_position -= (decel * dt * dt / 2.00) + speed * dt;
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
		
		int sections[]= {1000,4000};
		
		int tempDepart;
		ArrayList liste1= new ArrayList();
		
		for (int i=0; i<sections.length; i++){
			System.out.print("\t" + distanceAcceleration(sections[i]));
		}
		
		
		System.out.println(distanceAcceleration(100000));
		System.out.println(TIMEEXIT);
		
		output(temps_depard, temps_arrive, nbr_train, nbr_sections);
		System.out.println("x");
		
		
		
        
    }


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