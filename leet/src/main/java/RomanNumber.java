import java.util.HashMap;
import java.util.Map;

public class RomanNumber {

    Map<Character, Integer> map = new HashMap<Character, Integer>() {{
        put('I', 1);
        put('V', 5);
        put('X', 10);
        put('L', 50);
        put('C', 100);
        put('D', 500);
        put('M', 1000);
    }};

   public int romanToInt(String s){
       char[] arr=s.toCharArray();
       char preC='a';
       int r=0;
       for(int i=0;i<arr.length;i++){
           char c=arr[i];
            int current=map.get(c);
            int preNumber=preC=='a'?0:map.get(preC);
            r+=map.get(c);
            if(current>preNumber&&preNumber!=0){
                r-= (2*preNumber);
            }
           preC=c;

       }
       return r;
   }
    int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

  public String intToRoman(int num){
      StringBuffer result=new StringBuffer();
      for (int i=0;i<values.length;i++){
          int value=values[i];
          String s=symbols[i];
          while (num>=value){
              num-=value;
              result.append(s);
          }
      }
      return result.toString();
  }

}
