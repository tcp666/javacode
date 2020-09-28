package com.tcp.datafind.comm;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
 
public class DBSCAN {
    private static String ITEM_SPLIT = ","; 
    private static int ATRIBUTE_NUMBER = 4;
    
    //邻域半径
    private double epsilon = 0.35;
    //邻域内最小样本数量
    private int minimumNumberOfClusterMembers = 4;
    //数据集
    private ArrayList<double[]> inputValues = null;
    public static void main(String[] args) {
        DBSCAN one = new DBSCAN();
        String fileAdd = "D:\\SpringDemos\\javacode\\junit\\src\\main\\resources\\data.properties";
        try {
            one.inputValues = one.readFile(fileAdd); 
        } catch (IOException e) {
            e.printStackTrace();
        }

        boolean doNormalize = true;
        int[] labels = one.performClustering(doNormalize);
        printResult(labels);
    }
    
    /**
     * @param fileAdd
     * @return collection of all input iteam
     * @throws IOException
     */
    private ArrayList<double[]> readFile(String fileAdd) throws IOException {
 
        ArrayList<double[]> arrayList = new ArrayList<>();
        File file = new File(fileAdd);
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(file));
            String tempString = null;
            // 一次读入一行，直到读入null为文件结束
            while ((tempString = reader.readLine()) != null) {
                // 需要注意读入空行
                String[] strings = tempString.split(ITEM_SPLIT);
                double[] array = new double[ATRIBUTE_NUMBER];
                for (int i = 0; i < ATRIBUTE_NUMBER; i++) {
                    array[i] = Double.parseDouble(strings[i]);
                }
                arrayList.add(array);
            }
            reader.close();
            return arrayList;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
        }
        return null;
    }
 
    /**
     * 返回数据的标签不直接返回样本的划分
     */
    public int[] performClustering(boolean doNormalize) {
    	System.out.println("num_sample:"+inputValues.size());
    	//是否数据归一化，对结果影响比较大
    	if(doNormalize)
    		dataNormalize();
    	int k = 0;//簇计数
    	List<Integer> unvisitedIndices = new ArrayList<>();
    	for(int i = 0; i < inputValues.size(); i++) {
    		unvisitedIndices.add(i);
    	}
    	//保存样本的类别信息 
    	// -1：噪音，0:未被访问，1,2,3,4...类别1，2，3，4...
    	int[] labels = new int[inputValues.size()];
    	int iter = 0;
    	while(unvisitedIndices.size() != 0) {
    		System.out.println("iter..."+iter);
    		//0 随机选择一个没被访问过的样本作为开始
    		int index = (int) (Math.round(Math.random()*(unvisitedIndices.size()-1)));
    		index = unvisitedIndices.get(index);
    		//1获取该样本的邻域样本
    		List<Integer> indices = coreObjectTest(index);
    		//判断是否满足核心对象
    		if(indices.size() >= minimumNumberOfClusterMembers) {
    			//新生成簇进行扩展
    			k++;
    			//核心对象队列，也就是需要被扩展的核心对象
    			Map<Integer, List<Integer>> omega = new HashMap<>();
    			omega.put(index, indices);
    			//直到核心对象队列为空迭代停止
    			do {
    				//从核心对象列表中选择一个
    				int index_c = omega.entrySet().iterator().next().getKey();
    				labels[index_c] = k;
    				unvisitedIndices.remove(new Integer(index_c));
    				//获取邻域
    				List<Integer> neighborIndices = omega.get(index_c);
    				//从Omega中移除
    				omega.remove(index_c);
        			//遍历邻域
        			for(int index_ : neighborIndices) {
        				//未被访问或者之前是噪音
        				if(labels[index_] < 1) {
        					labels[index_] = k;
        					unvisitedIndices.remove(new Integer(index_));
        					//测试是否是核心对象,如果是加入到队列中
            				List<Integer> index_OfNeighborIndices = coreObjectTest(index_);
            				if(index_OfNeighborIndices.size() >= minimumNumberOfClusterMembers)
            					omega.put(index_, index_OfNeighborIndices);
        				}
        			}
    			}
    			while(omega.size() != 0);
    		} else {
    			//噪音
    			labels[index] = -1;
    			unvisitedIndices.remove(new Integer(index));
    		}
    		iter++;
    	}
		return labels;
    }
    
    public static void printResult(int[] labels) {
    	// -1噪音，0,未被访问（不会出现），>=1类别
    	Map<Integer, ArrayList<Integer>> counts = new HashMap<>();
    	int c = 0;
    	for(int label : labels) {
    		ArrayList<Integer> indices = counts.get(label);
    		if(indices == null) {
    			ArrayList<Integer> list = new ArrayList<>();
    			list.add(c);
    			counts.put(label, list);
    		} else {
    			indices.add(c);
    		}
    		c++;
    	}
    	System.out.println("CLUSTER -1 means noise samples!");
    	counts.forEach((k,v)->{
    		System.out.println("CLUSTER "+k+":"+(v.size()*1.0/labels.length)+" "+v.size()+"/"+labels.length);
    	});
    	System.out.println();
    	counts.forEach((k,v)->{
    		System.out.println("CLUSTER "+k+" data indices:");
    		System.out.print("----------");
    		v.forEach((e)->System.out.print(e+","));
    		System.out.println();
    	});
    }
    
    /**
     * 获取一个样本邻域的样本
     * @param testSampleIndex
     * @return 返回这些样本的index
     */
    public List<Integer> coreObjectTest(int testSampleIndex){
    	List<Integer> indices = new ArrayList<>();
    	for(int i = 0; i < inputValues.size(); i++) {
    		if(distance(inputValues.get(testSampleIndex), inputValues.get(i)) <= epsilon) {
    			indices.add(i);
    		}
    	}
    	return indices;
    }
    /**
     * 数据归一化
     * 如果不做归一化并且不修改weka中DBSCAN的设置那么结果将大不一样
     * x = (x - min)/(max - min)
     */
    public void dataNormalize() {
    	//x = (x - min)/(max - min)
    	double[] mins = new double[ATRIBUTE_NUMBER];
    	double[] maxs = new double[ATRIBUTE_NUMBER];
    	for(int i = 0; i < ATRIBUTE_NUMBER;i++) {
    		mins[i] = Double.MAX_VALUE;
    		maxs[i] = Double.MIN_VALUE;
    	}
    	for(int i = 0; i < ATRIBUTE_NUMBER; i++) {
    		for(int j = 0; j < inputValues.size();j++) {
    			mins[i] = inputValues.get(j)[i] < mins[i] ? inputValues.get(j)[i] : mins[i];
    			maxs[i] = inputValues.get(j)[i] > maxs[i] ? inputValues.get(j)[i] : maxs[i];
    		}
    	}
    	double[] maxsReduceMins = new double[ATRIBUTE_NUMBER];
    	for(int i = 0; i < ATRIBUTE_NUMBER;i++) {
    		maxsReduceMins[i] = maxs[i] - mins[i];
    	}
    	for(int i = 0; i < ATRIBUTE_NUMBER; i++) {
    		for(int j = 0; j < inputValues.size();j++) {
    			inputValues.get(j)[i] = (inputValues.get(j)[i] - mins[i])/(maxsReduceMins[i]);
    		}
    	}
    }
    /**
     * 欧式距离
     * @param v1
     * @param v2
     * @return
     */
    public double distance(double[] v1, double[] v2) {
		double sum = 0;
		for(int i = 0; i < v1.length; i++) {
			sum += Math.pow(v1[i]-v2[i], 2);
		}
		return Math.sqrt(sum);
	}
}
