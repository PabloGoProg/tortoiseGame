/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author jpgonzalez
 */
public class Board extends JPanel {
    
    private int tortoiseX = 368;  // mid frame cordenates
    private int tortoiseY = 268;
    private boolean pen = true;
    private BufferedImage image; //background image
    private Color backgorundColor = Color.LIGHT_GRAY; //Frame's background color
    private JLabel pencilButton;
    private Toolkit tools;
    Graphics g;
    private ArrayList<String> pencilImages;
    private ArrayList<String> tortoiseImages;
    
    private enum Direction {
        up, down, left, right
    }
    private Direction direction = Direction.up;
    
    //Display the board
    public Board() {
        this.tools = Toolkit.getDefaultToolkit();
        this.pencilImages = new ArrayList<>();
        this.tortoiseImages = new ArrayList<>();
        addImages();
        
        //set a 800px * 1000px board
        setPreferredSize(new Dimension(800, 600));
        //Creates the image that'll be used for erase method
        this.image = new BufferedImage(800, 600, BufferedImage.TYPE_INT_RGB);
        setBackgorundColor(backgorundColor);
        //Adds pencil button to the frame
        this.pencilButton = new JLabel();
    }
    
    /**
     * Deactivates the tortoise's pencil
     */
    public void pencilOut() {
        this.setPen(false);
    } 
    
    /**
     * Activates the tortoise's pencil
     */
    public void pencilIn() {
        this.setPen(true);
    }
    
    /**
     * Adds pencil and tortoise images
     */
    public void addImages() {
        this.getPencilImages().add("src/images/pencilIn");
        this.getPencilImages().add("src/images/pencilOut");
        this.getTortoiseImages().add("src/images/tortoise.png");
        this.getTortoiseImages().add("src/images/tortoiseLeft.png");
        this.getTortoiseImages().add("src/images/tortoiseDown.png");
        this.getTortoiseImages().add("src/images/tortoiseRight.png");
    }
    
    public void goRight() {
        switch (direction) {
            case up:
                this.direction = Direction.right;
                break;
            case down:
                this.direction = Direction.left;
                break;
            case left:
                this.direction = Direction.up;
                break;
            case right:
                this.direction = Direction.down;
                break;
        }
    }
    
    public void goLeft() {
        switch (direction) {
            case up:
                this.direction = Direction.left;
                break;
            case down:
                this.direction = Direction.right;
                break;
            case left:
                this.direction = Direction.down;
                break;
            case right:
                this.direction = Direction.up;
                break;
        }
    }
    
    
    
    /**
     * Cleans the board's image
     */
    public void erase() {
        //Takes the current frame 
        Graphics frame = getImage().getGraphics();
        //Erases all the lines in the current frame
        frame.setColor(getBackgorundColor());
        frame.fillRect(0, 0, this.getImage().getWidth(), this.getImage().getHeight());
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Image tortoise = getTools().getImage("src/images/tortoise.png");
        g.drawImage(tortoise, this.getTortoiseX(), this.getTortoiseY(), 64, 64, this);
    }
    
    /**
     * Draws a line between certain codenates x and y
     * @param x1
     * @param y1
     * @param x2
     * @param y2 
     */
    public void drawLine(int x1, int y1, int x2, int y2) {
        Graphics g = image.getGraphics();
        Color color = Color.BLACK;
        g.setColor(color);
        g.drawLine(x1, y1, x2, y2);
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
     * @return the backgorundColor
     */
    public Color getBackgorundColor() {
        return backgorundColor;
    }

    /**
     * @param backgorundColor the backgorundColor to set
     */
    public void setBackgorundColor(Color backgorundColor) {
        this.backgorundColor = backgorundColor;
    }

    /**
     * @return the pencilButton
     */
    public JLabel getPencilButton() {
        return pencilButton;
    }

    /**
     * @param pencilButton the pencilButton to set
     */
    public void setPencilButton(JLabel pencilButton) {
        this.pencilButton = pencilButton;
    }

    /**
     * @return the pencilImages
     */
    public ArrayList<String> getPencilImages() {
        return pencilImages;
    }

    /**
     * @param pencilImages the pencilImages to set
     */
    public void setPencilImages(ArrayList<String> pencilImages) {
        this.pencilImages = pencilImages;
    }

    /**
     * @return the tortoiseImages
     */
    public ArrayList<String> getTortoiseImages() {
        return tortoiseImages;
    }

    /**
     * @param tortoiseImages the tortoiseImages to set
     */
    public void setTortoiseImages(ArrayList<String> tortoiseImages) {
        this.tortoiseImages = tortoiseImages;
    }

    /**
     * @return the tools
     */
    public Toolkit getTools() {
        return tools;
    }

    /**
     * @param tools the tools to set
     */
    public void setTools(Toolkit tools) {
        this.tools = tools;
    }
}
