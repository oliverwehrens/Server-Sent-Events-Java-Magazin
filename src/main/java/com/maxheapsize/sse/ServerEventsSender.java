package com.maxheapsize.sse;

import javax.servlet.AsyncContext;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

public class ServerEventsSender implements Runnable {

  private ServletResponse servletResponse;

  public ServerEventsSender(ServletResponse servletResponse) {
    this.servletResponse = servletResponse;
  }

  @Override public void run() {
    sendEvent(servletResponse);
  }

  private void sendEvent(ServletResponse response) {
    try {
      Date date = new Date();
      response.setContentType("text/event-stream; charset=utf-8");
      response.getWriter().
          append("retry: 5000\n").
          append("event: hey\n").
          append("data: START\n\n");

      response.flushBuffer();
      response.getWriter().
          append("retry: 5000\n").
          append("event: hey\n").
          append("data: Hey I was created at " + date.toString() + "(" + System.currentTimeMillis() + ")\n\n");
      response.flushBuffer();
      response.getWriter().
          append("retry: 5000\n").
          append("event: hey\n").
          append("data: END\n\n");

      // important, flush the response
      response.flushBuffer();
    }
    catch (IOException e) {
      e.printStackTrace();
    }
  }
}
