package telas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import bancoDeDados.Conexao;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaLogin extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private Conexao conn = new Conexao();

	/**
	 * Launch the application.
	 */
	public void starta() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaLogin frame = new TelaLogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/*
	 * Create the frame.
	 */
	public TelaLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 287, 241);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel lblLogin = new JLabel("LOGIN");
		lblLogin.setFont(new Font("Tahoma", Font.PLAIN, 77));

		JLabel lblUsurio = new JLabel("Usu\u00E1rio:");
		lblUsurio.setFont(new Font("Tahoma", Font.PLAIN, 18));

		textField = new JTextField();
		textField.setColumns(10);

		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setFont(new Font("Tahoma", Font.PLAIN, 18));

		passwordField = new JPasswordField();

		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				conn.setUsuario(textField.getText());
				conn.setSenha(String.valueOf(passwordField.getPassword()));
				conn.conectar(textField.getText(), String.valueOf(passwordField.getPassword()));
				JOptionPane.showMessageDialog(null, conn.estaConectado(), "Resumo da Conexão",
						JOptionPane.INFORMATION_MESSAGE);

				if (!conn.connection.equals(null)) {
					dispose();
					TelaPrincipal tPrincipal = new TelaPrincipal();
					tPrincipal.setVisible(true);

				} else {
					JOptionPane.showMessageDialog(null, "teste");
				}
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane
				.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup().addGap(18)
								.addComponent(lblLogin, GroupLayout.DEFAULT_SIZE, 297, Short.MAX_VALUE).addGap(109))
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup().addGroup(gl_contentPane
								.createParallelGroup(Alignment.TRAILING).addGroup(Alignment.LEADING,
										gl_contentPane.createSequentialGroup().addGap(62).addComponent(btnEntrar,
												GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE))
								.addGroup(gl_contentPane.createSequentialGroup().addContainerGap()
										.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
												.addComponent(lblUsurio, GroupLayout.DEFAULT_SIZE,
														GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(lblSenha, GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE))
										.addPreferredGap(ComponentPlacement.RELATED)
										.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
												.addComponent(passwordField, GroupLayout.DEFAULT_SIZE, 108,
														Short.MAX_VALUE)
												.addComponent(textField, GroupLayout.DEFAULT_SIZE, 85,
														Short.MAX_VALUE))))
								.addGap(139)));
		gl_contentPane
				.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(Alignment.TRAILING,
						gl_contentPane.createSequentialGroup()
								.addComponent(lblLogin, GroupLayout.PREFERRED_SIZE, 77, Short.MAX_VALUE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(textField)
										.addComponent(lblUsurio, GroupLayout.PREFERRED_SIZE, 20, Short.MAX_VALUE))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
										.addComponent(passwordField)
										.addComponent(lblSenha, GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE))
								.addGap(18)
								.addComponent(btnEntrar, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
								.addGap(10)));
		contentPane.setLayout(gl_contentPane);
	}
}
