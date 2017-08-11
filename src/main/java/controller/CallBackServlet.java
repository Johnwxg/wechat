package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import utils.AuthUtil;

/**
 * Servlet implementation class CallBackServlet
 */
public class CallBackServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("hahah");
		/**
		 * 根据回传code获取token
		 */
        String code=request.getParameter("code");
        String url="https://api.weixin.qq.com/sns/oauth2/access_token?appid="+AuthUtil.APPID+"&secret="+AuthUtil.APPSECRET+"&code="+code+"&grant_type=authorization_code";
        JSONObject jsonObject = AuthUtil.doGetJson(url);
        System.out.println("用户身份验证，根据code获取token："+jsonObject);
        
        /**
         * 根据回传token，获取用户信息 
         */
        String openid=jsonObject.getString("openid");
        String token=jsonObject.getString("access_token");
        String infoUrl="https://api.weixin.qq.com/sns/userinfo?access_token="+token+"&openid="+openid+"&lang=zh_CN";
        JSONObject userInfo=AuthUtil.doGetJson(infoUrl);
        System.out.println("用户身份验证，获取用户信息："+userInfo);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
