package com.jooc.GazeOffer;

import com.jooc.components.TreeNode;

public class Solution_37 {

    public void main(){
        Codec codec = new Codec();
        String str = codec.serialize(TreeNode.instance());
        System.out.println(str);
        codec.deserialize(str);
    }

    /**
     * recur_serialize
     */
    public class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            if(root == null) return "[]";

            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append('[');

            recur_serialize(root, stringBuilder);

            stringBuilder.deleteCharAt(stringBuilder.length()-1);
            stringBuilder.append(']');
            return stringBuilder.toString();
        }

        private void recur_serialize(TreeNode node, StringBuilder stringBuilder){
            stringBuilder.append(node.val);
            stringBuilder.append(',');

            if(node.left != null) {
                recur_serialize(node.left, stringBuilder);
            }else {
                stringBuilder.append("null,");
            }
            if(node.right != null) {
                recur_serialize(node.right, stringBuilder);
            }else {
                stringBuilder.append("null,");
            }
        }

        // Decodes your encoded data to tree.
        int index = 0;
        public TreeNode deserialize(String data) {
            if(data.equals("[]")) return null;

            String[] nums = data.substring(1, data.length()-1).split(",");
            TreeNode res = recur_deserialize(nums);

            return res;
        }

        public TreeNode recur_deserialize(String[] nums){
            TreeNode node = null;
            if(!nums[index].equals("null")){
                node = new TreeNode(Integer.valueOf(nums[index++]));

                node.left = recur_deserialize(nums);

                node.right = recur_deserialize(nums);
            }else{
                index++;
            }

            return node;
        }
    }

    /**
     * LeverOrder
     */
//    public class Codec {
//        // Encodes a tree to a single string.
//        public String serialize(TreeNode root) {
//            StringBuilder stringBuilder = new StringBuilder();
//            LinkedList<TreeNode> queue = new LinkedList<>();
//            queue.add(root);
//
//            stringBuilder.append('[');
//            while(!queue.isEmpty()){
//                TreeNode node = queue.poll();
//                if(node == null){
//                    stringBuilder.append("null");
//                }else{
//                    stringBuilder.append(node.val);
//                    queue.add(node.left);
//                    queue.add(node.right);
//                }
//                stringBuilder.append(',');
//            }
//            stringBuilder.deleteCharAt(stringBuilder.length()-1);
//            stringBuilder.append(']');
//
//            return stringBuilder.toString();
//        }
//
//        // Decodes your encoded data to tree.
//
//        public TreeNode deserialize(String data) {
//            if(data.equals("[]")) return new TreeNode();
//
//            String[] nums = data.substring(1, data.length()-1).split(",");
//            LinkedList<TreeNode> queue = new LinkedList<>();
//            TreeNode res = new TreeNode(Integer.valueOf(nums[0]));
//            queue.add(res);
//
//            int index = 1;
//            while(!queue.isEmpty()){
//                TreeNode node = queue.poll();
//
//                if(!nums[index].equals("null")){
//                    node.left = new TreeNode(Integer.valueOf(nums[index]));
//                    queue.add(node.left);
//                }
//                index++;
//                if(!nums[index].equals("null")){
//                    node.right = new TreeNode(Integer.valueOf(nums[index]));
//                    queue.add(node.right);
//                }
//                index++;
//            }
//
//            return res;
//        }
//    }


}
