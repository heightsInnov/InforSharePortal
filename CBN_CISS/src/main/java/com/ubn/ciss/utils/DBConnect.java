package com.ubn.ciss.utils;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class DBConnect {

	@Value("${DB_Driver}")
	private String driver;

	@Value("${DB_Username}")
	private String username;

	@Value("${DB_Password}")
	private String password;

	@Value("${DB_ConnString}")
	private String url;
	
	@Value("${DATASOURCE_JNDI}")
	private String DATASOURCE_JNDI;
	
	  public Connection getConn() {
	        Context initCtx = null;
	        DataSource ds = null;
	        Connection conn = null;
	        try {
	            initCtx = new InitialContext();
	            ds = (DataSource) initCtx.lookup(DATASOURCE_JNDI);

	            conn = ds.getConnection();
	            System.out.println("Connection " + conn);
	        } catch (SQLException e) {
	            System.out.println("SQLException In Connection : " + e.getMessage());
	            e.printStackTrace();
	        } catch (Exception e) {
	            System.out.println("Exception In connection : " + e.getMessage());
	            e.printStackTrace();
	        }
	        return conn;
	    } 

	
	public Connection getPrConn() {
		PBEncrytor pb = new PBEncrytor();
		Connection connection = null;
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			connection = DriverManager.getConnection(url, username, pb.PBDecrypt(password));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return connection;
	}
	
	public void CloseConnect(Connection conn, CallableStatement pst, ResultSet rs) {
		try {
			if(rs != null) {
				rs.close();
			}
			if(pst != null) {
				pst.close();
			}
			if(conn != null) {
				conn.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
