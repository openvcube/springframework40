package org.springframework.samples.petclinic.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.Ordered;
import org.springframework.orm.jpa.SharedEntityManagerCreator;

/**
 * 
 * @author worldheart
 *
 */
@Aspect
public class JpaBeforeFlushAspectJ implements Ordered{
	
	protected static final Log log = LogFactory.getLog(JpaBeforeFlushAspectJ.class);
	
	private EntityManager em = null;
	
	private int order;
	
	public void setEmf(EntityManagerFactory emf) {
		//��õ�ǰ����������EntityManager
		this.em = SharedEntityManagerCreator.createSharedEntityManager(emf);
	}
	
	@Around("execution(* org.springframework.samples.petclinic.jpa..*(..))")
	public Object flushEm(ProceedingJoinPoint pjp) throws Throwable{
        log.info("Entering JpaBeforeFlushAspectJ()...." + pjp.getClass());
        //ȷ��flush()������ҵ�񷽷�������ǰ����
        if (em != null) {
            log.info("Running em.flush()");
            em.flush();
        }
        //����������
		Object obj = pjp.proceed();		
        log.info("Exiting JpaBeforeFlushAspectJ()...." + pjp.getClass());
        return obj;        
	}
	
	public int getOrder() {
		return order;
	}
	
	public void setOrder(int order) {
		this.order = order;
	}
	
}
