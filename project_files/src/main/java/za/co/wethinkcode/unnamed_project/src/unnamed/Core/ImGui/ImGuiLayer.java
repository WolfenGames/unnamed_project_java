package za.co.wethinkcode.unnamed_project.src.unnamed.Core.ImGui;

import imgui.ImGui;
import imgui.ImGuiIO;
import imgui.ImGuiStyle;
import imgui.ImVec2;
import imgui.flag.ImGuiCol;
import imgui.flag.ImGuiConfigFlags;
import imgui.gl3.ImGuiImplGl3;
import imgui.glfw.ImGuiImplGlfw;
import za.co.wethinkcode.unnamed_project.src.unnamed.Core.Application.Application;
import za.co.wethinkcode.unnamed_project.src.unnamed.Core.Layer.Layer;

import static imgui.ImGui.*;
import static org.lwjgl.glfw.GLFW.glfwGetCurrentContext;
import static org.lwjgl.glfw.GLFW.glfwMakeContextCurrent;

public class ImGuiLayer implements Layer {
    ImGuiImplGlfw implGFLW;
    ImGuiImplGl3 implGl3;

    String m_DebugName;

    boolean m_BlockEvents = true;
    public final ExampleUi exampleUi = new ExampleUi();

    public ImGuiLayer()
    {
        implGFLW = new ImGuiImplGlfw();
        implGl3 = new ImGuiImplGl3();

        SetName("ImGuiLayer");
    }

    @Override
    public void OnAttach() {
        createContext();

        final ImGuiIO io = getIO();

        io.setIniFilename(null); // We don't want to save .ini file
        io.addConfigFlags(ImGuiConfigFlags.NavEnableKeyboard);  // Enable Keyboard Controls
        io.addConfigFlags(ImGuiConfigFlags.DockingEnable);      // Enable Docking
        io.addConfigFlags(ImGuiConfigFlags.ViewportsEnable);    // Enable Multi-Viewport / Platform Windows
        io.setConfigViewportsNoTaskBarIcon(true);
        io.setDisplaySize(Application.get_Instance().GetWindow().GetWidth(), Application.get_Instance().GetWindow().GetHeight());

        if (io.hasConfigFlags(ImGuiConfigFlags.ViewportsEnable)) {
            final ImGuiStyle style = getStyle();
            style.setWindowRounding(0.0f);
            style.setColor(ImGuiCol.WindowBg, getColorU32(ImGuiCol.WindowBg, 1));
        }

        long Window = Application.get_Instance().GetWindow().GetNativeWindow();

        implGFLW.init(Window, true);
        implGl3.init("#version 410");
    }

    @Override
    public void OnDetach() {
        implGl3.dispose();
        implGFLW.dispose();
        destroyContext();
    }

    @Override
    public void OnUpdate() throws Exception {
        newFrame();
        implGFLW.newFrame();

        exampleUi.render();
        render();
    }

    @Override
    public void OnEvent() {

    }

    @Override
    public void ImGuiRender() {

    }

    @Override
    public String GetName() {
        return m_DebugName;
    }

    @Override
    public void SetName(String name) {
        m_DebugName = name;
    }

    public void Begin() {

    }

    public void End() {
        implGl3.renderDrawData(ImGui.getDrawData());

        if (ImGui.getIO().hasConfigFlags(ImGuiConfigFlags.ViewportsEnable)) {
            final long backupWindowPtr = glfwGetCurrentContext();
            ImGui.updatePlatformWindows();
            ImGui.renderPlatformWindowsDefault();
            glfwMakeContextCurrent(backupWindowPtr);
        }
    }

    public void BlockEvents(boolean block) {
        m_BlockEvents = block;
    }
}
