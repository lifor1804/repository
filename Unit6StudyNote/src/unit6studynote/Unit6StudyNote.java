/*
Kyle Pasta, Micah Riddler, Liam Fortin
Friday December 1st - Wednesday December 6th 2023
Stage 3: Implementation
Code your system in stages
Code a class and test it
Code a method and test it
Write user manuals and internal documentation
Build an executable JAR so that anyone can use your program
 */
package unit6studynote;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;
import javax.swing.JOptionPane;


/**
 *
 * @author mirid1871
 */
public class Unit6StudyNote {
   
    
    /**
     * When called, output a message using JOptionPane
     * @param msg - Message to be outputted
     */
    public static void mssg(String msg){
        JOptionPane.showMessageDialog(null,msg);
    }
    
    /**
     * When called, return the size of a data file
     * @param file - File path for text file
     * @return - Size of the data file
     */
    public static int getLength(String file) {
        int i = 0;
        try {
            File f = new File(file);
            Scanner s = new Scanner(f);
            //Keep looping until the data does not have another line
            while(s.hasNextLine()) {
                //Increase the counter each loop
                i++;
                s.nextLine();
            }
        }catch(FileNotFoundException e) {
            System.out.println("Error" + e);
        }
        //Return the size of the data file
        return i;
    }
    
    /**
     * When called, show user notes until user wants to close
     * @param notes - Array of notes
     */
    public static void displayNotes(String[] notes){
        boolean quit = false;
        int input;
        int count = 0;
        //While the user has not chosen to quit the program or the end of the notes have been reached, keep looping
        while (quit == false && count < notes.length) {
            
            //Display the notes and ask user if they want to continue
            input = JOptionPane.showConfirmDialog(null, "" + notes [count] + "\nDo you want to continue?","Notes", JOptionPane.YES_NO_OPTION);
            count++;
            
            //If they select yes keep looping
            if (input == 0) {
                quit = false;
            } 
            //If they select no stop looping
            else {
                quit = true;
            }
            
        }
    }
    
    /**
     * When called, parse a string into an integer
     * @param sNum - String to be converted
     * @return - Converted string to an int
     */
    public static int parseInt (String sNum) {
        int num; {
        try {
            num = Integer.parseInt(sNum);
        } catch (NumberFormatException e) {
            num = 0;
        }
        return num;
    }
    }
    
    /**
     * When called, create a 10 question multiple choice quiz to study with
     * @param answers - Array loaded with both questions and answers
     */
    public static void displayQuiz (Question [] answers) {
        String output;
        boolean quit = false;
        int correctNum = 0;
        //Keep looping until user quits or they have done the entire quiz
        for (int i = 0; i < answers.length - 1; i++) {
            output = "";
            output += answers [i].getQuestion();
            //Declare a random position for the correct answer to be
            int r = (int) (Math.random() * 2);
            //Declare a random incorrect answer to be added
            int e = (int) (Math.random() * answers.length - 1 );
            //Keep looping until the other answer is not the same as the correct answer
            while (e == i) {
                e = (int) (Math.random() * answers.length - 1 );
            }
            //If the random position is 1, put the correct answer in the #1 spot.
            if (r == 1) {
                output += "\n1." + answers [i].getAnswer();
                output += "\n2." + answers [e].getAnswer();
                correctNum = 1;
                
            } 
            //If it's 2 put it in the second spot.
            else {
                output += "\n1." + answers [e].getAnswer();
                output += "\n2." + answers [i].getAnswer();
                correctNum = 2;
            }
            //Let user know how to quit the quiz.
            output += "\nEnter \"Quit\" to exit the quiz.";
            
            //Ask user for their answer to the question
            String answer = JOptionPane.showInputDialog(output);
            //If user gets it correct, display a message telling them they're correct
            if (answer.equalsIgnoreCase(answers [i].getAnswer()) || parseInt(answer) == correctNum) {
                mssg("Correct!");
            } 
            //If user chooses to quit, end the loop
            else if (answer.equalsIgnoreCase("Quit")) {
                i = answers.length;
            } 
            //If it is not correct, display message and let user know it's incorrect
            else {
                mssg("Incorrect!\nThe correct answer was: " + answers [i].getAnswer());
            }
            
        }
    }
    
    /**
     * When called, load an array with strings from a data file
     * @param fileName - File path of text file
     * @return - Filled array with strings
     */
    public static String[] loadArray(String fileName) {
        //Declare an array with the length of the data file
        String[] array = new String[getLength(fileName)];
        try {
            File file = new File(fileName);
            Scanner scanner = new Scanner(file);
            //Load information from data file into array
            for (int i = 0; i < array.length; i++) {
                array[i] = scanner.nextLine();

            }
        } catch (FileNotFoundException e) {
            //Display error message if an error occurs
            System.out.println("Error: " + e);
        }
        return array;
    }
    
    /**
     * When called load an array of questions
     * @param answers - Array of answers
     * @param questions - Array of questions
     * @return - Filled array with questions and answers
     */
    public static Question[] loadQuestion(String[] answers, String[] questions) {
        //Declare the length of the array
        Question[] questionsAnswers = new Question[answers.length];
        //Load up the array with questions and answers
        for (int i = 0; i < questions.length; i++) {
            questionsAnswers[i] = new Question(questions[i], answers[i]);
        }
        //Return filled array
        return questionsAnswers;
    }
    
    public static void main(String[] args) {
        String[] questions = loadArray("src/unit6studynote/Questions.txt/");
        String[] answers = loadArray("src/unit6studynote/Answers.txt/");
        Question[] questionsAnswers = loadQuestion(questions, answers);
        String[] notes = loadArray("src/unit6studynote/Notes.txt/");
        
        boolean quit = false;
        
        //Greet user with message
        mssg("Welcome to the Unit 6 Study System");
        //While user has not chosen to close the program, keep looping
        while(quit == false){
            //Prompt user to select one of three options
            int option = parseInt(JOptionPane.showInputDialog("Enter a option: \n1.Study Notes \n2.Quiz \n3.Quit"));
            
            //If user selects to see the notes, call the displayNotes method
            if(option == 1){
                displayNotes(notes);
            }
            //If user selects to do the quiz, call the displayQuiz method
            else if(option == 2){
                displayQuiz(questionsAnswers);
            }
            //If user selects to quit the program, quit the program.
            else if(option == 3){
                mssg("You have chosen to close the program, goodbye!");
                quit = true;
            }
            //If user did not enter a valid input, display an error message
            else{
                mssg("That was not an option. Please try again.");
            }
        }
    }
    
    
    
    
}

