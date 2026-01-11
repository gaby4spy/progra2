import imp.*;

public class Main {

    public static void main(String[] args) {
        Ciudad arg = new Ciudad("Buenos Aires","Argentina");
        Ciudad usa = new Ciudad("Miami Floridad","USA");
        Ciudad lima = new Ciudad("Lima","Peru");

        Aeropuerto ezeiza = new Aeropuerto("Aeropuerto Ezeiza",2,arg);
        Aeropuerto mi = new Aeropuerto("International airport Miami",234,usa);
        Aeropuerto pru = new Aeropuerto("Jorge Chavez",304,lima);

        Avion boing = new Avion("747",234,"Boing","AAI345");

        Vuelo vuelo234= new Vuelo(boing,ezeiza,mi,pru,34959);

        Pasajero p1 = new Pasajero("Gabriel","Rojas",4444,"3a");
        Pasajero p2= new Pasajero("ARIEl","hernandez",445644,"3b");
        Pasajero p3= new Pasajero("Hernan","Gomeza",55555,"14c");

        vuelo234.agregarPasajero(p1);
        vuelo234.agregarPasajero(p2);
        vuelo234.agregarPasajero(p3);

        vuelo234.mostrarInfo();


    }
}
