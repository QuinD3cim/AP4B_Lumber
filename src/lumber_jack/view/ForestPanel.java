package lumber_jack.view;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
//import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.event.MouseInputAdapter;
import javax.swing.plaf.DimensionUIResource;

import lumber_jack.controller.ForestController;
//import lumber_jack.controller.RessourceController;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.BorderLayout;
import java.awt.event.MouseEvent;
//import java.awt.Component;
import java.security.Policy;

public class ForestPanel extends JPanel{

    private transient ForestController controller;
    private int gridWidth = 15;
    private int gridHeight = 10;
    private int cellSize = 0;
    Dimension cellDim = null;
    Dimension panelSize;

    public ForestPanel(Dimension parentSize, ForestController controller)
    {
        this.controller = controller;
        panelSize = new Dimension((int) parentSize.getWidth()*4/5,(int) parentSize.getHeight()*4/5);
        setSize(panelSize);
        cellSize = (int) Math.min(panelSize.getWidth(),panelSize.getHeight()) / Math.max(gridWidth,gridHeight);
        cellDim = new Dimension(cellSize,cellSize);
        GridLayout grid = new GridLayout(gridHeight, gridWidth);
        this.setLayout(grid);
        //this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        this.setBackground(Color.lightGray);
        //System.out.println(gteWidth());


        //grid = new ForestGrid(getPreferredSize());
        //this.add(grid,BorderLayout.CENTER);
        createButtonGrid();
        
    }

    protected void createButtonGrid() {
            
        for (int row = 0; row < gridHeight; row++) {
            for (int col = 0; col < gridWidth; col++) {
                JLabel plotButton = new JLabel(row+";"+col);

                plotButton.setBackground(Color.gray);
                plotButton.setBorder(BorderFactory.createLineBorder(Color.black));
                plotButton.addMouseListener(new GridMouseListener(col,row));
                plotButton.setPreferredSize(cellDim);
                add(plotButton);
            }
        }
    }

    private class GridMouseListener extends MouseInputAdapter {
        private int xPos;
        private int yPos;

        public GridMouseListener(int xPos, int yPos) {
            this.xPos = xPos;
            this.yPos = yPos;
        }

        @Override
        public void mousePressed(MouseEvent e) {
            System.out.println("Mouse touched : "+xPos+ " "+yPos);
        }
    }
}

    /*
     * 
     * protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        Graphics2D g2d = (Graphics2D) g.create();
        int size = Math.min(getWidth() - 4, getHeight() - 4) / Math.max(gridWidth,gridHeight);
        cellDim = new Dimension(size,size);

        int y = (getHeight() - (size * gridHeight)) / 2;
        for (int vert = 0; vert < gridHeight; vert++) {
            int x = (getWidth() - (size * gridWidth)) / 2;
            for (int horz = 0; horz < gridWidth; horz++) {
                g.drawRect(x, y, size, size);
                x += size;
            }
            y += size;
        }
        g2d.dispose();
        
    }
     */


        

    


/*
 * private void refreshView(){
        int n = 0;
        for(Component jc : this.getComponents())
        {
            if(jc instanceof JLabel)
            {
                JLabel label = (JLabel)jc;

                n++;
            }
        }
    }
 */
