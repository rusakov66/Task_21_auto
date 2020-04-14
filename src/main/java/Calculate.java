public class Calculate {
    // инкремент для заполнения матрицы
    int inc = 1;
    // строка с путем возвращается в тест
    String res;


    // вывод в консоль заполненной матрицы
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
            System.out.println();
        }
        System.out.println("....................THE END...........................");
    }
    // проверка - заполнена ли матрица полностью
    public boolean matrixIsFull(int[][] matrix) {
        boolean fl = true;
        for (int i = 0; i < 6; i++)
            for (int j = 0; j < 6; j++)
                if (matrix[i][j] == 0) fl = false; // если в матрице еще есть нули то есть ещё куда идти
        return fl;
    }
    // получаем координаты в матрице
    // если точка в текущеих координатах равна значению инкремента, то
    // смотрим, если соседи не равны -1 и не равны нулю, то заполняем текущим инкрементом + 1
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

    // смотрим на периметр матрицы и находим минимальное число - это самый короткий путь
    // запоминаем координаты "точки выхода"
    public void analysis(int[][] matrix) {
        res = "";
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
        System.out.println("------------------------------------------------------");
        // вызываем рекурсивную процедуру поиска из "точки выхода" к точке со знасеним инкремента 1
        path(minX, minY, min, matrix);
    }

    public void path(int x, int y, int inc, int[][] matrix) {
        res = "(" + y + ", " + x + "); " + res;
        System.out.println("Path = " + y + ", " + x + ";");
        // если значение в текущей точке равно 1 то дошли до начальной точки и возвращаемся
        if (inc == 1) return;
        // если находимся в угловой точке, то обрабатываем только двух соседей
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
        // если находимся на одной из границ, то обрабатываем трех сосоедей
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
        // в конечном случае, обрабатываем всех сосоедей
        if (matrix[x + 1][y] == inc - 1 & matrix[x + 1][y] != -1) path(x + 1, y, inc - 1, matrix);
        if (matrix[x][y + 1] == inc - 1 & matrix[x][y + 1] != -1) path(x, y + 1, inc - 1, matrix);
        if (matrix[x][y - 1] == inc - 1 & matrix[x][y - 1] != -1) path(x, y - 1, inc - 1, matrix);
        if (matrix[x - 1][y] == inc - 1 & matrix[x - 1][y] != -1) path(x - 1, y, inc - 1, matrix);
    }

    public String trip(int[][] matrix) {
        matrix[4][3] = 1;
        inc = 1;
        // обходим весь массив пока не заполним его
        while (!matrixIsFull(matrix) & inc < 36) {
            for (int i = 0; i < 6; i++)
                for (int j = 0; j < 6; j++)
                    neighbor(i, j, matrix);
            inc = inc + 1;
        }
        // обходим периметр и затем находим путь
        analysis(matrix);
        print(matrix);
        return res;

    }
}