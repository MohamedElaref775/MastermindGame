package com.mycompany.oopgamemain;


class Validator { // Validates the user's guess against the secret code
    public String validateGuess(String secretCode , String guess){ // Main method for comparing the secretcode and guess
        int correctPosition = 0;
        int correctDigit = 0;
        
        boolean[] usedSecret = new boolean[4]; // to track which secret code positions are matched
        boolean[] usedGuess = new boolean[4]; // to track which guess positions are matched
        
        
        // Check for correct positions
        for(int i=0; i<4; i++){
            // Compare characters in the same positions for exact matches
            if(secretCode.charAt(i) == guess.charAt(i)){
                correctPosition++;
                usedSecret[i] = true; // Mark the positions as matched in the secret code
                usedGuess[i] = true;  // Mark the positions as matched in the guess
            }
        }
        
        // check for correct colors in wrong positions
        for(int i=0; i<4; i++){
            if(usedGuess[i]){
                continue; // To Skip positions already matched
            }
            for(int j=0; j<4; j++){
                // Compares unmatched characters for partial matches
                if(!usedSecret[j] && secretCode.charAt(j) == guess.charAt(i)){
                    correctDigit++;
                    usedSecret[j] = true;// Mark the matched color in the secret code
                    break;
                }
            }
        }
        
        // return a formatted feedback about the match
        return correctPosition + " correct position(s) " + "\n          : " +correctDigit + " correct color(s) in wrong position(s)." ;
    }
}
