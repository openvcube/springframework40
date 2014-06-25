package test;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * ����FactoryBean��ʹ��
 * 
 * @author worldheart
 */
public class PropertyPathDemo {

	protected static final Log log = LogFactory.getLog(PropertyPathDemo.class);

	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("propertypath.xml");
		
		log.info(ac.getBean("propertyPath"));
		log.info(ac.getBean("property-path"));
		
	}

}