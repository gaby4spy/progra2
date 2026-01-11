package clase6;


class  Calculadora{
    public static  int Suma (int a , int b){
        return a+b;
    }
    public static  double Suma (double a , double b){
        return a+b;
    }

    public static int  Resta (int a, int b){
        return a-b;

    }

    public static double Resta (double a, double b){
        return a-b;

    }


    public static  double multiplicacion(double a , double b){
        return a*b;
    }

    public static  double multiplicacion(int  a , int b){
        return a*b;
    }

    public static  double division(double  a , double b){

        double operacion=0.0;
        try {
            operacion = a/b;
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
     return operacion ;
    }

    public static  int  division(int  a , int b){
        int operacion=0;
        try {
            operacion = a/b;
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return operacion ;
    }
}



public class Main {

    public static void main(String[] args) {

        System.out.println(Calculadora.Suma(5,1));
        System.out.println(Calculadora.Suma(5.2,1.2));
    }
}
