class Solution {
	static class Gene {
		String gene;
		int level;

		public Gene(String gene, int level) {
			this.gene = gene;
			this.level = level;
		}
	}

	public int minMutation(String startGene, String endGene, String[] bank) {
		Set<String> geneSet = new LinkedHashSet<String>(Arrays.asList(bank));

		Queue<Gene> nodeQueue = new LinkedList<>();
		nodeQueue.offer(new Gene(startGene, 0));
		char[] allowedChars = {'A', 'C', 'G', 'T'};

		while (!nodeQueue.isEmpty()) {
			Gene curr = nodeQueue.poll();
			String currGene = curr.gene;
			int level = curr.level;

			if (currGene.equals(endGene)) {
				return level;
			}

			for (int i = 0; i < currGene.length(); i++) {
				for (char ch : allowedChars) {
					char[] toReplace = currGene.toCharArray();
					toReplace[i] = ch;
					String transfomedGene = String.valueOf(toReplace);
					if (geneSet.contains(transfomedGene)) {
						geneSet.remove(transfomedGene);
						nodeQueue.offer(new Gene(transfomedGene, level + 1));
					}
				}
			}
		}
		return -1;
	}
}
