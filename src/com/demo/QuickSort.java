package com.demo;

import java.util.Scanner;

public class QuickSort {

    int[] numbers;
    Scanner s =new Scanner(System.in);

    public QuickSort()
    {
        System.out.print("请输入需要排列的总数：");
        numbers =new int[s.nextInt()];
        System.out.println("请输入需要排列的数字（空格分割）：");
        for (int i=0;i<numbers.length;i++)
        {
            numbers[i]=s.nextInt();
        }

    }
    private void toSort(int[] numbers,int in,int to)
    {
        int flag =(to+in)/2;
        int c;
        int flagNum=numbers[flag];
        if(numbers[0]>flagNum)numbers[flag]=numbers[0];
        for (int i=in,j=to;i<=j;)
        {

        }
    }

}
