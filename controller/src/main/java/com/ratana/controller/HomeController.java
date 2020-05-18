package com.ratana.controller;

import javafx.fxml.FXML;
import net.rgielen.fxweaver.core.FxmlView;
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
        System.out.println("Creating window object");
    }
}
