package com.jarcy.vm2pdf.entry;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.jarcy.vm2pdf.util.Html2Pdf;
import com.jarcy.vm2pdf.util.Velocity2Html;

public class Test {

	public static void main(String[] args) {
		Map<String, Object> data =new HashMap<String, Object>();
		data.put("name", "尹海波");
		data.put("sex", "男");
		try {
			Velocity2Html.createHtml("gyhz01.vm", "gyhz01.html", data);
			Html2Pdf.createPdf("gyhz01.html", "gyhz01.pdf",PageSize.A4.rotate());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
