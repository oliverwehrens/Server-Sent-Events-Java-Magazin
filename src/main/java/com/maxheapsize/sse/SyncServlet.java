package com.maxheapsize.sse;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/sync", loadOnStartup = 1, asyncSupported = false)
public class SyncServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    response.setContentType("text/event-stream; charset=utf-8");
    response.getWriter().
        append("retry: 5000\n").
        append("event: syncevent\n").
        append("data: I'm a event.\n\n");
  }
}
