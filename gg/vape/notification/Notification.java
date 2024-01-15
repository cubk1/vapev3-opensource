package gg.vape.notification;

import gg.vape.utils.TimerUtil;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScaledResolution;

public final class Notification {
    private final String title;
    private final String message;
    private final NotificationType type;
    private final long time;

    public boolean canRemove = false;
    public boolean setY = false;

    public double animationX = new ScaledResolution(Minecraft.getMinecraft()).getScaledWidth();
    public double animationY;

    public final TimerUtil timerUtil = new TimerUtil();

    public Notification(String title, String message, NotificationType type, long time) {
        this.title = title;
        this.message = message;
        this.type = type;
        this.time = time;
        timerUtil.reset();
    }

    public String getTitle() {
        return title;
    }

    public String getMessage() {
        return message;
    }

    public NotificationType getType() {
        return type;
    }

    public long getTime() {
        return time;
    }

    public enum NotificationType {
        INFO,
        WARNING,
        ERROR,
        SUCCESS
    }
}
