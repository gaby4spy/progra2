package Sistema;


import TDAStp.AVL.AVLNode;
import TDAStp.AVL.AVLTree;
import TDAStp.AVL.MetodosExternos;
import TDAStp.AVL.TDAABB;
import TDAStp.Cola.ColaAsistente;
import TDAStp.Cola.ColaAsistenteTDA;
import TDAStp.Conjunto.ConjuntoTDA;
import TDAStp.Diccionario.DiccionarioSimpleA;
import TDAStp.Diccionario.DiccionarioSimpleTDA;
import TDAStp.arboless.ABB;

public class ControlFestival {
    public AVLTree presentes;//Arbol para guardar los DNIS de los asistentes que estan actualmente en el recinto
    public ABB presentesPrueba; //ABB degenerado para mostrar diferencia por pantalla
    public DiccionarioSimpleTDA dic; ///Diccionario para guardar la informacion de todos los asistentes
    public ColaAsistenteTDA colaIngresos, colaEgresos; ///Colas para controlar el orden de ingresos y egresos
    public int ingresosTotales, egresosTotales, cantidadPresentes;

    public ControlFestival() {
        presentes = new AVLTree();
        presentes.InicializarArbol();
        dic       = new DiccionarioSimpleA();
        dic.InicializarDiccionario();
        colaIngresos = new ColaAsistente();
        colaIngresos.InicializarCola();
        colaEgresos  = new ColaAsistente();
        colaEgresos.InicializarCola();
        ingresosTotales = egresosTotales = cantidadPresentes = 0;
        presentesPrueba= new ABB();
        presentesPrueba.InicializarArbol();
    }
    boolean existeEnDic(int dni) { ///Se crea esta función para que al ingresar al festival, verificar si existe o no en el diccionario de todos los asistentes
        ConjuntoTDA c = dic.Claves();
        return c.Pertenece(dni);
    }
    public void registrarAsistentes (int dni, Asistente asistente){
        dic.Agregar(dni, asistente);
    }
    public static void mostrarOrdenIngreso(ColaAsistenteTDA cola) {
        ColaAsistenteTDA aux= new ColaAsistente();
        aux.InicializarCola();
        System.out.println("El orden de ingreso ha sido :");

        while (!cola.ColaVacia()) {
            Asistente actual = cola.Primero();
            System.out.println("Nombre:   "+actual.nombre+" de tipo de entrada: "+actual.tipoEntrada);
            aux.Acolar(actual);
            cola.Desacolar();
        }
        while (!aux.ColaVacia()) {
            Asistente c = aux.Primero();
            cola.Acolar(c);
            aux.Desacolar();
        }

    }
    public static void mostrarDiccionario (DiccionarioSimpleTDA d) {
        ConjuntoTDA dnis = d.Claves();
        System.out.println("Los asistentes registrados en el sistema son :");
        while (!dnis.ConjuntoVacio()){
            int x= dnis.Elegir();
            Asistente a= d.Recuperar(x);
            System.out.println("DNI: " + a.DNI + " | Nombre: " + a.nombre + " | Tipo: " + a.tipoEntrada);

            dnis.Sacar(x);
        }
        }
//verificar
    public boolean registrarIngreso(Asistente a) {
        if (existeEnDic(a.DNI)){
        presentes.AgregarElem(a.DNI);
        presentesPrueba.AgregarElem(a.DNI);
        cantidadPresentes++;
        ingresosTotales++;
        colaIngresos.Acolar(a);
        return true;
    }
    return false;
    }

    public boolean registrarEgreso(int dni) {
        if (!MetodosExternos.existeElementoenABB(presentes,dni)) return false;
        else {
            presentes.EliminarElem(dni);
            cantidadPresentes--;
            egresosTotales++;
            Asistente a= dic.Recuperar(dni);
            colaEgresos.Acolar(a);
            return true;
        }

    }
    public void mostrarCantidadpresentes(){
        System.out.println("Actualmente en el recinto hay: "+cantidadPresentes+ " personas");
    }

    public void mostrarCantidadegresados(){
        System.out.println("Ya se han ido del recinto la cantidad de : "+egresosTotales+ " personas");
    }



    //in order reverse
    public static void mostrarPresentes (AVLTree a, int nivel){


        if (!a.ArbolVacio()){
            mostrarPresentes(a.HijoDer(), nivel+1);
            for(int i=0;i<nivel;i++){
                System.out.print("\t");
            }
            System.out.println(a.Raiz());
            mostrarPresentes(a.HijoIzq(), nivel+1);

        }


    }}












