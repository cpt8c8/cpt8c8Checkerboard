
package cpt8c8checkerboard;

import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author Sam
 */
public class Checkerboard {
    private double boardHeight;
    private double boardWidth;
    private double recHeight;
    private double recWidth;
    private int numCols;
    private int numRows;
    private AnchorPane checkboard = null;
    private Color lightCol;
    private Color darkCol;
    
    public Checkerboard(int numRows, int numCols, double boardWidth, double boardHeight) {
        this.numRows = numRows;
        this.numCols = numCols;
        this.boardWidth = boardWidth;
        this.boardHeight = boardHeight;
    }
    
    public Checkerboard(int numRows, int numCols, double boardWidth, double boardHeight, Color lightCol, Color darkCol) {
        this(numRows, numCols, boardWidth, boardHeight);
        this.lightCol = lightCol;
        this.darkCol = darkCol;
    }
    
    public AnchorPane build(){
        if(boardWidth < boardHeight){//calculate max width and height of sqaures
            recWidth = boardWidth/numCols;
            recHeight = boardWidth/numRows;
        }
        else{
           recWidth = boardHeight/numCols;
           recHeight = boardHeight/numRows; 
        }
        
        checkboard = new AnchorPane();
                 
        for(int i = 0; i < numRows; i++){//create squares
            for(int j = 0 ; j < numCols ; j++){
                
               
                Rectangle boardSquare = new Rectangle();
                boardSquare.setWidth(recWidth);
                boardSquare.setHeight(recHeight);
                boardSquare.setX(recWidth * j);
                boardSquare.setY(recHeight * i);
            
                if((j % 2 == 0 && i % 2 != 0) || (j % 2 != 0 && i % 2 == 0)){//set colors
                    boardSquare.setFill(darkCol);
                }
                else{
                    boardSquare.setFill(lightCol);
                }
            
                checkboard.getChildren().add(boardSquare);
            }
        }            
        return checkboard;
    }
    
    public AnchorPane getBoard(){
        return checkboard;
    }
  
    public Color getLightColor(){
        return lightCol;
    }
    
    public Color getDarkColor(){
        return darkCol;
    }
    
    public double getWidth(){
        return boardWidth;
    }
    
    public double getHeight(){
        return boardHeight;
    }
    
    public double getRectangleWidth(){
        return recWidth;
    }
    
    public double getRectangleHeight(){
        return recHeight;
    }
    
    public int getNumRows(){
        return numRows;
    }
    
    public int getNumCols(){
        return numCols;
    }
}
