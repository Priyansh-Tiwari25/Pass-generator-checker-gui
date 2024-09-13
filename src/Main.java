import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    private Generator generator;
    private TextArea outputArea;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Password Generator");

        generator = new Generator(true, true, true, true); // Example settings
        outputArea = new TextArea();
        outputArea.setEditable(false);

        TextField lengthField = new TextField();
        lengthField.setPromptText("Enter password length");

        CheckBox includeUpper = new CheckBox("Include Uppercase");
        CheckBox includeLower = new CheckBox("Include Lowercase");
        CheckBox includeNumbers = new CheckBox("Include Numbers");
        CheckBox includeSymbols = new CheckBox("Include Symbols");

        Button generateButton = new Button("Generate Password");
        generateButton.setOnAction(e -> generatePassword(lengthField.getText(),
                includeUpper.isSelected(),
                includeLower.isSelected(),
                includeNumbers.isSelected(),
                includeSymbols.isSelected()));

        Button checkStrengthButton = new Button("Check Password Strength");
        checkStrengthButton.setOnAction(e -> checkPasswordStrength());

        VBox layout = new VBox(10);
        layout.getChildren().addAll(lengthField, includeUpper, includeLower, includeNumbers, includeSymbols, generateButton, checkStrengthButton, outputArea);

        Scene scene = new Scene(layout, 400, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void generatePassword(String lengthStr, boolean upper, boolean lower, boolean numbers, boolean symbols) {
        try {
            int length = Integer.parseInt(lengthStr);
            Generator gen = new Generator(upper, lower, numbers, symbols);
            Password password = gen.GeneratePassword(length);
            outputArea.setText("Generated Password: " + password.toString());
        } catch (NumberFormatException e) {
            outputArea.setText("Invalid length. Please enter a number.");
        }
    }

    private void checkPasswordStrength() {
        String password = showInputDialog("Enter your password:");
        if (password != null) {
            Password p = new Password(password);
            outputArea.setText(p.calculateScore());
        }
    }

    private String showInputDialog(String message) {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Input");
        dialog.setHeaderText(null);
        dialog.setContentText(message);

        return dialog.showAndWait().orElse(null);
    }
}
