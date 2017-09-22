package com.svnsummit.mailtool.viewtool;

import com.dotmarketing.util.Logger;
import com.dotmarketing.util.Mailer;
import org.apache.velocity.tools.view.tools.ViewTool;

/**
 * Created by Michael J. Gulley (mikejgulley) on 9/22/2017.
 */
public class MailViewTool implements ViewTool {

    @Override
    public void init(Object initData) {
    }

    public boolean sendEmail(String fromEmail, String toEmail, String subject, String body) {

        Mailer mailer = createEmail(fromEmail, toEmail, subject, body);

        if(!mailer.sendMessage()) {
            Logger.error(this,"Email failed to send to: " + toEmail);
            return false;
        } else {
            return true;
        }
    }

    private Mailer createEmail(String fromEmail, String toEmail, String subject, String body) {

        Mailer mailer = new Mailer();

        mailer.setFromEmail(fromEmail);
        mailer.setSubject(subject);
        mailer.setToEmail(toEmail);
        mailer.setHTMLAndTextBody(body);

        return mailer;
    }

}
