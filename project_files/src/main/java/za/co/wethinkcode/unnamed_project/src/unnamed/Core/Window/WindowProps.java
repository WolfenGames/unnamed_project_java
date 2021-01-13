package za.co.wethinkcode.unnamed_project.src.unnamed.Core.Window;

public class WindowProps {
    String Title;
    long Width, Height;
    public WindowProps(String Title, long Width, long Height) {
        this.Title = Title;
        this.Width = Width;
        this.Height = Height;
    }
    public WindowProps() {
        this.Title = "Unnamed Project";
        this.Width = 1280;
        this.Height = 720;
    }

    public long getWidth() {
        return Width;
    }

    public String getTitle() {
        return Title;
    }

    public long getHeight() {
        return Height;
    }
}
