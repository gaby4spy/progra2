package Presentacion;


import Sistema.Asistente;
import Sistema.ControlFestival;
import TDAStp.arboless.MetodosExternos;


public class Main {
    public static void main(String[] args) {
        Asistente a4 = new Asistente(956243, "Pedro Gomez", "GENERAL");
        Asistente a5 = new Asistente(1001523, "Sofia Perez", "VIP");
        Asistente a6 = new Asistente(1002714, "Martina Lopez", "GENERAL");
        Asistente a7 = new Asistente(1003895, "Mateo Perez", "VIP");
        Asistente a8 = new Asistente(1004976, "Valentina Sanchez", "GENERAL");
        System.out.println("🎶 ¡Bienvenidos al Festival! 🎶");
        System.out.println("Las luces se encienden, suena la música... arranca el festival!\n");

        ControlFestival cf = new ControlFestival(); // init interno
        cf.registrarAsistentes(a4.DNI,a4);
        cf.registrarAsistentes(a5.DNI,a5);
        cf.registrarAsistentes(a6.DNI,a6);
        cf.registrarAsistentes(a7.DNI, a7);
        cf.registrarAsistentes(a8.DNI, a8);
       System.out.println("--- Ingresos ---");

       if (cf.registrarIngreso(a4)) {
           System.out.println(a4.nombre + " ingresó con éxito.");
       } else {
            System.out.println("Error: " + a4.nombre + " duplicado.");
       }
        if (cf.registrarIngreso(a5)) {// verificar que no se registren repetidos
            System.out.println(a5.nombre + " ingresó con éxito."); 
        } else {
            System.out.println("Error: " + a5.nombre + " duplicado.");
        }

         if (cf.registrarIngreso(a6)) {
             System.out.println(a6.nombre + " ingresó con éxito.");
         } else {
             System.out.println("Error: " + a6.nombre + " duplicado.");
         }

         if (cf.registrarIngreso(a7)) {
             System.out.println(a7.nombre + " ingresó con éxito.");
         } else {
             System.out.println("Error: " + a7.nombre + " duplicado.");
         }

         if (cf.registrarIngreso(a8)) {
             System.out.println(a8.nombre + " ingresó con éxito.");
         } else {
             System.out.println("Error: " + a8.nombre + " duplicado.");
         }
          if (cf.registrarIngreso(a8)) {                                       
              System.out.println(a8.nombre + " ingresó con éxito.");           
          } else {                                                             
              System.out.println("Error: " + a8.nombre + " duplicado.");       
          }                                                                    



        System.out.println("\n🎤 El presentador anuncia: ¡Ya hay " + cf.cantidadPresentes + " personas disfrutando del festival!\n");

        ControlFestival.mostrarDiccionario(cf.dic);
        ControlFestival.mostrarOrdenIngreso(cf.colaIngresos);
        System.out.println("Asistentes actualmente dentro:");
        MetodosExternos.mostrarInOrdenInverso(cf.presentesPrueba,0);
        System.out.println("--------------Se hace un balanceo------");
        ControlFestival.mostrarPresentes(cf.presentes,0 );
        cf.mostrarCantidadpresentes();

        System.out.println("El asistente numero 5 está registrando su egreso" );
        cf.registrarEgreso(a5.DNI);
        System.out.println("Se ha registrado correctamente");

         System.out.println("\n📊 Estadísticas finales del festival:");
         System.out.println("Total de ingresos: " + cf.ingresosTotales);
         System.out.println("Asistentes que ya se fueron: " + cf.egresosTotales);


         
        System.out.println("\n🎇 El show cierra con fuegos artificiales... ¡Gracias por venir al festival!");
    }


}









