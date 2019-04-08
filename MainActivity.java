public class MainActivity extends AppCompatActivity {
  
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
  }

  public void shallowCopyOfAnArray() {
      List<String> list1 = new ArrayList<>();
      list1.add("item1");
      list1.add("item2");
      /* clone: Returns a shallow copy of this ArrayList instance. */
      List<String> list2 = ((ArrayList<String>)list1.clone());
      list2.add("item3");
      list1.size(); // list1 has 2 items
      /** 
        * list2 has 3 items.
        * if list 2 has modified it does not mean list1 also has to be modified.
        */
      list2.size();
  }

  public void listIteratorExample() {
    List<String> list1 = new ArrayList<>();
    list1.add("item1");
    list1.add("item2");
    list1.add("item3");
    ListIterator listIterator = list1.listIterator();
    listIterator.next(); // item1
    listIterator.next(); // item2
    listIterator.next(); // item3
    listIterator.next(); // this should produce an error as list has only 3 items.

    List<ExampleModel> list1 = new ArrayList<>();
    ExampleModel exampleModel = new ExampleModel();
    list1.add(exampleModel);
    ListIterator listIterator = list1.listIterator();
    /* Pojos are to be casted before use */
    String name = ((ExampleModel)listIterator.next()).getName();
  }

  public void removeIfExample() {
    List<ExampleModel> list1 = new ArrayList<>();
    ExampleModel exampleModel = new ExampleModel();
    exampleModel.setName("item1");
    list1.add(exampleModel);

    ExampleModel exampleModel1 = new ExampleModel();
    exampleModel1.setName("item2");
    list1.add(exampleModel1);

    list1.removeIf(new Predicate<ExampleModel>() {
        @Override
        public boolean test(ExampleModel exampleModel) {
            /**
             * Remove object from the list if returns true;
             */
            if(exampleModel.getName().contains("2")) {
              return true;
            }
            return false;
        }
    });
  }

  public void replaceAllExample() {
    List<ExampleModel> list1 = new ArrayList<>();
    ExampleModel exampleModel = new ExampleModel();
    ExampleModel.setName("item1");
    list1.add(exampleModel);

    ExampleModel exampleModel1 = new ExampleModel();
    exampleModel1.setName("item2");
    list1.add(exampleModel1);

    /**
     * Replace item(s) conditionally.
     */
    list1.replaceAll(new UnaryOperator<ExampleModel>() {
        @Override
        public ExampleModel apply(ExampleModel exampleModel) {
            if(exampleModel.getName().contains("2"))
                exampleModel.setName("item3");
            return exampleModel;
        }
    });
  }

  public void sortExample() {
    List<ExampleModel> list1 = new ArrayList<>();
    ExampleModel exampleModel = new ExampleModel();
    ExampleModel.setName("item1");
    list1.add(exampleModel);

    ExampleModel exampleModel1 = new ExampleModel();
    exampleModel1.setName("item2");
    list1.add(exampleModel1);

    Comparator<ExampleModel> comparator = (t1, t2) -> {
       // TODO: You can sort item using 1, 0, -1
       return t1.getName().compareTo(t2.getName());
    };

    /** These are the two ways for sorting */
    Collections.sort(list1, comparator);
    list1.sort(comparator);
  }

  public void disjointExample() {
    List<ExampleModel> list1 = new ArrayList<>();
    ExampleModel exampleModel = new ExampleModel();
    exampleModel.setName("edf");
    ExampleModel exampleModel1 = new ExampleModel();
    exampleModel1.setName("abc");

    /* Adds all of the specified elements to the specified collection. */
    Collections.addAll(list1, exampleModel, exampleModel1);

    List<ExampleModel> list2 = new ArrayList<>();
  
    /* Returns true if the two specified collections have no elements in common. */
    Collections.disjoint(list2, list1);
  }
}
