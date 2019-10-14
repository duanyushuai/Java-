package sixtoten;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * @ClassName practice2
 * @Description TODO
 * @Acthor Administrator
 * @Date 2019-10-12 11:37
 * @Version 1.0
 **/
public class practice2 {
    public static void main(String[] args) {

    }


    /**Test6
     * @return void
     * @Author duanyushuai
     * @Description //自定义字符输入流的包装类，通过这个包装类对底层字符
     * // 输入流进行包装，让程序通过这个包装类读取某个文本文件
     * // （例如，一个java源文件）时，能够在读取的每行前面都加上有行号和冒号。
     * @Date 16:53 2019-07-04
     * @Param []
     **/
    public static void readAndAdd() throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("a.txt"));
        int a = 0;
        String str = null;
        StringBuffer stringBuffer = new StringBuffer();
        while ((str = bufferedReader.readLine()) != null) {
            a++;
            stringBuffer.append(a).append(":").append(str);
            System.out.println(stringBuffer);
            stringBuffer.setLength(0);
        }
    }
    /** Test8
     * @Author duanyushuai
     * @Description //TODO est8–将字符串中进行反转。abcde–>edcba
     * @Date 11:40 2019-10-12
     * @Param []
     * @return void
     **/
    public static void reverse() {
        StringBuffer stringBuffer = new StringBuffer(new String("aafdfef"));
        stringBuffer.reverse();
        System.out.println(stringBuffer);
    }

    /**Tes10
     * @Author duanyushuai
     * @Description //TODO 28人买可乐喝，3个可乐瓶盖可以换一瓶可乐，那么要买多少瓶可乐，够28人喝？假如是50人，又需要买多少瓶可乐？
     * @Date 11:43 2019-10-12
     * @Param [peoplenum]
     * @return void
     **/
    public static void peoplekele(int peoplenum) {
        int kelenumber = 0;
        for (; peoplenum > 3; peoplenum = peoplenum - 4) {
            kelenumber = kelenumber + 3;
        }
        kelenumber = peoplenum + kelenumber;
        System.out.println(kelenumber);
    }
}
