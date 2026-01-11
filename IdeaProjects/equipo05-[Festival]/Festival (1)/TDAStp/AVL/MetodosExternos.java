package TDAStp.AVL;

public class MetodosExternos {

    public static boolean existeElementoenABB (AVLTree t, int x){
        if (t.ArbolVacio()) return false;
        else if (t.Raiz()==x) return true;
        else if (t.Raiz()>x){
            return (existeElementoenABB(t.HijoDer(),x));
        }
        else {
            return (existeElementoenABB(t.HijoIzq(),x));
        }
    }
    }
