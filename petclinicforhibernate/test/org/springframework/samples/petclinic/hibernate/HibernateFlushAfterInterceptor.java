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
 * Description: ��֤���˳�Ŀ����Է������ܹ���Hibernate Session�е�HQLͬ����RDBMS
 *    ������Է�����ִ����Ŀ����Է�����ʹ�õ�JDBC������һ�������ز����١�
 * 
 */
public class HibernateFlushAfterInterceptor implements MethodInterceptor {

    protected static final Log log = LogFactory.getLog(HibernateFlushAfterInterceptor.class);

    // ע��Hibernate 3.x SessionFactory
    private SessionFactory sessionFactory;

    public Object invoke(MethodInvocation invocation) throws Throwable {
        log.info("Entering HibernateFlushAfterInterceptor()...." + invocation.getClass());
        //����������
        Object object = invocation.proceed();
        //ȷ��flush()������ҵ�񷽷������ú󴥷�
        Session session = SessionFactoryUtils.getSession(this.sessionFactory, false);
        if (session != null) {
            log.info("Running session.flush()");
            session.flush();
        }
        log.info("Exiting HibernateFlushAfterInterceptor()...." + invocation.getClass());
        return object;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

}
