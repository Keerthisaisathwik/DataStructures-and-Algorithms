//IPL 2021 - Match Day 2  problem name
//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class Main {
    public static void main(String args[]) {
        // taking input using class Scanner
        Scanner sc = new Scanner(System.in);

        // taking total count of testcases
        int t = sc.nextInt();

        while (t-- > 0) {
            // taking total number of elements
            int n = sc.nextInt();

            // taking size of subArrays
            int k = sc.nextInt();

            // Declaring and Intializing an array of size n
            int arr[] = new int[n];

            // adding all the elements to the array
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }

            // Calling the method max_of_subarrays of class solve
            // and storing the result in an ArrayList
            ArrayList<Integer> res = new Solution().max_of_subarrays(arr, n, k);

            // printing the elements of the ArrayList
            for (int i = 0; i < res.size(); i++)
                System.out.print(res.get(i) + " ");
            System.out.println();
        }
    }
}
// } Driver Code Ends


class Solution {
    static ArrayList<Integer> max_of_subarrays(int arr[], int n, int k) {
        // Your code here
        ArrayList<Integer> list = new ArrayList<>();
        Deque<Integer> dq = new ArrayDeque<>();
        for(int i=0;i<k;i++){
            while(dq.isEmpty()==false && arr[dq.peekLast()]<arr[i])
                dq.pollLast();
            dq.offerLast(i);
        }
        list.add(arr[dq.peekFirst()]);
        for(int i=k;i<n;i++){
            while(dq.isEmpty()==false && dq.peekFirst()<i-k+1)
                dq.pollFirst();
            while(dq.isEmpty()==false && arr[dq.peekLast()]<arr[i])
                dq.pollLast();
            dq.offerLast(i);
            list.add(arr[dq.peekFirst()]);
        }
        return list;
    }
}


/*
        //priorityQueue taking so much time O(nlogn).
        if(k==1){
            ArrayList<Integer> list = new ArrayList<>();
            for(int i: arr)
                list.add(i);
            return list;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<k;i++){
            pq.add(arr[i]);        //logk
        }
        ArrayList<Integer> list = new ArrayList<>();
        list.add(pq.peek());
        for(int i=k;i<n;i++){
            pq.remove(arr[i-k]);    //logk
            pq.add(arr[i]);         //logk
            list.add(pq.peek());
        }
        return list;*/
