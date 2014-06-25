package test;

import org.aopalliance.aop.Advice;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.RegexpMethodPointcutAdvisor;

/**
 * 
 * @author worldheart
 *
 */
public class HelloClient {
	
    private static final Log log = LogFactory.getLog(HelloClient.class);

    public static void main(String[] args) {    	
        //����ProxyFactory���Ӷ�����Ҫ����Spring IoC�����ṩ���Ʒ�ת����
        ProxyFactory factory = new ProxyFactory(new HelloWorld());
    	    	
        //����LoggingAroundAdviceװ��
        Advice advice = new LoggingAroundAdvice();        
        
        //����Advisor����
        RegexpMethodPointcutAdvisor advisor = new RegexpMethodPointcutAdvisor();
        advisor.setAdvice(advice);
        advisor.setPatterns(new String[]{".*"});
        
        factory.addAdvisor(advisor);

        //����ҵ�����
        IHelloWorld hw = (IHelloWorld) factory.getProxy();
        log.info(hw.getContent("worldheart"));        
    }

}
