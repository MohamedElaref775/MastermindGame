package com.mycompany.oopgamemain;

abstract class Player { // the base class for Players 
    protected final String name; // it protected to allows subclasses to access it
    
    public Player(String name){
        this.name = name; // Initialize the player's name
    }
    
}
