class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
		Map<String, List<String>> map = new HashMap<String, List<String>>();

		for (String s : strs) {
			char[] ch = s.toCharArray();
			Arrays.sort(ch);
			String ss = String.valueOf(ch);
			List<String> list;

			if (!map.containsKey(ss)) {
				list = new ArrayList<String>();
			} else {
				list = map.get(ss);
			}
			list.add(s);
			map.put(ss, list);
		}
		List<List<String>> result = new ArrayList<List<String>>();
		for (List<String> ls : map.values()) {
			result.add(ls);
		}
        return result;
    }
}
