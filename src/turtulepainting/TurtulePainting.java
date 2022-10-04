/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package turtulepainting;

import javax.swing.JFrame;
import javax.swing.WindowConstants;
import models.Board;

/**
 *
 * @author jpgonzalez
 */
public class TurtulePainting {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Board myTest = new Board();
        JFrame display = new JFrame("Turtle Painting Game");
        
        display.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        display.getContentPane().add(myTest);
        display.pack();
        display.setVisible(true);
    }
    
}
