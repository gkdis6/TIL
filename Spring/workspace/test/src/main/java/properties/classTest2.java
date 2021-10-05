package properties;

import java.util.*;

public class classTest2 {

	public static void main(String[] args) {
		String className = args[0];
		Map map = new HashMap();
		Class object = null;
		Action instance = null;
		
		try {
			object = Class.forName("properties.Spring");
			instance = (Action)object.newInstance();
			
			map.put("Spring", instance);
			
			object = Class.forName("properties.Summer");
			instance = (Action)object.newInstance();
			map.put("Summer", instance);
			
			object = Class.forName("properties.Fall");
			instance = (Action)object.newInstance();
			map.put("Fall", instance);
			
			object = Class.forName("properties.Winter");
			instance = (Action)object.newInstance();
			map.put("Winter", instance);
			
			instance = (Action)map.get(className);
			instance.execute();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
