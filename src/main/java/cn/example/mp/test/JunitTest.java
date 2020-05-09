package cn.example.mp.test;
import cn.example.mp.test.constant.SystemConstant;
import cn.example.mp.test.fileparam.FileResponse;
import cn.example.mp.test.util.*;
import com.alibaba.fastjson.JSON;
import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;
import org.apache.commons.io.FileUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.testng.annotations.Test;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.net.URISyntaxException;
import java.util.*;

public class JunitTest {

    private static int total = 1000000;


    @Test
    public void propertiesTest(){
        String filePath = null;
        try {
            String s = "aaaaaaaaaaa";
            filePath = PropertiesUtil.getProperties("config.properties", "report_temp_dir");
            String fileName = "adsafdsa.txt";
            FileWriter writer = new FileWriter(filePath+fileName);
            writer.write(s);
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(filePath);
    }

    @Test
    public void fileDownLoadTest() throws IOException, URISyntaxException {
        String downloadUrl = "http://192.168.2.33:8091/api/bsp/fileManager/fileinfo/download";
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

        String fileName = "ff80808171beb8150171bede30290007.txt";
        String fileFid = "wKgChF6npXaAS5t3AAJl5jFQsz8453.txt";

        paraMap.put("fileName",fileName);
        paraMap.put("fileFdfsName",fileFid);
        paraMap.put("svcRqsSysEnShrtName","CIM");
        paraMap.put("svcRqsSysTxnTimpstamp",DateUtil.formatDate(new Date(),DateUtil.SIMPLE_DATE_PATTERN3));
        paraMap.put("svcRqsSysSerNo",sNo);
        paraMap.put("globalSerialNo",gNo);
        paraMap.put("origSvcRqsSysEnShrtName","BSP");
        paraMap.put("origSvcRqsSysTxnTimpstamp",DateUtil.formatDate(new Date(),DateUtil.SIMPLE_DATE_PATTERN3));
        paraMap.put("flagStatus","");
        paraMap.put("uploadFileDate",DateUtil.formatDate5(new Date()));

        byte []  result = HttpClientUtil.sendGet(downloadUrl, paraMap, "utf-8");
        String bResult = new String(result);
        InputStream inputStream = null;
        if(bResult.contains("retCode")){
            System.out.println("下载文件失败");
        }else{
            inputStream = new ByteArrayInputStream(result);
        }
        OutputStream out = null;
        File file = new File("E:\\"+"mm7.txt");
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

    @Test
    public void fileUploadTest() throws IOException {

        String uploadUrl = "http://192.168.2.33:8091/api/bsp/fileManager/fileinfo/upload";
        String replace = DateUtil.formatDate(new Date(), DateUtil.SIMPLE_DATE_PATTERN3)
                .replace("-", "")
                .replace(" ", "")
                .replace(":", "")
                .replace(".","");
        //系统流水号
        String sNo = "S"+"CIM"+replace+ UUID.randomUUID().toString().substring(0,5);
        //全局流水号
        String gNo = "G"+"CIM"+replace+UUID.randomUUID().toString().substring(0,5);

        String fileName = "40280a8171b62aa60171b646c9a50003.txt";
        String path = "E:\\"+fileName;
        MultipartFile mFile = FileUtil.getMulFileByPath(path,fileName);
        String originalFilename = mFile.getOriginalFilename();
        long size = mFile.getSize();
        Map<String,Object> upParams = new HashMap<String,Object>();
        upParams.put("file",mFile);
        upParams.put("fileName",fileName);
        upParams.put("fileMd5", FileMd5Util.getFileMd5(mFile));
        upParams.put("batchNo","CIM"+System.currentTimeMillis());
        upParams.put("flag","0");
        upParams.put("svcRqsSysEnShrtName","CIM");
        upParams.put("svcRqsSysTxnTimpstamp", DateUtil.formatDate(new Date(),DateUtil.SIMPLE_DATE_PATTERN3));
        upParams.put("svcRqsSysSerNo",sNo);
        upParams.put("globalSerialNo",gNo);
        upParams.put("origSvcRqsSysEnShrtName","BSP");
        upParams.put("origSvcRqsSysTxnTimpstamp",DateUtil.formatDate(new Date(),DateUtil.SIMPLE_DATE_PATTERN3));
        byte [] response = HttpClientUtil.sendPost(uploadUrl, upParams, "utf-8");
        String result = new String(response);
        String s = result.replace("null", "\"null\"");
        FileResponse fileResponse1 = JSON.parseObject(s, FileResponse.class);
        String retUrl = fileResponse1.getRetEntity();
    }

    @Test
    public void testFileOut(){

        String result = "<reqID>40280a8171b437c80171b437c8cf0000</reqID><resCode>000000</resCode><resMsg>查询成功</resMsg>";
        String fileName = "ppppp"+".txt";
        String filePath = "E:\\";
        try {
            File file = new File(filePath+fileName);
            if(!file.exists()){
                file.createNewFile();
            }
            FileWriter writer = new FileWriter(file);
            writer.write(result);
            writer.flush();
            writer.close();
            if(!file.exists()){
                file.createNewFile();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void testDateSub(){
        String startDate  = "20200227";
        String endDate = "20200429";
        StringBuffer sb = new StringBuffer(startDate);
        sb.insert(4,"-");
        sb.insert(7,"-");

        String DStr= sb.toString()+" 23:59:59";
        System.out.println();
        Date date = DateUtil.stringToDate(DStr, "yyyy-MM-dd HH:mm:ss");
        System.out.println(date.toString());

    }


    @Test
    public void testIO(){
        String fileName = "ppppp"+".txt";
        String filePath = "E:\\aa";
        File file = new File(filePath+fileName);
    }

    @Test
    public void testIPUtil(){

        int a = 123;
        int i1 = a << 2;
        System.out.println(i1);


        SnowFlake snowFlake = new SnowFlake(2,3);
        long l = snowFlake.nextId();
        System.out.println(l);


    }


    @Test
    public void testBloomFilter(){

        BloomFilter<Integer> bf = BloomFilter.create(Funnels.integerFunnel(), total,0.003);

        //往布隆过滤器放入100万数据
        for (int i = 0 ; i <total;i++){
            bf.put(i);
        }
        //检测存在过滤器中的元素误判率，存在过滤器中的元素逃脱率0
        for(int i= 0;i<total;i++){
            if(!bf.mightContain(i)){
                System.out.println("逃脱");
            }
        }

        //1万个不在过滤器中的元素，被误判了320个存在，误判率0.032
        int count = 0;
        for(int i = total ;i<total+10000;i++){
            if(bf.mightContain(i)){
                count++;
            }
        }

        System.out.println("误伤:"+count);
    }

    @Test
    public void testRemove(){
        List<String> ls = new ArrayList<String>();
        ls.add("11");
        ls.add("22");
        ls.add("33");
        ls.add("44");
        /*for (String l : ls) {
            if ("11".equals(l)){
                ls.remove(l);
            }
        }
*/
        Iterator<String> iterator = ls.iterator();
        while (iterator.hasNext()){
            String next = iterator.next();
            if (next.equals("11")){
                iterator.remove();
            }
        }

        for (String l : ls) {
            System.out.println(l);
        }
    }

    String s = new String("11");

    StringBuilder builder = new StringBuilder("12");

}
