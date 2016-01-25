package com.kunlunrisk.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kunlunrisk.model.ProjectItem;
import com.kunlunrisk.model.Standard;
import com.kunlunrisk.repository.ProjectItemRepository;
import com.util.ExcelUtil;

@Controller
@RequestMapping(value="/projectitemexcel")
public class ExcelProjectItemController {

	@Autowired
	private ProjectItemRepository projectItemRepository;
	
    @RequestMapping(value="/export")
    public String download(HttpServletRequest request,HttpServletResponse response) throws IOException{
        String fileName="excel文件";
        //填充projectItem数据
        List<ProjectItem> projectItems = createData();
        List<Map<String,Object>> list=createExcelRecord(projectItems);
        String columnNames[]={"序号","地点（桩号）","损失项","使用标准","长","宽","高","损失数量","标准单价","报损金额","实际损失金额","备注"};//列名
        String keys[] = {"item.id","place","item.name","standard.name","length","width","height","amount","price","reportedLoss","realPrice","remark"};//map中的key
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        try {
            ExcelUtil.createWorkBook(list,keys,columnNames).write(os);
        } catch (IOException e) {
            e.printStackTrace();
        }
        byte[] content = os.toByteArray();
        InputStream is = new ByteArrayInputStream(content);
        // 设置response参数，可以打开下载页面
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

    private List<ProjectItem> createData() {
		// TODO Auto-generated method stub
		return null;
	}

	private List<Map<String, Object>> createExcelRecord(List<ProjectItem> projectItems) {
        List<Map<String, Object>> listmap = new ArrayList<Map<String, Object>>();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("sheetName", "sheet1");
        listmap.add(map);
        ProjectItem projectItem = null;
        for (int j = 0; j < projectItems.size(); j++) {
        	projectItem=projectItems.get(j);
            Map<String, Object> mapValue = new HashMap<String, Object>();
            mapValue.put("item.id", projectItem.getItem().getId());
            mapValue.put("place", projectItem.getPlace());
            mapValue.put("item.name", projectItem.getItem().getName());
            mapValue.put("standard.name", projectItem.getStandard().getName());
            mapValue.put("length", projectItem.getLength());
            mapValue.put("width", projectItem.getWidth());
            mapValue.put("height", projectItem.getHeight());
            mapValue.put("amount", projectItem.getAmount());
            mapValue.put("price", projectItem.getPrice());
            mapValue.put("reportedLoss", projectItem.getReportedLoss());
            mapValue.put("price", projectItem.getPrice());
            mapValue.put("remark", projectItem.getRemark());
            listmap.add(mapValue);
        }
        return listmap;
    }
    
  
   
}
