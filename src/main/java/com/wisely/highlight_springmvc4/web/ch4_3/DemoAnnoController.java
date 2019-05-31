package com.wisely.highlight_springmvc4.web.ch4_3;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wisely.highlight_springmvc4.domian.DemoObj;

@Controller //@Controller注解声明此类是一个控制器
@RequestMapping("/anno")//@RequestMapping("/anno")映射此类的访问路径是/anno
public class DemoAnnoController { 
	//此方法未标注路径，因此使用类级别为/anno，procuces可定制返回的response媒体类型和字符集，或需要返回json对象则设置produces="application/json;charset=UTF-8"
	@RequestMapping(produces="text/plain;charset=UTF-8")
	public @ResponseBody String index(HttpServletRequest request){
		return "url:"+request.getRequestURI()+" can access";
	}
	
	@RequestMapping(value="/pathvar/{str}",produces="text/plain;charset=UTF-8")
	//@PathVariable表示访问路径为/anno/pathvar/XX
	public @ResponseBody String demoPathVar(@PathVariable String str,HttpServletRequest request){
		return "url:"+request.getRequestURI()+" can access,str:"+str;
	}
	
	//request获取参数访问路径为/anno/requestParam?id=1
	@RequestMapping(value="/requestparam",produces="text/plain;charset=UTF-8")
	public @ResponseBody String passRequestParam(Long id,HttpServletRequest request){
		return "url:"+request.getRequestURI()+" can access,id:"+id;
	}
	
	@RequestMapping(value="/obj",produces="text/plain;charset=UTF-8")
	public @ResponseBody String passObj(DemoObj obj,HttpServletRequest request){
		return "url:"+request.getRequestURI()+" can access,obj id:"+obj.getId()+"obj name:"+obj.getName();
	}
	
	//@ResponseBody 演示映射不用的路径到相同的方法，访问路径为/anno/name1或/anno/name2
	@RequestMapping(value={"/name1","/name2"},produces="text/plain;charset=UTF-8")
	public @ResponseBody String remove(HttpServletRequest request){
		return "url:"+request.getRequestURI()+" can access";
	}
}
