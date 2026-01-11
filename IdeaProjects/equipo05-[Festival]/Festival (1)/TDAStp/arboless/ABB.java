package TDAStp.arboless;



public class ABB implements TDAABB {
    NodoABB raiz;
    NodoABB arbol1;
    NodoABB arbol2;

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
            raiz=new NodoABB();
            raiz.dato=x;
            raiz.hijoIzq= new ABB();
            raiz.hijoIzq.InicializarArbol();
            raiz.hijoDer= new ABB();
            raiz.hijoDer.InicializarArbol();
        }
        if (raiz.dato>x){
            raiz.hijoIzq.AgregarElem(x);
        }
        if (raiz.dato<x){
            raiz.hijoDer.AgregarElem(x);
        }

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
    public void EliminarElem(int x){
        if (raiz.dato == x && raiz.hijoIzq.ArbolVacio()&& raiz.hijoDer.ArbolVacio()){
            raiz= null;
        }
        else if (raiz.dato==x&& !raiz.hijoIzq.ArbolVacio()){
            raiz.dato=this.mayor(raiz.hijoIzq);
            raiz.hijoIzq.EliminarElem(raiz.dato);
        }
        else if (raiz.dato==x&& raiz.hijoIzq.ArbolVacio()){
            raiz.dato=this.menor(raiz.hijoDer);
            raiz.hijoDer.EliminarElem(raiz.dato);
        }
        else if (raiz.dato>x){
            raiz.hijoIzq.EliminarElem(x);
        }
        else if (raiz.dato<x){
            raiz.hijoDer.EliminarElem(x);
        }
    }
}