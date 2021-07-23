package dataObjects;

public class newGroupData {
    private final String groupName;
    private final String groupDescription1;
    private final String groupDescription2;

    public newGroupData(String groupName, String groupDescription1, String groupDescription2) {
        this.groupName = groupName;
        this.groupDescription1 = groupDescription1;
        this.groupDescription2 = groupDescription2;
    }

    public String getGroupName() {
        return groupName;
    }

    public String getGroupDescription1() {
        return groupDescription1;
    }

    public String getGroupDescription2() {
        return groupDescription2;
    }
}
