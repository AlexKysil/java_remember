package dataObjects;

import java.util.Objects;

public class newGroupData {
    private  String groupName;
    private  String groupDescription1;
    private  String groupDescription2;
    private  String id;

    public String getId() {
        return id;
    }

    public newGroupData(String groupName, String groupDescription1, String groupDescription2) {
        this.id = null;
        this.groupName = groupName;
        this.groupDescription1 = groupDescription1;
        this.groupDescription2 = groupDescription2;
    }

    public newGroupData(String id, String groupName, String groupDescription1, String groupDescription2) {
        this.id = id;
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

    @Override
    public String toString() {
        return "newGroupData{" +
                "groupName='" + groupName + '\'' +
                ", id='" + id + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        newGroupData that = (newGroupData) o;
        return groupName.equals(that.groupName);
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(groupName);
    }
}
