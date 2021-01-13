package za.co.wethinkcode.unnamed_project.Sandbox;

import za.co.wethinkcode.unnamed_project.src.unnamed.Core.Layer.Layer;

public class ExampleLayer implements Layer {
    String m_DebugName;

    ExampleLayer()
    {
        SetName("Example");
    }

    @Override
    public void OnAttach() {

    }

    @Override
    public void OnDetach() {

    }

    @Override
    public void OnUpdate() {

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

    }
}
