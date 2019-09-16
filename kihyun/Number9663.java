package baekjoon;

import java.io.*;
import java.util.StringTokenizer;

// N-Queen 문제, 백트래킹
public class Number9663 {
    // 열
    private static boolean[] col = new boolean[14];
    // 왼쪽 아래에서 오른쪽 위로의 대각선
    private static boolean[] cross1 = new boolean[27];
    // 오른쪽 위에서 왼쪽 아래로의 대각선
    private static boolean[] cross2 = new boolean[27];
    // 총 경우의 수
    private static int cnt = 0;
    // 입력값
    private static int n;

    private void solution(int row) {
        if (row == n) {
            cnt++;
            return;
        }

        // (row, i) 좌표에 퀸을 놓을 예정
        for (int i = 0; i < n; i++) {

            // 열, 대각선1, 대각선2 상에 퀸이 하나라도 놓여져 있으면 continue
            if (col[i] || cross1[i + row] || cross2[row - i + n - 1])
                continue;

            col[i] = true;
            cross1[i + row] = true;
            cross2[row - i + n - 1] = true;

            solution(row + 1);

            col[i] = false;
            cross1[i + row] = false;
            cross2[row - i + n - 1] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // (1 ≤ N < 15)
        n = Integer.parseInt(st.nextToken());

        new Number9663().solution(0);

        StringBuilder sb = new StringBuilder();
        bw.write(sb.append(cnt).toString());
        bw.flush();
    }
}
