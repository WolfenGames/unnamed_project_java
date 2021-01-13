package za.co.wethinkcode.unnamed_project.src.unnamed.Events;


public enum EventCategory {
    NONE(-1),
    EventCategoryApplication(0),
    EventCategoryInput(1),
    EventCategoryKeyboard(2),
    EventCategoryMouse(3),
    EventCategoryMouseButton(4)
    ;

    private int numVal;

    EventCategory(int x) {
        this.numVal = 1 << x;
    }
    int GetNumVal() {
        return numVal;
    }
}
