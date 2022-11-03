import java.util.Arrays;

public class DynamicProgramming {
    public static int fibanaccirecursion(int N){
        if(N==0 || N==1) return N;
       
        return fibanaccirecursion(N-1)+fibanaccirecursion(N-2);
    }
     public static int fibmemo(int N,int arr[]){
        if(N<=1) return N;
        if(arr[N]!=0) return arr[N];
        int fib1 = fibmemo(N-1, arr);
        int fib2 = fibmemo(N-2, arr);
        int ans = fib1 + fib2;
        arr[N] = ans;
        return ans;
    }
    public static int fibDP(int N){
        int arr[] = new int[N+1];
        arr[0] = 0;
        arr[1] = 1;
        for(int i=2;i<arr.length;i++){
            arr[i] = arr[i-1]+arr[i-2];
        }
        return arr[arr.length-1];
    }
    public static int countPathsrec(int n){
        if(n == 0) return 1;
        else if(n<0) return 0;
        int path1 = countPathsrec(n-1);
        int path2 = countPathsrec(n-2);
        int path3 = countPathsrec(n-3);

        return path1+path2+path3;
    }
    public static int countPathsmemo(int n,int arr[]){
        if(n == 0) return 1;
        else if(n<0) return 0;
        if(arr[n] != 0) return arr[n];
        int path1 = countPathsrec(n-1);
        int path2 = countPathsrec(n-2);
        int path3 = countPathsrec(n-3);
        int res = path1+path2+path3;
        arr[n] = res;

        return res;
    }
    public static int countPathsDP(int N){
        int arr[] = new int[N+1];
        arr[0] = 1;
      for(int i=1;i<arr.length;i++){
         if(i==1){
            arr[i] = arr[i-1];
         }
         else if(i == 2){
            arr[i] = arr[i-1] + arr[i-2];
         }
         else{
            arr[i] = arr[i-1]+arr[i-2]+arr[i-3];
         }
      }
        return arr[arr.length-1];
    }
    public static int climbingstairswithjumpDP(int arr[]){
        int dp[] = new int[arr.length+1];
        arr[arr.length] = 1;
        for(int i=dp.length-1;i>=0;i--){
            for(int j = 1;j<=arr[i] && i+j<dp.length;j++){
                dp[i] += dp[i+j];
            }
        }
        return dp[0];
    }
    public static int sourcetodestMinJump(int arr[]){
        int n = arr.length;
        Integer dp[] = new Integer[n+1];
        dp[n] = 0;
        for(int i=n-1;i>=0;i--){
           if(arr[i] > 0){
            int min = Integer.MAX_VALUE;
             for(int j=1;j<=arr[i] && i+j<dp.length;j++){
                if(dp[i+j] != null){
               min = Math.min(dp[i+j],min);}
             }
             if(min != Integer.MAX_VALUE){
                dp[i] = min+1;
             }
           }
        }
             return dp[0];
    }
    public static int minimumcostoath(int arr[][]){
        int dp[][] = new int[arr.length][arr[0].length];
        for(int i=dp.length-1;i>=0;i--){
            for(int j = dp[i].length-1;j>=0;j--){
                if(i==dp.length-1 && j == dp[i].length-1){
                     dp[i][j] = arr[i][j];
                }
                else if(i == dp.length-1){
                   dp[i][j] = arr[i][j+1] + dp[i][j];
                }
                else if(j == dp[i].length-1){
                     dp[i][j] = dp[i][j] + arr[i+1][j];
                }
                else{
                   dp[i][j]  = Math.min(dp[i][j+1],dp[i+1][j]) + dp[i][j];
                }
            }
        }
        return dp[0][0];
    }
    public static int maxgoldPath(int arr[][]){
        int dp[][] = new int[arr.length][arr[0].length];
        for(int j = arr[0].length-1;j>=0;j--){
            for(int i=arr.length-1;i>=0;i--){
                if(j == arr[0].length-1){
                    dp[i][j] = arr[i][j];
                }
                else if(i == 0){
                  dp[i][j] = arr[i][j]+ Math.max(dp[i][j+1],dp[i+1][j+1]);
                }
                else if(i == arr[0].length-1){
                  dp[i][j] = arr[i][j] +Math.max(dp[i][j+1],dp[i-1][j+1]);
                }
                else{
                  dp[i][j] = Math.max(dp[i][j+1],Math.max(dp[i-1][j+1],dp[i+1][j+1])) + arr[i][j];
                }
            }
        }
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
        int max = dp[0][0];
        for(int i = 1;i<dp.length;i++){
            max = Math.max(dp[i][0],max);
        }
         return max;
    }
    public static int coinpermutation(int coinsarr[],int target){
        int dp[] = new int [target+1];
        dp[0] = 1;
        for(int amt = 1;amt<dp.length;amt++){
            for(int coin : coinsarr ){
                if(coin <= amt){
                    int remamt = amt - coin;
                    dp[amt] += dp[remamt];
                }
            }
        }
        return dp[dp.length-1];
    }
    public static int coinchange(int arr[],int target){
        int dp[] = new int[target+1];
        dp[0] = 1;
        for(int i= 0;i<arr.length;i++){
            for(int j = arr[i];j<dp.length;j++){
                dp[j] += dp[j - arr[i]];
            }
        }
        return dp[dp.length-1];
    }
    public static boolean subset(int arr[], int target){
        boolean dp[][] = new boolean [arr.length+1][target+1];
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                if(i==0 && j==0){
                    dp[i][j] = true;
                }
                else if(i==0){
                    dp[i][j] = false;
                }
                else if(j==0){
                    dp[i][j] = true;
                }
                else{
                    if(dp[i-1][j] == true){
                        dp[i][j] = true;
                    }
                    else{
                        int val = arr[i-1];
                        if(j>=val){
                            if(dp[i-1][j-val] == true){
                                dp[i][j] = true;
                            }
                        }
                    }

                }
            }
        }
        return dp[arr.length][target];
    }
    public static int decodeways(String s){
        int dp[] = new int[s.length()];
        dp[0] = 1;
        for(int i=1;i<s.length();i++){
            if(s.charAt(i-1) == '0' && s.charAt(i)=='0' ){ 
                   dp[i] = 0;
            }
            else if(s.charAt(i-1) == '0' && s.charAt(i)!='0'){
               dp[i] = dp[i-1];
            }
            else if(s.charAt(i-1) != '0' && s.charAt(i)=='0'){
                 if(s.charAt(i-1) == '1' || s.charAt(i-1) == '2'){
                    dp[i] = (i>=2 ? dp[i-2]:1);
                 }
                 else{
                    dp[i] = 0;
                 }
            }
            else{
                   if(Integer.parseInt(s.substring(i-1, i+1)) <= 26){
                    dp[i] = dp[i-1]+ (i>=2 ? dp[i-2]:1);
                   }
            }
        }
        return dp[s.length()-1];

    }
    public static int Knapsack(int wts[],int val[],int cap){
        int dp[] = new int[cap+1];
        dp[0] = 0;
        for(int inicap = 1;inicap <= cap;inicap++){
            int max = 0;
            for(int i=0;i<wts.length;i++){
                if(wts[i]<=inicap){
                    int remcap = inicap - wts[i];
                    int remval = dp[remcap];
                    int currval = remval + val[i];
                    if(currval>max){
                        max = currval;
                    }
                }
            }
            dp[inicap] = max;
        }
        return dp[cap];
    }
    public static int uniquePaths(int m, int n) {
        int[][] dp=new int[m][n];
        for(int i=0;i<m;i++){
            dp[i][n-1]=1;
        }
        for(int j=0;j<n;j++){
            dp[m-1][j]=1;
        }
        for(int i=m-2;i>=0;i--){
            for(int j=n-2;j>=0;j--){
                dp[i][j]=dp[i+1][j]+dp[i][j+1];
            }
        }
        return dp[0][0];
    }
   public static void main(String[] args) {
// System.out.println(fibanaccirecursion(8));
// System.out.println("------------------");
// int N = 8;
// int arr[] = new int[N+1];
// System.out.println(fibmemo(N,arr));
// System.out.println("------------------");
// System.out.println(fibDP(8));
// System.out.println(countPathsrec(8));
// int arr[] = new int[9];
// System.out.println(countPathsmemo(8,arr));
// System.out.println(countPathsDP(8));
// int arr[] = {1,1,1,4,9,8,1,1,10,1};
// // System.out.println(sourcetodestMinJump(arr));
// int arr1[][] = {{5,3,2,9},{2,10,7,19},{1,14,6,15},{9,3,22,9}};
// int arr2[][] = {{0,1,4,2,8,2},{4,3,6,5,0,4},{1,2,4,1,4,6},{2,0,7,3,2,2},{3,1,5,9,2,4},{2,7,0,8,5,1}};
// // System.out.println(minimumcostoath(arr1));
// System.out.println(maxgoldPath(arr2));
   int arr[] = {2,3,5,6};
   System.out.println(coinpermutation(arr, 10));
   System.out.println(subset(arr,20));
   System.out.println(decodeways("21123"));
   int wts[] = {2,5,1,3,4};
   int vl[] = {15,14,10,45,30};
   System.out.println(Knapsack(wts,vl,7));
   System.out.println(uniquePaths(4,4));
   } 
}

