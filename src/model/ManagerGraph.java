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
			nodes.add(createNode(String.valueOf(letter), width, height));
		}
	}

	private Node<String> createNode(String info, int width, int height) {
		int posX = 0;
		int posY = 0;
		boolean accept = false;
		while (!accept) {
			posX = (int) (Math.random() * width - ConstantList.NODE_SIZE);
			posY = (int) (Math.random() * height - ConstantList.NODE_SIZE);
			accept = validatePosition(posX, posY);
		}
		return new Node<String>(info, posX, posY);
	}

	private boolean validatePosition(int posX, int posY) {
		for (Node<String> node : nodes) {
			if (ConstantList.NODE_SIZE >= Math.hypot(node.getPositionX() - posX, node.getPositionY() - posY)) {
				return false;
			}
		}
		return true;
	}
	
	public void setRelations(ArrayList<Integer> relations) {
		for (int i = 0; i < relations.size(); i++) {
			setRelation(i, relations.get(i));
		}
	}
	
	private void setRelation(int index, int weigth) {
		int num = 0;
		for (int i = nodes.size(); i < nodes.size() * nodes.size() - 2; i+=nodes.size()) {
			if (index < i) {
				nodes.get(num).addRelation(getColumn(index), weigth);
			}
			num++;
		}
	}
	
	private Node<String> getColumn(int index) {
		int column = 0;
		for (int i = 0; i <= index; i++) {
			column++;
			if (column == nodes.size()) {
				column = 0;
			}
		}
		return nodes.get(column);
	}

	public ArrayList<Node<String>> getNodes() {
		return nodes;
	}
}