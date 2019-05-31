package com.wisely.highlight_springmvc4.web.ch4_3;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wisely.highlight_springmvc4.domian.DemoObj;

@RestController
@RequestMapping("/rest")
public class DemoRestController {
	
	@RequestMapping(value="/getjson",produces={"application/json;charset=UTF-8"})
	public DemoObj getjson(DemoObj obj){
		return new DemoObj(obj.getId()+1,obj.getName()+"yy");
	}
	
	@RequestMapping(value="/getxml",produces={"application/xml;charset=UTF-8"})
	public DemoObj getxml(DemoObj obj){
		return new DemoObj(obj.getId()+1,obj.getName()+"yy");
	}
}
