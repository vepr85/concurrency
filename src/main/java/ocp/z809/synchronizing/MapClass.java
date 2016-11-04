package ocp.z809.synchronizing;


import java.util.HashMap;

/**
 * Created by abyakimenko on 26.10.2016.
 */
public class MapClass {

    public MapClass() {
    }

    public MapClass(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int x;
    public int y;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MapClass myClass = (MapClass) o;

        return x == myClass.x;
    }

    @Override
    public int hashCode() {
        return x;
    }

    public static void main(String[] args) {

        MapClass t1 = new MapClass(5, 10);
        MapClass t2 = new MapClass(10, 10);

        HashMap<MapClass, String> map = new HashMap<>();

        MapClass clazz = new MapClass(5, 10);

        map.put(clazz, "EEE");
        map.put(t1, "T11111");
        map.put(t2, "T22222");
        String res = map.get(clazz);

        clazz.x = 10;

        String res1 = map.get(clazz);
        String res2 = map.get(new MapClass(5, 10));
        String res3 = map.get(t2);

        map.put(clazz, "EEE");

    }
}
