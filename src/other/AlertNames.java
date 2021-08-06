package other;

import java.util.*;

public class AlertNames {
//    public List<String> alertNames(String[] keyName, String[] keyTime)  {
//        List<String> res=new ArrayList<>();
//        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("HH:mm");
//        for (int i = 0; i < keyName.length; i++) {
//            String time=keyTime[i];
//            Date date= null;
//            try {
//                date = simpleDateFormat.parse(time);
//            } catch (ParseException e) {
//                e.printStackTrace();
//            }
//            Date dateAft=new Date(date.getTime()+3600*1000);
//            String time2=simpleDateFormat.format(dateAft);
//            if (time.compareTo(new String("23:00"))>=0)
//                time2="23:59";
//            int count=0;
//            for (int j = 0; j <keyTime.length ; j++) {
//                if((keyTime[j].compareTo(time2)<=0)&&(keyTime[j].compareTo(time)>=0)) {
//                    if(keyName[j].equals(keyName[i]))
//                        count++;
//                }
//                if (count>=3) {
//                    res.add(keyName[i]);
//                    break;
//                }
//            }
//        }
//        HashSet<String> set = new HashSet<>(res);
//        res.clear();
//        res.addAll(set);
//
//        res.sort((s1,s2)->s1.compareTo(s2));
//        return res;
//    }
private int cal(String str)
{
    return Integer.parseInt((str.substring(0,2)))*60+Integer.parseInt(str.substring(3,5));
}
    public List<String> alertNames(String[] keyName, String[] keyTime)
    {
        HashMap<String,List<Integer>> hashMap = new HashMap();

        for(int i= 0;i<keyName.length;i++)
        {
            if(!hashMap.containsKey(keyName[i]))
            {
                List<Integer> v = new ArrayList<>();
                v.add(cal(keyTime[i]));
                hashMap.put(keyName[i],v);
            }
            else
            {
                List<Integer> v = hashMap.get(keyName[i]);
                v.add(cal(keyTime[i]));
                hashMap.put(keyName[i],v);
            }
        }
        List<String> res =new ArrayList<>();
        for(String key : hashMap.keySet())
        {
            List<Integer> v = hashMap.get(key);
            Collections.sort(v);
            for(int i =0;i+2<v.size();i++)
            {
                if(v.get(i+2)-v.get(i)<=60)
                {
                    res.add(key);
                    break;
                }
            }
        }
        Collections.sort(res);
        return res;

    }
    public static void main(String[] args) {
        AlertNames alertNames = new AlertNames();
        String [] keyName={
            "a", "a", "a", "a", "a", "b", "b", "b", "b", "b", "b"};
        String [] keyTime={"23:20","11:09","23:30","23:02","15:28","22:57","23:40","03:43","21:55","20:38","00:19"};
        alertNames.alertNames(keyName,keyTime);
    }
}
