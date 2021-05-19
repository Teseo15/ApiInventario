package group7.inventario.inventario.security.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class ControllerSecuryWeb implements WebMvcConfigurer {

    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/").setViewName("indexp");
        registry.addViewController("/dashboard").setViewName("indexp");
        registry.addViewController("/dashboard/productos").setViewName("products");
        registry.addViewController("/registrar").setViewName("register");
        registry.addViewController("/user/registrar").setViewName("index");
        registry.addViewController("/dashboard/sales").setViewName("salescreate");

    }
    public void addResourceHandlers(ResourceHandlerRegistry registry){
        registry.addResourceHandler("/static/**");
    }

}