package imp;

public class Ciudad {
    String pais;
    String ciudad;

    public Ciudad(String ciudad,String pais){
        this.pais=pais;
        this.ciudad=ciudad;
    }

    public void mostrarInfo(){
        System.out.println("Pais: " + this.pais);
        System.out.println("Ciudad : " + this.ciudad);
    }
}
