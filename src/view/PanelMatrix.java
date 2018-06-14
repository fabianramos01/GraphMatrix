package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.Command;
import controller.ConstantList;
import model.Node;

public class PanelMatrix extends JPanel {

	private static final long serialVersionUID = 1L;
	private ArrayList<JTextField> textFields;

	public PanelMatrix(ActionListener listener, ArrayList<Node<String>> nodes, int num) {
		setLayout(new BorderLayout());
		textFields = new ArrayList<>();
		createMatrix(num, nodes);
		add(UtilityList.createJButtonText(Command.COMMAND_ACCEPT.getCommand(), Command.COMMAND_ACCEPT.getTitle(),
				Color.BLUE, Color.WHITE, ConstantList.AGENCY_FB, listener), BorderLayout.SOUTH);
		revalidate();
	}

	private void createMatrix(int num, ArrayList<Node<String>> nodes) {
		JPanel panel = new JPanel(new GridLayout(++num, num));
		panel.add(UtilityList.createJLabel(ConstantList.SIMBOL, ConstantList.AGENCY_FB, Color.BLUE));
		for (Node<String> node : nodes) {
			panel.add(UtilityList.createJLabel(node.getInfo(), ConstantList.AGENCY_FB, Color.BLUE));
		}
		int nodeNum = 0;
		for (int i = 1; i < num; i++) {
			for (int j = 0; j < num; j++) {
				if (j == 0) {
					panel.add(UtilityList.createJLabel(nodes.get(nodeNum++).toString(), ConstantList.AGENCY_FB,
							Color.BLUE));
				} else {
					panel.add(createTextField());
				}
			}
		}
		add(panel, BorderLayout.CENTER);
	}

	private JTextField createTextField() {
		JTextField textField = new JTextField();
		textField.setFont(ConstantList.AGENCY_FB);
		textField.setHorizontalAlignment(JTextField.CENTER);
		textFields.add(textField);
		return textField;
	}

	public ArrayList<JTextField> getjTextFields() {
		return textFields;
	}
}