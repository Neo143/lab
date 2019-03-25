import java.util.Scanner;
public class GreedyKnapsack {
public static void knapsack(float m, float[] val, float[] weight, int n) {
float[] ratio = new float[n];
for(int i=0; i<n; i++)
ratio[i]=val[i]/weight[i];
for(int i=0; i<n-1; i++) {
for(int j=0; j<n-i-1;j++) {
if(ratio[j]<ratio[j+1]) {
float temp = ratio[j];
ratio[j] = ratio[j+1];
ratio[j+1] = temp;
temp = val[j];
val[j] = val[j+1];
val[j+1] = temp;
temp = weight[j];
weight[j] = weight[j+1];
weight[j+1] = temp;
}
}
}
System.out.println("Entered Items are :");
System.out.println("Value\t\tWeight");
System.out.println("-----------------------");
for(int i=0;i<n;i++)
System.out.println(val[i]+"\t\t"+weight[i]);
float[] pv = new float[n]; //Declaring & Initialising Profit Vector with 0
float tp=0; //Initialising total profit with 0
for(int i=0;i<n;i++) {
if (m - weight[i] >= 0){
tp += val[i];
pv[i] = 1 ;
m -= weight[i];
}
else{
tp += (val[i] * (m/weight[i]) );
pv[i] = m/weight[i];
m -= (weight[i] * (m/weight[i]) );
break;
}
}
System.out.println("Profit Vector");
for(float i:pv)
System.out.print(i+"\t");
System.out.println("\nTotal Profit = "+tp);
}
public static void main(String args[]) {
Scanner sc = new Scanner(System.in);
System.out.println("Enter the no.of items in a Knapsack");
int n = sc.nextInt();
float[] val = new float[n];
float[] weight = new float[n];
for(int i=0;i<n;i++) {
System.out.println("Enter Value and Weight for item "+(i+1));
val[i]=sc.nextInt();
weight[i]=sc.nextInt();
}
System.out.println("Enter the Capacity of Knapsack");
float m = sc.nextInt();
sc.close();
knapsack(m,val,weight,n);
}
}
/*
Output:-
Enter the no.of items in a Knapsack
4
Enter Value and Weight for item 1
1 2
Enter Value and Weight for item 2
2 3
Enter Value and Weight for item 3
5 4
Enter Value and Weight for item 4
6 5
Enter the Capacity of Knapsack
8
Entered Items are :
Value Weight
-----------------------
5.0 4.0
6.0 5.0
2.0 3.0
1.0 2.0
Profit Vector
1.0 0.8 0.0 0.0
Total Profit = 9.8
*/