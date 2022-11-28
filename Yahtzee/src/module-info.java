module Yahtzee {
    requires javafx.fxml;
    requires javafx.controls;
    exports game;
    opens game;
}