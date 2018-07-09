package com.jarcy.vm2pdf.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Velocity2Html {

	
	private static final Logger log =LoggerFactory.getLogger(Velocity2Html.class);
	/**
	 * 通过vm模板生成html
	 * @param vmTemplate vm模板名称（包含后缀）
	 * @param htmlName 生成的html名称（包含后缀）
	 * @param data 要填充到vm的数据
	 * @throws IOException 
	 */
	public static void createHtml(String vmTemplate,String htmlName,
			Map<String, Object> data) throws IOException{
		log.info("【创建html】vm模板开始生成html文件...");
		 VelocityEngine ve = new VelocityEngine();
		 String vmDir=Constants.VM_TEMPLATE_DIR;
		 if(!StringUtils.isEmpty(vmDir)){
			 ve.setProperty(ve.FILE_RESOURCE_LOADER_PATH, vmDir);
		 }else{
			 String vmTmp=Velocity2Html.class.getResource("/config/vm").getPath();
			 ve.setProperty(ve.FILE_RESOURCE_LOADER_PATH, vmTmp);
		 }
		ve.init();
		Template template = ve.getTemplate(vmTemplate, "utf-8");
		VelocityContext context = new VelocityContext(data);
		// String
		// htmlDir=PropertiesUtils.getInstance().getProperty("html_template_dir");
		Writer writer = new FileWriter(new File(Constants.HTML_TEMPLATE_DIR,
				htmlName));
		;
		/*
		 * if(!StringUtils.isEmpty(htmlDir)){ writer = new FileWriter(new
		 * File(htmlDir,htmlName)); }else{ String
		 * htmlTmp=Velocity2Html.class.getResource("/config/html").getPath();
		 * writer = new FileWriter(new File(htmlTmp,htmlName));
		 * 
		 * }
		 */
		template.merge(context, writer);
		writer.flush();
		writer.close();	 
        log.info("【创建html】vm模始生成html文件结束");
	}
	
	public static void createHtml(String vmTemplate,String htmlName) throws IOException{
		createHtml(vmTemplate, htmlName, null);
	}
}
