package book;

import java.lang.reflect.Method;

public class UserServlet {

	public void login() {
		System.out.println("这是登录的功能");
	}
	public void regist() {
		System.out.println("这是注册的功能");
	}
	public void updatePassword() {
		System.out.println("这是修改密码的功能");
	}
	
	public static void main(String[] args) throws Exception {
		String action = "updatePassword";
		// 通过反射获取方法的反射对象Method
		Method method = UserServlet.class.getDeclaredMethod(action);
		UserServlet userServlet = new UserServlet();
		System.out.println(method);
		// 通过反射执行业务方法
		method.invoke(userServlet);
	}
	
}
