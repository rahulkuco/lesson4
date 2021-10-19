package view;

import javax.swing.JPanel;

import model.idemo.IRender;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.awt.Dimension;
import java.awt.BasicStroke;

public class IDemoCanvas extends JPanel{

    private IDemoPanel panel;
    private ArrayList<IRender> pictures = new ArrayList<>();
    private int selectIndex = -1;

    public IDemoCanvas(IDemoPanel panel) {
        this.panel = panel;
        setPreferredSize(new Dimension(500, 500));
        setBackground(Color.black);
    }
    
    @Override
    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);

        Graphics2D graphics2 = (Graphics2D) graphics;

        for (int i = 0; i < pictures.size(); i++) {
            IRender pic = pictures.get(i);
            pic.render(graphics2);
            if(i == selectIndex) {
                graphics2.setStroke(new BasicStroke(5));
                graphics2.setColor(Color.red);
                graphics2.draw(pic.getBoundingBox());
            }
        }
    }

    public ArrayList<IRender> getPictures() {
        return pictures;
    }

    public int getSelectIndex() {
        return selectIndex;
    }

    public void setSelectIndex(int selectIndex) {
        this.selectIndex = selectIndex;
    }
}