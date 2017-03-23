package org.lvzr.fast.java.patten.create.factoryMethod.mutiltion;

import org.lvzr.fast.java.patten.create.factoryMethod.MailSender;
import org.lvzr.fast.java.patten.create.factoryMethod.Sender;
import org.lvzr.fast.java.patten.create.factoryMethod.SmsSender;

public class SendFactory {

	public Sender produceMail() {
		return new MailSender();
	}

	public Sender produceSms() {
		return new SmsSender();
	}
}
