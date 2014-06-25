package test;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * ����ApplicationContext
 * 
 * @author worldheart
 *
 */
public class ApplicationContextConstructDemo1 {

	protected static final Log log = LogFactory.getLog(ApplicationContextConstructDemo1.class);
	
	public static void main(String[] args){
		
		//��classpath��·������resource1.xml
		ApplicationContext ac = new ClassPathXmlApplicationContext("resource1.xml");
		
		//��classpath test·������resource2.xml
		ac = new ClassPathXmlApplicationContext("classpath:test/resource2.xml");
		
		//��TestBean������classpath��λresource2.xml
		ac = new ClassPathXmlApplicationContext("resource2.xml", TestBean.class);
		
		//ͨ��URL��λresource1.xml
		ac= new ClassPathXmlApplicationContext("file:D:/eclipse/workspace/resourcedemo/src/resource1.xml");

		//ֱ�Ӵ����ļ�·��
		ac = new FileSystemXmlApplicationContext("D:/eclipse/workspace/resourcedemo/src/test/resource2.xml");
		
		//ͨ��classpath��λresource2.xml
		ac = new FileSystemXmlApplicationContext("classpath:test/resource2.xml");
		
	}
	
}
