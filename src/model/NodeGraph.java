package model;

public class NodeGraph<T> {

	private Node<T> node;
	private int weight;
	
	public NodeGraph(Node<T> node, int weight) {
		super();
		this.node = node;
		this.weight = weight;
	} 
	
	public Node<T> getNode() {
		return node;
	}
	
	public int getWeight() {
		return weight;
	}
}