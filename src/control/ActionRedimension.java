package control;

import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

import javax.swing.JFrame;

public class ActionRedimension implements ComponentListener {
	
	ParaUI paraUI;

	public ActionRedimension(ParaUI paraUI) {
		super();
		this.paraUI = paraUI;
	}

	@Override
	public void componentHidden(ComponentEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void componentMoved(ComponentEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void componentResized(ComponentEvent e) {
		System.out.println(((JFrame) e.getComponent()).getWidth() + " " + ((JFrame) e.getComponent()).getHeight());
	}

	@Override
	public void componentShown(ComponentEvent e) {
		// TODO Auto-generated method stub
		
	}

}
