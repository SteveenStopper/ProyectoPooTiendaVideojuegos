package mundo.InterfazGrafica;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import mundo.ConexionMongoDB.ConexionMongoDB;
import mundo.TiendaVideojuegos.Juegos;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.Font;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JTextField;

public class VentanaJuegosGeneral extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTable table_1;
	
	public static JComboBox<String> comboBoxJuegos = new JComboBox<String>();
	public static boolean borrarJuego = false;
	private JTextField textFieldCodigo;
	private JTextField textFieldGenero;
	private JTextField textFieldPrecio;
	private JTextField textFieldKey;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaJuegosGeneral frame = new VentanaJuegosGeneral();
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
	public VentanaJuegosGeneral() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 844, 607);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setBounds(0, 0, 830, 169);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(0, 0, 172, 169);
		panel.add(lblNewLabel);
		lblNewLabel.setIcon(new ImageIcon("Imagenes/LOgo 2.jpeg"));
		
		JButton btnRegistarJuego = new JButton("Nuevo Juego");
		btnRegistarJuego.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaRegistrarJuego ventana = new VentanaRegistrarJuego();
				ventana.setVisible(true);
			}
		});
		btnRegistarJuego.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnRegistarJuego.setBounds(269, 71, 155, 27);
		panel.add(btnRegistarJuego);
		
		JButton btnEliminarJuego = new JButton("Eliminar juego");
		btnEliminarJuego.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comboBoxJuegos.getSelectedItem() == null){
					JOptionPane.showMessageDialog(null, "No hay un juego seleccionado", "ERROR", JOptionPane.ERROR_MESSAGE);
				}else{
					VentanaRegistrarJuego.tiendita.eliminarJuego(comboBoxJuegos.getSelectedItem().toString());
					ConexionMongoDB conec = new ConexionMongoDB();
					conec.deleteDB(comboBoxJuegos.getSelectedItem().toString());
				}			
			}
		});
		
		btnEliminarJuego.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnEliminarJuego.setBounds(506, 71, 155, 27);
		panel.add(btnEliminarJuego);
		
		JButton btnRegresar = new JButton("");
		btnRegresar.setBackground(Color.BLACK);
		btnRegresar.setIcon(new ImageIcon("Imagenes/back_48px.png"));
		btnRegresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaJuegosGeneral.this.dispose();
				VentanaTiendaVideoJuegos ventana = new VentanaTiendaVideoJuegos();
				ventana.setVisible(true);
			}
		});
		btnRegresar.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnRegresar.setVerticalAlignment(SwingConstants.TOP);
		btnRegresar.setBounds(766, 10, 54, 56);
		panel.add(btnRegresar);
		btnRegresar.setSelectedIcon(null);
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 168, 830, 405);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		comboBoxJuegos.setFont(new Font("Tahoma", Font.BOLD, 22));
		
		comboBoxJuegos.setBounds(10, 25, 208, 30);
		panel_1.add(comboBoxJuegos);
		
		JButton btnRefrescar = new JButton("");
		btnRefrescar.setIcon(new ImageIcon("Imagenes/refresh_30px.png"));
		btnRefrescar.setBackground(null); 
		btnRefrescar.setBounds(228, 25, 40, 30);
		panel_1.add(btnRefrescar);
		btnRefrescar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel lblNewLabel_1 = new JLabel("Codigo");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1.setBounds(10, 89, 122, 25);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Genero");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_2.setBounds(10, 148, 122, 25);
		panel_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Precio");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_3.setBounds(10, 206, 122, 25);
		panel_1.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("# Key's");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_4.setBounds(10, 262, 122, 25);
		panel_1.add(lblNewLabel_4);
		
		textFieldCodigo = new JTextField();
		textFieldCodigo.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldCodigo.setEditable(false);
		textFieldCodigo.setFont(new Font("Tahoma", Font.PLAIN, 19));
		textFieldCodigo.setBounds(158, 88, 166, 26);
		panel_1.add(textFieldCodigo);
		textFieldCodigo.setColumns(10);
		
		textFieldGenero = new JTextField();
		textFieldGenero.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldGenero.setEditable(false);
		textFieldGenero.setFont(new Font("Tahoma", Font.PLAIN, 19));
		textFieldGenero.setBounds(158, 147, 166, 26);
		panel_1.add(textFieldGenero);
		textFieldGenero.setColumns(10);
		
		textFieldPrecio = new JTextField();
		textFieldPrecio.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldPrecio.setEditable(false);
		textFieldPrecio.setFont(new Font("Tahoma", Font.PLAIN, 19));
		textFieldPrecio.setBounds(158, 205, 166, 26);
		panel_1.add(textFieldPrecio);
		textFieldPrecio.setColumns(10);
		
		textFieldKey = new JTextField();
		textFieldKey.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldKey.setEditable(false);
		textFieldKey.setFont(new Font("Tahoma", Font.PLAIN, 19));
		textFieldKey.setBounds(158, 261, 166, 26);
		panel_1.add(textFieldKey);
		textFieldKey.setColumns(10);
		
		JButton btnComprarJuego = new JButton("Comprar");
		btnComprarJuego.setBounds(49, 350, 102, 27);
		panel_1.add(btnComprarJuego);
		btnComprarJuego.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comboBoxJuegos.getSelectedItem() == null){
					JOptionPane.showMessageDialog(null, "No hay un juego seleccionado", "ERROR", JOptionPane.ERROR_MESSAGE);
				}else{
					int num=0;
					num=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero de Key's a comprar"));
					while (num<=0) {
						JOptionPane.showMessageDialog(null, "Debe ingresar al menos una Key", "ERROR", JOptionPane.ERROR_MESSAGE);
						num=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero de Key's a comprar"));
					}
					if (num != 0) {
						VentanaRegistrarJuego.tiendita.AumentarJuegos(comboBoxJuegos.getSelectedItem().toString(), num);
						ConexionMongoDB conec = new ConexionMongoDB();
						conec.updateBD(comboBoxJuegos.getSelectedItem().toString(), num);
					}
					
				}		
			}
		});
		btnComprarJuego.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		JButton btnVenderJuego = new JButton("Vender");
		btnVenderJuego.setBounds(200, 350, 102, 27);
		panel_1.add(btnVenderJuego);
		btnVenderJuego.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comboBoxJuegos.getSelectedItem() == null){
					JOptionPane.showMessageDialog(null, "No hay un juego seleccionado", "Eliminar", JOptionPane.ERROR_MESSAGE);
				}else{
					Juegos buscar = VentanaRegistrarJuego.tiendita.buscarNombre(comboBoxJuegos.getSelectedItem().toString());
					if (buscar.getCantidadActual() <= 0 ){
						JOptionPane.showMessageDialog(null, "Este juego no tiene Key's", "ERROR", JOptionPane.ERROR_MESSAGE);
					}else {
						int num=0;
						num=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero de Key's a vender"));
						while (num<=0) {
							JOptionPane.showMessageDialog(null, "Debe ingresar al menos una Key", "ERROR", JOptionPane.ERROR_MESSAGE);
							num=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero de Key's a vender"));
						}
						if (buscar.getCantidadActual() < num) {
							JOptionPane.showMessageDialog(null, "No hay suficientes Key's para la venta", "ERROR", JOptionPane.ERROR_MESSAGE);
						}else if (num != 0) {
							VentanaRegistrarJuego.tiendita.venderJuego(comboBoxJuegos.getSelectedItem().toString(), num);
							ConexionMongoDB conec = new ConexionMongoDB();
							conec.updateBD(comboBoxJuegos.getSelectedItem().toString(), num);
						}
					}					
				}	
			}
		});
		btnVenderJuego.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon("Imagenes/Publicidad 5.jpeg"));
		lblNewLabel_5.setBounds(386, 72, 434, 236);
		panel_1.add(lblNewLabel_5);
		
		JButton btnMostrar = new JButton("Mostrar");
		btnMostrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (comboBoxJuegos.getSelectedItem() == null) {
					JOptionPane.showMessageDialog(null, "No hay un juego seleccionado", "ERROR", JOptionPane.ERROR_MESSAGE);
					textFieldCodigo.setText(null);
					textFieldGenero.setText(null);
					textFieldPrecio.setText(null);
					textFieldKey.setText(null);
				} else {
					Juegos buscar = VentanaRegistrarJuego.tiendita.buscarNombre(comboBoxJuegos.getSelectedItem().toString());
					textFieldCodigo.setText(Integer.toString(buscar.getCodigo()));
					textFieldGenero.setText(buscar.getGenero().toString());
					textFieldPrecio.setText(String.valueOf(buscar.getCosto()));
					textFieldKey.setText(Integer.toString(buscar.getCantidadActual()));
				}
				
			}
		});
		btnMostrar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnMostrar.setBounds(127, 307, 85, 21);
		panel_1.add(btnMostrar);
		
		btnRefrescar.addActionListener(new ActionListener() {	
			public void actionPerformed(ActionEvent e) {
				comboBoxJuegos.removeAllItems();
				for (int i = 0; i<VentanaRegistrarJuego.tiendita.getBiblioteca().size() ; i++) {				
					comboBoxJuegos.addItem(VentanaRegistrarJuego.tiendita.getBiblioteca().get(i).getNombre());				
				}				
			}
		});
	}
}
