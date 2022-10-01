/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package turtulepainting;

import javax.swing.JFrame;
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
        JFrame display = new JFrame();
        display.getContentPane().add(myTest);
        display.pack();
        display.setVisible(true);
    }
    
}
