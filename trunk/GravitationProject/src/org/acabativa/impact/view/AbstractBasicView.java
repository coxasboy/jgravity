package org.acabativa.impact.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.acabativa.impact.controller.ColisionController;
import org.acabativa.impact.model.ColisionModel;
import org.acabativa.impact.util.Observer;

public abstract class AbstractBasicView extends JPanel implements ActionListener, Observer {

	private static final long serialVersionUID = 1L;
	public static final int MAX_WIDHT = 500;
	public static final int MAX_HEIGHT = 500;
	ColisionController controller;
	ColisionModel model;
	protected JFrame frame;
			
	public AbstractBasicView(ColisionController controller, ColisionModel model) {
		this.controller = controller;
		this.model = model;
		model.addObserver(this);
		frame = new JFrame("Gravitation Experiment");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		System.out.println(getWidth());
		System.out.println(getHeight());
		frame.setSize(getWidthFrame() + 17 , getHeightFrame() + 37);
		frame.add(this);
		
	}
	
	protected abstract int getWidthFrame();
	
	protected abstract int getHeightFrame();
	
	public void actionPerformed(ActionEvent e) {
		repaint();
	}
	
	public void notifyEvent(String event) {
		repaint();
	}

}
