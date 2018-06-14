package view;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;

import controller.ConstantList;
import model.Node;
import model.NodeGraph;

public class PanelGraph extends JPanel {

	private static final long serialVersionUID = 1L;
	private ArrayList<Node<String>> nodes;

	public PanelGraph(ArrayList<Node<String>> nodes) {
		this.nodes = nodes;
		repaint();
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.setFont(ConstantList.AGENCY_FB);
		for (Node<String> node : nodes) {
			g.setColor(Color.GRAY);
			for (NodeGraph<String> relation : node.getRelations()) {
				g.drawLine(node.getPositionX() + ConstantList.NODE_SIZE / 2,
						node.getPositionY() + ConstantList.NODE_SIZE/2,
						relation.getNode().getPositionX() + ConstantList.NODE_SIZE / 2,
						relation.getNode().getPositionY() + ConstantList.NODE_SIZE / 2);
			}
			g.fillOval(node.getPositionX(), node.getPositionY(), ConstantList.NODE_SIZE, ConstantList.NODE_SIZE);
			g.setColor(Color.WHITE);
			g.drawString(node.getInfo(), node.getPositionX() + 45, node.getPositionY() + 60);
		}
	}
}