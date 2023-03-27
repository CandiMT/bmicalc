package bmicalc;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class calc {

	private JFrame frame;
	private JTextField alt;
	private JTextField pes;
	private JTextField result;
	private JTextField diag;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					calc window = new calc();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public calc() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		BMICalcImpl test = new BMICalcImpl();
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		alt = new JTextField();
		alt.setBounds(172, 27, 86, 20);
		frame.getContentPane().add(alt);
		alt.setColumns(10);
		
		pes = new JTextField();
		pes.setBounds(172, 65, 86, 20);
		frame.getContentPane().add(pes);
		pes.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Altura");
		lblNewLabel.setBounds(116, 30, 46, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Peso");
		lblNewLabel_1.setBounds(116, 68, 46, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("m");
		lblNewLabel_2.setBounds(268, 30, 46, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("kg");
		lblNewLabel_3.setBounds(268, 68, 46, 14);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Resultado");
		lblNewLabel_4.setBounds(137, 160, 81, 14);
		frame.getContentPane().add(lblNewLabel_4);
		
		result = new JTextField();
		result.setBounds(228, 157, 86, 20);
		frame.getContentPane().add(result);
		result.setColumns(10);
		
		
		JLabel lblNewLabel_5 = new JLabel("kg/m^2");
		lblNewLabel_5.setBounds(324, 160, 46, 14);
		frame.getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_4_1 = new JLabel("Diagnóstico");
		lblNewLabel_4_1.setBounds(137, 188, 81, 14);
		frame.getContentPane().add(lblNewLabel_4_1);
		
		diag = new JTextField();
		diag.setColumns(10);
		diag.setBounds(228, 188, 105, 20);
		frame.getContentPane().add(diag);
		
		JButton btnNewButton = new JButton("Calcular");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == btnNewButton) {
					 try {
			                double altura = Double.parseDouble(alt.getText());
			                double peso = Double.parseDouble(pes.getText());
			                double imc = test.bmi(peso, altura);
			                result.setText(String.format("%.2f", imc));
			                diag.setText(String.format("%s", test.category(imc)));
			            } catch (NumberFormatException ex) {
			                JOptionPane.showInputDialog(this);
			            }
				}
			}
		});
		btnNewButton.setBounds(172, 96, 89, 23);
		frame.getContentPane().add(btnNewButton);

		

	}
}
