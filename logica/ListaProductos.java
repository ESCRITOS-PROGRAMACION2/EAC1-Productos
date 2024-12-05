package logica;
import java.util.ArrayList;

public class ListaProductos {
	private ArrayList<Producto> lista; //declara la lista
	
	//constructor
	public 	ListaProductos() {
		lista=new ArrayList<>(); //crear la lista vacia
	}
	
	public void insertarProducto(Producto p) {
		lista.add(p);
	}
	
	//elimina el producto dado el codigo
	public void eliminarProducto(int codigo) {
		
		int x=0;
		boolean encontre=false;
		do{
			if(lista.get(x).getCodigo()==codigo) {
				lista.remove(x);
				encontre=true;
			 }else
				x++;
		 }while( x<lista.size()&&!encontre);
					
	
	}
	//devuelve el producto que está en la posición i
	public Producto devolver(int i) {
		
		return (lista.get(i));
	}
	
	public String toString() {
		return lista.toString();
	}

	//toString con formato
    public String listarProductos() {
    	String listaFinal="Código\tNombre \tPrecio \tAnio Fab\tNivel\n";
        if (lista.isEmpty()) 
            return "No hay productos en la lista.";
        else {
            for (int i = 0; i < lista.size(); i++) {
                listaFinal += lista.get(i).toString()+"\n";
                
            }
            return listaFinal;
        }
    }
}
