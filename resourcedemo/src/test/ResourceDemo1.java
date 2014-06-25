package test;

import java.io.File;
import java.net.MalformedURLException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;

/**
 * ֤ʵResource�ĸ����÷�
 * 
 * @author worldheart
 *
 */
public class ResourceDemo1 {

	protected static final Log log = LogFactory.getLog(ResourceDemo1.class);
	
	public static void main(String[] args){
		
		//��classpath��·������resource1.xml
		Resource res = new ClassPathResource("resource1.xml");
		new XmlBeanFactory(res).getBean("testBean");
		
		//��testĿ¼��λresource2.xml
		res = new ClassPathResource("test/resource2.xml");
		new XmlBeanFactory(res).getBean("testBean");
		
		//��TestBean������Ŀ¼��λresource2.xml
		res = new ClassPathResource("resource2.xml", TestBean.class);
		new XmlBeanFactory(res).getBean("testBean");

		//ֱ�Ӵ����ļ�·��
		res = new FileSystemResource("D:/eclipse/workspace/resourcedemo/src/test/resource2.xml");
		new XmlBeanFactory(res).getBean("testBean");
		
		//��������File Handler���뵽FileSystemResource��
		File file = new File("D:/eclipse/workspace/resourcedemo/src/resource1.xml");
		res = new FileSystemResource(file);
		new XmlBeanFactory(res).getBean("testBean");
		
		try{
			//֧��file:��http:��ftp:����ǰ׺����Щ���Ǳ�׼��URL��ʽ
			res = new UrlResource("file:D:/eclipse/workspace/resourcedemo/src/resource1.xml");
			new XmlBeanFactory(res).getBean("testBean");
		} catch(MalformedURLException mue){
			log.error("", mue);
		}
		
	}
	
}
