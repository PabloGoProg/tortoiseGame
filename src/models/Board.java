/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;

/**
 *
 * @author jpgonzalez
 */
public class Board extends JPanel {
    
    private int tortoiseX = 368;
    private int tortoiseY = 268;
    private boolean pen = true;
    private BufferedImage image;
    private Graphics g;

    //Display the board
    public Board() {
        //set a 800px * 1000px board
        setPreferredSize(new Dimension(800, 600));
        this.image = new BufferedImage(800, 600, BufferedImage.TYPE_INT_RGB);
        
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Toolkit t = Toolkit.getDefaultToolkit();
        Image tortoise = t.getImage("src/images/tortoise.png");
        g.drawImage(tortoise, 
                this.tortoiseX, 
                this.tortoiseY, 
                64, 
                64, 
                this);
    }

    /**
     * @return the tortoiseX
     */
    public int getTortoiseX() {
        return tortoiseX;
    }

    /**
     * @param tortoiseX the tortoiseX to set
     */
    public void setTortoiseX(int tortoiseX) {
        this.tortoiseX = tortoiseX;
    }

    /**
     * @return the tortoiseY
     */
    public int getTortoiseY() {
        return tortoiseY;
    }

    /**
     * @param tortoiseY the tortoiseY to set
     */
    public void setTortoiseY(int tortoiseY) {
        this.tortoiseY = tortoiseY;
    }

    /**
     * @return the pen
     */
    public boolean isPen() {
        return pen;
    }

    /**
     * @param pen the pen to set
     */
    public void setPen(boolean pen) {
        this.pen = pen;
    }

    /**
     * @return the image
     */
    public BufferedImage getImage() {
        return image;
    }

    /**
     * @param image the image to set
     */
    public void setImage(BufferedImage image) {
        this.image = image;
    }

    /**
     * @return the g
     */
    public Graphics getG() {
        return g;
    }

    /**
     * @param g the g to set
     */
    public void setG(Graphics g) {
        this.g = g;
    }
}
