package test;

import java.util.Locale;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 
 * <pre>
 * 演示MessageSource的使用。
 * </pre>
 * @author http://www.open-v.com
 * @version 1.00.00
 * <pre>
 * 修改记录
 *    修改后版本:     修改人：  修改日期:     修改内容: 
 * </pre>
 */
public class MessageSourceDemo {

	private static final Log log = LogFactory.getLog(MessageSourceDemo.class);

	public static void main(String[] args) {		
		//实例化IoC容器
		ApplicationContext aac = new ClassPathXmlApplicationContext("messagesource.xml");
		
		//访问message_en.properties中的消息
		log.info(aac.getMessage("helloworld", null, Locale.ENGLISH));
		//访问message_zh_CN.properties中的消息
		log.info(aac.getMessage("helloworld", null, Locale.CHINA));
		//访问message_en.properties中的消息，并传入参数
		log.info(aac.getMessage("welcome", new Object[]{"worldheart"} , Locale.ENGLISH));
		//访问message_zh_CN.properties中的消息，并传入参数
		log.info(aac.getMessage("welcome", new Object[]{"访客"}, Locale.CHINA));
		
		//访问parenthelloworld_en.properties中的消息，使用父MessageSource。
		log.info(aac.getMessage("parenthelloworld", null, Locale.ENGLISH));	

		//访问message_zh_CN.properties中的消息。由于hw键不存在，因此抛出异常
		log.info(aac.getMessage("hw", null, Locale.CHINA));
	}
	
}