package test;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.Resource;

/**
 * ֤ʵResource�ĸ����÷�
 * 
 * @author worldheart
 *
 */
public class ResourceDemo2 {

	protected static final Log log = LogFactory.getLog(ResourceDemo2.class);
	
	public static void main(String[] args){

		ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:test/resource2.xml");
		
		//���ClassPathResource
		Resource res = ac.getResource("test/resource2.xml");
		
		//���ClassPathResource
		res = ac.getResource("classpath:resource1.xml");
		
		//���UrlResource
		res = ac.getResource("file:D:/eclipse/workspace/resourcedemo/src/resource1.xml");
		
		//���ClassPathResource
		res = ac.getResource("D:/eclipse/workspace/resourcedemo/src/resource1.xml");
		
		ac = new FileSystemXmlApplicationContext("file:D:/eclipse/workspace/resourcedemo/src/resource1.xml");
		
		//���UrlResource
		res = ac.getResource("file:D:/eclipse/workspace/resourcedemo/src/resource1.xml");
		
		//���ClassPathResource
		res = ac.getResource("classpath:resource1.xml");
		
		//���FileSystemResource
		res = ac.getResource("D:/eclipse/workspace/resourcedemo/src/resource1.xml");
	}
	
}
