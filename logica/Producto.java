package logica;

public class Producto {
	private int codigo;
	private String nombre;
	private double precio;
	private int anioFab;
	
	public Producto(int codigo, String nombre, double precio, int anioFab) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.precio = precio;
		this.anioFab = anioFab;
	}

	public Producto() {
		
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public int getAnioFab() {
		return anioFab;
	}

	public void setAnioFab(int anioFab) {
		this.anioFab = anioFab;
	}

	@Override
	public String toString() {
		return codigo + "\t "
				+ nombre + "\t "
				+ precio + "\t "
				+ anioFab;
	}
	
	//si el precio es mayor de 300 la promocion será 10% sino 0
	public double promocion() {
		if(this.getPrecio()>300)
			return this.getPrecio()-this.getPrecio()*0.10;
		else
			return this.getPrecio();
		
	}
}
