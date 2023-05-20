import java.util.Scanner;

class Array{
    static void print(int arr[][]){
        for(int ar[] : arr){
            for(int a : ar)
                System.out.print(a+" ");
            System.out.println("");
        }
    }
    public static void main(String args[]){
        int arr[][] = new int[10][5];
        System.out.println("Enter a list in matrix a 10 x 5:");
        for(int i=0;i<10;i++)
            for(int j = 0 ; j < 5 ; j++)
                arr[i][j] = i+j+1;
        
        print(arr);

        int arr1[][] = new int[10][];
        for(int i=0;i<10;i++)
            arr1[i] = new int[(int)(Math.random()*(1+10)+1)];
        System.out.println("Enter a list in matrix a 10 x 5:");
        for(int i=0;i<arr.length;i++)
            for(int j = 0 ; j < arr1[i].length ; j++)
                arr1[i][j] = i+j+1;
        
        print(arr1);
    }
}