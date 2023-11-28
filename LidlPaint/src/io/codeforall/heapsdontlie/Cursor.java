package io.codeforall.heapsdontlie;


import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class Cursor extends Cell implements KeyboardHandler {

    private Keyboard keyboard;

    private boolean isDeleting;
    private boolean isPressed;

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

       KeyboardEvent stopPaiting= new KeyboardEvent();
       stopPaiting.setKey(KeyboardEvent.KEY_P);
       stopPaiting.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);

       KeyboardEvent delete = new KeyboardEvent();
       delete.setKey(KeyboardEvent.KEY_D);
       delete.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

       KeyboardEvent stopDelete = new KeyboardEvent();
       stopDelete.setKey(KeyboardEvent.KEY_D);
       stopDelete.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);

       KeyboardEvent save = new KeyboardEvent();
       save.setKey(KeyboardEvent.KEY_S);
       save.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

       KeyboardEvent load = new KeyboardEvent();
       load.setKey(KeyboardEvent.KEY_L);
       load.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);


       keyboard.addEventListener(save);
       keyboard.addEventListener(load);
       keyboard.addEventListener(stopDelete);
       keyboard.addEventListener(delete);
       keyboard.addEventListener(paint);
       keyboard.addEventListener(left);
       keyboard.addEventListener(right);
       keyboard.addEventListener(up);
       keyboard.addEventListener(down);
       keyboard.addEventListener(stopPaiting);

   }

    public void paint(){
        Cell cell = grid.getList()[y][x];
        cell.changeColor();
    }

    public void delete(){
        Cell cell = grid.getList()[y][x];
        cell.resetColour();
    }

    private void dIsPressed(){
        if(isDeleting){
            delete();
        }

    }

    private void cellStatus(){
        if (isPressed){
            paint();
        }
    }


    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
       switch (keyboardEvent.getKey()){
           case KeyboardEvent.KEY_LEFT:
               moveLeft();
               cellStatus();
               dIsPressed();
                break;
           case (KeyboardEvent.KEY_RIGHT):
               moveRight();
               cellStatus();
               dIsPressed();
               break;
           case (KeyboardEvent.KEY_DOWN):
               moveDown();
               cellStatus();
               dIsPressed();
               break;
           case (KeyboardEvent.KEY_UP):
               moveUp();
               cellStatus();
               dIsPressed();
               break;
           case(KeyboardEvent.KEY_P):
               paint();
               isPressed=true;
               break;
           case(KeyboardEvent.KEY_D):
               delete();
               isDeleting=true;
               break;
           case(KeyboardEvent.KEY_L):
               grid.loadFile();
               break;
           case(KeyboardEvent.KEY_S):
               grid.saveFile();
       }

    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

        switch(keyboardEvent.getKey()){
            case KeyboardEvent.KEY_P :
                isPressed = false;
                break;
            case KeyboardEvent.KEY_D:
                isDeleting = false;
                break;

        }

    }



}
