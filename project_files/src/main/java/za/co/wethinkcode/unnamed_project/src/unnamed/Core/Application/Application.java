package za.co.wethinkcode.unnamed_project.src.unnamed.Core.Application;

import org.lwjgl.opengl.*;
import static org.lwjgl.opengl.GL11.*;

import za.co.wethinkcode.unnamed_project.src.Platform.Windows.WindowsWindow;
import za.co.wethinkcode.unnamed_project.src.unnamed.Core.ImGui.ImGuiLayer;
import za.co.wethinkcode.unnamed_project.src.unnamed.Core.Layer.Layer;
import za.co.wethinkcode.unnamed_project.src.unnamed.Core.Layer.LayerStack;
import za.co.wethinkcode.unnamed_project.src.unnamed.Core.Window.Window;
import za.co.wethinkcode.unnamed_project.src.unnamed.Core.Window.WindowProps;

import java.util.Iterator;

public class Application {
    static Application s_Instance = null;
    LayerStack m_LayerStack;

    Window m_Window = null;
    boolean m_Running = true;

    ImGuiLayer m_ImGuiLayer;

    public Application() {
        if (s_Instance == null)
            s_Instance = this;
        m_LayerStack = new LayerStack();
        m_Window = new WindowsWindow(new WindowProps());
        m_ImGuiLayer = new ImGuiLayer();
        PushOverlay(m_ImGuiLayer);
    }

    public void PushLayer(Layer layer) {
        m_LayerStack.PushLayer(layer);
        layer.OnAttach();
    }

    public void PushOverlay(Layer overlay)
    {
        m_LayerStack.PushOverlay(overlay);
        overlay.OnAttach();
    }

    public static Application get_Instance() {
        return s_Instance;
    }

    public void Run() throws Exception {
        while (m_Running)
        {
            glClearColor(1.0f, 0.0f, 1.0f, 1.0f);
            glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);

            for (Iterator it = m_LayerStack.Iterator(); it.hasNext(); ) {
                Layer l = (Layer) it.next();
                l.OnUpdate();
            }

            m_ImGuiLayer.Begin();
            for (Iterator it = m_LayerStack.Iterator(); it.hasNext(); ) {
                Layer l = (Layer) it.next();
                l.ImGuiRender();
            }
            m_ImGuiLayer.End();

            m_Window.OnUpdate();
        }
    }

    public Window GetWindow() {
        return m_Window;
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
