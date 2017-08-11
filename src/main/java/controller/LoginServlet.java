package controller;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utils.AuthUtil;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * 向微信公众平台发起调用（申请获取用户信息）请求
	 * 返回路径：http://3261045722cwy.vicp.io/wx/callBack
	 * 返回值：code
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String backUrl="http://3261045722cwy.vicp.io/wx/callBack";
	    /**
	     *这儿一定要注意！！首尾不能有多的空格（因为直接复制往往会多出空格），其次就是参数的顺序不能变动
	    */
        String url="https://open.weixin.qq.com/connect/oauth2/authorize?appid="+
	        AuthUtil.APPID+"&redirect_uri="+URLEncoder.encode(backUrl,"UTF-8")+
	        "&response_type=code"+"&scope=snsapi_userinfo"+"&state=STATE#wechat_redirect";
        response.sendRedirect(url);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
