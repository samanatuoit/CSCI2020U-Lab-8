package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {
    private BorderPane layout;
    private TableView<StudentRecord> table;

    @Override
    public void start(Stage primaryStage) throws Exception{
        //Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Lab 05");

        table = new TableView<>();
        table.setItems(DataSource.getAllMarks());

        TableColumn<StudentRecord, String> sidColumn = new TableColumn<>("SID");
        sidColumn.setCellValueFactory(new PropertyValueFactory<>("SID"));
        sidColumn.setMinWidth(100);

        table.getColumns().add(sidColumn);






        layout = new BorderPane();
        layout.setCenter(table);
        primaryStage.setScene(new Scene(layout, 300, 275));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
