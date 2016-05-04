package APL.assign.dodary;

import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

public class DynamicClassProvider {

	static Map< Pair<String,String> , String > m_cls = new HashMap< Pair<String,String> , String >();
	static Map< Pair<String,String> , Class<?> > m_cache = new WeakHashMap< Pair<String,String> , Class<?> >();
	static Pair<String, String> pair = new Pair<String, String>("t1", "t2");
	
	public static void register(String nick, String creator, String path){
		pair.setPair(nick, creator);
		m_cls.put(pair, path);
	}

	public static Object newInstance(String nick, String creator) 
			throws ClassNotFoundException, InstantiationException, IllegalAccessException {
				
		pair.setPair(nick, creator);
				
		// finding classpath
		String classPath = m_cls.get(pair);
				
		// cashing class
		if (m_cache.containsKey(pair))  // if cache has the key
		{
			return m_cache.get(pair).newInstance();
		}
		else 
		{
			// loading the class
			Class<?> cls = Class.forName(classPath);
			m_cache.put(pair, cls);
			
			return cls.newInstance();
		}
	}
}