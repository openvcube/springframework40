package org.springframework.samples;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.generic.GenericBeanFactoryAccessor;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.support.JdbcUtils;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

/**
 * 
 * @author worldheart
 *
 */
public class MainTestForTransactionAwareDataSourceProxy {

	private static final Log log = LogFactory.getLog(MainTestForTransactionAwareDataSourceProxy.class);
	
	public static void main(String[] args) {
		
		ListableBeanFactory cbf = new ClassPathXmlApplicationContext("dsproxy.xml");		
		GenericBeanFactoryAccessor gbfa = new GenericBeanFactoryAccessor(cbf);
		
		TransactionTemplate tt = gbfa.getBean("transactionTemplate");
		
		//�����dataSource�滻��dataSourceTarget��
		//��ʹstatus.setRollbackOnly()ִ���ˣ�last_name���Ǳ�������
		final DataSource ds = gbfa.getBean("dataSource");
		
		tt.execute(new TransactionCallbackWithoutResult(){
			protected void doInTransactionWithoutResult(TransactionStatus status) {
				Connection conn = null;
				Statement stat = null;				
				try{
					conn = ds.getConnection();
					stat = conn.createStatement();
					log.info(stat.executeUpdate(
							"update owners set last_name = 'Luo' where telephone = '16068008'"));
					//��ʶ����ع�
					status.setRollbackOnly();
				}catch(SQLException exec){
					log.error("", exec);
				} finally{
					JdbcUtils.closeStatement(stat);
					JdbcUtils.closeConnection(conn);
				}
			}
		});
	}

}