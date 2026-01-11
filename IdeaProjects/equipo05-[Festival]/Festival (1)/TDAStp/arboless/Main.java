package TDAStp.arboless;

public class Main {
	public static void main(String[] args) {
		ABB arbol = new ABB();

		// PRUEBA
		arbol.AgregarElem(10);
		arbol.AgregarElem(5);
		arbol.AgregarElem(15);
		arbol.AgregarElem(3);
		arbol.AgregarElem(7);
		arbol.AgregarElem(13);
		arbol.AgregarElem(17);
		ABB arbol2= new ABB();
		arbol2.InicializarArbol();
		arbol2.AgregarElem(10);
		arbol2.AgregarElem(5);
		arbol2.AgregarElem(3);
		arbol2.AgregarElem(7);
		arbol2.AgregarElem(13);
		arbol2.AgregarElem(17);
		System.out.println("In orden");
imprimirArbol(arbol2);
		System.out.println("In orden inverso");
		MetodosExternos.mostrarInOrdenInverso(arbol2,0);


}
public static void imprimirArbol (TDAABB ab){
		if (!ab.ArbolVacio()){
			imprimirArbol(ab.HijoIzq());
			System.out.println(ab.Raiz());
			imprimirArbol(ab.HijoDer());
		}
}
}