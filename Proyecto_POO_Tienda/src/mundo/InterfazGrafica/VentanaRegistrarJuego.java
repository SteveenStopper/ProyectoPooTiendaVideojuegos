package mundo.InterfazGrafica;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import mundo.ConexionMongoDB.ConexionMongoDB;
import mundo.TiendaVideojuegos.Juegos;
import mundo.TiendaVideojuegos.TiendaVideojuegos;
import mundo.TiendaVideojuegos.Juegos.Genero;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collection;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.SystemColor;

public class VentanaRegistrarJuego extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldCodigo;
	private JTextField textFieldNombre;
	private JTextField textFieldPrecio;
	private JComboBox comboBoxGenero = new JComboBox();
	
	public static TiendaVideojuegos tiendita = new TiendaVideojuegos();
	public static ConexionMongoDB conecta = new ConexionMongoDB();
	
	
	public TiendaVideojuegos getTiendita() {
		return tiendita;
	}

	public void setTiendita(TiendaVideojuegos tiendita) {
		this.tiendita = tiendita;
	}

	public ConexionMongoDB getConecta() {
		return conecta;
	}

	public void setConecta(ConexionMongoDB conecta) {
		this.conecta = conecta;
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaRegistrarJuego frame = new VentanaRegistrarJuego();
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
	public VentanaRegistrarJuego() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 426, 356);
		contentPane = new JPanel();
		contentPane.setForeground(Color.BLACK);
		contentPane.setBackground(SystemColor.desktop);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nombre");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 22));
		lblNewLabel.setBounds(32, 88, 116, 19);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Codigo");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Verdana", Font.BOLD, 22));
		lblNewLabel_1.setBounds(32, 36, 116, 25);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Precio");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Verdana", Font.BOLD, 22));
		lblNewLabel_2.setBounds(32, 145, 116, 19);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Genero");
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setFont(new Font("Verdana", Font.BOLD, 22));
		lblNewLabel_3.setBounds(32, 189, 116, 19);
		contentPane.add(lblNewLabel_3);
		
		textFieldCodigo = new JTextField();
		textFieldCodigo.setFont(new Font("Dialog", Font.PLAIN, 15));
		textFieldCodigo.setBounds(173, 41, 187, 25);
		contentPane.add(textFieldCodigo);
		textFieldCodigo.setColumns(10);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setFont(new Font("Dialog", Font.PLAIN, 15));
		textFieldNombre.setBounds(173, 88, 187, 24);
		contentPane.add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		textFieldPrecio = new JTextField();
		textFieldPrecio.setFont(new Font("Dialog", Font.PLAIN, 15));
		textFieldPrecio.setBounds(173, 139, 187, 25);
		contentPane.add(textFieldPrecio);
		textFieldPrecio.setColumns(10);
		
		
		comboBoxGenero.setFont(new Font("Tahoma", Font.BOLD, 14));
		comboBoxGenero.setModel(new DefaultComboBoxModel(Juegos.Genero.values()));
		comboBoxGenero.setBounds(173, 193, 187, 25);
		contentPane.add(comboBoxGenero);
		
		JButton btnRegistrar = new JButton("Registrar");
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegistroJuego();
			}
		});
		btnRegistrar.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnRegistrar.setBounds(70, 264, 134, 29);
		contentPane.add(btnRegistrar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaRegistrarJuego.this.dispose();
			}
		});
		btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnCancelar.setBounds(226, 264, 134, 29);
		contentPane.add(btnCancelar);
	}
	
	public void RegistroJuego() {
		if (textFieldCodigo.getText().equals("") || textFieldNombre.getText().equals("") || textFieldPrecio.getText().equals("")
				|| textFieldCodigo.getText().equals(" ") || textFieldNombre.getText().equals(" ") || textFieldPrecio.getText().equals(" ")) {
			JOptionPane.showMessageDialog(null, "Faltan datos del juego", "ERROR", JOptionPane.ERROR_MESSAGE);
		} else {
			
			int codigo = Integer.parseInt(textFieldCodigo.getText());
			double precio = Double.parseDouble(textFieldPrecio.getText());
			
			Juegos nuevo = tiendita.nuevoJuego(textFieldNombre.getText(), codigo, (Genero)comboBoxGenero.getSelectedItem(), precio);
			
			conecta.ConexionMongoDB(nuevo);
			
			JOptionPane.showMessageDialog(null, "JUEGO RESGISTRADO", "Registro", JOptionPane.INFORMATION_MESSAGE);
			
			textFieldCodigo.setText(null);
			textFieldNombre.setText(null);
			textFieldPrecio.setText(null);
			
			VentanaRegistrarJuego.this.dispose();
			
		}
	}
	
	
}
