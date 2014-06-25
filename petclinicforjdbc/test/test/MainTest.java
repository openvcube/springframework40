package test;

import javax.sql.DataSource;

import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.generic.GenericBeanFactoryAccessor;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 
 * @author worldheart
 * 
 */
public class MainTest {

	public static void main(String[] args) {

		ListableBeanFactory cbf = new ClassPathXmlApplicationContext("ata.xml");
		GenericBeanFactoryAccessor gbfa = new GenericBeanFactoryAccessor(cbf);

		DataSource ds = gbfa.getBean("dataSource");
		
		//���ܹ�Bean����ֻ��ʵ������ͨ��Java����
		TransactionOpera to = new TransactionOpera();
		//������һ�������Բ���
		to.updateDB(ds);

	}

}
