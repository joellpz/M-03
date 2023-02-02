module com.example.fallingfood {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.fallingfood to javafx.fxml;
    exports com.example.fallingfood;
}