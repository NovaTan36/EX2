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

        toSort(numbers,0,numbers.length-1);

        for (int number : numbers) {
            System.out.print(number);
            System.out.print(",");
        }
        System.out.println();
    }
    private void toSort(int[] numbers,int in,int to)
    {
        if (in!=to)
        {
            int flag =(to+in)/2;
            int flagNum=numbers[flag];
            numbers[flag]=numbers[in];
            boolean f=true;
            for (int i=in,j=to;i<=j;)
            {
                if (i==j)
                {
                    numbers[i]=flagNum;
                    if(i-1>=0){
                        toSort(numbers,0,i-1);
                    }
                    if(i+1<=to)
                    {
                        toSort(numbers,i+1,to);
                    }
                    break;
                }
                if(f)
                {
                    if (numbers[j]<flagNum)
                    {
                        numbers[i]=numbers[j];
                        i++;
                        f=false;
                    }
                    else j--;
                }
                else {
                    if (numbers[i]>flagNum)
                    {
                        numbers[j]=numbers[i];
                        j--;
                        f=true;
                    }
                    else i++;
                }
            }
        }

    }

}
