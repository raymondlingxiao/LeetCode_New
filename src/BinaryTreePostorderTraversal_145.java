public class BinaryTreePostorderTraversal_145 {
    class Recursion{
        private List<Integer> list = new LinkedList<>();

        public List<Integer> postorderTraversal(TreeNode root) {
            if (root == null)
                return list;
            postorderTraversal(root.left);
            postorderTraversal(root.right);
            list.add(root.val);
            return list;
        }
    }

    class Structure{
        public List<Integer> postorderTraversal(TreeNode root) {
            // Using linkedlist instead of list to initiate
            // 如果使用 List<String> list = new LinkedList<string>()声明list的话，那么list调用的都是接口List中虚拟的方法（方法特征即返回类型，函数名，参数都有，就是没有具体实现），如list.add()就是调用该虚拟方法在LinkedList类中具体实现。再声明list = new ArrayList<string>后，然后调用list.add()那么就是调用add()这一虚拟方法在ArrayList类中的具体实现，其实这就是多态。 但是使用这个声明之后，list不能调用ArrayList类中扩展出来的新方法，比如trimTosize()方法，只能调用ArrayList类已经实现的list接口中的虚拟方法。相反使用 ArrayList<String> list = new ArrayList<String>()定义的话就没有问题了
            LinkedList<Integer> result = new LinkedList<>();
            if (root == null)
                return result;
            Deque<TreeNode> stack = new ArrayDeque<>();
            stack.push(root);
            while (stack.peek() != null){
                TreeNode node = stack.pop();
                result.addFirst(node.val);
                if (node.left != null)
                    stack.push(node.left);
                if (node.right != null)
                    stack.push(node.right);
            }
            return result;
        }

    }
}

