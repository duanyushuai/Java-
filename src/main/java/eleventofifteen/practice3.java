package eleventofifteen;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @ClassName practice3
 * @Description TODO
 * @Acthor Administrator
 * @Date 2019-10-12 11:45
 * @Version 1.0
 **/
public class practice3 {
    public static void main(String[] args) {
        readFileAndCount();
    }


    /**
     * Test11
     *
     * @return void
     * @Author duanyushuai
     * @Description //TODO 编写一个类，在main方法中定义一个Map对象（采用泛型），加入若干个对象，然后遍历并打印出各元素的key和value。
     * @Date 14:20 2019-10-12
     * @Param []
     **/
    public static void mapCreate() {
        Map map = new HashMap<Object, Object>();
        map.put(1, 2);
        map.put("123", "fff");
        Set set = map.keySet();
        for (Object o : set) {
            Object obj = map.get(o);
            System.out.println(obj + "  " + o);
        }
    }
/**
 Test12–方法中的内部类能不能访问方法中的局部变量，为什么？
 当方法被调用运行完毕之后，局部变量就已消亡了。但内部类对象可能还存在，
 *             直到没有被引用时才会消亡。此时就会出现一种情况，就是内部类要访问一个不存在的局部变量。
 **/


    /**
     * Test13
     *
     * @return void
     * @Author duanyushuai
     * @Description //TODO 定义一个交通灯枚举，包含红灯、绿灯、黄灯，需要有获得下一个灯的方法，例如：红灯获取下一个灯是绿灯，绿灯获取下一个灯是黄灯。
     * @Date 14:30 2019-10-12
     * @Param []
     **/
    public static void showTraffic() {
        traffic traffic1 = traffic.RED.next();
        System.out.println(traffic1);

    }

    enum traffic {
        RED {
            public traffic next() {
                return GRE;
            }
        }, GRE {
            public traffic next() {
                return YEL;
            }
        }, YEL {
            public traffic next() {
                return RED;
            }
        };

        public abstract traffic next();
    }

    /**
     * Test14
     * @Author duanyushuai
     * @Description //TODO 编写一个类，增加一个实例方法用于打印一条字符串。并使用反射手段创建该类的对象，并调用该对象中的方法
     * @Date 14:39 2019-10-12
     * @Param []
     * @return void
     **/
    public static void usereflection() throws Exception {
        Class c = StringPrint.class;
        Constructor cs = c.getConstructor(String.class);
        StringPrint stringPrint = (StringPrint) cs.newInstance("aaaaa");
        Method method = c.getMethod("print");
        method.invoke(stringPrint);
    }


    /**
     * Test15
     * @Author duanyushuai
     * @Description //TODO 把当前文件中的所有文本拷贝，存入一个txt文件，统计每个字符出现的次数并输出，例如：a：21次b：15次c:：15次把：7次…
     * @Date 14:40 2019-10-12
     * @Param []
     * @return void
     **/
    public static void readFileAndCount() {
        try {
            BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream("src//main//java//eleventofifteen//practice3.java"));
            StringBuffer stringBuffer = new StringBuffer();
            byte[] bytes = new byte[1024];
            while (bufferedInputStream.read(bytes) != -1) {
                stringBuffer.append(new String(bytes));
            }
            char[] chars = stringBuffer.toString().toCharArray();
            Map<Character, Integer> map = new HashMap<>();
            for (char aChar : chars) {
                if (map.containsKey(aChar)) {
                    map.put(aChar, map.get(aChar) + 1);
                } else {
                    map.put(aChar, 0);
                }
            }
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream("aa.txt"));
            Set<Character> set = map.keySet();
            for (Character c : set) {
                bufferedOutputStream.write((c+":    "+map.get(c)+"次").getBytes());
                bufferedOutputStream.write("\r\n".getBytes());
            }
            bufferedOutputStream.close();
            bufferedInputStream.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
//gjg