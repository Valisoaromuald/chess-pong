package projetEchecPong.views;

import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

import java.time.LocalDate;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Orientation;
// import javafx.geometry.Orientation;
// import javafx.scene.control.Label;
// import javafx.scene.control.TextArea;
// import javafx.scene.control.TextField;
// import javafx.scene.control.Separator;
// import javafx.scene.control.PasswordField;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.RadioButton;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.Slider;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.CheckBox;
/*
Event
    -type(EventType)
    -source
    -cible(EventTarget)
    ActionEvent
    WindowEvent
    KeyEvent
 */
public class MainView extends VBox {
    public MainView(double spacing){
        super(spacing);
         this.getChildren().addAll();
    } 
}