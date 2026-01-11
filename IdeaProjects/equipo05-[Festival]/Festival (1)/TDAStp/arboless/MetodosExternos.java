package TDAStp.arboless;

public class MetodosExternos {

    public static void mostrarInOrdenInverso (TDAABB a, int nivel){
        if (!a.ArbolVacio()){
        mostrarInOrdenInverso(a.HijoDer(), nivel+1);
            System.out.println("llamando desde 0 otra vez desde nodo " + a.Raiz());
        for(int i=0;i<nivel;i++){
            System.out.print("\t");
            }
        System.out.println(a.Raiz());
        mostrarInOrdenInverso(a.HijoIzq(), nivel+1);

    }
}

}


