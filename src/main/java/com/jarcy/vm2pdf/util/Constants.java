package com.jarcy.vm2pdf.util;

public interface Constants {

	
	/**
	 * vm模板目录
	 */
	String VM_TEMPLATE_DIR = PropertiesUtils.getInstance().getProperty("vm_template_dir");
	
	/**
	 * html生成的目录
	 */
	String HTML_TEMPLATE_DIR = PropertiesUtils.getInstance().getProperty("html_template_dir");
	
	/**
	 * PDF 生成的目录
	 */
	String PDF_TEMPLATE_DIR = PropertiesUtils.getInstance().getProperty("pdf_template_dir");
	
}
