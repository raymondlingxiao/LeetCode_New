import java.util.Queue;

public class AlienDict_269 {
    public String alienOrder(String[] words) {
        // topo sort
        if (words == null || words.length == 0)
            return "";
        HashMap<Character,HashSet<Character>> map = new HashMap<>();
        Integer[] degree = new Integer[26];
        Queue<Character> queue = new LinkedList<>();
        StringBuilder res = new StringBuilder();
        int cnt = 0;
        // initialize degree
        for (String str: words){
            for (char ch:str.toCharArray()){
                degree[ch-'a'] = 0;
            }
        }
        // intialize the graph
        for (int i=0;i<words.length-1;i++){
            char[] cur = words[i].toCharArray();
            char[] nxt = words[i+1].toCharArray();

            // compare till one array is to the end
            int len = Math.min(cur.length,nxt.length);

            for (int j = 0;j<len;j++){
                if (cur[j] != nxt[j]){
                    if (!map.containsKey(cur[j])){
                        map.put(cur[j], new HashSet<Character>());
                    }
                    if (map.get(cur[j]).add(nxt[j]))
                        degree[nxt[j] - 'a'] ++;

                }
            }
        }

        // start topo sort
        for (int n = 0;n<degree.length;n++){
            if (degree[n] != null && degree[n] == 0){
                char temp = 'a';
                temp += n;
                queue.offer(temp);
                cnt++;
            }
        }

        while (!queue.isEmpty()){
            Character node = queue.poll();
            res.append(node);
            // go though linked nodes
            if (!map.containsKey(node))
                continue;
            for(Character ch: map.get(node)){
                degree[ch-'a']--;
                if (degree[ch - 'a'] == 0){
                    queue.offer(ch);
                    cnt ++;
                }

            }
        }

        if (cnt == res.length())
            return res.toString();
        else
            return "";
    }
}
