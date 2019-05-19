package com.nineboy.seckill.controller;

import com.nineboy.seckill.model.Merchant;
import com.nineboy.seckill.model.User;
import com.nineboy.seckill.service.MerchantService;
import com.nineboy.seckill.service.UserService;
import com.nineboy.seckill.vo.MerchantVO;
import com.nineboy.seckill.vo.UserVO;
import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping(path ={"/user"} )
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    UserService userService;

    @RequestMapping(path = {"/toadd"}, method = {RequestMethod.GET})
    public String toadd() {
        return "user/add";
    }

    @RequestMapping(path ={"/add"},method = {RequestMethod.GET,RequestMethod.POST})
    public String add(User user){
        userService.insertUser(user);
        System.out.println(user);
        return "redirect:querybyvo";
    }

    @RequestMapping(path = {"/toupdate"}, method = {RequestMethod.GET})
    public String toupdate(Model model,
                           @RequestParam("id") int id) {
        User user  = userService.queryUserById(id);
        System.out.println(user);
        model.addAttribute("user",user);
        return "user/update";
    }

    @RequestMapping(path = {"/update"}, method = {RequestMethod.GET,RequestMethod.POST})
    public String update(Model model,User user) {
        userService.updateUser(user);
        System.out.println(user);
        return "redirect:querybyvo";
    }

    @RequestMapping(path = {"/querybyvo"}, method = {RequestMethod.GET})
    public String querybyvo(Model model,
                            UserVO userVO) {
        List<User> list = userService.queryUserByVo(userVO);
        model.addAttribute("list",list);
        return "user/list";
    }

    @RequestMapping(path = {"/querybyid"}, method = {RequestMethod.GET})
    public String querybyid(Model model,
                            @Param("id") int id) {
        User user = userService.queryUserById(id);
        System.out.println(user);
        model.addAttribute("user",user);
        return "user/view";
    }

    @RequestMapping(path = {"/del"}, method = {RequestMethod.GET,RequestMethod.POST})
    public String del(@RequestParam("id") int id) {
        userService.deleteUserById(id);
        return "redirect:querybyvo";
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
