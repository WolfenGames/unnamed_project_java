package za.co.wethinkcode.unnamed_project.src.Platform.Windows;

public class WindowData {
    String Title;
    long Width, Height;
    boolean Vsync;

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public long getWidth() {
        return Width;
    }

    public void setWidth(long width) {
        Width = width;
    }

    public long getHeight() {
        return Height;
    }

    public void setHeight(long height) {
        Height = height;
    }

    public boolean isVsync() {
        return Vsync;
    }

    public void setVsync(boolean vsync) {
        Vsync = vsync;
    }
}
