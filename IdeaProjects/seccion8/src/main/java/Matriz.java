public class Matriz {
    public static void main(String[] args) {

        //Definimos matriz

        /*int [][] matriz = new  int [2][3];///indicamos 2 filos y 3 columnas
        var matriz = new  int [2][3];


        matriz[0][0]=100;
        matriz[0][1]=200;
        matriz[0][2]=300;

        matriz[1][0]=400;
        matriz[1][1]=500;
        matriz[1][2]=600;






        for (int fila =0 ; fila<matriz.length;fila++){
            System.out.print("\nFILA : " + fila );

            for (int columna =0; columna<matriz[fila].length;columna++){
                System.out.print("\n\t VALORES : " + matriz[fila][columna]);

            }
        }


        int [] nro = new int [3];

        nro[0]=1;
        nro[1]=33;
        nro[2]=2;

        System.out.println(nro[0]);

        System.out.println(nro);

         */


        var matriz = new int[][]{{100,200,300},{400,500,600},{700,800,900}};

        int [] [] x = {{100,200,300},{400,500,600},{700,800,900}};

        int suma=0;

        int puntero=0;
        int iteracion=0;

        int nro=0;

        for (int filas =0; filas<x.length; filas++){
            for (int columnas=0; columnas<x[filas].length;columnas++){
                nro =x[iteracion][puntero];
            }
            puntero++;
            iteracion++;

            System.out.println(nro);
            nro=0;
        }




    }
}
