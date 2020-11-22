# JAVA-experiment5
# 计191 王博涛 2019310193
# 实验内容
模拟学生作业处理
# 实验目的
掌握字符串String及其方法的使用  
掌握文件的读取/写入方法  
掌握异常处理结构  
# 业务要求
在某课上,学生要提交实验结果，该结果存储在一个文本文件A中。  
文件A包括两部分内容：  
一是学生的基本信息；  
二是学生处理后的作业信息，该作业的业务逻辑内容是：利用已学的字符串处理知识编程完成《长恨歌》古诗的整理对齐工作，写出功能方法，实现如下功能：  
>1.每7个汉字加入一个标点符号，奇数时加“，”，偶数时加“。”  
>2.允许提供输入参数，统计古诗中某个字或词出现的次数  
>3.输入的文本来源于文本文件B读取，把处理好的结果写入到文本文件A  
>4.考虑操作中可能出现的异常，在程序中设计异常处理程序  
# 实验要求
1.设计学生类（可利用之前的）；  
2.采用交互式方式实例化某学生；  
3.设计程序完成上述的业务逻辑处理，并且把“古诗处理后的输出”结果存储到学生基本信息所在的文本文件A中。  
# 实验过程
## （1）设计学生类：
学生类我选择使用了与之前实验相同的方法  
学生类为StudentM，里面包含方法：
```
	public String St(String name, String classn, int number) {
		this.name =name;
		this.classn = classn;
		this.number = number;
		return name+"     "+classn+"     "+number;
	}
```
需要用到的时候调用即可，返回姓名+班级+学号。
## （2）设计主类
主类中包含多个方法，有计数、加标点、读取这些方法，在main中，首先要实例化一个学生，让用户输入，才能实现后面的写入文档。  
```
StudentM S1 = new StudentM(); 
```
接着是用户输入部分，与之前的实验相同。声明一个变量filepath，赋值为源txt文件地址。随后调用readTxt方法，读取文件。
```
        String filePath = "C:\\Users\\Plachta\\eclipse-workspace\\yuan.txt";
        readTxt(filePath);
```
在保存文件时，用try进行异常处理，`file.write(bytes);`语句可以实现覆盖文本，bytes为`byte[] bytes = sm.getBytes("UTF-8");`是将sm转化为二进制。最后关闭文件。  
如果出现错误，则会在命令行打印异常信息在程序中出错的位置及原因。这是e.printStackTrace()方法的作用。  
然后是调用计数方法，返回次数，打印出来。这些方法在下面解释。
## （3）编写count方法
>count方法为计数方法，使用循环语句和indexOf()方法，查找用户输入的字符串是否在文本中，如果出现则记一个数，最后返回一个数字。
```
        while ((index = src.indexOf(find, index)) != -1) {
            index = index + find.length();
            count++;
        }
```
## (4)编写dispose方法
>dispose方法为加标点方法，根据诗歌断句规律，在合适的位置加入标点，诗歌的词每句都应该一样的字数，所以统计出该断句的地方，并且判断奇偶就可以实现。  
```
 for (int i = 0; i<fPath.length(); i = i+7) {
            if( i%2 == 0 ){//如果i除以2的余数不为零，为奇数个字。
                String split = fPath.substring(i, i+7);//截取字符串从i到i+7。
                m=m+split+ "，";
```
这是判断奇数个字，加逗号的语句。
## （5）编写readTxt方法
>readTxt方法为读取文件方法，main中传入fPath，为文件地址，经查询，学会了读取文件的编写。当然还要加上异常处理。我觉得很重要，会写在核心代码处。
# 流程图
![实验结果截图](https://github.com/plachta2/JAVA-experiment4/raw/main/流程1.png)
# 核心代码
```
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
```
以上是读取文件方法的代码，很重要。
# 实验结果
![实验结果截图](https://github.com/plachta2/JAVA-experiment4/raw/main/结果1.png)
# 实验感想
这次实验主要使用了文件的读取和保存，经过网上的资料查询，学会并仿写了一些代码，我觉得这些虽然很格式化，但还是很重要。其次是对奇偶字插入标点的判断，训练了我的循环编写能力，以及字符串处理能力。异常处理仍旧非常重要，可以让用户直观感受到哪里出现了问题。  
还有在编写过程中出现的问题， 例如`char [] r=new char[999999];`长度要够长。以及`String text2 =text.replace("null","");`用replace()方法删除字符串中的指定字符，起到了很大作用。  
实验比之前轻松，但是不缺严谨性是做不出来的，我已经体会到了这点，并反复修改多次。
