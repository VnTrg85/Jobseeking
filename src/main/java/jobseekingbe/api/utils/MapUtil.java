package jobseekingbe.api.utils;

import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class MapUtil {
	public static <T> T getJob(Map<String, Object> params,String name,Class<T> tclass) {
		Object object=params.getOrDefault(name, null);
		if(object !=null) {
			if(tclass==Long.class){
				object=object!=""?Long.valueOf(object.toString()):null;
			}else if(tclass==Integer.class) {
				object=object!=""?Integer.valueOf(object.toString()):null;
			}else {
				object=object!=""?String.valueOf(object.toString()):null;
			}
		}return tclass.cast(object);
	}
}
