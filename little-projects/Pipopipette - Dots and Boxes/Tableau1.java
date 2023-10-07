import java.util.Scanner;

public class Tableau1{
      int longeur;                                                             
      int hauteur;
      String[][] Tableau;
      int move;
      
      public Tableau1 () {
		  Scanner sc = new Scanner(System.in);
          System.out.println("PIPOPIPETTE MODE PVP");
          System.out.println("Choisissez votre taille de jeu:");
          
	      // Creer tableau
          System.out.println("Hauteur y (2 < y < 6): ");                                                      //choisir nombre de ligne (y)
          this.hauteur = sc.nextInt();
          while (2>this.hauteur || this.hauteur>=6) {
		      System.out.print("Bah qu'est ce que je viens de dire ? Choisissez un different numero: ");
		      this.hauteur = sc.nextInt();
	          }
	          
          System.out.println("Longeur x (2 < x < 6): ");                                                      //nombre de colonne (x)
          this.longeur = sc.nextInt();
          while (2>longeur || longeur>6) {
              System.out.print("Bah qu'est ce que je viens de dire ? Choisissez un different numero: ");
	          this.longeur = sc.nextInt();
              }
              
          genereT();
          affiche();
          move = this.longeur * (this.hauteur - 1) + this.hauteur *(this.longeur -1 );
          System.out.println("Nombre de mouvements possibles: " +move); 
    }
	//AFFICHAGE
    public void affiche() {
		System.out.print(" ");
		for (int k = 0;k<this.Tableau[0].length; k++) {
			System.out.print(k);
		}
		System.out.println();
        for (int i = 0; i<this.Tableau.length; i++) {
			System.out.print(i);
			  for (int j = 0;j<this.Tableau[0].length;j++) {	
				 System.out.print(Tableau[i][j]);
            }
            System.out.println();
        }
}
     // Génère tableau
     public void genereT(){
		this.Tableau = new String[this.hauteur*2-1][this.longeur*2-1];		
		for (int i = 0; i<this.Tableau.length; i++) {
			  for (int j = 0;j<this.Tableau[0].length;j++) { 
				   if (i%2==0 && j%2==0) {
					   this.Tableau[i][j]="*";
				   }
				   else this.Tableau[i][j]=" ";
			   }
		   }
	}
}
