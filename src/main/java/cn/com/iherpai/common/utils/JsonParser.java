package cn.com.iherpai.common.utils;

import java.io.StringWriter;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonParser {
	private static final ObjectMapper mapper = new ObjectMapper();

	public static String jsonFromObject(Object object) {
		StringWriter writer = new StringWriter();
		try {
			mapper.writeValue(writer, object);
		} catch (RuntimeException e) {
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return writer.toString();
	}
	
//	public static <T> T objFromJson(String json, Class<T> klass) {
//		return objectFromJson(json, klass);
//	}

	public static <T> T objectFromJson(String json, Class<T> klass) {
		T object;
		try {
			object = mapper.readValue(json, klass);
		} catch (RuntimeException e) {
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return object;
	}
	
	
	
	
}
