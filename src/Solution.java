public class Solution {
    private static final int MOD = 1000000007;
    private static final int MAX_SIZE = 26;

    public static int shortPalindrome(String s) {
        int count = 0;
        int[] freq = new int[MAX_SIZE];
        int[][] pairs = new int[MAX_SIZE][MAX_SIZE];
        int[] triplets = new int[MAX_SIZE];

        for (char c : s.toCharArray()) {
            int index = c - 'a';
            count = (count + triplets[index]) % MOD;

            for (int i = 0; i < MAX_SIZE; i++) {
                triplets[i] = (triplets[i] + pairs[i][index]) % MOD;
            }

            for (int i = 0; i < MAX_SIZE; i++) {
                pairs[i][index] = (pairs[i][index] + freq[i]) % MOD;
            }

            freq[index] = (freq[index] + 1) % MOD;
        }

        return count;
    }
}
