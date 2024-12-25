/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Map<Node, Node> nodeMap = new LinkedHashMap<>();

        Node temp = head;
        while (temp != null) {
            Node copyNode = new Node(temp.val);
            nodeMap.put(temp, copyNode);
            temp = temp.next;
        }

        temp = head;
        while (temp != null) {
            Node copyNode = nodeMap.get(temp);
            copyNode.next = nodeMap.get(temp.next);
            copyNode.random = nodeMap.get(temp.random);
            temp=temp.next;
        }
        temp = head;
        return nodeMap.get(temp);
    }
}
