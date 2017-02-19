package com.op;

import com.op.bean.entity.email.Email;
import com.op.service.MailSendService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.mail.MessagingException;
import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Created by xuning on 17-2-17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class TestMailSend {
	@Autowired
	private MailSendService mailSendService;
	private Email email = new Email();
	private String mailSender = "postmaster@networklab.cn";
	private String eefungAccepter = "xuning@eefung.com";
	private String qqAccepter = "1748373312@qq.com";
	private String phoneAccepter = "18753377393@163.com";
	private String otherAccepter = "1250496032@qq.com";
	private String title = "这是一封测试邮件" + new Random().toString();
	private String content = "如果收到，无需回复，打扰了。。。";
	/**
	 * 简单邮件
	 *
	 * @throws MessagingException
	 */
	@Test
	public void testSimpleMailSend() throws MessagingException {
		List<String> accepts = Arrays.asList(new String[]{eefungAccepter, qqAccepter});
		email.setAccepter(accepts);
//		email.setSender(mailSender);
		email.setTitle(title);
		email.setContent(content);
		Boolean res = mailSendService.sendSimpleEmail(email);
		Assert.assertTrue(res);
	}

	/**
	 * 抄送邮件
	 *
	 * @throws MessagingException
	 */
	@Test
	public void testRecipientersMailSend() throws MessagingException {
		email.setSender(mailSender);
		email.setTitle(title);
		email.setContent(content);
		List<String> recipientersList = Arrays.asList(new String[]{qqAccepter});
		email.setRecipienters(recipientersList);
		Boolean res = mailSendService.sendRecipientsEmail(email);
		Assert.assertTrue(res);
	}

	/**
	 * 密送邮件
	 *
	 * @throws MessagingException
	 */
	@Test
	public void testBccMailSend() throws MessagingException {
		email.setSender(mailSender);
		email.setTitle(title);
		email.setContent(content);
		List<String> bbcAccepterlist = Arrays.asList(new String[]{qqAccepter});
		email.setBccAccepter(bbcAccepterlist);
		Boolean res = mailSendService.sendBccEmail(email);
		Assert.assertTrue(res);
	}

	/**
	 * 带有附件的邮件
	 *
	 * @throws MessagingException
	 */
	@Test
	public void testAttachmentMailSens() throws MessagingException {
		List<String> accepts = Arrays.asList(new String[]{qqAccepter});
		email.setAccepter(accepts);
		email.setSender(mailSender);
		email.setTitle(title);
		email.setContent(content);
		List<File> files = Arrays.asList(new File[]{
				new File("C:/Users/me/Desktop/test.txt"),
				new File("C:/Users/me/Desktop/test1.txt"),
				new File("C:/Users/me/Desktop/test.docx")
		});
		email.setAttachment(files);
		Boolean res = mailSendService.sendAttachmentsEmail(email);
		Assert.assertTrue(res);
	}


	/**
	 * 全功能邮件
	 *
	 * @throws MessagingException
	 */
	@Test
	public void testCommonMailSend() throws MessagingException {
		List<String> accepts = Arrays.asList(new String[]{eefungAccepter, qqAccepter});
		email.setAccepter(accepts);
		email.setSender(mailSender);
		email.setTitle(title);
		email.setContent(content);
		List<String> recipientersList = Arrays.asList(new String[]{otherAccepter});
		List<String> bccAccepts = Arrays.asList(new String[]{phoneAccepter});
		email.setBccAccepter(bccAccepts);
		email.setRecipienters(recipientersList);
		List<File> files = Arrays.asList(new File[]{
				new File("C:/Users/me/Desktop/test.txt"),
				new File("C:/Users/me/Desktop/test1.txt"),
				new File("C:/Users/me/Desktop/test.docx")
		});
		email.setAttachment(files);
		Boolean res = mailSendService.sendCommonEmail(email);
		Assert.assertTrue(res);
	}
}