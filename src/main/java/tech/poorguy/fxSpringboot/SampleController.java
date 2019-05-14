package tech.poorguy.fxSpringboot;

import javafx.fxml.FXML;
import javafx.scene.web.WebView;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;

/**
 * @author poorguy
 * @version 0.0.1
 * @E-mail 494939649@qq.com
 * @created 2019/5/14 17:01
 * @description the controller was created and managed by spring
 */
@Controller
public class SampleController {
    @FXML
    private WebView myWebView;

    @Value("${my.url}")
    private String myUrl;

    @FXML
    private void initialize(){
        myWebView.getEngine().load(myUrl);
    }
}
