package com.kunlunrisk.controller;

import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kunlunrisk.model.Standard;
import com.kunlunrisk.repository.StandardRepository;
import com.util.ExcelUtil;

@Controller
@RequestMapping(value="/standardexcel")
public class ExcelStandardController {

	@Autowired
	private StandardRepository standardRepository;
	
    @RequestMapping(value="/export")
    public String download(HttpServletRequest request,HttpServletResponse response) throws IOException{
        String fileName="excel文件";
        //填充standard数据
        List<Standard> standards = createData();         //standardRepository.findAll();
        List<Map<String,Object>> list=createExcelRecord(standards);
        String columnNames[]={"序号","名称","年份","地区","性质"};//列名
        String keys[] = {"id","name","year","area","property"};//map中的key
        
        FileOutputStream fileOut = null;     
        BufferedImage bufferImg = null;    
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        try {
        	//bufferImg = ImageIO.read(new File("D:/Picture/1.jpg"));     
            //ImageIO.write(bufferImg, "jpg", os);  
            ExcelUtil.createWorkBook(list,keys,columnNames).write(os);
            
         
        } catch (IOException e) {
            e.printStackTrace();
        }
        byte[] content = os.toByteArray();
        InputStream is = new ByteArrayInputStream(content);
        // 设置response参数  ，可以打开下载页面
        response.reset();
        response.setContentType("application/vnd.ms-excel;charset=utf-8");
        response.setHeader("Content-Disposition", "attachment;filename="+ new String((fileName + ".xls").getBytes(), "iso-8859-1"));
        ServletOutputStream out = response.getOutputStream();
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null; 
        try {
            bis = new BufferedInputStream(is);
            bos = new BufferedOutputStream(out);
            byte[] buff = new byte[2048];
            int bytesRead;
            // Simple read/write loop.
            while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {
                bos.write(buff, 0, bytesRead);
            }
        } catch (final IOException e) {
            throw e;
        } finally {
            if (bis != null)
                bis.close();
            if (bos != null)
                bos.close();
        }
        return null;
    }

    private List<Standard> createData() {
    	List<Standard> list = standardRepository.findAll();
        return list;
    }
    
    
    private List<Map<String, Object>> createExcelRecord(List<Standard> standards) {
        List<Map<String, Object>> listmap = new ArrayList<Map<String, Object>>();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("sheetName", "sheet1");
        listmap.add(map);
        Standard standard=null;
        for (int j = 0; j < standards.size(); j++) {
        	standard=standards.get(j);
            Map<String, Object> mapValue = new HashMap<String, Object>();
            mapValue.put("id", standard.getId());
            mapValue.put("name", standard.getName());
            mapValue.put("year", standard.getYear());
            mapValue.put("area", standard.getArea());
            mapValue.put("property", standard.getProperty());
            listmap.add(mapValue);
        }
        return listmap;
    }
    
  
  

}
