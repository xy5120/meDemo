package com.xy5120.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


/**
 * 
 *  Class Name: DBUtil.java
 *  Description: 数据库工具类
 *  @author xy  DateTime 2018-12-6 下午04:56:31 
 *  @version 1.0
 */
public class DBUtil {
	private static final String URL  ="jdbc:oracle:thin:@127.0.0.1:1521:oacl" ;
	private static final String USER  ="school" ;
	private static final String PWD  ="123123" ;
	public static PreparedStatement ps = null ;
	public static Connection conn = null ;
	public static ResultSet rs = null ; 
		/**
		 * 
		 *  Description:通用增删改
		 *  @author xy  DateTime 2018-12-6 下午04:56:59
		 *  @param sql
		 *  @param obj
		 *  @return
		 */
		public static boolean executeUpdate(String sql,Object[] obj) {
			try {
				ps = createPreParedStatement(sql,obj);
				int count = ps.executeUpdate() ;
				if(count>0)
					return true ;
				else 
					return false ;
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
				  return false ;
			} catch (SQLException e) {
				e.printStackTrace();
				  return false ;
			}catch (Exception e) {
				e.printStackTrace();
				return false ;
			}
			finally {
				closeAll(null,ps,conn);
			}
		}
		/**
		 * 
		 *  Description:关闭数据库资源
		 *  @author xy  DateTime 2018-12-6 下午04:57:26
		 *  @param rs
		 *  @param sta
		 *  @param conn
		 */
		public static void closeAll(ResultSet rs,Statement sta,Connection conn)
		{
			try {
				if(rs!=null)rs.close();
				if(ps!=null)ps.close();
				if(conn!=null)conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} 
			
			
		}
		/**
		 * 
		 *  Description:建立数据库链接
		 *  @author xy  DateTime 2018-12-6 下午04:57:50
		 *  @return
		 *  @throws ClassNotFoundException
		 *  @throws SQLException
		 */
		private static Connection getConnection() throws ClassNotFoundException, SQLException {
			 Class.forName("oracle.jdbc.OracleDriver") ;
			 return  DriverManager.getConnection(URL, USER, PWD);
		}
		/**
		 * 
		 *  Description:创建会话
		 *  @author xy  DateTime 2018-12-6 下午04:58:05
		 *  @param sql
		 *  @param obj
		 *  @return
		 *  @throws ClassNotFoundException
		 *  @throws SQLException
		 */
		private static PreparedStatement createPreParedStatement(String sql,Object[] obj) throws ClassNotFoundException, SQLException {
			  ps = getConnection() .prepareStatement( sql) ;
			  if(obj!=null ) {
				  for(int i=0;i<obj.length;i++) {
					  ps.setObject(i+1, obj[i]);
				  }
			  }
			  return ps;
		}
	
		/**
		 * 
		 *  Description:通用查询
		 *  @author xy  DateTime 2018-12-6 下午04:58:27
		 *  @param sql
		 *  @param obj
		 *  @return
		 */
		public static ResultSet executeQuery( String sql ,Object[] obj) {
			try {
				ps = createPreParedStatement(sql,obj);
				rs =  ps.executeQuery() ;
				return rs ;
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
				return null ; 
			} catch (SQLException e) {
				e.printStackTrace();
				return null ; 
			}catch (Exception e) {
				e.printStackTrace();
				return null ; 
			}
		}
		
		/**
		 * 
		 *  Description:通用count查询
		 *  @author xy  DateTime 2018-12-6 下午04:58:49
		 *  @param sql
		 *  @return
		 */
		public static int queryCount(String sql){
			int count =-1;
			ResultSet rs = executeQuery(sql, null);
			try {
				if(rs.next()){
					count=rs.getInt(1);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				DBUtil.closeAll(rs, ps, conn);
			}
			return count;
		}
	
	
	
	
}
