package dsa.proyecto.g6.Util;

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

}
