package test.aspect;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import test.pointcut.AnnotationParam;

/**
 * 
 * @author worldheart
 *
 */
@Aspect
public class LoggingAspect {
	
	private static final Log log = LogFactory.getLog(LoggingAspect.class);
	
	//within�����ӵ����÷�ΧȦ����test.pointcut����
	@Pointcut("within(test.pointcut.*)")
	public void with(){}

	//���ӵ��Ӧ�ķ����ķ���ֵ������void��java.lang.String
	@Pointcut("execution(public void || String test.pointcut..*(..))")
	public void service1(){}
	
	//���ӵ��Ӧ�ķ����ķ���ֵ������java.lang.String
	@Pointcut("execution(public String test.pointcut..*(..) throws RuntimeException)")
	public void service2(){}
	
	//service1()����������
	@Before("service1() && with() && args(str) && target(obj) && this(proxy) ")
	public void before1Aspect(JoinPoint jp, String str, Object obj, Object proxy){
		log.info("before1Aspect......");
		log.info(jp);
		log.info(str);
		log.info(obj);
		log.info(proxy);
	}
	
	//service2()����������
	@Before("service2() && with() && target(obj) && this(proxy) ")
	public void before2Aspect(JoinPoint jp, Object obj, Object proxy){
		log.info("before2Aspect......");
		log.info(jp);
		log.info(obj);
		log.info(proxy);
	}
	
	//@args�������������ӵ�Ĳ�����Ӧ�������Ӧ����@ForYouע�⣨��һ����
	@Before("service1() && with()  && args(ap) && target(obj) && this(proxy) && @args(test.pointcut.ForYou)")
	public void before3Aspect(JoinPoint jp, AnnotationParam ap, Object obj, Object proxy){
		log.info("before3Aspect......");
		log.info(jp);
		log.info(obj);
		log.info(proxy);
	}
	
	//@within������ֻ����Щ����һ��Ӧ����@ForYouע������еĸ��������ܹ���Ϊ���ӵ��ѡ
	@Before("service1() && with() && @within(test.pointcut.ForYou) && target(obj) && this(proxy)")
	public void before4Aspect(JoinPoint jp, Object obj, Object proxy){
		log.info("before4Aspect......");
		log.info(jp);
		log.info(obj);
		log.info(proxy);
	}
	
	//@annotation����������������е����ӵ㣨��Ŀ�귽����
	//����Ӧ����@ForYouע�⣨����һ����
	@Before("service1() && with() && @annotation(test.pointcut.ForYou) && target(obj) && this(proxy)")
	public void before5Aspect(JoinPoint jp, Object obj, Object proxy){
		log.info("before5Aspect......");
		log.info(jp);
		log.info(obj);
		log.info(proxy);
	}
	
	//@target����������������������һ��Ӧ����@ForYouע��
	@Before("service1() && with() && @target(test.pointcut.ForYou) && target(obj) && this(proxy)")
	public void before6Aspect(JoinPoint jp, Object obj, Object proxy){
		log.info("before6Aspect......");
		log.info(jp);
		log.info(obj);
		log.info(proxy);
	}
	
	//PointInfo+������������PointInfo��β���༰����
	@Before("within(test.pointcut.*) && execution(* test..*PointInfo+.*(..) throws RuntimeException)")
	public void before7Aspect(JoinPoint jp){
		log.info("before7Aspect......");
		log.info(jp);
	}
		
	//service2()���������㣬�����޶��ܹ�Bean������
	@Before("bean(classForPointInfo*) && service2()")
	public void before8Aspect(JoinPoint jp){
		log.info("before8Aspect......");
		log.info(jp);
	}

}