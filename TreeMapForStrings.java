/*
* TreeMapForStrings
* Alex Olson & Kiya Govek
* Dave Musicant, CS 201
* 5 May 2015
*/

import java.util.*;

// This class implements a map as a binary search tree
// Stores keys/value pairs in node objects

public class TreeMapForStrings
{
    private Node root;
     
    public TreeMapForStrings()
    {
        root = null;
    }
    
    private class Node
    {
        private String key;
        private String value;
        private Node left;
        private Node right;
        
        // Node Constructor
        private Node(String inputKey, String inputValue)
        {
            key = inputKey;
            value = inputValue;
            left = null;
            right = null;
        }
    }
  
  
    // Add a key and a value to your tree. If the key is already present in 
    // the tree, replace the old value with the new one.
    
    // starter put method
    public void put(String key, String value)
    {
        root = put(root, key, value);
    }
    
    // recursive put method
    public Node put(Node localRoot, String key, String value)
    {
        if (localRoot == null)
        {
            return new Node(key, value);
        }
        
        // if key of local root is equal to key you're inserting
        else if (key.compareTo(localRoot.key) == 0)
        {
            localRoot.value = value;
            return localRoot;
        }
        
        // if key of local root is greater than the key you're inserting
        else if (key.compareTo(localRoot.key) < 0)
        {
            localRoot.left = put(localRoot.left, key, value);
            return localRoot;
        }
        
        // if key of local root is less than the key you're inserting
        else
        {
            localRoot.right = put(localRoot.right, key, value);
            return localRoot;
        }
         
    }


    // Get the value associated with a particular key. 
    // Get should return null if the word is not in the tree.
    
    // Starter get method
    public String get(String key) 
    {
        return get(root, key);
    }
    
    // Recursive get method
    public String get(Node localRoot, String key)
    {
        if (localRoot == null)
        {
            return null;
        }
        
        // if key of local root is equal to key you're looking for
        else if (key.compareTo(localRoot.key) == 0)
        {
            return localRoot.value;
        }
        
        // if key of local root is greater than the key you're looking for
        else if (key.compareTo(localRoot.key) < 0)
        {
            return get(localRoot.left, key);
        }
        
        // if key of local root is less than the key you're looking for
        else
        {
            return get(localRoot.right, key);
        }
    }
    
    // takes a string prefix, returns list of all keys that start with the prefix
    
    // starter getKeysForPrefix method- this is what user calls
    public ArrayList<String> getKeysForPrefix(String prefix)
    {
        return getKeysForPrefix(prefix, root);
    }
    
    // intermediate getKeysForPrefix method
    // recursively locates first node whose key has prefix
    public ArrayList<String> getKeysForPrefix(String prefix, Node localRoot)
    {   
        // if tree map is empty
        if (localRoot == null)
        {
            return null;
        }
        else
        {
            
            String subKey = "";
            
            // We will compare subKey to prefix
            if (localRoot.key.length() > prefix.length())
            {
                subKey = localRoot.key.substring(0, prefix.length());
            }
            else
            {
                subKey = localRoot.key;
            }
            
            ArrayList<String> starterKeyList = new ArrayList<String>();
            
            // if local root has the prefix
            if (subKey.compareTo(prefix) == 0)
            {
                return getKeysForPrefix(prefix, localRoot, starterKeyList);
            }
            
            // if the key of local root is greater than the prefix
            else if (subKey.compareTo(prefix) > 0)
            {
                return getKeysForPrefix(prefix, localRoot.left);
            }
            
            // if the key of local root is less than the prefix
            else
            {
                return getKeysForPrefix(prefix, localRoot.right);
            }
        } 
    }
    
    // final getKeysForPrefix method
    // assumes called at first occurance of key with prefix
    // goes through children, adding keys that contain prefix to a list
    public ArrayList<String> getKeysForPrefix(String prefix, Node localRoot, ArrayList<String> keyList )
    {
        // if the end of the tree is reached, return empty list
        if (localRoot == null)
        {
            return new ArrayList<String>();
        }
        
        else
        {
            String subKey = "";
            if (localRoot.key.length() > prefix.length())
            {
                subKey = localRoot.key.substring(0, prefix.length());
            }
            else
            {
                subKey = localRoot.key;
            }
            
            // if node reached where key doesn't have prefix, return empty list
            // but also search children
            // if subKey is less than prefix, search left
            if (subKey.compareTo(prefix) > 0)
            {   
                getKeysForPrefix(prefix, localRoot.left, keyList);
                return new ArrayList<String>();
            }
            // if subKey is greater than prefix, search right
            else if (subKey.compareTo(prefix) < 0)
            {
                getKeysForPrefix(prefix, localRoot.right, keyList);
                return new ArrayList<String>();
            }
            
            // if key has prefix, adds key to keyList 
            // recursively calls getKeysForPrefix on Left and Right children
            else
            {
                getKeysForPrefix(prefix, localRoot.left, keyList);
                keyList.add(localRoot.key);
                getKeysForPrefix(prefix, localRoot.right, keyList);
                return keyList;
            }
        }
    
    }

    // Main method tests TreeMapForStrings class with a small data set
    public static void main(String[] args)
    {
        TreeMapForStrings BST = new TreeMapForStrings();
        
        BST.put("k", "Kiya");
        BST.put("z", "Zarg");
        BST.put("y", "Yahhoo");
        BST.put("j", "Jim");
        BST.put("a", "Alex");
        BST.put("f", "Fish");
        BST.put("b", "Billy");
        BST.put("bo", "Bob");
        BST.put("ba", "Baby");
        BST.put("bob", "Bobby");
        BST.put("bor", "Bore");
        BST.put("bop", "Bopit");

        BST.put("price", "p");
        BST.put("prince", "p");
        BST.put("pay", "p");
        BST.put("pride", "p");
        BST.put("pray", "p");
        BST.put("pria", "p");
        
        // creates array of keys with prefix "bo" and prints them in the terminal
        ArrayList<String> listOfKeys = BST.getKeysForPrefix("bo");
        
        System.out.println("");
        
        if (listOfKeys != null)
        {
            System.out.println("The keys with the prefix 'bo' are:");
            for (String key : listOfKeys)
            {
                System.out.println(key);
            }
        }
        
        else
        {
            System.out.println("There are no movies with this prefix  :( ");
        }
        
        System.out.println("");
        
        // creates array of keys with prefix "pri" and prints them in the terminal
        ArrayList<String> listOfKeys2 = BST.getKeysForPrefix("pri");
        if (listOfKeys2 != null)
        {
            System.out.println("The keys with the prefix 'pri' are:");
            for (String key : listOfKeys2)
            {
                System.out.println(key);
            }
        }
        
        else
        {
            System.out.println("There are no movies with this prefix  :( ");
        }
        
        System.out.println("");
        
    }
}
