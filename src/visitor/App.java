package visitor;

public class App {
    public static void main(String[] args) {
        System.out.println("Making root entries...");
        Directory root = new Directory("root");
        Directory bin = new Directory("bin");
        Directory tmp = new Directory("tmp");
        Directory usr = new Directory("usr");

        root.add(bin);
        root.add(tmp);
        root.add(usr);

        bin.add(new File("gcc", 123456));
        bin.add(new File("bison", 45645));

        root.accept(new ListVisitor());

        System.out.print(System.lineSeparator());
        System.out.println("Making usr entries...");
        Directory dio = new Directory("dio");
        Directory jotaro = new Directory("jotaro");
        Directory kakyoin = new Directory("kakyoin");
        usr.add(dio);
        usr.add(jotaro);
        usr.add(kakyoin);
        dio.add(new File("THE WORLD.txt", 11111));
        jotaro.add(new File("Star platinum", 123123));
        kakyoin.add(new File("Hierophant green", 53345));

        root.accept(new ListVisitor());
    }
}
