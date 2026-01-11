package TpIntegrador;

public class Main {
    public static void main(String[] args) {

        Profesor profe1 = new Profesor("alg",50,"matematica",Nivel.UNIVERSITARIO);
        Curso matematica1 = new Curso("matematica 1" ,10 ,profe1);


        Estudiante e1 = new Estudiante("Gabriel", 22, "A001", Nivel.UNIVERSITARIO);
        Estudiante e2 = new Estudiante("Lucía", 21, "A002", Nivel.UNIVERSITARIO);
        Estudiante e3 = new Estudiante("Martín", 23, "A003", Nivel.UNIVERSITARIO);
        Estudiante e4 = new Estudiante("Sofía", 20, "A004", Nivel.UNIVERSITARIO);
        Estudiante e5 = new Estudiante("Nicolás", 24, "A005", Nivel.UNIVERSITARIO);
        Estudiante e6 = new Estudiante("Valentina", 22, "A006", Nivel.UNIVERSITARIO);
        Estudiante e7 = new Estudiante("Juan", 25, "A007", Nivel.UNIVERSITARIO);
        Estudiante e8 = new Estudiante("Camila", 19, "A008", Nivel.UNIVERSITARIO);
        Estudiante e9 = new Estudiante("Agustín", 23, "A009", Nivel.UNIVERSITARIO);
        Estudiante e10 = new Estudiante("Mariana", 21, "A010", Nivel.UNIVERSITARIO);

        Estudiante e11 = new Estudiante("Lautaro", 22, "A011", Nivel.UNIVERSITARIO);
        Estudiante e12 = new Estudiante("Florencia", 20, "A012", Nivel.UNIVERSITARIO);
        Estudiante e13 = new Estudiante("Tomás", 24, "A013", Nivel.UNIVERSITARIO);
        Estudiante e14 = new Estudiante("Carolina", 23, "A014", Nivel.UNIVERSITARIO);
        Estudiante e15 = new Estudiante("Diego", 21, "A015", Nivel.UNIVERSITARIO);
        Estudiante e16 = new Estudiante("Julieta", 22, "A016", Nivel.UNIVERSITARIO);
        Estudiante e17 = new Estudiante("Mateo", 19, "A017", Nivel.UNIVERSITARIO);
        Estudiante e18 = new Estudiante("Micaela", 20, "A018", Nivel.UNIVERSITARIO);
        Estudiante e19 = new Estudiante("Franco", 23, "A019", Nivel.UNIVERSITARIO);
        Estudiante e20 = new Estudiante("Ana", 21, "A020", Nivel.UNIVERSITARIO);

        matematica1.agregarEstudiante(e1);
        matematica1.agregarEstudiante(e2);
        matematica1.agregarEstudiante(e3);
        matematica1.agregarEstudiante(e4);
        matematica1.agregarEstudiante(e5);
        matematica1.agregarEstudiante(e6);
        matematica1.agregarEstudiante(e7);
        matematica1.agregarEstudiante(e8);
        matematica1.agregarEstudiante(e9);
        matematica1.agregarEstudiante(e10);
        matematica1.agregarEstudiante(e11);
        matematica1.agregarEstudiante(e13);
        matematica1.agregarEstudiante(e14);
        matematica1.agregarEstudiante(e15);
        matematica1.agregarEstudiante(e16);
        matematica1.agregarEstudiante(e17);
        matematica1.agregarEstudiante(e18);
        matematica1.agregarEstudiante(e19);
        matematica1.agregarEstudiante(e20);


        matematica1.mostrarEstuidante();









    }
}
