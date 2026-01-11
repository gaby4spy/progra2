package imp;

public class EquipoFutbol {
    String nombre;
    String pais;
    Tecnico tecnico;
    Arquero  arquero;
    MedioCampista [] medioCampista;
    Delantero [] delantero;
    Defensa [] defensa ;

    public EquipoFutbol (String nombre,String pais){
        this.nombre=nombre;
        this.pais=pais;
    }

    public EquipoFutbol (String nombre,String pais , Tecnico tecnico , Arquero arquero,MedioCampista[] medioCampista , Delantero[] delantero ,Defensa [] defensa){
        this.nombre=nombre;
        this.pais=pais;
        this.tecnico=tecnico;
        this.arquero=arquero;
        this.medioCampista=medioCampista;
        this.delantero=delantero;
        this.defensa=defensa;
    }

    public void mostraEquipo(){
        System.out.println("========INFO EQUIPO=============");

        System.out.println("====TECNICO==== " + this.tecnico.nombre + " " + this.tecnico.apellido );

        System.out.println("====ARQUERO==== " + this.tecnico.nombre + " " + this.tecnico.apellido);
        System.out.println( "====DEFENSA====");
        for(Defensa d : defensa){

            System.out.println(d.nombre + " " + d.apellido);
        }
        System.out.println("====Delantero====" );
        for (Delantero d : delantero){
            System.out.println(d.nombre + " " + d.apellido);
        }
        System.out.println("=====MEDIOCAMPISTA=====");
        for (MedioCampista m : medioCampista){
            System.out.println(m.nombre + " " + m.apellido);
        }



    }


}
