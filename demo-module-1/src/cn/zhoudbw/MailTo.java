package cn.zhoudbw;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * 这个类是为了实现，通过Java发送邮件的。
 */
public class MailTo {

    public static void main(String[] args) {

        try {
            // 1. 创建一个与自己邮箱的连接
            // Properties装载一些邮件的配置信息
            Properties pro = new Properties();
            Session session = Session.getInstance(pro);

            // 2. 创建一个邮件对象（让session连接的邮箱负责发送邮件）
            MimeMessage message = new MimeMessage(session);

            // 3. 根据邮件的组成 ——>
            // (1)发件人
            message.setFrom(new InternetAddress("973121322@qq.com"));
            // (2)收件人
            // - 收件人类别：TO收件人，CC抄送人，BCC密送
            // - 收件人账号：user1，user2...
            message.setRecipients(Message.RecipientType.TO, new InternetAddress[] {
                    new InternetAddress("508128291@qq.com")
            });
            // (3)设置邮件标题
            message.setSubject("威威哥哥和甜妹妹的缠绵");
            // (4)设置邮件内容
            String htmlText = "<font size =\"5\" face=\"arial\" >" +
                    "2500年前，人们飞鸽传书<br>" +
                    "185年前，莫尔斯发明了电报<br>" +
                    "52年前，第一封电子邮件发出<br>" +
                    "... </font>";
            message.setContent(htmlText, "text/plain;charset=utf-8");

            // 创建发送对象
            Transport transport = session.getTransport();
            // 设置连接信息
            transport.connect("smtp.qq.com", 25, "973121322", "shermdwpewsubcji");
            // 发送邮件
            transport.sendMessage(message, message.getAllRecipients());

            System.out.println("发送成功");
        } catch (MessagingException e) {
            e.printStackTrace();
        }

    }


}
