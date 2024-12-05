package logica;

public class ProductoLimpieza extends Producto{
	private int nivel;
	
	//constructor por defecto
	public ProductoLimpieza() {
		super();
	}

	//constructor especifico
	public ProductoLimpieza(int codigo, String nombre, double precio, int anioFab, int nivel) {
		super(codigo, nombre, precio, anioFab);
		this.nivel = nivel;
	}

	public int getNivel() {
		return nivel;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}

	@Override
	public String toString() {
		return super.toString()+"\t" + nivel;
	}
	
	

}
