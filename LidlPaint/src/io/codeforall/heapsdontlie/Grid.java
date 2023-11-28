package io.codeforall.heapsdontlie;

import java.io.*;

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

    public void saveFile(){

        try {
            BufferedWriter bufferedWriter= new BufferedWriter(new FileWriter("LidlPaint/resources/paint.txt"));

            for(int i = 0; i< list.length; i++ ){
                for(int j = 0; j< list[i].length; j++){
                    if(list[i][j].isPainted()){
                        bufferedWriter.write("1");
                    }else {
                        bufferedWriter.write("0");
                    }
                }

                bufferedWriter.write("\n");

            }
            bufferedWriter.close();

        } catch (IOException e) {
            System.out.println(e);
        }

    }

    public void loadFile(){

        try {

            String line;

            BufferedReader bufferedReader = new BufferedReader(new FileReader("LidlPaint/resources/paint.txt"));

            for(int i = 0 ; i < list.length; i++){
                line= bufferedReader.readLine();
                for(int j = 0; j< list[i].length; j++ ){
                    if(line.charAt(j)=='0'){
                        list[i][j].resetColour();
                    }else{
                        list[i][j].changeColor();
                    }
                }
            }



            bufferedReader.close();

        } catch (IOException e) {
            System.out.println(e);
        }

    }


}
