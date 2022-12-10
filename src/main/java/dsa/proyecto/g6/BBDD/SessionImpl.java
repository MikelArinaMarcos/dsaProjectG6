package dsa.proyecto.g6.BBDD;

import dsa.proyecto.g6.Util.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

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
            pstm.setObject(1, 0);
            int i = 2;
            System.out.println("Entramos al bucle que ahce cosas del save");
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
        String query = "TRUNCATE TABLE employee";
        try {
            PreparedStatement pstm = conn.prepareStatement(query);
            pstm.executeQuery(); //Aqui en teoria limpiamos employee
            query = "TRUNCATE TABLE deparment";
            pstm = conn.prepareStatement(query);
            pstm.executeQuery(); //Aqui limpiamos deparment
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

    public void update(Object object) {

    }

    public void delete(Object object) {

    }

    public List<Object> findAll(Class theClass) {
        return null;
    }

    public List<Object> findAll(Class theClass, HashMap params) {
        return null;
    }

    public List<Object> query(String query, Class theClass, HashMap params) {
        return null;
    }
}