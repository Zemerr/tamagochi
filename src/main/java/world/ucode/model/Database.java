package world.ucode.model;

import world.ucode.Main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.DatabaseMetaData;

public class Database {

    public static Connection conn = null;
    public static Statement statmt = null;
    public static ResultSet resSet = null;
    public static PreparedStatement pstmt = null;
    public static boolean saving = true;


    public static void Conn() throws ClassNotFoundException, SQLException
    {
        conn = null;
        Class.forName("org.sqlite.JDBC");
        conn = DriverManager.getConnection("jdbc:sqlite:uscore.s3db");
    }

    public static void checkDB() throws ClassNotFoundException, SQLException
    {
        Conn();
        statmt = conn.createStatement();


        DatabaseMetaData dbm = conn.getMetaData();
        ResultSet tables = dbm.getTables(null, null, "hiscore", null);
        if (tables.next()) {

            resSet = statmt.executeQuery("SELECT * FROM hiscore WHERE id = 1");
            Datareserve.dataserve.feedpos = resSet.getInt("feedpos");
            Datareserve.dataserve.waterpos = resSet.getInt("waterpos");
            Datareserve.dataserve.medicinepos = resSet.getInt("medicinepos");
            Datareserve.dataserve.crabs = resSet.getInt("crabs");
            Datareserve.dataserve.health = resSet.getInt("health");
            Datareserve.dataserve.cleanpos = resSet.getInt("cleanpos");

        }
        else {
            Datareserve.dataserve.first_enty = true;

        }
        CloseDB();
    }

    public static void WriteDB(int health, int feedpos, int waterpos, int medicinepos, int cleanpos, int crabs) throws ClassNotFoundException, SQLException  {
        if (saving == true) {
            Conn();
            String executes = "Update hiscore SET health = ?, waterpos = ?, medicinepos = ?, cleanpos = ?, crabs = ?, feedpos = ? WHERE id = 1; ";
            pstmt = conn.prepareStatement(executes);
            pstmt.setInt(1, health);
            pstmt.setInt(2, waterpos);
            pstmt.setInt(3, medicinepos);
            pstmt.setInt(4, cleanpos);
            pstmt.setInt(5, crabs);
            pstmt.setInt(6, feedpos);
            pstmt.executeUpdate();
            CloseDB();
        }
    }

    public static void createtable() throws ClassNotFoundException, SQLException {
        Conn();
        statmt = conn.createStatement();
        statmt.execute("CREATE TABLE if not exists 'hiscore' ('id' INTEGER PRIMARY KEY AUTOINCREMENT, 'feedpos' INTEGER, 'waterpos' INTEGER, 'medicinepos' INTEGER, 'crabs' INTEGER, 'health' INTEGER, 'cleanpos' INTEGER, 'date' date);");
        statmt.execute("INSERT INTO hiscore VALUES (1,41, 78, 46, 50, 80, 38, datetime('now', 'localtime'));");
        CloseDB();
    }

    public static void deleteTable() throws SQLException, ClassNotFoundException {
        Conn();
        statmt = conn.createStatement();
        statmt.execute("DROP TABLE IF EXISTS 'hiscore';");
        CloseDB();
    }

    public static void CloseDB() throws ClassNotFoundException, SQLException
    {

        if (resSet != null) {
            resSet.close();
            resSet = null;
        }
        if (statmt != null) {
            statmt.close();
            statmt = null;
        }
        if (pstmt != null) {
            pstmt.close();
            pstmt = null;
        }
        if (conn != null) {
            conn.close();
            conn = null;
        }
    }


}
