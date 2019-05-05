/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Functions;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author lenovo
 */
public class DBConnect {
    public static Connection connection = null;
    public static String URL = "jdbc:mysql://localhost:3306/supermarket";
    public static String HOSTNAME = "root";
    public static String PASSWORD = "";
	//connect the database 
	public static Connection ConnectDB(){
		try{
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(URL,HOSTNAME,PASSWORD);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return connection;
	}
}
