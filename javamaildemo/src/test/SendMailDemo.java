package test;

import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * ֱ�ӽ���JavaMail API�����ʼ�
 * 
 * @author worldheart
 * 
 */
public class SendMailDemo {

	protected static final Log log = LogFactory.getLog(SendMailDemo.class);

	public static void main(String[] args) {
		String host = "mail.open-v.com";
		String toAdd = "javaee@open-v.com";
		String fromAdd = "test@open-v.com";

		SendMailDemo smd = new SendMailDemo();
		// �����������ʼ�
		smd.sendMail(host, toAdd, fromAdd);
	}

	public void sendMail(String host, String toAdd, String fromAdd) {
		// �ṩ����Sessionʱ��Ҫʹ�õ�����
		Properties props = new Properties();
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.auth", "true");// ��Щ�ʼ�������Ҫ�������֤

		Session session = Session.getInstance(props, null);
		session.setDebug(true);

		Transport tran = null;
		try {
			// ������Ϣ
			MimeMessage msg = new MimeMessage(session);
			// �ṩ������
			msg.setFrom(new InternetAddress(fromAdd));
			// �ṩ�ռ��˼���
			InternetAddress[] address = { new InternetAddress(toAdd) };
			msg.setRecipients(Message.RecipientType.TO, address);
			// ��������
			msg.setSubject("��ӭʹ��JavaMail API");
			// ���÷�������
			msg.setSentDate(new Date());
			// �����ʼ�����
			MimeBodyPart mbp = new MimeBodyPart();
			mbp.setText("лл���ĵ���!");
			Multipart mp = new MimeMultipart();
			mp.addBodyPart(mbp);
			// ��ӵ���Ϣ��
			msg.setContent(mp);
			// ���Transport�����������ʼ��������Ĵ���ͨ��
			tran = session.getTransport("smtp");
			tran.connect(host, "test@open-v.com", "mamama");
			// �����ʼ�
			tran.sendMessage(msg, msg.getAllRecipients());
		} catch (MessagingException mex) {
			log.error("", mex);
		} finally {
			if (tran != null)
				try {
					tran.close();
				} catch (MessagingException me) {
					;
				}
		}
	}
	
}
