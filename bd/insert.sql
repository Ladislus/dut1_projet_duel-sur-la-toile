insert into ROLE values ('ADMIN'), ('USER');

insert into TYPEJEU VALUES (NULL, 'Score'), (NULL, 'Speed'), (NULL, 'Turn-based');

insert into JEU values (NULL, 'Mastermind', 'Le but du jeu est d\'aligner une suite de 4 pions de même couleur sur une
                        grille comptant 6 rangées et 7 colonnes. Chaque joueur dispose de 21 pions d\'une couleur (par convention,
                        en général jaune ou rouge). Tour à tour les deux joueurs placent un pion dans la colonne de leur choix, le pion
                        coulisse alors jusqu\'à la position la plus basse possible dans la dite colonne à la suite de quoi c\'est
                        à l\'adversaire de jouer. Le vainqueur est le joueur qui réalise le premier un alignement (horizontal, vertical
                        ou diagonal) consécutif d\'au moins quatre pions de sa couleur. Si, alors que toutes les cases de la grille de
                        jeu sont remplies, aucun des deux joueurs n\'a réalisé un tel alignement, la partie est déclarée nulle.', NULL, 1, 2, NULL),
                       (NULL, 'Puissance4', 'Le but du jeu est d\'aligner une suite de 4 pions de même couleur sur une grille comptant 6 rangées
                        et 7 colonnes. Chaque joueur dispose de 21 pions d\'une couleur (par convention, en général jaune ou rouge). Tour à tour
                        les deux joueurs placent un pion dans la colonne de leur choix, le pion coulisse alors jusqu\'à la position la plus basse
                        possible dans la dite colonne à la suite de quoi c\'est à l\'adversaire de jouer. Le vainqueur est le joueur qui réalise
                        le premier un alignement (horizontal, vertical ou diagonal) consécutif d\'au moins quatre pions de sa couleur. Si, alors que
                        toutes les cases de la grille de jeu sont remplies, aucun des deux joueurs n\'a réalisé un tel alignement, la partie
                        est déclarée nulle.', NULL, 1, 3, NULL);
