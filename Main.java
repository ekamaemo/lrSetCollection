import setCollection.SetCollection;

public class Main{
    public static void main(String[] args){
        int[] data = {1, 2, 2, 2, 5, 4};
        SetCollection set = new SetCollection(data, 6);
        System.out.print("Множество: ");
        System.out.println(set);
      
        set.AddElement(3);
        set.AddElement(2);
        System.out.print("Множество после добавления 2 и 3: ");
        System.out.println(set);
      
        set.RemoveElement(22);
        set.RemoveElement(4);
        System.out.print("Удаление 22 и 4 из множества: ");
        System.out.println(set);
      
        System.out.printf("Максимальный элемент множества: %d%n", set.FindMax());
        System.out.printf("Минимальный элемент множества: %d%n", set.FindMin());
        System.out.printf("Номер ячейки в памяти с массивом чисел множества: %d%n", set.GetAddress());
      
        System.out.println("Сложение множеств A и B: ");
        int[] dataA = {1, 5, 7, 9};
        int[] dataB = {3, 8, 5, 2};
        SetCollection setA = new SetCollection(dataA, 4);
        SetCollection setB = new SetCollection(dataB, 4);
        System.out.print("Множество A: ");
        System.out.println(setA);
        System.out.print("Множество B: ");
        System.out.println(setB);
      
        System.out.print("Множество C = A + B: ");
        SetCollection setC = setA.operatorPlus(setB);
        System.out.println(setC);
    }
}
