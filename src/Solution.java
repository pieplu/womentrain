import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
	
	static double timeDec;
	static boolean pasDerreur;
	static int tabTempSection[];
	
	static int dernier=0;
	
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

	

	
	
	public static double calcVitesseChangement(int distance){
		float accel = 0.75f;
		float decel = 1.055555556f;
		return Math.sqrt(2 *distance / (1/accel + 1/decel));
	}
	
	private static double tempDeplacement(int distance) {
		float accel = 0.75f;
		float decel = 1.055555556f;
		double vitesseChangement = calcVitesseChangement(distance);
		double vmax = 25.00;
		if (vitesseChangement >= vmax){
			return distance/vmax + ((vmax/2)*(1/accel + 1/decel));
		}else{
			return vitesseChangement/accel + vitesseChangement/decel;
		}	
	}
	
	public static void calcul(int[] tailleSection, int numTrain){
		System.out.printf(numTrain + " : *****");
		int tempdepart=0;
		int pause = 1;
		int depart = 0;
		int arrive = 0;
		
		for(int i =0; i < tailleSection.length; i++){
			if (numTrain == 1 && i > 0){
				pause =121;
			}
			
			if (numTrain ==1){
				depart = tabTempSection[i+1] + arrive +pause;
			}else{
				depart = tabTempSection[i+1] + pause;
			}
			 if (arrive > depart){
				 depart = arrive + 121;
			 }
			 if (i == (tailleSection.length-1)){
				 if (arrive == (dernier+1)){
					 depart += 121;
				 }
				 
			 }
			 
			// System.out.print(" AR " + arrive + " ~| "+depart);
			 
			 
			arrive = depart + (int)Math.ceil(tempDeplacement(tailleSection[i]));
			System.out.printf(" - %5s  %5s",  depart , arrive);
			
			tabTempSection[i]=depart;
			if (i == (tailleSection.length-1)){
				tabTempSection[i+1]=arrive;
				dernier = arrive;
				
			}
		}
		
		System.out.printf(" *****\n");
		
		
	}

	
	
	
	//=============================================================================
	//==================          		MAIN  					 ==================
	//=============================================================================
	
	public static void main(String[] args) {

		int tabInput[] = input();
		verification(tabInput);
		int nbTrain= tabInput[0];
		
		int tailleSection[] = new int[tabInput.length -1];
		for(int i=1;i< tabInput.length ; i++){
			tailleSection[i-1]=tabInput[i];
		}
		
		if(pasDerreur){
			tabTempSection = new int[tailleSection.length +1];
			for(int i =0; i< tabTempSection.length; i++){
				tabTempSection[i]=0;
			}
			
			for(int i= 1;i<=nbTrain ;i++ ){
				calcul(tailleSection, i);
			}
			
		}else{
			erreur();
		}
    }


	

	private static void verification(int tabAverif[]) {
		int nTrain=tabAverif[0];
		int tailleTabAverif = tabAverif.length;
		
		
		if( nTrain > 5 || nTrain<1 || tailleTabAverif > 7){
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
		if((total != 100000)){
			pasDerreur = false;
		}
		
	}



	
}