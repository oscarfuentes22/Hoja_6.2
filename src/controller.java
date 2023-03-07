package src;

import java.util.ArrayList;
import java.util.Map;

public class controller {

    private static Map<String, Map<String, Integer>> inventario = null;
// inserta un producto en el inventario
    public static void anadirProducto(String producto, String clasificacion, int unidades)  {
        inventario.get(clasificacion).put(producto,unidades);
    }

    public static String ensenarProductoCategorias(String producto) {
        for (String llave : inventario.keySet()) {
            if (inventario.get(llave).containsKey(producto)) {
                return llave;
            }
        }
        return "No existe el producto";
    }


    public static String ensenarProductoUnidades(String producto){
            for(String llave: inventario.keySet()){
                if (inventario.get(llave).containsKey(producto)){
                    return producto +":"+  inventario.get(llave).get(producto).toString();
                }
            }
            return producto;
        }

    public void eliminarProducto(String producto){
        for (String llave: inventario.keySet()){
            if (inventario.get(llave).containsKey(producto)){
                inventario.get(llave).remove(producto);
            }
        }
    }

    public static String ensenarDetalles(String producto){
    return ensenarProductoCategorias(producto) + ":" + ensenarProductoUnidades(producto);
    }

    public static ArrayList<String> mostrarInventario(){
        ArrayList<String> detalles = new ArrayList<>();
        for (String llave: inventario.keySet()){
            for (String key: inventario.get(llave).keySet()){
                detalles.add(llave + ":" + key + ":" + inventario.get(llave).get(key));
            }
        }
        return detalles;
    }

    public static Map<String, Map<String, Integer>> getInventario() {
        return inventario;
    }

    public  static void setInventario(Map<String, Map<String, Integer>> inventario) {
        inventario = inventario;
    }

}