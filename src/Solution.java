import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
	
	static double timeDec;
	static double TIMEEXIT = 16.3295;
	static boolean pasDerreur;
	
	
	
	public static int[] input(){
		pasDerreur = true;
		Scanner  monclavier = new Scanner(System.in);

		String chaine_arg = monclavier.nextLine();		
		String tab[] = chaine_arg.split(" ");
		int argumentInt[] = new int[tab.length];
		
		for(int j = 0; j< argumentInt.length; j++){
			try{ argumentInt[j] = Integer.parseInt(tab[j]);
			}catch(Exception e){
				pasDerreur = false;
			}
			if (pasDerreur){argumentInt[j] = Integer.parseInt(tab[j]);	
			}
		}
		return argumentInt;	
	}
	
	
	
	public static void erreur(){
		System.out.println("ERROR");
	}
	
	
	
	//=============================================================================
	//==================  Acceleration et Decceleration   CALCUL  =================
	//=============================================================================
	
	private static void calcul( int[] tabSections) {
		for (int i=0; i<tabSections.length; i++){
			//System.out.println(tabSections[i]);
		}
		
		System.out.printf("1 : ***** -");
		for (int i=1; i<tabSections.length; i++){
			//System.out.print("\t" + (int)Math.ceil(distanceAcceleration(tabSections[i]))); // arrondi au sup
			System.out.printf("%6s %6s", 1, 1 + ((int)Math.ceil(distanceAcceleration(tabSections[i]))));
		}
		System.out.printf(" *****");
		//System.out.println("\n temps sortit station: " + TIMEEXIT);
		//System.out.println("x");
	}
    /*
	"     1"
	"     1     49 -   170    218 -   339   4328"
	"     49"
	"   170"
*/
	
	
	public static double distanceAcceleration(double distanceSection){
		float dt = 0.005f;     	// frequence d'echantillonage en secondes
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
	
	
	
	
	//=============================================================================
	//==================          		MAIN  					 ==================
	//=============================================================================
	
	public static void main(String[] args) {
		
		int temps_depard = 0;
		int temps_arrive = 0;
		int nbr_train = 0;
		int nbr_sections = 0;
		
		int sections[]= {1000,4000};
		
		int tempDepart;
		ArrayList liste1= new ArrayList();
		int tabSections[] = input();
		
		verification(tabSections);
		
		if(pasDerreur){
			calcul(tabSections);
		}else{
			erreur();
		}
		
   
    }


	
	



	private static void verification(int tabAverif[]) {
		int nTrain=tabAverif[0];
		int tailleTabAverif = tabAverif.length;
		
		
		if( nTrain > 5 || nTrain<1 || tailleTabAverif > 6){
			pasDerreur = false;
		}else{
			for (int i = 1 ; i < tailleTabAverif; i++){
				if(tabAverif[i] < 500 ){
					pasDerreur = false;
					break;
				}
			}
		}
		
		int total = 0;
		for (int i=1; i < tailleTabAverif; i++){
			total += tabAverif[i];
		}
		if((total>100000)){
			pasDerreur = false;
		}
		
	}



	private static void output(int temps_depard, int temps_arrive, int nbr_train, int nbr_sections) {
		for (int i = 0;i < nbr_sections; i++){
			System.out.println("***** -");
			
			for (int j= 0;j < nbr_train; j++){
				System.out.println("\t" + temps_depard + "\t" + temps_arrive + " -");
			}
			
			System.out.println("*****\n");
			
		}
	}
}