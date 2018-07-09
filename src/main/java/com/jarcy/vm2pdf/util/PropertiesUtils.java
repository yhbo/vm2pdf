package com.jarcy.vm2pdf.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PropertiesUtils {

	private static Properties  properties= new Properties();
	
	//配置文件路径
	private static final String CONFIG_DIR =PropertiesUtils.class.getResource("/").getPath();
	
	private static final Logger log =LoggerFactory.getLogger(PropertiesUtils.class);
	
	private PropertiesUtils(){};
	
	/**
	 * 实例化Properties
	 * @return
	 */
	public static synchronized Properties getInstance(){
		if(properties ==null ){
			properties = new Properties();
		}
		init();
		return properties;
	}
	
	public static void init(){
		
		try {
			//先读取外部配置文件（自定义文件）
			//通过文件大小判断是否存在自定义文件，比catch 效率高
			log.debug("【加载配置文件】读取自定义配置文件....");
			File extFile= new File(CONFIG_DIR,"pdf_config.properties");
			if(extFile.length()!=0){
				properties.load(new InputStreamReader(new FileInputStream(extFile)));
			}else{
				log.debug("【加载配置文件】自定义文件未找到，读取默认配置...");
				properties.load(PropertiesUtils.class.getResourceAsStream("/pdf_config.properties"));
			}
			
		} catch (FileNotFoundException e) {
			log.error("【加载配置文件】，未找到文件，{}",e);
		} catch (IOException e) {
			log.error("【加载配置文件】 IO异常，{}",e);
		}
	}
	
	public String getProperty(String key){
		if(properties.getProperty(key)==null){
			try {
				properties.load(PropertiesUtils.class.getResourceAsStream("/pdf_config.properties"));
				return properties.getProperty(key);
			} catch (IOException e) {
				log.debug("IO异常");
			}
		}
		return properties.getProperty(key);
	}
	
	public static void main(String[] args) {
		String value=PropertiesUtils.getInstance().getProperty("vm_template_dir");
		System.out.println("value="+value);
	}
}
