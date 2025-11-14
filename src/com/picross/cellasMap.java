package com.picross;

import java.util.Random;

public class cellasMap {
    cella[][] cellas;

    public cellasMap(int width, int height, int maxDark) {
        this.cellas = new cella[width][height];
        Random random = new Random();

        // Inizializza tutte le celle come false (non scure)
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                cellas[i][j] = new cella(false);
            }
        }

        // Posiziona esattamente maxDark celle nere casualmente
        while (maxDark > 0) {
            int i = random.nextInt(width);
            int j = random.nextInt(height);

            if (!cellas[i][j].isDark()) {
                cellas[i][j] = new cella(true);
                maxDark--;
            }
        }
    }

    public int contaDarkRighe(int riga){
        int conta = 0;
        for (int i = 0; i< cellas.length; i++){
            if (!cellas[i][riga].isPressato() && cellas[i][riga].isDark()){
                conta++;
            }
        }
        return conta;
    }

    public int contaDarkColonne(int colonna){
        int conta = 0;
        for (int i = 0; i< cellas.length; i++){
            if (!cellas[colonna][i].isPressato() && cellas[colonna][i].isDark()){
                conta++;
            }
        }
        return conta;
    }

    public cella getCella(int riga, int colonna){
        return cellas[riga][colonna];
    }

    public boolean isVerificato(){
        for (int i = 0; i< cellas.length; i++){
            for (int j = 0; j< cellas[i].length; j++){
                if (cellas[i][j].isPressato() != cellas[i][j].isDark()){
                    return false;
                }
            }
        }
        return true;
    }

}