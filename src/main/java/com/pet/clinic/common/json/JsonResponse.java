package com.pet.clinic.common.json;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.google.gson.GsonBuilder;

/**
 * 
 * @author lixiejun
 * 解析返回的数据
 */
@Component
public class JsonResponse {

	private final GsonBuilder gsonbuilder; 

	public JsonResponse() {
		gsonbuilder = new GsonBuilder().serializeNulls();
	}
	
	public String ok () {
		return gsonbuilder.create().toJson(this.getResultTemplate());
	}
	
	public String okWithData(Object data) {
		Map<String,Object> result = this.getResultTemplate();
		result.put("data",data);
		return gsonbuilder.create().toJson(result);
	}
	
	public String error(String errorMessage) {
		Map<String,Object> result = new HashMap<String,Object>();
		result.put("code",ResponseCode.ERROR );
		result.put("msg", errorMessage);
		return gsonbuilder.create().toJson(result);
	}
	
	private Map<String,Object> getResultTemplate(){
		Map<String,Object> result = new HashMap<String,Object>();
		result.put("code",ResponseCode.SUCESS );
		result.put("msg", "ok");
		return result;
	}
}
