package Rojas_Gabriel;

public class Main {
    public static void main(String[] args) {

        EmpleadoTiempoCompleto fijo1 = new EmpleadoTiempoCompleto("Ana López", 50000, 5000);
        fijo1.setId(Empleado.generarID());
        EmpleadoTiempoCompleto fijo2 = new EmpleadoTiempoCompleto("Luis Pérez", 48000, 4000);
        fijo2.setId(Empleado.generarID());

        Freelancer free1 = new Freelancer("Carla Gómez", 0, 1000, 60);
        free1.setId(Empleado.generarID());
        Freelancer free2 = new Freelancer("Mario Díaz", 0, 1200, 120);
        free2.setId(Empleado.generarID());

        Departamento depto = new Departamento("Departamento de Sistemas");
        depto.contratarEmpleados(fijo1);
        depto.contratarEmpleados(fijo2);
        depto.contratarEmpleados(free1);
        depto.contratarEmpleados(free2);

        Proyecto proyecto = new Proyecto("Proyecto de Gestión de RRHH");
        proyecto.agregarMiembro(fijo1);
        proyecto.agregarMiembro(free1);

        proyecto.mostrarMiembro();

        System.out.println(fijo1.getNombre() + " | Salario: $" + fijo1.calcularSalario());
        System.out.println("Bono anual: $" + fijo1.calcularBonoAnual());
        System.out.println("Cobertura de salud: " + fijo1.obtenerDetallesSalud());


        System.out.println(fijo2.getNombre() + " | Salario: $" + fijo2.calcularSalario());
        System.out.println("Bono anual: $" + fijo2.calcularBonoAnual());
        System.out.println("Cobertura de salud: " + fijo2.obtenerDetallesSalud());


        System.out.println(free1.getNombre() + " trabajó " + free1.getHorasTrabajdas() + " horas.");
        System.out.println("Bono por horas: $" + free1.obtenerBonoPorHoras());


        System.out.println(free2.getNombre() + " trabajó " + free2.getHorasTrabajdas() + " horas.");
        System.out.println("Bono por horas: $" + free2.obtenerBonoPorHoras());


        depto.mostrarEmpleados();

        System.out.println();
        proyecto.mostrarMiembro();
    }
}
