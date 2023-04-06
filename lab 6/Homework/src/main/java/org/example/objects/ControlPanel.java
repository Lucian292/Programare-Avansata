package org.example.objects;

import org.example.objects.MainFrame;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static org.example.objects.MainFrame.canvas;

public class ControlPanel extends JPanel {
    final MainFrame frame;
    JButton exitBtn = new JButton("Exit");
    JButton loadBtn = new JButton("Load");
    JButton saveBtn = new JButton("Save");
    JButton resetBtn = new JButton("Reset");

    public ControlPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }

    private void init() {
        //change the default layout manager
        setLayout(new GridLayout(1, 5));

        //add all buttons
        add(loadBtn);
        add(saveBtn);
        add(resetBtn);
        add(exitBtn);

        loadBtn.addActionListener(e -> {
            JFileChooser fileChooser = new JFileChooser();
            int returnValue = fileChooser.showOpenDialog(frame);
            if (returnValue == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();
                // TODO: Load the game state from the selected file
                System.out.println("Loaded game state from file: " + selectedFile.getAbsolutePath());
            }
        });
        saveBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveImage();
            }
        });
        resetBtn.addActionListener(e -> {

            canvas.createBoard(0, (double) 0);
            System.out.println("Cleared the game board.");
        });
        exitBtn.addActionListener(e -> {
            int option = JOptionPane.showConfirmDialog(frame, "Are you sure you want to exit?", "Exit Game",
                    JOptionPane.YES_NO_OPTION);
            if (option == JOptionPane.YES_OPTION) {
                frame.dispose();
            }
        });
    }

    private void exitGame(ActionEvent e) {
        frame.dispose();
    }

    private void saveImage() {
        try {
            // Obțineți o referință la panoul care conține desenul
            Component content = frame.getContentPane();

            // Creează o imagine tampon pentru a desena panoul pe ea
            BufferedImage image = new BufferedImage(content.getWidth(), content.getHeight(), BufferedImage.TYPE_INT_ARGB);
            Graphics2D g2d = image.createGraphics();

            // Desenați panoul pe imaginea tampon
            content.paint(g2d);
            g2d.dispose();

            // Afișează un dialog de salvare a fișierului
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("Save As");
            fileChooser.setFileFilter(new FileNameExtensionFilter("PNG Images", "png"));

            if (fileChooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
                // Salvează imaginea în fișierul selectat
                File fileToSave = fileChooser.getSelectedFile();
                ImageIO.write(image, "png", fileToSave);
                // Salvați imaginea tampon în fișierul PNG
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}