package com.tcp;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;


import java.io.*;

/**
 * 把pdf转换为word格式
 *
 * @author Angin
 * @date 2019/3/18 0018.
 */
public class PdfToWord {
    /**
     * 转换
     */
    public void convertText(String pdfPath) {
        PDDocument doc = null;
        OutputStream fos = null;
        Writer writer = null;
        PDFTextStripper stripper = null;
        try {
            doc = PDDocument.load(new File(pdfPath));
            fos = new FileOutputStream(pdfPath.substring(0, pdfPath.indexOf(".")) + ".doc");
            writer = new OutputStreamWriter(fos, "UTF-8");
            stripper = new PDFTextStripper();
            int pageNumber = doc.getNumberOfPages();
            stripper.setSortByPosition(true);
            stripper.setStartPage(1);
            stripper.setEndPage(pageNumber);
            stripper.writeText(doc, writer);
            writer.close();
            doc.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("end..");
    }


    public static void main(String[] args) {
        PdfToWord pdfToWord=new PdfToWord();
//        System.out.println(ClassLayout.parseInstance(pdfToWord).toPrintable(pdfToWord));
//        pdfToWord.convertText("D:\\SpringDemos\\javacode\\junit\\src\\main\\resources\\后台研发工程师_范伯鹏.pdf");

        Integer f=1;
        Integer f2=1;
        System.out.println(f==f2);
    }
}