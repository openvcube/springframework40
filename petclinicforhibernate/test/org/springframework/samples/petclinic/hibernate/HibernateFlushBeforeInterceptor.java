package org.springframework.samples.petclinic.hibernate;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.SessionFactoryUtils;

/**
 * 
 * Title:�������ɲ��ԣ�Spring AOP��������
 * Description: ��֤�ڽ���Ŀ����Է���ǰ���ܹ���Hibernate Session�е�HQLͬ����RDBMS��
 *    ���Ŀ����Է�����ʹ�õ�JDBC������һ�������ز�����
 * 
 */
public class HibernateFlushBeforeInterceptor implements MethodInterceptor {

    protected static final Log log = LogFactory.getLog(HibernateFlushBeforeInterceptor.class);

    // ע��Hibernate 3.x SessionFactory
    private SessionFactory sessionFactory;

    public Object invoke(MethodInvocation invocation) throws Throwable {
        log.info("Entering HibernateFlushBeforeInterceptor()...." + invocation.getClass());
        //ȷ��flush()������ҵ�񷽷�������ǰ����
        Session session = SessionFactoryUtils.getSession(this.sessionFactory, false);
        if (session != null) {
            log.info("Running session.flush()");
            session.flush();
        }
        //����������
        Object object = invocation.proceed();
        log.info("Exiting HibernateFlushBeforeInterceptor()...." + invocation.getClass());
        return object;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

}
