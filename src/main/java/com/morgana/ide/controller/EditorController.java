package com.morgana.ide.controller;

import javafx.fxml.FXML;
import javafx.scene.control.*;

public class EditorController {
    @FXML
    private TextArea codeTextArea;

    @FXML
    private Label lineNumberLabel;

    @FXML
    private void initialize() {
        setupEditor();
    }

    private void setupEditor() {
        codeTextArea.setWrapText(false);
        codeTextArea.setStyle("-fx-font-family: 'Courier New', monospace; -fx-font-size: 14px;");

        // Add line number tracking
        codeTextArea.caretPositionProperty().addListener((obs, oldPos, newPos) -> {
            int line = getLineNumber(newPos.intValue());
            lineNumberLabel.setText("Line: " + line);
        });
    }

    private int getLineNumber(int caretPosition) {
        String text = codeTextArea.getText(0, caretPosition);
        return text.split("\n").length;
    }

    public void setText(String content) {
        codeTextArea.setText(content);
    }

    public String getText() {
        return codeTextArea.getText();
    }
}
