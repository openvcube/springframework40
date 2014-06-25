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
public class InlineMailDemo {

	protected static final Log log = LogFactory
			.getLog(InlineMailDemo.class);

	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext(
				"inlinemail.xml");

		JavaMailSender ms = (JavaMailSender) ac.getBean("mailSender");
		
		//ʹ��MimeMessagePreparator�ص��ӿ�
		ms.send(new MimeMessagePreparator() {
			public void prepare(MimeMessage mimeMessage) throws Exception {
				//��װMimeMessage���Լ򻯶�MimeMessage�Ĳ���
				MimeMessageHelper mmh = new MimeMessageHelper(mimeMessage, true);

				//�����ʼ�Ԫ������Ϣ
				mmh.setTo("javaee@open-v.com");
				mmh.setFrom("test@open-v.com","openv�����û�");
				mmh.setSubject("��ӭʹ��Spring JavaMailSenderImpl���ͺ���HTML����Ƕ��Դ���ʼ�");
				
				//���HTML����Ƕ��Դ
				mmh.setText("��ӭ�������<a href='http://www.open-v.com'><img src='cid:logo' /></a>", true);
			    mmh.addInline("logo", new ClassPathResource("/logo.gif"));
			}
		});

	}

}
