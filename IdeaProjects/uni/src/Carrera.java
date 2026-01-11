public class Carrera {
    String nombre;
    int codigo;
    Materia [] materias;

    public  Carrera (String nombre,int codigo,Materia [] materias){
        this.nombre=nombre;
        this.codigo=codigo;
        this.materias=materias;
    }

    public void mostraInfo(){
        System.out.println("CARRERA: "+ this.nombre);
        for (Materia m: materias){
            System.out.println("=================================");
            System.out.println("NOMBRE MATERIA : " + m.nombre);
            System.out.println("CODIGO MATERIA "+ m.codigo);
            System.out.println("DOCENTE : " + m.docente.nombre + " " + m.docente.apellido);

        };
    }
}
