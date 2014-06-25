package test.aspect;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;

/**
 * 
 * @author worldheart
 *
 */
@Aspect
public class LoggingAfterThrowingAspect {
	
	private static final Log log = LogFactory.getLog(LoggingAfterThrowingAspect.class);
	
	//���õ�LoggingBeforeAspect�����pointcut
	@AfterThrowing(pointcut="LoggingBeforeAspect.service() && LoggingBeforeAspect.with()" +
			" && args(str) && target(obj) && this(proxy) ",throwing="thro")
	public void afterThrowingAspect(JoinPoint jp, String str, Object obj, Object proxy, RuntimeException thro){
		log.info("afterThrowingAspect....................");
		log.info(jp);
		log.info(str);
		log.info(obj);
		log.info(proxy);
		log.info(thro);
	}
	
	//���õ�LoggingBeforeAspect�����pointcut
	@After("LoggingBeforeAspect.service() && LoggingBeforeAspect.with()" +
			" && args(str) && target(obj) && this(proxy) ")
	public void afterAspect(JoinPoint jp, String str, Object obj, Object proxy){
		log.info("afterAspect....................");
		log.info(jp);
		log.info(str);
		log.info(obj);
		log.info(proxy);
	}
	
}
