package io.codeforall.heapsdontlie;

public class Grid {

    public static final int PADDING = 10;

    public final int CELL_SIZE = 20;

    private int col;    // X

    private int row;    //Y


    private Cell[][] list;

    public Grid(int col, int row){
        this.col = col;
        this.row = row;
        list = new Cell[col][row];
        start();
        init();

    }


    public void init(){

        Cursor cursor = new Cursor(0,0, this);

    }

    public void start(){

        for (int i = 0; i < getRow() ; i++) {
            for(int j = 0; j< getCol(); j++) {
                list[i][j] = new Cell( j*CELL_SIZE,i*CELL_SIZE, this);
            }
        }
    }

    public int getCELL_SIZE() {
        return CELL_SIZE;
    }


    public int getCol() {
        return col;
    }


    public int getRow() {
        return row;
    }

    public Cell[][] getList(){
        return this.list;

    }

}
