package com.highfly029;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
        List list1 = new ArrayList();
        List list2 = new LinkedList();
        Map map = new HashMap();
        Set set = new HashSet();
    }
}
