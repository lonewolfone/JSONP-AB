package org.lanqiao.controller;

import com.alibaba.fastjson.JSON;
import org.lanqiao.pojo.Goods;
import org.lanqiao.service.goodsService;
import org.lanqiao.service.impl.goodsServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet( "/jsonServlet")
public class jsonServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //前端穿过来的回调函数的名称
        // String callback = request.getParameter("callback");
        response.setContentType("text/json");
        response.setCharacterEncoding("utf-8"  );

        response.setHeader("Access-Control-Allow-Origin","*");

        PrintWriter out = response.getWriter();
        goodsService goodsService =  new goodsServiceImpl();
        //获取商品列表
        List<Goods> goodsList = goodsService.findAllGoods();
        //将其转化为JSON字符串
        String strJson =  JSON.toJSONString(goodsList);
        //回调函数名称包裹返回函数，返回函数作为回调参数传到前端
        //strJson =callback + "("+strJson+")";
        //将其输出到jsp页面
        out.print(strJson);
        //关闭流
        out.close();

    }
}
