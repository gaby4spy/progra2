import Autos.Autos;
import imp.ArchivoDAO;

public class Main {
    public static void main(String[] args) {

        Autos toyota = new Autos("Fiat","Argo","88888");
        System.out.println(toyota.formato());
        ArchivoDAO c = new ArchivoDAO();

        c.aregar(toyota);

    }
}
