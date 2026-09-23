package tictactoe;

public class Tablero {
 private char[][] casillas = {
 {'-', '-', '-'},
 {'-', '-', '-'},
 {'-', '-', '-'}
 };
 public boolean esCasillaOcupada(int x, int y) {
    for(int i = 0; i < casillas.length; i++) {
        for(int j = 0; j < casillas[i].length; j++) {
            if(casillas[x][y] != '-') {
                return true;
            }
        }

    }
    return false;
 }
 public boolean esPartidaFinalizada() {
    for(int i = 0; i < casillas.length; i++) {
        for(int j = 0; j < casillas[i].length; j++) {
            if(casillas[i][j] == '-') {
                return false;
            }
        }
    }
    return true;
 }
 private boolean tienenMismoSimbolo(char casilla1, char casilla2, char casilla3) {
    if(casilla1 == casilla2 && casilla2 == casilla3 && casilla1 != '-') {
        return true;
    }
    return false;
 }
public char[][] getCasillas(){
    return this.casillas;
}
 @Override
 public String toString() {
    String tablero = "";
    for(int i = 0; i < casillas.length; i++) {
        for(int j = 0; j < casillas[i].length; j++) {
            tablero += casillas[i][j] + " ";
        }
        tablero += "\n";
    }
    return tablero;
 }
}