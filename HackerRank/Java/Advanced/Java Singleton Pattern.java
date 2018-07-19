import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.lang.reflect.*;

//Double-checked locking

class Singleton{
    public String str;
    private static Singleton instance;
    private Singleton() {
    }
    
    public static Singleton getSingleInstance() {
        if(instance == null) {
            synchronized(Singleton.class) { //Double check locking
                if(instance == null)
                    instance = new Singleton();
            }
        }
        return instance;
    }
}

//Eager Initialization

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.lang.reflect.*;


class Singleton{
    public String str;
    private static Singleton instance = new Singleton();
    private Singleton() {
    }
    
    public static Singleton getSingleInstance() {
        return instance;
    }
}

//Lazy initialization

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.lang.reflect.*;


class Singleton{
    public String str;
    private static Singleton instance;
    private Singleton() {
    }
    
    public static Singleton getSingleInstance() {
        if(instance == null)
            instance = new Singleton();
        
        return instance;
    }
}


/***

Reference: https://cs.nyu.edu/courses/fall16/CSCI-UA.0470-001/slides/lecture25.pdf#page=52]

***/