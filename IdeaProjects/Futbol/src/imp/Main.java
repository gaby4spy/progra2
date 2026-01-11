package imp;

public class Main {
    public static void main(String[] args) {

        //Arquero
        Arquero a1= new Arquero("Amadeo","Carrizo",true,30,10);
        //tecnico

        Tecnico t1= new Tecnico("Luis ","Menotti", 76, 40,false);
        //defensa

        Defensa [] d1= {
                new Defensa("Roberto","Perfumo",true, 24),
                new Defensa("Daniel ","Passarella" ,true, 23),
                new Defensa("Javier"," Zanetti",true, 29),
                new Defensa("Oscar"," Ruggeri",true, 29)
        };
        //MEDIOCAMPISTA


        MedioCampista [] m1= {
                new MedioCampista("Diego"," Maradona", true,28 , 1200 ),
                new MedioCampista("Fernando"," Redondo", true,25, 12  ),
                new MedioCampista("Juan"," Román Riquelme",true, 31, 1 )
        };

        //DELANTERO
      Delantero [] del1 = {
              new Delantero("Lionel","Messi",true,36,150),
              new Delantero("Gabriel","batistuta",true,28,300),
              new Delantero("Alfredo","Di stefano",true,30,400)

      };

      EquipoFutbol equip1 = new EquipoFutbol("River","Argentina",t1,a1,m1,del1,d1);

      equip1.mostraEquipo();






    }
}
