package state;

import java.awt.*;

public class SafeFrame extends Frame implements Context {
    private TextField textClock = new TextField(60);
    private TextArea textScreen = new TextArea(10, 60);
    private Button btnUse = new Button("Use bank");
    private Button btnAlarm = new Button("Trigger alarm");
    private Button btnCall = new Button("Phone call");
    private Button btnExit = new Button("Exit");

    private State state = DayState.getInstance();

    public SafeFrame(String title) throws HeadlessException {
        super(title);
        setBackground(Color.lightGray);
        setLayout(new BorderLayout());

        add(textClock, BorderLayout.NORTH);
        textClock.setEditable(false);

        add(textScreen, BorderLayout.CENTER);
        textScreen.setEditable(false);

        Panel panel = new Panel();
        panel.add(btnUse);
        panel.add(btnAlarm);
        panel.add(btnCall);
        panel.add(btnExit);
        add(panel, BorderLayout.SOUTH);

        pack();

        btnUse.addActionListener(e -> state.doUse(this));
        btnAlarm.addActionListener(e -> state.doAlarm(this));
        btnCall.addActionListener(e -> state.doPhone(this));
        btnExit.addActionListener(e -> System.exit(0));
    }

    @Override
    public void setClock(int hour) {
        String clkStr = String.format(
                "Current time: %02d:00", hour
        );
        System.out.println(clkStr);
        textClock.setText(clkStr);
        state.doClock(this, hour);
    }

    @Override
    public void changeState(State state) {
        System.out.println(String.format(
                "State Changed: from %s to %s",
                this.state, state
        ));
        this.state = state;
    }

    @Override
    public void callSecurityCenter(String msg) {
        textScreen.append(String.format(
                "Incoming call: %s\n", msg
        ));
    }

    @Override
    public void recordLog(String msg) {
        textScreen.append(String.format(
                "Recording ... %s\n", msg
        ));
    }
}
