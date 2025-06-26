// CREDITS https://www.geeksforgeeks.org/problems/bird-and-maximum-fruit-gathering0509/1
//         https://hackerranksolutionc.blogspot.com/2018/06/bird-and-maximum-fruit-gathering.html

/*
 * #include<stdio.h>
#include<math.h>

int maxTreeSum(int a[], int size, int windowsize)
{
   int max_so_far = 0, max_wind_start = -1;
   int i,j,sum=0;
   int w = windowsize;
   int n = size;
   for(i=0;i<n;i++){
       for(j=0;j<w;j++){
           sum=sum+a[(j+i)%n];
       }
       if(max_so_far < sum){ max_wind_start=i ;max_so_far = sum; }
       sum=0;

   }
   printf("Max sum resulting window");
   j=max_wind_start;
   
   while(w--){
        printf(" %d",a[j%n]);
        j++;
    }
    printf("\n");
   return max_so_far;
}

int main()
{
   int a[] = {2, 3, 4, 1, 2, 1, 5, 3}; //fruit values
   int n = sizeof(a)/sizeof(a[0]); // n
   int s = 3; //Bird has 3 seconds

   // As Bird has 3 seconds it can stay at node for 0.5 sec + 0.5 sec to go to 
   //next node so bird can traverse 1 node in 1 sec 
   // hence in 3 seconds bird can traverse 3 node

   int max_sum = maxTreeSum(a, n, s);
   printf("Maximum contiguous sum is %d\n", max_sum);
   return 0;
}
See code at http://ideone.com/f7IdMR

Thanks Dhaval for preparing this article.

O(NM) is time complexity for above code.

Solution 2)
Optimized Solution with DP : 

- Keep one Array of size of N
- Each index will carry the fruit value of next S values.
- Instead of Loop 
 for(i=0;i<n;i++){
       for(j=0;j<w;j++){
           sum=sum+a[(j+i)%n];
        }
 }
 */

import java.util.Scanner;

public class BirdMaxTrip {
    public static int maxFruits(int[] arr, int totalTime) {
        // code here
        // Edge case check
        if (arr == null || arr.length == 0 || totalTime <= 0) {
            return 0;
        }
        int total = 0;
        if(totalTime > arr.length)
        {
            for(int i = 0 ; i < arr.length ; i++){
                total = total + arr[i];
            }
            return total;
        }
        int i = 0;
        int sum = 0;
        while(i < totalTime){
            sum += arr[i];
            i++;
        }
        int n = arr.length;
        int maxSum = sum;
        int k = totalTime;
        for(i = 1 ; i <= n-k ; i++){
            int prevElement = arr[i-1];
            int nextElement = arr[i+k-1];

            sum = sum - prevElement + nextElement;
            maxSum = Math.max(maxSum,sum);
        }
        return maxSum;
    }

    public static void main (String[] args)
    {
        Scanner ab=new Scanner(System.in);
        int t=ab.nextInt();
        while(t-->0)
        {
            int n=ab.nextInt();
            int k=ab.nextInt();
            int arr[]=new int[n];
            for(int i=0;i<n;++i)
                arr[i]=ab.nextInt();
            System.out.println(maxFruits(arr,k));
        }
    }
}
