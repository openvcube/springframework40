package test;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Order;
import org.springframework.samples.Owners;
import org.springframework.samples.Pets;
import org.springframework.samples.Specialties;
import org.springframework.samples.Types;
import org.springframework.samples.Vets;
import org.springframework.samples.Visits;

/**
 * 
 * @author worldheart
 * 
 */
public class MainTestForHibernateDemo {

	private SessionFactory sf;

	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}

	protected static final Log log = LogFactory
			.getLog(MainTestForHibernateDemo.class);

	public static void main(String[] args) {

		//�ṩ.hbm/.class��Ϣ
		Configuration cfg = new Configuration().addClass(Owners.class)
				.addClass(Pets.class).addClass(Types.class)
				.addClass(Vets.class).addClass(Specialties.class)
				.addClass(Visits.class);

		MainTestForHibernateDemo mthd = new MainTestForHibernateDemo();
		//ʹ��classpath��·����hibernate.cfg.xml�����������������Ĭ�ϻ�ʹ��hibernate.properties
		cfg.configure();
		//�����̰߳�ȫ��SessionFactory
		mthd.setSf(cfg.buildSessionFactory());

		mthd.testVisitsVersionHQL();
		mthd.testVisitsVersionCriteriaAPI();
		mthd.testVisitsVersionNativeSQL();

		mthd.sf.close();

	}

	public void testVisitsVersionHQL() {
		//����̲߳���ȫ��Hibernate Session
		Session session = this.sf.openSession();
		Transaction tran = null;
		try {
			//�ֹ���������
			tran = session.beginTransaction();
			//������HQL��ѯ����
			List list = session.createQuery("from Visits vi").setFirstResult(1).setMaxResults(3).list();
			//ֱ�ӷ�����Visits���ɵļ���
			for (Object visits : list) {
				Visits visit = (Visits) visits;
				log.info("id:" + visit.getId() + ",visitDate:" + visit.getVisitDate() +
						",description:" + visit.getDescription() + ",pets:" + visit.getPets() );
			}
			tran.commit();
		} catch (Exception exe) {
			if (tran != null)
				tran.rollback();
			log.error("", exe);
		} finally {
			session.close();
		}
	}
	
	public void testVisitsVersionCriteriaAPI() {
		//����̲߳���ȫ��Hibernate Session
		Session session = this.sf.openSession();
		Transaction tran = null;
		try {
			//�ֹ���������
			tran = session.beginTransaction();
			//������Criteria API��ѯ����
			List list = session.createCriteria(Visits.class).setFirstResult(1).setMaxResults(3).addOrder(Order.asc("visitDate")).list();
			//ֱ�ӷ�����Visits���ɵļ���
			for (Object visits : list) {
				Visits visit = (Visits) visits;
				log.info("id:" + visit.getId() + ",visitDate:" + visit.getVisitDate() +
						",description:" + visit.getDescription() + ",pets:" + visit.getPets() );
			}
			tran.commit();
		} catch (Exception exe) {
			if (tran != null)
				tran.rollback();
			log.error("", exe);
		} finally {
			session.close();
		}
	}
	
	public void testVisitsVersionNativeSQL() {
		//����̲߳���ȫ��Hibernate Session
		Session session = this.sf.openSession();
		Transaction tran = null;
		try {
			//�ֹ���������
			tran = session.beginTransaction();
			//������ԭ��SQL����ѯ����
			List list = session.createSQLQuery("select id,visit_date from Visits").setFirstResult(1).setMaxResults(3).list();
			//ֱ�ӷ��������鹹�ɵļ���
			for (Object visits : list){
				Object[] vi = (Object[])visits;
				log.info("id:"+vi[0] + ",visit_date:" + vi[1]);
			}				
			//��ɲ�ѯ�����Hibernateʵ���ӳ��
			list = session.createSQLQuery("select * from Visits").addEntity(Visits.class).setFirstResult(1).setMaxResults(3).list();
			//	ֱ�ӷ�����Visits���ɵļ���
			for (Object visits : list){
				Visits visit = (Visits) visits;
				log.info("id:" + visit.getId() + ",visitDate:" + visit.getVisitDate());
			}							
			tran.commit();
		} catch (Exception exe) {
			if (tran != null)
				tran.rollback();
			log.error("", exe);
		} finally {
			session.close();
		}
	}

}
