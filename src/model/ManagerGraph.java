package model;

import java.util.ArrayList;

import controller.ConstantList;

public class ManagerGraph {

	private ArrayList<Node<String>> nodes;
	private int letter_ascci = 65;

	public ManagerGraph(int nodeNum, int width, int height) {
		nodes = new ArrayList<>();
		for (int i = 0; i < nodeNum; i++) {
			char letter = (char) letter_ascci++;
			createNode(String.valueOf(letter), width, height);
			nodes.add(new Node<>(String.valueOf(letter), 0, 0));
		}
	}

	private Node<String> createNode(String info, int width, int height) {
		int posX = 0;
		int posY = 0;
		boolean accept = false;
		while (!accept) {
			posX = (int) (Math.random() * width - ConstantList.NODE_SIZE) + ConstantList.NODE_SIZE;
			posY = (int) (Math.random() * height - ConstantList.NODE_SIZE) + ConstantList.NODE_SIZE;
			accept = validatePosition(posX, posY);
		}
		return new Node<String>(info, posX, posY);
	}

	private boolean validatePosition(int posX, int posY) {
		for (Node<String> node : nodes) {
			if (ConstantList.NODE_SIZE == Math.hypot(node.getPositionX() - posX, node.getPositionY() - posY)) {
				return false;
			}
		}
		return true;
	}

	public ArrayList<Node<String>> getNodes() {
		return nodes;
	}
}