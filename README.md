SendGrid Sample App - Java
======================

This git repository helps you to send emails quickly and easily through SendGrid using Java.

Create an SendGrid account at http://sendgrid.com/pricing.html

Clone SendGrid application on your local machine
<pre>
    git clone https://github.com/sendgrid/sendgrid-java-sample-app
</pre>

###Configuration###

Configure `src/com/sendgrid/SendGridJavaSampleApplicationSendServlet.java` file with your information:

Update the *&lt;sendgrid_username&gt;* and *&lt;sendgrid_password&gt;* with your SendGrid Credentials and *&lt;from_email&gt;* with your email address.
```java
	// initialize Sendgrid class
	// please replace "<sendgrid_username>" and "<sendgrid_password>" with your SendGrid credentials
	SendGrid mail = new SendGrid("<sendgrid_username>","<sendgrid_password>");
	// set to address, from address, subject, the html/text content and send the email 
	String response = mail.addTo(req.getParameter("emailto"))
	  // update the <from_email> with your email address
	  .setFrom("<from_email>")
	  .setSubject(req.getParameter("subject"))
	  .setText(req.getParameter("content"))
	  .setHtml("")
	  .send();
```

Build your application and deploy to your webserver.

For more information visit our [Java Library](https://github.com/sendgrid/sendgrid-java)


