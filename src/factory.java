package src;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class factory <T>{

    public Map<String,T> tipoMapa(String tipoMapa){
        switch (tipoMapa){
            case "hashmap":
                return new HashMap<>();
            case "treemap":
                return new TreeMap<>();
            case "linkedhashmap":
                return new LinkedHashMap<>();
            default:
                return null;
        }
    }
}