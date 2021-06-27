package core;
public class Model {
    private View v;
    private int joueurId;
    private int compteur;
    private char[][] caseJeu;
    private String text;


    public Model() {
        this.caseJeu = new char[10][10];
        this.compteur = 100;
        this.joueurId = 1;
    }


    public void registerView(View v) {
        this.v = v;
    }


    public int getjoueurId() {
        return joueurId;
    }

    public void setjoueurId(int joueurId) {
        this.joueurId = joueurId;
    }

    public int getcompteur() {
        return compteur;
    }

    public void setcompteur(int compteur) {
        this.compteur = compteur;
    }

    public String gettext() {
        return text;
    }

    public void settext(String text) {
        this.text = text;
    }


    public void deplacement(int x, int y) {

        if(getcompteur() > 0){
            if(joueurId%2 != 0)
                caseJeu[x][y] = 'X';
            else
                caseJeu[x][y] = 'O';


            setcompteur(--compteur);

            if(checkGagnant(x, y)) {
                settext("le joueur " + joueurId + " est le gagnant!");
                v.checkGagnant(x, y, caseJeu[x][y], gettext());
            }
            else if(getcompteur()==0) {
                settext("il n'y a pas de gagnant dans le jeu ,le jeu est nul");
                v.checkGagnant(x, y, caseJeu[x][y], gettext());
            }
            else {
                if(joueurId%2 != 0) {

                    setjoueurId(2);
                    settext("O turn ");
                }
                else {
                    setjoueurId(1);
                    settext("X  turn ");

                }

                v.update(x, y, caseJeu[x][y], gettext());
            }

        }

    }


    public boolean checkGagnant(int x, int y) {
        int cligne = 0;
        int Colonne = 0;
        int compteur1 = 0;
        int compteur2 = 0;
        int compteur3 = 0;
        int compteur4 = 0;
        int compteur5 = 0;
        int compteur6 = 0;
        int compteur7 = 0;
        int compteur8 = 0;
        int compteur9 = 0;
        int compteur10 = 0;
        int compteur11 = 0;
        int compteur12 = 0;
        int compteur13 = 0;
        int compteur14 = 0;
        int compteur15 = 0;
        int compteur16 = 0;
        int compteur17 = 0;
        int compteur18 = 0;
        int compteur19 = 0;
        int compteur20 = 0;
        int compteur21 = 0;
        int compteur22 = 0;
        char pions;
        if(getjoueurId() %2 !=0){
            pions = 'X';
        }
        else {
            pions = 'O';
        }
        for(int i=0; i<caseJeu.length;i++) {

            if(caseJeu[x][i] == pions)
                cligne++;
            if(caseJeu[i][y] == pions)
                Colonne++;
            if(caseJeu[i][i] == pions)
                compteur2++;
            if(caseJeu[10-1-i][i] == pions)
                compteur1++;
            //facon de gagner en haut de la diagonale principale
            if(i<9) {
                if (caseJeu[9-1-i][9 - i] == pions) {
                    compteur3++;
                }
            }
            if(i<8) {
                if (caseJeu[8-1-i][9  - i] == pions) {
                    compteur4++;
                }
            }
            if(i<7) {
                if (caseJeu[7-1-i][9  - i] == pions) {
                    compteur5++;
                }
            }
            if(i<6) {
                if (caseJeu[6-1-i][9  - i] == pions) {
                    compteur6++;
                }
            }
            if(i<5) {
                if (caseJeu[5-1-i][9  - i] == pions) {
                    compteur7++;
                }
            }
            //facon de gagner en bas de la diagonale principale
            if(i<9) {
                if (caseJeu[9 - i][9-1-i] == pions) {
                    compteur8++;
                }
            }
            if(i<8) {
                if (caseJeu[9  - i][8-1-i] == pions) {
                    compteur9++;
                }
            }
            if(i<7) {
                if (caseJeu[9  - i][7-1-i] == pions) {
                    compteur10++;
                }
            }
            if(i<6) {
                if (caseJeu[9  - i][6-1-i] == pions) {
                    compteur11++;
                }
            }
            if(i<5) {
                if (caseJeu[9 - i][5-1-i] == pions) {
                    compteur12++;
                }
            }
            //facon de gagner en haut de la diagonale secondaire

            if(i<9) {
                if (caseJeu[8  - i][i] == pions) {
                    compteur14++;
                }
            }
            if(i<8) {
                if (caseJeu[7  - i][i] == pions) {
                    compteur15++;
                }
            }
            if(i<7) {
                if (caseJeu[6 - i][i] == pions) {
                    compteur16++;
                }
            }
            if(i<6) {
                if (caseJeu[5 - i][i] == pions) {
                    compteur17++;
                }
            }
            if(i<5) {
                if (caseJeu[4 - i][i] == pions) {
                    compteur13++;
                }
            }
            //facon de gagner en bas de la diagonale secondaire
            if(i<9) {
                if (caseJeu[i+1][9  - i] == pions) {
                    compteur18++;
                }
            }
            if(i<8) {
                if (caseJeu[i + 3  -1][9 - i ] == pions) {
                    compteur19++;
                }
            }
            if(i<7) {
                if (caseJeu[i + 4  -1][9 - i] == pions) {
                    compteur20++;
                }
            }
            if(i<6) {
                if (caseJeu[i + 5  -1][9 - i] == pions) {
                    compteur21++;
                }
            }
            if(i<5) {
                if (caseJeu[i + 6 -1][9 - i] == pions) {
                    compteur22++;
                }
            }



        }

        if(Colonne==5|| cligne==5
                || compteur1 == 5 || compteur2 == 5 || compteur3 == 5 || compteur4 == 5 || compteur5 == 5
                || compteur6 == 5 || compteur7 == 5 || compteur8 == 5 || compteur9 == 5 || compteur10 == 5 || compteur11 == 5 || compteur12 == 5
                || compteur13 == 5 || compteur14 == 5 || compteur15 == 5 || compteur16 == 5 || compteur17 == 5
                || compteur18 == 5 || compteur19 == 5 || compteur20 == 5 || compteur21 == 5 || compteur22 == 5)
            return true;

        return false;

    }

    public void clear() {
        compteur = 100;
        setjoueurId(1);
        settext("");
        for(int i=0; i<caseJeu.length;i++) {
            for(int j=0; j<caseJeu.length;j++) {
                caseJeu[i][j] = '\0';
            }
        }
        v.resetGrille_du_jeu();

    }

}
