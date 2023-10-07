import java.util.Scanner;

public class Move {
	int ligne;
	int colonne;
	Tableau1 Tableau;
	int p = 1;                                                             // joueur 1 ou 2
	int [] joueur = new int [2];                                           // tableau contenant le point des joueurs
	
	public Move() {
		this.Tableau = new Tableau1();
		while(Tableau.move >0){                                        // quand le nombre des mouvements possibles restant > 0
    Scanner sc = new Scanner(System.in);
			
    System.out.println("C'est votre tour,joueur "+p);
    System.out.println("Choisissez la ligne de votre mouvement:");
			
    while (!Checkmove()) {                                                           // si le mouvement est validé
    this.ligne = sc.nextInt();                                                       // choose the row
	    
    while (ligne<0 || ligne>=Tableau.Tableau.length) {
		  System.out.print("Ei bien sur vous devez choisir un numero valide: ");
		  this.ligne = sc.nextInt();                                                         //choose again
    }
    System.out.println("Choisissez la colonne de votre mouvement"); 
    this.colonne =sc.nextInt();                                                            //choose the column
    while (colonne<0 || colonne>=Tableau.Tableau[0].length) {                                                        
		  System.out.print("Ei bien sur vous devez choisir un numero valide: ");
		  this.colonne = sc.nextInt();
    }
}
    write(); // remplir la position choisie avec | ou - (pour votre movement)
    Tableau.affiche(); // afficher le tableau
    Entoure(); // pour vérifier si le joueur a marqué un point òu le tour passe à l'autre joueur
    
    Tableau.move--; // le nombre de mouvement restant se diminue
    }
    declare(joueur); //declaré le gagnant
}
	
    public boolean Checkmove() {                                                        // vérifier si le mouvement choisie est validé
	    if ((this.ligne + this.colonne)%2==0) {                                    // == position du mouvement est celle d'un * ou un carré
            System.out.println ("Uh uh choisissez une autre position: ");
            return false;
	    } else if(this.Tableau.Tableau[this.ligne][this.colonne] != " ") {         // position déjà choisie
            System.out.println( "Choisissez une autre move");
            return false;
        } else {
            System.out.println( " Position valide");
            return true;
        }
    }
  public void write () {                                                            // décider s'il faut un - ou un | et le remplir
    	 if (this.ligne % 2 == 0) { 
    		 this.Tableau.Tableau[this.ligne][this.colonne] = "-";
    	 } else {
    		 this.Tableau.Tableau[this.ligne][this.colonne] = "|";
    	 }
    }
          
            
    public void Entoure () {                                                           // après un mouvement, il faut vérifier 2 cases (carrés)
         int k = joueur [p-1]+2;                                                       // pour garder la note avant le mouvement du joueur
         if (this.Tableau.Tableau[this.ligne][this.colonne] == "-") {                  // si c'est un '-'
            for (int i = this.ligne-1; i<= this.ligne+1; i++) {                        // il faudra vérifier les cases au-dessus et en dessous
                if ((i+this.colonne)%2==0 && i > 0 && i < Tableau.Tableau.length) {    // ne vérifie pas la cases contenant le - et celles qui dépassent le tableau 
                   EstEntoure(i,this.colonne);                                         // pour vérifier si un carré est rempli (avec les 3 autres côtés)
                }
            }
        } else if (this.Tableau.Tableau[this.ligne][this.colonne] == "|") { 
            for ( int j=this.colonne-1; j <= this.colonne+1;j++) {                     // si c'est un '|', vérifier les cases à gauche et à droite 
                if ((j+this.ligne)%2==0 && j >0 && j < Tableau.Tableau[0].length) {
                    EstEntoure(this.ligne,j);
                }
            }
        }
        if (k-joueur[p-1] == 2){                                                           // si le joueur ne gagne aucun point
				p = (p % 2) + 1;                                           //changer joueur
        }
    }
    
    
    public void EstEntoure (int lig, int col) {                                    // vérifier si un carré est complète pour ajouter des points
        boolean EstEntoure= true;
        for (int i =lig -1;i<= lig+1; i++)  {                                      // balayer l'entourage du carré
            for (int j=col-1;j<= col+1;j++) {
                if (((i+j)%2) != 0 && Tableau.Tableau[i][j] == " ") {
                    EstEntoure= false;
                }
            }
        }
        if (EstEntoure == true) { 
            joueur[p-1] = joueur [p-1] + 1;                                          // ajouter point
            System.out.println(" Point de joueur 1 : +"+joueur [0]);                 //chaque fois quelqu'un gagne un point, print les points des 2 joueurs
            System.out.println(" Point de joueur 2 : +"+ joueur[1]);
        }
    }
    
	
	
    public void declare (int [] joueur) {                                            //déclaré le gagnant
    	 if (joueur[0] > joueur [1]) {
    		 System.out.println("Joueur 1 a gagne!!");
    	 } else if (joueur[1] > joueur [0]) {
    		 System.out.println("Joueur 2 a gagne!!");
    	 } else {
    		 System.out.println("Le jeu se termine sur un score nul.");
    	 }
     }
}
 

