package calculation.gui;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.InvalidParameterException;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import calculation.process.CalculationUtility;

public class MainWindow extends JFrame {
	private static final long serialVersionUID = 1L;

	private static final Dimension WINDOW_MIN_DIMENSION = new Dimension(854, 480);
	private static final Dimension WINDOW_DIMENSION = new Dimension(1280, 720);

	private JPanel fieldPanel;
	private JPanel buttonPanel;
	JTextField firstField;
	JTextField secondField;

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
			int firstNumber, secondNumber;
			try {
				firstNumber = readTextField(firstField);
				secondNumber = readTextField(secondField);
			} catch (InvalidParameterException ex) {
				JOptionPane.showMessageDialog(MainWindow.this, ex.getMessage(), popupTitle, JOptionPane.ERROR_MESSAGE);
				return;
			}
			List<Double> result = CalculationUtility.calculateSquareRoot(firstNumber, secondNumber);
			String resultText = new String();
			for (Double number : result) {
				resultText += number.toString() + "\n";
			}
			JOptionPane.showMessageDialog(MainWindow.this, resultText, popupTitle, JOptionPane.INFORMATION_MESSAGE);
		}

		private int readTextField(JTextField textField) {
			String fieldValue = textField.getText();
			if (fieldValue == null || fieldValue.trim().isEmpty()) {
				throw new InvalidParameterException("Empty field " + textField.getName());
			}
			Integer number = Integer.valueOf(fieldValue);
			if (number == null) {
				throw new InvalidParameterException("No number found in field " + textField.getName());
			}
			return number.intValue();
		}
	}

	class ActionGoodNumber implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String popupTitle = "Calculation : Square Root";
			int firstNumber, secondNumber;
			try {
				firstNumber = readTextField(firstField);
				secondNumber = readTextField(secondField);
			} catch (InvalidParameterException ex) {
				JOptionPane.showMessageDialog(MainWindow.this, ex.getMessage(), popupTitle, JOptionPane.ERROR_MESSAGE);
				return;
			}
			List<Integer> result = CalculationUtility.calculateGoodNumber(firstNumber, secondNumber);
			String resultText = new String();
			for (Integer number : result) {
				resultText += number.toString() + "\n";
			}
			JOptionPane.showMessageDialog(MainWindow.this, resultText, popupTitle, JOptionPane.INFORMATION_MESSAGE);
		}

		private int readTextField(JTextField textField) {
			String fieldValue = textField.getText();
			if (fieldValue == null || fieldValue.trim().isEmpty()) {
				throw new InvalidParameterException("Empty field " + textField.getName());
			}
			Integer number = Integer.valueOf(fieldValue);
			if (number == null) {
				throw new InvalidParameterException("No number found in field " + textField.getName());
			}
			return number.intValue();
		}
	}

	public static void main(String[] args) {
		new MainWindow();
	}

}
