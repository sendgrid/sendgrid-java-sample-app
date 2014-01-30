package com.sendgrid;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

public class SendGridJavaSampleApplicationSendServlet extends HttpServlet {
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    response.sendRedirect(request.getContextPath() + "/");
  }

  public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
    resp.setContentType("text/html");
    try {
      // initialize Sendgrid class
      // please replace "<sendgrid_username>" and "<sendgrid_password>" with your SendGrid credentials
      SendGrid mail = new SendGrid("<sendgrid_username>","<sendgrid_password>");
      // set to address, from address, subject, the html/text content and send the email 
      String response = mail.addTo(req.getParameter("emailto"))
        // update the <from_address> with your email address
        .setFrom("<email_from>")
        .setSubject(req.getParameter("subject"))
        .setText(req.getParameter("content"))
        .setHtml("")
        .send();
      
      JSONObject jsonResponse = new JSONObject(response);

      // check the response and display proper message
      if (jsonResponse.getString("message").equals("success")) {
        req.setAttribute("message", "Your request was successfully processed.");
        req.setAttribute("myclass", "success");
      } else {
        req.setAttribute("message", "Request failed  - " + jsonResponse.getString("message"));
        req.setAttribute("myclass", "error");
      }
      req.getRequestDispatcher("success.jsp").forward(req, resp);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}