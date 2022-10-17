package io.github.itzg.tryjavafxfilesystemaccess;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

/**
 * This is my text pane.
 */
public class MainTextPane extends TextFlow {

    private ObjectProperty<File> dataDirectory = new SimpleObjectProperty<>();

    public MainTextPane() {
        dataDirectory.addListener((observable, oldValue, newValue) -> {
            loadMainText(newValue);
        });
    }

    /**
     * Loads the main text
     * @param dataDirectory the data directory
     */
    private void loadMainText(File dataDirectory) {
        try {
            final List<String> lines = Files.readAllLines(dataDirectory.toPath().resolve("main.txt"));

            getChildren().clear();
            for (final String line : lines) {
                getChildren().add(new Text(line+"\n"));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public ObjectProperty<File> dataDirectoryProperty() {
        return dataDirectory;
    }
}
