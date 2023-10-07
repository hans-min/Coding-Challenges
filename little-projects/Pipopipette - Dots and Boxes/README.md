# Pipopipette
The game Dot for 2 human players in Java (the programming language)

Created without using graphics (IHM)
                                                                                                 

Tableau.java: create the interface of the game and calculate the number of possible moves (rows and columns are numbered so you can choose your move easily)
                                                                                               
Move.java : here's how it works: Game starts with player 1 choosing a move
-> If the move is valid, the move will be made on the table (either a '-' if the row is even, a '|' if the row is odd), replacing the space. Then change turn to player 2.
-> When a player fill the square , they gain a point and continue to choose the next move. The game will announce the score of both player each time someone gains a point. 
-> And lastly, announce the winner !

Pipopipette.java : the main file (compile the 2 files above, then compile and run this file to play the game)
