package com.nineboy.seckill.controller;

import com.nineboy.seckill.model.ProductInfo;
import com.nineboy.seckill.service.ProductInfoService;
import com.nineboy.seckill.vo.ProductInfoVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping(path ={"/productinfo"} )
public class ProductInfoController {
    private static final Logger logger = LoggerFactory.getLogger(ProductInfoController.class);

    @Autowired
    ProductInfoService productInfoService;

    @RequestMapping(path = {"/toapplyproduct"}, method = {RequestMethod.GET})
    public String toApplymsproduct() {
        return "productinfo/applyproduct";
    }

    @RequestMapping(path ={"/applyproduct"},method = {RequestMethod.GET,RequestMethod.POST})
    public String applymsproduct(ProductInfo productInfo){
        productInfoService.applyProduct(productInfo);
        System.out.println(productInfo);
        return "redirect:listproduct";
    }

    @RequestMapping(path = {"/toupdateproduct"}, method = {RequestMethod.GET})
    public String toUpdateProductInfo(Model model,
                           @RequestParam("id") int id) {
        ProductInfo productInfo = productInfoService.queryProductInfoById(id);
        System.out.println(productInfo);
        Date starttime = productInfo.getStartTime();
        Date endtime = productInfo.getEndTime();
        String startTimeString = "";
        String endTimeString = "";
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        if(starttime!=null){
            startTimeString = dateFormat.format(starttime);
        }
        if(endtime!=null){
            endTimeString = dateFormat.format(endtime);
        }
        model.addAttribute("productInfo",productInfo);
        model.addAttribute("startTimeString",startTimeString);
        model.addAttribute("endTimeString",startTimeString);

        return "productinfo/updateproduct";
    }

    @RequestMapping(path = {"/updateproduct"}, method = {RequestMethod.GET,RequestMethod.POST})
    public String updateProductInfo(Model model,ProductInfo productInfo) {
        productInfoService.updateProductInfo(productInfo);
        System.out.println(productInfo);
        return "redirect:listproduct";
    }

    @RequestMapping(path = {"/toupdateproductstate"}, method = {RequestMethod.GET})
    public String toupdateproductstate(Model model,
                                      @RequestParam("id") int id) {
        ProductInfo productInfo = productInfoService.queryProductInfoById(id);
        System.out.println(productInfo);
        Date starttime = productInfo.getStartTime();
        Date endtime = productInfo.getEndTime();
        String startTimeString = "";
        String endTimeString = "";
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        if(starttime!=null){
            startTimeString = dateFormat.format(starttime);
        }
        if(endtime!=null){
            endTimeString = dateFormat.format(endtime);
        }
        model.addAttribute("productInfo",productInfo);
        model.addAttribute("startTimeString",startTimeString);
        model.addAttribute("endTimeString",startTimeString);

        return "productinfo/updateproductstate";
    }

    @RequestMapping(path = {"/updateproductstate"}, method = {RequestMethod.GET,RequestMethod.POST})
    public String updateProductState(Model model,
                                     int id , int state) {
        productInfoService.updateProductState(id ,state);
        return "redirect:listproduct";
    }

    @RequestMapping(path = {"/listproduct"}, method = {RequestMethod.GET})
    public String listproduct(Model model,
                                ProductInfoVO productInfoVO) {
        List<ProductInfo> list = productInfoService.listProduct(productInfoVO);
        model.addAttribute("list",list);
        return "productinfo/list";
    }

    @RequestMapping(path = {"/queryproductinfobyid"}, method = {RequestMethod.GET})
    public String queryProductInfoById(Model model,
                            @Param("id") int id) {
        ProductInfo productInfo = productInfoService.queryProductInfoById(id);
        System.out.println(productInfo);
        model.addAttribute("productinfo",productInfo);
        return "productinfo/view";
    }

    @RequestMapping(path = {"/del"}, method = {RequestMethod.GET,RequestMethod.POST})
    public String del(@Param("id") int id) {
        productInfoService.deleteProductInfoById(id);
        return "redirect:listproduct";
    }

//    @RequestMapping(path={"/profile/{groupId}/{userId}"})
//    @ResponseBody
//    public String profile(@PathVariable("userId") int userId,
//                          @PathVariable("groupId") String groupId,
//                          @RequestParam(value = "type",defaultValue = "1") int type,
//                          @RequestParam(value = "key",required = false)String key){
//        return String.format("Profile Page of %s / %d, t:%d k:%s",groupId,userId,type,key);
//    }
//
//    @RequestMapping(path={"/home"},method = {RequestMethod.GET})
//    public String template(Model model){
//        model.addAttribute("name","thymeleaf");
//        List<String> colors = Arrays.asList(new String[]{"RED","GREEN","BLUE"});
//        model.addAttribute("colors",colors);
//
//        Map<String,String> map = new HashMap<>();
//        for (int i = 0; i < 4; i++) {
//            map.put(String.valueOf(i),String.valueOf(i*i));
//        }
//        model.addAttribute("map",map);
//        model.addAttribute("user",new User("LEE"));
//        return "home";
//    }
//
//    @RequestMapping(path = {"/request"},method = {RequestMethod.GET})
//    @ResponseBody
//    public String template(Model model,
//                           HttpServletResponse response,
//                           HttpServletRequest request,
//                           HttpSession httpSession,
//                           @CookieValue("JSESSIONID") String sessionId){
//        StringBuilder sb = new StringBuilder();
//        sb.append("COOKIEVALUE:"+sessionId);
//        Enumeration<String>  headerNames = request.getHeaderNames();
//        while (headerNames.hasMoreElements()){
//            String name = headerNames.nextElement();
//            sb.append(name+":"+request.getHeader(name)+"<br>");
//        }
//        if(request.getCookies()!=null){
//            for (Cookie cookie:request.getCookies()) {
//                sb.append("Cookie:" + cookie.getName()+"   value:"+ cookie.getValue()+"<br>");
//            }
//        }
//        sb.append(request.getMethod()+"<br>");
//        sb.append(request.getQueryString()+"<br>");
//        sb.append(request.getPathInfo()+"<br>");
//        sb.append(request.getRequestURI()+"<br>");
//
//        response.addHeader("newcoderId","hello");
//        response.addCookie(new Cookie("usename","newcoder"));
//        return sb.toString();
//    }
//
//    @RequestMapping(path = {"/redirect/{code}"}, method = {RequestMethod.GET})
//    public RedirectView redirect(@PathVariable("code") int code,
//                                 HttpSession httpSession) {
//        String str1 = new String("jump from redirect");
//        httpSession.setAttribute("msg",str1);
//        RedirectView red = new RedirectView("/", true);
//        if (code == 301) {
//            red.setStatusCode(HttpStatus.MOVED_PERMANENTLY);
//        }
//        return  red;
//    }
//
//    @RequestMapping(path = {"/admin"},method = {RequestMethod.GET})
//    @ResponseBody
//    public String admin(@RequestParam("key") String key){
//        if("admin".equals(key)){
//            return "hello admin";
//        }
//        throw new IllegalArgumentException("参数不对");
//    }
//
//    @ExceptionHandler()
//    @ResponseBody
//    public String error(Exception e){
//        return "error:"+e.getMessage();
//    }
}
