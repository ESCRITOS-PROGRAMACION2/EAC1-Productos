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
	
	//si el nivel 1 o 2 tendra un 20% de descuento sobre el precio sino 0
	@Override
	public double promocion() {
		double promo1=super.promocion();
		double promo2=0;
		if (nivel==1|| nivel==2)
			promo2=promo1*0.20;
			promo1=promo1-promo2;
		return promo1;
			
			
		
	}
	
	

}

