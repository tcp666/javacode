package weather;


public class Entity {
	private String fieldPrivate;
	
	private static String fieldStaticPrivate;
	public String fieldPublic;
	public static String fieldStaticPublic;
	private String operateWithFieldPrivate(){
		return "operate private method:"+ fieldPrivate;
	}
	
	private static String operateWithFieldStaticPrivate(){
		return "operate private static method:"+ fieldStaticPrivate;
	}
	
	public String operateWithFieldPublic(){
		return "operate public method"+fieldPublic;
	}
	
	public static String operateWithFieldStaticPublic(){
		return "operate public static method"+fieldStaticPublic;
	}
	
	public String hasParameterMethod(String param1,String param2){
		return "operate hasParameterMethod:"+param1+","+param2;
	}
	
	public String hasChangeableParameterMethod(Object... objects){
		StringBuilder result=new StringBuilder();
		for(Object obj:objects){
			result.append(obj.toString()).append(",");
		}
		return "operate hasParameterMethod:"+result;
	}
}