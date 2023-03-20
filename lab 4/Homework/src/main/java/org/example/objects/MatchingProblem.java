package org.example.objects;
import java.util.*;
import java.util.stream.*;
public class MatchingProblem {
    private static Map<Student,List<Project>> prefMap = new TreeMap<>();
    private  static Map<Student,Project> greedyMap = new TreeMap<>();
    public static Map<Student,List<Project>> getPrefMap() {return prefMap;}
    public static Map<Student,Project> getGreedyMap() {return greedyMap;}

    public  static  void addList(Student student, List<Project> projects){
        prefMap.put(student,projects);
    }

    public List<Student> getStudentsWithFewerPreferences() {
        int avg = prefMap.values().stream()
                .mapToInt(List::size)
                .sum();
        List<Student> pref = prefMap.entrySet().stream()
                .filter(e -> e.getValue().size() < avg / prefMap.size())
                .map(Map.Entry::getKey)
                .toList();
        return pref;
    }

    public static void Greedy() {
        List<Project> remove_proj = new ArrayList<>();
        int iterator,ok;
        for(Student i:prefMap.keySet()){
            List<Project> j=prefMap.get(i);
            iterator =0;
            ok=1;
            while (iterator<j.size()){
                if(remove_proj.size()==0){
                    greedyMap.put(i,j.get(iterator));
                    remove_proj.add(j.get(iterator));
                    break;
                }else {
                    for (int poz = 0; poz <remove_proj.size();poz++){
                        if(j.get(iterator)==remove_proj.get(poz)){
                            ok=0;
                            break;
                        }
                    }
                    if(ok==1){
                        greedyMap.put(i,j.get(iterator));
                        remove_proj.add(j.get(iterator));
                        break;
                    }
                    if(ok==0){
                        iterator++;
                        ok=1;
                    }
                }
            }
        }
    }
}

