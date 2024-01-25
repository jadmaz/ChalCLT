/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.ulaval.glo2004.gui.Panels;

import ca.ulaval.glo2004.domain.Accessoires;
import ca.ulaval.glo2004.domain.DTO.AccessoiresDTO;
import ca.ulaval.glo2004.domain.Orientation;
import ca.ulaval.glo2004.domain.drawer.chaletDrawer;
import ca.ulaval.glo2004.domain.drawer.*;
import ca.ulaval.glo2004.domain.utils.Points;
import ca.ulaval.glo2004.gui.MainWindow;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.io.Serializable;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import java.awt.event.MouseWheelListener;
import java.awt.event.MouseWheelEvent;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.AffineTransform;

/**
 *
 * @author charlescareau
 */
@SuppressWarnings("serial")
public class drawingPanel extends JPanel implements Serializable {
    
    private int gridSize = 48;
    private double zoomFactor = 1.0;
    private double baseZoomFactor = 1.0;
    private double offsetX = 0;
    private double offsetY = 0;
    private int centerX = 0;
    private int centerY = 0;

    public Dimension initialDimension;
    private MainWindow mainWindow;
    private AfficheurDessus afficheurDessus;
    private AfficheurMur afficheurMur;
    private chaletDrawer drawer;
    private chaletDrawer currentDrawer;
    private AfficheurAccessoire accdrawer;

        public void setGridSize(int newSize) {
        this.gridSize = newSize;
        // redessiner la grille si nécessaire
    }
        
    public boolean isShowingGrid() {
    return showGrid;
}
    
    private boolean showGrid = false;
    public void setShowGrid(boolean showGrid) {
    this.showGrid = showGrid;
    repaint(); 
}
    
    public double getZoomFactor() {
        return zoomFactor;
    }

    public double getOffsetX() {
        return offsetX;
    }

    public double getOffsetY() {
        return offsetY;
    }
    public drawingPanel() {
    }

    public drawingPanel(MainWindow mainWindow) {
        this.mainWindow = mainWindow;
        this.afficheurDessus = new AfficheurDessus(mainWindow);
        this.afficheurMur = new AfficheurMur(mainWindow);
        this.drawer = new AfficheurDessus(mainWindow);
        this.currentDrawer = this.afficheurDessus;
        this.accdrawer = new AfficheurAccessoire(new Accessoires(mainWindow.point, mainWindow.getItemType(), mainWindow.dimensions, mainWindow.mur_associe, false, false ));
        
        buildUp();

addMouseWheelListener(new MouseWheelListener() {
    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {
        double oldZoomFactor = zoomFactor;
        double rotation = e.getPreciseWheelRotation();
        zoomFactor *= (rotation < 0) ? 1.05 : 0.95;

        double factor = zoomFactor / oldZoomFactor;
        offsetX += (e.getX() - offsetX) * (1 - factor);
        offsetY += (e.getY() - offsetY) * (1 - factor);

        repaint();
    }
});


addMouseListener(new MouseAdapter() {
    @Override
    public void mousePressed(MouseEvent e) {

        double adjustedX = (e.getX() - getOffsetX()) / getZoomFactor();
        double adjustedY = (e.getY() - getOffsetY()) / getZoomFactor();

        Points point = Points.fromPixelsToImperial((int)adjustedX, (int)adjustedY);


        if (mainWindow.getselectmode() == MainWindow.SelectMode.ADD) {

        } else if (mainWindow.getselectmode() == MainWindow.SelectMode.SELECT) {

        }

        repaint();
    }
});

   
        
    }
    
    public void resetZoomAndView() {
        zoomFactor = 1.0;
        offsetX = 0;
        offsetY = 0;
        repaint();
    }

    private void buildUp() {
        setBorder(new javax.swing.border.BevelBorder(BevelBorder.LOWERED));
    int width = (int) (java.awt.Toolkit.getDefaultToolkit().getScreenSize().width * 0.7);
    setPreferredSize(new Dimension(width, 850));
    setVisible(true);
    int height = (int) (width * 0.6);
        initialDimension = new Dimension(width, height);
        
    }

    @Override
    protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    Graphics2D g2 = (Graphics2D) g.create();
 
    AffineTransform transform = new AffineTransform();
    transform.translate(offsetX, offsetY);
    transform.scale(zoomFactor, zoomFactor);
    g2.transform(transform);
    
    if (currentDrawer != null) {
        currentDrawer.drawDessus(g2, mainWindow.controller, initialDimension);
        currentDrawer.drawToit(g2, mainWindow.controller, initialDimension);
         if(mainWindow.controller.getMurOrientation() != Orientation.Dessus){
            List<AccessoiresDTO> accList = mainWindow.controller.getAccList();
            if (accList != null) {
                for (AccessoiresDTO acc : accList) {
                    if(mainWindow.controller.getMurOrientation() == Orientation.Droite)
                    {
                        if("droite".equals(acc.mur_associe))
                    {
 
                    accdrawer.drawAccessoire(g2, acc, mainWindow.controller, initialDimension);
                        if(!acc.is_valid)
                    {
                    accdrawer.drawBorder_v(g2, acc, mainWindow.controller, initialDimension);
                    }
                        if(acc.is_selected)
 
                    accdrawer.drawAccessoire(g2, acc, mainWindow.controller, initialDimension);
                                        if(acc.is_selected)
 
                    {
                    accdrawer.drawBorder(g2, acc, mainWindow.controller, initialDimension);
                    }
                    }
                    }
 
                    if(mainWindow.controller.getMurOrientation() == Orientation.Gauche)
                    {
                        if("gauche".equals(acc.mur_associe))
                    {
 
                    accdrawer.drawAccessoire(g2, acc, mainWindow.controller, initialDimension);
                        if(!acc.is_valid)
                    {
                    accdrawer.drawBorder_v(g2, acc, mainWindow.controller, initialDimension);
                    }

                        if(acc.is_selected)
 
                    accdrawer.drawAccessoire(g2, acc, mainWindow.controller, initialDimension);
                                        if(acc.is_selected)
 
                    {
                    accdrawer.drawBorder(g2, acc, mainWindow.controller, initialDimension);
                    }
 
                    }
                    }
                    if(mainWindow.controller.getMurOrientation() == Orientation.Facade)
                    {
                        if("facade".equals(acc.mur_associe))
                    {
 
                    accdrawer.drawAccessoire(g2, acc, mainWindow.controller, initialDimension);
                        if(!acc.is_valid)
                    {
                    accdrawer.drawBorder_v(g2, acc, mainWindow.controller, initialDimension);
                    }
                        if(acc.is_selected)
 
                    accdrawer.drawAccessoire(g2, acc, mainWindow.controller, initialDimension);
                                        if(acc.is_selected)
 
                    {
                    accdrawer.drawBorder(g2, acc, mainWindow.controller, initialDimension);
                    }
                    }
                    }
                    if(mainWindow.controller.getMurOrientation() == Orientation.Arriere)
                    {
                        if("arriere".equals(acc.mur_associe))
                    {
 
                    accdrawer.drawAccessoire(g2, acc, mainWindow.controller, initialDimension);
                        if(!acc.is_valid)
                    {
                    accdrawer.drawBorder_v(g2, acc, mainWindow.controller, initialDimension);
                    }
                        if(acc.is_selected)
 
                    accdrawer.drawAccessoire(g2, acc, mainWindow.controller, initialDimension);
                                        if(acc.is_selected)
 
                    {
                    accdrawer.drawBorder(g2, acc, mainWindow.controller, initialDimension);
                    }
 
                    }
                    }

 
                    
 
 
                    }
                }
            }
            repaint();
    }    
        
int startx = (int) (-offsetX / zoomFactor);
    int starty = (int) (-offsetY / zoomFactor);
    
    startx = startx - (startx % gridSize);
    starty = starty - (starty % gridSize);

    int numCols = (int) ((getWidth() / (gridSize * zoomFactor)) + 2);
    int numRows = (int) ((getHeight() / (gridSize * zoomFactor)) + 2);

    g2.setColor(Color.GRAY);

    if (showGrid) {
    for (int i = 0; i <= numRows; i++) {
        int y = starty + (i * gridSize);
        g2.drawLine(startx, y, startx + (numCols * gridSize), y);
    }

    // Lignes verticales
    for (int j = 0; j <= numCols; j++) {
        int x = startx + (j * gridSize);
        g2.drawLine(x, starty, x, starty + (numRows * gridSize));
    }
        }  
               g2.dispose(); 
}
    

    public void setCurrentDrawer(chaletDrawer drawer) {
        this.currentDrawer = drawer;
        repaint();
    }

    public void setDrawers(chaletDrawer drawer) {
        this.drawer = drawer;
        repaint();
    }
    


    public MainWindow getMainWindow() {
        return mainWindow;
    }

    public void setMainWindow(MainWindow mainWindow) {
        this.mainWindow = mainWindow;
    }

    public Dimension getInitialDimension() {
        return initialDimension;
    }

}