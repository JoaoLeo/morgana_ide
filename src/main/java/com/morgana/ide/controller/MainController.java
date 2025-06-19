package com.morgana.ide.controller;

import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class MainController {
    @FXML private TabPane editorTabPane;
    @FXML private TreeView<String> fileTreeView;
    @FXML private MenuBar menuBar;
    @FXML private ToolBar toolBar;
    @FXML private Label statusLabel;

    private Stage primaryStage;
    private final Map<Tab, File> tabFileMap = new HashMap<>();

    public void initialize(Stage stage) {
        this.primaryStage = stage;
        setupFileTree();
//        setupMenus();
        setupToolbar();
        setupStatusBar();
    }

    private void setupFileTree() {
        TreeItem<String> rootItem = new TreeItem<>("Project");
        rootItem.setExpanded(true);

        TreeItem<String> srcItem = new TreeItem<>("📁 src");
        srcItem.getChildren().addAll(
                new TreeItem<>("📄 MainApp.java"),
                new TreeItem<>("📄 MainController.java"),
                new TreeItem<>("📄 EditorController.java")
        );

        TreeItem<String> resourcesItem = new TreeItem<>("📁 resources");
        resourcesItem.getChildren().addAll(
                new TreeItem<>("📁 fxml"),
                new TreeItem<>("📁 css")
        );

        rootItem.getChildren().addAll(srcItem, resourcesItem);
        fileTreeView.setRoot(rootItem);

        // Handle file selection
        fileTreeView.getSelectionModel().selectedItemProperty().addListener(
                (obs, oldVal, newVal) -> {
                    if (newVal != null && newVal.getValue().startsWith("📄")) {
                        String fileName = newVal.getValue().substring(2); // Remove emoji
                        openFileInEditor(fileName);
                    }
                }
        );
    }

//    private void setupMenus() {
//        Menu fileMenu = new Menu("File");
//        MenuItem newItem = new MenuItem("New");
//        MenuItem openItem = new MenuItem("Open");
//        MenuItem saveItem = new MenuItem("Save");
//        MenuItem exitItem = new MenuItem("Exit");
//
//        newItem.setOnAction(e -> createNewFile());
//        openItem.setOnAction(e -> openFile());
//        saveItem.setOnAction(e -> saveCurrentFile());
//        exitItem.setOnAction(e -> primaryStage.close());
//
//        fileMenu.getItems().addAll(newItem, openItem, saveItem, new SeparatorMenuItem(), exitItem);
//
//        Menu editMenu = new Menu("Edit");
//        MenuItem undoItem = new MenuItem("Undo");
//        MenuItem redoItem = new MenuItem("Redo");
//        editMenu.getItems().addAll(undoItem, redoItem);
//
//        menuBar.getMenus().addAll(fileMenu, editMenu);
//    }

    private void setupToolbar() {
        JFXButton fileBtn = new JFXButton("File");

        fileBtn.setOnAction(e -> openFile());

        toolBar.getItems().addAll(fileBtn);
    }

    private void setupStatusBar() {
        statusLabel.setText("Ready");
    }

    private void openFileInEditor(String fileName) {
        // Check if file is already open
        for (Tab tab : editorTabPane.getTabs()) {
            if (tab.getText().equals(fileName)) {
                editorTabPane.getSelectionModel().select(tab);
                return;
            }
        }

        // Create new tab
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Editor.fxml"));
            Parent editorContent = loader.load();
            EditorController editorController = loader.getController();

            Tab tab = new Tab(fileName);
            tab.setContent(editorContent);

            // Load file content (mock for now)
            String content = loadFileContent(fileName);
            editorController.setText(content);

            // Handle tab close
            tab.setOnClosed(e -> tabFileMap.remove(tab));

            editorTabPane.getTabs().add(tab);
            editorTabPane.getSelectionModel().select(tab);

            statusLabel.setText("Opened: " + fileName);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String loadFileContent(String fileName) {
        // Mock content - in real app, load from file system
        return "// " + fileName + "\npublic class " + fileName.replace(".java", "") + " {\n    \n}";
    }

    @FXML
    private void createNewFile() {
        openFileInEditor("Untitled.java");
    }

    @FXML
    private void openFile() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open File");
        fileChooser.getExtensionFilters().add(
                new FileChooser.ExtensionFilter("Java Files", "*.java")
        );

        File file = fileChooser.showOpenDialog(primaryStage);
        if (file != null) {
            openFileInEditor(file.getName());
        }
    }

    @FXML
    private void saveCurrentFile() {
        Tab selectedTab = editorTabPane.getSelectionModel().getSelectedItem();
        if (selectedTab != null) {
            statusLabel.setText("Saved: " + selectedTab.getText());
        }
    }

    @FXML
    private void runCurrentFile() {
        Tab selectedTab = editorTabPane.getSelectionModel().getSelectedItem();
        if (selectedTab != null) {
            statusLabel.setText("Running: " + selectedTab.getText());
        }
    }
}