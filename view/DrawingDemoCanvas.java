package view;

import javax.swing.JPanel;

import model.shapes.IShapeDraw;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.awt.Color;

public class DrawingDemoCanvas extends JPanel {

    private DrawingDemoPanel ddpanel;
    private ArrayList<IShapeDraw> shapes = new ArrayList<>();
    private int singleStepIndex = -1;

    public DrawingDemoCanvas(DrawingDemoPanel ddpanel) {
        this.ddpanel = ddpanel;
        setBackground(Color.black);
        setPreferredSize(new Dimension(500, 400));
    }
    
    @Override
    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        Graphics2D g2 = (Graphics2D) graphics; 
        
        if (singleStepIndex >= 0) {

            for (int i = 0; i <= singleStepIndex; i++) {
                if(singleStepIndex < shapes.size())
                    shapes.get(i).render(g2);
            }

        } else {   
            for (var a: shapes) {
            a.render(g2);
            } 
        }
    }

    public void incrementSingleStepIndex() {
        if(shapes.size() == 0) return;

        ++singleStepIndex;
        if (singleStepIndex == shapes.size()) {
            singleStepIndex = 0;
        }
    }

    public void setSingleStepIndex(int singleStepIndex) {
        this.singleStepIndex = singleStepIndex;
    }

    public ArrayList<IShapeDraw>getShapes(){
        return shapes;
    }
    
}
