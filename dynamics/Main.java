package com.company.algorithms.dynamics;
public class Main {

    public static char[][] findPath(char[][] field, int x, int y) {

        char[][] path = new char[field.length][field.length];
        char[][] memory = new char[field.length][field.length];
        int x0 = x;
        int y0 = y;

        while (x0 != 0 || y0 != 0) {
            char direction = whereFrom(field, x0, y0, memory);
            if (direction == 'N') {
                System.out.println("No way!");
            } else if (direction == 'U') {
                path[x0][y0] = 'x';
                x0 -= 1;
            } else if (direction == 'L') {
                path[x0][y0] = 'x';
                y0 -= 1;
            }
        }
        return path;
    }

    public static char whereFrom(char[][] field, int x, int y, char[][] memory) {

        if (y > 0) {
            int left_y = y - 1;

            if (left_y == 0 && x == 0) {
                memory[x][y] = 'L';
                return 'L';
            }
            if (field[x][left_y] != '*') {
                if (whereFrom(field, x, left_y, memory) != 'N') {
                    memory[x][y] = 'L';
                    return 'L';
                }
            }
        }

        if (x > 0) {
            int up_x = x - 1;

            if (y == 0 && up_x == 0) {
                memory[x][y] = 'U';
                return 'U';
            }
            if (field[up_x][y] != '*') {
                if (whereFrom(field, up_x, y, memory) != 'N') {
                    memory[x][y] = 'U';
                    return 'U';
                }
            }
        }
        memory[x][y] = 'N';
        return 'N';
    }

    public static void main(String[] args) {
        char[][] field = {
                {'Щ', '-', '-', '*', '*', '-', '-', '-', '-', '-'},
                {'-', '*', '-', '-', '*', '-', '*', '*', '-', '-'},
                {'-', '*', '-', '*', '-', '*', '-', '-', '-', '*'},
                {'-', '*', '-', '-', '-', '-', '-', '-', '-', '-'},
                {'-', '-', '-', '-', '-', '-', '*', '-', '-', '-'},
                {'-', '-', '*', '-', '-', '*', '-', '-', '-', '-'},
                {'-', '-', '-', '*', '*', '-', '-', '-', '-', '-'},
                {'-', '-', '-', '*', '*', '-', '-', '-', '-', '-'},
                {'-', '-', '-', '*', '*', '-', '-', '-', '-', '-'},
                {'-', '-', '-', '*', '*', '-', '-', '-', '-', '-'}
        };
        char[][] chars = findPath(field, 3, 8);

        for (int i = 0; i < chars.length; i++) {
            for (int j = 0; j < chars[i].length; j++) {
                System.out.print(chars[i][j]);
            }
            System.out.println();
        }
    }
}

