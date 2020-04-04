package com.codecool.dynamicArrayDojo;

import java.util.Arrays;

// put your code here!
public class DynamicIntArray {

    private int[] currentArray = new int[0];

    DynamicIntArray(){}

    DynamicIntArray(int size){
        currentArray = new int[size];
    }

    /**
     * Add new element to array
     *
     * Store the current array in a new temp array with size great than current array + 1
     * Add element to temp array and assign the entire temp array to current array after adding required element
     * @param element to add
     */
    public void add(int element){
        int[] tempArray = new int[currentArray.length + 1];
        System.arraycopy(currentArray, 0, tempArray, 0, currentArray.length);
        tempArray[currentArray.length] = element;
        currentArray = tempArray;
    }

    /**
     * Remove element from array
     *
     * Remove element in array when is found and throw an exception when you want to remove an element that doesn't
     * exist in current array
     * @param element you want remove from array
     */
    public void remove(int element){
        try {
            int[] tempArray = new int[currentArray.length - 1];
            int counter = 0;
            for(int i = 0; i < currentArray.length;i++){
                if(i != element){
                    tempArray[counter] = currentArray[i];
                    counter++;
                }
            }
            currentArray = tempArray;

        } catch (Exception e) {
            throw new ArrayIndexOutOfBoundsException();
        }

    }

    /**
     * Add element to position
     *
     * When position is greater than the entire array length add element to the end of array.
     * Add elements in tempArray while position is not equal to i, if is equal continue to add elements to tempArray
     * on i position + 1
     *
     * @param position where you want to insert element
     * @param element to be inserted
     */
    public void insert(int position, int element){
        int[] tempArray = new int[currentArray.length + 1];
        boolean changePosition = false;
        for(int i = 0; i < currentArray.length;i++){
            if(position > currentArray.length){
                tempArray[tempArray.length - 1] = element;
            }
            if(i != position) {
                if (changePosition) {
                    tempArray[i + 1] = currentArray[i];
                } else {
                    tempArray[i] = currentArray[i];
                }
            }
            else {
               tempArray[i + 1] = currentArray[i];
               tempArray[i] = element;
               changePosition = true;
           }
        }
        currentArray = tempArray;
    }

    @Override
    public String toString() {
        String[] stringArray = new String[currentArray.length];
        for(int i = 0; i < currentArray.length;i++){
            stringArray[i] = String.valueOf(currentArray[i]);
        }
        return " " + String.join(" ", stringArray);
    }
}
