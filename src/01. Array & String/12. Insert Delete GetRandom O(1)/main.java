import java.util.*;

class InsertDeleteGetRandom {
    static class RandomizedSet {
        List<Integer> list;
        Map<Integer, Integer> map;
        Random random;

        public RandomizedSet() {
            list = new ArrayList<>();
            map = new HashMap<>();
            random = new Random();
        }

        public boolean insert(int val) {
            if (map.containsKey(val)) {
                return false; // already exists
            }
            list.add(val);
            map.put(val, list.size() - 1);
            return true;
        }

        public boolean remove(int val) {
            if (!map.containsKey(val)) {
                return false; // doesn't exist
            }
            int index = map.get(val);
            int lastElement = list.get(list.size() - 1);
            list.set(index, lastElement);
            map.put(lastElement, index);
            list.remove(list.size() - 1);
            map.remove(val);
            return true;
        }

        public int getRandom() {
            // return a random element from list
            return list.get(random.nextInt(list.size()));
        }
    }

    public static void main(String[] args) {
        RandomizedSet obj = new RandomizedSet();
        System.out.println(obj.insert(1));   
        System.out.println(obj.remove(2)); 
        System.out.println(obj.insert(2));  
        System.out.println(obj.getRandom()); 
        System.out.println(obj.remove(1));
        System.out.println(obj.insert(2)); 
        System.out.println(obj.getRandom());
    }
}