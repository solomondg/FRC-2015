package com.team254.lib.web.handlers;

import java.io.IOException;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.handler.AbstractHandler;

import com.google.gson.Gson;
import com.team254.lib.util.SystemManager;

public class GetAllStatesHandler extends AbstractHandler {

  public void handle(String target, Request baseRequest, HttpServletRequest request, HttpServletResponse response)
      throws IOException, ServletException {

    Gson gson = new Gson();
    response.setContentType("application/json;charset=utf-8");
    response.setStatus(HttpServletResponse.SC_OK);
    baseRequest.setHandled(true);

    HashMap<String, String> states = SystemManager.get();
    String res = gson.toJson(states);
    response.getWriter().println(res);
  }

}
