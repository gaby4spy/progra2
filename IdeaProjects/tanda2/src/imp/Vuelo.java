package imp;

public class Vuelo {
    Avion avion;
    int nroVuelo;
    Aeropuerto aeropuertoInicio;
    Aeropuerto aeropuertoDestino;
    Aeropuerto escalas;
    Pasajero [] asientos;
    int pos;

    public  Vuelo(Avion avion,Aeropuerto aeropuertoInicio,Aeropuerto aeropuertoDestino, Aeropuerto escalas , int nroVuelo){
        this.avion=avion;
        this.aeropuertoInicio=aeropuertoInicio;
        this.aeropuertoDestino=aeropuertoDestino;
        this.escalas=escalas;
        this.nroVuelo=nroVuelo;
        asientos= new Pasajero[this.avion.asiento];
        pos= 0;

    }

    public void agregarPasajero(Pasajero p){
        if (pos>=this.avion.asiento){
            System.out.println("NO HAY ASIENTOS DISPONIBBLES");
        }


        asientos[pos]=p;
        pos+=1;
    }
    public void asientoDispo(){
        System.out.println("=======INFO GRAL VUELO======");
        int dispo= this.avion.asiento-pos;
        System.out.println(" VUELO NRO: " + this.nroVuelo + " ASIENTOS DISPONIBLES : " + dispo);
        System.out.println("========ORIGEN=========:");
        this.aeropuertoInicio.mostrarInfo();
        System.out.println("========DESTINO======== : " );
        this.aeropuertoDestino.mostrarInfo();
    }


    public void mostrarInfo(){
        System.out.println("========INFO AVION=========");
        this.avion.mostrarInfo();
        System.out.println("=========AEROPUERTO INICIO========");
        this.aeropuertoInicio.mostrarInfo();
        System.out.println("========AEROPUERTO DESTINO=========");
        this.aeropuertoDestino.mostrarInfo();
        System.out.println("=========ESCALAS========");
        this.escalas.mostrarInfo();


    }

    public void mostrarPasajeros(){
        for (int i=0;i<pos;i++){
            asientos[i].mostrarInfo();

        }
    }
}
