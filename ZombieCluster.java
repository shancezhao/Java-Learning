/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pocketgems;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class ZombieCluster {
    static int zombieCluster(String[] arr){
        int visited[] = new int[arr.length];
        int count=0;
        while(true)
        {
            int start = -1;
            for(int i=0;i<visited.length;i++)
            {
                if(visited[i]==0)
                {
                    start = i;
                    break;
                }
            }
            if(start==-1)
            {
                break;
            }
            count++;
            bfs(arr,start,visited);
        }
        System.out.print(count);
        return count;
    }
    static void bfs(String[] graph, int start, int visited[])
    {
        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(start);
        while(!queue.isEmpty())
        {
            int item = queue.pop();
            visited[item] = 1;
            for(int i=0;i<graph.length;i++)
            {
                if(graph[item].charAt(i)=='1' && visited[i]==0)
                {
                    queue.add(i);
                }
            }
        }
    }
}