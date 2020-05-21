package com.ratana.controller;

import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.MenuButton;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

@Component
@FxmlView
@Controller
public class HomeController {


    @FXML
    public void initialize() {
        System.out.println("Initialize on Main window");
    }

    public HomeController() {
        System.out.println("to inject constructor");
    }
}
