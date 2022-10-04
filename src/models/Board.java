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
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.JOptionPane;

/**
 *
 * @author jpgonzalez
 */
public class Board extends JPanel implements KeyListener {
    
        private boolean pen = true;
        private int tortoiseX = 368;  // mid frame cordenates
        private int tortoiseY = 268;
        private BufferedImage image; //background image
        private Tortoise tortoise;
        private Color backgorundColor = Color.LIGHT_GRAY; //Frame's background color
        private Toolkit tools;
        private JTextField inputField = new JTextField();
        //Music
        private SClip audio = new SClip("src/Music/sound.wav");
    
    //Display the board
    public Board() {
        this.tools = Toolkit.getDefaultToolkit();
        this.tortoise = new Tortoise();
        this.add(inputField);
        
        //set a 800px * 1000px board
        setPreferredSize(new Dimension(800, 600));
        //Creates the image that'll be used for erase method
        this.image = new BufferedImage(800, 600, BufferedImage.TYPE_INT_RGB);
        setMaximumSize(new Dimension(image.getWidth(), image.getHeight()));
        setBackgorundColor(this.backgorundColor);
        
        // Sets Input's Size
        inputField.setPreferredSize(new Dimension(100,30));
        inputField.addKeyListener(this);
        audio.loop();
    }  
    
    /**
     * Prints the turtle depending on the cordenates and direction
     * @param g 
     */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Image tor = getTools().getImage(this.getTortoise().getTortoiseImages().get(this.getTortoise().getDirection()));
        g.drawImage(tor, this.getTortoiseX(), this.getTortoiseY(), 64, 64, this);
    }
    
    /**
     * Detects enter key to erase the text field content and call action method
     * @param e 
     */
    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_ENTER) {
            try {
                consoleResponse();
            } catch (InterruptedException ex) {
                Logger.getLogger(Board.class.getName()).log(Level.SEVERE, null, ex);
            }
            getInputField().setText("");
        }
    }
    
    /**
     * Selects the programs actions depending on the input
     */
    public void consoleResponse() throws InterruptedException {
        String[] temp = getInputField().getText().split(" ");
        if(getInputField().getText().equals("lv")) this.pencilIn();
        else if(getInputField().getText().equals("po")) this.pencilOut();
        else if(getInputField().getText().equals("de")) this.getTortoise().goRight();
        else if(getInputField().getText().equals("iz")) this.getTortoise().goLeft();
        else if(getInputField().getText().equals("cl")) this.erase();
        else if(temp[0].equals("ad")) {
            this.moveForeward(Integer.parseInt(temp[1]));
        }else{
            JOptionPane.showMessageDialog(this, "COMANDO INVÁLIDO");
        }
        repaint();
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
     * Cleans the board's image
     */
    public void erase() {
        //Takes the current frame 
        Graphics frame = getImage().getGraphics();
        //Erases all the lines in the current frame
        frame.setColor(getBackgorundColor());
        frame.fillRect(0, 0, this.getImage().getWidth(), this.getImage().getHeight());
    }
    
    /**
     * Draws a line between certain coordenates x and y
     * @param x1
     * @param y1
     * @param x2
     * @param y2 
     */
    public void drawLine(int x1, int y1, int x2, int y2) {
        Graphics g = getImage().getGraphics();
        Color color = Color.BLACK;
        g.setColor(color);
        g.drawLine(x1, y1, x2, y2);
    }
    
    public void moveForeward(int amount) throws InterruptedException {
        switch (tortoise.getDirection()) {
            case 0:
                for(int i = 0; i < amount; i++) {
                    if(isPen()) drawLine(tortoiseX, tortoiseY, tortoiseX, tortoiseY - 1);
                    this.setTortoiseY(this.getTortoiseY() - 1);
                    //sleep(1000);
                }
                break;
            case 2:
                for(int i = 0; i < amount; i++) {
                    if(isPen()) drawLine(tortoiseX, tortoiseY, tortoiseX, tortoiseY + 1);
                    this.setTortoiseY(this.getTortoiseY() + 1);
                    //sleep(1000);
                }
                break;
            case 3:
                for(int i = 0; i < amount; i++) {
                    if(isPen()) drawLine(tortoiseX, tortoiseY, tortoiseX - 1, tortoiseY);
                    this.setTortoiseY(this.getTortoiseX() - 1);
                    //sleep(1000);
                }
                break;
            case 1:
                for(int i = 0; i < amount; i++) {
                    if(isPen()) drawLine(tortoiseX, tortoiseY, tortoiseX + 1, tortoiseY);
                    this.setTortoiseY(this.getTortoiseX() + 1);
                    //sleep(1000);
                }
                break;
        }
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
    
    @Override
    public void keyReleased(KeyEvent e) {
        
    }
    
        @Override
    public void keyTyped(KeyEvent e) {
        
    }

    /**
     * @return the tortoise
     */
    public Tortoise getTortoise() {
        return tortoise;
    }

    /**
     * @param tortoise the tortoise to set
     */
    public void setTortoise(Tortoise tortoise) {
        this.tortoise = tortoise;
    }

    /**
     * @return the inputField
     */
    public JTextField getInputField() {
        return inputField;
    }

    /**
     * @param inputField the inputField to set
     */
    public void setInputField(JTextField inputField) {
        this.inputField = inputField;
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
}
