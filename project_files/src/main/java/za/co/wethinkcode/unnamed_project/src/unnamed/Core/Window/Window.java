package za.co.wethinkcode.unnamed_project.src.unnamed.Core.Window;

public interface Window {
    void    OnUpdate();
    long    GetWidth();
    long    GetHeight();
    void    SetEventCallback();
    void    SetVsync(boolean vsync);
    boolean IsVsync();

    long GetNativeWindow();

    default Window CreateWindow(WindowProps props) {
        return null;
    }
}

