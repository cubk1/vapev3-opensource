package gg.vape.notification;

import gg.vape.utils.AnimationUtils;
import gg.vape.utils.render.RenderUtils;
import gg.vape.wrapper.impl.ScaledResolution;
import pub.nextsense.Tweaker;

import java.util.concurrent.CopyOnWriteArrayList;

public final class NotificationManager {
    public static NotificationManager Instance = new NotificationManager();
    private final CopyOnWriteArrayList<Notification> notifications = new CopyOnWriteArrayList<>();

    public void draw(ScaledResolution scaledResolution) {
        float notificationY = scaledResolution.getScaledHeight() - 60;
        for (Notification notification : notifications) {
            final double secondDouble = (notification.timerUtil.getLastMS() / 1000.0) - (notification.getTime() / 1000.0);
            String second = (String.valueOf((String.format("%." + 1 + "f", secondDouble))));
            final double notificationWidth = scaledResolution.getScaledWidth() - Tweaker.default18.getStringWidth(notification.getMessage());

            try {
                second = second.split("-")[1];
            } catch (Exception ignored) { }

            if (!notification.setY) {
                notification.animationY = notificationY;
                notification.setY = true;
            }

            if (notification.canRemove) {
                notification.animationX = getAnimationState(notification.animationX,scaledResolution.getScaledWidth() + 30.0,notification.animationX > scaledResolution.getScaledWidth() + 2 ? 200 : AnimationUtils.easing(notification.animationX,scaledResolution.getScaledWidth() + 30,5));//notificationWidth / 3.0f
                if (notification.animationX >= scaledResolution.getScaledWidth() + 30.0) {
                    notifications.remove(notification);
                }
            } else {
                notification.animationX = getAnimationStateEasing(notification.animationX,notificationWidth,8);
            }

            if (notification.timerUtil.hasTimeElapsed(notification.getTime())) {
                notification.canRemove = true;
                notification.timerUtil.reset();
            } else {
                notification.animationY = getAnimationState(notification.animationY,notificationY, Math.max(10,AnimationUtils.easing(notification.animationY,notificationY,8)));//240
            }

            final double timeX = (scaledResolution.getScaledWidth() - notification.animationX + 22) * ((notification.getTime() - notification.timerUtil.getLastMS()) / (double)notification.getTime());
            RenderUtils.drawRect(notification.animationX - 22.0,notification.animationY,scaledResolution.getScaledWidth(),notification.animationY + 20.0,getRGB(0,0,0,50));
            if (!notification.canRemove) {
                RenderUtils.drawRect(notification.animationX - 22.0, notification.animationY + 19, scaledResolution.getScaledWidth() - timeX, notification.animationY + 20.0,-1);
            }
            Tweaker.default18.drawStringWithShadow(notification.getTitle(),notification.animationX - 20,notification.animationY + 1,getRGB(251,251,251));
            Tweaker.default18.drawStringWithShadow(notification.getMessage(),notification.animationX - 20,notification.animationY + 10,getRGB(184,184,184));
            notificationY -= 32;
        }
    }

    public static int getRGB(int r, int g, int b) {
        return getRGB(r,g,b,255);
    }

    @SuppressWarnings("PointlessBitwiseExpression")
    public static int getRGB(int r, int g, int b, int a) {
        return ((a & 0xFF) << 24) |
                ((r & 0xFF) << 16) |
                ((g & 0xFF) << 8)  |
                ((b & 0xFF) << 0);
    }

    public static double delta;

    public static double getAnimationState(double animation, double finalState, double speed) {
        double add = delta * speed;
        animation = animation < finalState ? (Math.min(animation + add, finalState)) : (Math.max(animation - add, finalState));
        return animation;
    }

    public static double getAnimationStateEasing(double animation, double finalState,double speed) {
        double add = delta * AnimationUtils.easing(animation,finalState,speed);
        animation = animation < finalState ? (Math.min(animation + add, finalState)) : (Math.max(animation - add, finalState));
        return animation;
    }

    public void addNotification(Notification notification) {
        notifications.add(notification);
    }

    public void addNotification(String title, String message, Notification.NotificationType type, long time) {
        notifications.add(new Notification(title, message, type, time));
    }
}
