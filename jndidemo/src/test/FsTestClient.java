/**
 * 
 */
package test;

import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * File Systemʾ��ʹ��
 * 
 * @author worldheart
 * 
 */
public class FsTestClient {

	protected static final Log log = LogFactory.getLog(FsTestClient.class);

	public static void main(String[] args) {
		
		Hashtable<String, String> env = new Hashtable<String, String>(2);
		
		//�趨�����Ĺ���
		env.put(Context.INITIAL_CONTEXT_FACTORY,
				"com.sun.jndi.fscontext.RefFSContextFactory");
		
		//�����ļ�ϵͳ·��(ע�⣬��������Ҫ��������Ļ����޸�"file:d://eclipse")
		env.put(Context.PROVIDER_URL, "file:d://eclipse");
		
		Context initCtx = null;
		try {
			//��ó�ʼ��������
			initCtx = new InitialContext(env);
			
			//������JNDI�������ļ�
			Object fc = initCtx.lookup("eclipse.ini");
						
			log.info(fc);
		} catch (NamingException ne) {
			//���������쳣
			log.error("", ne);
		} finally {
			try {
				//�ر�������
				initCtx.close();
			} catch (NamingException ne) {
				;
			}
		}

	}

}
