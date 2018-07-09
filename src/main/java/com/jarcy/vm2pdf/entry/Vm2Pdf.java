package com.jarcy.vm2pdf.entry;

import java.io.IOException;
import java.util.Map;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Rectangle;
import com.jarcy.vm2pdf.util.Html2Pdf;
import com.jarcy.vm2pdf.util.Velocity2Html;
public class Vm2Pdf {

	/**
	 * 通过模板文件生成pdf文件
	 * @param vmTemplate
	 * @param htmlName
	 * @param pdfName
	 * @param data
	 * @param pageType
	 * @throws IOException
	 * @throws DocumentException
	 */
	public static void createPdf(String vmTemplate, String htmlName,
			String pdfName, Map<String, Object> data, Rectangle pageType)
			throws IOException, DocumentException {
		Velocity2Html.createHtml(vmTemplate, htmlName, data);
		Html2Pdf.createPdf(htmlName, pdfName,pageType);
	}
}
