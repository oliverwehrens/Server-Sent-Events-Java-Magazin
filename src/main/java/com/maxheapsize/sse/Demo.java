package com.maxheapsize.sse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.util.Random;

@Controller
public class Demo {

  private final String contentType = "text/event-stream; charset=utf-8";
  private Random random = new Random();

  @RequestMapping("index")
  public ModelAndView start() {
    return new ModelAndView("index");
  }

  @RequestMapping("update")
  @ResponseBody
  public String update(HttpServletResponse response) {
    response.setContentType(contentType);
    String result = getTimeAndCloseData();
    System.out.println("Sending " + result);
    return result;
  }

  private String getTimeAndCloseData() {
    return "data: " + System.currentTimeMillis() + "\n\n";
  }

  @RequestMapping("events")
  @ResponseBody
  public String events(HttpServletResponse response) {
    response.setContentType(contentType);
    StringBuffer result = new StringBuffer();
    if (random.nextBoolean()) {
      result.append("event: create\n");
    }
    else {
      result.append("event: update\n");
    }
    result.append("retry: 10000\n");
    result.append(getTimeAndCloseData());
    System.out.println(result.toString());
    return result.toString();
  }
}
