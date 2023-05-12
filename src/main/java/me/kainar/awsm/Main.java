package me.kainar.awsm;

import org.apache.catalina.LifecycleException;
import org.apache.catalina.WebResourceRoot;
import org.apache.catalina.core.StandardContext;
import org.apache.catalina.startup.Tomcat;
import org.apache.catalina.webresources.DirResourceSet;
import org.apache.catalina.webresources.StandardRoot;

import java.io.File;

public class Main {
    public static void main(String[] args) throws LifecycleException{
        String webappDir = "src/main/webapp";
        Tomcat tomcat = new Tomcat();

        tomcat.setPort(8080);
        tomcat.getConnector();

        StandardContext context = (StandardContext) tomcat.addWebapp("/", new File(webappDir).getAbsolutePath());
        File additionalWebInfClasses = new File("target/classes");
        WebResourceRoot resources = new StandardRoot(context);
        resources.addPreResources(new DirResourceSet(resources, "/WEB-INF/classes",
                additionalWebInfClasses.getAbsolutePath(), "/"));

        context.setResources(resources);

        tomcat.start();
        tomcat.getServer().await();
    }
}
