package com.jarcy.vm2pdf.util;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

public class Velocity2HtmlTest {

    @Test
    public void testCreateHtmlStringStringMapOfStringObject() {
        
        try {
            Velocity2Html.createHtml("gyhz01.vm", "gyhz01.html");
        } catch (IOException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testCreateHtmlStringString() {
        fail("Not yet implemented");
    }

}
