package view;

import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import controller.ConstantList;
import model.Node;

public class FrameHome extends JFrame {

	private static final long serialVersionUID = 1L;

	private ActionListener listener;
	private PanelMatrix panelMatrix;
	private PanelGraph panelGraph;

	public FrameHome(ActionListener listener) {
		this.listener = listener;
		setLayout(new GridLayout(1, 2));
		setTitle(ConstantList.FRAME_TITLE);
		setSize(Toolkit.getDefaultToolkit().getScreenSize());
		setIconImage(new ImageIcon(getClass().getResource(ConstantList.ICON_APP)).getImage());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}
	
	public void init(ArrayList<Node<String>> nodes) {
		panelGraph = new PanelGraph(nodes);
		add(panelGraph);
		panelMatrix = new PanelMatrix(listener, nodes, nodes.size());
		add(panelMatrix);
		setVisible(true);
	}
	
	public void repaintGraph() {
		panelGraph.repaint();
	}
	
	public ArrayList<Integer> getjTextFields() {
		return panelMatrix.getjTextFields();
	}
}