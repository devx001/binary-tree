package co.binarytree.logica;

import java.util.ArrayList;
import java.util.List;

public class Arbol {

	private Nodo raiz;
	private List<Integer> ruta1;
	private List<Integer> ruta2;

	public Arbol() {
		ruta1 = new ArrayList<>();
		ruta2 = new ArrayList<>();
	}

	public int buscarPadreComun(int n1, int n2) {
		ruta1.clear();
		ruta2.clear();
		return buscarEnRamas(this.raiz, n1, n2);
	}

	private int buscarEnRamas(Nodo root, int n1, int n2) {
		if (!encontrarRuta(root, n1, ruta1) || !encontrarRuta(root, n2, ruta2)) {
			System.out.println((ruta1.size() > 0) ? "Hoja " + n1 + " existe" : "Hoja " + n1 + " no existe");
			System.out.println((ruta2.size() > 0) ? "Hoja " + n2 + " existe" : "Hoja " + n2 + " no existe");
			return -1;
		}
		int i;
		for (i = 0; i < ruta1.size() && i < ruta2.size(); i++) {
			if (!ruta1.get(i).equals(ruta2.get(i)))
				break;
		}
		return ruta1.get(i - 1);
	}

	private boolean encontrarRuta(Nodo raiz, int n, List<Integer> ruta) {
		if (raiz == null) {
			return false;
		}
		ruta.add(raiz.getDato());
		if (raiz.getDato() == n) {
			return true;
		}
		if (raiz.getIzquierda() != null && encontrarRuta(raiz.getIzquierda(), n, ruta)) {
			return true;
		}
		if (raiz.getDerecha() != null && encontrarRuta(raiz.getDerecha(), n, ruta)) {
			return true;
		}
		ruta.remove(ruta.size() - 1);
		return false;
	}

	public Nodo getRaiz() {
		return raiz;
	}

	public void setRaiz(Nodo raiz) {
		this.raiz = raiz;
	}

	private void addNodo(Nodo nodo, Nodo raiz) {
		if (raiz == null) {
			this.setRaiz(nodo);
		} else {
			if (nodo.getDato() <= raiz.getDato()) {
				if (raiz.getIzquierda() == null) {
					raiz.setIzquierda(nodo);
				} else {
					addNodo(nodo, raiz.getIzquierda());
				}
			} else {
				if (raiz.getDerecha() == null) {
					raiz.setDerecha(nodo);
				} else {
					addNodo(nodo, raiz.getDerecha());
				}
			}
		}
	}

	public void addNodo(Nodo nodo) {
		this.addNodo(nodo, this.raiz);
	}
}