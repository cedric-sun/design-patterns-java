package proxy;

public class Printer implements Printable {
    private String name;

    public Printer() {
        heavyJob("Generating Printer instance...");
    }

    public Printer(String name) {
        this.name = name;
        heavyJob(String.format(
                "Generating Printer instance (%s)...", name
        ));
    }

    private void heavyJob(String msg) {
        System.out.println(msg);
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new Error(e);
            }
            System.out.print('.');
        }
        System.out.println("done");
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void print(String string) {
        System.out.println(String.format("===%s===", name));
        System.out.println(string);
    }
}
