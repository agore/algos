import java.util.*;

public class OneAway {


        public static void main(String[] argv) {
            OneAway oa = new OneAway();
            assert oa.oneAway("pale", "ple") == true;
            assert oa.oneAway("pales", "pale") == true;
            assert oa.oneAway("pale", "bale") == true;
            assert oa.oneAway("pale", "bake") == false;
            assert oa.oneAway("pale", "pa") == false;
        }

        public boolean oneAway(String s1, String s2) {
            int[] hash = new int[128];
            for (Character c: s1.toCharArray()) {
                hash[c - 'a']++;
            }

            for (Character c: s2.toCharArray()) {
                if (hash[c - 'a'] == 1) hash[c - 'a'] = 0;
            }

            int acc = 0;
            for (int i = 0; i < 128; i++) {
                acc += hash[i];
            }

            System.out.println(Arrays.toString(hash));
            System.out.println(s1 + ", " + s2 + " -> " + acc);
            return acc == 1 || acc == 0;
        }

}

