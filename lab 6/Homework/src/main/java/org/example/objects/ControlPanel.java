package org.example.objects;

import org.example.objects.MainFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;

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
        saveBtn.addActionListener(e -> {
            JFileChooser fileChooser = new JFileChooser();
            int returnValue = fileChooser.showSaveDialog(frame);
            if (returnValue == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();
                // TODO: Save the current game state to the selected file
                System.out.println("Saved game state to file: " + selectedFile.getAbsolutePath());
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
}