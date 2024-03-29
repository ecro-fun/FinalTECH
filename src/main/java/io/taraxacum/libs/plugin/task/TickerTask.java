package io.taraxacum.libs.plugin.task;

import javax.annotation.Nonnull;

/**
 * @see TaskTicker
 * @author Final_ROOT
 * @since 2.2
 * @version 2
 * @param <T> Target object type
 */
public abstract class TickerTask<T> implements AbstractTask<T> {
    private int time;

    public TickerTask(int time) {
        this.time = time;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public void subTime(int time) {
        this.time -= time;
    }

    public void addTime(int time) {
        this.time += time;
    }

    public abstract String getId();

    public abstract void tick(@Nonnull T t);
}
