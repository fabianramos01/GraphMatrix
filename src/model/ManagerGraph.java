package model;

import java.util.ArrayList;

public class ManagerGraph {

	private ArrayList<Node<String>> nodes;
	private int letter_ascci = 65;
	
	public ManagerGraph(int nodeNum) {
		nodes = new ArrayList<>();
		for (int i = 0; i < nodeNum; i++) {
			char letter = (char) letter_ascci++;
			nodes.add(new Node<>(String.valueOf(letter), 0, 0, 0));
		}
		print();
	}
	
	private void print() {
		for (Node<String> node : nodes) {
			System.out.println(node.getInfo());
		}
	}
	
	public ArrayList<Node<String>> getNodes() {
		return nodes;
	}
	
	public static void main(String[] args) {
		new ManagerGraph(4);
	}
}