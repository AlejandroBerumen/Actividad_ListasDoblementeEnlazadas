import java.util.Scanner;
class Nodo{
	private int dato;
	private Nodo nodoSiguiente;
	private Nodo nodoAnterior;
	public Nodo() {}
	public Nodo(int dato) {
		this.dato = dato;
	}
	public int getDato() {
		return dato;
	}
	public void setDato(int dato) {
		this.dato = dato;
	}
	public Nodo getNodoSiguiente() {
		return nodoSiguiente;
	}
	public void setNodoSiguiente(Nodo nodoSiguiente) {
		this.nodoSiguiente = nodoSiguiente;
	}
	
	public Nodo getNodoAnterior() {
		return nodoAnterior;
	}
	public void setNodoAnterior(Nodo nodoAnterior) {
		this.nodoAnterior = nodoAnterior;
	}
}
class ListaEnlazada{
	Nodo nodoInicio;
	Nodo nodoFin;
	public ListaEnlazada() {
		nodoInicio = nodoFin = null;
	}
	public boolean listaVacia() {
		if(nodoInicio==null)
			return true;
		else
			return false;	
	}
	public int cantidadElementos() {
		int cantidad = 0;
		Nodo nodoActual = nodoInicio;		
		while(nodoActual != null) {
			cantidad++;
			nodoActual = nodoActual.getNodoSiguiente();
		}
		return cantidad;
	}
	public void insertarInicio(int x) {
		Nodo nuevoNodo = new Nodo(x);
		if(listaVacia()) {
			nodoInicio = nodoFin = nuevoNodo;
		}else {
			nodoInicio.setNodoAnterior(nuevoNodo);
			nuevoNodo.setNodoSiguiente(nodoInicio);
			nodoInicio = nuevoNodo;
		}
	}
	public void insertarFinal(int dato) {
		Nodo nuevoNodo = new Nodo(dato);
		nodoFin.setNodoSiguiente(nuevoNodo);
		nodoFin = nuevoNodo;
	}
	public void eliminarInicio() {
		if(listaVacia()) {
			System.out.println("\nError al eliminar: La lista está vacía");
		}else if(nodoInicio==nodoFin) {
			nodoInicio = nodoFin = null;
			System.out.println("\nSe eliminó el elemento inicial con éxito");
		}else {
			Nodo nodoEliminado = nodoInicio;
			nodoInicio = nodoInicio.getNodoSiguiente();
			nodoEliminado = null;
			System.out.println("\nSe eliminó el elemento inicial con éxito");
		}
	}
	public void eliminarFinal() {
		if(listaVacia()) {
			System.out.println("\nError al eliminar: La lista está vacía");
		}else if(nodoInicio==nodoFin) {
			nodoInicio = nodoFin = null;
			System.out.println("\nSe eliminó el elemento final con éxito");
		}else {
			Nodo nodoEliminado = nodoInicio;
			while(nodoEliminado.getNodoSiguiente()!=nodoFin) {
				nodoEliminado = nodoEliminado.getNodoSiguiente();
			}
			nodoFin = nodoEliminado;
			nodoFin.setNodoSiguiente(null);
			System.out.println("\nSe eliminó el elemento final con éxito");
		}
	}
	public void eliminarEspecifico(int posicion) {
		if(posicion>cantidadElementos()) {
			System.out.println("\nError al eliminar: La posicion elegida no existe");
		}else if(posicion==1)
			eliminarInicio();
		else if(posicion==cantidadElementos())
			eliminarFinal();
		else {
			Nodo nodoActual = nodoInicio;
			Nodo nodoEliminado;
			for(int i=1; i<posicion; i++) {
				nodoActual = nodoActual.getNodoSiguiente();
			}
			nodoEliminado = nodoActual;
			nodoEliminado.getNodoSiguiente().setNodoAnterior(nodoEliminado.getNodoAnterior());
			nodoEliminado.getNodoAnterior().setNodoSiguiente(nodoEliminado.getNodoSiguiente());
			nodoEliminado = null;
		}
	}
	public void mostrarElementos() {
		Nodo nodoActual = nodoInicio;	
		System.out.println();
		while(nodoActual != null) {
			System.out.print("<-- ["+nodoActual.getDato()+"] --> ");
			nodoActual = nodoActual.getNodoSiguiente();
		}
		System.out.println();
	}
}
public class Actividad {
	public static void main(String[] args) {
		Scanner x = new Scanner(System.in);
		ListaEnlazada lista = new ListaEnlazada();
		/*lista.insertarInicio(7);
		lista.insertarInicio(6);
		lista.insertarInicio(5);
		lista.insertarInicio(4);
		lista.insertarInicio(3);
		lista.insertarInicio(2);*/
		int elec = 0;
		while(elec!=7) {
		System.out.println("\nPrograma de listas doblemente enlazadas.\n\nElija una opción\n1.- Agregar elemento al inicio\n2.- Agregar elemento al final\n3.- Eliminar primer elemento\n4.- Eliminar último elemento\n5.- Eliminar elemento específico\n6.- Mostrar lista\n7.- Salir");
		elec = x.nextInt();
		switch(elec) {
			case 1:
				System.out.println("\nInserte dato que desea agregar al inicio:");
				int dato = x.nextInt();
				lista.insertarInicio(dato);
				break;
			case 2:
				System.out.println("\nInserte dato que desea agregar al final:");
				int dato2 = x.nextInt();
				lista.insertarFinal(dato2);
				break;
			case 3:
				lista.eliminarInicio();
				break;
			case 4:
				lista.eliminarFinal();
				break;
			case 5:
				System.out.println("\nInserte la posición del nodo que desea borrar:");
				int pos = x.nextInt();
				lista.eliminarEspecifico(pos);
				break;
			case 6:
				lista.mostrarElementos();
				break;
		}
		}
	}
}
