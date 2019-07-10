package state;

public class NightState implements State{
    private static NightState singleton = new NightState();
    private NightState(){}

    public static NightState getInstance() {
        return singleton;
    }

    @Override
    public void doClock(Context context, int hour) {
        if (hour >= 9 && hour < 17) {
            context.changeState(DayState.getInstance());
        }
    }

    @Override
    public void doUse(Context context) {
        context.callSecurityCenter(
                "Emergency: using bank during nighttime");
    }

    @Override
    public void doAlarm(Context context) {
        context.callSecurityCenter("Alarm triggered (nighttime)");
    }

    @Override
    public void doPhone(Context context) {
        context.recordLog("Voice mail (nighttime)");
    }

    @Override
    public String toString() {
        return "nighttime";
    }
}
