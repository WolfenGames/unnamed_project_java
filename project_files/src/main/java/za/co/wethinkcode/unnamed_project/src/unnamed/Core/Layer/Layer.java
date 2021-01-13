package za.co.wethinkcode.unnamed_project.src.unnamed.Core.Layer;

public interface Layer {
    public String m_DebugName = null;

    void OnAttach();
    void OnDetach();
    void OnUpdate();
    void OnEvent();

    public default String GetName() {
        return m_DebugName;
    }
}
