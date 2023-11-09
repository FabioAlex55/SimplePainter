package io.codeforall.heapsdontlie;


import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class Cursor extends Cell implements KeyboardHandler {

    private Keyboard keyboard;


    public Cursor(int x, int y, Grid grid) {
        super(x, y, grid);
        rectangle.setColor(Color.MAGENTA);
        rectangle.fill();
        keyboard = new Keyboard(this);
        init();

    }




    public void moveLeft(){

        if(x>0) {

            rectangle.translate(-grid.getCELL_SIZE(), 0);
            this.x--;

        }

    }

    public void moveRight(){

        if(x< grid.getCol()-1) {

            rectangle.translate(grid.getCELL_SIZE(), 0);
            this.x++;
        }
    }


    public void moveUp(){

        if(y>0) {

            rectangle.translate(0, -grid.getCELL_SIZE());
            this.y--;
        }
    }


    public void moveDown(){
        if(y< grid.getRow()-1) {
            rectangle.translate(0, grid.getCELL_SIZE());
            this.y++;
        }
    }







   public void init(){
       KeyboardEvent left = new KeyboardEvent();
       left.setKey(KeyboardEvent.KEY_LEFT);
       left.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

       KeyboardEvent right = new KeyboardEvent();
       right.setKey(KeyboardEvent.KEY_RIGHT);
       right.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

       KeyboardEvent up = new KeyboardEvent();
       up.setKey(KeyboardEvent.KEY_UP);
       up.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

       KeyboardEvent down = new KeyboardEvent();
       down.setKey(KeyboardEvent.KEY_DOWN);
       down.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

       KeyboardEvent paint = new KeyboardEvent();
       paint.setKey(KeyboardEvent.KEY_P);
       paint.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);



       keyboard.addEventListener(paint);
       keyboard.addEventListener(left);
       keyboard.addEventListener(right);
       keyboard.addEventListener(up);
       keyboard.addEventListener(down);



   }

    public void paint(){
        Cell cell = grid.getList()[y][x];
        cell.changeColor();
    }




    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
       switch (keyboardEvent.getKey()){
           case KeyboardEvent.KEY_LEFT:
               moveLeft();
                break;
           case (KeyboardEvent.KEY_RIGHT):
               moveRight();
               break;
           case (KeyboardEvent.KEY_DOWN):
               moveDown();
               break;
           case (KeyboardEvent.KEY_UP):
               moveUp();
               break;
           case(KeyboardEvent.KEY_P):
               paint();
       }

    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }



}
