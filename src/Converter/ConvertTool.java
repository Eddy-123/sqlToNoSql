package Converter;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JButton;

public class ConvertTool {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConvertTool window = new ConvertTool();
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
	public ConvertTool() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(45, 191, 7, 21);
		frame.getContentPane().add(textPane);
		
		JLabel lblSqllike = new JLabel("Sql-like");
		lblSqllike.setBounds(40, 231, 66, 15);
		frame.getContentPane().add(lblSqllike);
		
		JLabel lblJson = new JLabel("Json");
		lblJson.setBounds(349, 231, 66, 15);
		frame.getContentPane().add(lblJson);

		JTextArea sqlArea = new JTextArea();
		sqlArea.setLineWrap(true);
		sqlArea.setWrapStyleWord(true);
		sqlArea.setBounds(23, 12, 98, 200);
		frame.getContentPane().add(sqlArea);
		
		JTextArea jsonArea = new JTextArea();
		jsonArea.setLineWrap(true);
		jsonArea.setWrapStyleWord(true);
		jsonArea.setBounds(317, 12, 98, 200);
		frame.getContentPane().add(jsonArea);
		
		
		JButton btnGenerate = new JButton("Generate");
		btnGenerate.addActionListener((ActionListener) new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String sql = sqlArea.getText();
				Choisir_Operation choisir_operation = new Choisir_Operation(sql);
				
				String json = choisir_operation.executer_operation();
				jsonArea.setText(json);
				
			}
		});
		btnGenerate.setBounds(160, 122, 114, 25);
		frame.getContentPane().add(btnGenerate);
		
	}
}
