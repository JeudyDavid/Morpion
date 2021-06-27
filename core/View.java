package core;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;

public class View {
    private maestro maestro;
    private JFrame fenetre;
    private JButton[][] CaseJeu;
    private JButton reset;
    private JTextArea TourJoueur;

    // constructeur
    public View() {
        this.fenetre = new JFrame("Morpion");
        this.CaseJeu = new JButton[10][10];
        this.reset = new JButton("Recommencer");
        this.TourJoueur = new JTextArea();
        initialisation();
    }


    public void setActionListener(Controller c) {
        this.maestro = new maestro(c,this);
        for(int ligne = 0; ligne<10 ;ligne++) {
            for(int colonne = 0; colonne<10 ;colonne++) {

                CaseJeu[ligne][colonne].addActionListener(maestro);
            }
        }
        reset.addActionListener(maestro);
    }

    public void initialisation () {


        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fenetre.setSize(new Dimension(350, 400));
        fenetre.setResizable(false);
        fenetre.setLocationRelativeTo(null);
        JPanel jeuPanel = new JPanel(new FlowLayout());
        JPanel Grille_du_jeu = new JPanel(new GridLayout(  10,10));
        Grille_du_jeu.setBackground(new Color(200,173,127));
        jeuPanel.add(Grille_du_jeu, BorderLayout.CENTER);
        jeuPanel.setBackground(Color.BLACK);
        JPanel menu = new JPanel(new FlowLayout());
        menu.add(reset);
        menu.setBackground(Color.BLACK);
        fenetre.add(jeuPanel, BorderLayout.NORTH);
        fenetre.add(menu, BorderLayout.CENTER);
        menu.add(TourJoueur);
        TourJoueur.setText("X turn");

        for(int ligne = 0; ligne<10 ;ligne++) {
            for(int colonne = 0; colonne<10 ;colonne++) {
                CaseJeu[ligne][colonne] = new JButton();
                CaseJeu[ligne][colonne].setPreferredSize(new Dimension(30,30));
                CaseJeu[ligne][colonne].setText("");
                Grille_du_jeu.add(CaseJeu[ligne][colonne]);

            }
        }

        fenetre.setVisible(true);

    }

    public boolean TestClear(ActionEvent e) {
        if(e.getSource() == reset)
            return true;
        return false;
    }


    public ArrayList<Integer> getPosition(ActionEvent e) {
        ArrayList<Integer> position = new ArrayList<Integer>();
        for(int ligne = 0; ligne<10 ;ligne++) {
            for(int colonne = 0; colonne<10 ;colonne++) {
                if(e.getSource() == CaseJeu[ligne][colonne]) {

                    position.add(ligne);
                    position.add(colonne);
                }
            }
        }
        return position;
    }


    public void update(int ligne, int colonne, char pions, String text) {
        CaseJeu[ligne][colonne].setText(Character.toString(pions));
        CaseJeu[ligne][colonne].setEnabled(false);
        TourJoueur.setText(text);

    }

    public void checkGagnant(int ligne, int colonne, char pions, String text) {
        CaseJeu[ligne][colonne].setText(Character.toString(pions));
        CaseJeu[ligne][colonne].setEnabled(false);
        for(int i = 0; i<10 ;i++) {
            for(int j = 0; j<10 ;j++) {
                CaseJeu[i][j].setEnabled(false);
            }
        }
        TourJoueur.setText(text);

    }


    public void resetGrille_du_jeu() {
        for(int ligne = 0;ligne<10;ligne++) {
            for(int colonne = 0;colonne<10;colonne++) {
                CaseJeu[ligne][colonne].setText("");
                CaseJeu[ligne][colonne].setEnabled(true);
            }
        }
        TourJoueur.setText("X turn");
    }




}
