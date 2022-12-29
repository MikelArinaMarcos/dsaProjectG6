package dsa.proyecto.g6.Util;


import java.util.UUID;


public class IDs {
    public static int generarId() {
        return UUID.randomUUID().hashCode();
    }
}
