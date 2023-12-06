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
import java.util.ArrayList;
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
     * When called, show user notes until user wants to close
     * @param notes - Array of notes
     */
    public static void notes(String[] notes){
        boolean quit = false;
        while (quit == false) {
            int r = (int) (Math.random()* notes.length);
            mssg(notes[r]);
            System.out.println("HI LIAM");
        }
    }
    
    public static void main(String[] args) {
        Question[] questions = new Question[getLength("src/unit6studynote/Quiz.txt")];
        String[] notes = new String[getLength("src/unit6studynote/Notes.txt")];
        loadArray("src/unit6studynote/Notes.txt/");
        
        boolean quit = false;
        
        
        mssg("Welcome to the Unit 6 Study System");
        while(quit == false){
            int option = Integer.parseInt(JOptionPane.showInputDialog("Enter a option: \n1.Study Notes \n2.Quiz \n3.Quit"));
            
            if(option == 1){
                notes(notes);
            }
            else if(option == 2){
                
            }
            else if(option == 3){
                mssg("You have chosen to close the program, goodbye!");
                quit = true;
            }
            else{
                mssg("That was not an option. Please try again.");
            }
        }
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
            while(s.hasNextLine()) {
                i++;
                s.nextLine();
            }
        }catch(FileNotFoundException e) {
            System.out.println("Error" + e);
        }
        return i;
    }
    
    /**
     * When called, load an array with strings from a data file
     * @param fileName - File path of text file
     * @return - Filled array with strings
     */
    public static String[] loadArray(String fileName) {
        String[] array = new String[getLength(fileName)];
        try {
            File file = new File(fileName);
            Scanner scanner = new Scanner(file);
            for (int i = 0; i < array.length; i++) {
                array[i] = scanner.nextLine();

            }
        } catch (FileNotFoundException e) {
            System.out.println("Error: " + e);
        }
        return array;
    }
    
}
