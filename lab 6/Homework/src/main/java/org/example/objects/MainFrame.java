package org.example.objects;

import javax.swing.*;

import java.awt.*;

import static javax.swing.SwingConstants.*;

import javax.swing.*;

import static java.awt.BorderLayout.*;

public class MainFrame extends JFrame {
    ConfigPanel configPanel;
    ControlPanel controlPanel;
    static  DrawingPanel canvas;

    public MainFrame() {
        super("My Drawing Application");
        init();
    }

    private void init() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        configPanel=new ConfigPanel(this);
        controlPanel=new ControlPanel(this);
        canvas = new DrawingPanel(this,ConfigPanel.getNumVertices(),ConfigPanel.getEdgeProbability());

        add(configPanel,BorderLayout.NORTH);
        add(controlPanel,BorderLayout.SOUTH);
        add(canvas, BorderLayout.CENTER);

        pack();
    }
}
