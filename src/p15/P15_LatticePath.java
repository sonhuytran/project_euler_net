/**
 * 
 */
package p15;

/**
 * @author mtpham
 * 
 */
public class P15_LatticePath {

	public static void main(String[] args) {
		int N = 20;
		long[][] map = new long[N + 1][N + 1];

		for (int i = 0; i <= N; i++) {
			map[i][N] = 1;
			map[N][i] = 1;
		}

		map[N][N] = 0;

		for (int i = N - 1; i >= 0; i--) {
			for (int j = N - 1; j >= 0; j--) {
				map[i][j] = map[i][j + 1] + map[i + 1][j];
			}
		}

		System.out.println(map[0][0]);
	}
}
