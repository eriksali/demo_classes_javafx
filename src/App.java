import java.util.Random;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class App extends Application {

	@Override 

	public void start(Stage primaryStage) {
		GridPane gridpane = new GridPane();
        gridpane.setAlignment(Pos.CENTER);
    
        Label question = new Label("");
        Label answer = new Label();
        TextField result = new TextField();

        Loader loader = new Loader(result, answer, question, gridpane);

        loader.loadText(gridpane);
        loader.submitBtn(gridpane);
        loader.renewBtn(gridpane);
        loader.exitBtn(gridpane, primaryStage);
   
        Scene scene = new Scene(gridpane, 600, 450);

        primaryStage.setTitle("Addition");
        primaryStage.setScene(scene);
        primaryStage.show();
  
	}

    public static void main(String[] args){
		launch(args);
	}

}



class Loader {

    private Label question;
    private Label answer;
    private TextField result;

    int sum1;
    int sum2;

    Random rand;
    int number1;
    int number2;


    Loader(TextField result, Label answer, Label question, final GridPane gridpane) {
        this.question = question;
        this.answer = answer;
        this.result = result;
    }


    public int loadQuestion(GridPane gp, int number1, int number2) {
        question.setText(number1 + " + " + number2);
        return number1 + number2;
    }

    public int loadAnswer(GridPane gp, TextField result, Label answer) {
        int res = Integer.parseInt(result.getText());
        answer.setText(result.getText());
        return res;     
    }

    public void loadText(GridPane gp) {
        Text txt1 = new Text("Question: ");
        Text txt2 = new Text("Answer: ");

        gp.add(txt1,     0, 0);
        gp.add(txt2,     0, 1);
        gp.add(question, 1, 0);
        gp.add(result,   1, 1);
        gp.add(answer,   1, 2);

        rand = new Random(); 
        number1 = rand.nextInt(10); 
        number2 = rand.nextInt(10);

        question.setText(number1 + " + " + number2);
    }



    public void submitBtn(GridPane gp) {
        Button btn = new Button("Summit");
        
        btn.setDefaultButton(true);
        btn.setOnAction(e -> {

            try{
                sum1 = loadQuestion(gp, number1, number2);
                sum2 = loadAnswer(gp, result, answer);
            } catch(NumberFormatException ex){ // handle your exception
                ;
            }

            if(sum1 == sum2){
                answer.setText(number1 + " + " + number2 + " = " + result.getText() + "  correct");
            } 
            else if(!(sum1 == sum2)){
                answer.setText(number1 + " + " + number2 + " = " + result.getText() + "  incorrect");
            }
            else {
                Alert alert = new Alert(AlertType.ERROR, "Please enter a number.");
                alert.showAndWait();
            }
        });
        gp.add(btn, 0, 3);
    }

    public void renewBtn(GridPane gp) {
        Button btn1 = new Button("Continue");
        
        btn1.setOnAction(e -> {
            number1 = rand.nextInt(10); 
            number2 = rand.nextInt(10);

            question.setText(number1 + " + " + number2);
            result.clear();
            answer.setText("");
            sum1 = 0;
            sum2 = 0;
        });

        gp.add(btn1, 1, 3);
    }


    public void exitBtn(GridPane gp, Stage stage) {
        Button btnExit = new Button("Exit");
        btnExit.setOnAction(e -> {
            stage.close();
        });
        gp.add(btnExit, 2, 3);
    }
	
}
