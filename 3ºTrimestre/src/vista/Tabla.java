

package vista;

import java.awt.BorderLayout;
import java.sql.Date;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;

import beans.Animal;
import controlador.Central;
import beans.Alimentacion;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Tabla extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JPanel panel;
	private JButton botonEliminar;
	private JTextField idEliminar;
	private JLabel textoEliminar;
	private JLabel lblEliminacion;
	private JLabel lblModificacion;
	private JLabel lblCambiarNombreAnimal;
	private JLabel lblCambiarAlimentacionDel;
	private JTextField idModificar;
	private JTextField nombreModificar;
	private JTextField alimentacionModificar;

	public Tabla(ArrayList<Animal> animales) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 724, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		/* Crear la tabla con su modelo */
		DefaultTableModel dtm = new DefaultTableModel();
		
		panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		table = new JTable(dtm);
		table.setBackground(Color.WHITE);
		table.setFillsViewportHeight(true);
		
		textoEliminar = new JLabel("Elija \"id\" a eliminar:");
		
		//eliminar
		
		idEliminar = new JTextField();
		panel.add(idEliminar);
		idEliminar.setColumns(10);
		
		botonEliminar = new JButton("Eliminar");
		botonEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int idAnimales;
				try {
					idAnimales = Integer.parseInt(idEliminar.getText());
				}
				catch (Exception error) {
					idAnimales = 0; 
				}
				Central central = new Central();
				central.eliminar(idAnimales);
				
			}
			
			
		});
		
		JLabel lblElijaidQue = new JLabel("Elija \"id\" que quiera modificar:");
		
		JLabel lblTablaAnimales = new JLabel("TABLA ANIMALES");
		lblTablaAnimales.setFont(new Font("Tahoma", Font.BOLD, 17));
		
		lblEliminacion = new JLabel("ELIMINACION");
		lblEliminacion.setFont(new Font("Tahoma", Font.BOLD, 17));
		
		lblModificacion = new JLabel("MODIFICACION");
		lblModificacion.setFont(new Font("Tahoma", Font.BOLD, 17));
		
		lblCambiarNombreAnimal = new JLabel("Cambiar nombre animal:");
		
		lblCambiarAlimentacionDel = new JLabel("Cambiar alimentacion del animal:");
		
		//Modificar
		
		idModificar = new JTextField();
		idModificar.setColumns(10);
		
		nombreModificar = new JTextField();
		nombreModificar.setColumns(10);
		
		alimentacionModificar = new JTextField();
		alimentacionModificar.setColumns(10);
		
		JButton botonModificar = new JButton("Modificar");
		
		botonModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int idAnimal;
				try {
					idAnimal = Integer.parseInt(idModificar.getText());
				}
				catch (Exception error) {
					idAnimal = 0;
					// TODO: handle exception
				}
				Central central = new Central();
				String nombreAnimal = nombreModificar.getText();
				String nombreAlimento = alimentacionModificar.getText();
				central.modificarAnimal(idAnimal, nombreAnimal, nombreAlimento);
				
			}
			
			
		});
		
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addComponent(table, GroupLayout.PREFERRED_SIZE, 264, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(54)
							.addComponent(lblTablaAnimales)))
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_panel.createSequentialGroup()
								.addPreferredGap(ComponentPlacement.RELATED, 73, Short.MAX_VALUE)
								.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
									.addGroup(gl_panel.createSequentialGroup()
										.addComponent(textoEliminar)
										.addGap(18)
										.addComponent(idEliminar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addGap(18)
										.addComponent(botonEliminar))
									.addGroup(gl_panel.createSequentialGroup()
										.addComponent(lblModificacion, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE)
										.addGap(48)))
								.addGap(105))
							.addGroup(gl_panel.createSequentialGroup()
								.addGap(128)
								.addComponent(lblEliminacion, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE)
								.addContainerGap()))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(18)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
								.addComponent(lblCambiarNombreAnimal, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblElijaidQue, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblCambiarAlimentacionDel, GroupLayout.PREFERRED_SIZE, 198, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(idModificar, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(nombreModificar, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(botonModificar))
								.addComponent(alimentacionModificar, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE))
							.addGap(54))))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblTablaAnimales)
								.addComponent(lblEliminacion, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(57)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(textoEliminar)
								.addComponent(idEliminar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(botonEliminar))))
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(table, GroupLayout.PREFERRED_SIZE, 307, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(64)
							.addComponent(lblModificacion, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
							.addGap(28)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblElijaidQue)
								.addComponent(idModificar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(26)
							.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblCambiarNombreAnimal)
								.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
									.addComponent(nombreModificar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addComponent(botonModificar)))
							.addGap(28)
							.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
								.addComponent(alimentacionModificar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblCambiarAlimentacionDel)))))
		);
		panel.setLayout(gl_panel);
		/* Crear las columnas */
		dtm.addColumn("Id Animales");
		dtm.addColumn("Nombre");
		dtm.addColumn("alimento");
		/* Rellenar los datos con el array de animales */
		for(Animal animal : animales) {
			Object[] fila = new Object[3];
			fila[0] = animal.getIdAnimales();
			fila[1] = animal.getNombre();
			fila[2] = animal.getAlimentacion();
			dtm.addRow(fila);			
		}
		
		
		setVisible(true);
	}
}

