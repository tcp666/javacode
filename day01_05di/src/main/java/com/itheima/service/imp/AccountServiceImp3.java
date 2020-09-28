package com.itheima.service.imp;

import com.itheima.service.IAccountService;

import java.lang.reflect.Array;
import java.util.*;


public class AccountServiceImp3 implements IAccountService {
    private String[] mystrs;
    private List<String> mylist;
    private Set<String> myset;
    private Map<String, String> mymap;
    private Properties myprops;

    public void setMystrs(String[] mystrs) {
        this.mystrs = mystrs;
    }

    public void setMylist(List<String> mylist) {
        this.mylist = mylist;
    }

    public void setMyset(Set<String> myset) {
        this.myset = myset;
    }

    public void setMymap(Map<String, String> mymap) {
        this.mymap = mymap;
    }

    public void setMyprops(Properties myprops) {
        this.myprops = myprops;
    }

    public void saveAccount() {
        System.out.println(Arrays.toString(mystrs));
        System.out.println(mylist);
        System.out.println(myset);
        System.out.println(mymap);
        System.out.println(myprops);

    }

}
