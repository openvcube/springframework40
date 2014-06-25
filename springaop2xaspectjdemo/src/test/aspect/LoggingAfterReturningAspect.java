package test.aspect;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;

/**
 * 
 * @author worldheart
 *
 */
@Aspect
public class LoggingAfterReturningAspect {
	
	private static final Log log = LogFactory.getLog(LoggingAfterReturningAspect.class);
	
	//���õ�LoggingBeforeAspect�����pointcut
	@AfterReturning(pointcut="LoggingBeforeAspect.service() && LoggingBeforeAspect.with()" +
			" && args(str) && target(obj) && this(proxy) ",returning="retur")
	public void afterReturningAspect(JoinPoint jp, String str, Object obj, Object proxy, Object retur){
		log.info(jp);
		log.info(str);
		log.info(obj);
		log.info(proxy);
		log.info(retur);
	}
	
}
