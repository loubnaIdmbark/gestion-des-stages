

import java.io.IOException;
import java.util.Properties;

import javax.mail.*;
import javax.mail.internet.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/MailServlet")
public class MailServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String recipient = request.getParameter("recipient");
        String subject = request.getParameter("subject");
        String messageText = request.getParameter("message");
        

        
        final String username = "hamzakerboub096@outlook.com"; 
        final String password = "hamza2002"; 

        
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.office365.com"); 
        props.put("mail.smtp.port", "587"); 

        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            Message emailMessage = new MimeMessage(session);
            emailMessage.setFrom(new InternetAddress(username));
            emailMessage.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipient));
            emailMessage.setSubject(subject);
            emailMessage.setText(messageText);

            Transport.send(emailMessage);

            response.setContentType("text/html");
            System.out.println("Sent message successfully....");
            response.sendRedirect("Email.jsp");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}

 
