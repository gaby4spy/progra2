package imp;

public class Avion {
    String modelo;
    int asiento;
    String marca;
    String matricula;

    public Avion(String modelo,int asiento,String marca,String matricula){
        this.modelo=modelo;
        this.asiento=asiento;
        this.marca=marca;
        this.matricula=matricula;
    }

    public void mostrarInfo(){
        System.out.println("MODELO : " + this.modelo);
        System.out.println( "CANTIDAD ASIENTOS : " +this.asiento);
        System.out.println("MARCA : " + this.marca);
        System.out.println("MATRICULA : " + this.matricula);

    }

}
