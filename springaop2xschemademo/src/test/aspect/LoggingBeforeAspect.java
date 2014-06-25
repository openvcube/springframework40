package test.aspect;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.JoinPoint;

/**
 * 
 * @author worldheart
 *
 */
public class LoggingBeforeAspect {
	
	private static final Log log = LogFactory.getLog(LoggingBeforeAspect.class);
	
	/**
	 * ����
	 * 
	 * @param jp JoinPoint���ӵ���Ϣ
	 * @param str �������
	 * @param obj ����Ŀ��
	 * @param proxy ������
	 */
	public void beforeAspect(JoinPoint jp, String str, Object obj, Object proxy){
		log.info(jp);
		log.info(str);
		log.info(obj);
		log.info(proxy);
	}
	
}
