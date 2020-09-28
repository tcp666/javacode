package com.tcp.datafind.id3;


public class ID3Main {

    public static void main(String[] args) {
        
        ID3Alogo id3Alogo = new ID3Alogo();
        /**
         * data.properties：数据集
         * result.txt结果数
         * 是否购买：决策树名
         */
        id3Alogo.ID3("是否购买","D:\\SpringDemos\\javacode\\junit\\src\\main\\java\\com\\tcp\\datafind\\id3\\data.properties",
                "D:\\SpringDemos\\javacode\\junit\\src\\main\\java\\com\\tcp\\datafind\\id3\\result.txt");
        
    }
    
}