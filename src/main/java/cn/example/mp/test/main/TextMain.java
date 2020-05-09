package cn.example.mp.test.main;

import cn.example.mp.test.entity.SystemOrg;
import cn.example.mp.test.fileparam.DownloadRequest;
import cn.example.mp.test.fileparam.FileResponse;
import cn.example.mp.test.util.DateUtil;
import cn.example.mp.test.util.ExcelUtil;
import cn.example.mp.test.util.HttpClientUtil;
import com.alibaba.fastjson.JSON;
import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.util.EntityUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.net.URISyntaxException;
import java.util.*;

/**
 * @author: xianpei.qin
 * @create: 2020-03-17 15:18
 **/
public class TextMain {

    public static void main(String[] args) throws IOException, URISyntaxException {
        String uploadUrl = "http://192.168.2.33:8091/api/bsp/fileManager/fileinfo/upload";
        String downloadUrl = "http://192.168.2.33:8091/api/bsp/fileManager/fileinfo/download";

        //http://192.168.3.238:8090/bbs/Img/02_gettyimages_478845908_high_resized.jpg
        //17位时间格式 例:202004201139234
        String replace = DateUtil.formatDate(new Date(), DateUtil.SIMPLE_DATE_PATTERN3)
                .replace("-", "")
                .replace(" ", "")
                .replace(":", "")
                .replace(".","");
        //系统流水号
        String sNo = "S"+"CIM"+replace+UUID.randomUUID().toString().substring(0,5);
        //全局流水号
        String gNo = "G"+"CIM"+replace+UUID.randomUUID().toString().substring(0,5);
        Map<String,String > paraMap = new HashMap<String,String>();
        paraMap.put("fileName","404.png");
        paraMap.put("fileFdfsName","wKgChV6EN02Ad-FyAAD5QMTRD3M986.png");
        paraMap.put("svcRqsSysEnShrtName","CIM");
        paraMap.put("svcRqsSysTxnTimpstamp",DateUtil.formatDate(new Date(),DateUtil.SIMPLE_DATE_PATTERN3));
        paraMap.put("svcRqsSysSerNo",sNo);
        paraMap.put("globalSerialNo",gNo);
        paraMap.put("origSvcRqsSysEnShrtName","BSP");
        paraMap.put("origSvcRqsSysTxnTimpstamp",DateUtil.formatDate(new Date(),DateUtil.SIMPLE_DATE_PATTERN3));
        paraMap.put("flagStatus","");
        paraMap.put("uploadFileDate","");

        byte []  result = HttpClientUtil.sendGet(downloadUrl, paraMap, "utf-8");

        String bResult = new String(result);

        InputStream inputStream = null;
        if(bResult.contains("retCode")){
            System.out.println("下载文件失败");
        }else{
            inputStream = new ByteArrayInputStream(result);
        }
        OutputStream out = null;
        File file = new File("E:\\"+"mm3.png");
        if(!file.exists()){
            file.createNewFile();
        }
        out = new FileOutputStream(file);
        byte[] buffer= new byte[1024];
        int len = 0;
        while ((len=inputStream.read(buffer))!=-1){
            out.write(buffer,0,len);
        }
        if(inputStream!=null){
            inputStream.close();
        }
        if(out!=null){
            out.close();
        }




    }


}