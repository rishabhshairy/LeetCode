class Solution {
    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjacencyList = prepareDirectedGraph(prerequisites, numCourses);

        // First find in-degrees of courses
        int[] inDegrees = new int[numCourses];

        for (int currNode = 0; currNode < numCourses; currNode++) {
            for (Integer adjNode : adjacencyList.get(currNode)) {
                inDegrees[adjNode]++;
                System.out.println(inDegrees[adjNode]);
            }
        }

        // Declare Queue and add all the nodes with zero in-degrees
        Queue<Integer> courseQueue = new LinkedList<>();
        for (int course = 0; course < inDegrees.length; course++) {
            if (inDegrees[course] == 0) {
                courseQueue.add(course);
            }
        }
        int[] courseOrder = new int[numCourses];
        int index = 0;

        while (!courseQueue.isEmpty()) {
            Integer currCourse = courseQueue.poll();
            courseOrder[index++] = currCourse;
            for (Integer adjCourse :
                    adjacencyList.get(currCourse)) {
                inDegrees[adjCourse]--;
                if (inDegrees[adjCourse] == 0) {
                    courseQueue.add(adjCourse);
                }
            }
        }

        // now check if all the courses are in resulting array
        if (index == numCourses) {
            return courseOrder;
        }
        return new int[0];

    }

    private static List<List<Integer>> prepareDirectedGraph(int[][] edges, int vertex) {
        List<List<Integer>> adjacencyList = new ArrayList<>();

        for (int i = 0; i < vertex; i++) {
            adjacencyList.add(new ArrayList<>());
        }

        for (int i = 0; i < edges.length; i++) {
            adjacencyList.get(edges[i][1]).add(edges[i][0]);
        }
        return adjacencyList;
    }
}
