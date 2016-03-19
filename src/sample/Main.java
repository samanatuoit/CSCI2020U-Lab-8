package sample;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.*;
import java.util.Iterator;

public class Main extends Application {
    private BorderPane layout;
    private TableView<StudentRecord> table;
    private File currentFilename;

    private void save() {
        try {
            PrintWriter fout = new PrintWriter(currentFilename);
            ObservableList<StudentRecord> mylist = table.getItems();
            for (StudentRecord studentRecord : mylist) {
                fout.println(studentRecord.SID + "," + studentRecord.assignment + "," + studentRecord.midterm + ","
                        + studentRecord.finalExam);
                System.out.println(studentRecord.SID + "," + studentRecord.assignment + "," + studentRecord.midterm + ","
                        + studentRecord.finalExam);
            }
            fout.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void load() {
        String SID;
        float assignment = 0;
        float midterm = 0;
        float finalExam = 0;
        ObservableList<StudentRecord> marks = FXCollections.observableArrayList();

        try {
            BufferedReader in = new BufferedReader(new FileReader(currentFilename));
            String line;
            while ((line = in.readLine()) != null) {
                String[] data = line.split(",");
                SID = data[0];
                assignment = Float.parseFloat(data[1]);
                midterm = Float.parseFloat(data[2]);
                finalExam = Float.parseFloat(data[3]);
                //table.getItems().add(new StudentRecord(SID, assignment, midterm, finalExam));
                //table.setItems(new StudentRecord(SID, assignment, midterm, finalExam));
                marks.add(new StudentRecord(SID, assignment, midterm, finalExam));
            }
            table.setItems(marks);


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        //Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Lab 08");
        currentFilename = new File("test.csv");

        // File menu
        Menu fileMenu = new Menu("File");
        MenuItem newMenuItem = new MenuItem("New");
        fileMenu.getItems().add(newMenuItem);
        newMenuItem.setOnAction(evt -> table.setItems(null));
        MenuItem openMenuItem = new MenuItem("Open");
        fileMenu.getItems().add(openMenuItem);
        openMenuItem.setOnAction(evt -> load());
        MenuItem saveMenuItem = new MenuItem("Save");
        fileMenu.getItems().add(saveMenuItem);
        saveMenuItem.setOnAction(evt -> save());
        MenuItem saveAsMenuItem = new MenuItem("Save As");
        fileMenu.getItems().add(saveAsMenuItem);
        MenuItem exitMenuItem = new MenuItem("Exit");
        fileMenu.getItems().add(exitMenuItem);
        exitMenuItem.setOnAction(evt -> System.exit(0));


        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().add(fileMenu);

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




        /* GridPane fng a new student */
        Label sidLbl = new Label("SID: ");
        TextField sidFld = new TextField();
        Label midtermLbl = new Label("Midterm: ");
        TextField midtermFld = new TextField();
        Label assignLbl = new Label("Assignments: ");
        TextField assignFld = new TextField();
        Label finalExamLbl = new Label("Final Exam: ");
        TextField finalExamFld = new TextField();
        Button addBtn = new Button("Add");

        GridPane addPane = new GridPane();
        addPane.setHgap(20);
        addPane.setVgap(20);

        addPane.add(sidLbl, 0, 0);
        addPane.add(sidFld, 1, 0);
        addPane.add(midtermLbl, 0, 1);
        addPane.add(midtermFld, 1, 1);
        addPane.add(assignLbl, 2, 0);
        addPane.add(assignFld, 3, 0);
        addPane.add(finalExamLbl, 2, 1);
        addPane.add(finalExamFld, 3, 1);
        addPane.add(addBtn, 1, 3);

        addBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String SID = sidFld.getText();
                float assignment = Float.parseFloat(assignFld.getText());
                float midterm = Float.parseFloat(midtermFld.getText());
                float finalExam = Float.parseFloat(finalExamFld.getText());

                table.getItems().add(new StudentRecord(SID, assignment, midterm, finalExam));

                sidFld.setText("");
                assignFld.setText("");
                midtermFld.setText("");
                finalExamFld.setText("");


            }
        });





        layout = new BorderPane();
        layout.setTop(menuBar);
        layout.setCenter(table);
        layout.setBottom(addPane);
        primaryStage.setScene(new Scene(layout, 600, 400));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
