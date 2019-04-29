package com.highfly029;

/**
 * @ClassName TmpTest
 * @Description TODO
 * @Author liyunpeng
 * @Date 2019/4/29/029 15:32
 **/
public class TmpTest {
    public static void main(String[] args) {
        int a = 1001;
        int b = 1;
        long c = a << 16;
        long d = c | b;
        System.out.println("d="+d);
    }
}
