class Solution {
    public int minSteps(String s, String t) {
        HashMap<Character, Integer> countOfS = new HashMap<>();

        for (char c :
                s.toCharArray()) {
            if (countOfS.containsKey(c)) {
                countOfS.put(c, countOfS.get(c) + 1);
            } else {
                countOfS.put(c, 1);
            }
        }

        int answer = 0;
        for (char c :
                t.toCharArray()) {
            if (countOfS.containsKey(c) && countOfS.get(c) > 0) {
               // System.out.println(countOfS.get(c) + " " + c);
                countOfS.put(c, countOfS.get(c) - 1);
            } else {
              //  System.out.println(c);
                answer++;
            }
        }
        return answer;
    }
}
