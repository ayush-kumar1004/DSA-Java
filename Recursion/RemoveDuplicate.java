public class RemoveDuplicate {
    public static void removeDuplicateString(String s , int i , StringBuilder sb , boolean map[]){
        if(i==s.length()){
            System.out.println(sb);
            return;
        }
        char currChar = s.charAt(i);
        if(map[currChar - 'a'] == true){
            removeDuplicateString(s,i+1,sb,map);
        }
        else{
            map[currChar - 'a'] = true;
            removeDuplicateString(s,i+1,sb.append(currChar),map);
        }
    }
    public static void main(String[] args){
        String str = "aapnaanacollege";
        removeDuplicateString(str,0,new StringBuilder(""),new boolean[26]);

    }
}
