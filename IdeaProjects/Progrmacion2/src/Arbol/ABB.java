package Arbol;

public class ABB implements TDAABB{
    NodoABB raiz;


    @Override
    public int Raiz() {
        return raiz.dato;
    }

    @Override
    public TDAABB HijoIzq() {
        return raiz.hijoIzq;
    }

    @Override
    public TDAABB HijoDer() {
        return raiz.hijoDer;
    }

    @Override
    public boolean ArbolVacio() {
        return raiz == null;
    }

    @Override
    public void InicializarArbol() {
        raiz = null;
    }

    @Override
    public void AgregarElem(int x) {
        if (raiz == null) {
            raiz = new NodoABB();
            raiz.dato = x;
            raiz.hijoIzq = new ABB();
            raiz.hijoIzq.InicializarArbol();
            raiz.hijoDer = new ABB();
            raiz.hijoDer.InicializarArbol();
        } else if (raiz.dato > x)
            raiz.hijoIzq.AgregarElem(x);
        else if (raiz.dato < x)
            raiz.hijoDer.AgregarElem(x);
    }

    private int mayor(TDAABB a) {
        if (a.HijoDer().ArbolVacio())
            return a.Raiz();
        else
            return mayor(a.HijoDer());
    }

    private int menor(TDAABB a) {
        if (a.HijoIzq().ArbolVacio())
            return a.Raiz();
        else
            return menor(a.HijoIzq());
    }

    @Override
    public void EliminarElem(int x) {
        if (raiz != null) {// si la raiz no es nula
            if (raiz.dato == x && raiz.hijoIzq.ArbolVacio() && raiz.hijoDer.ArbolVacio()) {
                raiz = null;// si el elemnto a liminar es hoja lo pongo en null
            } else if (raiz.dato == x && !raiz.hijoIzq.ArbolVacio()) {
                raiz.dato = this.mayor(raiz.hijoIzq);// si el nodo a eliminar tiene un sub izquierdo el dato de esta raiz sera reemplazado por el mayor del sub izquierdo
                raiz.hijoIzq.EliminarElem(raiz.dato); // elimina el valor duplicado por el cual se reemplazo raiz
            } else if (raiz.dato == x && raiz.hijoIzq.ArbolVacio()) {//si el nodo a elminar tiene sub derecho entocnes reemplazar el dato a elminar por el menor del hijo derecho
                raiz.dato = this.menor(raiz.hijoDer);
                raiz.hijoDer.EliminarElem(raiz.dato);// elimina el valor duplicado por el cual se reemplazo raiz
            } else if (raiz.dato < x) {
                raiz.hijoDer.EliminarElem(x); //si el valor a eliminar es mayor a la raiz se lo elmina directmane...esto permite seguir bajando
                System.out.println("xxx usando");
            } else {
                raiz.hijoIzq.EliminarElem(x); //caso contrario elminar el hijo izquiero
            }
        }
    }



}
