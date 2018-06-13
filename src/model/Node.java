package model;

import java.util.ArrayList;

public class Node<T> {

	private T info;
	private int weigth;
	private int positionX;
	private int positionY;
	private ArrayList<NodeGraph<T>> relations;

	public Node(T info, int weigth, int positionX, int positionY) {
		this.info = info;
		this.weigth = weigth;
		this.positionX = positionX;
		this.positionY = positionY;
		relations = new ArrayList<>();
	}
	
	public void addRelation(Node<T> node, int weigth) {
		relations.add(new NodeGraph<>(node, weigth));
	}

	public int getWeigth() {
		return weigth;
	}

	public void setWeigth(int weigth) {
		this.weigth = weigth;
	}

	public T getInfo() {
		return info;
	}

	public int getPositionX() {
		return positionX;
	}

	public int getPositionY() {
		return positionY;
	}
	
	public ArrayList<NodeGraph<T>> getRelations() {
		return relations;
	}
}