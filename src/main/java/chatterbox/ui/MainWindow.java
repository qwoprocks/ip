package chatterbox.ui;

import chatterbox.Chatterbox;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

/**
 * Controller for MainWindow. Provides the layout for the other controls.
 */
public class MainWindow extends AnchorPane {
    @FXML
    private ScrollPane scrollPane;
    @FXML
    private VBox dialogContainer;
    @FXML
    private TextField userInput;
    @FXML
    private Button sendButton;

    private Chatterbox chatterbox;

    private Image userImage = new Image(this.getClass().getResourceAsStream("/images/User.jpg"));
    private Image chatterboxImage = new Image(this.getClass().getResourceAsStream("/images/Chatterbox.jpg"));

    @FXML
    public void initialize() {
        scrollPane.vvalueProperty().bind(dialogContainer.heightProperty());
    }

    public void setChatterbox(Chatterbox d) {
        chatterbox = d;
    }

    /**
     * Creates two dialog boxes, one echoing user input and the other containing Chatterbox's reply and then appends
     * them to the dialog container. Clears the user input after processing.
     */
    @FXML
    private void handleUserInput() {
        String input = userInput.getText();
        String response = input;
        dialogContainer.getChildren().addAll(
                DialogBox.getUserDialog(input, userImage),
                DialogBox.getDukeDialog(response, chatterboxImage)
        );
        userInput.clear();
    }
}

