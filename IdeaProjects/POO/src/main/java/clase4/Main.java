package clase4;

public class Main {

    public static void main(String[] args) {



        Universidad uni = new Universidad("UTN", "Av. Universidad 123", 1953, "Dr. López");

        // Agregar carreras
        uni.agregarCarrera("Ingeniería en Sistemas", "Ingeniero en Sistemas", 5, "SIS101");
        uni.agregarCarrera("Licenciatura en Administración", "Licenciado en Administración", 4, "ADM102");
        uni.agregarCarrera("Contador Público", "Contador Público Nacional", 5, "CON103");

        // Agregar materias a la primera carrera (Ingeniería en Sistemas)
        Carrera ingSis = uni.obtenerCarreras().get(0); // primera carrera

        Materia matematic1 = new Materia("Matemática I", "MAT101");
        ingSis.agregarMateria(matematic1);
        ingSis.agregarMateria(new Materia("Programación I", "PRG102"));
        ingSis.agregarMateria(new Materia("Bases de Datos", "BD103"));
        ingSis.agregarMateria(new Materia("Redes de Computadoras", "RED104"));
        ingSis.agregarMateria(new Materia("Sistemas Operativos", "SO105"));
        ingSis.agregarMateria(new Materia("Algoritmos y Estructuras de Datos", "AED106"));
        ingSis.agregarMateria(new Materia("Ingeniería de Software", "IS107"));
        ingSis.agregarMateria(new Materia("Inteligencia Artificial", "IA108"));
        ingSis.agregarMateria(new Materia("Programación II", "PRG109"));
        ingSis.agregarMateria(new Materia("Seguridad Informática", "SEC110"));

        // Mostrar toda la información de la universidad y sus carreras
        uni.mostrarInfo();
    }
}
