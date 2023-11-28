package io.codeforall.heapsdontlie;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Cell {

    protected Rectangle rectangle;

    protected Grid grid;

    protected int x;
    protected int y;

    private boolean isPainted;




    public Cell (int x, int y, Grid grid){
        this.x = x;
        this.y = y;
        this.grid = grid;
        this.rectangle = new Rectangle(x + Grid.PADDING,y + Grid.PADDING,grid.getCELL_SIZE(),grid.getCELL_SIZE()) ;
        this.rectangle.draw();
        this.rectangle.setColor(Color.BLACK);
    }



    public void changeColor(){
        this.rectangle.setColor(Color.BLACK);
        this.rectangle.fill();
        isPainted = true;
    }

    public void resetColour(){
        this.rectangle.draw();
        isPainted = false;
    }

    public boolean isPainted() {
        return isPainted;
    }


}
