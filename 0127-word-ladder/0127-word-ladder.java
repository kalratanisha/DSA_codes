class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);
        if (!set.contains(endWord)) return 0;

        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);
        int level = 1;

        while (!q.isEmpty()) {
            int size = q.size();

            while (size-- > 0) {
                String s = q.poll();
                char[] a = s.toCharArray();

                for (int i = 0; i < a.length; i++) {
                    char old = a[i];

                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == old) continue;

                        a[i] = c;
                        String next = new String(a);

                        if (next.equals(endWord))
                            return level + 1;

                        if (set.remove(next))
                            q.offer(next);
                    }

                    a[i] = old;
                }
            }

            level++;
        }

        return 0;
    }
}