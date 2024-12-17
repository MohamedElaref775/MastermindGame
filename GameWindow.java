package com.mycompany.oopgamemain;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// is an extended from JFrame class , it making it a top-level GUI Window
public class GameWindow extends JFrame {
    private final Controller controller; // handles the game logic and validation
    private final JLabel attemptsLabel; // displays the number of attempts that the user made out of the max allowed attempts
    private final JTextField guessInput; // Guess input field
    private final JButton submitButton; // Submit button for guess submission
    private final JTextArea feedbackArea; // non -editable text area for displaying feedback after each guess

    public GameWindow(String title) {
        super(title); // the title of the game

        String playerName = JOptionPane.showInputDialog("Enter your name: ");
        controller = new Controller(playerName);

        // Set up main layout
        setLayout(new BorderLayout());
        
        // Game Header
        JLabel headerLabel = new JLabel("Mastermind Game", SwingConstants.CENTER);
        headerLabel.setFont(new Font("Arial", Font.BOLD, 24));
        headerLabel.setForeground(Color.WHITE);
        headerLabel.setOpaque(true);
        headerLabel.setBackground(Color.DARK_GRAY);
        headerLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        add(headerLabel, BorderLayout.NORTH);

        // Center Panel for Input and Feedback
        JPanel centerPanel = new JPanel(new BorderLayout());
        centerPanel.setBackground(Color.LIGHT_GRAY);
        
        // Input Panel
        JPanel inputPanel = new JPanel();
        inputPanel.setBackground(Color.DARK_GRAY);
        inputPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        inputPanel.setLayout(new FlowLayout());
        
        JLabel inputLabel = new JLabel("Enter 4 Characters {R, G, B, Y, O, P}:");
        inputLabel.setForeground(Color.WHITE);
        guessInput = new JTextField(10);
        submitButton = new JButton("Submit Guess");
        
        inputPanel.add(inputLabel);
        inputPanel.add(guessInput);
        inputPanel.add(submitButton);
        
        centerPanel.add(inputPanel, BorderLayout.NORTH);

        // Feedback Area
        feedbackArea = new JTextArea(15, 40);
        feedbackArea.setEditable(false);
        feedbackArea.setFont(new Font("Monospaced", Font.PLAIN, 14));
        JScrollPane scrollPane = new JScrollPane(feedbackArea);
        scrollPane.setBorder(BorderFactory.createTitledBorder("Feedback"));

        centerPanel.add(scrollPane, BorderLayout.CENTER);
        add(centerPanel, BorderLayout.CENTER);

        // Attempts Panel = displays the number of guesses made so far
        JPanel attemptsPanel = new JPanel();
        attemptsPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        attemptsPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        attemptsLabel = new JLabel("Attempts: 0 of " + controller.getMaxAttempts());
        attemptsLabel.setFont(new Font("Arial", Font.BOLD, 16));
        attemptsPanel.add(attemptsLabel);
        attemptsPanel.setBackground(Color.LIGHT_GRAY);
        add(attemptsPanel, BorderLayout.SOUTH);

        // Button Action Listener
        submitButton.addActionListener(new SubmitGuessListener());

        // Window settings
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700,700);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    // handles what happens when the user clicks the " Submit Guess" button
    private class SubmitGuessListener implements ActionListener {
        @Override // form action listener class
        public void actionPerformed(ActionEvent e) {
            String guess = guessInput.getText().toUpperCase();
            String feedback = controller.processGuess(guess);
            
            if (feedback.contains("Congratulations!")) {
                feedbackArea.setForeground(new Color(0, 128, 0)); // Green for success
            } else if (feedback.contains("Game Over!")) {
                feedbackArea.setForeground(Color.RED); // Red for game over
            } else {
                feedbackArea.setForeground(Color.BLACK); // Default color for feedback
            }
            
            feedbackArea.append(feedback + "\n");
            attemptsLabel.setText("Attempts: " + controller.getAttempts() + " of " + controller.getMaxAttempts());

            if (controller.isGameOver()) {
                JOptionPane.showMessageDialog(null, controller.getGameOverMessage(), "Game Over", JOptionPane.INFORMATION_MESSAGE);
                System.exit(0);
            }
            guessInput.setText("");
        }
    }
}
