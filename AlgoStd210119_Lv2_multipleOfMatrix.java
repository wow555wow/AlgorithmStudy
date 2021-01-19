class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = {};
        
        int r = arr1.length;    //row of arr1
        int c = arr2[0].length; //col of arr2
        int x = arr1[0].length; //col of arr1 && row of arr2
        
        answer = new int[arr1.length][arr2[0].length];
        for(int i=0; i<arr1.length; i++) {
            for(int j=0; j<arr2[0].length; j++) {
                for(int k=0; k<arr1[0].length; k++) {
                    answer[i][j] += arr1[i][k] * arr2[k][j];
                }
            }
        }
        
        return answer;
    }
}
