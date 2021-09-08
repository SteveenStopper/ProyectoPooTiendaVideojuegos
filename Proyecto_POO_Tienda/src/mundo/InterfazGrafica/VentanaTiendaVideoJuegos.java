package mundo.InterfazGrafica;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

public class VentanaTiendaVideoJuegos extends JFrame {

	private JPanel contentPane;
	private JButton btnJuegosMasVendidos;
	private JTextField txtNombre;
	private JTextField txtCodigo;
	private JTextField txtPrecio;
	private JTextField txtGenero;
	private JTextField txtNombre1;
	private JTextField txtCodigo1;
	private JTextField txtPrecio1;
	private JTextField txtGenero1;
	private JTextField txtNombre2;
	private JTextField txtCodigo2;
	private JTextField txtPrecio2;
	private JTextField txtGenero2;
	private JLabel imagen;
	private JLabel imagen1;
	private JLabel imagen2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaTiendaVideoJuegos frame = new VentanaTiendaVideoJuegos();
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
	public VentanaTiendaVideoJuegos() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 699, 554);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panelBotones = new JPanel();
		panelBotones.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "GAME ZONE", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(255, 255, 255)));
		panelBotones.setBackground(Color.BLACK);
		panelBotones.setBounds(0, 11, 175, 504);
		contentPane.add(panelBotones);
		panelBotones.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("Imagenes\\Logo.jpeg"));
		lblNewLabel.setBounds(10, 22, 155, 116);
		panelBotones.add(lblNewLabel);
		
		JButton btnComprar = new JButton("Comprar");
		btnComprar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaTiendaVideoJuegos.this.dispose();
				VentanaJuegosGeneral ventana = new VentanaJuegosGeneral();
				ventana.setVisible(true);
			}
		});
		btnComprar.setBounds(10, 164, 155, 34);
		panelBotones.add(btnComprar);
		
		JButton btnJuegos = new JButton("Juegos");
		btnJuegos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				txtNombre.setText("Call of Duty");
				txtCodigo.setText("VZ001");
				txtPrecio.setText("30");
				txtGenero.setText("Disparos");
				
				txtNombre1.setText("Left 4 Dead");
				txtCodigo1.setText("VZ002");
				txtPrecio1.setText("20");
				txtGenero1.setText("Supervivencia");
				
				txtNombre2.setText("Darksiders");
				txtCodigo2.setText("VZ003");
				txtPrecio2.setText("15");
				txtGenero2.setText("Accion");
				
				
				
			}
		});
		btnJuegos.setBounds(10, 209, 155, 31);
		panelBotones.add(btnJuegos);
		
		btnJuegosMasVendidos = new JButton("Juegos mas Vendidos");
		btnJuegosMasVendidos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				txtNombre.setText("Grand Theft Auto V");
				txtCodigo.setText("VZ004");
				txtPrecio.setText("30");
				txtGenero.setText("Accion-Aventura");
				
				txtNombre1.setText("Read Red Redemption2");
				txtCodigo1.setText("VZ005");
				txtPrecio1.setText("20");
				txtGenero1.setText("Accion-Aventura");
				
				txtNombre2.setText("Hitman 3");
				txtCodigo2.setText("VZ006");
				txtPrecio2.setText("15");
				txtGenero2.setText("Accion");
				
			}
		});
		btnJuegosMasVendidos.setBounds(10, 251, 155, 31);
		panelBotones.add(btnJuegosMasVendidos);
		
		JButton btnJuegosGratis = new JButton("Juegos Gratuitos");
		btnJuegosGratis.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				txtNombre.setText("Rocket League");
				txtCodigo.setText("VZ007");
				txtPrecio.setText("Gratis");
				txtGenero.setText("Deportes");
				
				txtNombre1.setText("Fortnite");
				txtCodigo1.setText("VZ008");
				txtPrecio1.setText("Gratis");
				txtGenero1.setText("Disparos");
				
				txtNombre2.setText("League of Legends");
				txtCodigo2.setText("VZ009");
				txtPrecio2.setText("Gratis");
				txtGenero2.setText("MOBA");
				
			}
		});
		btnJuegosGratis.setBounds(10, 293, 155, 31);
		panelBotones.add(btnJuegosGratis);
		
		JButton btnComprar_4 = new JButton("Cerrar Sesion");
		btnComprar_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaTiendaVideoJuegos.this.dispose();
				InterfazLogin ventana = new InterfazLogin();
				ventana.setVisible(true);
			}
		});
		btnComprar_4.setBounds(10, 462, 155, 31);
		panelBotones.add(btnComprar_4);
		
		JPanel panelJuegos = new JPanel();
		panelJuegos.setBorder(new TitledBorder(null, "JUEGOS", TitledBorder.LEADING, TitledBorder.TOP, null, Color.WHITE));
		panelJuegos.setBackground(new Color(192, 192, 192));
		panelJuegos.setBounds(175, 11, 508, 504);
		contentPane.add(panelJuegos);
		panelJuegos.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre: ");
		lblNewLabel_1.setBounds(200, 14, 51, 15);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelJuegos.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Codigo: ");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_1.setBounds(200, 48, 51, 15);
		panelJuegos.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Precio: ");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_2.setBounds(200, 82, 51, 15);
		panelJuegos.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Genero: ");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_3.setBounds(200, 113, 51, 15);
		panelJuegos.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("Nombre: ");
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_4.setBounds(200, 179, 51, 15);
		panelJuegos.add(lblNewLabel_1_4);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Codigo: ");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_1_1.setBounds(200, 211, 51, 15);
		panelJuegos.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Precio: ");
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_2_1.setBounds(200, 245, 51, 15);
		panelJuegos.add(lblNewLabel_1_2_1);
		
		JLabel lblNewLabel_1_3_1 = new JLabel("Genero: ");
		lblNewLabel_1_3_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_3_1.setBounds(200, 279, 51, 15);
		panelJuegos.add(lblNewLabel_1_3_1);
		
		JLabel lblNewLabel_1_3_1_1 = new JLabel("Genero: ");
		lblNewLabel_1_3_1_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_3_1_1.setBounds(200, 460, 51, 15);
		panelJuegos.add(lblNewLabel_1_3_1_1);
		
		JLabel lblNewLabel_1_2_1_1 = new JLabel("Precio: ");
		lblNewLabel_1_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_2_1_1.setBounds(200, 426, 51, 15);
		panelJuegos.add(lblNewLabel_1_2_1_1);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Codigo: ");
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_1_1_1.setBounds(200, 392, 51, 15);
		panelJuegos.add(lblNewLabel_1_1_1_1);
		
		JLabel lblNewLabel_1_4_1 = new JLabel("Nombre: ");
		lblNewLabel_1_4_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_4_1.setBounds(200, 357, 51, 15);
		panelJuegos.add(lblNewLabel_1_4_1);
		
		txtNombre = new JTextField();
		txtNombre.setEditable(false);
		txtNombre.setBounds(297, 11, 169, 23);
		panelJuegos.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtCodigo = new JTextField();
		txtCodigo.setEditable(false);
		txtCodigo.setColumns(10);
		txtCodigo.setBounds(297, 45, 169, 23);
		panelJuegos.add(txtCodigo);
		
		txtPrecio = new JTextField();
		txtPrecio.setEditable(false);
		txtPrecio.setColumns(10);
		txtPrecio.setBounds(297, 79, 169, 23);
		panelJuegos.add(txtPrecio);
		
		txtGenero = new JTextField();
		txtGenero.setEditable(false);
		txtGenero.setColumns(10);
		txtGenero.setBounds(297, 110, 169, 23);
		panelJuegos.add(txtGenero);
		
		txtNombre1 = new JTextField();
		txtNombre1.setEditable(false);
		txtNombre1.setColumns(10);
		txtNombre1.setBounds(297, 176, 169, 23);
		panelJuegos.add(txtNombre1);
		
		txtCodigo1 = new JTextField();
		txtCodigo1.setEditable(false);
		txtCodigo1.setColumns(10);
		txtCodigo1.setBounds(297, 208, 169, 23);
		panelJuegos.add(txtCodigo1);
		
		txtPrecio1 = new JTextField();
		txtPrecio1.setEditable(false);
		txtPrecio1.setColumns(10);
		txtPrecio1.setBounds(297, 242, 169, 23);
		panelJuegos.add(txtPrecio1);
		
		txtGenero1 = new JTextField();
		txtGenero1.setEditable(false);
		txtGenero1.setColumns(10);
		txtGenero1.setBounds(297, 276, 169, 23);
		panelJuegos.add(txtGenero1);
		
		txtNombre2 = new JTextField();
		txtNombre2.setEditable(false);
		txtNombre2.setColumns(10);
		txtNombre2.setBounds(297, 355, 169, 23);
		panelJuegos.add(txtNombre2);
		
		txtCodigo2 = new JTextField();
		txtCodigo2.setEditable(false);
		txtCodigo2.setColumns(10);
		txtCodigo2.setBounds(297, 389, 169, 23);
		panelJuegos.add(txtCodigo2);
		
		txtPrecio2 = new JTextField();
		txtPrecio2.setEditable(false);
		txtPrecio2.setColumns(10);
		txtPrecio2.setBounds(297, 423, 169, 23);
		panelJuegos.add(txtPrecio2);
		
		txtGenero2 = new JTextField();
		txtGenero2.setEditable(false);
		txtGenero2.setColumns(10);
		txtGenero2.setBounds(297, 457, 169, 23);
		panelJuegos.add(txtGenero2);
		
		JLabel imagen = new JLabel("");
		imagen.setIcon(new ImageIcon("Imagenes\\CallOfDuty.jpeg"));
		imagen.setBounds(10, 15, 155, 113);
		panelJuegos.add(imagen);
		
		JLabel imagen1 = new JLabel("");
		imagen1.setIcon(new ImageIcon("Imagenes\\Left4Dead.jpg"));
		imagen1.setBounds(10, 179, 155, 115);
		panelJuegos.add(imagen1);
		
		JLabel imagen2 = new JLabel("");
		imagen2.setIcon(new ImageIcon("Imagenes\\DarkSiders.jpg"));
		imagen2.setBounds(10, 357, 155, 118);
		panelJuegos.add(imagen2);
		
	}

}
