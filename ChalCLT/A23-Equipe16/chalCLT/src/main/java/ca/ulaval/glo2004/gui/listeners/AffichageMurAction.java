/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.ulaval.glo2004.gui.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import ca.ulaval.glo2004.domain.drawer.*;
import ca.ulaval.glo2004.gui.MainWindow;
import ca.ulaval.glo2004.domain.Orientation;


public class AffichageMurAction implements ActionListener {

	private final MainWindow outer;

	public AffichageMurAction(MainWindow outer) {
		this.outer = outer;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		chaletDrawer Drawer = new AfficheurMur(outer);
		outer.drawingPanel.setDrawers(Drawer);
                outer.controller.setMurOrientation(Orientation.Gauche);
	}
}
