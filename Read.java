package 实验4;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.List;
public class Read {
   static String q=null;
   static String m=null;
   static FileWriter writer;
   static char [] r=new char[999999];
   static int f=0;
   static int b=0;
   static char ch='a';
   static String[] a= new String[10000000];
   static String strs=null;
    public static int count(String src, String find) {
        int count = 0;
        int index = 0;
        while ((index = src.indexOf(find, index)) != -1) {
            index = index + find.length();
            count++;
        }
        return count;
    }

    public static String dispose(String fPath)
    {
        for (int i = 0; i<fPath.length(); i = i+7) {
            if( i%2 == 0 ){//如果i除以2的余数不为零，为奇数个字。
                String split = fPath.substring(i, i+7);//截取字符串从i到i+7。
                m=m+split+ "，";
            }
            if( i%2 == 1 ){//如果i除以2的余数为零，为偶数个字。
                String split = fPath.substring(i, i+7);//截取字符串从i到i+7。
                m=m+split+ "。" + "\n";
            }
        }
        return m;
    }


    public static void readTxt(String fPath) {
        try {
            File file = new File(fPath);
            if(file.isFile() && file.exists()) {
                InputStreamReader ins = new InputStreamReader(new FileInputStream(file), "utf-8");
                BufferedReader bufferr = new BufferedReader(ins);
                String lineTxt = null;
                List<String> strings = new ArrayList<String>();
                while ((lineTxt = bufferr.readLine()) != null) {
                    strings.add(lineTxt);
                    q=q+lineTxt;
                    a[b]=lineTxt;
                    b++;
                }
                bufferr.close();
            } else {
                System.out.println("文件不存在!");
            }
        } catch (Exception e) {
            System.out.println("文件读取错误!");
        }

    }
    
    public static void main(String[] args) {
    
		StudentM S1 = new StudentM(); 
		System.out.println("请输入学生信息（姓名；班级；学号）");
		Scanner input = new Scanner(System.in);
		String name = input.nextLine();
		String classn = input.nextLine();
		int number = input.nextInt();
		S1.St(name, classn, number);
        Scanner sc=new Scanner(System.in);
        String filePath = "C:\\Users\\Plachta\\eclipse-workspace\\yuan.txt";
        readTxt(filePath);
        System.out.println("结果为：");
        String s = S1.St(name,classn,number)+'\n';
        String text=dispose(q.replace("null",""));
        String text2 =text.replace("null","");
        String sm = s+text2;
        try {
            FileOutputStream file = new FileOutputStream("C:\\Users\\Plachta\\eclipse-workspace\\A.txt",true);
        	byte[] bytes = sm.getBytes("UTF-8");  // 将字符串按指定编码集编码 将信息转成二进制数
        	file.write(bytes);  //将文件中的原数据覆盖
        	file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(text2);
        System.out.println("请输入想要查询的字：");
        strs=sc.next();
        int count = count(text, strs);
        System.out.println(strs + " 出现 " + count + " 次");

    }

}

