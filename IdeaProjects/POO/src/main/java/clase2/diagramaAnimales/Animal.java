package clase2.diagramaAnimales;

public class Animal {

  private String nombre;
  private int edad ;
  private float peso;

  public  Animal (String nombre,int edad,float peso){
      this.nombre=nombre;
      this.edad=edad;
      this.peso=peso;
  }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    protected void  emitirSonido(){};

    protected  void alimentarse(){};
}
