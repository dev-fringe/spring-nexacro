package dev.fringe.app;

import javax.servlet.ServletException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import io.undertow.Handlers;
import io.undertow.Undertow;
import io.undertow.server.handlers.PathHandler;
import io.undertow.servlet.Servlets;
import io.undertow.servlet.api.DeploymentInfo;
import io.undertow.servlet.api.DeploymentManager;
import io.undertow.servlet.api.ListenerInfo;
import io.undertow.servlet.util.ImmediateInstanceFactory;

public class Server {
    
    @Autowired Undertow undertow;
    
    public static void main(String[] args) {
        new AnnotationConfigApplicationContext(Server.class).getBean(Server.class).run(args);        
    }

    private void run(String[] args) {
        undertow.start();
    }

    @Bean
    public Undertow undertow() throws ServletException {
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.setConfigLocation("dev.fringe.app.config");
        DeploymentInfo servletBuilder = Servlets.deployment().setClassLoader(this.getClass().getClassLoader())
                .setContextPath("/").setDeploymentName(Server.class.getName() + ".war")
                .addServlet(Servlets.servlet("DispatcherServlet", DispatcherServlet.class, new ImmediateInstanceFactory<>(new DispatcherServlet(context)))
                .addMapping("/*").setLoadOnStartup(1))
                .addListener(new ListenerInfo(ContextLoaderListener.class, new ImmediateInstanceFactory<>(new ContextLoaderListener(context))));
        DeploymentManager manager = Servlets.defaultContainer().addDeployment(servletBuilder);
        manager.deploy();
        PathHandler path = Handlers.path(Handlers.redirect("/static/hello.html")).addPrefixPath("/", manager.start());
        return Undertow.builder().addHttpListener(80, "0.0.0.0").setHandler(path).build();
    }
}
