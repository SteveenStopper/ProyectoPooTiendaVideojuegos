package mundo.InterfazGrafica;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;

import mundo.ConexionMongoDB.ConexionUsuarioMongoDB;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;

public class InterfazLogin extends JFrame {

	private JPanel contentPane;
	private JTextField contrasena;
	private JTextField textUsu;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfazLogin frame = new InterfazLogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public InterfazLogin() {
		setTitle("Iniciar Sesion");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 715, 514);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setBounds(0, 0, 325, 471);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("Imagenes\\Logo.jpeg"));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(61, 185, 233, 234);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("GAME ZONE");
		lblNewLabel_1.setFont(new Font("Monotype Corsiva", Font.BOLD | Font.ITALIC, 40));
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(48, 58, 233, 70);
		panel.add(lblNewLabel_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.BLACK);
		panel_1.setBounds(320, 0, 383, 471);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Iniciar Sesion");
		lblNewLabel_2.setFont(new Font("Corbel Light", Font.PLAIN, 36));
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setBounds(45, 68, 221, 48);
		panel_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("CORREO ELECTRONICO");
		lblNewLabel_3.setFont(new Font("Corbel Light", Font.PLAIN, 18));
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setBounds(45, 145, 221, 21);
		panel_1.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("CONTRASE\u00D1A");
		lblNewLabel_4.setFont(new Font("Corbel", Font.PLAIN, 18));
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setBounds(45, 228, 144, 44);
		panel_1.add(lblNewLabel_4);
		
		contrasena = new JPasswordField(10);
		contrasena.setFont(new Font("Tahoma", Font.PLAIN, 12));
		contrasena.setBounds(96, 267, 221, 33);
		panel_1.add(contrasena);
		contrasena.setColumns(10);
		
		JButton btnNewButton = new JButton("INGRESAR");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				if(textUsu.getText().equals("")||contrasena.getText().equals("")) {
					JOptionPane.showMessageDialog(textUsu, "Por Favor llene los campos", "Error 404", JOptionPane.ERROR_MESSAGE);
				}else {		
					if (textUsu.getText().equals("Admin") && contrasena.getText().equals("12345") ) {
						InterfazLogin.this.dispose();
						VentanaTiendaVideoJuegos ventana = new VentanaTiendaVideoJuegos();
						ventana.setVisible(true);
						
					} else  {
						boolean ingresa=false;
						for (int i = 0; i < InterfazRegistro.logg.size(); i++) {
							if (textUsu.getText().equals(InterfazRegistro.logg.get(i).getEmail().toString()) && 
								contrasena.getText().equals(InterfazRegistro.logg.get(i).getPassword().toString())){
								ingresa=true;
								break;
							}
						}
						if (ingresa) {
							InterfazLogin.this.dispose();
							VentanaTiendaVideoJuegos ventana = new VentanaTiendaVideoJuegos();
							ventana.setVisible(true);
						}
						
						if (ingresa != true) {
							textUsu.setText("");
							contrasena.setText("");
							JOptionPane.showMessageDialog(textUsu, "Datos Erroneos", "Error 404", JOptionPane.ERROR_MESSAGE);
						}
					}
					
				}
			}
		});
		btnNewButton.setBounds(157, 361, 109, 21);
		panel_1.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("REGISTRASE");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InterfazLogin.this.dispose();
				InterfazRegistro ventana = new InterfazRegistro();
				ventana.setVisible(true);
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton_1.setBounds(157, 414, 109, 22);
		panel_1.add(btnNewButton_1);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Mantener Sesion Iniciada");
		chckbxNewCheckBox.setFont(new Font("Tahoma", Font.PLAIN, 14));
		chckbxNewCheckBox.setForeground(Color.WHITE);
		chckbxNewCheckBox.setBackground(Color.BLACK);
		chckbxNewCheckBox.setBounds(45, 314, 201, 21);
		panel_1.add(chckbxNewCheckBox);
		
		JLabel lblNewLabel_5 = new JLabel("Recuerdame");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_5.setForeground(Color.WHITE);
		lblNewLabel_5.setBounds(70, 322, 93, 13);
		panel_1.add(lblNewLabel_5);
		
		textUsu = new JTextField();
		textUsu.setBounds(96, 176, 221, 42);
		panel_1.add(textUsu);
		textUsu.setColumns(10);
	}
}