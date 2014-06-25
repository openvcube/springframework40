package test;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.config.java.annotation.Bean;
import org.springframework.config.java.annotation.Configuration;
import org.springframework.config.java.context.JavaConfigApplicationContext;

@Configuration
public class JavaConfigDemo {

	protected static final Log log = 
		LogFactory.getLog(JavaConfigDemo.class);

	@Bean
	public IHelloWorld helloWorld(){
		HelloWorld hw = new HelloWorld();
		hw.setHelloStr(helloStr());
		return hw;
	}
	
	@Bean
	public IHelloStr helloStr(){
		return new FileHelloStrImpl("helloworld.properties");
	}
	
	public static void main(String[] args) {
		//��ע����װ��DI��������Ԫ����
		JavaConfigApplicationContext context = 
				new JavaConfigApplicationContext(JavaConfigDemo.class);
		
		//����ܹ�Bean
		IHelloWorld hw = context.getBean(IHelloWorld.class);

		//�����ַ���
		log.info(hw.getContent());
	}

}