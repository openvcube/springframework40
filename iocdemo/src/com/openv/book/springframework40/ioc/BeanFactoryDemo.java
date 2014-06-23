package com.openv.book.springframework40.ioc;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class BeanFactoryDemo {

	private static final Log log = LogFactory.getLog(BeanFactoryDemo.class);

	public static void main(String[] args) {
		//��classpath·����װ��XML������Ϣ
		Resource resource = new ClassPathResource("beanfactory.xml");
		
		//ʵ����IoC��������ʱ��������δʵ����beanfactory.xml������ĸ����ܹ�Bean
		BeanFactory factory = new XmlBeanFactory(resource);
		
		//����ܹ�Bean
		IBankSecurityService bankSecurityService = 
			(IBankSecurityService) factory.getBean("bankSecurityService");
		
		bankSecurityService.bankToSecurity(2000.00);
		bankSecurityService.securityToBank(2000.00);
	}

}
