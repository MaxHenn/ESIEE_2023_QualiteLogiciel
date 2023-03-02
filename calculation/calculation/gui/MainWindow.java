package calculation.gui;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.InvalidParameterException;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import calculation.process.CalculationUtility;

public class MainWindow extends JFrame {
	private static final long serialVersionUID = 1L;

	private static final Dimension WINDOW_MIN_DIMENSION = new Dimension(854, 480);
	private static final Dimension WINDOW_DIMENSION = new Dimension(1280, 720);

	private JPanel fieldPanel;
	private JPanel buttonPanel;
	private JTextField firstField;
	private JTextField secondField;

	public MainWindow() {
		initLayout();
		setMinimumSize(WINDOW_MIN_DIMENSION);
		setPreferredSize(WINDOW_DIMENSION);
		pack();
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}

	private void initLayout() {
		setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
		initFieldPanel();
		getContentPane().add(fieldPanel);
		initButtonPanel();
		getContentPane().add(buttonPanel);
	}

	private void initFieldPanel() {
		fieldPanel = new JPanel();
		firstField = new JTextField(20);
		fieldPanel.add(firstField);
		secondField = new JTextField(20);
		fieldPanel.add(secondField);
	}

	private void initButtonPanel() {
		buttonPanel = new JPanel();
		JButton squareButton = new JButton("Racine Carré");
		squareButton.addActionListener(new ActionSquareRoot());
		buttonPanel.add(squareButton);
		JButton numberButton = new JButton("Nombre \"Premier\"");
		numberButton.addActionListener(new ActionGoodNumber());
		buttonPanel.add(numberButton);
	}

	class ActionSquareRoot implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String popupTitle = "Calculation : Square Root";
			String firstFieldText = firstField.getText();
			String secondFieldText = secondField.getText();
			List<Double> result;
			try {
				result = CalculationUtility.calculateSquareRoot(firstFieldText, secondFieldText);
			} catch (InvalidParameterException ex) {
				JOptionPane.showMessageDialog(MainWindow.this, ex.getMessage(), popupTitle, JOptionPane.ERROR_MESSAGE);
				return;
			}
			DefaultListModel<Double> resultList = new DefaultListModel<Double>();
			for (Double number : result) {
				resultList.addElement(number);
			}
			JList<Double> list = new JList<Double>(resultList);
			list.setLayoutOrientation(JList.VERTICAL);
			list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			list.setVisibleRowCount(1);
			JScrollPane listScroller = new JScrollPane(list);
			listScroller.setPreferredSize(WINDOW_MIN_DIMENSION);
			JOptionPane.showMessageDialog(MainWindow.this, listScroller, popupTitle, JOptionPane.INFORMATION_MESSAGE);

		}
	}

	class ActionGoodNumber implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String popupTitle = "Calculation : Square Root";
			String firstFieldText = firstField.getText();
			String secondFieldText = secondField.getText();
			List<Integer> result;
			try {
				result = CalculationUtility.calculateGoodNumber(firstFieldText, secondFieldText);
			} catch (InvalidParameterException ex) {
				JOptionPane.showMessageDialog(MainWindow.this, ex.getMessage(), popupTitle, JOptionPane.ERROR_MESSAGE);
				return;
			}
			DefaultListModel<Integer> resultList = new DefaultListModel<Integer>();
			for (Integer number : result) {
				resultList.addElement(number);
			}
			JList<Integer> list = new JList<Integer>(resultList);
			list.setLayoutOrientation(JList.VERTICAL);
			list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			list.setVisibleRowCount(1);
			JScrollPane listScroller = new JScrollPane(list);
			listScroller.setPreferredSize(WINDOW_MIN_DIMENSION);
			JOptionPane.showMessageDialog(MainWindow.this, listScroller, popupTitle, JOptionPane.INFORMATION_MESSAGE);
		}
	}

	public static void main(String[] args) {
		new MainWindow();
	}

}
