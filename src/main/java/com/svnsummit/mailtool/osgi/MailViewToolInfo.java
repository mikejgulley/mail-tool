package com.svnsummit.mailtool.osgi;

import com.svnsummit.mailtool.viewtool.MailViewTool;
import org.apache.velocity.tools.view.context.ViewContext;
import org.apache.velocity.tools.view.servlet.ServletToolInfo;

/**
 * Created by Michael J. Gulley (mikejgulley) on 9/22/2017.
 */
public class MailViewToolInfo extends ServletToolInfo {

    @Override
    public String getKey () {
        return "mailtool";
    }

    @Override
    public String getScope () {
        return ViewContext.APPLICATION;
    }

    @Override
    public String getClassname () {
        return MailViewTool.class.getName();
    }

    @Override
    public Object getInstance ( Object initData ) {

        MailViewTool viewTool = new MailViewTool();
        viewTool.init( initData );

        setScope( ViewContext.APPLICATION );

        return viewTool;
    }

}
