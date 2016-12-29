package com.nemanjat94.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by neman on 27-Dec-16.
 * <p>
 * Home controller.
 */
@Controller
public class HomeController {
  private static final String HOME_PAGE_NAME = "index";
  private static final String HOME_REQ_MAPPING = "/";

  @RequestMapping(value = {HOME_REQ_MAPPING})
  public String showHomePage(Model model) {
    model.addAttribute("test", "Hello World!");
    return HOME_PAGE_NAME;
  }

}
