package util.dbtool;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
/**
 * 获取连接的工厂
 * @author 
 *
 */
public class ConnectionFactory {
		
		
		


//wjt-jdbc连接数据库方式////////////////////////////////////////////////////
	  private static  ConnectionFactory instance;
	  private ConnectionFactory()
	  {	  
	  }
	  public static synchronized ConnectionFactory getInstance()
	  {
		  if(instance==null)
		  {
			  instance=new  ConnectionFactory();
		  }
		  return instance;
	  }
	  public Connection getConnection()
	  {
		  Connection conn=null;
		  try
		{
			  Properties properties =new Properties();
			  properties.load(ConnectionFactory.class.getResourceAsStream("../../db.properties"));
			  //1注册驱动
			Class.forName(properties.getProperty("driverName"));
			
			String url=properties.getProperty("url");
			
			conn=DriverManager.getConnection(url, properties.getProperty("userName"),properties.getProperty("password"));
			
		}
		catch (ClassNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
		  
	  }

	
}

