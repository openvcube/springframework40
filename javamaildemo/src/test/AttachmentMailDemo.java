package test;

import javax.mail.internet.MimeMessage;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;

/**
 * 
 * @author worldheart
 *
 */
public class AttachmentMailDemo {

	protected static final Log log = LogFactory
			.getLog(AttachmentMailDemo.class);

	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext(
				"attachmentmail.xml");

		JavaMailSender ms = (JavaMailSender) ac.getBean("mailSender");
		
		//ʹ��MimeMessagePreparator�ص��ӿ�
		ms.send(new MimeMessagePreparator() {
			public void prepare(MimeMessage mimeMessage) throws Exception {
				//��װMimeMessage���Լ򻯶�MimeMessage�Ĳ���
				MimeMessageHelper mmh = new MimeMessageHelper(mimeMessage, true);

				//�����ʼ�Ԫ������Ϣ
				mmh.setTo("javaee@open-v.com");
				mmh.setFrom("test@open-v.com","openv�����û�");
				mmh.setSubject("��ӭʹ��Spring JavaMailSenderImpl���͸���");
				mmh.setText("лл������ո������ݣ�");

				//��Ӹ���
				mmh.addAttachment("logo.gif",
						new ClassPathResource("/logo.gif"));
				mmh.addAttachment("mail.properties",
						new ClassPathResource("/mail.properties"));
			}
		});

	}

}
