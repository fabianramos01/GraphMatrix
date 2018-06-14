package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import model.ManagerGraph;
import view.FrameHome;

public class Controller implements ActionListener {

	private ManagerGraph managerGraph;
	private FrameHome frameHome;
	
	public Controller() {
		frameHome = new FrameHome(this);
		int num = Integer.parseInt(JOptionPane.showInputDialog(ConstantList.NODE_NUM));
		managerGraph = new ManagerGraph(num, frameHome.getWidth()/2, frameHome.getHeight());
		frameHome.init(managerGraph.getNodes());
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (Command.valueOf(e.getActionCommand())) {
		case COMMAND_ACCEPT:
			validateRelations();
			break;
		default:
			break;
		}
	}

	private void validateRelations() {
		managerGraph.setRelations(frameHome.getjTextFields());
		frameHome.repaint();
	}
}