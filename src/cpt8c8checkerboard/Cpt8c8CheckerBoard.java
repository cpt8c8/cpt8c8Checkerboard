
package cpt8c8checkerboard;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Sam
 */
public class Cpt8c8CheckerBoard extends Application{
    
    @Override
    public void start(Stage stage) throws Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLCheckerBoard.fxml"));
        Parent root = loader.load();
        FXMLCheckerBoardController controller = loader.getController();
        
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        controller.ready(scene);
    }

    public static void main(String[] args){
        launch(args);
    }
    
}
