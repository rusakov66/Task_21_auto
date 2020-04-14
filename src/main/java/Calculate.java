public class Calculate {
    int inc = 1;
    String res = "";


    // Распечатка матрицы (использовалась для отладки)
    public void print(int[][] matrix) {
        System.out.print("   ");
        for (int i = 0; i < matrix.length; i++)
            System.out.printf("%4d", i);
        System.out.println("\r\n------------------------------------------------------");
        for (int i = 0; i < matrix.length; i++) {
            System.out.print(i + " |");
            for (int j = 0; j < matrix.length; j++) {
                System.out.printf("%4d", matrix[i][j]);
            }
            System.out.println(" Increment = " + inc);
        }
        System.out.println("......................................................");
    }

    public boolean matrixIsFull(int[][] matrix) {
        boolean fl = true;
        for (int i = 0; i < 6; i++)
            for (int j = 0; j < 6; j++)
                if (matrix[i][j] == 0) fl = false; // если в матрице еще есть нули то есть ещё куда идти
        return fl;
    }

    public void neighbor(int x, int y, int[][] matrix) {
        if (matrix[x][y] == inc) {
            if (x == 0 & y == 0) {
                if (matrix[x + 1][y] == 0 & matrix[x + 1][y] != -1) matrix[x + 1][y] = inc + 1;
                if (matrix[x][y + 1] == 0 & matrix[x][y + 1] != -1) matrix[x][y + 1] = inc + 1;
                return;
            }
            if (x == 0 & y == 5) {
                if (matrix[x + 1][y] == 0 & matrix[x + 1][y] != -1) matrix[x + 1][y] = inc + 1;
                if (matrix[x][y - 1] == 0 & matrix[x][y - 1] != -1) matrix[x][y - 1] = inc + 1;
                return;
            }
            if (x == 5 & y == 5) {
                if (matrix[x - 1][y] == 0 & matrix[x - 1][y] != -1) matrix[x - 1][y] = inc + 1;
                if (matrix[x][y - 1] == 0 & matrix[x][y - 1] != -1) matrix[x][y - 1] = inc + 1;
                return;
            }
            if (x == 5 & y == 0) {
                if (matrix[x - 1][y] == 0 & matrix[x - 1][y] != -1) matrix[x - 1][y] = inc + 1;
                if (matrix[x][y + 1] == 0 & matrix[x][y + 1] != -1) matrix[x][y + 1] = inc + 1;
                return;
            }
            if (x == 0) {
                if (matrix[x + 1][y] == 0 & matrix[x + 1][y] != -1) matrix[x + 1][y] = inc + 1;
                if (matrix[x][y + 1] == 0 & matrix[x][y + 1] != -1) matrix[x][y + 1] = inc + 1;
                if (matrix[x][y - 1] == 0 & matrix[x][y - 1] != -1) matrix[x][y - 1] = inc + 1;
                return;
            }
            if (x == 5) {
                if (matrix[x - 1][y] == 0 & matrix[x - 1][y] != -1) matrix[x - 1][y] = inc + 1;
                if (matrix[x][y + 1] == 0 & matrix[x][y + 1] != -1) matrix[x][y + 1] = inc + 1;
                if (matrix[x][y - 1] == 0 & matrix[x][y - 1] != -1) matrix[x][y - 1] = inc + 1;
                return;
            }
            if (y == 0) {
                if (matrix[x][y + 1] == 0 & matrix[x][y + 1] != -1) matrix[x][y + 1] = inc + 1;
                if (matrix[x - 1][y] == 0 & matrix[x - 1][y] != -1) matrix[x - 1][y] = inc + 1;
                if (matrix[x + 1][y] == 0 & matrix[x + 1][y] != -1) matrix[x + 1][y] = inc + 1;
                return;
            }
            if (y == 5) {
                if (matrix[x + 1][y] == 0 & matrix[x + 1][y] != -1) matrix[x + 1][y] = inc + 1;
                if (matrix[x - 1][y] == 0 & matrix[x - 1][y] != -1) matrix[x - 1][y] = inc + 1;
                if (matrix[x][y - 1] == 0 & matrix[x][y - 1] != -1) matrix[x][y - 1] = inc + 1;
                return;
            }
            if (matrix[x + 1][y] == 0 & matrix[x + 1][y] != -1) matrix[x + 1][y] = inc + 1;
            if (matrix[x][y + 1] == 0 & matrix[x][y + 1] != -1) matrix[x][y + 1] = inc + 1;
            if (matrix[x][y - 1] == 0 & matrix[x][y - 1] != -1) matrix[x][y - 1] = inc + 1;
            if (matrix[x - 1][y] == 0 & matrix[x - 1][y] != -1) matrix[x - 1][y] = inc + 1;
        }

        return;
    }


    public void analysis(int[][] matrix) {
        String s = "";
        int min = 200;
        int minX = 200;
        int minY = 200;

        for (int i = 0; i < 6; i++)
            for (int j = 0; j < 6; j++)
                if (i == 5 | i == 0 | j == 5 | j == 0)
                    if (matrix[i][j] < min & matrix[i][j] != -1) {
                        min = matrix[i][j];
                        minX = i;
                        minY = j;
                    }
        System.out.println(minX + " " + minY + " " + min + "");
        path(minX, minY, min, matrix);
    }

    public void path(int x, int y, int inc, int[][] matrix) {
        res = "(" + y + ", " + x + "); " + res;
        System.out.println("Path = " + y + ", " + x + ";");
        if (inc == 1) return;
        if (x == 0 & y == 0) {
            if (matrix[x + 1][y] == inc - 1 & matrix[x + 1][y] != -1) path(x + 1, y, inc - 1, matrix);
            if (matrix[x][y + 1] == inc - 1 & matrix[x][y + 1] != -1) path(x, y + 1, inc - 1, matrix);
            return;
        }
        if (x == 0 & y == 5) {
            if (matrix[x + 1][y] == inc - 1 & matrix[x + 1][y] != -1) path(x + 1, y, inc - 1, matrix);
            if (matrix[x][y - 1] == inc - 1 & matrix[x][y - 1] != -1) path(x, y - 1, inc - 1, matrix);
            return;
        }
        if (x == 5 & y == 5) {
            if (matrix[x - 1][y] == inc - 1 & matrix[x - 1][y] != -1) path(x - 1, y, inc - 1, matrix);
            if (matrix[x][y - 1] == inc - 1 & matrix[x][y - 1] != -1) path(x, y - 1, inc - 1, matrix);
            return;
        }
        if (x == 5 & y == 0) {
            if (matrix[x - 1][y] == inc - 1 & matrix[x - 1][y] != -1) path(x - 1, y, inc - 1, matrix);
            if (matrix[x][y + 1] == inc - 1 & matrix[x][y + 1] != -1) path(x, y + 1, inc - 1, matrix);
            return;
        }
        if (x == 0) {
            if (matrix[x + 1][y] == inc - 1 & matrix[x + 1][y] != -1) path(x + 1, y, inc - 1, matrix);
            if (matrix[x][y + 1] == inc - 1 & matrix[x][y + 1] != -1) path(x, y + 1, inc - 1, matrix);
            if (matrix[x][y - 1] == inc - 1 & matrix[x][y - 1] != -1) path(x, y - 1, inc - 1, matrix);
            return;
        }
        if (x == 5) {
            if (matrix[x - 1][y] == inc - 1 & matrix[x - 1][y] != -1) path(x - 1, y, inc - 1, matrix);
            if (matrix[x][y + 1] == inc - 1 & matrix[x][y + 1] != -1) path(x, y + 1, inc - 1, matrix);
            if (matrix[x][y - 1] == inc - 1 & matrix[x][y - 1] != -1) path(x, y - 1, inc - 1, matrix);
            return;
        }
        if (y == 0) {
            if (matrix[x][y + 1] == inc - 1 & matrix[x][y + 1] != -1) path(x, y + 1, inc - 1, matrix);
            if (matrix[x - 1][y] == inc - 1 & matrix[x - 1][y] != -1) path(x - 1, y, inc - 1, matrix);
            if (matrix[x + 1][y] == inc - 1 & matrix[x + 1][y] != -1) path(x + 1, y, inc - 1, matrix);
            return;
        }
        if (y == 5) {
            if (matrix[x + 1][y] == inc - 1 & matrix[x + 1][y] != -1) path(x + 1, y, inc - 1, matrix);
            if (matrix[x - 1][y] == inc - 1 & matrix[x - 1][y] != -1) path(x - 1, y, inc - 1, matrix);
            if (matrix[x][y - 1] == inc - 1 & matrix[x][y - 1] != -1) path(x, y - 1, inc - 1, matrix);
            return;
        }
        if (matrix[x + 1][y] == inc - 1 & matrix[x + 1][y] != -1) path(x + 1, y, inc - 1, matrix);
        if (matrix[x][y + 1] == inc - 1 & matrix[x][y + 1] != -1) path(x, y + 1, inc - 1, matrix);
        if (matrix[x][y - 1] == inc - 1 & matrix[x][y - 1] != -1) path(x, y - 1, inc - 1, matrix);
        if (matrix[x - 1][y] == inc - 1 & matrix[x - 1][y] != -1) path(x - 1, y, inc - 1, matrix);
    }

    public String trip(int[][] matrix) {
        matrix[4][3] = 1;
        inc = 1;
        while (!matrixIsFull(matrix) & inc < 36) {
            for (int i = 0; i < 6; i++)
                for (int j = 0; j < 6; j++)
                    neighbor(i, j, matrix);
            inc = inc + 1;
            print(matrix);
        }
        analysis(matrix);
        return res;

    }
}