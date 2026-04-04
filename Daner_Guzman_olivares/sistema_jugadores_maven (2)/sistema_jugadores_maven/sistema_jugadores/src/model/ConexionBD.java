package model;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexionBD {

    private static final String HOST = "bguscmyc1lmzq1ls6wpn-mysql.services.clever-cloud.com";
    private static final String PORT = "3306";
    private static final String DB   = "bguscmyc1lmzq1ls6wpn";
    private static final String USER = "u9ujha4l5dlw1m1g";
    private static final String PASS = "mFzcFDk3PpHBhtpo7NQQ";

    private static final String URL = "jdbc:mysql://" + HOST + ":" + PORT + "/" + DB
            + "?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";

    public static Connection getConexion() {
        try {
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (Exception e) {
            System.out.println("Error de conexión: " + e.getMessage());
            return null;
        }
    }
}
