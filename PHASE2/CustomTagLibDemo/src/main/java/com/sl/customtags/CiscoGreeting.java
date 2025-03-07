package com.sl.customtags;

import java.io.IOException;

import jakarta.servlet.jsp.JspException;
import jakarta.servlet.jsp.JspWriter;
import jakarta.servlet.jsp.tagext.TagSupport;

public class CiscoGreeting extends TagSupport {	
	private static final long serialVersionUID = 1L;
	
	private String name;

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int doStartTag() throws JspException {
		try {
			JspWriter out = pageContext.getOut();

			if (name != null && !name.isEmpty()) {
				out.println("<br>Welcome " + name + " to Cisco!");
			}
			else {
				out.println("Welcome " + "Guest" );
			}

		} catch (IOException e) {

			e.printStackTrace();
		}

		return SKIP_BODY; // No body content processing
	}

}
