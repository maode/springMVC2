package org.code0.base.model;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;


/**  
 * @Title: BaseModel.java
 * @Package org.code0.base.model
 * @Description: BaseModel.java
 * @author Code0   
 * @date 2017年9月11日 下午5:51:37 
 */
public class BaseModel {


	@Override
	public String toString() {

		return JSON.toJSONString(this, new SerializerFeature[]{
				SerializerFeature.WriteMapNullValue, 
				SerializerFeature.WriteNullListAsEmpty,
                SerializerFeature.WriteNullStringAsEmpty, 
                SerializerFeature.WriteNullNumberAsZero, 
                SerializerFeature.WriteNullBooleanAsFalse,
                SerializerFeature.UseISO8601DateFormat});
	}

	
}
