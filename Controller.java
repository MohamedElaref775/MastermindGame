package com.mycompany.oopgamemain;

class Controller { // manages the game's core logic , attempts , validation and feedback
    private final PC pc; // generates and holds the secret code that the user must guess
    private final User user; // initialized with the player's name
    private final Validator validator; // for validating guesses and generating feedback
    private final int maxAttempts = 5; // max number of guessing
    private int attempts; // track the umber of guesses made by the player
    
    public Controller(String playerName){
        this.pc = new PC("Computer");
        this.user = new User(playerName);
        this.validator = new Validator();
        this.attempts = 0;
    }
    
    
    public int getMaxAttempts(){
        return maxAttempts; // return 5
    }
    
    // Getter method
    public int getAttempts(){
        return attempts; // returnthe current number of guesses
    }
    
    public String processGuess(String guess){
        if(!isValidGuess(guess)){
            return " Invalid input! \n Please enter exactly 4 characters from {R, G, B, Y, O, P}.";
        }
        
        attempts++;
        // comapare the guess with pc's secret code and generate feedback 
        String feedback = validator.validateGuess(pc.getSecretCode(), guess);
        
        if(guess.equals(pc.getSecretCode())){
            return " Congratulations! \n You've guessed the secret code.";
        }
        
        if(attempts >= maxAttempts){
            return " Game Over! \n The secret code was: " + pc.getSecretCode();
        }
        return " Your Guess : " + guess + "\n " + "Feedback : "+ feedback;
    }
    
    public boolean isGameOver(){
        return attempts >= maxAttempts || user.isWinner(pc.getSecretCode()); 
    }
    
    public String getGameOverMessage(){
        if(user.isWinner(pc.getSecretCode())){
            return " Congratulations! \n You've guessed the secret code. \n Created by Mr.Robot Team";
        }else{
            return "Game Over! The secret code was : " + pc.getSecretCode() + "\n Created by Mr.Robot Team";
        }
    }
    
    private boolean isValidGuess(String guess){
        return guess.length() == 4 && guess.matches("[RGBYOP]{4}");
    }
    
}
