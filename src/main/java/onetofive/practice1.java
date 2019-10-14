package onetofive;

import java.io.*;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

/**
 * @ClassName practice1
 * @Description TODO
 * @Acthor Administrator
 * @Date 2019-10-12 10:26
 * @Version 1.0
 **/
public class practice1 {

    public static void main(String[] args) throws Exception {
//        numberAppearOfLetter();
        numberStringList();
    }

    /**
     * Test1
     *
     * @return void
     * @Author duanyushuai
     * @Description //取出一个字符串中字母出现的次数。如：字符串："abcdekka27qoq" ，输出格式为： a(2)b(1)k(2)
     * @Date 17:06 2019-07-02
     * @Param []
     **/
    public static void numberAppearOfLetter() {
        String str = "asdzdkljfdf1254";
        HashMap<Character, Integer> hm = new HashMap<>();
        char[] cc = str.toCharArray();
        for (char c : cc) {
            if (!hm.containsKey(c)) {
                hm.put(c, 1);
            } else {
                hm.put(c, hm.get(c) + 1);
            }
        }
        for (Character c : hm.keySet()) {
            System.out.println(c + "(" + hm.get(c) + ")");
        }
    }

    /**
     * Test3
     *
     * @return void
     * @Author duanyushuai
     * @Description //在泛型为Integer的ArrayList中存放一个String类型的对象
     * @Date 19:48 2019-07-02
     * @Param []
     **/
    public static void numberStringList() throws Exception {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            list.add(i);
        }
        String str = "wo shi zifuchuan";
        Method method = list.getClass().getMethod("add", Object.class);
        method.invoke(list, str);
        Iterator<Integer> integers = list.iterator();
        while (integers.hasNext()) {
            System.out.println(integers.next());
        }
    }

    /**
     * Test4
     *
     * @return void
     * @Author duanyushuai
     * @Description //有五个学生，每个学生有3门课（语文、数学、英语）的成绩，写一个程序接收从键盘输入学生的信息，
     * // 输入格式为：name,30,30,30（姓名，三门课成绩），然后把输入的学生信息按总分从高到低的顺序写
     * // 入到一个名称”stu.txt”文件中。要求：stu.txt文件的格式要比较直观，打开这个文件，就可以很清楚的看到学生的信息
     * @Date 20:13 2019-07-02
     * @Param []
     **/
    public static void studentInfo() {
        ArrayList<Student> stu = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 3; i++) {
            String str = sc.nextLine();
            String[] s = str.split(",");
            Student student = new Student(s[0], Integer.parseInt(s[1]), Integer.parseInt(s[2]), Integer.parseInt(s[3]));
            stu.add(student);
        }
        stu.sort((s1, s2) -> {
            Integer num1 = s1.getMath() + s1.getLanguage() + s1.getEnglish();
            Integer num2 = s2.getMath() + s2.getLanguage() + s2.getEnglish();
            return num1.compareTo(num2);
        });
        for (Student s : stu) {
            System.out.println(s);
        }
        File f = new File("a.txt");
        byte[] bytes = null;
        try {
            BufferedOutputStream bf = new BufferedOutputStream(new FileOutputStream(f, true));
            for (Student s : stu) {
                bytes = s.toString().getBytes();
                bf.write(bytes);
                bf.write("\r\n".getBytes());
            }
            bf.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**Test5
     * @return void
     * @Author duanyushuai
     * @Description 定义一个文件输入流，调用read(byte[]b)方法将exercise.txt文件中的所有内容打印出来(byte数组的大小限制为5)
     * @Date 16:30 2019-07-04
     * @Param []
     **/
    public static void readTxtPrint() throws Exception {
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream("a.txt"));
        byte[] byt = new byte[5];
        int a = 0;
        while (bufferedInputStream.read(byt) != -1) {
            System.out.print(new String(byt));
        }
        bufferedInputStream.close();
    }
}


