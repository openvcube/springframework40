/**
 * 
 */
package test;

import javax.jms.JMSException;
import javax.jms.Queue;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;



/**
 * ��ʾJndiObjectFactoryBean��ʹ��
 * 
 * @author worldheart
 *
 */
public class JndiOfbDemo {

	protected static final Log log = LogFactory.getLog(JndiOfbDemo.class);
	
	public static void main(String[] args) {
		
		//jndiofb.xml��jndienv.xml��jndilookup.xml
		ApplicationContext ac = new ClassPathXmlApplicationContext("jndilookup.xml");
		
		//���javax.jms.Queue����
		Queue tq = (Queue)ac.getBean("tq");
		try{
			log.info(tq.getQueueName());
		} catch(JMSException je){
			log.error("", je);
		}
		
	}

}
