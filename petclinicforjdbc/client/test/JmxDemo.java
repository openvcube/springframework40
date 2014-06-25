package test;

import java.lang.management.ManagementFactory;

import javax.management.InstanceAlreadyExistsException;
import javax.management.MBeanRegistrationException;
import javax.management.MBeanServer;
import javax.management.MalformedObjectNameException;
import javax.management.NotCompliantMBeanException;
import javax.management.ObjectName;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 
 * @author worldheart
 * 
 */
public class JmxDemo {
	
	protected static final Log log = LogFactory.getLog(JmxDemo.class);

	public static void main(String[] args) throws MalformedObjectNameException,
			NullPointerException, InstanceAlreadyExistsException,
			MBeanRegistrationException, NotCompliantMBeanException,
			InterruptedException {
		//����JMX������
		MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();
		//����MBean���������
		ObjectName on = new ObjectName("jmxdemo:ui=UserInfo");

		UserInfoMBean ui = new UserInfo();
		ui.setUserName("spring");
		ui.setPassword("dragon");
		//	ע��MBean���
		mbs.registerMBean(ui, on);

		while (true) {
			Thread.sleep(5000);
			log.info(ui);
		}
	}
	
}
