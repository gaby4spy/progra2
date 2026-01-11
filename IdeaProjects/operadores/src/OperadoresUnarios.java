public class OperadoresUnarios {
    public static void main(String[] args) {


        int a = 3,b=-2,resultado;


        ///  Operaadores unarios incremento / decremento
        /// pre - decremento

        resultado=++a; ///primero se incrmenta el valor

        System.out.println("Ya se incremento previo a su uso " + resultado);

        /// post-incremento
        a=3;
        resultado=a++;///primero se usa el valor y despues se incrmenta
        System.out.println("Se usa la variable " + " " +  a);



        System.out.println("Se incrementa despues del uso" + " " + a);

    }
}
