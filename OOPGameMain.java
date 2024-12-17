package com.mycompany.oopgamemain;
import java.util.Scanner;
import javax.swing.SwingUtilities; // Provides thread-safe methods to creating GUIs

public class OOPGameMain {
    public static void main(String[] args) {
        // to implement the GUI
        SwingUtilities.invokeLater(()-> new GameWindow("Mastermind Game"));
        
    }
}
