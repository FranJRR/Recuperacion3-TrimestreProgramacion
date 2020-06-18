package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.Central;

import javax.swing.JButton;
import javax.swing.BoxLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.SwingConstants;
import java.awt.Font;

public class Principal extends JFrame {

	private JPanel contentPane;
	private JTextField inputNombre;
	private JTextField inputTipo;

	public Principal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JButton btnAñadir = new JButton("A\u00F1adir");
		btnAñadir.setBounds(166, 128, 89, 20);
		panel.add(btnAñadir);
		
		inputNombre = new JTextField();
		inputNombre.setBounds(169, 53, 86, 20);
		panel.add(inputNombre);
		inputNombre.setColumns(10);
		
		inputTipo = new JTextField();
		inputTipo.setBounds(169, 84, 86, 20);
		panel.add(inputTipo);
		inputTipo.setColumns(10);
		
		JLabel labelNombre = new JLabel("Nombre:");
		labelNombre.setBounds(38, 56, 79, 14);
		panel.add(labelNombre);
		
		JButton btnTodos = new JButton("Ver todos los animales");
		btnTodos.setBounds(122, 192, 193, 23);
		panel.add(btnTodos);
		
		JLabel lblTipo = new JLabel("Tipo de alimentaci\u00F3n:");
		lblTipo.setBounds(38, 83, 152, 14);
		panel.add(lblTipo);
		
		JLabel lblZoologico = new JLabel("Zoologico");
		lblZoologico.setFont(new Font("Comic Sans MS", Font.PLAIN, 24));
		lblZoologico.setHorizontalAlignment(SwingConstants.CENTER);
		lblZoologico.setBounds(131, 11, 161, 31);
		panel.add(lblZoologico);
		
		
		/* Acciones */
		
		btnAñadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nombre = inputNombre.getText();
				String tipo = inputTipo.getText();
				Central central = new Central();
				int resultadoSaludar = central.saludar(nombre, tipo);
				if(resultadoSaludar > 0) {
					inputNombre.setText("");
					inputTipo.setText("");	
				}
			}
		});
		btnTodos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Central().verTodos();
			}
		});

	}
}
