import java.util.Random;

public class aleatorio {
    public static void main(String[] args) {

        var random= new Random();

        var numAlea= random.nextInt(10);
        System.out.println(numAlea);

        numAlea=random.nextInt(10)+1;
        System.out.println(numAlea);

        var flotanteAlea=random.nextFloat();
        System.out.println(flotanteAlea);
    }
}
