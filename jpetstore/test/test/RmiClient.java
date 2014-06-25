package test;

import java.rmi.RemoteException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 
 * @author worldheart
 * 
 */
public class RmiClient {
	protected static final Log log = LogFactory.getLog(RmiClient.class);

	public static void main(String[] args) {
		try {
			Context ic = new InitialContext();
			//ͨ��JNDI API���ҵ�RMIԶ�̶���
			IUserInfo ui = (IUserInfo) ic.lookup("rmi://localhost:1099/userinfo");
			ic.close();
			//����ҵ�񷽷�
			log.info(ui.getUserInfo());
		} catch (NamingException ne) {
			log.error("", ne);
		} catch(RemoteException re){
			log.error("", re);
		}
	}
}
