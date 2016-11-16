package per.sd.string;



import java.util.HashMap;
import java.util.Map;


public class Mykey
{

    public static void main(String[] args)
    {
        Map<Key, Value> map = new HashMap<Key, Value>();
        Key key1 = new Key("1");
        Value v1 = new Value(1);
        map.put(key1, v1);

        Key key2 = new Key("1");
        System.out.println(map.get(key2));//没有重写equals或hashCode，返回null

        if (null != map.get(key2))
        {
            System.out.println(map.get(key2).getValue());
        }

    }
}


class Key
{

    private String id;

    public Key(String id)
    {
        this.id = id;
    }

    public String getId()
    {
        return id;
    }

//    @Override
//    public boolean equals(Object obj)
//    {
//        if (obj == null || !(obj instanceof Key) || null == this.id)
//        {
//            return false;
//        }
//
//        Key key = (Key) obj;
//
//        return this.id.equals(key.getId());
//    }
    
    @Override
    public int hashCode()
    {
        return this.id.hashCode();
    }
}


class Value
{

    private int value;

    public Value(int value)
    {
        this.value = value;
    }

    public int getValue()
    {
        return value;
    }
}

