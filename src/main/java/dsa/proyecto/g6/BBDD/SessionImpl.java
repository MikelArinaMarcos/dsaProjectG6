package dsa.proyecto.g6.BBDD;

import dsa.proyecto.g6.Util.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SessionImpl implements Session {
    private final Connection conn;

    public SessionImpl(Connection conn) {
        this.conn = conn;
    }
    public void save(Object entity) {

        String insertQuery = QueryHelper.createQueryINSERT(entity);

        System.out.println(insertQuery);

        PreparedStatement pstm = null;

        try {
            pstm = conn.prepareStatement(insertQuery);
            //pstm.setObject(1, 0);
            int i = 1;
            //System.out.println("Entramos al bucle que ahce cosas del save");
            for (String field: ObjectHelper.getFields(entity)) {
                pstm.setObject(i++, ObjectHelper.getter(entity, field));
            }
            System.out.println("!-!-!-!-!-!-!-! SENTENCIA!!!!11!!1!!1!1!!!!!!");
            System.out.println(pstm);
            pstm.executeQuery();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void close() {

    }

    @Override
    public void clean() {
        String query = "TRUNCATE TABLE Usuario";
        try {
            PreparedStatement pstm = conn.prepareStatement(query);
            pstm.executeQuery(); //Aqui en teoria limpiamos Usuario
            /*query = "TRUNCATE TABLE deparment";
            pstm = conn.prepareStatement(query);
            pstm.executeQuery(); //Aqui limpiamos deparment*/
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Object get(Class theClass, int ID) { //Aqui el mateix que el save pero amb la query del select
        try {
            Object entity = theClass.newInstance();

        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public void update(Object object, int id) {
        String updateQuery  = QueryHelper.createQueryUPDATE(object);
        PreparedStatement ptsm = null;
        try {
            ptsm = conn.prepareStatement(updateQuery);
            int i = 1;
            for (String field : ObjectHelper.getFields(object)) {
                ptsm.setObject(i++, ObjectHelper.getter(object, field));
            }
            ptsm.setObject(i,id);
            ptsm.executeQuery();
            System.out.println("SENTENCIA UPDATE QUE SE EJECUTA FINALMENTE!!!\n"+ptsm);
        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void delete(Object object) {

    }
/*Crea una lista de los objetos que pasamos como parametro (relamente pasamos una clase?)*/
    public List<Object> findAll(Class theClass) {
        String findQuery = QueryHelper.createQuerySELECTAll(theClass);
        System.out.println(findQuery);
        List<Object> listaObjeto = new ArrayList<Object>();
        PreparedStatement pstm = null;

        try {
            pstm = conn.prepareStatement(findQuery);
            pstm.setObject(1,1);
            System.out.println("!-!-!-!-!-!-!-! SENTENCIA !-!-!-!-!-!-!-!");
            System.out.println(pstm);
            pstm.executeQuery();
            ResultSet rs = pstm.getResultSet();
            while(rs.next()){
                Object o = theClass.getDeclaredConstructor().newInstance();
                for(int i = 1; i <= rs.getMetaData().getColumnCount(); i++){
                    ObjectHelper.setter(o,rs.getMetaData().getColumnName(i),rs.getObject(i));
                }
                listaObjeto.add(o);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return listaObjeto;
    }

    public List<Object> findAll(Class theClass, HashMap params) {
        return null;
    }

    public List<Object> query(String query, Class theClass, HashMap params) {
        return null;
    }

    public List<Object> findByParams(Object entity, HashMap params){
        String findQuery = QueryHelper.createQuerySELECTByParams(entity,params);
        PreparedStatement pstm = null;
        List<Object> objectList = new ArrayList<Object>();
        try {
            pstm = conn.prepareStatement(findQuery);
            int x = 1;
            for (Object value : params.values()) {
                pstm.setObject(x,value.toString());
                x++;
            }
            System.out.println("QUERY DEL findByParams QUE SE EJECUTA!\n" + pstm.toString());
            pstm.executeQuery();
            ResultSet rs = pstm.getResultSet();
            while (rs.next()){
                Object o = entity.getClass().newInstance();
                for(int i = 1; i<=rs.getMetaData().getColumnCount();i++){
                    ObjectHelper.setter(o,rs.getMetaData().getColumnName(i), rs.getObject(i));
                }
                objectList.add(o);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return objectList;
    }
}