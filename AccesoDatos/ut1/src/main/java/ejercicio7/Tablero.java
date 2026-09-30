package ejercicio7;

public class Tablero {
    private char[][] casillas = {
        {'-', '-', '-'},
        {'-', '-', '-'},
        {'-', '-', '-'}
    };

    // Comprobación directa sin bucles
    public boolean esCasillaOcupada(int x, int y) {
        return casillas[x][y] != '-';
    }

    private boolean tienenMismoSimbolo(char c1, char c2, char c3) {
        return c1 != '-' && c1 == c2 && c2 == c3;
    }

    // Termina si hay ganador O si ya no quedan huecos libres
    public boolean esPartidaFinalizada() {
        // Filas y columnas
        for (int i = 0; i < 3; i++) {
            if (tienenMismoSimbolo(casillas[i][0], casillas[i][1], casillas[i][2])){
                return true;
            } 
            if (tienenMismoSimbolo(casillas[0][i], casillas[1][i], casillas[2][i])){
                return true;
            } 
        }
        // Diagonales
        if (tienenMismoSimbolo(casillas[0][0], casillas[1][1], casillas[2][2])){
            return true;
        } 
        if (tienenMismoSimbolo(casillas[0][2], casillas[1][1], casillas[2][0])){
            return true;
        } 

        for (int i = 0; i < casillas.length; i++) {
            for (int j = 0; j < casillas[i].length; j++) {
                if (casillas[i][j] == '-') {
                    return false;
                }
            }
        }
        return true;
    }

    public char[][] getCasillas() {
        return this.casillas;
    }

    @Override
    public String toString() {
        StringBuilder tablero = new StringBuilder();
        for (int i = 0; i < casillas.length; i++) {
            for (int j = 0; j < casillas[i].length; j++) {
                tablero.append(casillas[i][j]).append(" ");
            }
            tablero.append("\n");
        }
        return tablero.toString();
    }
}