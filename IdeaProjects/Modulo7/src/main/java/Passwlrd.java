import java.util.Scanner;

public class Passwlrd {
    public static void main(String[] args) {
        final  String USUARIAO="admin";
        final String PASSWORD="123";


        /// solcicita

        Scanner consola = new Scanner(System.in);

        System.out.print("Ingrese usuario");
        var usuario = consola.nextLine();
        System.out.print("Contraseña");
        var password=consola.nextLine();

        if (PASSWORD.equals(password) && USUARIAO.equals(usuario)){
            System.out.print("BIENVENIDO");
        } else if (PASSWORD.equals(password) && !usuario.equals(USUARIAO)) {
            System.out.print("USUARIO INCORRECTO");

        } else if (usuario.equals(USUARIAO) && !password.equals(PASSWORD)) {
            System.out.print("CONTRASEÑA INCORRECTA");

        }else{
            System.out.print("AMBOS CAMPOS INCORRECTOS ");
        }

    }
}
