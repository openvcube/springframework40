
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * ����ApplicationContext
 * 
 * @author worldheart
 * 
 */
public class ApplicationContextConstructDemo2 {

	protected static final Log log = LogFactory
			.getLog(ApplicationContextConstructDemo2.class);

	public static void main(String[] args) {

		// ��classpath·���ϲ�����resource��ͷ������XML�����ļ�����Ե�ǰӦ�ã�
		ApplicationContext ac1 = new ClassPathXmlApplicationContext(
				"classpath:**/resource*.xml");

		// ��classpath·���ϲ�������resource1.xml�����ļ�����Ե�ǰӦ�ã�
		ApplicationContext ac2 = new ClassPathXmlApplicationContext(
				"classpath*:**/resource1.xml");

		// ָ�����XML�����ļ�
		ApplicationContext ac3 = new ClassPathXmlApplicationContext(
				new String[] { "resource1.xml", "test/resource2.xml" });

	}

}
