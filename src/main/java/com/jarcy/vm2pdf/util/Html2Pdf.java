package com.jarcy.vm2pdf.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorkerHelper;

public class Html2Pdf {
	
	private static final Logger log =LoggerFactory.getLogger(Html2Pdf.class);
	
	public static void createPdf(String htmlName,String pdfName, Rectangle pageType) throws DocumentException, IOException{
		log.info("【创建pdf】由html文件开始生成pdf文件....");
		Rectangle rectangle =new Rectangle(pageType);
        Document document = new Document(rectangle);
        File pdf = new File(Constants.PDF_TEMPLATE_DIR,pdfName);
        if(pdf.exists()){
        	log.debug("文件：{}已存在，执行删除操作。",pdfName);
        	pdf.delete();
        }
        PdfWriter  writer= PdfWriter.getInstance(document, new FileOutputStream(pdf));
        document.open();
        XMLWorkerHelper.getInstance().parseXHtml(writer, document,
        		new FileInputStream(new File(Constants.HTML_TEMPLATE_DIR, htmlName)),
        		Charset.forName("utf-8"));
        document.close();
        log.info("【创建pdf】pdf：{}生成结束",pdfName);
	}
	
	public static void createPdf(String htmlName,String pdfName) throws DocumentException, IOException{
		createPdf(htmlName, pdfName, PageSize.A4);
	}
	

}
