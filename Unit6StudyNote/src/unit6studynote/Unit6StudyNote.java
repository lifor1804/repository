/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
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
    
    public static void mssg(String msg){
        JOptionPane.showMessageDialog(null,msg);
    }
    
    public static void notes(String[] notes){
        boolean quit = false;
        while (quit == false) {
            int r = (int) (Math.random()* notes.length);
            mssg(notes[r]);
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
