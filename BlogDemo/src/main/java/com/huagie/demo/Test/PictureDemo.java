package com.huagie.demo.Test;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.drew.imaging.jpeg.JpegMetadataReader;
import com.drew.imaging.jpeg.JpegProcessingException;
import com.drew.metadata.Directory;
import com.drew.metadata.Metadata;
import com.drew.metadata.Tag;
import com.huagie.demo.utils.RequestUtils;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author ：zhangsh
 * @date ：Created in 2021/7/14 9:41
 * @description：识别图片信息
 */
public class PictureDemo {
    public static void main(String[] args) throws JpegProcessingException, IOException {
        Map<String,String> hashMap = PicAnalysis("图片路径");
        getAddress(hashMap);
    }
    //分析图片获取地址
    public static  Map<String,String> PicAnalysis(String path) throws JpegProcessingException, IOException {
        Map<String,String> map = new HashMap();
        System.out.println("强大的语言正在识别图片地址...");
        File picFile = new File(path);
        Metadata metadata = JpegMetadataReader.readMetadata(picFile);
        Iterator<Directory> it = metadata.getDirectories().iterator();
        while (it.hasNext()) {
            Directory exif = it.next();
            Iterator<Tag> tags = exif.getTags().iterator();
            while (tags.hasNext()) {
                Tag tag = tags.next();
                map.put(tag.getTagName(),tag.getDescription());
                System.out.println(tag.getTagName() + ":" +tag.getDescription());
            }
        }
        System.out.println("图片分析完毕！");
        return map;
    }
    //转换经纬度
    public static String translate(String Gps) {
        String a = Gps.split("°")[0].replace(" ", "");
        String b = Gps.split("°")[1].split("'")[0].replace(" ", "");
        String c = Gps.split("°")[1].split("'")[1].replace(" ", "").replace("\"", "");
        double gps = Double.parseDouble(a)+Double.parseDouble(b)/60 + Double.parseDouble(c)/60/60;
        return String.valueOf(gps);
    }
    //根据经纬度获取地址
    public static void getAddress( Map<String,String> param){
        String str = RequestUtils.sendGet("https://restapi.amap.com/v3/geocode/regeo", "key=123123&location="+translate(param.get("GPS Longitude"))+","+translate(param.get("GPS Latitude")));
        JSONObject result = JSON.parseObject(str);
        System.out.println("拍摄时间：" +param.get("Date/Time"));
        System.out.println("拍摄地点：" +result.getJSONObject("regeocode").getString("formatted_address"));
        System.out.println("手机型号：" +param.get("Make") +" " + param.get("Model"));
        System.out.println(str);
    }
}
