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

        TableColumn<StudentRecord, Float> assignColumn = new TableColumn<>("Assignments");
        assignColumn.setCellValueFactory(new PropertyValueFactory<>("assignment"));
        assignColumn.setMinWidth(100);

        TableColumn<StudentRecord, Float> midtermColumn = new TableColumn<>("Midterm");
        midtermColumn.setCellValueFactory(new PropertyValueFactory<>("midterm"));
        midtermColumn.setMinWidth(100);

        TableColumn<StudentRecord, Float> finalExamColumn = new TableColumn<>("Final Exam");
        finalExamColumn.setCellValueFactory(new PropertyValueFactory<>("finalExam"));
        finalExamColumn.setMinWidth(100);

        TableColumn<StudentRecord,Float> finalMarkColumn = new TableColumn<>("Final Mark");
        finalMarkColumn.setCellValueFactory(new PropertyValueFactory<>("finalMark"));
        finalExamColumn.setMinWidth(100);

        TableColumn<StudentRecord, String> letterGradeColumn = new TableColumn<>("Letter Grade");
        letterGradeColumn.setCellValueFactory(new PropertyValueFactory<>("letterGrade"));
        letterGradeColumn.setMinWidth(100);


        table.getColumns().add(sidColumn);
        table.getColumns().add(assignColumn);
        table.getColumns().add(midtermColumn);
        table.getColumns().add(finalExamColumn);
        table.getColumns().add(finalMarkColumn);
        table.getColumns().add(letterGradeColumn);







        layout = new BorderPane();
        layout.setCenter(table);
        primaryStage.setScene(new Scene(layout, 600, 600));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
