package grafica;
import logica.*;
import java.util.Scanner;
public class Principal {

	public static void main(String[] args) {
		Scanner teclado=new Scanner(System.in);
		ListaProductos listado=new ListaProductos();
		
		Producto prod1=new Producto();
		Producto prod2=new Producto(120,"zapato",2300.5,2000);
		ProductoLimpieza prod3=new ProductoLimpieza(380,"Escoba",140.5,1850,3);
		System.out.println("Producto 1 tiene: "+prod1.toString());
		System.out.println("Producto 2 tiene: "+prod2.toString());
		prod1.setNombre("camiseta");
		System.out.println("El nombre de Producto 1 es: "+prod1.getNombre());
		System.out.println("El prod de limpieza es: "+prod3.toString());
		System.out.println("Ingrese un nuevo año de fabricación:");
		prod3.setAnioFab(teclado.nextInt());
		System.out.println("El prod de limpieza es: "+prod3.getAnioFab());
		listado.insertarProducto(prod1);
		listado.insertarProducto(prod2);
		listado.insertarProducto(prod3);
		System.out.println("Listado de productos: "+listado.toString());
		listado.eliminarProducto(120);
		System.out.println("Listado de productos: "+listado.toString());
		listado.eliminarProducto(344);
		System.out.println("Listado de productos: "+listado.toString());
		
	}

}
