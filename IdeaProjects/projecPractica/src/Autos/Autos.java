package Autos;

public class Autos {
    String marca ;
    String modelo;
    String patente;


    public Autos(String marca,String modelo,String patente){
        this.marca=marca;
        this.modelo=modelo;
        this.patente=patente;
    }



    public String formato (){
        return this.marca + "," + this.patente + "," + this.modelo;
    };
}
