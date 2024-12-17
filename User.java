package com.mycompany.oopgamemain;
import java.util.Scanner;

class User extends Player{ // the class that make the player guess the secret code
    private boolean winner;
    
    public User(String name){
        super(name); // Call the constructor of (The Player Class) to set the (name)
        this.winner = false;
    }
    
    //Geter method
    public boolean isWinner(String secretCode){
        return winner;
    }
    // Setter method
    public void setWinner(boolean winner){
        this.winner = winner;
    }
}
