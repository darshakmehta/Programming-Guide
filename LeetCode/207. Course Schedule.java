class Solution { //OO DFS
    
    class Course {
        boolean visited = false;
        boolean tested = false;
        List<Course> pre = new ArrayList<Course>(); //Pre requisite courses
        public void add(Course c) {
            pre.add(c);
        }
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Course[] courses = new Course[numCourses];
        for (int i = 0; i < numCourses; i++) {
            courses[i] = new Course(); //Initialize numCourses Object of Course Class
        }
        for (int i = 0; i < prerequisites.length; i++) {
            courses[prerequisites[i][0]].add(courses[prerequisites[i][1]]); //Add all the pre-requisite courses to individual courses
        }
        for (int i = 0; i < numCourses; i++) {
            if(isCyclic(courses[i])) return false; 
        }
        return true;
    }

    private boolean isCyclic(Course cur) {
        if (cur.tested == true) return false; 
        if (cur.visited == true) return true; //cycle if already visited
        cur.visited = true;
        for (Course c : cur.pre) { //for all prerequisite check for cycle
            if (isCyclic(c)) {
                return true;
            }
        }
        cur.tested = true;
        return false;
    }   
}

public class Solution { //DFS
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(numCourses == 0 || prerequisites == null || prerequisites.length == 0) return true; 
        
        // create the array lists to represent the courses
        List<List<Integer>> courses = new ArrayList<List<Integer>>(numCourses);
        for(int i = 0; i < numCourses; i++) {
            courses.add(new ArrayList<Integer>());
        }
        // create the dependency graph
        for(int i = 0; i < prerequisites.length; i++) {
            courses.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        int[] visited = new int[numCourses]; 
        
        // dfs visit each course
        for(int i = 0; i < numCourses; i++) {
               if (!dfs(i, courses, visited)) return false; 
        }
        
        return true;
    }

    private boolean dfs(int course, List<List<Integer>> courses, int[] visited) {
        
        visited[course] = 1; // mark it being visited
        
        List<Integer> eligibleCourses = courses.get(course); // get its children
        
        // dfs its children
        for(int i = 0; i < eligibleCourses.size(); i++) {
            int eligibleCourse = eligibleCourses.get(i).intValue();
            
            if(visited[eligibleCourse] == 1) return false; // has been visited while visiting its children - cycle !!!!
            if(visited[eligibleCourse]  == 0) { // not visited
               if (!dfs(eligibleCourse, courses, visited)) return false; 
            }
        }
        visited[course] = 2; // mark it done visiting
        return true;
        
    }
}

public class Solution { //BFS
    public boolean canFinish(int numCourses, int[][] prerequisites) { 
        if (numCourses == 0 || prerequisites.length == 0) return true;

        // Convert graph presentation from edges to indegree of adjacent list.
        int indegree[] = new int[numCourses];
        for (int i = 0; i < prerequisites.length; i++) // Indegree - how many prerequisites are needed.
            indegree[prerequisites[i][0]]++;    

        Queue<Integer> queue = new LinkedList<Integer>();
        for (int i = 0; i < numCourses; i++) 
            if (indegree[i] == 0)
                queue.add(i);

        // How many courses don't need prerequisites.
        int canFinishCount = queue.size();  
        while (!queue.isEmpty()) {
            int prerequisite = queue.remove(); // Already finished this prerequisite course.
            for (int i = 0; i < prerequisites.length; i++)  {
                if (prerequisites[i][1] == prerequisite) { 
                    indegree[prerequisites[i][0]]--;
                    if (indegree[prerequisites[i][0]] == 0) {
                        canFinishCount++;
                        queue.add(prerequisites[i][0]);
                    }
                }
            }
        }

        return (canFinishCount == numCourses);    
    }
}