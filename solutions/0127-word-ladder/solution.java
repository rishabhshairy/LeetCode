class Solution {
	static class Word {
		String word;
		int step;

		public Word(String word, int step) {
			this.word = word;
			this.step = step;
		}

	}
	public int ladderLength(String beginWord, String endWord,
			List<String> wordList) {
		// add words to set to remove duplicates
		Set<String> wordSet = new LinkedHashSet<String>(wordList);
		// remove begin word to start
		wordSet.remove(beginWord);

		Queue<Word> nodeQueue = new LinkedList<>();
		nodeQueue.add(new Word(beginWord, 1));

		while (!nodeQueue.isEmpty()) {

			Word curr = nodeQueue.poll();
			String currWord = curr.word;
			if (curr.word.equals(endWord)) {
				return curr.step;
			}

			for (int i = 0; i < currWord.length(); i++) {
				for (char ch = 'a'; ch <= 'z'; ch++) {
					char[] wordChar = currWord.toCharArray();
					wordChar[i] = ch; // replace characters for curr word and
										// check in set
					if (wordSet.contains(String.valueOf(wordChar))) {
                        wordSet.remove(String.valueOf(wordChar));
						nodeQueue.offer(new Word(String.valueOf(wordChar),
								curr.step + 1));
					}
				}
			}
		}
		return 0;
	}
}
