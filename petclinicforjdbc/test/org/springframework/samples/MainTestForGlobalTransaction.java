package org.springframework.samples;

import javax.naming.NamingException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 
 * @author worldheart
 *
 */
public class MainTestForGlobalTransaction {

	private static final Log log = LogFactory.getLog(MainTestForGlobalTransaction.class);
	
	public static void main(String[] args) {				

		UserTransaction ut = null;
		try{
			javax.naming.Context ctx = new javax.naming.InitialContext();
			ut = (UserTransaction) ctx.lookup("java:comp/UserTransaction");
			ut.begin();
			
			//��XA��Դ����CRUD����������XA-JMS��XA-Connection
			//.....
			
			ut.commit();
		} catch(NamingException ne){
			log.error("", ne);
		} catch(SystemException se){
			log.error("", se);
			//����ut.rollback()
		} catch(NotSupportedException nse){
			log.error("", nse);
			//����ut.rollback()
		} catch(RollbackException re){
			log.error("", re);
			//����ut.rollback()
		} catch(Exception exe){
			log.error("", exe);
			//�����쳣
		}
		
	}

}
