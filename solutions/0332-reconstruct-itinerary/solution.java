class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        // Step 1 --> construct graphs

        Map<String, PriorityQueue<String>> graph = new HashMap<>();

        // Map<String, Integer> inDegree = new HashMap<>();
        // Map<String, Integer> outDegree = new HashMap<>();

        for (List<String> ticket : tickets) {
            String start = ticket.get(0);
            String end = ticket.get(1);

            graph.computeIfAbsent(start, k -> new PriorityQueue<>()).add(end);
            // outDegree.put(start, outDegree.getOrDefault(start, 0) + 1);
            // inDegree.put(end, inDegree.getOrDefault(end, 0) + 1);
        }

        String startNode = "JFK";
        List<String> result = new ArrayList<>();
        visit(startNode, graph, result);

        Collections.reverse(result);
        // System.out.println(result);
        return result;
    }

    private void visit(String startNode, Map<String, PriorityQueue<String>> graph, List<String> result) {
        PriorityQueue<String> arrivalCity = graph.get(startNode);

        while (arrivalCity != null && !arrivalCity.isEmpty()) {
            String nextCity = arrivalCity.poll();
            visit(nextCity, graph, result);
        }
        result.add(startNode);
    }
}
