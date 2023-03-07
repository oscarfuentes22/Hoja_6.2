package src;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
public class files {
    static factory<Map<String, Integer>> mapaGrande = new factory<>();
    static factory<Integer> mapaPequeno = new factory<>();

    public static void saveFile(Map<String, Map<String, Integer>> map) {
        try {
            FileWriter myWriter = new FileWriter(".\\src\\ListadoProducto.txt");
            myWriter = new FileWriter(".\\src\\ListadoProducto.txt");
            for (String llave : map.keySet()) {
                for (String key : map.get(llave).keySet()) {
                    for (int i = 0; i < map.get(llave).get(key); i++) {
                        myWriter.write(llave + " | " + key+ "\n");
                    }
                }

            }
            myWriter.close();
        } catch (IOException exepcion) {
            exepcion.printStackTrace();
        }

    }


    public static Map<String, Map<String, Integer>> leerFile(String tipoMapa){
        Map<String, Map<String, Integer>> MapaGrande = mapaGrande.tipoMapa(tipoMapa);
        Map<String, Integer> MapaPequeno  = mapaPequeno.tipoMapa(tipoMapa);
        try {
            File myObj = new File(".\\src\\ListadoProducto.txt");
            Scanner myReader = new Scanner(myObj);
            String data = myReader.nextLine();
            while (myReader.hasNextLine()) {


                String[] datas = data.split("\\|");
                datas[0] = datas[0].trim();
                datas[1] = datas[1].trim();

                if (!MapaPequeno .containsKey(datas[1])) {
                    MapaPequeno .put(datas[1], 1);

                } else {
                    MapaPequeno .put(datas[1], MapaPequeno .get(datas[1]) + 1);
                }

                String tempData = datas[0];

                data = myReader.nextLine();
                if (!tempData.equals(data.split("\\|")[0].trim())) {
                    MapaGrande.put(tempData, MapaPequeno );
                    MapaPequeno  = mapaPequeno.tipoMapa(tipoMapa);
                }
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return MapaGrande;
    }
}
