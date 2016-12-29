package com.nemanjat94.web.controller;

import com.nemanjat94.util.Logger;
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

  private static final Logger log = Logger.getLogger(HomeController.class);

  @RequestMapping(value = {HOME_REQ_MAPPING})
  public String showHomePage(Model model) {
    log.debug("Hit controller HomeController::showHomePage");

    model.addAttribute("test", "Hello World!");

    return HOME_PAGE_NAME;
  }

}
