package imp;


public class Prueba {
    public static void main(String[] args) {

        /// Carga de datos
      Inventario.guardarDispositivo(new Smartphone(101, "Galaxy S23", 1500, 4500, 6.8));
      Inventario.guardarDispositivo(new Laptop(102, "Dell Inspiron", 3200, 16, 512));
      Inventario.guardarDispositivo(new Tablet(103, "iPad Pro", 2100, 2388));
      Inventario.guardarDispositivo(new Smartphone(104, "iPhone 13", 1850, 3095, 6.1));
      Inventario.guardarDispositivo(new Laptop(105, "Lenovo ThinkPad", 4600, 8, 256));
      Inventario.guardarDispositivo(new Tablet(106, "Galaxy Tab S8", 3000, 2560));
      Inventario.guardarDispositivo(new Smartphone(107, "Motorola Edge", 2400, 5000, 6.5));
      Inventario.guardarDispositivo(new Laptop(108, "Asus ZenBook", 1800, 32, 1024));
      Inventario.guardarDispositivo(new Tablet(109, "Huawei MatePad", 2100, 1920));
      Inventario.guardarDispositivo(new Smartphone(110, "Xiaomi 13", 1950, 4820, 6.7));

      Inventario.guardarDispositivo(new Smartphone(111, "Realme GT", 2200, 4500, 6.4));
      Inventario.guardarDispositivo(new Laptop(112, "HP Pavilion", 3100, 12, 512));
      Inventario.guardarDispositivo(new Tablet(113, "Lenovo Tab M10", 1500, 1280));
      Inventario.guardarDispositivo(new Smartphone(114, "Nokia X20", 1000, 4470, 6.6));
      Inventario.guardarDispositivo(new Laptop(115, "Acer Aspire", 2600, 8, 256));
      Inventario.guardarDispositivo(new Tablet(116, "Amazon Fire HD", 900, 1920));
      Inventario.guardarDispositivo(new Smartphone(117, "Google Pixel 6", 1600, 4614, 6.4));
      Inventario.guardarDispositivo(new Laptop(118, "MSI Stealth", 4200, 64, 2048));
      Inventario.guardarDispositivo(new Tablet(119, "Surface Go", 2400, 1920));
      Inventario.guardarDispositivo(new Smartphone(120, "ZTE Axon", 1750, 4000, 6.9));

      Inventario.guardarDispositivo(new Smartphone(121, "Poco X5", 1200, 5000, 6.7));
      Inventario.guardarDispositivo(new Laptop(122, "Samsung Book", 3300, 16, 1024));
      Inventario.guardarDispositivo(new Tablet(123, "BQ Aquaris M10", 1700, 1920));
      Inventario.guardarDispositivo(new Smartphone(124, "Vivo V27", 1100, 4500, 6.5));
      Inventario.guardarDispositivo(new Laptop(125, "Razer Blade", 3900, 32, 1024));
      Inventario.guardarDispositivo(new Tablet(126, "Teclast T20", 1400, 2560));
      Inventario.guardarDispositivo(new Smartphone(127, "Sony Xperia 5", 1900, 4000, 6.1));
      Inventario.guardarDispositivo(new Laptop(128, "Alienware M15", 4500, 64, 2048));
      Inventario.guardarDispositivo(new Tablet(129, "Toshiba Encore", 1300, 1280));
      Inventario.guardarDispositivo(new Smartphone(130, "Honor Magic5", 2000, 4800, 6.8));

      Inventario.guardarDispositivo(new Smartphone(131, "OnePlus Nord", 1550, 4500, 6.43));
      Inventario.guardarDispositivo(new Laptop(132, "MacBook Pro", 3600, 16, 512));
      Inventario.guardarDispositivo(new Tablet(133, "iPad Mini", 2500, 2048));
      Inventario.guardarDispositivo(new Smartphone(134, "Asus ROG Phone", 2100, 6000, 6.78));
      Inventario.guardarDispositivo(new Laptop(135, "Chuwi HeroBook", 1800, 8, 128));
      Inventario.guardarDispositivo(new Tablet(136, "Archos Oxygen", 1900, 1920));
      Inventario.guardarDispositivo(new Smartphone(137, "Wiko Power U30", 1000, 6000, 6.8));
      Inventario.guardarDispositivo(new Laptop(138, "Vaio Z", 2700, 16, 1024));
      Inventario.guardarDispositivo(new Tablet(139, "Onda V10 Pro", 1600, 2560));
      Inventario.guardarDispositivo(new Smartphone(140, "Doogee S98", 1850, 6000, 6.3));

      Inventario.guardarDispositivo(new Smartphone(141, "Infinix Note", 1700, 5000, 6.78));
      Inventario.guardarDispositivo(new Laptop(142, "Google Pixelbook", 2950, 16, 256));
      Inventario.guardarDispositivo(new Tablet(143, "Zebra ET51", 1750, 1920));
      Inventario.guardarDispositivo(new Smartphone(144, "Fairphone 4", 1450, 3905, 6.3));
      Inventario.guardarDispositivo(new Laptop(145, "LG Gram", 3400, 32, 1024));
      Inventario.guardarDispositivo(new Tablet(146, "Panasonic Toughpad", 1600, 1920));
      Inventario.guardarDispositivo(new Smartphone(147, "Sharp Aquos R7", 2200, 5000, 6.6));
      Inventario.guardarDispositivo(new Laptop(148, "Fujitsu Lifebook", 2600, 16, 512));
      Inventario.guardarDispositivo(new Tablet(149, "Xiaomi Pad 5", 2700, 2560));
      Inventario.guardarDispositivo(new Smartphone(150, "Meizu 18", 1950, 4000, 6.2));




      /// funcionalidades  test
        System.out.println("====CAL TIEMPO======");
        Inventario.calcularTiempoUsoPorTipo();

        System.out.println("======ID REPETIDO========");
        Inventario.guardarDispositivo(new Laptop(91, "HP", 320, 16, 1024));
        Inventario.guardarDispositivo(new Tablet(92, "Huawei", 260, 1440));
        Inventario.guardarDispositivo(new Smartphone(93, "OnePlus", 230, 128.0, 6.4));
        System.out.println("=====LIST PRODUC=======");
        Inventario.listarNombresDispositivos();
        System.out.println("===ID INFO NO EXISTE====");
        Inventario.mostrarDatosDispositivo(222222);



    }

}
