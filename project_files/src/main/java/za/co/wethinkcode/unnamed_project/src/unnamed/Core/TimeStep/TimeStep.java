package za.co.wethinkcode.unnamed_project.src.unnamed.Core.TimeStep;

public class TimeStep {
    float m_Time;

    public TimeStep(float time)
    {
        this.m_Time = time;
    }
    public TimeStep() {
        this.m_Time = 0.0f;
    }

    public float GetSeconds() {
        return m_Time;
    }

    public float GetMilliseconds() {
        return m_Time * 1000.0f;
    }
}
