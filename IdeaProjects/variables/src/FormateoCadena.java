public class FormateoCadena {
    public static void main(String[] args) {
        var nroEmp=12;
        var nombre="sss";
        var edad=22;
        var salario=3333.88;
        //fromateo con texto bloxk
        var msj= """
                %nDetalle Persona:\s
                --------------------
                \tnombre:%s
                \tno. Empleado=%04d 
                \tedad:%d años
                \tSalario: %.2f
                """.formatted(nombre,nroEmp,edad,salario);

        System.out.println(msj);
    }
}
