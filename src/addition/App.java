package addition;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
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


        Scene scene = new Scene(gridpane, 600, 450);

        primaryStage.setTitle("Addition");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        loader.loadText(gridpane);
        loader.submitBtn(gridpane);
        loader.renewBtn(gridpane);
        loader.exitBtn(gridpane, primaryStage);
   
	}

    public static void main(String[] args){
		launch(args);
	}

}


