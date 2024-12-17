package com.mycompany.oopgamemain;
import java.util.Random;

// The class that generates the secret code
class PC extends Player{ 
    private final String secretCode; // Stores the generated code that the user needs to guess
    
    public PC(String name){
        super(name); // Call the constructor of (the Player Class) to set the (name)
        this.secretCode = generateSecretCode(); // Initialized the secret code by calling the helper method 
    }
    
    private String generateSecretCode(){ // Randomly generates a 4-character String
        // Define Array that has the allowed colors as characters
        char[] colors = {'R' , 'G' , 'B' , 'Y' , 'O' , 'P'};
        StringBuilder code = new StringBuilder();
        
        // To Generate a random 4-colors code using the colors array
        for(int i=0; i<4; i++){
            code.append(colors[(int) (Math.random() * colors.length)]); // Selects a random character and appends it to the string
        }
        return code.toString();
    }
    
    // Getter method
    public String getSecretCode(){ // To provide access to the secret code
        return secretCode; 
    }
    
}
