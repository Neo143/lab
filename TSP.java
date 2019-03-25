public class TSP {
public static int n=4;
public static int dist[][] = {
{0,8,12,25},
{8,0,21,10},
{12,21,0,30},
{25,10,30,0}
};
public static int VISITED_ALL = (1<<n) -1;
public static int[][] dp =new int[16][4];
public static void main(String args[]) {
for(int i=0; i< (1<<n); i++) {
for(int j=0; j<n; j++) {
dp[i][j]=-1;
}
}
System.out.println("The minimum cost is : "+tsp(1,0));
}
public static int tsp(int mask,int pos) {
if(mask==VISITED_ALL)
return dist[pos][0];
if(dp[mask][pos]!=-1)
return dp[mask][pos];
int ans = Integer.MAX_VALUE;
for(int city=0; city<n ;city++) {
if((mask & (1<<city))==0) {
int newAns = dist[pos][city] + tsp(mask|(1<<city),city);
ans=Math.min(ans,newAns);
}
}
return dp[mask][pos] = ans;
}
}