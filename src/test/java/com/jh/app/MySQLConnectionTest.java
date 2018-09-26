package com.jh.app;
 
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

 
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/config/root-context.xml" })
public class MySQLConnectionTest {
    
	@Autowired
    private DataSource ds;
 
    @Test
    public void testConnection() throws Exception {

        try (Connection con = ds.getConnection()) {
 
            System.out.println("\n >>>>>>>>>> Connection Ãâ·Â : " + con + "\n");
/*            Statement stmt = con.createStatement();
            ResultSet resultSet = stmt.executeQuery("select * from testtable");
		      while( resultSet.next() )
		      {
		      	String string = resultSet.getString(1);
		      	System.out.println(string);
		      }*/
        } catch (Exception e) {
            e.printStackTrace();
        } 
    }
    
}