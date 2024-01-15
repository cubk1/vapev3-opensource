package gg.vape.utils;

import gg.vape.notification.NotificationManager;

public final class AnimationUtils {
    public static double easing(double now,double target,double speed) {
        return Math.abs(target - now) * speed;
    }

    private static boolean canAnimate;



    public static float animate(float current, float target, float speed) {

        if (NotificationManager.delta <= 50 && !canAnimate) canAnimate = true;
        if (!canAnimate) return current;

        return purse(target, current, (long) NotificationManager.delta, Math.abs(target - current) * speed);
    }

    public static float purse(float target, float current, long delta, float speed) {

        if (delta < 1L) delta = 1L;

        final float difference = current - target;

        final float smoothing = Math.max(speed * (delta / 16F), .15F);

        if (difference > speed)
            current = Math.max(current - smoothing, target);
        else if (difference < -speed)
            current = Math.min(current + smoothing, target);
        else current = target;

        return current;
    }
}
