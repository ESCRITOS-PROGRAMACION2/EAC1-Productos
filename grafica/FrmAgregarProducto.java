package grafica;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import logica.*;

public class FrmAgregarProducto extends JFrame {

	private JPanel contentPane;
	private JTextField txtCodigo, txtNombre, txtPrecio, txtNivel, txtPromocion;
	private JCheckBox chkLimpieza;
	private JButton btnAgregar, btnCalcular, btnLimpiar;
	private JTextArea textAreaProductos;
	private JLabel lblFechaFab;
	private JTextField txtAnioFab;

	private ListaProductos listaP;
	private JButton btnEliminar;

	public FrmAgregarProducto() {
		listaP = new ListaProductos(); // Inicializar ListaProductos
		setTitle("Gestión de Productos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 450);
		iniciarComponentes();
		iniciarManejadoresEventos();
	}

	private void iniciarComponentes() {
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// Panel de Datos del Vehículo
		JPanel panel1 = new JPanel();
		panel1.setBackground(Color.LIGHT_GRAY);
		panel1.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(128, 128, 128)),
				"Datos del Producto", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel1.setBounds(10, 10, 236, 190);
		contentPane.add(panel1);
		panel1.setLayout(null);

		JLabel lblCodigo = new JLabel("Código:");
		lblCodigo.setBounds(10, 25, 80, 20);
		panel1.add(lblCodigo);

		txtCodigo = new JTextField();
		txtCodigo.setBounds(100, 25, 120, 20);
		panel1.add(txtCodigo);

		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(10, 55, 80, 20);
		panel1.add(lblNombre);

		txtNombre = new JTextField();
		txtNombre.setBounds(100, 55, 120, 20);
		panel1.add(txtNombre);

		JLabel lblPrecio = new JLabel("Precio:");
		lblPrecio.setBounds(10, 86, 80, 20);
		panel1.add(lblPrecio);

		txtPrecio = new JTextField();
		txtPrecio.setBounds(100, 86, 120, 20);
		panel1.add(txtPrecio);

		lblFechaFab = new JLabel("Año fabricación:");
		lblFechaFab.setBounds(10, 129, 110, 14);
		panel1.add(lblFechaFab);

		txtAnioFab = new JTextField();
		txtAnioFab.setBounds(134, 123, 86, 20);
		panel1.add(txtAnioFab);
		txtAnioFab.setColumns(10);

		// Panel de Datos del Producto
		JPanel panel2 = new JPanel();
		panel2.setBackground(Color.LIGHT_GRAY);
		panel2.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(128, 128, 128)),
				"Datos del producto de limpieza", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel2.setBounds(256, 10, 213, 100);
		contentPane.add(panel2);
		panel2.setLayout(null);

		JLabel lblNivel = new JLabel("Nivel:");
		lblNivel.setBounds(10, 60, 80, 20);
		panel2.add(lblNivel);

		txtNivel = new JTextField();
		txtNivel.setBounds(59, 60, 100, 20);
		txtNivel.setEnabled(false); // Inicialmente deshabilitado
		panel2.add(txtNivel);

		// CheckBox para habilitar/deshabilitar el campo de l
		chkLimpieza = new JCheckBox("¿Es de limpieza?");
		chkLimpieza.setBounds(10, 25, 149, 20);
		panel2.add(chkLimpieza);

		// Panel de Promoción
		JPanel panel3 = new JPanel();
		panel3.setBackground(Color.LIGHT_GRAY);
		panel3.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.WHITE, Color.GRAY),
				"Cálculo de la promoción", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
		panel3.setBounds(256, 120, 213, 80);
		contentPane.add(panel3);
		panel3.setLayout(null);

		btnCalcular = new JButton("Calcular");
		btnCalcular.setBounds(10, 30, 90, 25);
		panel3.add(btnCalcular);

		txtPromocion = new JTextField();
		txtPromocion.setEditable(false);
		txtPromocion.setBounds(110, 30, 90, 25);
		panel3.add(txtPromocion);

		// JTextArea para mostrar la lista de Productos
		textAreaProductos = new JTextArea();
		textAreaProductos.setEditable(false);
		JScrollPane scrollPaneProductos = new JScrollPane(textAreaProductos);
		scrollPaneProductos.setBounds(10, 210, 460, 130);
		contentPane.add(scrollPaneProductos);

		// Botón para agregar un Producto
		btnAgregar = new JButton("Agregar");
		btnAgregar.setBounds(174, 377, 117, 23);
		contentPane.add(btnAgregar);

		btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(308, 377, 117, 23);
		contentPane.add(btnEliminar);

		btnLimpiar = new JButton("Limpiar");
		btnLimpiar.setBounds(63, 377, 90, 23);
		contentPane.add(btnLimpiar);
	}

	private void iniciarManejadoresEventos() {
		// Acción del botón "Agregar Producto"
		btnAgregar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				agregarProducto();
			}
		});

		// Acción del botón "Calcular" para la promoción
		btnCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calcularPromocion();
			}
		});

		// Acción del botón "Limpiar"
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiarCampos();
			}
		});

		// Acción del JCheckBox para habilitar/deshabilitar el campo de limpieza
		chkLimpieza.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtNivel.setEnabled(chkLimpieza.isSelected());
			}
		});
		
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String cod=JOptionPane.showInputDialog("Ingrese cod a eliminar");
					listaP.eliminarProducto(Integer.valueOf(cod));
					actualizarListaProductos();
					JOptionPane.showMessageDialog(null, "Producto eliminado correctamente");
				}catch(Exception ex) {
					JOptionPane.showMessageDialog(null, ex);
				}
			}
		});
	}// fin iniciarManejadoresEventos

	// Método para agregar un Producto a la lista y actualizar el JTextArea
	private void agregarProducto() {
		if (!camposVacios()) {

			try {
				int codigo = Integer.valueOf(txtCodigo.getText());
				String nombre = txtNombre.getText();
				double precio = Double.parseDouble(txtPrecio.getText());
				int anioFab = chkLimpieza.isSelected() ? Integer.parseInt(txtNivel.getText()) : 0;
				int nivel;
				if (chkLimpieza.isSelected()) {
					nivel = Integer.parseInt(txtNivel.getText());
					ProductoLimpieza b = new ProductoLimpieza(codigo, nombre, precio, anioFab, nivel);
					listaP.insertarProducto(b);
					actualizarListaProductos(); // Actualizar el JTextArea
					limpiarCampos(); // Limpiar los campos después de agregar
				} else {
					Producto a = new Producto(codigo, nombre, precio, anioFab);
					listaP.insertarProducto(a);
					actualizarListaProductos();
					limpiarCampos();
				}
			} catch (NumberFormatException ex) {
				JOptionPane.showMessageDialog(this,
						"Error: Ingrese valores numéricos válidos en los campos de Precio y Cilindrada.",
						"Error de Formato", JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	// Método para calcular la promoción y mostrar el precio con descuento
	private void calcularPromocion() {
		// Verificar si los campos requeridos están vacíos
		if (!camposVacios()) {

			try {
				int codigo = Integer.valueOf(txtCodigo.getText());
				String nombre = txtNombre.getText();
				double precio = Double.parseDouble(txtPrecio.getText());
				int anioFab = chkLimpieza.isSelected() ? Integer.parseInt(txtNivel.getText()) : 0;
				int nivel;
				if (chkLimpieza.isSelected()) {
					nivel = Integer.parseInt(txtNivel.getText());
					ProductoLimpieza b = new ProductoLimpieza(codigo, nombre, precio, anioFab, nivel);
					double precioConDescuento = b.promocion();
					txtPromocion.setText(String.valueOf(precioConDescuento));
				}else {
					Producto p = new Producto(codigo, nombre, precio, anioFab);
					double precioConDescuento = p.promocion();
					txtPromocion.setText(String.valueOf(precioConDescuento));
				}
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(this,
						"Error: Ingrese valores numéricos válidos en los campos de Precio y Cilindrada para calcular la promoción.",
						"Error de Formato", JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	// Método para limpiar los campos de texto
	private void limpiarCampos() {
		txtCodigo.setText("");
		txtNombre.setText("");
		txtPrecio.setText("");
		txtAnioFab.setText("");
		txtNivel.setText("");
		txtPromocion.setText("");
		chkLimpieza.setSelected(false);
		txtNivel.setEnabled(false); // Deshabilita el campo de cilindrada al limpiar
	}

	// Método para actualizar el JTextArea con la lista de autos
	private void actualizarListaProductos() {
		textAreaProductos.setText(listaP.listarProductos());
	}

	// Chequea si hay algún campo vacío
	private boolean camposVacios() {
		boolean vacio = false;
		if (txtCodigo.getText().isEmpty() || txtNombre.getText().isEmpty() || txtPrecio.getText().isEmpty()
				|| (chkLimpieza.isSelected() && txtNivel.getText().isEmpty())) {
			JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos para calcular la promoción.",
					"Campos vacíos", JOptionPane.WARNING_MESSAGE);
			vacio = true;
		}
		return vacio;
	}

	public static void main(String[] args) {
		FrmAgregarProducto vent = new FrmAgregarProducto();
		vent.setVisible(true);
	}
}
