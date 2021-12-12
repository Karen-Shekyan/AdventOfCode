import java.util.*;
import java.io.*;

public class P12_2 {
  public static int findPaths (String[][] g, ArrayList<String> e, ArrayList<String> r, int index, boolean once, ArrayList<String> v) {
    int ans = 0;
    if (index == -1) {
      return 1;
    }
    else {
      v.add(e.get(index));
      //System.out.println(v);
      for (int i = 0; i < g[index].length; i++) {
        //System.out.println(index);
        if (!r.contains(g[index][i])) {
          int newIndex = e.indexOf(g[index][i]);
          // System.out.println(i + " " + index);
          // System.out.println(g[index].length);
          if (newIndex != -1 && !e.get(newIndex).equals(e.get(newIndex).toUpperCase())) {
            r.add(e.get(newIndex));
          }
          ans += (findPaths(g,e,r,newIndex,once,v));
          //System.out.println(i);
          if (newIndex != -1 && !e.get(newIndex).equals(e.get(newIndex).toUpperCase())) {
            r.remove(r.size()-1);
          }
        }
        else if (!once) {
          int newIndex = e.indexOf(g[index][i]);
          // System.out.println(i + " " + index);
          // System.out.println(g[index].length);
          if (!e.get(newIndex).equals("start")) {
            ans += (findPaths(g,e,r,newIndex,true,v));
          }
          // System.out.println(i);
        }
      }
    }


    return ans;
  }

  public static void main(String[] args) throws IOException {
    File f = new File (args[0]);
    Scanner sc = new Scanner (f);

    ArrayList<String[]> data = new ArrayList<String[]> ();
    while (sc.hasNextLine()) {
      String s = sc.nextLine();
      data.add(s.split("-"));
    }
    //System.out.println(Arrays.toString(data.get(5)));
    ArrayList<String> elements = new ArrayList<String> ();
    for (int i = 0; i < data.size(); i++) {
      for (int j = 0; j < data.get(i).length; j++) {
        if (!elements.contains(data.get(i)[j]) && !data.get(i)[j].equals("end")) {
          elements.add(data.get(i)[j]);
        }
      }
    }
    //System.out.println(elements);

    String[][] graph = new String[elements.size()][];
    for (int i = 0; i < elements.size(); i++) {
      String s = "";
      for (int j = 0; j < data.size(); j++) {
        if (data.get(j)[0].equals(elements.get(i))) {
          //System.out.println(i);
          s += data.get(j)[1] + " ";
        }
        if (data.get(j)[1].equals(elements.get(i))) {
          s += data.get(j)[0] + " ";
        }
      }
      graph[i] = s.split(" ");
    }
    //System.out.println(elements.get(5) + Arrays.toString(graph[5]));
    int s = 0;
    for (int i = 0; i < elements.size(); i++) {
      if (elements.get(i).equals("start")) {
        s = i;
      }
    }
    ArrayList<String> restricted = new ArrayList<String> ();
    restricted.add("start");
    //System.out.println(elements);
    ArrayList<String> visited = new ArrayList<String> ();
    int ans = findPaths(graph,elements,restricted,s,false,visited);
    System.out.println(ans);
  }
}
