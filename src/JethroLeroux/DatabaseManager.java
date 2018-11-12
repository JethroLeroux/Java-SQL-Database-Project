/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JethroLeroux;

/**
 *
 * @author Jethro
 */
import java.io.FileNotFoundException;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DatabaseManager
{
    private Connection conn = null;

    public DatabaseManager()
	{
		try
		{
                        Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
                        conn=DriverManager.getConnection("jdbc:ucanaccess://RepairsPAT.accdb");
			System.out.println("Connection To Table Succesful");
		}catch(Exception e)
		{
			System.out.println("Failed To Aquire Connection To Table");
			e.printStackTrace();
		}
        }

    public ResultSet queryDatabase(String sql) throws SQLException
    {
        Statement stmt = conn.createStatement();
        return stmt.executeQuery(sql);
    }

    public void updateDatabase(String sql) throws SQLException
    {
        Statement stmt = conn.createStatement();
        stmt.execute(sql);
    }
    
    
}
