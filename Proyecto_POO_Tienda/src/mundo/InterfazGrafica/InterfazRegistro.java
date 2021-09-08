package mundo.InterfazGrafica;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import mundo.ConexionMongoDB.ConexionUsuarioMongoDB;
import mundo.TiendaVideojuegos.Login;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class InterfazRegistro extends JFrame {

	private JPanel contentPane;
	private JTextField Nombre;
	private JTextField Apellido;
	private JTextField Email;
	private JTextField contrasena;
	public static ArrayList<Login> logg = new ArrayList<Login>();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfazRegistro frame = new InterfazRegistro();
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
	public InterfazRegistro() {
		setTitle("REGISTRO");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 715, 477);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setBounds(0, 0, 701, 440);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("GAME ZONE");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Monotype Corsiva", Font.BOLD | Font.ITALIC, 40));
		lblNewLabel_1.setBounds(232, 10, 233, 70);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_3 = new JLabel("CORREO ELECTRONICO");
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setFont(new Font("Corbel Light", Font.PLAIN, 18));
		lblNewLabel_3.setBounds(91, 225, 221, 21);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("NOMBRE");
		lblNewLabel_3_1.setForeground(Color.WHITE);
		lblNewLabel_3_1.setFont(new Font("Corbel Light", Font.PLAIN, 18));
		lblNewLabel_3_1.setBounds(91, 118, 221, 21);
		panel.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_3_2 = new JLabel("APELLIDO");
		lblNewLabel_3_2.setForeground(Color.WHITE);
		lblNewLabel_3_2.setFont(new Font("Corbel Light", Font.PLAIN, 18));
		lblNewLabel_3_2.setBounds(91, 166, 221, 21);
		panel.add(lblNewLabel_3_2);
		
		JLabel lblNewLabel_4 = new JLabel("CONTRASE\u00D1A");
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setFont(new Font("Corbel", Font.PLAIN, 18));
		lblNewLabel_4.setBounds(92, 271, 144, 44);
		panel.add(lblNewLabel_4);
		
		Nombre = new JTextField();
		Nombre.setFont(new Font("Tahoma", Font.PLAIN, 18));
		Nombre.setBounds(322, 106, 324, 31);
		panel.add(Nombre);
		Nombre.setColumns(10);
		
		Apellido = new JTextField();
		Apellido.setFont(new Font("Tahoma", Font.PLAIN, 18));
		Apellido.setColumns(10);
		Apellido.setBounds(322, 160, 324, 31);
		panel.add(Apellido);
		
		Email = new JTextField();
		Email.setFont(new Font("Tahoma", Font.PLAIN, 18));
		Email.setColumns(10);
		Email.setBounds(322, 215, 324, 31);
		panel.add(Email);
		
		contrasena = new JPasswordField(10);
		contrasena.setFont(new Font("Tahoma", Font.PLAIN, 18));
		contrasena.setColumns(10);
		contrasena.setBounds(322, 268, 324, 31);
		panel.add(contrasena);
		
		JButton btnNewButton = new JButton("REGISTRARSE");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Nombre.getText().equals("")||Apellido.getText().equals("")||Email.getText().equals("")||contrasena.getText().equals("")) {
					JOptionPane.showMessageDialog(Nombre, "Por Favor llene los campos", "Error 404", JOptionPane.ERROR_MESSAGE);
				}else {
					Login nuevo = new Login(Nombre.getText(), Apellido.getText(), Email.getText(), contrasena.getText());
					logg.add(nuevo);
					
					ConexionUsuarioMongoDB conecc = new ConexionUsuarioMongoDB();
					conecc.UsuarioAdmin(nuevo);
					
					JOptionPane.showMessageDialog(Nombre, "Datos Guardados Exitosamente", "CORRECTO", JOptionPane.INFORMATION_MESSAGE);
					
					InterfazRegistro.this.dispose();
					InterfazLogin ventana = new InterfazLogin();
					ventana.setVisible(true);
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton.setBounds(132, 350, 124, 31);
		panel.add(btnNewButton);
		
		JButton btnRegistrarse = new JButton("CANCELAR");
		btnRegistrarse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InterfazRegistro.this.dispose();
				InterfazLogin ventana = new InterfazLogin();
				ventana.setVisible(true);
			}
		});
		btnRegistrarse.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnRegistrarse.setBounds(484, 350, 124, 31);
		panel.add(btnRegistrarse);
	}

}
