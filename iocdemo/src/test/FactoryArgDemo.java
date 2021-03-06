package test;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/**
 * 
 * <pre>
 * 演示通过构造器注入factory-bean、factory-method所需的参数。
 * </pre>
 * @author http://www.open-v.com
 * @version 1.00.00
 * <pre>
 * 修改记录
 *    修改后版本:     修改人：  修改日期:     修改内容: 
 * </pre>
 */
public class FactoryArgDemo {

	private static final Log log = LogFactory.getLog(FactoryArgDemo.class);

	public void getContent(){
		//从classpath路径上装载XML配置信息
		Resource resource = new ClassPathResource("factoryarg.xml");
		//实例化IoC容器
		BeanFactory factory = new XmlBeanFactory(resource);
		//获得受管POJO
		IHelloWorld hw1 = (IHelloWorld) factory.getBean("helloWorld1");
		//输出字符串
		log.info(hw1.getContent());
		//获得受管POJO
		IHelloWorld hw2 = (IHelloWorld) factory.getBean("helloWorld2");
		//输出字符串
		log.info(hw2.getContent());
	}

	public static void main(String[] args) {
		FactoryArgDemo bfd = new FactoryArgDemo();
		bfd.getContent();
	}
	
}