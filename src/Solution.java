import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
	
	static double timeDec;
	static int tabTempSection[];
	
	static int dernier=0;
	
	public static int[] input(){
		Scanner  monclavier = new Scanner(System.in);	
		String tab[] = monclavier.nextLine().split(" ");
		int argumentInt[] = new int[tab.length];
		
		for(int j = 0; j< argumentInt.length; j++){
			try{ 
				argumentInt[j] = Integer.parseInt(tab[j]);
			}catch(Exception e){
				erreur();
			}
		}
		return argumentInt;	
	}
	
	
	
	public static void erreur(){
		System.out.println("ERROR");
		System.exit(0);
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

	
	

	private static boolean bonArgs(int tabAverif[]) {
		
		int nTrain=tabAverif[0];
		int tailleTabAverif = tabAverif.length;
		
		boolean bonArgs = distanceTotal(tabAverif);
		
		if( nTrain > 5 || nTrain<1 || tailleTabAverif > 7){
			bonArgs = false;
		}else{
			for (int i = 1 ; i < tailleTabAverif; i++){
				if(tabAverif[i] < 500 ){
					bonArgs = false;
					break;
				}
			}
		}
		System.out.println(bonArgs);
		return bonArgs;
	}
	
	
	/**
	 * Vérifie la distance total
	 * @param tabInput, le tableua des paramètres
	 * @return un tableau de tailles des différentes sections
	 */
	private static boolean distanceTotal(int tabAverif[]) {
		int total = 0;
		for (int i=1; i < tabAverif.length; i++){
			total += tabAverif[i];
		}
		return total == 100000;
	}
	
	//=============================================================================
	//==================          		MAIN  					 ==================
	//=============================================================================
	
	public static void main(String[] args) {

		int tabInput[] = input();
		if(!bonArgs(tabInput)){
			erreur();
		}
		int nbTrain=tabInput[0];
		int[] tailleSection = defineSections(tabInput);
		
		tabTempSection = new int[tailleSection.length +1];
		for(int i =0; i< tabTempSection.length; i++){
			tabTempSection[i]=0;
		}
			
		for(int i= 1;i<=nbTrain ;i++ ){
			calcul(tailleSection, i);
		}
			
    }



	/**
	 * Sélectione les arguments de section
	 * @param tabInput, le tableua des paramètres
	 * @return un tableau de tailles des différentes sections
	 */
	private static int[] defineSections(int[] tabInput) {
		int tailleSection[] = new int[tabInput.length -1];
		for(int i=1;i< tabInput.length ; i++){
			tailleSection[i-1]=tabInput[i];
		}
		return tailleSection;
	}


	

	



	
}
