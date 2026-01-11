package simulacro1.Practica;

import java.util.ArrayList;
import java.util.List;
public class Main {

    public static void main(String[] args) {



        // 10 camionetas
        Camioneta camioneta1 = new Camioneta(1, "toyota", 1, 255.5);
        Camioneta camioneta2 = new Camioneta(2, "ford", 2, 260.0);
        Camioneta camioneta3 = new Camioneta(3, "chevrolet", 3, 270.0);
        Camioneta camioneta4 = new Camioneta(4, "nissan", 4, 280.0);
        Camioneta camioneta5 = new Camioneta(5, "volkswagen", 5, 290.0);
        Camioneta camioneta6 = new Camioneta(6, "fiat", 6, 300.0);
        Camioneta camioneta7 = new Camioneta(7, "renault", 7, 310.0);
        Camioneta camioneta8 = new Camioneta(8, "peugeot", 8, 320.0);
        Camioneta camioneta9 = new Camioneta(9, "citroen", 9, 330.0);
        Camioneta camioneta10 = new Camioneta(10, "kia", 10, 340.0);

        // 10 automoviles
        Automovil automovil1 = new Automovil(207, "chevrolet", 11, 4);
        Automovil automovil2 = new Automovil(208, "ford", 12, 4);
        Automovil automovil3 = new Automovil(209, "fiat", 13, 4);
        Automovil automovil4 = new Automovil(210, "peugeot", 14, 4);
        Automovil automovil5 = new Automovil(211, "citroen", 15, 4);
        Automovil automovil6 = new Automovil(212, "renault", 16, 4);
        Automovil automovil7 = new Automovil(213, "toyota", 17, 4);
        Automovil automovil8 = new Automovil(214, "nissan", 18, 4);
        Automovil automovil9 = new Automovil(215, "volkswagen", 19, 4);
        Automovil automovil10 = new Automovil(216, "kia", 20, 4);

        // 20 conductores
        Conductor conductor1 = new Conductor("gabriel", 1111);
        Conductor conductor2 = new Conductor("lucas", 1112);
        Conductor conductor3 = new Conductor("martin", 1113);
        Conductor conductor4 = new Conductor("sofia", 1114);
        Conductor conductor5 = new Conductor("juan", 1115);
        Conductor conductor6 = new Conductor("maria", 1116);
        Conductor conductor7 = new Conductor("roberto", 1117);
        Conductor conductor8 = new Conductor("laura", 1118);
        Conductor conductor9 = new Conductor("nicolas", 1119);
        Conductor conductor10 = new Conductor("carla", 1120);
        Conductor conductor11 = new Conductor("alejandro", 1121);
        Conductor conductor12 = new Conductor("camila", 1122);
        Conductor conductor13 = new Conductor("fernando", 1123);
        Conductor conductor14 = new Conductor("valentina", 1124);
        Conductor conductor15 = new Conductor("jorge", 1125);
        Conductor conductor16 = new Conductor("delfina", 1126);
        Conductor conductor17 = new Conductor("oscar", 1127);
        Conductor conductor18 = new Conductor("romina", 1128);
        Conductor conductor19 = new Conductor("esteban", 1129);
        Conductor conductor20 = new Conductor("julieta", 1130);

        // Lista de viajes
        List<Viaje> viajes = new ArrayList<>();

        // 10 viajes con camionetas
        viajes.add(new Viaje("salta", conductor1, "bs as", 250, camioneta1));
        viajes.add(new Viaje("cordoba", conductor2, "mendoza", 300, camioneta2));
        viajes.add(new Viaje("rosario", conductor3, "tucuman", 200, camioneta3));
        viajes.add(new Viaje("jujuy", conductor4, "la plata", 400, camioneta4));
        viajes.add(new Viaje("misiones", conductor5, "corrientes", 150, camioneta5));
        viajes.add(new Viaje("neuquen", conductor6, "rio negro", 280, camioneta6));
        viajes.add(new Viaje("san juan", conductor7, "san luis", 320, camioneta7));
        viajes.add(new Viaje("chaco", conductor8, "formosa", 180, camioneta8));
        viajes.add(new Viaje("catamarca", conductor9, "santiago", 350, camioneta9));
        viajes.add(new Viaje("entre rios", conductor10, "santa fe", 220, camioneta10));

        // 10 viajes con automoviles
        viajes.add(new Viaje("salta", conductor11, "bs as", 250, automovil1));
        viajes.add(new Viaje("cordoba", conductor12, "mendoza", 300, automovil2));
        viajes.add(new Viaje("rosario", conductor13, "tucuman", 200, automovil3));
        viajes.add(new Viaje("jujuy", conductor14, "la plata", 400, automovil4));
        viajes.add(new Viaje("misiones", conductor15, "corrientes", 150, automovil5));
        viajes.add(new Viaje("neuquen", conductor16, "rio negro", 280, automovil6));
        viajes.add(new Viaje("san juan", conductor17, "san luis", 320, automovil7));
        viajes.add(new Viaje("chaco", conductor18, "formosa", 180, automovil8));
        viajes.add(new Viaje("catamarca", conductor19, "santiago", 350, automovil9));
        viajes.add(new Viaje("entre rios", conductor20, "santa fe", 220, automovil10));

        // Mostrar todos los viajes desde el ArrayList
        for (Viaje v : viajes) {
            System.out.println(v.toString());



        }
}
}

