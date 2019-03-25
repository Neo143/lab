import java.util.Scanner;
public class AllPairsShortestPath {
public static void allPairsShortestPath(int[][] cost,int v) {
int[][] A =new int[v+1][v+1]; // Copy cost into A.
for(int i=1;i<=v;i++) {
for(int j=1;j<=v;j++) {
A[i][j]=cost[i][j];
}
}
for(int k=1;k<=v;k++) {
for(int i=1;i<=v;i++) {
for(int j=1;j<=v;j++) {
A[i][j] = Math.min(A[i][j],A[i][k]+A[k][j]);
}
}
displayMatrix(A,v);
}
}
public static void displayMatrix(int[][] A,int v) {
System.out.println("New distance Matrix");
for(int i=1;i<=v;i++) {
for(int j=1;j<=v;j++) {
System.out.print(A[i][j]+" ");
}
System.out.println();
}
}
public static void main(String args[]) {
Scanner sc = new Scanner(System.in);
System.out.println("Enter No.of Vertices");
int v = sc.nextInt();
int[][] cost = new int[v+1][v+1];
for(int i=1;i<=v;i++) {
for(int j=1;j<=v;j++) {
cost[i][j]=9999;
}
cost[i][i]=0;
}
System.out.println("Enter No.of Edges");
int e = sc.nextInt();
for(int i=0;i<e;i++) {
System.out.println("Enter Starting Vertex and Ending Vertex");
int v1=sc.nextInt();
int v2=sc.nextInt();
System.out.println("Enter Cost");
cost[v1][v2]=sc.nextInt();
}
sc.close();
allPairsShortestPath(cost,v);
}
}

/*Enter No.of Vertices
3
Enter No.of Edges
5
Enter Starting Vertex and Ending Vertex
1 2
Enter Cost
4
Enter Starting Vertex and Ending Vertex
2 3
Enter Cost
2
Enter Starting Vertex and Ending Vertex
3 1
Enter Cost
3
Enter Starting Vertex and Ending Vertex
1 3
Enter Cost
11
Enter Starting Vertex and Ending Vertex
2 1
Enter Cost
6
New distance Matrix
0 4 11
6 0 2
3 7 0
New distance Matrix
0 4 6
6 0 2
3 7 0
New distance Matrix
0 4 6
5 0 2
3 7 0
*/