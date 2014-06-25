package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 
 * @author worldheart
 *
 */
public class HSQLJdbcDemo {

	private static final Log log = LogFactory.getLog(HSQLJdbcDemo.class);
	
	public static void main(String[] args) {		
		try {
			//װ��JDBC����
			Class.forName("org.hsqldb.jdbcDriver");
		} catch (ClassNotFoundException e) {
			log.error("", e);
		}
		
		Properties prop = new Properties();
		prop.setProperty("username", "sa");
		prop.setProperty("password", "");
				
		try {
			//��������URL���������
			Connection conn = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost:9001", prop);
			//����Statement
			Statement stat = conn.createStatement();
			//ִ��SQL��䣬�����ؽ����
			ResultSet rs = stat.executeQuery("select * from pets");
			while(rs.next()){
				StringBuilder sb = new StringBuilder("id:" + rs.getInt("id"));
				sb.append(",name:" + rs.getString("name"));
				sb.append(",birth_date:" + rs.getDate("birth_date"));
				sb.append(",type_id:" + rs.getInt("type_id"));
				sb.append(",owner_id:" + rs.getInt("owner_id"));
				log.info(sb.toString());
			}
			//�ر������Դ
			rs.close();
			stat.close();
			conn.close();
		} catch (SQLException e) {
			log.error("", e);
		}		
	}

}
