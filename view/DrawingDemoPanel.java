package view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import controller.ShapeDemoListener;

public class DrawingDemoPanel {
    
    private JFrame window;
    private DrawingDemoCanvas canvas;
    private JRadioButton cirButton = new JRadioButton("Circle");
    private JRadioButton recButton = new JRadioButton("Rectangle");
    private JRadioButton triButton = new JRadioButton("Triangle");

    private JRadioButton whiteColor = new JRadioButton("white");
    private JRadioButton yellowColor = new JRadioButton("yellow");
    private JRadioButton redColor = new JRadioButton("red");

    private JCheckBox filledBox = new JCheckBox("filled");

    private JRadioButton smallsize = new JRadioButton("small");
    private JRadioButton midsize = new JRadioButton("medium");
    private JRadioButton largesize = new JRadioButton("large");

    private JButton sortXButton = new JButton(" Sort by X");
    private JButton sortYButton = new JButton(" Sort by Y");
    private JButton showAllButton = new JButton(" Show All");
    private JButton showOrderButton = new JButton(" Show order");
    private JButton clearButton = new JButton(" Clear");
    private JButton exitButton = new JButton(" Exit");

    public DrawingDemoPanel(JFrame window) {
        this.window = window;
    }

    public void init() {
        Container cp = window.getContentPane();

        canvas = new DrawingDemoCanvas(this);
        cp.add(BorderLayout.CENTER, canvas);

        JPanel southPanel = new JPanel();
        cp.add(BorderLayout.SOUTH, southPanel);
        southPanel.setLayout(new GridLayout(4, 1));
        JPanel shapePanel = new JPanel();
        JPanel colorPanel = new JPanel();
        JPanel sizePanel = new JPanel();
        JPanel buttonPanel = new JPanel();
        southPanel.add(shapePanel);
        southPanel.add(colorPanel);
        southPanel.add(sizePanel);
        southPanel.add(buttonPanel);

        shapePanel.setBorder(BorderFactory.createTitledBorder("Shape"));
        shapePanel.add(cirButton);
        shapePanel.add(recButton);
        shapePanel.add(triButton);
        ButtonGroup shapeGroup = new ButtonGroup();
        shapeGroup.add(cirButton);
        shapeGroup.add(recButton);
        shapeGroup.add(triButton);
        cirButton.setSelected(true);

        colorPanel.setBorder(BorderFactory.createTitledBorder("Color"));
        colorPanel.add(whiteColor);
        colorPanel.add(yellowColor);
        colorPanel.add(redColor);
        colorPanel.add(filledBox);
        ButtonGroup ColorGroup = new ButtonGroup();
        ColorGroup.add(whiteColor);
        ColorGroup.add(yellowColor);
        ColorGroup.add(redColor);
        whiteColor.setSelected(true);

        sizePanel.setBorder(BorderFactory.createTitledBorder("size"));
        sizePanel.add(smallsize);
        sizePanel.add(midsize);
        sizePanel.add(largesize);
        ButtonGroup sizeGroup = new ButtonGroup();
        sizeGroup.add(smallsize);
        sizeGroup.add(midsize);
        sizeGroup.add(largesize);
        smallsize.setSelected(true);

        buttonPanel.setBorder(BorderFactory.createTitledBorder("Actions"));
        buttonPanel.add(sortXButton);
        buttonPanel.add(sortYButton);
        buttonPanel.add(showAllButton);
        buttonPanel.add(showOrderButton);
        buttonPanel.add(clearButton);
        buttonPanel.add(exitButton);

        ShapeDemoListener listener = new ShapeDemoListener(this);
        canvas.addMouseListener(listener);
        clearButton.addActionListener(listener);
        exitButton.addActionListener(listener);
        showOrderButton.addActionListener(listener);
        showAllButton.addActionListener(listener);
        sortXButton.addActionListener(listener);
        sortYButton.addActionListener(listener);
    }

    public JFrame getWindow() {
        return window;
    }

    public DrawingDemoCanvas getCanvas() {
        return canvas;
    }
    
    public JRadioButton getCirButton() {
        return cirButton;
    }

    public JRadioButton getRecButton() {
        return recButton;
    }

    public JRadioButton getTriButton() {
        return triButton;
    }

    public JCheckBox getFilledBox() {
        return filledBox;
    }

    public JRadioButton getSmallsize() {
        return smallsize;
    }

    public JRadioButton getMidsize() {
        return midsize;
    }

    public JRadioButton getLargesize() {
        return largesize;
    }

    public JButton getSortXButton() {
        return sortXButton;
    }

    public JButton getSortYButton() {
        return sortYButton;
    }

    public JButton getShowAllButton() {
        return showAllButton;
    }

    public JButton getShowOrderButton() {
        return showOrderButton;
    }

    public JButton getClearButton() {
        return clearButton;
    }

    public JButton getExitButton() {
        return exitButton;
    }

    public JRadioButton getWhiteColor() {
        return whiteColor;
    }

    public JRadioButton getYellowColor() {
        return yellowColor;
    }

    public JRadioButton getRedColor() {
        return redColor;
    }


}
