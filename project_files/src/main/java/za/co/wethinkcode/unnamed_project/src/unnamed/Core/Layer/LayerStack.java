package za.co.wethinkcode.unnamed_project.src.unnamed.Core.Layer;

import java.util.Vector;

public class LayerStack {
    Vector<Layer> m_Layers;
    long m_LayerInsertIndex = 0;

    public void PushLayer(Layer layer) {
        m_Layers.add((int) m_LayerInsertIndex, layer);
        m_LayerInsertIndex++;
    }

    public void PopLayer(Layer layer) {
        if (m_Layers.contains(layer))
        {
            layer.OnDetach();
            m_Layers.remove(layer);
            m_LayerInsertIndex--;
        }
    }
    public void PushOverlay(Layer overlay) {
        m_Layers.add(m_Layers.size(), overlay);
    }

    public void PopOverlay(Layer overlay) {
        if(m_Layers.contains(overlay))
        {
            overlay.OnDetach();
            m_Layers.remove(overlay);
        }
    }
}
