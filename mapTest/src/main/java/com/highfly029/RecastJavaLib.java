package com.highfly029;

import java.io.File;
import java.util.List;

import com.seasun.navmesh.RecastLib;

/**
 * @ClassName RecastJavaLib
 * @Description TODO
 * @Author liyunpeng
 * @Date 2019/3/20/020 11:46
 **/
public class RecastJavaLib {
    public static void main(String[] args) {
        RecastLib recast = new RecastLib();
        //srv_CAIBakedNavmesh 1.72,3.57,30 addNum=6 raycast
        //2_DongXue_02_Navmesh 117,30,259
        //2_YiDouCun_Navmesh 8,19.26,10
        //2_YueYeCheng_01_Navmesh 277,23.22,261
        String path = new File(
                Thread.currentThread().getContextClassLoader().getResource("2_YueYeCheng_01_Navmesh.navmesh").getFile())
                .getAbsolutePath();
        int meshId = recast.load(path);
        if (meshId <= 0) {
            System.out.println("load navmesh failed");
        } else {
            System.out.println("load navmesh sucess meshId="+meshId);
        }

        float[] start = new float[3];
        start[0] = 277f;
        start[1] = 23.22f;
        start[2] = 261f;

        float[] end = new float[3];
        end[0] = 32.76521f;
        end[1] = 2.299392f;
        end[2] = -5.955514f;

        int addNum = 1;

        List<float[]> list = recast.find(meshId, start[0], start[1], start[2], start[0]+addNum, start[1], start[2]+addNum);
        if (list != null) {
            for (float[] l : list) {
                System.out.println("find paths:" + l[0] + " " + l[1] + " " + l[2]);
            }
        }


        List<float[]> list2 = recast.raycast(meshId, start[0], start[1], start[2], start[0]+addNum, start[1], start[2]);
        if (list2 != null) {
            for (float[] l : list2) {
                System.out.println("raycast paths:" + l[0] + " " + l[1] + " " + l[2]);
            }
        }
    }
}
