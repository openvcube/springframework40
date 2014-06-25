package test;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * ��ʾConfigurableע�͵�ʹ��
 * 
 * @author worldheart
 */
public class ConfigurableDemo{

	protected static final Log log = LogFactory.getLog(ConfigurableDemo.class);

	public static void main(String[] args) {
		
		//����Spring DI�������AspectJ 6��������ù��������罫IoC������¶������
		new ClassPathXmlApplicationContext("ltw.xml");
				
		log.info("���������������");
		
		//�ܶ�ʱ��Hibernate/JPA/Ӧ�ô���Ḻ�𴴽��������
		ConfiguredBySpringDI springDI = new ConfiguredBySpringDI();
		
		log.info("AspectJ 6�Ѿ�����������������ù���");
		
		// ���ǲ�û����ʽ����springDI��Э���ߣ���infoBeanȷʵ������null
		log.info(springDI.getInfoBean().getUserName());
		log.info(springDI.getInfoBean().getPassword());
		
	}
	
}

