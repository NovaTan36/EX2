package com.demo;

import java.util.Scanner;

public class Tromino {

    Scanner s=new Scanner(System.in);
    int n,num=0;
    int[][] q;
    public Tromino()
    {

        System.out.print("请输入棋盘为2的几次方：");
        n=s.nextInt();
        n=size(n);              //获得实际矩阵长度
        q=new int[n][n];
        System.out.print("请输入缺少的方块位置（行、列）:");
        int x=s.nextInt()-1;
        int y=s.nextInt()-1;
        q[x][y]=-1;
        filling(n,x,y,0,0);
        for (int i=0;i<n;i++)
        {
            for (int j=0;j<n;j++)
            {
                if (q[i][j]<10&&q[i][j]>0) System.out.print(0);
                System.out.print(q[i][j]);
                System.out.print(",");
            }
            System.out.println();
        }

    }
    private int size(int num)
    {
        int i=1;
        for (;num!=0;num--)
        {
            i*=2;
        }
        return i;
    }
    private int location(int size,int x,int y,int fx,int fy)      //寻找相对位置
    {
        x-=fx;
        y-=fy;
        size/=2;

        if (x>=size)
        {
            if (y<size)return 3;
            else return 4;
        }
        else
        {
            if (y<size)return 2;
            else return 1;
        }

    }

    private void filling(int s,int x,int y,int fx,int fy)   //矩阵长度、填写点x,y,相对下标修正
    {
        num++;
        int flag;
        if (s>2)flag=s/2;
        else flag=1;
        switch (location(s, x, y, fx, fy)) {
            case 1 -> {
                q[fx + flag - 1][fy + flag - 1] = q[fx + flag][fy + flag - 1] = q[fx + flag][fy + flag] = num;
                if (s / 2 != 1) {                                                               //坐落在第一象限
                    filling(s / 2, x, y, fx, fy + flag);                            //第一象限
                    filling(s / 2, fx + flag - 1, fy + flag - 1, fx, fy);             //第二象限
                    filling(s / 2, flag + fx, flag - 1 + fy, fx + flag, fy);               //第三象限
                    filling(s / 2, flag + fx, flag + fy, fx + flag, fy + flag);                   //第四象限
                }
            }
            case 2 -> {
                q[fx + flag - 1][fy + flag] = q[fx + flag][fy + flag - 1] = q[fx + flag][fy + flag] = num;
                if (s / 2 != 1) {                                                               //坐落在第二象限
                    filling(s / 2, flag - 1 + fx, flag + fy, fx, fy + flag);      //第一象限
                    filling(s / 2, x, y, fx, fy);                                               //第二象限
                    filling(s / 2, flag - 1 + fx, flag - 1 + fy, fx + flag, fy);                  //第三象限
                    filling(s / 2, flag + fx, flag + fy, fx + flag, fy + flag);   //第四象限
                }
            }
            case 3 -> {
                q[fx + flag - 1][fy + flag] = q[fx + flag - 1][fy + flag - 1] = q[fx + flag][fy + flag] = num;
                if (s / 2 != 1) {
                    filling(s / 2, flag - 1 + fx, flag + fy, fx, fy + flag);
                    filling(s / 2, flag - 1 + fx, flag - 1 + fy, fx, fy);
                    filling(s / 2, x, y, fx + flag, fy);
                    filling(s / 2, flag + fx, flag + fy, fx + flag, fy + flag);
                }
            }
            case 4 -> {
                q[fx + flag - 1][fy + flag] = q[fx + flag - 1][fy + flag - 1] = q[fx + flag][fy + flag - 1] = num;
                if (s / 2 != 1) {
                    filling(s / 2, flag - 1 + fx, flag + fy, fx, fy + flag);
                    filling(s / 2, flag - 1 + fx, flag - 1 + fy, fx, fy);
                    filling(s / 2, flag + fx, flag - 1 + fy, fx + flag, fy);
                    filling(s / 2, x, y, fx + flag, fy + flag);
                }
            }
            default -> {
            }
        }
    }
}
