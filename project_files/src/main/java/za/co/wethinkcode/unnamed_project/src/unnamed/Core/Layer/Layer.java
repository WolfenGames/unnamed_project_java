package za.co.wethinkcode.unnamed_project.src.unnamed.Core.Layer;

public interface Layer {

    void OnAttach();
    void OnDetach();
    void OnUpdate() throws Exception;
    void OnEvent();
    void ImGuiRender();

    public String GetName();
    void SetName(String name);
}
