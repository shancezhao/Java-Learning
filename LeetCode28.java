package leetcode_PocketGems;

/**
 *
 * @author zhaos
 *
 * Implement strStr(). Returns the index of the first occurrence of needle in
 * haystack, or -1 if needle is not part of haystack.
 *
 */
public class LeetCode28 {

    public int strStr(String haystack, String needle) {
        /*        Function 1
        int len = needle.length();
        int str = haystack.indexOf(needle, 0);//时间复杂度O(n*m)暴力匹配
        System.out.print(str);
        return str;
         */

        //not very familiar with KMP
        char[] hay = haystack.toCharArray();
        char[] ndl = needle.toCharArray();
  
        if(haystack.equals("")&&!needle.equals("")) return -1;
        if(needle.equals("")) return 0;
      else
            return KMP(hay, ndl);
    }
    public static int[] next(char[] t)
    {
        int[] next = new int[t.length];
        next[0]=-1;
        int i=0;
        int j = -1;
        while(i<t.length-1)
        {
            if(j==-1||t[i]==t[j])
            {
                i++;
                j++;
                if(t[i]!=t[j])
                {
                    next[i]=j;
                }
                else{
                    next[i] = next[j];
                }
            }
            else{
                j=next[j];
            }
        }
        return next;
    }
    public static int KMP(char[] hay, char[] ndl)
    {
        int[] next = next(ndl);
        int i=0,j = 0;
        while(i<=hay.length-1 && j<=ndl.length-1)
        {
            if(j == -1 || hay[i]==ndl[j])
            {
                i++;
                j++;
            }
            else{
                j=next[j];
            }
        }
        if(j<ndl.length)
            return -1;
        else
            return i-ndl.length;
    }
}
