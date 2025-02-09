class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<List<String>>();
		Map<String, List<String>> map = new HashMap<String, List<String>>();

		for (String s : strs) {
			char[] chs = s.toCharArray();
			Arrays.sort(chs);
			map.computeIfAbsent(String.valueOf(chs), k -> new ArrayList<>()).add(s);
		}
		
		for(String k:map.keySet()) {
			result.add(map.get(k));
		}
			System.out.println(result);
		return result;
    }
}
