public class Main {
    public static void main(String[] args) {
        Docente d1 = new Docente("Pablo","veriño",12334);
        Docente d2= new Docente("Juan","Ocampo",54221);
        Docente d3 = new Docente("Alfre","dess",23423);

        Materia [] sw= {new Materia("Algoritmos 2",6242,d1),
                new Materia("POO",323,d2),
                new Materia("Telecomunicaciones",3232,d3)
        };

        Carrera software = new Carrera("Tec desarrollo de software",213123,sw);

        Estudiante e1= new Estudiante("ariel","jas","gss@gmail.com",software);

        e1.mostrarDetalles();

    }
}
