package dsa.proyecto.g6.Util;

import java.util.HashMap;

public class QueryHelper {

    /*Query que recibe una entidad/objeto y hace un INSERT de ese elemento*/

    public static String createQueryINSERT(Object entity) {

        StringBuffer sb = new StringBuffer("INSERT INTO ");
        sb.append(entity.getClass().getSimpleName()).append(" ");
        sb.append("(");

        String [] fields = ObjectHelper.getFields(entity); //Recogemos cada campo de la clase

        //sb.append(fields[0]);
        for (String field: fields) {
            sb.append(field).append(", ");

            //sb.append(", ").append(field); //Los vamos añadiendo junto con la ,
        }
        //Hacemos esto para quitar el espacio y la coma finales
        sb=sb.replace(sb.length()-2,sb.length(),"");
        sb.append(") VALUES (?");

        for (String field: fields) {
            sb.append(", ?");
        }
        sb=sb.replace(sb.length()-3,sb.length(),"");
        sb.append(")");

        return sb.toString();
    }

    public static String createQuerySELECT(Object entity) {
        StringBuffer sb = new StringBuffer();
        sb.append("SELECT * FROM ").append(entity.getClass().getSimpleName());
        sb.append(" WHERE ID = ?");

        return sb.toString();
    }
/*Query que recibe una entidad/objeto y hace un SELECT ALL de ese elemento*/
    public static String createQuerySELECTAll(Class theClass){
        StringBuffer sb = new StringBuffer();
        sb.append("SELECT * FROM ").append(theClass.getSimpleName()); //Por ej employee = SELECT * FROM Employee
        return sb.toString();
    }
    public static String createQuerySELECTByParams(Object object, HashMap params){
        StringBuffer sb = new StringBuffer();
        sb.append("SELECT * FROM ").append(object.getClass().getSimpleName()).append(" ");
        sb.append("WHERE 1=1");
        params.forEach((k,v)->sb.append(" AND ").append(k.toString()).append(" = ").append("?"));
        System.out.println("QUERY POR PARAMETROS Y HASHMAP");
        System.out.println(sb.toString());
        return sb.toString();
    }

}
