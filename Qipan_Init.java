import java.util.Scanner;


public class Qipan_Init {
	final static int N = 15;		//棋盘边长
	static String s[][]=new String[N][N];
	static String s1=" +"; 		//棋盘
	static String s2=" O";	//棋子类型
	static String s3=" K";	//棋子类型
	public int px=0;		//棋子坐标，整数1~N
	public static boolean Win=false;	//赢了吗
	static int num_five=1;			//几个棋子同线呢？
	
	public void Init_qipan()	//给棋子赋值
	{
		for(int i=0;i<N;i++)
		{
			for(int j=0;j<N;j++)
			{
				s[i][j]=s1;
				//System.out.print(s[i][j]);
			}
			//System.out.print("\n");
		}
	}
	
	public void Draw_qipan()		//画棋盘棋子
	{
		for(int i=0;i<N;i++)
		{
			for(int j=0;j<N;j++)
			{
				System.out.print(s[i][j]);
			}
			System.out.print("\n");
		}
	}
	
	public int GetPosition()		//输入落棋子位置坐标
	{
		Scanner sc=new Scanner(System.in);
		String str=sc.nextLine();

		try
		{
			px=Integer.parseInt(str);
		}catch(Exception e)
		{
			System.out.print(e);
		}
		//sc.close();
		return px;
	}
	
	public static boolean Win_or_not(int a, int b)		//a , b 表示棋盘坐标，从1到N
	{
		int n_v=0,n_h=0,n_r_d=0,n_r_u=0;		//分别表示垂直、水平、左上方、右上方
		String token=s[a-1][b-1];

		int tmpa=a,tmpb=b;//tep=a
		boolean line=true;//连续则true,否则false
		//判断竖着向上
		while(tmpa-1>0&&line)
		{
			if(s[tmpa-1-1][tmpb-1]==token)
			{
				n_v++;
				tmpa--;
			}
			else
			{
				line=false;
			}
		}
		//判断右上方
		tmpa=a;
		tmpb=b;
		line=true;
		while((tmpa-1-1>=0)&&(tmpb-1+1<N)&&line)
		{
			if(s[tmpa-1-1][tmpb-1+1]==token)
			{
				n_r_u++;
				tmpa--;
				tmpb++;				
			}
			else
			{
				line=false;
			}
		}
		//判断右方
		tmpa=a;
		tmpb=b;
		line=true;
		while((tmpa-1>=0)&&(tmpb-1+1<N)&&line)
		{
			if(s[tmpa-1][tmpb-1+1]==token)
			{
				n_h++;
				//tmpa--;
				tmpb++;				
			}
			else
			{
				line=false;
			}
		}
		//判断右下方
		tmpa=a;
		tmpb=b;
		line=true;
		while((tmpa-1+1<N)&&(tmpb-1+1<N)&&line)
		{
			if(s[tmpa-1+1][tmpb-1+1]==token)
			{
				n_r_d++;
				tmpa++;
				tmpb++;				
			}
			else
			{
				line=false;
			}
		}
		//判断向下
		tmpa=a;
		tmpb=b;
		line=true;
		while(tmpa-1+1<N&&line)
		{
			if(s[tmpa-1+1][tmpb-1]==token)
			{
				n_v++;
				tmpa++;
				//System.out.println(n_v);
			}
			else
			{
				line=false;
			}
		}
		
		//判断左下
		tmpa=a;
		tmpb=b;
		line=true;
		while((tmpa-1+1<N)&&(tmpb-1-1>=0)&&line)
		{
			if(s[tmpa-1+1][tmpb-1-1]==token)
			{
				n_r_u++;
				tmpa++;
				tmpb--;				
			}
			else
			{
				line=false;
			}
		}
		
		//判断左
		tmpa=a;
		tmpb=b;
		line=true;
		while((tmpa-1>=0)&&(tmpb-1-1>=0)&&line)
		{
			if(s[tmpa-1][tmpb-1-1]==token)
			{
				n_h++;
				//tmpa--;
				tmpb--;				
			}
			else
			{
				line=false;
			}
		}
		
		//判断左上
		tmpa=a;
		tmpb=b;
		line=true;
		while((tmpa-1-1>=0)&&(tmpb-1-1>=0)&&line)
		{
			if(s[tmpa-1-1][tmpb-1-1]==token)
			{
				n_r_d++;
				tmpa--;
				tmpb--;				
			}
			else
			{
				line=false;
			}
		}
		//判断是否有5连
		if(n_v>=4||n_h>=4||n_r_d>=4||n_r_u>=4)
		{
			return true;
		}
		else
		{
			return false;
		}
		
	}
	
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		Qipan_Init qp=new Qipan_Init();
		qp.Init_qipan();
		qp.Draw_qipan();
		
		int n1=0,n2=0,k=0;
		do
		{	
			if(k%2==0)
			{
				System.out.println("~~~现在由Jack落棋~~~");
			}
			else
			{
				System.out.println("~~~现在由Rose落棋~~~");
			}
			
			System.out.println("请输入1~"+N+"的整数，"+"input X:");
			n1=qp.GetPosition();
			if(n1>15||n1<1)
			{
				System.out.println("你的输入超出X范围，重新输入X与Y坐标");
				continue ;
			}			
			System.out.println("请输入1~"+N+"的整数，"+"input Y:");
			n2=qp.GetPosition();
			if(n2>15||n2<1)
			{
				System.out.println("你的输入超出Y范围，重新输入X与Y坐标");
				continue ;
			}
			
			if(Qipan_Init.s[n1-1][n2-1]!=s1)
			{
				System.out.println("这个位置已经被占了，请重新输入落棋坐标");
				continue ;
			}
			
			if(k%2==0)
			{
				Qipan_Init.s[n1-1][n2-1]=s2;
				qp.Draw_qipan();
				//判断落棋后是否有人赢了
				Win=Win_or_not(n1,n2);
				if(Win)
				{
					System.out.print("恭喜，Jack赢了！");
				}				
			}
			else
			{				
				Qipan_Init.s[n1-1][n2-1]=s3;
				qp.Draw_qipan();
				//判断落棋后是否有人赢了
				Win=Win_or_not(n1,n2);
				if(Win)
				{
					System.out.print("恭喜，Rose赢了！");
				}				
			}
						
			k++;
		}while(1==1&&Win==false);
			
	}

}
