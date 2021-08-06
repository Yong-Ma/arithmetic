package bishi;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

//统计一个文件的字符出现次数
public class tongji {
    public static void main(String[] args) {
        String fileName="F:\\a.txt";
        Map<Character,Integer> map=new HashMap<>();
        readdata(fileName,map);
        map.forEach((k,v)->{
            System.out.printf("字符%c出现次数为：%d",k,v);
            System.out.println();
        });
    }
    public static void readdata(String fileName,Map<Character,Integer> map) {
        try {
            BufferedReader bf=new BufferedReader(new FileReader(fileName));
            StringBuilder stringBuilder=new StringBuilder();
            while(true){
                String line=bf.readLine();
                if(line==null)
                    break;
                stringBuilder.append(line);
            }
            char[] strs=stringBuilder.toString().toCharArray();
            for (int i = 0; i < strs.length; i++) {
                map.merge(strs[i],1,Integer::sum);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
