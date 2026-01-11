public class Sentencias {
    public static void main(String[] args) {

        var edad = 9;

        if (edad>=18){
            System.out.println("mayor de edad");
        } else if (edad<18 && edad>=13) {
            System.out.println("adolecente");

        } else {
            System.out.println("niño");
        }
    }
}
