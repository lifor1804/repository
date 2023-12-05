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
        JOptionPane.showMessageDialog(null,"");
    }
    
    public static void main(String[] args) {
        ArrayList <String> studyList = new ArrayList();
        
        boolean quit = false;
        
        try{
            File f = new File("src/unit6studynote/notes.txt");
            Scanner s = new Scanner(f);
            
            while(s.hasNextLine()){
                studyList.add(s.nextLine());
            }
            
            
        }catch(FileNotFoundException e){
            System.out.println("Error " + e);
        }
        
        while(quit != false){
            mssg("Welcome to the Unit 6 Study System");
            int option = Integer.parseInt(JOptionPane.showInputDialog("Enter a option: + \n1.Study Notes \n2.Quiz \n3.Quit"));
            
            if(option == 1){
                
            }
            else if(option == 2){
                
            }
            else if(option == 3){
                quit = true;
            }
            else{
                mssg("That was not an option. Please try again.");
            }
        }
    }
    
}
