import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Window.Type;
import java.awt.Dialog.ModalExclusionType;

public class GuessingGame extends JFrame {
	private JTextField txtGuess;
	private JLabel lblOutput;
	JButton  btnPlayAgain;
	private int theNumber;
	private int numberOfTries;
	public void checkGuess () {
		String guessText = txtGuess.getText();
		String message = "";
		

		try {

			int guess = Integer.parseInt(guessText);
			numberOfTries++;
			if (guess < theNumber) 
				message = guess + " меньше загаданного. Попробуйте ещё.";
			else if (guess > theNumber)
				message = guess + " больше загаданного. Попробуйте ещё.";
			else {
				message = guess + " загаданное число. Вы выиграли!" + " Сделанно попыток: " + numberOfTries + " Сыграем еще раз.";
				//newGame();
				btnPlayAgain.setVisible(true);
			}

		} catch (Exception e) {
			message = "Введите целое число между 1 и 100";
		} finally {
			lblOutput.setText(message);
			txtGuess.requestFocus();
			txtGuess.selectAll();
		}

	}

	public void newGame () {
		theNumber = (int)(Math.random() * 100 + 1);
		numberOfTries = 0;
		btnPlayAgain.setVisible(false);
	}
	public GuessingGame() {
		setBackground(Color.GRAY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle(" HiLo v. 0.1");
		getContentPane().setLayout(null);

		JLabel lblCreatedByAlevur = new JLabel("Created by Alevur");
		lblCreatedByAlevur.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCreatedByAlevur.setHorizontalAlignment(SwingConstants.CENTER);
		lblCreatedByAlevur.setBounds(129, 232, 115, 14);
		getContentPane().add(lblCreatedByAlevur);

		JLabel label = new JLabel("\u041E\u0442\u0433\u0430\u0434\u0430\u0439\u0442\u0435 \u0447\u0438\u0441\u043B\u043E \u043C\u0435\u0436\u0434\u0443 1 \u0438 100:");
		label.setFont(new Font("Tahoma", Font.BOLD, 17));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(50, 11, 288, 21);
		getContentPane().add(label);

		txtGuess = new JTextField();
		txtGuess.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkGuess();
			}
		});
		txtGuess.setHorizontalAlignment(SwingConstants.CENTER);
		txtGuess.setBounds(141, 55, 86, 36);
		getContentPane().add(txtGuess);
		txtGuess.setColumns(10);

		JButton btnGuess = new JButton("\u0423\u0433\u0430\u0434\u0430\u0442\u044C");
		btnGuess.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnGuess.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkGuess();
			}
		});
		btnGuess.setBounds(141, 116, 89, 36);
		getContentPane().add(btnGuess);

		lblOutput = new JLabel("\u041D\u0430\u043F\u0435\u0447\u0430\u0442\u0430\u0439\u0442\u0435 \u0447\u0438\u0441\u043B\u043E \u0432 \u043F\u043E\u043B\u0435 \u0432\u0432\u043E\u0434\u0430 \u0438 \u043D\u0430\u0436\u043C\u0438\u0442\u0435 \u043A\u043D\u043E\u043F\u043A\u0443 \"\u0423\u0433\u0430\u0434\u0430\u0442\u044C\" ");
		lblOutput.setHorizontalAlignment(SwingConstants.CENTER);
		lblOutput.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblOutput.setBounds(-20, 214, 428, 21);
		getContentPane().add(lblOutput);

		btnPlayAgain = new JButton("\u0418\u0433\u0440\u0430\u0442\u044C \u0441\u043D\u043E\u0432\u0430");
		btnPlayAgain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				newGame();
			}
		});
		btnPlayAgain.setBounds(134, 167, 110, 36);
		getContentPane().add(btnPlayAgain);
	}

	public static void main(String[] args) {
		GuessingGame theGame = new GuessingGame();
		theGame.newGame();
		theGame.setSize(new Dimension(450,300));
		theGame.setVisible(true);

	}
}
