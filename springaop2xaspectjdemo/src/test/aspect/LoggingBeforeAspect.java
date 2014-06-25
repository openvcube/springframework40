package test.aspect;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * 
 * @author worldheart
 *
 */
@Aspect
public class LoggingBeforeAspect {
	
	private static final Log log = LogFactory.getLog(LoggingBeforeAspect.class);
	
	//�����ӵ����÷�ΧȦ����service����
	@Pointcut("within(*test.service.*)")
	public void with(){}

	//���ӵ��Ӧ�ķ����ķ���ֵ������void��java.lang.String
	@Pointcut("execution(public void || String test.service..*(..))")
	public void service(){}
	
	//����������
	@Before("service() && with() && args(str) && target(obj) && this(proxy) ")
	public void beforeAspect(JoinPoint jp, String str, Object obj, Object proxy){
		log.info(jp);
		log.info(str);
		log.info(obj);
		log.info(proxy);
	}
	
}
