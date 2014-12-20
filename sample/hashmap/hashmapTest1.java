import java.util.HashMap;

class hashmapTest1{
  public static void main(String args[]){
    HashMap<String,String> map = new HashMap<String,String>();

    map.put("りんご", "apple");
    map.put("ぶどう", "grapes");

    if (map.containsKey("りんご")){
      System.out.print("りんごを英語にすると");
      System.out.println(map.get("りんご"));
    }else{
      System.out.println("指定したキーは存在しません");
    }
  }
}
