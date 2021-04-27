package lv.lu.guntars.revelins.finalwork;

import lv.lu.guntars.revelins.finalwork.config.AppConfiguration;
import lv.lu.guntars.revelins.finalwork.ui.ConsoleUi;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ProductAccountingApplication {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfiguration.class);
        context.getBean(ConsoleUi.class).run();
    }
}
