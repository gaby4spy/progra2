import java.util.Scanner;

public class password {

    public static void main(String[] args) {

        Scanner consola = new Scanner(System.in);
        var flag = false;

        while (!flag){

            System.out.print("Ingrese una constraseña la misma debe tener 6 caracteres");
            var password= consola.nextLine();



            if (password.length()>5){
                System.out.println("password valida!!");
                flag=true;
            }else {
                System.out.println("Passwrod invalida");
            }



        }
    }
}
