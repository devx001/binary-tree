package co.binarytree.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import co.binarytree.logica.Arbol;
import co.binarytree.logica.Nodo;
import co.binarytree.rest.logica.Busqueda;
import co.binarytree.rest.logica.Insercion;

@Path("/binarytree")
public class BinaryTreeService {
	
	private Arbol arbol = new Arbol();

	@POST
	@Path("/create")
	@Produces(MediaType.APPLICATION_JSON)
	public String buildTree(List<Insercion> numeros) {
		arbol.setRaiz(new Nodo(numeros.get(0).getNumero()));
		for (int i = 1; i<numeros.size(); i++) {
			arbol.addNodo(new Nodo(numeros.get(i).getNumero()));
		}
		return "OK Insertado";
	}
	
	@POST
	@Path("/search")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String searchAncestorCommon(Busqueda busqueda) {
		Integer numero1 = busqueda.getNumero1();
		Integer numero2 = busqueda.getNumero2();
		Arbol arbol = new Arbol();
		arbol.setRaiz(new Nodo(70)); 
        arbol.getRaiz().setIzquierda(new Nodo(49)); 
        arbol.getRaiz().setDerecha(new Nodo(84)); 
        arbol.getRaiz().getIzquierda().setIzquierda(new Nodo(37)); 
        arbol.getRaiz().getIzquierda().setDerecha(new Nodo(54)); 
        arbol.getRaiz().getDerecha().setIzquierda(new Nodo(78)); 
        arbol.getRaiz().getDerecha().setDerecha(new Nodo(85)); 
        arbol.getRaiz().getIzquierda().getIzquierda().setIzquierda(new Nodo(22));
        arbol.getRaiz().getIzquierda().getIzquierda().setDerecha(new Nodo(40));
        arbol.getRaiz().getIzquierda().getDerecha().setIzquierda(new Nodo(51));
        arbol.getRaiz().getDerecha().getIzquierda().setIzquierda(new Nodo(76));
        arbol.getRaiz().getDerecha().getIzquierda().setDerecha(new Nodo(80));
		return "("+numero1+", "+numero2+"): " + arbol.buscarPadreComun(numero1,numero2);
	}
}