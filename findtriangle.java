package DP;


import java.util.Scanner;

public class findtriangle {

	public static void main(String[] args) 
	{
		Scanner scan=new Scanner(System.in);
		int distance[][]={{0,14,25,27,10,11,24,16},{0,0,18,15,27,28,16,14},{0,0,0,19,14,19,16,10},{0,0,0,0,22,23,15,14},{0,0,0,0,0,14,13,20},{0,0,0,0,0,0,15,18},{0,0,0,0,0,0,0,27},{0,0,0,0,0,0,0,0}};
		//距离矩阵赋初值
		for(int i=0;i<distance.length;i++)
		{
			for(int j=0;j<distance[i].length;j++)
				System.out.print(distance[i][j]+" ");
			System.out.print('\n');
		}
		int best[][]=new int[8][8];//存放最优权值矩阵
		int road[][]=new int[8][8];//存放最优划分路径矩阵
		for(int i=0;i<road.length;i++)
		{
			for(int j=0;j<road[i].length;j++)
				road[i][j]=-1;
		}
		int j;
		int min;
		for(int length=1;length<best.length-1;length++)
		{
			for(int i=1;i<best.length-length;i++)
			{
				j=i+length;
				best[i][j]=best[i+1][j]+sum(i-1,i,j,distance);
				min=best[i][j];
				road[i][j]=i;
				for(int k=i+1;k<j;k++)
				{
					int number=best[i][k]+best[k+1][j]+sum(i-1,k,j,distance);
					if(number<min)
					{
						best[i][j]=number;
						min=number;
						road[i][j]=k;
					}
				}
				
			}
		}
		for(int i=0;i<best.length;i++)
		{
			for(int k=0;k<best[i].length;k++)
				System.out.print(best[i][k]+" ");
			System.out.print('\n');
		}
		traceback(1,7,road);
		for(int i=0;i<best.length;i++)
		{
			for(int k=0;k<best[i].length;k++)
				System.out.print(road[i][k]+" ");
		
			System.out.print('\n');
		}
				
		
		
		
		

	}
	static int sum(int i,int k,int j,int a[][])
	{
		return(a[i][k]+a[k][j]+a[i][j]);
	}
	static void traceback(int x,int y,int a[][])
	{
		if(y==x)
			return;
		traceback(x,a[x][y],a);
		traceback(a[x][y]+1,y,a);
		if((x!=0&&y!=7)&&(x!=7||y!=0))
		System.out.println((x-1)+" "+y);
	}

}