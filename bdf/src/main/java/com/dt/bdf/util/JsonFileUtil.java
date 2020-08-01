package com.dt.bdf.util;

import com.alibaba.fastjson.JSON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

public class JsonFileUtil {
    public static <T> List<T> readList(InputStream inputStream, Class<T> clazz) throws IOException {

        BufferedReader tBufferedReader = new BufferedReader(new InputStreamReader(inputStream));

        StringBuilder sb = new StringBuilder();

        String sTempOneLine;

        while ((sTempOneLine = tBufferedReader.readLine()) != null) {

            sb.append(sTempOneLine);

        }

        return JSON.parseArray(sb.toString(), clazz);

    }

    public static <T> T readObject(InputStream inputStream, Class<T> clazz) throws IOException {

        BufferedReader tBufferedReader = new BufferedReader(new InputStreamReader(inputStream));

        StringBuilder sb = new StringBuilder();

        String sTempOneLine;

        while ((sTempOneLine = tBufferedReader.readLine()) != null) {

            sb.append(sTempOneLine);

        }

        return JSON.parseObject(sb.toString(), clazz);

    }

}
