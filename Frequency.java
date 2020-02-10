import java.util.*;
import java.util.function.Function;

public class Frequency {

    public void getFrequency1(String str) {
        Comparator byKey = Comparator.comparingInt(String::length).thenComparing(Function.identity());
        Map<String, Integer> map = new TreeMap<String, Integer>(byKey);

        String[] arr = str.split(" ");
        for (String s : arr) {
            map.putIfAbsent(s, 0);
            map.computeIfPresent(s, (k, v) -> v += 1);
        }

        map.forEach((k, v) -> {
            System.out.println(v + " " + k);
        });

    }

    public void getFrequency2(String str) {
        Comparator<Occurance> byLengthAndLetter = Comparator.comparingInt((Occurance o) -> o.word.length()).thenComparing(o -> o.word);
        List<Occurance> list = new ArrayList<>();
        String[] arr = str.split(" ");
        for (String s : arr) {
            boolean exists = false;
            for (Occurance occ : list) {
                if (occ.word.equals(s)) {
                    exists = true;
                    occ.count++;
                }
            }
            if (!exists) {
                Occurance occ = new Occurance(s);
                list.add(occ);
            }
        }
        list.sort(byLengthAndLetter);
        list.forEach(e->System.out.println(e.count + " " + e.word));
    }

    static class Occurance {
        Integer count;
        String word;

        Occurance(String word) {
            this.word = word;
            this.count = 1;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Occurance occurance = (Occurance) o;
            return Objects.equals(count, occurance.count) &&
                    Objects.equals(word, occurance.word);
        }

        @Override
        public int hashCode() {
            return Objects.hash(count, word);
        }
    }

    public static void main(String[] args) {
        Frequency freq = new Frequency();
        String str = "The quick brown fox jumped over the lazy brown dog's back";
        freq.getFrequency1(str);
        freq.getFrequency2(str);
    }

}
