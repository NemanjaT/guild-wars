package com.nemanjat94.web;

import com.nemanjat94.util.Logger;
import com.nemanjat94.web.config.RootConfig;
import com.nemanjat94.web.config.WebConfig;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * Created by neman on 27-Dec-16.
 *
 * Web application initializer.
 */
public class WebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
  private static final Logger log = Logger.getLogger(WebInitializer.class);

  @Override
  protected Class<?>[] getRootConfigClasses() {
    log.debug("Loading root configurations.");
    return new Class<?>[]{RootConfig.class};
  }

  @Override
  protected Class<?>[] getServletConfigClasses() {
    log.debug("Loading servlet configurations.");
    return new Class<?>[]{WebConfig.class};
  }

  @Override
  protected String[] getServletMappings() {
    log.debug("Loading servlet mappings.");
    return new String[]{"/"};
  }

}
