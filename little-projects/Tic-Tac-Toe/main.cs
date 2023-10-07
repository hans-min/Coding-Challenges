using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading;

namespace TicTacToe
{
  class Program
  {
    static void Main(string[] args)
    {
      Dictionary<string, string> game = new Dictionary<string, string>();
      for (int i=1;i<=3;i++){   //could make a list {A,B,C} and put in a loop, too
        string a = "A"+i;
        string b= "B"+i;
        string c = "C"+i;
        game.Add(a," ");
        game.Add(b," ");
        game.Add(c," ");
      }
      List<string> locations = game.Keys.ToList();
      Console.WriteLine("\n Jeu de Tic Tac Toe\n");
      string choice;
      Random random = new Random();
      Display(game);
      while(locations.Any()){                    //==(locations.Count() != 0)
         while(true){                       //loop for valid action
          Console.Write("[Joueur] Choisir un emplacement : ");  
          choice = Console.ReadLine();
          if (locations.Contains(choice)) {
           break;
          } else {
            Console.WriteLine("[Joueur] Invalide choix.");
          }
         }
         game[choice] = "X";
         Display(game);
         if (EndGame(game,choice)){
           Console.WriteLine("Vous avez gagné ! \nTWOTEATO222");
           break;
         }
         locations.Remove(choice);
         Console.WriteLine("[IA] Je réfléchis...");
         System.Threading.Thread.Sleep(1000);
         int AIChoice = random.Next(locations.Count); 
         string ai =locations[AIChoice];
         Console.WriteLine("[IA] Je joue en {0}", ai); 
         game[ ai] = "O";
         Display(game);
         if (EndGame(game,ai)){
           Console.WriteLine("Vous avez perdu ! \nÀ un AI qui joue au hasard!!!\nBWAHAHAA");
           break;
         }
         locations.Remove( ai);
      }
     // if (!)
    }

    static void Display(Dictionary<string, string> game)
    {
      string[] liste = new string[] {"A","B","C"};
      char[] columns = new char[] {'1','2','3'};
      Console.WriteLine("   1   2   3  ");
      string sep = "+---+---+---+";
      for(int i=0; i<3; i++) {
        Console.WriteLine(" "+sep);
        Console.Write(liste[i]);
        for (int j=0;j<3;j++){
           string coord = liste[i]+columns[j];
           Console.Write("| {0} ",game[coord]);
        }
        Console.WriteLine("|");
      }
      Console.WriteLine(" "+sep+"\n");
    }

    static bool Count3Marks(Dictionary<string, string> game, string symbole,
    List<string> l)
    {
      int marksCount =0;
      foreach (string coord in l){
        if (game[coord] == symbole) { 
          marksCount++; 
        }
      }
      bool e= marksCount ==3 ? true : false;
      return e;
    }

    static bool EndGame(Dictionary<string, string> game, string choice)
    {
      string symbole = game[choice];
      List<char> columns = new List<char> {'1','2','3'};
      char[] liste = new char[] {'A','B','C'};
      char l = choice[0];
      char c = choice[1];
      List<string> line = new List<string>(3);
      List<string> col = new List<string>(3);
      for (int i=0;i<3;i++){
        line.Add(String.Concat(l,columns[i]));
        col.Add(String.Concat(liste[i],c));
      }
      
      List<string> diag1 = new  List<string>{"A1","B2","C3"} ;
      List<string> diag2 = new List<string>{"A3","B2","C1"} ;
      if (Count3Marks(game,symbole,line) || Count3Marks(game,symbole,col)||Count3Marks(game,symbole,diag1)||Count3Marks(game,symbole,diag2)) {
        return true;
      } else return false;
    } 
  }
}  
