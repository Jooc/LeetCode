public class Main {
    class Solution_StringBuilder {
        public String replaceSpace(String s) {
            StringBuilder builder = new StringBuilder();

            for(Character c : s.toCharArray()){
                builder.append(c==' ' ? "%20" : c);
            }

            return builder.toString();
        }
    }

    class Solution_traversal {
        public String replaceSpace(String s) {
            char[] chars = new char[s.length() * 3];
            int index = 0;

            for(Character c : s.toCharArray()){
                if(c == ' '){
                    chars[index++] = '%';
                    chars[index++] = '2';
                    chars[index++] = '0';
                }else{
                    chars[index++] = c;
                }
            }
            String ans = new String(chars, 0, index);
            return ans;
        }
    }

    public static void main(String[] args) {
        Solution_traversal solution = new Main().new Solution_traversal();

        System.out.println(solution.replaceSpace("We are happy."));
    }
}
