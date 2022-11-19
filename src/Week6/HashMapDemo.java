import java.util.*;

public class HashMapDemo {
    public static void main(String[] args) {
        HashMap<String, Integer> hm1 = new HashMap<>();
        hm1.put("PHCT", 170);
        hm1.put("VTAT", 180);
        hm1.put("ABCD", 190);

        Iterator it = hm1.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry x = (Map.Entry) it.next();
            System.out.println(x.getKey());
        }

        System.out.println(hm1.get("PHCT"));

        System.out.println(hm1.get("Xam"));

        hm1.put("PHCT", 180); // Thao tác cập nhật
        System.out.println(hm1.get("PHCT")); // Nên chọn key khéo để tránh trùng
    }
}

//class YearComparator implements Comparator<Movie> {
//    public int compare(Movie m1, Movie m2) {
//        @Override
//        // year decreasing
//        if (m1.getYear() < m2.getYear()) {
//            return -1;
//        }
//        if (m1.getYear() > m2.getYear()) {
//            return 1;
//        }
//        else return 0;
//    }
//}
