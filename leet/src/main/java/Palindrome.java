public class Palindrome {

    public String longestPalindrome(String s) {
        if (s.equals(""))
            return "";
        String origin = s;
        String reverse = new StringBuffer(s).reverse().toString();
        int length = s.length();
        int[][] arr = new int[length][length];
        int maxLen = 0;
        int maxEnd = 0;
        for (int i = 0; i < length; i++)
            for (int j = 0; j < length; j++) {
                if (origin.charAt(i) == reverse.charAt(j)) {
                    if (i == 0 || j == 0) {
                        arr[i][j] = 1;
                    } else {
                        arr[i][j] = arr[i - 1][j - 1] + 1;
                    }
                }
                /**********修改的地方*******************/
                if (arr[i][j] > maxLen) {
                    int beforeRev = length - 1 - j;
                    if (beforeRev + arr[i][j] - 1 == i) { //判断下标是否对应
                        System.out.print(i);
                        System.out.print("  ");
                        System.out.print(j);
                        System.out.println("");
                        maxLen = arr[i][j];
                        maxEnd = i;
                    }
                    /*************************************/
                }
            }
        return s.substring(maxEnd - maxLen + 1, maxEnd + 1);

    }

    public Boolean isPalindrome(int x){
        int maxDiv=10;
        if(x<0)return false;
        if(x<10)return true;
        while (x/maxDiv>=10){
            maxDiv*=10;//确定最大除数 用于取最高位整数
        }
        while (maxDiv>=10){
            int left=x/maxDiv;
            int right=x%10;
            if(left!=right)return  false;

            x=x%maxDiv/10;
            maxDiv=maxDiv/100;

        }
        return  true;
    }
}
