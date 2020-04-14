public class Program {
    public static void main(String[] args) {
        String s;
        int[][] matrix = {
                { 0, 0, 0, 0, 0, 0},
                { 0,-1, 0,-1, 0, 0},
                { 0,-1, 0, 0, 0, 0},
                {-1,-1, 0, 0,-1, 0},
                {-1, 0, 0, 1, 0,-1},
                {-1,-1,-1,-1,-1,-1}
        };


        Calculate aa = new Calculate();
        s = aa.trip(matrix);
        System.out.println(s);
    }
}
