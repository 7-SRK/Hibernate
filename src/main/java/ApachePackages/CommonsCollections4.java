package ApachePackages;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.IterableUtils;
import org.apache.commons.collections4.ListUtils;
import org.apache.commons.collections4.MapUtils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommonsCollections4 {
    public static void main(String[] args) {

        List<String> list1 = Arrays.asList("A","B","C");
        List<String> list2 = Arrays.asList("B","C","D");

        //CollectionUtils Intersection
        List<String> intersection = (List<String>) CollectionUtils.intersection(list1,list2);
        System.out.println("Intersection: "+ intersection);

        //CollectionUtils Disjunction
        List<String> disjunction = (List<String>) CollectionUtils.disjunction(list1,list2);
        System.out.println("Disjunction : "+ disjunction);

        //IterableUtils
        int size = IterableUtils.size(list1);
        System.out.println("Iterable Size: " + size);

        //ListUtils
        List<String> safeList = ListUtils.emptyIfNull(null);
        System.out.println("Empty List Safe: "+ safeList);

        //MapUtils
        Map<String, String> map = new HashMap<>();
        map.put("Key1" , "Value1");
        Map<String, String> safemap = MapUtils.emptyIfNull(null);
        System.out.println("Safe map: " + safemap);
        System.out.println("Value from map.get(key1): " + MapUtils.getString(map,"Key1","default"));

    }
}
