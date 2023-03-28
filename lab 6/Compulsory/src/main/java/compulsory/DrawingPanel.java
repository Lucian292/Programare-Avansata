package compulsory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

/**
 * Class DrawingPanel - models the drawing panel of the application
 */
public class DrawingPanel extends JPanel {
    static final int W = 800;
    static final int H = 600;
    final MainFrame frame;
    BufferedImage image; //the offscreen image
    Graphics2D graphics; //the tools needed to draw in the image
    private int numVertices;
    private double edgeProbability;
    private int[] x;
    private int[] y;

    public DrawingPanel(MainFrame frame) {
        this.frame = frame;
        createOffscreenImage();
        initPanel();
        createBoard();
    }

    private void initPanel() {
        setPreferredSize(new Dimension(W, H));
        setBorder(BorderFactory.createEtchedBorder());
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                int mouseX = e.getX();
                int mouseY = e.getY();
                int clickedVertex = -1; // no vertex clicked by default
                for (int i = 0; i < numVertices; i++) {
                    int dx = mouseX - x[i];
                    int dy = mouseY - y[i];
                    if (dx * dx + dy * dy < 100) { // check if within 10 pixels of vertex
                        clickedVertex = i;
                        break;
                    }
                }
                if (clickedVertex >= 0) {
                    graphics.setColor(Color.RED);
                    graphics.fillOval(x[clickedVertex] - 10, y[clickedVertex] - 10, 20, 20);
                    repaint();
                }
            }
        });
    }

    private void createOffscreenImage() {
        image = new BufferedImage(W, H, BufferedImage.TYPE_INT_ARGB);
        graphics = image.createGraphics();
        graphics.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        graphics.setColor(Color.WHITE);
        graphics.fillRect(0, 0, 800, 600);
    }

    final void createBoard() {
        frame.configPanel = new ConfigPanel(frame);
        numVertices = (Integer) frame.configPanel.dotsSpinner.getValue();
        edgeProbability = (Double) frame.configPanel.linesCombo.getSelectedItem();
        createOffscreenImage();
        createVertices();
        drawLines();
        drawVertices();
        repaint();
    }

    private void createVertices() {
        int x0 = W / 2;
        int y0 = H / 2; //middle of the board
        int radius = H / 2 - 10; //board radius
        double alpha = 2 * Math.PI / numVertices; // the angle
        x = new int[numVertices];
        y = new int[numVertices];
        for (int i = 0; i < numVertices; i++) {
            x[i] = x0 + (int) (radius * Math.cos(alpha * i));
            y[i] = y0 + (int) (radius * Math.sin(alpha * i));
        }
    }

    private void drawLines() {
        for (int i = 0; i < numVertices; i++) {
            for (int j = i + 1; j < numVertices; j++) {
                if (Math.random() < edgeProbability) {
                    graphics.setColor(Color.BLACK);
                    graphics.drawLine(x[i], y[i], x[j], y[j]);
                }
            }
        }
    }

    private void drawVertices() {
        for (int i = 0; i < numVertices; i++) {
            int size = 10;
            int fontSize = 20;
            graphics.setColor(Color.BLACK);
            graphics.fillOval(x[i] - size / 2, y[i] - size / 2, size, size);
            graphics.setFont(new Font("Arial", Font.PLAIN, fontSize));
            //comentat ca sa nu apara cifrele in desen
            //graphics.drawString(String.valueOf(i + 1), x[i] - size / 4, y[i] + size / 4);
        }
    }

    @Override
    public void update(Graphics g) {
        //No need for update
    }

    //Draw the offscreen image, using the original graphics
    @Override
    protected void paintComponent(Graphics graphics) {
        graphics.drawImage(image, 0, 0, this);
    }
}