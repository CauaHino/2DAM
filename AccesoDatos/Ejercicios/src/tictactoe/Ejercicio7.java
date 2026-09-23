package tictactoe;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Ejercicio7 {
    public static void main(String[] args) {
        Tablero tablero = new Tablero();
        Scanner input = new Scanner(System.in);
        int x, y;
        boolean jugador1 = true;
        try(BufferedWriter bw = new BufferedWriter(new FileWriter("./tictactoe.txt"))) {
            bw.write(tablero.toString());
            while(!tablero.esPartidaFinalizada()){
                char simboloActual = jugador1 ? 'X' : 'O';
                System.out.println("Jugador " + simboloActual);
                System.out.print("¿En que fila quieres colocar el simbolo? (1, 2, 3)");
                x = input.nextInt() - 1;
                System.out.println("¿En que Columna quieres colocar el simbolo? (1, 2, 3)");
                y = input.nextInt() - 1;
                if(!tablero.esCasillaOcupada(x, y)){
                    tablero.getCasillas()[x][y] = simboloActual;
                    bw.write(tablero.toString() + "\n");
                } else{
                    System.out.println("¡La casilla ya está ocupada!");
                }
                jugador1 = !jugador1;
            }  
        
        } catch (IOException e) {
            e.printStackTrace();

        }

    }}
