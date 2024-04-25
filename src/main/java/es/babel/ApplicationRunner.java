package es.babel;

import es.babel.Cine.CineApp;
import es.babel.Configuration.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class ApplicationRunner {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        CineApp cine = context.getBean(CineApp.class);

        cine.start();
    }
}