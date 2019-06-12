package files;

public class resources {


	public static String userlogin()
	{
		
		String res = "/user/login/json";
		return res;
		
		
	}
	
	public static String inventory()
	{
		
		String res = "/store/inventory/json";
		return res;
		
		
	}
	public static String placeorder()
	{
		
		String res = "/store/order/json";
		return res;
		
		
	}
	public static String queryorder()
	{
		
		String res = "/store/order/{orderId}/json";
		return res;
		
		
	}
	
	public static String deleteorder()
	{
		
		String res = "/store/order/{orderId}/json";
		return res;
		
		
	}
	
	
}
