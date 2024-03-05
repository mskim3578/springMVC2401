package sendmail;

import java.util.Properties;

public class MailSend {

public void MailSend() {
Properties prop = System.getProperties();
prop.put("mail.smtp.starttls.enable", "true");
prop.put("mail.smtp.host", "smtp.gmail.com");
prop.put("mail.smtp.auth", "true");
prop.put("mail.smtp.port", "587");

Authenticator auth = new MailAuth();

Session session = Session.getDefaultInstance(prop, auth);

MimeMessage msg = new MimeMessage(session);

try {
msg.setSentDate(new Date());

msg.setFrom(new InternetAddress("shxorld@gmail.com", "VISITOR"));
InternetAddress to = new InternetAddress("szhyun2002@gmail.com");
msg.setRecipient(Message.RecipientType.TO, to);
msg.setSubject("제목", "UTF-8");
msg.setText("안녕하세요 테스트 메일입니다.", "UTF-8");

Transport.send(msg);

} catch(AddressException ae) {
System.out.println("AddressException : " + ae.getMessage());
} catch(MessagingException me) {
System.out.println("MessagingException : " + me.getMessage());
} catch(UnsupportedEncodingException e) {
System.out.println("UnsupportedEncodingException : " + e.getMessage());
}

}
}