package com.picross;

import java.util.Random;

public class cellsMap {
    cell[][] cells;

    public cellsMap(int width, int height, int darkCells) {
        this.cells = new cell[width][height];
        Random random = new Random();
        
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                cells[i][j] = new cell(false);
            }
        }
        
        while (darkCells > 0) {
            int i = random.nextInt(width);
            int j = random.nextInt(height);

            if (!cells[i][j].isDark()) {
                cells[i][j] = new cell(true);
                darkCells--;
            }
        }
    }

    public cell getCell(int row, int column){
        return cells[row][column];
    }

    public int countDarkInRows(int row){
        int count = 0;
        for (cell[] cell : cells) {
            if (cell[row].isNotPressed() && cell[row].isDark()) {
                count++;
            }
        }
        return count;
    }

    public int countDarkInColumns(int column){
        int count = 0;
        for (int i = 0; i < cells.length; i++){
            if (cells[column][i].isNotPressed() && cells[column][i].isDark()){
                count++;
            }
        }
        return count;
    }
}