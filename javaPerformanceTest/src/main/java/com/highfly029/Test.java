package com.highfly029;

/**
 * @ClassName Test
 * @Description 类引用性能检测
 * test        tmpms	tmp1ms	tmp2ms	tmpNewms
 * 100000000L 	31 		28		26		27
 * 1000000000L	241		238		236		237
 * @Author liyunpeng
 * @Date 2019/4/16/016 10:09
 **/
public class Test {
    private int a;
    private int[] b;
    private TestObj obj;

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int[] getB() {
        return b;
    }

    public void setB(int[] b) {
        this.b = b;
    }

    public TestObj getObj() {
        return obj;
    }

    public void setObj(TestObj obj) {
        this.obj = obj;
    }

    public static void main(String[] args) {
        long num = 1000000000L;
//        long num = 1L;
        long startTime = System.currentTimeMillis();
        TestObj obj = new TestObj();
        obj.setObjA((short) 1);
        obj.setObjB(new short[]{1, 2, 3, 4, 5});

        Test test = new Test();
        test.setA(10);
        test.setB(new int[]{10, 20, 30, 40, 50});
        test.setObj(obj);
        int testA = test.getA();
        int testB = test.getB()[0];
        TestObj testObj = test.getObj();
        int objA = testObj.getObjA();
        int objB = testObj.getObjB()[0];
        int[] tmpB = test.getB();
        short[] tmpObjB = testObj.getObjB();

        for (long i = 0; i < num; i++) {
//            int tmp = test.getA() + test.getB()[0] + test.getObj().getObjA() + test.getObj().getObjB()[0];
//            int tmp1 = testA +testB + testObj.getObjA() + testObj.getObjB()[0];
//            int tmp2 = testA + testB + objA + objB;
            int tmpNew = testA + tmpB[0] + objA + tmpObjB[0];
//            System.out.println(tmp);
        }
        long endTime = System.currentTimeMillis();
        long time = endTime - startTime;
        System.out.println("time="+time);
    }
}

class TestObj {
    private short objA;
    private short[] objB;

    public short getObjA() {
        return objA;
    }

    public void setObjA(short objA) {
        this.objA = objA;
    }

    public short[] getObjB() {
        return objB;
    }

    public void setObjB(short[] objB) {
        this.objB = objB;
    }
}