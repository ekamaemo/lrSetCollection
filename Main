import setCollection.SetCollection;

public class Main{
    public static void main(String[] args){
        int[] data = {1, 2, 2, 2, 5, 4};
        SetCollection set = new SetCollection(data, 6);
        set.AddElement(3);
        set.AddElement(2);
        System.out.println(set);
        set.RemoveElement(22);
        set.RemoveElement(4);
        System.out.println(set);
        int[] dataA = {1, 5, 7, 9};
        int[] dataB = {3, 8, 5, 2};
        SetCollection setA = new SetCollection(dataA, 4);
        SetCollection setB = new SetCollection(dataB, 4);
        SetCollection setC = setA.operatorPlus(setB);
        System.out.println(setC);
        System.out.println(setC.GetAddress());
    }
}