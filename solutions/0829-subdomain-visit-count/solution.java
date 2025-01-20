class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        		List<String> result = new ArrayList<String>();
		Map<String, Integer> map = new HashMap<>();

		for (String domain : cpdomains) {
			String[] domainSplit = domain.split(" ");
			String count = domainSplit[0];

			map.put(domainSplit[1], map.getOrDefault(domainSplit[1], 0)
					+ Integer.parseInt(count));
			int firstSepIndex = domainSplit[1].indexOf('.');

			map.put(domainSplit[1].substring(firstSepIndex + 1),
					map.getOrDefault(
							domainSplit[1].substring(firstSepIndex + 1), 0)
							+ Integer.parseInt(count));

			int secondSepIndex = domainSplit[1].lastIndexOf('.');
			if (firstSepIndex == secondSepIndex) {
				continue;
			} else {
				map.put(domainSplit[1].substring(secondSepIndex + 1),
						map.getOrDefault(
								domainSplit[1].substring(secondSepIndex + 1), 0)
								+ Integer.parseInt(count));
			}

		}
		for (String key : map.keySet()) {
			result.add(new String(map.get(key) + " " + key));
		}
//		System.out.println(result);
		return result;
    }
}
