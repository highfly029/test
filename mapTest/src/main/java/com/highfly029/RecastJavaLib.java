package com.highfly029;

import java.io.File;
import java.util.List;

/**
 * @ClassName RecastJavaLib
 * @Description TODO
 * @Author liyunpeng
 * @Date 2019/3/20/020 11:46
 **/
public class RecastJavaLib {
    public static void main(String[] args) {
        GameNativeLibrary recast = new GameNativeLibrary();
        //srv_CAIBakedNavmesh 1.72,3.57,30 addNum=6 raycast
        //2_DongXue_02_Navmesh 117,30,259
        //2_YiDouCun_Navmesh 8,19.26,10
        //2_YueYeCheng_01_Navmesh 277,23.22,261
        //srv_unity_test
        String path = new File(
                Thread.currentThread().getContextClassLoader().getResource("srv_unity_test.navmesh").getFile())
                .getAbsolutePath();
        int meshId = recast.load(path);
        if (meshId <= 0) {
            System.out.println("load navmesh failed");
        } else {
            System.out.println("load navmesh sucess meshId="+meshId);
        }

//        float[] start = new float[3];
//        start[0] = 277f;
//        start[1] = 23.22f;
//        start[2] = 261f;
//
//        float[] end = new float[3];
//        end[0] = 32.76521f;
//        end[1] = 2.299392f;
//        end[2] = -5.955514f;

        int addNum = 1;

//        List<float[]> list = recast.find(meshId, start[0], start[1], start[2], start[0]+addNum, start[1], start[2]+addNum);
//        if (list != null) {
//            for (float[] l : list) {
//                System.out.println("find paths:" + l[0] + " " + l[1] + " " + l[2]);
//            }
//        }
//
//
//        List<float[]> list2 = recast.raycast(meshId, start[0], start[1], start[2], start[0]+addNum, start[1], start[2]);
//        if (list2 != null) {
//            for (float[] l : list2) {
//                System.out.println("raycast paths:" + l[0] + " " + l[1] + " " + l[2]);
//            }
//        }

        float[] myStart = new float[3];
        myStart[0] = 0.4f;
        myStart[1] = 0.1f;
        myStart[2] = 0.4f;

        float[] myEnd = new float[3];
        myEnd[0] = 0.4f;
        myEnd[1] = 0.1f;
        myEnd[2] = 100.4f;

        //通过测试，发现raycast明显用时比较少 10000次raycast调用耗时3ms
        /**
         * 10000次调用 raycast耗时3ms find耗时23ms
         * 100000次调用 raycast耗时27ms find耗时193ms
         */
        long testNum = 1;


        //find 返回null找不到路径 实际调用的findStraightPath
        long beginTime  = System.currentTimeMillis();
        for (long i = 0; i < testNum; i++) {
            List<float[]> list = recast.find(meshId, myStart[0], myStart[1], myStart[2], myEnd[0], myEnd[1], myEnd[2]);
            if (list != null) {
                for (float[] l : list) {
                    System.out.println("find paths:" + l[0] + " " + l[1] + " " + l[2]);
                }
            } else {
                System.out.println("find paths null");
            }
        }
        long endTime = System.currentTimeMillis();
//        System.out.println("find cost time="+(endTime-beginTime));


        //raycast 返回null没有碰撞到可以走，如果返回数值，则为碰撞点。 实际调用的是raycast
        beginTime = System.currentTimeMillis();
        for (long i = 0; i < testNum; i++) {
            List<float[]> list2 = recast.rayCast(meshId, myStart[0], myStart[1], myStart[2], myEnd[0], myEnd[1], myEnd[2]);
            if (list2 != null) {
                for (float[] l : list2) {
                    System.out.println("raycast paths:" + l[0] + " " + l[1] + " " + l[2]);
                }
            } else {
                System.out.println("raycast paths null");
            }
        }
        endTime = System.currentTimeMillis();
//        System.out.println("raycast cost time="+(endTime-beginTime));
    }
}
