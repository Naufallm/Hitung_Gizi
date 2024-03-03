package gizi.lovebody;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Kalkulator BMI dan IMT");

        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10, 10, 10, 10));
        gridPane.setVgap(10);
        gridPane.setHgap(10);
        gridPane.setAlignment(Pos.CENTER);

        // Menambahkan warna latar belakang biru muda
        gridPane.setStyle("-fx-background-color: #add8e6;");

        // Nama Label
        Label nameLabel = new Label("Nama:");
        nameLabel.setStyle("-fx-font-family: 'Comic Sans MS'; -fx-font-size: 16;");
        GridPane.setConstraints(nameLabel, 0, 0);
        TextField nameInput = new TextField();
        nameInput.setPromptText("Masukkan nama");
        nameInput.setMaxSize(200, 30); // Mengatur ukuran maksimum
        GridPane.setConstraints(nameInput, 1, 0);

        // Tinggi Badan Label
        Label heightLabel = new Label("Tinggi Badan (cm):");
        heightLabel.setStyle("-fx-font-family: 'Comic Sans MS'; -fx-font-size: 16;");
        GridPane.setConstraints(heightLabel, 0, 1);
        TextField heightInput = new TextField();
        heightInput.setPromptText("Tinggi Badan");
        heightInput.setMaxSize(200, 30); // Mengatur ukuran maksimum
        GridPane.setConstraints(heightInput, 1, 1);

        // Berat Badan Label
        Label weightLabel = new Label("Berat Badan (kg):");
        weightLabel.setStyle("-fx-font-family: 'Comic Sans MS'; -fx-font-size: 16;");
        GridPane.setConstraints(weightLabel, 0, 2);
        TextField weightInput = new TextField();
        weightInput.setPromptText("Berat Badan");
        weightInput.setMaxSize(200, 30); // Mengatur ukuran maksimum
        GridPane.setConstraints(weightInput, 1, 2);

        Button calculateButton = new Button("Hitung");
        calculateButton.setStyle("-fx-font-family: 'Comic Sans MS'; -fx-font-size: 16;");
        calculateButton.setMaxSize(200, 30); // Mengatur ukuran maksimum
        GridPane.setConstraints(calculateButton, 1, 3);

        TextArea resultArea = new TextArea();
        resultArea.setEditable(false);
        resultArea.setStyle("-fx-font-family: 'Comic Sans MS'; -fx-font-size: 16;");
        resultArea.setMaxSize(400, 100); // Mengatur ukuran maksimum
        GridPane.setConstraints(resultArea, 0, 4, 2, 1);

        gridPane.getChildren().addAll(nameLabel, nameInput, heightLabel, heightInput, weightLabel, weightInput, calculateButton, resultArea);

        calculateButton.setOnAction(event -> {
            String name = nameInput.getText();
            double height = Double.parseDouble(heightInput.getText());
            double weight = Double.parseDouble(weightInput.getText());

            double bmi = calculateBMI(height, weight);
            double idealWeight = calculateIdealWeight(height);

            resultArea.setText("Nama: " + name + "\n" +
                    "Berat Badan Ideal: " + String.format("%.2f", idealWeight) + " kg\n" +
                    "Indeks Massa Tubuh (BMI): " + String.format("%.2f", bmi));
        });

        Scene scene = new Scene(gridPane, 400, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private double calculateBMI(double height, double weight) {
        double heightInMeters = height / 100; // Convert to meters
        return weight / (heightInMeters * heightInMeters);
    }

    private double calculateIdealWeight(double height) {
        return (height - 100) - ((height - 100) * 0.1);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
