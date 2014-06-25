package test;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.transaction.annotation.Transactional;

/**
 * 
 * @author worldheart
 *
 */
@Transactional
public class TransactionOpera {

	protected static final Log log = LogFactory.getLog(TransactionOpera.class);
	
	
	public void updateDB(DataSource ds) {
		try{
			//������Spring�ṩ��DataSourceUtilsʵ���࣬
			//��õ�ǰ�����Ѿ�������Connection����
			Connection conn = DataSourceUtils.getConnection(ds);
			Statement stat = conn.createStatement();
			log.info(
					stat.executeUpdate(
							"update owners set last_name = 'Luo' where id = 2"));
			//��Ҫ�ֹ��ر�Statement���������ǲ��ܹ��ر�conn��
			//��Ϊ��ǰ�������ʱSpring�Ḻ��ر���
			stat.close();
			//�׳��쳣�������߿���ȥ���ݿ��鵱ǰRDBMS�����Ƿ�һ�£�
			//���߿��Խ�����������ε�
			throw new RuntimeException("xx");
		} catch(SQLException sql){
			throw new RuntimeException(sql);
		}
	}
	
}
