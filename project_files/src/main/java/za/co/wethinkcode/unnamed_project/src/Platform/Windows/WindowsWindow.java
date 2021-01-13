package za.co.wethinkcode.unnamed_project.src.Platform.Windows;

import org.lwjgl.opengl.GL;
import za.co.wethinkcode.unnamed_project.src.unnamed.Core.Application.Application;
import za.co.wethinkcode.unnamed_project.src.unnamed.Core.Window.Window;
import za.co.wethinkcode.unnamed_project.src.unnamed.Core.Window.WindowProps;

import org.lwjgl.*;
import org.lwjgl.glfw.*;
import org.lwjgl.system.*;

import java.nio.*;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.system.MemoryStack.*;
import static org.lwjgl.system.MemoryUtil.*;


public class WindowsWindow implements Window {
    static boolean s_GLFWInitialized = true;

    private long m_Window;

    private final WindowData m_Data = new WindowData();

    static void GLFWErrorCallback(int e, String error) {

    }

    public WindowsWindow(WindowProps props)
    {
        System.out.println("Hello LWJGL " + Version.getVersion() + "!");
        Init(props);
    }

    Window Create(WindowProps props)
    {
        return new WindowsWindow(props);
    }

    void Init(WindowProps props)
    {
        m_Data.setTitle(props.getTitle());
        m_Data.setHeight(props.getHeight());
        m_Data.setWidth(props.getWidth());

        System.console().printf("Creating a window with %d, %d, %s\n", m_Data.getHeight(), m_Data.getWidth(), m_Data.getTitle());
        GLFWErrorCallback.createPrint(System.err).set();

        if ( !glfwInit() )
            throw new IllegalStateException("Unable to initialize GLFW");

        glfwDefaultWindowHints(); // optional, the current window hints are already the default
        glfwWindowHint(GLFW_VISIBLE, GLFW_FALSE); // the window will stay hidden after creation
        glfwWindowHint(GLFW_RESIZABLE, GLFW_TRUE); // the window will be resizable

        m_Window = glfwCreateWindow((int)props.getWidth(), (int)props.getHeight(), props.getTitle(), NULL, NULL);

        try ( MemoryStack stack = stackPush() ) {
            IntBuffer pWidth = stack.mallocInt(1); // int*
            IntBuffer pHeight = stack.mallocInt(1); // int*

            // Get the window size passed to glfwCreateWindow
            glfwGetWindowSize(m_Window, pWidth, pHeight);

            // Get the resolution of the primary monitor
            GLFWVidMode vidmode = glfwGetVideoMode(glfwGetPrimaryMonitor());

            // Center the window
            glfwSetWindowPos(
                    m_Window,
                    (vidmode.width() - pWidth.get(0)) / 2,
                    (vidmode.height() - pHeight.get(0)) / 2
            );
        } // the stack frame is popped automatically


        glfwMakeContextCurrent(m_Window);

        if (m_Window == NULL) {
            System.console().printf("NO WINDOW");
        }

        glfwShowWindow(m_Window);
        SetVsync(true);

        GL.createCapabilities();

        // TODO: Rework this

        glfwSetKeyCallback(m_Window, (window, key, scan_code, action, mods) -> {
            if (key == GLFW_KEY_ESCAPE && action == GLFW_RELEASE)
                Application.get_Instance().setRunning(false);
        });
    }

    @Override
    public void OnUpdate() {
        glfwPollEvents();
        glfwSwapBuffers(m_Window);/* Seg Fault */
    }

    @Override
    public long GetWidth() {
        return 0;
    }

    @Override
    public long GetHeight() {
        return 0;
    }

    @Override
    public void SetEventCallback() {

    }

    @Override
    public void SetVsync(boolean vsync) {
        if (vsync)
            GLFW.glfwSwapInterval(1);
        else
            GLFW.glfwSwapInterval(0);
        m_Data.setVsync(vsync);
    }

    @Override
    public boolean IsVsync() {
        return m_Data.isVsync();
    }

    @Override
    public long GetNativeWindow() {
        return m_Window;
    }
}
