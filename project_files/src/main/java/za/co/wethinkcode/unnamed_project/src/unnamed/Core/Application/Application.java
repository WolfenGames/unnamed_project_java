package za.co.wethinkcode.unnamed_project.src.unnamed.Core.Application;

import org.lwjgl.opengl.*;
import static org.lwjgl.opengl.GL11.*;

import za.co.wethinkcode.unnamed_project.src.Platform.Windows.WindowsWindow;
import za.co.wethinkcode.unnamed_project.src.unnamed.Core.Window.Window;
import za.co.wethinkcode.unnamed_project.src.unnamed.Core.Window.WindowProps;

public class Application {
    static Application s_Instance = null;

    Window m_Window = null;
    boolean m_Running = true;

    public Application() {
        if (s_Instance == null)
            s_Instance = this;
        m_Window = new WindowsWindow(new WindowProps());
    }

    public static Application get_Instance() {
        return s_Instance;
    }

    public void Run() {
        GL.createCapabilities();
        while (m_Running)
        {
            glClearColor(1.0f, 0.0f, 1.0f, 1.0f);
            glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
            m_Window.OnUpdate();
        }
    }

    public Boolean OnWindowClose(){
        return true;
    }

    public  Boolean OnWindowResize() {
        return true;
    }

    public void setRunning(boolean b) {
        m_Running = b;
    }
}
