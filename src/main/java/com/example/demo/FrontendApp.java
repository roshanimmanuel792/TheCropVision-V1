package com.example.demo;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class FrontendApp extends Application {

    private TextField cropField = new TextField();
    private TextField locationField = new TextField();
    private Label statusLabel = new Label("Upload an image to detect disease.");
    private File selectedFile;

    @Override
    public void start(Stage stage) {
        stage.setTitle("🌾 Crop Disease Detector");

        Label cropLabel = new Label("Crop Name:");
        Label locationLabel = new Label("Location:");

        Button uploadButton = new Button("Choose Image");
        Button detectButton = new Button("Detect Disease");

        ImageView imageView = new ImageView();
        imageView.setFitHeight(200);
        imageView.setFitWidth(200);
        imageView.setPreserveRatio(true);

        uploadButton.setOnAction(e -> {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Select Crop Image");
            selectedFile = fileChooser.showOpenDialog(stage);
            if (selectedFile != null) {
                imageView.setImage(new Image(selectedFile.toURI().toString()));
                statusLabel.setText("Image selected: " + selectedFile.getName());
            }
        });

        detectButton.setOnAction(e -> {
            if (selectedFile == null || cropField.getText().isEmpty() || locationField.getText().isEmpty()) {
                showAlert("Missing Fields", "Please enter crop name, location, and choose an image!");
                return;
            }
            detectDisease();
        });

        VBox layout = new VBox(10,
                cropLabel, cropField,
                locationLabel, locationField,
                uploadButton, imageView, detectButton, statusLabel
        );
        layout.setPadding(new Insets(20));

        stage.setScene(new Scene(layout, 400, 500));
        stage.show();
    }

    private void detectDisease() {
        try {
            String boundary = "----Boundary";
            URL url = new URL("http://localhost:8080/api/detect");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + boundary);

            try (DataOutputStream out = new DataOutputStream(conn.getOutputStream())) {
                writeFormField(out, "cropName", cropField.getText(), boundary);
                writeFormField(out, "location", locationField.getText(), boundary);
                writeFileField(out, "image", selectedFile, boundary);
                out.writeBytes("--" + boundary + "--\r\n");
            }

            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuilder responseBuilder = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                responseBuilder.append(line);
            }
            reader.close();

            String response = responseBuilder.toString();
            showFormattedResponse(response);

        } catch (Exception e) {
            e.printStackTrace();
            showAlert("Error", "Failed to connect to server: " + e.getMessage());
        }
    }

    private void writeFormField(DataOutputStream out, String name, String value, String boundary) throws IOException {
        out.writeBytes("--" + boundary + "\r\n");
        out.writeBytes("Content-Disposition: form-data; name=\"" + name + "\"\r\n\r\n");
        out.writeBytes(value + "\r\n");
    }

    private void writeFileField(DataOutputStream out, String name, File file, String boundary) throws IOException {
        out.writeBytes("--" + boundary + "\r\n");
        out.writeBytes("Content-Disposition: form-data; name=\"" + name + "\"; filename=\"" + file.getName() + "\"\r\n");
        out.writeBytes("Content-Type: application/octet-stream\r\n\r\n");
        try (FileInputStream fileInputStream = new FileInputStream(file)) {
            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = fileInputStream.read(buffer)) != -1) {
                out.write(buffer, 0, bytesRead);
            }
        }
        out.writeBytes("\r\n");
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private void showFormattedResponse(String response) {
        // Make JSON look readable
        String formatted = response
                .replace(",", ",\n")
                .replace("{", "{\n")
                .replace("}", "\n}");

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("🌿 Detection Result");
        alert.setHeaderText("AI Analysis Result");
        alert.setContentText(formatted);
        alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
        alert.showAndWait();
    }

    public static void main(String[] args) {
        launch();
    }
}
