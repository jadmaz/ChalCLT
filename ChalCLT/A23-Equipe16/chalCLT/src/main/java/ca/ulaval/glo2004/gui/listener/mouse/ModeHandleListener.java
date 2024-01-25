/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.ulaval.glo2004.gui.listener.mouse;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import ca.ulaval.glo2004.gui.MainWindow.SelectMode;
import ca.ulaval.glo2004.gui.*;
/**
 *
 * @author charlescareau



public class ModeHandleListener extends MouseAdapter {
    
    final MainWindow mainWindow;

	public ModeHandleListener(MainWindow outer) {
		this.mainWindow = outer;
	}

	@Override
	public void mousePressed(MouseEvent e) {
		Point mousePoint = e.getPoint();
		mainWindow.actualMousePoint = e.getPoint();
		SelectMode actualMode = mainWindow.getselectmode();
		if (actualMode == SelectMode.ADD) {
                        System.out.println(actualMode);
			String type = mainWindow.getItemType();
			mainWindow.controller.addItem(mousePoint, type);
                        
                
		}
                else{
                System.out.println(actualMode);
                }
	}
    
}
 */