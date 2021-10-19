package view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import controller.IDemoEventListener;
import model.idemo.Airplane;
import model.idemo.Bird;
import model.idemo.Dog;
import model.idemo.IRender;
import model.idemo.car;
import model.images.ImageStore;

public class IDemoPanel {

    private JFrame window;
    private JButton quitButton = new JButton("Quit");
    private IDemoCanvas canvas;

    public IDemoPanel(JFrame window) {
        this.window = window;
    }
    
    public void init() {
        Container cp = window.getContentPane();

        canvas = new IDemoCanvas(this);

        JPanel southPanel = new JPanel();
        southPanel.add(quitButton);

        cp.add(BorderLayout.CENTER, canvas);
        cp.add(BorderLayout.SOUTH, southPanel);

        populatePictures();

        IDemoEventListener listener = new IDemoEventListener(this);
        canvas.addMouseListener(listener);
        canvas.addKeyListener(listener);
        canvas.requestFocusInWindow();
        canvas.setFocusable(true);

        quitButton.setFocusable(false);

        quitButton.addActionListener(listener);
    }

    private void populatePictures() {
        ArrayList<IRender> pics = canvas.getPictures();
        car c1 = new car(50, 50, "Ford", 9000, "SUV");
        pics.add(c1);
        c1.setImage(ImageStore.car);
        var v1 = new Airplane(150, 50, "Boeing", 1200000, 350);
        pics.add(v1);
        v1.setImage(ImageStore.airplane);
        var v2 = new Bird(150, 150, "Eagle", 5, 10);
        pics.add(v2);
        v2.setImage(ImageStore.bird);
        var v3 = new Dog(50, 150, "Bulldog", 3, "white");
        pics.add(v3);
        v3.setImage(ImageStore.dog);
    }

    public IDemoCanvas getCanvas() {
        return canvas;
    }

    public JButton getQuitButton() {
        return quitButton;
    }

    public JFrame getWindow() {
        return window;
    }
}
