Object element = it.next();
if((element instanceof Integer)) { //Hints: use instanceof operator
 continue;
} else if(element instanceof String) {
 if(!((String) element == "###")) {
     System.out.println(element.toString());
 }
}