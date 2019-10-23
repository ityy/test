package cn.yang.arithmetic;

import java.util.ArrayList;
import java.util.List;

public class Queens {

    static List<List<String>> result = new ArrayList<>();
    static List<String>       ans    = new ArrayList<>();


    public static void main(String[] args) {
        int n = 4;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append("*");
        }
        queens(n, 0, new boolean[n], new boolean[2 * n - 1], new boolean[2 * n - 1], sb);

        StringBuilder line = new StringBuilder();
        for (int i = 0; i < n + 2; i++) {
            line.append("-");
        }
        System.out.println(line.toString());
        for (List<String> strings : result) {
            for (String string : strings) {
                System.out.println(" " + string);
            }
            System.out.println(line.toString());
        }
        System.out.println("共有" + result.size() + "个解");
    }


    private static void queens(int size, int row, boolean[] cols, boolean[] leftDiagonal, boolean[] rightDiagonal, StringBuilder sb) {
        if (row == size) {
            result.add(new ArrayList<>(ans));
            return;
        }
        for (int col = 0; col < size; col++) {
            if (cols[col] == true || leftDiagonal[row - col + size - 1] == true || rightDiagonal[row + col] == true) {
                continue;
            }
            cols[col] = leftDiagonal[row - col + size - 1] = rightDiagonal[row + col] = true;
            ans.add(new StringBuilder(sb).replace(col, col + 1, "Q").toString());
            queens(size, row + 1, cols, leftDiagonal, rightDiagonal, sb);
            ans.remove(row);//这一行的答案删掉，继续找这一行的下一个列
            cols[col] = leftDiagonal[row - col + size - 1] = rightDiagonal[row + col] = false;//同时解除攻击范围
        }
    }

}
