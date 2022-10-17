module io.github.itzg.tryjavafxfilesystemaccess {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.prefs;

    opens io.github.itzg.tryjavafxfilesystemaccess to javafx.fxml;
    exports io.github.itzg.tryjavafxfilesystemaccess;
}