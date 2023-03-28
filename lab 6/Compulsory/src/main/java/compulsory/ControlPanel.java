package compulsory;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Class ControlPanel - models the bottom control panel
 * of the application
 */
public class ControlPanel extends JPanel {
    final MainFrame frame;

    //initialise the buttons
    JButton exitBtn = new JButton("Exit");
    JButton clearBtn = new JButton("Clear");
    JButton saveBtn = new JButton("Save");
    JButton loadBtn = new JButton("Load");

    public ControlPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }

    private void init() {
        // change the default layout manager (just for fun)
        setLayout(new GridLayout(1, 4));

        // add all buttons
        add(clearBtn);
        add(saveBtn);
        add(loadBtn);
        add(exitBtn);

        // configure listeners for all buttons
        clearBtn.addActionListener(this::clearCanvas);
        saveBtn.addActionListener(this::saveCanvas);
        loadBtn.addActionListener(this::loadCanvas);
        exitBtn.addActionListener(this::exitGame);
    }

    private void clearCanvas(ActionEvent e) {
        frame.canvas.graphics.setColor(Color.WHITE);
        frame.canvas.graphics.fillRect(0, 0, DrawingPanel.W, DrawingPanel.H);
        frame.canvas.repaint();
    }

    private void saveCanvas(ActionEvent e) {
        try {
            ImageIO.write(frame.canvas.image, "PNG", new File("canvas.png"));
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
    }

    private void loadCanvas(ActionEvent e) {
        try {
            BufferedImage image = ImageIO.read(new File("canvas.png"));
            frame.canvas.image = image;
            frame.canvas.graphics = image.createGraphics();
            frame.canvas.repaint();
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
    }

    private void exitGame(ActionEvent e) {
        frame.dispose();
    }

}