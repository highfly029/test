package com.highfly029;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Pb2JavaBean
 * @Description TODO
 * @Author liyunpeng
 * @Date 2019/3/27/027 16:11
 **/
public class Pb2JavaBean {
    public static final String protoFile = "playerDataInDb.proto";

    public static void execute() throws IOException {
        String classPathStr = Pb2JavaBean.class.getResource("/").getPath();
        String fileName = classPathStr+protoFile;
        System.out.println(fileName);
        FileInputStream fis = new FileInputStream(fileName);
        InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
        BufferedReader br = new BufferedReader(isr);
        String line;
        ArrayList<String> content = new ArrayList<>();
        while ((line = br.readLine()) != null) {
            content.add(line);
        }
        br.close();
        isr.close();
        fis.close();
        parseContent(content);

    }

    public static void parseContent(List<String> content) {
        for (int i = 0; i < content.size(); i++) {
            System.out.println(content.get(i));
        }
    }
}
