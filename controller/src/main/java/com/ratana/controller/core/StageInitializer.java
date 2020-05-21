package com.ratana.controller.core;

import com.ratana.controller.utils.FTPs;
import com.ratana.controller.HomeController;
import com.ratana.controller.utils.I18N;
import com.ratana.controller.utils.Security;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import net.rgielen.fxweaver.core.FxWeaver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.util.Locale;

import static com.ratana.controller.core.LoanApplication.*;

@Component
public class StageInitializer implements ApplicationListener<StageReadyEvent> {

    private final FxWeaver fxWeaver;
    private String title;

    private Integer numSwitches = 0;
    @Value("${ftp.user}")
    private String ftpUser;
    @Value("${ftp.password}")
    private String ftpPassword;
    @Value("${ftp.host}")
    private String ftpHost;
    @Value("${ftp.directory}")
    private String ftpDirectory;

    @Autowired
    public StageInitializer(FxWeaver fxWeaver, @Value("${spring.application.name}") String title) {
        this.fxWeaver = fxWeaver;
        this.title = title;
    }

    @Override
    public void onApplicationEvent(StageReadyEvent stageReadyEvent) {
        Stage stage = stageReadyEvent.getStage();
        stage.setTitle(title);
        Scene scene = new Scene(fxWeaver.loadView(HomeController.class));

//        System.out.println(Security.MD5(Security.MD5(Security.MD5("client_01"))));
//        System.out.println(Security.MD5(Security.MD5(Security.MD5("ftp"))));
//        // create content
//        BorderPane content = new BorderPane();
//
//        // at the top two buttons
//        HBox hbox = new HBox();
//        hbox.setPadding(new Insets(5, 5, 5, 5));
//        hbox.setSpacing(5);
//
//        Button buttonEnglish = I18N.buttonForKey("button.english");
//        buttonEnglish.setOnAction((evt) -> {
//            switchLanguage(Locale.ENGLISH);
////            try {
////                FTPs ftp = new FTPs(ftpHost, ftpUser, ftpPassword);
//////                ftp.uploadFile("C:\\Users\\Ratana\\Pictures\\Screenshots\\Screenshot (1).png", "Screenshot (1).png", ftpDirectory);
////                ftp.deleteFile("/images/Screenshot (1).png");
////                ftp.disconnect();
////            } catch (Exception e) {
////                e.printStackTrace();
////            }
//
//        });
//        hbox.getChildren().add(buttonEnglish);
//
//        Button buttonGerman = I18N.buttonForKey("button.german");
//        buttonGerman.setOnAction((evt) -> switchLanguage(new Locale("kh")));
//        hbox.getChildren().add(buttonGerman);
//
//        content.setTop(hbox);
//
//        // a label to display the number of changes, recalculating the text on every change
//        final Label label = I18N.labelForValue(() -> I18N.get("label.numSwitches", numSwitches));
//        content.setBottom(label);
        scene.getStylesheets().add("css/style.css");
        stage.setScene(scene);
//        stage.setMaximized(true);
        stage.show();
    }

    /**
     * sets the given Locale in the I18N class and keeps count of the number of switches.
     *
     * @param locale
     *         the new local to set
     */
    private void switchLanguage(Locale locale) {
        numSwitches++;
        I18N.setLocale(locale);
    }
}
