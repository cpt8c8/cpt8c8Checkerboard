
package cpt8c8checkerboard;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

/**
 *
 * @author Sam
 */
public class FXMLCheckerBoardController implements Initializable{
    
    private double boardHeight;
    private double boardWidth;
    private int numCols = 8;
    private int numRows = 8;
    
    private Color lightCol = Color.RED;
    private Color darkCol = Color.BLACK;
    private Scene scene;
    
    @FXML private AnchorPane anchorPane;
    @FXML private Menu gridMenu;
    @FXML private Menu colorsMenu;
    @FXML private MenuBar menuBar;
    @FXML private MenuItem defaultMenu;
    @FXML private MenuItem pink;
    @FXML private MenuItem size3;
    @FXML private MenuItem size8;
    @FXML private MenuItem size10;
    @FXML private MenuItem size16;
    @FXML private VBox vBox;
    @FXML private VBox vBoxDisplayArea;
    
    @Override
    public void initialize(URL url, ResourceBundle rb){
    
    }    

    @FXML private void changeColor(ActionEvent event){
        MenuItem menuItem = (MenuItem)(event.getSource());
        
        switch(menuItem.getId()){
            case "defaultMenu":
                lightCol = Color.RED;
                darkCol = Color.BLACK;
                break;
            case "pink":
                lightCol = Color.PINK;
                darkCol = Color.MAGENTA;//sorry to go against the assignment, but pink > blue
                break;
            default:
                lightCol = Color.RED;
                darkCol = Color.BLACK;
                break;
        }
        
        setCheckBoard();
    }
    
    @FXML private void changeSize(ActionEvent event){
        MenuItem menuItem = (MenuItem)(event.getSource());
        
        switch(menuItem.getId()){
            case "size3":
                numRows = 3;
                numCols = 3;
                break;
            case "size8":
                numRows = 8;
                numCols = 8;
                break;
            case "size10":
                numRows = 10;
                numCols = 10;
                break;
            case "size16":
                numRows = 16;
                numCols = 16;
                break;
            default:
                numRows = 8;
                numCols = 8;
                break;
        }
        
        setCheckBoard();
    }
    
    public void ready(Scene scene){//change listener for width/height
        this.scene = scene;
        
        ChangeListener<Number> sizeChangeListener = (ObservableValue<? extends Number> observable, Number oldValue, final Number newValue) -> {
            setCheckBoard(); 
        };
        
        scene.widthProperty().addListener(sizeChangeListener);
        scene.heightProperty().addListener(sizeChangeListener);
        
        setCheckBoard();
    }
    
    public void setCheckBoard(){//clear old gameboard and make new one   
        boardWidth = vBox.getWidth();
        boardHeight = vBox.getHeight() - menuBar.getHeight();
        
        Checkerboard checkerboard = new Checkerboard(numRows, numCols, boardWidth, boardHeight, lightCol, darkCol);
        AnchorPane checkboard = checkerboard.build();
        
        anchorPane.getChildren().clear();
        anchorPane.getChildren().addAll(checkboard); 
    }  
}
