package io.github.itzg.tryjavafxfilesystemaccess;

import java.io.File;
import java.util.prefs.Preferences;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;

import java.io.IOException;

public class TryFileSystemAccess extends Application {

    public static final String PREF_DATA_DIRECTORY = "dataDirectory";

    @Override
    public void start(Stage stage) throws IOException {
        final MainTextPane mainTextPane = new MainTextPane();
        Scene scene = new Scene(mainTextPane, 320, 240);

        stage.setScene(scene);

        final Preferences prefs = Preferences.userNodeForPackage(TryFileSystemAccess.class);
        final String dataDirectory = prefs.get(PREF_DATA_DIRECTORY, null);
        if (dataDirectory == null) {
            final DirectoryChooser chooser = new DirectoryChooser();
            chooser.setTitle("Choose a data directory");
            final File chosenFile = chooser.showDialog(stage);
            if (chosenFile != null) {
                mainTextPane.dataDirectoryProperty().setValue(chosenFile);
                prefs.put(PREF_DATA_DIRECTORY, chosenFile.toString());
            }
        }
        else {
            mainTextPane.dataDirectoryProperty().setValue(new File(dataDirectory));
        }

        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}