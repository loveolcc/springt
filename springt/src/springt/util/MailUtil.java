package springt.util;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailUtil {

	public static void sendMail(String to,String code) throws AddressException, MessagingException{
		//��������
		Properties props=new Properties();
		 props.setProperty("mail.debug", "true");  
	        // ���ͷ�������Ҫ�����֤  
	        props.setProperty("mail.smtp.auth", "true");  
	        // �����ʼ�������������  
	        props.setProperty("mail.host", "smtp.163.com");  
	        // �����ʼ�Э������  
	        props.setProperty("mail.transport.protocol", "smtp");  
		Session session=Session.getInstance(props, new Authenticator() {

			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				// TODO Auto-generated method stub
				return new PasswordAuthentication("loveolcc@163.com", "wshxj961012");
			}
		
		});
		//�����ʼ�����
		Message message=new MimeMessage(session);
		//���÷�����
		message.setFrom(new InternetAddress("loveolcc@163.com"));
		//����������
		message.setRecipient(RecipientType.TO, new InternetAddress(to));
		//��������
		message.setSubject("�����˺�");
		//������������
		message.setContent("<h1>�˺ż���</h1><h3>�����������Ӽ���</h3><p><a href='http://localhost:8080/springt/active/"+code+"'>http://localhost:8080/springt/active/"+code+"</a></p>", "text/html;charset=UTF-8");
		//�����ʼ�
		Transport.send(message);
	}
}
