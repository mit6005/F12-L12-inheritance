package beforeclass;

import java.util.HashMap;
import java.util.Map;

public class BreakingProperties {

    // Java 1.0 had a Hashtable class for storing arbitrary Object
    // key -> Object value mappings.  It looked a bit like this
    static class Hashtable {
        private Map<Object,Object> map = new HashMap<Object,Object>();
        public Object get(Object key) {  return map.get(key); }
        public void put(Object key, Object value) { map.put(key, value); }
    }
    
    // Java 1.0 had a Properties class that subclassed Hashtable, 
    // designed *only* for String key -> String value mappings
    static class Properties extends Hashtable {
        // rep invariant: the map contains only String keys and String values
        public String getProperty(String key) { return (String) get(key); }
        public void putProperty(String key, String value) { put(key, value); }
    }
    
    public static void main(String[] args) {
        // here's some client code
        Properties props = new Properties();
        props.putProperty("name", "Ben");
        System.out.println(props.getProperty("name")); 
        // so far so good
        
        // but the client can also call Hashtable methods on props!
        props.put("age", new Integer(25));
        // what's happened to the prop's object's rep invariant?
        System.out.println(props.getProperty("age"));
    }
}
