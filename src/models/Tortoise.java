/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 *
 * @author jpgonzalez
 */
public class Tortoise {
    
    private ArrayList<String> pencilImages;
    private ArrayList<String> tortoiseImages;
    private BufferedImage image;
    private int direction = 0;
    private Toolkit tools;

    public Tortoise() {
        tools = Toolkit.getDefaultToolkit();
        this.pencilImages = new ArrayList<>();
        this.tortoiseImages = new ArrayList<>();
        this.addImages();
    }
    /**
     * Adds all the tortoise and pencil images
     */
    public void addImages() {
        this.getPencilImages().add("src/images/pencilIn");
        this.getPencilImages().add("src/images/pencilOut");
        this.getTortoiseImages().add("src/images/tortoise.png");
        this.getTortoiseImages().add("src/images/tortoiseRight.png");
        this.getTortoiseImages().add("src/images/tortoiseDown.png");
        this.getTortoiseImages().add("src/images/tortoiseLeft.png");
    }
    
    /**
     * Defines the movement to the right
     */
    public void goRight() {
        switch (getDirection()) {
            case 0:
                this.setDirection((getDirection() + 1) % 4);
                break;
            case 2:
                this.setDirection((getDirection() + 1) % 4);
                break;
            case 3:
                this.setDirection((getDirection() + 1) % 4);
                break;
            case 1:
                this.setDirection((getDirection() + 1) % 4);
                break;
        }
    }
    
    /**
     * Defines the movement to the left
     */
    public void goLeft() {
        switch (getDirection()) {
            case 0:
                this.setDirection((getDirection() + 3) % 4);
                break;
            case 2:
                this.setDirection((getDirection() + 3) % 4);
                break;
            case 3:
                this.setDirection((getDirection() + 3) % 4);
                break;
            case 1:
                this.setDirection((getDirection() + 3) % 4);
                break;
        }
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
     * @param direction the direction to set
     */
    public void setDirection(int direction) {
        this.direction = direction;
    }
    
    /**
     * @return the direction
     */
    public int getDirection() {
        return direction;
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
