package co.binarytree.logica;

public class Main {

	public static void main(String[] args) {
		Arbol tree = new Arbol(); 
        tree.setRaiz(new Nodo(70)); 
        tree.getRaiz().setIzquierda(new Nodo(49)); 
        tree.getRaiz().setDerecha(new Nodo(84)); 
        tree.getRaiz().getIzquierda().setIzquierda(new Nodo(37)); 
        tree.getRaiz().getIzquierda().setDerecha(new Nodo(54)); 
        tree.getRaiz().getDerecha().setIzquierda(new Nodo(78)); 
        tree.getRaiz().getDerecha().setDerecha(new Nodo(85)); 
        tree.getRaiz().getIzquierda().getIzquierda().setIzquierda(new Nodo(22));
        tree.getRaiz().getIzquierda().getIzquierda().setDerecha(new Nodo(40));
        tree.getRaiz().getIzquierda().getDerecha().setIzquierda(new Nodo(51));
        tree.getRaiz().getDerecha().getIzquierda().setIzquierda(new Nodo(76));
        tree.getRaiz().getDerecha().getIzquierda().setDerecha(new Nodo(80));
        
        
        System.out.println("(40, 78): " + tree.buscarPadreComun(40,78));
//        System.out.println("(51, 37): " + tree.buscarPadreComun(51,37));
//        System.out.println("(76, 85): " + tree.buscarPadreComun(76,85));
	}
	

}
