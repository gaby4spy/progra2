package simulacro1.Practica;

public class Viaje {
    int distancia;
    String origen;
    String Destino;
    Conductor conductor;
    Vehiculo vehiculo;


    public Viaje(String destino, Conductor conductor, String origen, int distancia,Vehiculo vehiculo) {
        Destino = destino;
        this.conductor = conductor;
        this.origen = origen;
        this.distancia = distancia;
        this.vehiculo=vehiculo;
    }


    public int getDistancia() {
        return distancia;
    }

    public void setDistancia(int distancia) {
        this.distancia = distancia;
    }

    public String getDestino() {
        return Destino;
    }

    public void setDestino(String destino) {
        Destino = destino;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public Conductor getConductor() {
        return conductor;
    }

    public void setConductor(Conductor conductor) {
        this.conductor = conductor;
    }



    @Override

    public String toString() {
        return "=========INFO VIAJE ===========\n" +
                "Viaje{" +
                "distancia=" + distancia +
                ", origen='" + origen + '\'' +
                ", Destino='" + Destino + '\'' +
                ", \n conductor=" + conductor +
                ", \n vehiculo datos = " + vehiculo +
                ", \n combustible consumido = " + vehiculo.calcularConsumo(distancia)+ "L"+
                '}';
    }




}
