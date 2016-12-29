package com.nemanjat94.web.config;

import com.nemanjat94.util.Logger;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;
import org.thymeleaf.templatemode.TemplateMode;

/**
 * Created by neman on 27-Dec-16.
 * <p>
 * Main web configuration class.
 */
@Configuration
@EnableWebMvc
@ComponentScan("com.nemanjat94.web")
public class WebConfig extends WebMvcConfigurerAdapter implements ApplicationContextAware {
  private static final String EXTENSION = "html";
  private static final String VIEW_RESOLVER_SUFFIX = "." + EXTENSION;
  private static final String VIEW_RESOLVER_PREFIX = "/WEB-INF/views/" + EXTENSION + "/";
  private static final String CSS_RES_HANDLER = "/css/**/*.css";
  private static final String CSS_RES_LOCATION = "/WEB-INF/lib/css/";
  private static final String JS_RES_HANDLER = "/js/**/*.js";
  private static final String JS_RES_MAP_HANDLER = "/js/**/*.map";
  private static final String JS_RES_LOCATION = "/WEB-INF/lib/js/";
  private static final String IMG_RES_HANDLER = "/img/**";
  private static final String IMG_RES_LOCATION = "/WEB-INF/lib/img/";
  private static final String FILE_RES_HANDLER = "/f/**";
  private static final String FILE_RES_LOCATION = "/public/";

  private static final Logger log = Logger.getLogger(WebConfig.class);

  private ApplicationContext applicationContext;

  @Override
  public void configureViewResolvers(ViewResolverRegistry registry) {
    log.debug("Configuring view resolvers.");
    ThymeleafViewResolver resolver = new ThymeleafViewResolver();
    resolver.setTemplateEngine(templateEngine());
    resolver.setCharacterEncoding("UTF-8");
    registry.viewResolver(resolver);
  }

  @Bean
  public TemplateEngine templateEngine() {
    log.debug("Configuring template engine.");
    SpringTemplateEngine engine = new SpringTemplateEngine();
    engine.setEnableSpringELCompiler(true);

    SpringResourceTemplateResolver resolver = new SpringResourceTemplateResolver();
    resolver.setApplicationContext(applicationContext);
    resolver.setPrefix(VIEW_RESOLVER_PREFIX);
    resolver.setSuffix(VIEW_RESOLVER_SUFFIX);
    resolver.setTemplateMode(TemplateMode.HTML);

    engine.setTemplateResolver(resolver);
    return engine;
  }

  @Override
  public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
    log.debug("Enabling default servlet handler configurer...");
    configurer.enable();
  }

  @Override
  public void addResourceHandlers(ResourceHandlerRegistry registry) {
    log.debug("Adding resource handlers.");

    /* Handler for CSS resources */
    registry.addResourceHandler(CSS_RES_HANDLER)
        .addResourceLocations(CSS_RES_LOCATION);

    /* Handler for JavaScript resources */
    registry.addResourceHandler(JS_RES_HANDLER)
        .addResourceLocations(JS_RES_LOCATION);
    registry.addResourceHandler(JS_RES_MAP_HANDLER)
        .addResourceLocations(JS_RES_LOCATION);

    /* Handler for image resources */
    registry.addResourceHandler(IMG_RES_HANDLER)
        .addResourceLocations(IMG_RES_LOCATION);

    /* Handler for other public files (avoiding WEB-INF for the 'public' part) */
    registry.addResourceHandler(FILE_RES_HANDLER)
        .addResourceLocations(FILE_RES_LOCATION);
  }

  @Override
  public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
    log.debug("Setting application context");
    this.applicationContext = applicationContext;
  }
}
