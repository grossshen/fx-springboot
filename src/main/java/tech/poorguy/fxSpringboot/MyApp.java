package tech.poorguy.fxSpringboot;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

/**
 * @author poorguy
 * @version 0.0.1
 * @E-mail 494939649@qq.com
 * @created 2019/5/14 16:18
 * @description extends Application to modify the MyApp class to Javafx under spring framework's control
 */
@SpringBootApplication
public class MyApp extends Application {
    private ConfigurableApplicationContext springContext;
    private Parent rootNode;
    private FXMLLoader fxmlLoader;

    public static void main(String[] args){
        //SpringApplication.run(MyApp.class, args);
        launch(args);
    }

    @Override
    public void init() {
        springContext = SpringApplication.run(MyApp.class);
        fxmlLoader=new FXMLLoader();
        //ceding the control of beans to the spring's bean factory
        fxmlLoader.setControllerFactory(springContext::getBean);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        fxmlLoader.setLocation(getClass().getResource("/fxml/sample.fxml"));
        rootNode = fxmlLoader.load();

        primaryStage.setTitle("hello world");
        Scene scene = new Scene(rootNode, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @Override
    public void stop() {
        springContext.stop();
    }

    //>>>>>>>>>>
//    /**
//     * @Description: add a component to context, it  will run after springboot started
//     */
//    @Bean
//    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
//        return x -> System.out.println("hello world");
//    }
}
