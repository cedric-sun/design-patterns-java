package mediator;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginFrame extends Frame
        implements ActionListener, Mediator {
    private ColleagueCheckbox checkGuest;
    private ColleagueCheckbox checkLogin;

    private ColleagueTextField textUser;
    private ColleagueTextField textPass;

    private ColleagueButton btnOK;
    private ColleagueButton btnCancel;

    public LoginFrame(String title) throws HeadlessException {
        super(title);
        setBackground(Color.lightGray);
        setLayout(new GridLayout(4, 2));

        createColleagues();

        add(checkGuest);
        add(checkLogin);

        add(new Label("Username:"));
        add(textUser);

        add(new Label("Password:"));
        add(textPass);

        add(btnOK);
        add(btnCancel);

        colleagueChanged();
        pack();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void createColleagues() {
        CheckboxGroup g = new CheckboxGroup();
        checkGuest = new ColleagueCheckbox("Guest", g, true);
        checkLogin = new ColleagueCheckbox("Login", g, false);
        textUser = new ColleagueTextField("", 10);
        textPass = new ColleagueTextField("", 10);
        textUser.setEchoChar('*');
        btnOK = new ColleagueButton("OK");
        btnCancel = new ColleagueButton("Cancel");

        checkGuest.setMediator(this);
        checkLogin.setMediator(this);
        textUser.setMediator(this);
        textPass.setMediator(this);
        btnOK.setMediator(this);
        btnCancel.setMediator(this);

        checkGuest.addItemListener(checkGuest);
        checkLogin.addItemListener(checkLogin);
        textUser.addTextListener(textUser);
        textPass.addTextListener(textPass);
        btnOK.addActionListener(this);
        btnCancel.addActionListener(this);
    }

    @Override
    public void colleagueChanged() {
        if (checkGuest.getState()) {
            textUser.setColleagueEnabled(false);
            textPass.setColleagueEnabled(false);
            btnOK.setColleagueEnabled(true);
        } else {
            textUser.setColleagueEnabled(true);
            userpassChanged();
        }
    }

    private void userpassChanged() {
        if (textUser.getText().length() > 0) {
            textPass.setColleagueEnabled(true);
            if (textPass.getText().length() > 0) {
                btnOK.setColleagueEnabled(true);
            } else {
                btnOK.setColleagueEnabled(false);
            }
        } else {
            textPass.setColleagueEnabled(false);
            btnOK.setColleagueEnabled(false);
        }
    }
}
