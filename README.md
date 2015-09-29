# CS201_TreeMapForStrings

by Alex Olson and Kiya Govek, May 2015

The goal of this assignment was to create a map implemented as a Binary Search Tree that could be used to construct a rudimentary search engine. Specifically, we could load up all of the titles and plots from the Internet Movie Database (IMDB) into the map, and then allow the user to request titles and plots for all movies that start with a particular prefix. The file TreeMapForStrings.java tests the map with a small data set. 

We first created a class called TreeMapForStrings that maps Strings to Strings, and implemented this map as a binary search tree. For this assignment we did not use the built-in Java classes that do this task such as TreeMap, HashMap, TreeSet, or HashSet. Instead we created the following methods:

void put(String key, String value): add a key and a value to your tree. If the key is already present in the tree, replace the old value with the new one.

String get(String key): get the value associated with a particular key. get returns null if the word is not in the tree.

ArrayList<String> getKeysForPrefix(String prefix): return a list of all keys that start with the prefix. This is done efficiently (i.e. the entire tree is not traversed in order to find these keys).

Note: Like with all pair programming assignments, we programmed side by side and each contributed eqully to the project. 
