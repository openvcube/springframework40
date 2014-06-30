package test;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 
 * <pre>
 * 演示PropertyOverrideConfigurer的使用。
 * </pre>
 * @author http://www.open-v.com
 * @version 1.00.00
 * <pre>
 * 修改记录
 *    修改后版本:     修改人：  修改日期:     修改内容: 
 * </pre>
 */
public class PropertyOverrideConfigurerDemo {

	protected final static Log log = LogFactory.getLog(PropertyOverrideConfigurerDemo.class);

	public static void main(String[] args) {
		
		ApplicationContext ac = new ClassPathXmlApplicationContext(
				"propertyoverrideconfigurer.xml");

		IUserInfo ui = (IUserInfo) ac.getBean("userInfo");

		log.info(ui.getUserInfo());
	}
	
}
