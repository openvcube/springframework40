/**
 * 
 */
package test;

import javax.naming.Context;
import javax.naming.NamingException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jndi.JndiCallback;
import org.springframework.jndi.JndiTemplate;



/**
 * ��ʾJndiObjectFactoryBean��ʹ��
 * 
 * @author worldheart
 *
 */
public class JndiTemplateDemo {

	protected static final Log log = LogFactory.getLog(JndiTemplateDemo.class);
	
	public static void main(String[] args) {
		
		ApplicationContext ac = new ClassPathXmlApplicationContext("jnditemplate.xml");
		
		//���JndiTemplate
		JndiTemplate jt = (JndiTemplate)ac.getBean("jndiTemplate");

		String jndiTemplateStr = new String("jndiTemplate");
		final String jndiCallbackStr = new String("jndiCallbackStr");
		
		try{
			//������󶨵�JNDI����
			jt.bind("jndiTemplate",jndiTemplateStr);
			//��ӡ�����ҽ��
			log.info(jt.lookup("jndiTemplate"));
			//��JNDI����ȥ������İ�
			jt.unbind("jndiTemplate");
			
			jt.execute(new JndiCallback(){
				public Object doInContext(Context ctx) throws NamingException {
					ctx.bind("jndiCallback", jndiCallbackStr);
					log.info(ctx.lookup("jndiCallback"));
					ctx.unbind("jndiCallback");			
					return null;
				}				
			});
		} catch(NamingException ne){
			log.error("", ne);
		}
		
	}

}
